package com.sc.amazonviewer.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

import com.sc.amazonviewer.db.IDBConnection;
import com.sc.amazonviewer.model.Movie;
import static com.sc.amazonviewer.db.DataBase.*;

public interface MovieDao extends IDBConnection{
	
	default Movie setMovieViewed(Movie movie) {
		return movie;
	}

	default ArrayList<Movie> read(){
		ArrayList <Movie> movies = new ArrayList<Movie>();
		try (Connection connection = connectToDB()){
			String sql = "SELECT * FROM "+TMOVIE;
			PreparedStatement preparedStatement = connection.prepareStatement(sql); 
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				Movie movie = new Movie(
						Integer.valueOf(rs.getString(TMOVIE_ID)),
						rs.getString(TMOVIE_TITLE), 
						rs.getString(TMOVIE_GENRE), 
						rs.getString(TMOVIE_CREATOR), 
						Integer.valueOf(rs.getString(TMOVIE_DURATION)),
						Short.valueOf(rs.getString(TMOVIE_YEAR)));
				movie.setViewed(getMovieViewed(preparedStatement, connection, Integer.valueOf(rs.getString(TMOVIE_ID))));
				movies.add(movie);
				}
		}catch (SQLException e) {
			// TODO: handle exception
		}
		return movies;
	}
	
	private boolean getMovieViewed(PreparedStatement preparedStatement, Connection connection, int id_movie) {
		boolean viewed = false;
		String sql = "SELECT * FROM "+TVIEWED+
				" WHERE " + TVIEWED_ID_MATERIAL + " =?" +
				" AND "   + TVIEWED_ID_ELEMENT  + " =?" +
				" AND "   + TVIEWED_ID_USER     + " =?";
		ResultSet rs = null;
		try {
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, 1);
			preparedStatement.setInt(2, id_movie);
			preparedStatement.setInt(3, 1);
			
			rs = preparedStatement.executeQuery();
			viewed = rs.next();
			System.out.println("hello here bug=====>>>>  "+viewed);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return viewed;
	}
}

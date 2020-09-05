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
						Integer.valueOf(rs.getString(1)),
						rs.getString(2), 
						rs.getString(3), 
						rs.getString(4), 
						Integer.valueOf(rs.getString(5)),
						Short.valueOf(rs.getString(6)));
				movies.add(movie);
				}
		}catch (SQLException e) {
			// TODO: handle exception
		}
		return movies;
	}
	
	default boolean getMovieViewed() {
		return false;
	}
}

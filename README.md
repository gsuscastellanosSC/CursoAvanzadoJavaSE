# Curso Avanzado de Java SE
https://platzi.com/clases/java-avanzado/
***Calse#33**
    ***Interfaces funcionales***
        Intrefaces con un unico metodo abstracto(Single Abstract Method SAM)
        Se implementan con Clases Anónimas
        Se documenta con @FunctionalInterface
***Clase#34**
    ***Programación Funcional***
        ***Paradigma de Progrmación***
            Programación Funcional  ¿Que hace? => funciones como entrada y salida(Funciones de orden superior)
            Programación Imperativa ¿Cómo hacerlo?
            Programación Declarativa
***Clase#35**
    ***Lambdas***
        Forma de representar código:
            (parámetros) -> {Cuerpo-función lambda}
            @FuncionalInterface
            public interface Greeting{
                public void perform();
            }
            //Tambien se puede usando Clase Anónimas o métodos abstractos
***Clase#36**
    ***Ejercicio. Lambdas***
***Clase#37**
    ***Lambdas como variables y Recursividad***
        ***Lambdas como variables***
            TypeVar nameVar = párametro               -> Cuerpo-función lambda;
            TypeVar nameVar = (párametros, ......, n) -> Cuerpo-función lambda;
        ***Recursividad***
            AtomicInteger atomicInteger = new AtomicInteger(1);
            Object.forEach(m -> System.out.println(atomicInteger.getAndIncrement()+m.getAtributte()));
            * No usa iteraciones *
***Clase#38**
    ***Stream y Filter***
        movies.stream().filter(m -> m.getIsViewed());
***Clase#39**
    ***Predicate y Consumer**
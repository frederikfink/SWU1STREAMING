import model.Movie;

import java.util.ArrayList;
import java.util.List;

public class User {
    private String name;
    private String username;
    private String password;
    private int age;

    private boolean underAge;
    private List<Movie> myList;

    public User(String name, String username, String password, int age){
        this.name = name;
        this.username = username;
        this.password = password;
        this.age = age;

        if(age >= 15){
            this.underAge = false;
        }

        myList = new ArrayList<Movie>();
    }

    public void addMovie(Movie m){
        myList.add(m);
    }

    public void removeMovie(Movie m){
        myList.remove(m);
    }

}

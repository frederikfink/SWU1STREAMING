import model.Movie;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.*;

public class Controller<movies> {
    private ArrayList<Movie> movies;
    private ArrayList<Movie> series;

    public Controller() throws FileNotFoundException {
        movies = new ArrayList<>();
        series = new ArrayList<>();
    }

    public void show() {
        int i = 0;
        for (Movie m : movies) {
            System.out.println("film " + i + " " + m.display());
            i++;
        }
    }

    public void searchMovies(String search) {
        for (Movie m : movies) {
            if (m.getTitle().contains(search)) {
                System.out.println(m.getTitle());
            }
        }
    }

    public void sortMoviesByRating(){
        movies.sort(Comparator.comparingDouble(Movie::getRating));
    }

    public void showRatingCriteria(double rating){
        sortMoviesByRating();
        for(Movie m: movies){
            if(m.getRating() >= rating){
                System.out.println(m.display());
            }
        }
    }

    public void showAllMovies(){
        for(Movie m: movies){
            JLabel movieTitle = new JLabel(m.getTitle());
        }
    }

    public ArrayList<Movie> movies() {
        return movies;
    }
}
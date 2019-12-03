package model;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.nio.Buffer;

public class Movie extends Content implements Comparable< Movie >{
    private int year;

    public Movie(String title, String genre, double rating, BufferedImage cover, int year) {
        super(title, genre, rating, cover);
        this.year = year;
    }


    @Override
    public int compareTo(Movie movie) {

        return Double.compare(this.rating, movie.getRating());
    }
}

package model;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.nio.Buffer;

public class Movie extends Content {
    protected int year;

    public Movie(String title, String genre, double rating, BufferedImage cover, int year) {
        super(title, genre, rating, cover);
        this.year = year;
    }


}

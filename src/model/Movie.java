package model;

import javafx.scene.image.Image;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Comparator;

public class Movie extends Content{
    private int year;

    public Movie(String title, String genre, double rating, Image cover, int year) {
        super(title, genre, rating, cover);
        this.year = year;
    }

    public int getYear() {
        return year;
    }



}

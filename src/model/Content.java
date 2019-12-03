package model;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.nio.Buffer;

public class Content {
    protected String title;
    protected String genre;
    protected double rating;
    protected BufferedImage cover;

    public Content(String title, String genre, double rating, BufferedImage cover){
        this.title = title;
        this.genre = genre;
        this.rating = rating;
        this.cover = cover;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
    public void setRating(double rating) {
        this.rating = rating;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public void setCover(BufferedImage cover) { this.cover = cover; }

    public String getTitle() {
        return title;
    }
    public double getRating() {
        return rating;
    }
    public String getGenre() {
        return genre;
    }
    public BufferedImage getCover() {
        return cover;
    }

    public String display(){
        return title + " " + rating;
    }
}

package model;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Show extends Content {
    private String runtime;
    private String seasons;

    public Show(String title, String genre, double rating, BufferedImage cover, String runtime, String seasons) {
        super(title, genre, rating, cover);
        this.runtime = runtime;
        this.seasons = seasons;
    }


}

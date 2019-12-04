package model;

import javafx.scene.image.Image;
import java.awt.*;
import javafx.scene.image.Image;


public class Show extends Content{
    protected String runtime;
    protected String seasons;

    public Show(String title, String[] genre, double rating, Image cover, String runtime, String seasons) {
        super(title, genre, rating, cover);
        this.runtime = runtime;
        this.seasons = seasons;
    }

}

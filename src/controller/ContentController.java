package controller;

import model.Movie;
import model.Show;
import model.Show;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class ContentController {
    private ArrayList<Movie> movies;
    //serie
    private ArrayList<Show> shows;

    public ContentController(){
        movies = new ArrayList<>();
        shows = new ArrayList<>();
    }

    public void initializeContent() throws IOException {
        Scanner mReader = new Scanner(new File("out/movies/movies_text.txt"));
        mReader.useDelimiter(";");

        while (mReader.hasNext()) {
            String        title  = mReader.next().trim();
            int           year   = Integer.parseInt(mReader.next().trim());
            String        genre  = mReader.next().trim();
            double        rating = Double.parseDouble(mReader.next().trim().replaceAll(",", "."));
            BufferedImage cover  = ImageIO.read(new File("out/movies/" + title + ".jpg"));

            movies.add(new Movie(title, genre, rating, cover, year));
            mReader.nextLine();
        }
        mReader.close();
    }

/*    public void initializeVideo() throws IOException {
        Scanner sReader = new Scanner(new File("out/shows/shows_text.txt"));
        sReader.useDelimiter(";");

        while (sReader.hasNext()) {
            String        title   = sReader.next().trim();
            String        runtime = sReader.next().trim();
            String        genre   = sReader.next().trim();
            double        rating  = Double.parseDouble(sReader.next().trim().replaceAll(",", "."));
            String        seasons = sReader.next().trim();
            BufferedImage cover   = ImageIO.read(new File("out/shows/Angel.jpg"));

            shows.add(new Show(title, genre, rating, cover, runtime, seasons));
            sReader.nextLine();
        }
        sReader.close();
    }*/

    public void display() {
        int i = 0;
        for (Movie m : movies) {
            System.out.println("film " + i + " " + m.display());
            i++;
        }
        i = 0;
        for (Show s: shows){
            System.out.println("Serie " + i + " " + s.display());
            i++;
        }
    }

    public void searchByRating(double sort){
        for(Movie m: movies){
            if(m.getRating() <= sort){
                m.display();
            }
        }
    }
}

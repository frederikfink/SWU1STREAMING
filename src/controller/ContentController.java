package controller;
import javafx.scene.image.Image;
import model.Content;
import model.Movie;
import model.Show;
import model.Show;

import javafx.scene.image.Image;
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;
import java.util.List;
import java.util.regex.Pattern;

public class ContentController {
    private ArrayList<Movie> movies;
    private ArrayList<Show> shows;
    private ArrayList<Content> content;

    public ContentController() {
        content = new ArrayList<>();
    }

    public void initializeContent() throws IOException {

        //movie scanner
        Scanner mReader = new Scanner(new File("out/movies/#movies.txt"));
        mReader.useDelimiter(";");

        while (mReader.hasNext()) {
            String        title  = mReader.next().trim();
            int           year   = Integer.parseInt(mReader.next().trim());
            String        genre  = mReader.next().trim();
            String[] arrOfGenres = genre.split(Pattern.quote(",").trim());
            double        rating = Double.parseDouble(mReader.next().trim().replaceAll(",", "."));
            Image cover   = new Image(new FileInputStream("out/movies/" + title + ".jpg"));


            content.add(new Movie(title, arrOfGenres, rating, cover, year));
            mReader.nextLine();
        }
        mReader.close();

        //shows scanner
        Scanner sReader = new Scanner(new File("out/shows/#shows.txt"));
        sReader.useDelimiter(";");

        while (sReader.hasNext()) {
            String        title   = sReader.next().trim();
            String        runtime = sReader.next().trim();
            String        genre  = sReader.next().trim();
            String[] arrOfGenres = genre.split(Pattern.quote(",").trim());
            double        rating  = Double.parseDouble(sReader.next().trim().replaceAll(",", "."));
            String        seasons = sReader.next().trim();
            Image cover   = new Image(new FileInputStream("out/shows/" + title + ".jpg"));


            content.add(new Show(title, arrOfGenres, rating, cover, runtime, seasons));
            sReader.nextLine();
        }
        sReader.close();
        //shuffles the arraylist so that it doesnt display movies and then series.
        Collections.shuffle(content);
    }

    public ArrayList<Content> getContent() {
        return content;
    }

    public void display() {
        int i = 0;
        for (Content c : content) {
            if (c instanceof Movie) {
                System.out.println("film " + i + " " + c.display());
            } else {
                System.out.println("Serie " + i + " " + c.display());
            }
            i++;
        }
    }

    public ArrayList searchByRating(double sort) {
        ArrayList<Content> sortArray = new ArrayList<>();
        for (Content c : content) {

            if (c.getRating() >= sort) {
                sortArray.add(c);
                if (c instanceof Movie) {
                    System.out.println("film " + c.display());
                } else {
                    System.out.println("Serie " + c.display());
                }
            }
        }
        return sortArray;
    }

    public void search(String sTerm) {
        for (Content c : content) {

            if (c.getTitle().toLowerCase().contains(sTerm.toLowerCase())) {
                if (c instanceof Movie) {
                    System.out.println("film " + c.display());
                } else {
                    System.out.println("Serie " + c.display());
                }
            }

        }

    }

    public ArrayList<Content> getContent() {
        return (ArrayList<Content>) content;
    }
}

package controller;

import model.Content;
import model.Movie;
import model.Show;
import model.Show;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;
import java.util.regex.Pattern;

public class ContentController {
    private ArrayList<Movie> movies;
    private ArrayList<Show> shows;
    private List<Content> content;

    public ContentController() {
        content = new ArrayList<>();
    }

    public void initializeContent() throws IOException {

        //movie scanner
        Scanner mReader = new Scanner(new File("out/movies/movies_text.txt"));
        mReader.useDelimiter(";");

        while (mReader.hasNext()) {
            String        title  = mReader.next().trim();
            int           year   = Integer.parseInt(mReader.next().trim());
            String        genre  = mReader.next().trim();
            String[] arrOfGenres = genre.split(Pattern.quote(",").trim());
            double        rating = Double.parseDouble(mReader.next().trim().replaceAll(",", "."));
            BufferedImage cover  = ImageIO.read(new File("out/movies/" + title + ".jpg"));

            content.add(new Movie(title, arrOfGenres, rating, cover, year));
            mReader.nextLine();
        }
        mReader.close();

        //shows scanner
        Scanner sReader = new Scanner(new File("out/shows/shows_text.txt"));
        sReader.useDelimiter(";");

        while (sReader.hasNext()) {
            String        title   = sReader.next().trim();
            String        runtime = sReader.next().trim();
            String        genre  = sReader.next().trim();
            String[] arrOfGenres = genre.split(Pattern.quote(",").trim());
            double        rating  = Double.parseDouble(sReader.next().trim().replaceAll(",", "."));
            String        seasons = sReader.next().trim();
            BufferedImage cover   = ImageIO.read(new File("out/shows/Angel.jpg"));

            content.add(new Show(title, arrOfGenres, rating, cover, runtime, seasons));
            sReader.nextLine();
        }
        sReader.close();
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

    public void customSort(double sort) {
        Collections.sort(content);
        for (Content c : content) {
            if (c.getRating() >= sort) {
                if (c instanceof Movie) {
                    System.out.println("film " + c.display());
                } else {
                    System.out.println("Serie " + c.display());
                }
            }

        }
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
}

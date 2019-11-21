import java.util.List;
import java.util.ArrayList;
/**
 * A Class to hold a Movie List
 *
 * @author (Mr. Kim)
 * @version (2019-11-16)
 * 
 */
public class MovieListAL {
    private ArrayList<Movie> pool;
    public MovieListAL(Movie[] movies) {
        pool = new ArrayList<Movie>();
        for (Movie m : movies) pool.add(m);
    }
    
    public ArrayList<Movie> getPool() {return pool;}
    
    /**
     * Given an arraylist of Movies and a studio name, create a new ArrayList of movies
     * by that studio
     */
    public ArrayList<Movie> getByStudio(String studio) {
        ArrayList<Movie> movieRes = new ArrayList<Movie>();
        for (Movie m : pool)
        if (m.getStudio().equals(studio)) movieRes.add(m);
        return movieRes;
    }
    
    /** 
     * get the movie with the highest rating within an ArrayList
     */
    public Movie getHighestrating(ArrayList<Movie> movies) {
        if (movies.size() == 0) return null;
        double highestRating = movies.get(0).getRating();
        int highestIndex=0, count=0;
        for (Movie m : movies) {
            double x = m.getRating();
            if (x > highestRating) { highestRating = x; highestIndex = count; count++; }
        }
        return movies.get(highestIndex);
    }
    
    /**
     * Find the highest movies by studio
     */
    public ArrayList<Movie> findHighestRatedByStudio() {
        ArrayList<Movie> highestRated = new ArrayList<Movie>();
        highestRated.add(getHighestrating(getByStudio("Ghibli")));
        highestRated.add(getHighestrating(getByStudio("Disney")));
        highestRated.add(getHighestrating(getByStudio("Indy")));
        highestRated.add(getHighestrating(getByStudio("Toho")));
        highestRated.add(getHighestrating(getByStudio("ops")));
        highestRated.add(getHighestrating(getByStudio("oops")));
        return highestRated;
    }
}
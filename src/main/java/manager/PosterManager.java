package manager;

import ru.netology.repository.Poster;

public class PosterManager {

    private int countMovie = 5;
    private Poster[] movies = new Poster[0];

    public PosterManager(int countMovie) {
        this.countMovie = countMovie;
    }

    public PosterManager() {
    }

    public void add(Poster movie) {
        int length = movies.length + 1;
        Poster[] tmp = new Poster[length];
        System.arraycopy(movies, 0, tmp, 0, movies.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = movie;
        movies = tmp;
    }

    public Poster[] findLastFive() {

        int resultLength = movies.length;
        if (resultLength >= countMovie) {
            resultLength = countMovie;
        } else {
            resultLength = movies.length;
        }
        Poster[] result = new Poster[resultLength];
        for (int i = 0; i < result.length; i++) {
            int index = movies.length - i - 1;
            result[i] = movies[index];
        }
        return result;
    }

    public Poster[] findAll() {

        return movies;
    }

}
package manager;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.repository.Poster;


class PosterManagerTest {

    private final Poster movie1 = new Poster(1, "Бладшот", "боевик");
    private final Poster movie2 = new Poster(2, "Вперёд", "мультфильм");
    private final Poster movie3 = new Poster(3, "Отель 'Белград'", "комедия");
    private final Poster movie4 = new Poster(4, "Джентельмены", "боевик");
    private final Poster movie5 = new Poster(5, "Человек-невидимка", "ужасы");
    private final Poster movie6 = new Poster(6, "Тролли. Мировой тур", "мультфильм");
    private final Poster movie7 = new Poster(7, "Номер один", "комедия");
    private final Poster movie8 = new Poster(8, "Интерстеллар", "фантастика");

    PosterManager movie = new PosterManager();

    @Test
    public void shouldAddMovie() {

        movie.add(movie1);
        movie.add(movie2);

        Poster[] expected = {movie1, movie2};
        Poster[] actual = movie.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldNullMovie() {

        Poster[] expected = {};
        Poster[] actual = movie.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldFindAll() {

        movie.add(movie1);
        movie.add(movie2);
        movie.add(movie3);
        movie.add(movie4);
        movie.add(movie5);
        movie.add(movie6);
        movie.add(movie7);
        movie.add(movie8);

        Poster[] expected = {movie1, movie2, movie3, movie4, movie5, movie6, movie7, movie8};
        Poster[] actual = movie.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldLastOverFive() {

        movie.add(movie1);
        movie.add(movie2);
        movie.add(movie3);
        movie.add(movie4);
        movie.add(movie5);
        movie.add(movie6);
        movie.add(movie7);
        movie.add(movie8);

        Poster[] expected = {movie8, movie7, movie6, movie5, movie4};
        Poster[] actual = movie.findLastFive();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldLastUnderFive() {
        PosterManager movie = new PosterManager(5);

        movie.add(movie1);
        movie.add(movie2);
        movie.add(movie3);
        movie.add(movie4);

        Poster[] expected = {movie4, movie3, movie2, movie1};
        Poster[] actual = movie.findLastFive();
        Assertions.assertArrayEquals(expected, actual);
    }
}
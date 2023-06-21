package hibernate.assignment.three.services;

import hibernate.assignment.three.entity.Movie;

import java.util.List;

public interface MovieService {
    public List<Movie> movieList();

    public String addMovie(Movie movie);

    public String deleteMovie(Movie movie);

    public Movie findMovie(Integer id);
}

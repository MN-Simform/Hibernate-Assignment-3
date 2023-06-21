package hibernate.assignment.three.controller;

import hibernate.assignment.three.dto.MovieDto;
import hibernate.assignment.three.entity.Movie;
import hibernate.assignment.three.services.DirectorService;
import hibernate.assignment.three.services.MovieService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/movies")
public class MovieController {

    @Autowired
    MovieService movieService;

    @Autowired
    DirectorService directorService;

    @Autowired
    ModelMapper modelMapper;

    @RequestMapping("/")
    public List<Movie> movieList(){
        return movieService.movieList();
    }

    @RequestMapping(value = "/add_movie", method = RequestMethod.POST)
    public String addMovie(@RequestBody MovieDto movieDto){
        if(movieDto != null){
            Movie movie = modelMapper.map(movieDto, Movie.class);
            movie.setDirector(directorService.findDirectorId(movieDto.getDirector()));
            return  movieService.addMovie(movie);
        }
        return "Something Went Wrong";
    }

    @RequestMapping(value = "/delete_movie/{id}", method = RequestMethod.DELETE)
    public String deleteMovie(@PathVariable Integer id){
        if(id != null){
            return movieService.deleteMovie(movieService.findMovie(id));
        }
        return "Something Went Wrong";
    }
}

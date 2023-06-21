package hibernate.assignment.three.repository;

import hibernate.assignment.three.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepo extends JpaRepository<Movie, Integer> {
    @Query("Select m from Movie m where m.id=?1")
    public Movie findMovieById(Integer id);
}

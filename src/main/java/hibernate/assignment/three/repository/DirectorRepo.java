package hibernate.assignment.three.repository;

import hibernate.assignment.three.entity.Director;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface DirectorRepo extends JpaRepository<Director, Integer> {
    @Query("Select d from Director d where d.id=?1")
    public Director findDirectorsById(Integer id);
}

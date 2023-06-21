package hibernate.assignment.three.services.impl;

import hibernate.assignment.three.entity.Director;
import hibernate.assignment.three.entity.Movie;
import hibernate.assignment.three.repository.DirectorRepo;
import hibernate.assignment.three.services.DirectorService;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class DirectorServiceImpl implements DirectorService {

    @Autowired
    DirectorRepo directorRepo;

    @Override
    public List<Director> directorList() {
        if (directorRepo.count() == 0) {
            log.info("No Records Exist");
        } else {
            log.info("{} Record Fetched Successfully", directorRepo.count());
        }
        return directorRepo.findAll();
    }

    @Override
    public String addDirector(Director director) {
        try{
            if(director.getFirstName() != null && director.getLastName() != null){
                directorRepo.save(director);
                log.info("Director Added Successfully");
                return "Director Added Successfully";
            } else {
                throw new Exception();
            }
        } catch (Exception e){
            log.error("Director Has Not Been Added");
            log.error("Exception Caught : {}", e.getMessage());
            return "Director Does Not Added";
        }
    }

    @Override
    public String deleteDirector(Director director) {
        try{
            if(director.getId() != null){
                directorRepo.delete(director);
                log.info("Director From Id : " + director.getId() + " Has Been Deleted");
                return "Record Deleted Successfully";
            } else {
                throw new NullPointerException();
            }
        } catch (Exception e){
            log.error("Exception Caught {}", e.getMessage());
            return "Record Does Not Deleted";
        }
    }

    @Override
    public Director findDirectorId(Integer id) {

        Director director = directorRepo.findDirectorsById(id);
        try {
            if (director != null) {
                log.info("Director Id '" + id + "' Fetched");
                return director;
            } else {
                throw new NullPointerException();
            }
        } catch (Exception e) {
            log.error("Id :'" + id + "' doesn't exist");
            log.error("Exception Caught {}" , e.getMessage());
        }
        return director;
    }
}

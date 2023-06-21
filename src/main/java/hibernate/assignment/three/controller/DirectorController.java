package hibernate.assignment.three.controller;

import hibernate.assignment.three.entity.Director;
import hibernate.assignment.three.services.DirectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/directors")
public class DirectorController {

    @Autowired
    DirectorService directorService;

    @RequestMapping("/")
    public List<Director> directorList(){
        return directorService.directorList();
    }

    @RequestMapping(value = "/add_director", method = RequestMethod.POST)
    public String addDirector(@RequestBody Director director){
        if(director != null){
            return directorService.addDirector(director);
        }
        return "Operation Failed";
    }

    @RequestMapping(value = "/delete_director/{id}", method = RequestMethod.DELETE)
    public String deleteDirector(@PathVariable Integer id){
        if(id != null && id >= 0){
            return directorService.deleteDirector(directorService.findDirectorId(id));
        }
        return "Operation Failed";
    }
}

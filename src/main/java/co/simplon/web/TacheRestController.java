package co.simplon.web;

import co.simplon.dao.TacheRepository;
import co.simplon.entities.Tache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class TacheRestController {
    @Autowired
    private TacheRepository tacheRepository;

    @GetMapping("/tasks")
    public List<Tache> tasks(){
        return tacheRepository.findAll();
    }

    @PostMapping("/tasks")
    public void postTache(@RequestBody Tache t) {
        tacheRepository.save(new Tache(null , t.getName()));
    }
}


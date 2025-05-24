package com.crud.controller;
import org.springframework.web.bind.annotation.RestController;
import com.crud.model.TechClass;
import com.crud.service.TechClassService;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/class")
public class TechClassController {
    private TechClassService techClassService;

    public TechClassController(TechClassService techClassService) {
        this.techClassService = techClassService;
    }

    @GetMapping
    public List<TechClass> getAllClasses() {
        return techClassService.getAllClass();
    }
    
    @PostMapping 
    public TechClass createTechClass(@RequestBody TechClass techClass) {
        return techClassService.createClass(techClass);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TechClass> getTechClassById(@PathVariable Long id) {
        return techClassService.getClassById(id)
                               .map(ResponseEntity::ok)
                               .orElse(ResponseEntity.notFound().build());

    }

    @DeleteMapping("/{id}")
    public String deleteTechClass(@PathVariable Long id) {
        if(techClassService.getClassById(id).isPresent()) {
            techClassService.deleteClassById(id);
        return "Class with "+id+" has been deleted!!";
        } else {
            return "Class with "+id+" does not exist";
        }
        
    }
}
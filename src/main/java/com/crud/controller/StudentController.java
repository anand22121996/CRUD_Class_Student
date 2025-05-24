package com.crud.controller;
import java.util.List;
import java.util.Optional;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.crud.model.Student;
import com.crud.model.TechClass;
import com.crud.service.StudentService;
import com.crud.service.TechClassService;

@RestController
@RequestMapping("/api/student")
public class StudentController {
        private final StudentService studentService;
        private final TechClassService techClassService;

        public StudentController(StudentService studentService, TechClassService techClassService) {
            this.studentService = studentService;
            this.techClassService = techClassService;
        }

        @GetMapping
        public List<Student> getAllStudents() {
            return studentService.getAllStudents();
        }
        
        @PostMapping
        public ResponseEntity<Student> createStudent(@RequestBody Student student) {
            if(student.getTechClass() == null || student.getTechClass().getId() == null) {
                return ResponseEntity.badRequest().build();
            } 
            
            Long techClassId = student.getTechClass().getId();
            Optional<TechClass> techOptional = techClassService.getClassById(techClassId);
    
            if(techOptional.isPresent()) {
                TechClass techClass = techOptional.get();
                student.setTechClass(techClass);
                studentService.createStudent(student);
                return ResponseEntity.ok(student);
            } else {
                return ResponseEntity.notFound().build();
            }
        }

        @GetMapping("/{id}")
        public ResponseEntity<Student> getAllStudentById(@PathVariable Long id) {
            return studentService.getAllStudentById(id).map(ResponseEntity::ok)
                    .orElse(ResponseEntity.notFound().build());
        }

        @DeleteMapping("/{id}")
        public String deleteStudentById(@PathVariable Long id) {
            if (studentService.getAllStudentById(id).isPresent()) {
                studentService.deleteStudentById(id);
                return "Student with " + id + " has been deleted!!";
            } else {
                return "Student with " + id + " does not exist";
            }
        }
}

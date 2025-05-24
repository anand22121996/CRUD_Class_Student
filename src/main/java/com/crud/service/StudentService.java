package com.crud.service;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import com.crud.model.Student;
import com.crud.repository.StudentRepository;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Optional<Student> getAllStudentById(Long id) {
        return studentRepository.findById(id);
    }

    public void deleteStudentById(Long id) {
        studentRepository.deleteById(id);
    }
}

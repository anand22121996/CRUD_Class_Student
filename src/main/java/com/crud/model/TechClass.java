package com.crud.model;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;
 
@Entity
@Data
@Table(name = "techclass")
public class TechClass {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String className;

    @OneToMany(mappedBy = "techClass", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<Student> students = new java.util.ArrayList<>();
}

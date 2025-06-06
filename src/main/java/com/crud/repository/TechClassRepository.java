package com.crud.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.crud.model.TechClass;

@Repository
public interface TechClassRepository extends JpaRepository<TechClass, Long> {

}

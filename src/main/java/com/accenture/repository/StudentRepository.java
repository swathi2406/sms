package com.accenture.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.accenture.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

	List<Student> findAllByNameStartingWith(String Name);
//	List<Student> findAllByAgeBetween(int min, int max);
}

package com.accenture.service;

import java.util.Collection;
import java.util.List;

//import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accenture.model.Student;
import com.accenture.repository.StudentRepository;

@Service
public class StudentService {

	@Autowired
	StudentRepository studentRepository;
	
	public void addStudent(Student student)
	{
		studentRepository.save(student);
		
	}
	
	public Collection<Student> getStudent() {
		return studentRepository.findAll();
	}

	public List<Student> getStudentByName(String Name)
	{
		List<Student> filtered = studentRepository.findAllByNameStartingWith(Name);
		return filtered;
	}
	public Student getStudentById(int id)
	{
		Student student = studentRepository.getById(id);
		return student;
	}
	public void updateStudent(int sid, Student student)
	{
		getStudentById(sid);
		studentRepository.save(student);
	}
	
	public void deleteStudent(int sid)
	{
		getStudentById(sid);
		studentRepository.deleteById(sid);
	}
}

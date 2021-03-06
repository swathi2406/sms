package com.accenture.controller;

import java.net.URI;
import java.util.Collection;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.accenture.exception.StudentIdMismatch;
import com.accenture.model.Student;

import com.accenture.service.StudentService;

@CrossOrigin(origins = "*")
@RestController
public class StudentController {
	
	@Autowired
	StudentService studentService;
	
//	Add students
	@PostMapping("/student/add")
	public ResponseEntity<?> addStudent( @RequestBody Student student)
	{
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{sid}")
				.buildAndExpand(student.getSid()).toUri();
		studentService.addStudent(student);
		return ResponseEntity.created(location).body("Student Details are entered successfully!!");
	}
	@GetMapping("/student/show")
	public Collection<Student> getStudent() {
		return studentService.getStudent();
	}
	
	@GetMapping("/student/show/name/{name}")
	public List<Student> getStudentByName(@PathVariable String name)
	{
		return studentService.getStudentByName(name);
	}
	@GetMapping("/student/show/sid/{sid}")
	public ResponseEntity<?> getStudentById(@PathVariable int sid)
	{
		return ResponseEntity.ok(studentService.getStudentById(sid));
	}
	@PutMapping("/student/update/sid/{sid}")
	public ResponseEntity<?> updateStudent(@PathVariable int sid, @Valid @RequestBody Student student)
	{
		if(sid !=student.getSid())
		{
			throw new StudentIdMismatch();
		}
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{sid}").buildAndExpand(student.getSid()).toUri();
		studentService.updateStudent(sid, student);
		return ResponseEntity.ok().body("Updated the details Successfully!Go back to the list to see the changes!");
		
	}
	@DeleteMapping("/student/delete/sid/{sid}")
	public ResponseEntity<?> deleteStudent(@PathVariable int sid)
	{
		Student student = new Student();
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{sid}").buildAndExpand(student.getSid()).toUri();
		studentService.deleteStudent(sid);
		return ResponseEntity.ok().body("Deleted Successfully! Go back to the list to see the changes!");
	}
}

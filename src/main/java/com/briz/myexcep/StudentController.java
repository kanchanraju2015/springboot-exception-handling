package com.briz.myexcep;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
// SPRINGBOOT STARTER VALIDATION IS ADDED INTO THE POM.XML
@RestController
@Validated
public class StudentController
{
@Autowired
StudentRepository srepo;
@RequestMapping("/")
public String test()
{
	return "this is test only";
}
@RequestMapping("/save")
public String save()
{
	Student s=new Student();
	s.setName("manu kumar singh");
	s.setAge(32);
	s.setAddress("patna");
	srepo.save(s);
	return "data saved";	
}
@RequestMapping("/{id}")
public Optional<Student> byid(@PathVariable int id)
{
	return srepo.findById(id);
}
@RequestMapping("/{id}/{age}")
public Optional<Student> byid(@PathVariable int id,@PathVariable @Valid int age)
{
	Student student=srepo.findById(id).get();
	//Student student=srepo.findById(id).orElseThrow()->new RuntimeException("Id not valid");
	student.setAge(age);
	srepo.save(student);
	return srepo.findById(id);
}

}

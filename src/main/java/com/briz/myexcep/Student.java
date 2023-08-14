package com.briz.myexcep;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity(name="student")
public class Student 
{
@Id
@GeneratedValue(strategy=GenerationType.AUTO)
int id;
@NotNull
@Size(min=10,message="name must be 10 char")
//if name is less than 10 chars then it will give ConstraintViolationException also in postman with scroll
// please enter the name more then 10 chars 
String name;
@Min(value = 20) // use @Validated at controller level and @Valid at method level
int age;
@AddressValidation(message="put a valid address")// it has higher priority then default
// not this is customer validation annotation for address 
String address;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public int getAge() {
	return age;
}
public void setAge(int age) {
	this.age = age;
	
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}

}

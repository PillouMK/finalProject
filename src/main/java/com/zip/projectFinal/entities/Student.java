package com.zip.projectFinal.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@Entity
@Table(name = "students")
public class Student {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(length = 64, unique = true, nullable = false)
	private String name;
	private float age;
	public Student(String name, float age) {
		this.name = name;
		this.age = age;
	}
	
	public Student() {
		
	}
	
	// getters and setters are not shown for brevity...
	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", price=" +
				age + "]";
	}
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getName() {
	return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public float getAge() {
		return age;
	}
	
	public void setAge(float age) {
		this.age = age;
	}
}
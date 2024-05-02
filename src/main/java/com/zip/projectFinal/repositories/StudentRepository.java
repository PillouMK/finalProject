package com.zip.projectFinal.repositories;

import org.springframework.data.repository.CrudRepository;

import com.zip.projectFinal.entities.Student;


public interface StudentRepository extends CrudRepository<Student, Integer> {
	public Student findByName(String name);
}
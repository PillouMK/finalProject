package com.zip.projectFinal;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;

import com.zip.projectFinal.entities.Student;
import com.zip.projectFinal.repositories.StudentRepository;

class TestDemoDataController {

	@Autowired
    private StudentRepository repo;
    
    @Test
    @Rollback(false)
    @Order(1)
    public void testCreateStudent() {
    	Student savedStudent = repo.save(new Student("Pille Maxence", 24));
        assertThat(savedStudent.getId()).isGreaterThan(0);
    }
    
    @Test
    @Order(2)
    public void testFindStudentByName() {
    	Student student = repo.findByName("Pille Maxence"); 
         assertThat(student.getName()).isEqualTo("Pille Maxence");
    }

    @Test
    @Rollback(true)
    @Order(3)
    public void testUpdateStudent() {
    	Student student = repo.findByName("Pille Maxence");
        student.setAge(18);
        repo.save(student);
        
        Student updatedStudent = repo.findByName("Pille Maxence");
        assertThat(updatedStudent.getAge()).isEqualTo(18);
    }
    
    @Test
    @Rollback(false)
    @Order(4)
    public void testDeleteStudent() {
    	Student student = repo.findByName("Pille Maxence");
        repo.deleteById(student.getId());
        
        Student deletedStudent = repo.findByName("Pille Maxence");
        assertThat(deletedStudent).isNull(); 
    
    }

}

package com.demo.jpa.hibernate.demo.repository;

import static org.junit.Assert.assertFalse;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.demo.jpa.hibernate.demo.DemoApplication;
import com.demo.jpa.hibernate.demo.entity.Passport;
import com.demo.jpa.hibernate.demo.entity.Student;
import com.demo.jpa.hibernate.demo.repository.SudentRepository1;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = DemoApplication.class)
public class StudentRepositoryTest2 {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	SudentRepository1 repository;

	@Autowired
	EntityManager em;

	// Session & Session Factory

	// EntityManager & Persistence Context
	// Transaction

	@Test
	@Transactional
	public void someTest() {
		//List<Student> findByNameAndGenderType = repository.findByNameAndGenderType("Jane", "female");
		//List<Student> findByNameAndGenderType = repository.findByNameAndGenderType("Jane", "female");
		//List<Student> findByNameAndGenderType = repository.findByNameAndGenderTypesOrderByAgeAsc("Jane", "female");
		//List<Student> findByNameAndGenderType = repository.findByNameAndGenderTypesAndAgeGreaterThan("Jane", "female",20);
		List<Student> findByNameAndGenderType = repository.findByNameAndGenderTypesAndAgeBetween("Jane", "female",45,60);
		

		
		for(Student student :findByNameAndGenderType)
		{
		   logger.info("STUDENTS -> {}",  student,student.getId());
		   //logger.info("STUDENTS ID -> {}",  student.getId());
		   //logger.info("STUDENTS Passport -> {}",  student.getPassport());
		   logger.info("STUDENTS Age -> {}",  student.getAge());
		}
		
//		List<Student> findByNameAndGenderType2 = repository.findByNameAndGenderTypeAndAgeBetweenQueryParam("female","Jane",50,60);
//		
//		for(Student student :findByNameAndGenderType2)
//		{
//		   logger.info("STUDENTS -> {}",  student,student.getId());
//		   //logger.info("STUDENTS ID -> {}",  student.getId());
//		   //logger.info("STUDENTS Passport -> {}",  student.getPassport());
//		   logger.info("STUDENTS Age -> {}",  student.getAge());
//		}

		
//		//List<String> findByNameAndGenderType2 = repository.findDistinctByNameAndGenderTypes("female");
		//List<String> findByNameAndGenderType2 = repository.findNameAndGenderTypes("female","a");
		List<Integer> age = new ArrayList<Integer>( Arrays.asList(29, 50, 27) );
		
		//List<Student> findByNameAndGenderType2 = repository.findBetweenInAge("female");
		//List<Student> findByNameAndGenderType2 = repository.findNotInAgeGenderTypes(age,"female");
		//List<Student> findByNameAndGenderType2 = repository.findByAgeNotInAndAgeGreaterThanAndGenderTypes(age,30, "female");
		
//		List<String> gts = new ArrayList<String>( Arrays.asList("female", "male") );
//		List<String> ages = new ArrayList<String>( Arrays.asList("48", "50") );
//		
//		
		List<Object[]> getAttribtes = repository.getAttribtes(age);
		
		for(Object[] student :getAttribtes)
		{
			   logger.info("Student ID -> {}", ((Long)student[0]) );
			   logger.info("Student AGE -> {}", ((Integer)student[1]) );
	
		}
		
		//List<Student> findByNameAndGenderType2 = repository.findBetweenInAgeIn(gts);
//		List<Student> findByNameAndGenderType2 = repository.findByAgeGreaterThanAndGenderTypesInOrderByIdDesc(30, gts);
//
//
//
//
//		for(Student student :findByNameAndGenderType2)
//		{
//		   logger.info("Gender -> {}",  student.getId());
//
//		}

		//repository.deleteByAge(50);
		//repository.deleteByAge(48);
		
		//Long countByGenderTypes = repository.countAllByGenderTypes("female");
		
		//logger.info("Gender Count -> {}", countByGenderTypes);
		
	}
	
//	@Test
//	public void whenCreatesEmptyOptional_thenCorrect() {
//	    Optional<String> empty = Optional.of("hi");;
//	   
//	    System.out.println(empty.orElse(null));
//	    assertFalse(empty.isPresent());
//	}

//	@Test
//	@Transactional
//	public void retrieveStudentAndPassportDetails() {
//		Student student = em.find(Student.class, 20001L);
//		logger.info("student -> {}", student);
//		logger.info("passport -> {}", student.getPassport());
//	}
//	
//	@Test
//	@Transactional
//	public void retrievePassportAndAssociatedStudent() {
//		Passport passport = em.find(Passport.class, 40001L);
//		logger.info("passport -> {}", passport);
//		logger.info("student -> {}", passport.getStudent());
//	}
//	
//	@Test
//	@Transactional
//	public void retrieveStudentAndCourses() {
//		Student student = em.find(Student.class, 20001L);
//		
//		logger.info("student -> {}", student);
//		logger.info("courses -> {}", student.getCourses());
//	}

}

package com.demo.jpa.hibernate.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.jpa.hibernate.demo.entity.Course;

public interface CourseSpringDataRepository extends JpaRepository<Course, Long> {

}

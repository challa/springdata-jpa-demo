package com.demo.jpa.hibernate.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.demo.jpa.hibernate.demo.entity.Student;

@Repository
@Transactional
public interface SudentRepository1 extends JpaRepository<Student,Long>{
	
	@Query("SELECT analyseReport FROM Student analyseReport where " +
            "analyseReport.name = :name AND  analyseReport.genderTypes= :genderTypes")
    List<Student> findByNameAndGenderType(@Param("name") String  name,
            @Param("genderTypes") String  tenant_uid);
	
	@Query("SELECT analyseReport FROM Student analyseReport where " +
            "analyseReport.name = :name AND  analyseReport.genderTypes= :genderTypes")
    Student findByNameAndGenderType1(@Param("name") String  name,
            @Param("genderTypes") String  tenant_uid);
	
	List<Student> findByNameAndGenderTypes(String name,String genderType);
	List<Student> findByNameAndGenderTypesOrderByAgeAsc(String name,String genderType);
	List<Student> findByNameAndGenderTypesAndAgeGreaterThan(String name,String genderType,int age);
	List<Student> findByNameAndGenderTypesAndAgeBetween(String name,String genderType,int age,int age1);

	@Query(value="SELECT * FROM student  where " +
            "name = ?1  AND gender_type= ?2 AND age BETWEEN ?3 AND ?4", nativeQuery = true)
	List<Student> findByNameAndGenderTypeAndAgeBetween(String name,String genderType,int age,int age1);

	@Query(value="SELECT * FROM student  where " +
            "name = :name  AND gender_type= :gender AND age BETWEEN :lowerage AND :higherage", nativeQuery = true)
	List<Student> findByNameAndGenderTypeAndAgeBetweenQueryParam(
			@Param("gender")String genderType, @Param("name")String name,
			@Param("lowerage")int age,
			@Param("higherage")int age1);

	@Query("SELECT Distinct student.name FROM Student student where " +
			" student.genderTypes= :tenant_uid")
	List<String> findDistinctByNameAndGenderTypes(@Param("tenant_uid") String genderTypes);

	@Query(" SELECT  student.name FROM Student student where " +
			" student.genderTypes= :tenant_uid  AND student.name like  CONCAT('%',:name,'%')")
	List<String> findNameAndGenderTypes(@Param("tenant_uid") String genderTypes,@Param("name") String name);

	@Query(" SELECT  student FROM Student student where " +
			"student.age Not in (:age_params)")
	List<Student> findNotInAge(@Param("age_params") List<Integer> ages);


	@Query(" SELECT  student.id ,student.age FROM Student student where " +
			"age  in (:age_params)")
	List<Object[]> getAttribtes(@Param("age_params") List<Integer> ages);

	@Query(" SELECT  student FROM Student student where " +
			"student.age Not in (:age_params) and  student.genderTypes = :genderTypes")
	List<Student> findNotInAgeGenderTypes(@Param("age_params") List<Integer> ages ,@Param("genderTypes")String genderTypes );

	@Query(" SELECT  student FROM Student student where " +
			"(student.age =27 OR student.age = 50) AND student.genderTypes= :genderTypes")
	List<Student> findBetweenInAge(@Param("genderTypes") String genderTypes);

	List<Student> findByAgeNotInAndAgeGreaterThanAndGenderTypes(List<Integer> ages,int greaterage, String genderTypes );

	Long  countAllByGenderTypes(String genderType);

	@Query(" SELECT  student FROM Student student where " +
			"student.genderTypes in (:gt) AND student.age > 30")
	List<Student> findBetweenInAgeIn(@Param("gt") List<String> genderTypes);
	
	@Query(" SELECT  student FROM Student student where " +
			"student.age  in (:gt)")
	List<Student> findBInAgeIn(@Param("gt") List<Integer> age);

	List<Student> findByAgeGreaterThanAndGenderTypesInOrderByIdAscAgeAsc(int age,List<String> genderTypes );
    @Modifying
	@Query("DELETE FROM Student c WHERE c.genderTypes = :p")
	void deleteAllByGenderTypes(@Param("p") String age);
}


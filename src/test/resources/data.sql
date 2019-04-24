insert into course(id, name, created_date, last_updated_date) 
values(10001,'JPA in 50 Steps', sysdate(), sysdate());
insert into course(id, name, created_date, last_updated_date) 
values(10002,'Spring in 50 Steps', sysdate(), sysdate());
insert into course(id, name, created_date, last_updated_date) 
values(10003,'Spring Boot in 100 Steps', sysdate(), sysdate());
insert into course(id, name, created_date, last_updated_date) 
values(10004,'Dummy1', sysdate(), sysdate());
insert into course(id, name, created_date, last_updated_date) 
values(10005,'Dummy2', sysdate(), sysdate());
insert into course(id, name, created_date, last_updated_date) 
values(10006,'Dummy3', sysdate(), sysdate());
insert into course(id, name, created_date, last_updated_date) 
values(10007,'Dummy4', sysdate(), sysdate());
insert into course(id, name, created_date, last_updated_date) 
values(10008,'Dummy5', sysdate(), sysdate());


insert into passport(id,number)
values(40001,'E123456');
insert into passport(id,number)
values(40002,'N123457');
insert into passport(id,number)
values(40003,'L123890');
insert into passport(id,number)
values(40004,'L123891');
insert into passport(id,number)
values(40005,'L123892');
insert into passport(id,number)
values(40006,'L123893');


insert into student(id,name,passport_id,gender_type,age) values(20001,'Ranga',40001,'male',32);
insert into student(id,name,passport_id,gender_type,age) values(20002,'Adam',40002,'female',24);
insert into student(id,name,passport_id,gender_type,age) values(20003,'Jane',40003,'female',48);
insert into student(id,name,passport_id,gender_type,age) values(20004,'Jane',40004,'female',27);
insert into student(id,name,passport_id,gender_type,age) values(20005,'Jane',40005,'female',50);
insert into student(id,name,passport_id,gender_type,age) values(20006,'Adam',40006,'female',29);


insert into review(id,rating,description,course_id)
values(50001,'5', 'Great Course',10001);
insert into review(id,rating,description,course_id)
values(50002,'4', 'Wonderful Course',10001);
insert into review(id,rating,description,course_id)
values(50003,'5', 'Awesome Course',10003);

insert into student_course(student_id,course_id)
values(20001,10001);
insert into student_course(student_id,course_id)
values(20002,10001);
insert into student_course(student_id,course_id)
values(20003,10001);
insert into student_course(student_id,course_id)
values(20001,10003);
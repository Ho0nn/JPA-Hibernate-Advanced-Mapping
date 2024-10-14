package com.luve2code.cruddemo;

import com.luve2code.cruddemo.dao.AppDAO;
import com.luve2code.cruddemo.entity.Course;
import com.luve2code.cruddemo.entity.Instructor;
import com.luve2code.cruddemo.entity.InstructorDetail;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CrudDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(CrudDemoApplication.class, args);
    }
    @Bean
    public CommandLineRunner commandLineRunner(AppDAO appDAO){
        return runner->{
//           createInstructor(appDAO);
//            findInstructor(appDAO);
//            deleteById(appDAO);
//            findInstructorDetail(appDAO);
//            deleteInstructorDetail(appDAO);
            createInstructorWithCourses(appDAO);
        };
    }

    private void createInstructorWithCourses(AppDAO appDAO) {

        Instructor instructor =
                new Instructor("susan","public","susan@gmail.com");
        //create Instructor Details
        InstructorDetail detail=
                new InstructorDetail(
                        "http://www.susan.com/youtube",
                        "Swimming");

        // associate the object
        instructor.setInstructorDetail(detail);

        // create some courses
        Course course = new Course("Java");
        Course course1 = new Course("Road to Spring");

        // add course to instructor
        instructor.add(course);
        instructor.add(course1);

        // save the instructor --> save the courses because of CascadeType.PERSIST
        System.out.println("Saving Instructor : "+instructor);
        System.out.println("Courses : "+instructor.getCourses());
        appDAO.save(instructor);
        System.out.println("Done🥳!");

    }

    private void deleteInstructorDetail(AppDAO appDAO) {
        int id=3;
        appDAO.deleteInstructorDetailById(id);
        System.out.println(" Done🤩 !");

    }

    private void findInstructorDetail(AppDAO appDAO) {
        int id=1;
        InstructorDetail detail=appDAO.findInstructorDetailById(id);
        System.out.println("Instructor Details: "+detail);
        System.out.println("Instructor related to this details : "+detail.getInstructor());

    }

    private void deleteById(AppDAO appDAO) {
        int id = 2;
        appDAO.deleteById(id);
        System.out.println("Instructor was Deleted Successfully !");

    }

    private void findInstructor(AppDAO appDAO) {
        int id =2;
        Instructor instructor=appDAO.findInstructorById(id);
        System.out.println("Instructor : "+ instructor);
        System.out.println("Instructor Details: "+instructor.getInstructorDetail());
    }

    private void createInstructor(AppDAO appDAO) {

/*
        //create Instructor
        Instructor instructor =
                new Instructor("Hanin","Mohamed","haneen.m.elfeky@gmail.com");
        //create Instructor Details
        InstructorDetail detail=
                new InstructorDetail(
                        "http://www.haneen.com/youtube",
                        "Coding");
*/


        //create Instructor
        Instructor instructor =
                new Instructor("Mohamed","Anas","mohamedanas123@gmail.com");
        //create Instructor Details
        InstructorDetail detail=
                new InstructorDetail(
                        "http://www.mohamedanas.com/youtube",
                        "Swimming");



        // associate the objecy
        instructor.setInstructorDetail(detail);

        // save the instructor

        // this will also save the details object cause of CascadeType.ALL
        System.out.println("Saving Instructor : " + instructor);
        appDAO.save(instructor);

        System.out.println("Done🥳!");
    }
}

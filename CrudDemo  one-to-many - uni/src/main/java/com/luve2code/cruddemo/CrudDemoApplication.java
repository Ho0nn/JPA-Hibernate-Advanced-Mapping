package com.luve2code.cruddemo;

import com.luve2code.cruddemo.dao.AppDAO;
import com.luve2code.cruddemo.entity.Course;
import com.luve2code.cruddemo.entity.Instructor;
import com.luve2code.cruddemo.entity.InstructorDetail;
import com.luve2code.cruddemo.entity.Review;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CrudDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(CrudDemoApplication.class, args);
    }
    @Bean
    public CommandLineRunner commandLineRunner(AppDAO appDAO){
        return runner->{

//            createCourseAndReviews(appDAO);
            retrieveCourseAndReviews(appDAO);
        };
    }

    private void retrieveCourseAndReviews(AppDAO appDAO) {

        // get the course and reviews
        int id=10;
        Course course= appDAO.finndCourseAndReviewsByCourseId(id);

        // print the course
        System.out.println(course);

        // print the review
        System.out.println(course.getReviews());

        System.out.println("Done🤩!");


    }

    private void createCourseAndReviews(AppDAO appDAO) {
        //  create course
        Course course = new Course("Road to Spring");

        // add a review
        course.addReview(new Review("Wow! Great Course "));
        course.addReview(new Review("Thanks For this Course!  "));
        course.addReview(new Review("Great Course ... I Love it !"));

        // save course
        System.out.println("Saving Course");
        System.out.println(course);
        System.out.println(course.getReviews());
        appDAO.save(course);
        System.out.println("Done🤩!");


    }

    private void deleteCourse(AppDAO appDAO) {
        int id=10;
        appDAO.deleteCourseById(id);
        System.out.println("Course with id :"+ id +" was Deleted Successfully! ");
    }

    private void updateCourse(AppDAO appDAO) {

       // find the course
        int id= 10;
        Course course= appDAO.findCourseById(id);

        // update course
        course.setTitle("Servlet");
        appDAO.update(course);
        System.out.println("Done🤩!");


    }

    private void updateInstructor(AppDAO appDAO) {
        int id=3;
        Instructor instructor = appDAO.findInstructorById(id);

        // update instructor data
        instructor.setFirstName("Hanin");

        appDAO.update(instructor);
    }

    private void findInstructorWithCoursesJoinFetch(AppDAO appDAO) {
        int id=1;

        //find instructor
        Instructor instructor=appDAO.findInstructorByIdJoinFetch(id);
        System.out.println("The Instructor : "+ instructor);
        System.out.println("associated courses : "+ instructor.getCourses());


    }

    private void findCoursesForInstructor(AppDAO appDAO) {
        int id=1;

        Instructor instructor = appDAO.findInstructorById(id);
        System.out.println("Instructor : "+instructor);

        //find courses for instructor
        List<Course> courses = appDAO.findCoursesByInstructorId(id);
        instructor.setCourses(courses);
        System.out.println("Courses associated to Instructor : "+instructor.getCourses());
        System.out.println("Done 🥳!");
    }

    private void findInstructorWithCourses(AppDAO appDAO) {
        int id=1;
        Instructor instructor=appDAO.findInstructorById(id);
        System.out.println("Instructor : "+instructor);
        System.out.println("Courses associated to Instructor : "+instructor.getCourses());

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

    private void deleteInstructor(AppDAO appDAO) {
        int id = 3;
        appDAO.deleteInstructorById(id);
        System.out.println("Instructor was Deleted Successfully !");

    }

    private void findInstructor(AppDAO appDAO) {
        int id =1;
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

package com.luve2code.cruddemo;

import com.luve2code.cruddemo.dao.AppDAO;
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
//            createInstructor(appDAO);
            findInstructor(appDAO);
            
        };

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

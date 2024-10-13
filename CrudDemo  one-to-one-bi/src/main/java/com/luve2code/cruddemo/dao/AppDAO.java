package com.luve2code.cruddemo.dao;

import com.luve2code.cruddemo.entity.Instructor;
import com.luve2code.cruddemo.entity.InstructorDetail;


public interface AppDAO {

    void save(Instructor instructor);

    Instructor findInstructorById(int id);

    void deleteById(int id);
    InstructorDetail findInstructorDetailById(int id);
    void deleteInstructorDetailById(int id);
}

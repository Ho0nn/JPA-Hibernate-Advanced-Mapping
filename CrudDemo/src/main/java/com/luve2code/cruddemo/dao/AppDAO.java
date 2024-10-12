package com.luve2code.cruddemo.dao;

import com.luve2code.cruddemo.entity.Instructor;


public interface AppDAO {

    void save(Instructor instructor);

    Instructor findInstructorById(int id);

    void deleteById(int id);
}

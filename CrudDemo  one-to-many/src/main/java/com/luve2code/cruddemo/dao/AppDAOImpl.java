package com.luve2code.cruddemo.dao;

import com.luve2code.cruddemo.entity.Course;
import com.luve2code.cruddemo.entity.Instructor;
import com.luve2code.cruddemo.entity.InstructorDetail;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AppDAOImpl implements AppDAO{

    // define field for entity manager
    private EntityManager entityManager;

    // inject entity manager using constructor injection
    @Autowired
    public AppDAOImpl(EntityManager entityManager){
        this.entityManager=entityManager;
    }

    @Override
    @Transactional
    public void save(Instructor instructor) {
        entityManager.persist(instructor);
    }

    @Override
    public Instructor findInstructorById(int id) {
        return entityManager.find(Instructor.class,id);
    }

    @Override
    @Transactional
    public void deleteInstructorById(int id) {
        Instructor instructor= entityManager.find(Instructor.class,id);

        // get courses
        List<Course>courses=instructor.getCourses();
        for (Course c:courses){
            c.setInstructor(null);
        }

        entityManager.remove(instructor);
    }

    @Override
    public InstructorDetail findInstructorDetailById(int id) {
        return entityManager.find(InstructorDetail.class,id);
    }

    @Override
    @Transactional
    public void deleteInstructorDetailById(int id) {
        InstructorDetail detail = entityManager.find(InstructorDetail.class,id);
      detail.getInstructor().setInstructorDetail(null);
        entityManager.remove(detail);
    }

    @Override
    public List<Course> findCoursesByInstructorId(int id) {
        // create query
        TypedQuery<Course> query=entityManager.createQuery(
                "from Course where instructor.id=:data",Course.class);
         query.setParameter("data",id);

         // execute query
        List<Course> courses=query.getResultList();
        return courses;
    }

    @Override
    public Instructor findInstructorByIdJoinFetch(int id) {

        TypedQuery<Instructor> instructor=entityManager.createQuery(
                "select i  from Instructor i "
                        +"JOIN FETCH i.courses "
                        + "JOIN FETCH i.instructorDetail "
                        +" where i.id=: data",Instructor.class);
        instructor.setParameter("data",id);
        Instructor inst = instructor.getSingleResult();
        return inst;

    }

    @Override
    @Transactional
    public void update(Instructor instructor) {
        entityManager.merge(instructor);
    }

    @Override
    @Transactional
    public void update(Course course) {
        entityManager.merge(course);
    }

    @Override
    public Course findCourseById(int id) {
         return entityManager.find(Course.class,id);

    }

    @Override
    @Transactional
    public void deleteCourseById(int id) {
        Course course=findCourseById(id);
        entityManager.remove(course);
    }
}

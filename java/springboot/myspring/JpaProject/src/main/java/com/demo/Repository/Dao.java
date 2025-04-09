package com.demo.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.demo.Model.Student;
@Repository

public interface Dao extends CrudRepository<Student,Integer>
{

}

package com.demo.Service;

import java.util.List;
import com.demo.Model.Student;


public interface ServiceInterface {

	String save(Student student);

	String findById(int roll);

	List<Student> findAll();

}

package com.demo.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.Model.Student;
import com.demo.Repository.Dao;
@Service
public class ServiceImpl implements ServiceInterface {
@Autowired
	private Dao dao;

	@Override
	public String save(Student student)
	{
		Student s1=dao.save(student);
		return s1+"inserted successully";
	}

	@Override
	public String findById(int roll) {
		Optional<Student> optional=dao.findById(roll);
		if(optional.isPresent())
		{
			return optional.toString();
		}
		else
		{
			return "User With Roll= "+roll+" Doesn't Exist";
		}
	}

	@Override
	public List<Student> findAll() {
		return (List<Student>) dao.findAll();
	}

}

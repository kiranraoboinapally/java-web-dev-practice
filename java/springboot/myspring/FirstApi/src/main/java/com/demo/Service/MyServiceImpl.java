package com.demo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.Repository.Dao;

@Service
public class MyServiceImpl implements MyService {
	@Autowired
	private Dao dao;
	public String m1()
	{
		return dao.m1();
	}
}

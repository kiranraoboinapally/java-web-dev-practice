package com.demo.Repository;

import org.springframework.stereotype.Repository;

@Repository
public class Dao {

	public String m1() {
		return "Hello all good Morning";
	}

	public int add(int num1,int num2) {
		// TODO Auto-generated method stub
		return num1+num2;
	}

}

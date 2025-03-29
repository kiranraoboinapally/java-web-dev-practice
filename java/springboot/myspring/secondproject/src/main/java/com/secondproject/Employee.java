package com.secondproject;

public class Employee {
int Id;
String Location;
public int getId() {
	return Id;
}
public void setId(int id) {
	Id = id;
}
public String getLocation() {
	return Location;
}
public void setLocation(String location) {
	Location = location;
}
@Override
public String toString() {
	return "Employee [Id=" + Id + ", Location=" + Location + "]";
}

}

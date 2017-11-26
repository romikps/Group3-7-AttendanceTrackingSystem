package com.example.guestbook;

import java.util.ArrayList;
import java.util.List;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;

@Entity
public class Student {
	@Id public Long id;
	public List<String> registeredGroups;
	public String studentId;
	
	public Student() {
		studentId = "example@example.com";
		this.registeredGroups = new ArrayList<String>();
	}
	
	public Student(String studentId) {
		this();
		this.studentId = studentId;
		
	}
	
	public void registerInGroup(String groupId) {
		registeredGroups.add(groupId);
	}
	
}

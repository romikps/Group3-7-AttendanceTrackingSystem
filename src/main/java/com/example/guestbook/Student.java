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
	
	public Student(String studentId) {
		this.studentId = studentId;
		this.registeredGroups = new ArrayList<String>();
	}
	
	public void registerInGroup(String groupId) {
		registeredGroups.add(groupId);
	}
	
}

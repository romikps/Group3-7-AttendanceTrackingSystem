package com.example.guestbook;

import java.util.ArrayList;
import java.util.List;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import com.googlecode.objectify.annotation.Index;

@Entity
public class Student {
	@Id public Long id;
	public String registeredGroup;
	@Index public String studentId;
	
	public Student() {
	}
	
	public Student(String studentId) {
		this.studentId = studentId;		
	}
	
	public void registerInGroup(String groupId) {
		registeredGroup = groupId;
	}
	
}


package com.example.guestbook;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import java.lang.String;

/**
 * The @Entity tells Objectify about our entity.  We also register it in {@link OfyHelper}
 * Our primary key @Id is set automatically by the Google Datastore for us.
 **/
@Entity
public class Group {
	@Id public Long id;

	public String number;
	public String time;
	public String place;
	public String instructor;

	public Group(String number, String time, String place, String instructor) {
		this.number = number;
		this.time = time;
		this.place = place;
		this.instructor = instructor;
	}

	public Long getId() {
		return id;
	}

	public String getNumber() {
		return number;
	}

	public String getTime() {
		return time;
	}

	public String getPlace() {
		return place;
	}

	public String getInstructor() {
		return instructor;
	}
	
	
}


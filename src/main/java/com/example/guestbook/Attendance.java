package com.example.guestbook;

import com.googlecode.objectify.Key;
import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import com.googlecode.objectify.annotation.Index;
import com.googlecode.objectify.annotation.Parent;

import java.lang.String;



@Entity
public class Attendance {
	@Parent Key<AttendanceLog> logger;
	
    @Id long attendanceId;
    @Index long studentId;
    long tutorialGroupId;
    long weekId;
    boolean presented;
    
    /**
     * Constructor
     */
	public Attendance(long studentId, long tutorialGroupId, String aLog) {
		// this.attendanceId = generate id
		// this.weekId = generate id new SimpleDateFormat("w").format(new java.util.Date())
		this.studentId = studentId;
		this.tutorialGroupId = tutorialGroupId;
		
	    if( aLog != null ) {
	        logger = Key.create(AttendanceLog.class, aLog);  // Creating the Ancestor key
	      } else {
	        logger = Key.create(AttendanceLog.class, "default");
	      }
	}

}
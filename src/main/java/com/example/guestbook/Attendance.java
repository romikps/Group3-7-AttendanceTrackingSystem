package com.example.guestbook;

public class Attendance {
    long attendanceId;
    long studentId;
    long tutorialGroupId;
    long weekId;
    boolean presented;
    
	public Attendance(long studentId, long tutorialGroupId) {
		// this.attendanceId = generate id
		// this.weekId = generate id new SimpleDateFormat("w").format(new java.util.Date())
		this.studentId = studentId;
		this.tutorialGroupId = tutorialGroupId;
	}

}
package com.example.guestbook;

import org.restlet.resource.Get;
import org.restlet.resource.ServerResource;

public class AttendanceResource extends ServerResource {
	
    @Get
    public String represent() {
        return "hello, world (from the cloud!)";
    }
    
}

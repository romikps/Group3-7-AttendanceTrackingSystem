
package com.example.guestbook;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;
import com.google.appengine.api.users.User;
import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;

import java.io.IOException;
import java.util.Date;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.googlecode.objectify.ObjectifyService;

/**
 * Form Handling Servlet
 * Most of the action for this sample is in webapp/guestbook.jsp, which displays the
 * {@link Greeting}'s. This servlet has one method
 * {@link #doPost(<#HttpServletRequest req#>, <#HttpServletResponse resp#>)} which takes the form
 * data and saves it.
 */
public class SignGuestbookServlet extends HttpServlet {

	// Process the http POST of the form
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {

		UserService userService = UserServiceFactory.getUserService();
		User user = userService.getCurrentUser();  // Find out who the user is.
		Student student;

		String groupId = req.getParameter("groupId");
		if (groupId != null && user != null) {
			student = ObjectifyService.ofy()
					.load()
					.type(Student.class)
					.filter("studentId", user.getEmail())
					.first().now();

			if (student == null) {
				student = new Student(user.getEmail());
			}

			student.registerInGroup(groupId);
			// now() is used to make the call synchronously
			ObjectifyService.ofy().save().entity(student).now();
		}
		resp.sendRedirect("/guestbook.jsp");
	}
}

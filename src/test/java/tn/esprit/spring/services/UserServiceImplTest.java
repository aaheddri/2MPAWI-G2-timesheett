
package tn.esprit.spring.services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import tn.esprit.spring.entities.Role;
import tn.esprit.spring.entities.User;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
class UserServiceImplTest {
	@Autowired
	IUserService us;
    /*
	@Test
	@Order(1)
	void testRetrieveAllUsers() {
		// Act
		List<User> listUsers = us.retrieveAllUsers();
		// Assert
		Assertions.assertEquals(0, listUsers.size());
	}
     */

	@Test
	@Order(2)
	void testAddUser() throws ParseException {
		// Arrange
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date d = dateFormat.parse("2015-03-23");
		User u = new User("Mayssa1", "Mayssa1", d, Role.INGENIEUR);

		// Act
		User userAdded = us.addUser(u);

		// Assert
		Assertions.assertEquals(u.getLastName(), userAdded.getLastName());
	}

	@Test
	@Order(3)
	void testModifyUser() throws ParseException {
		// Arrange
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date d = dateFormat.parse("2015-03-23");
		User u = new User(1L, "Mayssa122222222", "Mayssa", d, Role.INGENIEUR);

		// Act
		User userUpdated = us.updateUser(u);

		// Assert
		Assertions.assertEquals(u.getLastName(), userUpdated.getLastName());
	}

    /*
	@Test
	@Order(4)
	void testRetrieveUser() {
		// Act
		User userRetrieved = us.retrieveUser("1");

		// Assert
		Assertions.assertEquals(1L, userRetrieved.getId());
	}

     */

	@Test
	@Order(5)
	void testDeleteUser() {
		// Act
		us.deleteUser("1");

		// Assert
		Assertions.assertNull(us.retrieveUser("1"));
	}
}


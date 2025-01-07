package fitness;

import static org.junit.Assert.assertTrue;

import java.io.IOException;

import org.junit.Test;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AddUser_Test {
	public AddUser_Test(MyApp app) {
		super();
		this.app=app;
	}

	MyApp app;
	
	@Test
	@Given("i am loged in as an admin")
	public void iAmLogedInAsAnAdmin() throws IOException {
		app.login("Tayma", "123", "Admin");
        assertTrue(true);
	}
	@Test
	@Given("I am on the admin dashboard")
	public void iAmOnTheAdminDashboard() {
		 app.AdminDashboardpage();
	        assertTrue(app.adminDashbordOpen);
	}
	@Test
	@Given("I select {string} from the dashboard options")
	public void iSelectFromTheDashboardOptions(String string) {
		app.AdminDashboardOptiones("1");
	}
	@Test
	@Given("I am on the user management page")
	public void iAmOnTheUserManagementPage() {
		assertTrue(app.userManagementPageOpen);
	}
	@Test
	@When("I view the list of users")
	public void iViewTheListOfUsers() {
		app.viewAllUsers();
	}
	@Test
	@Then("I should see all users in the list")
	public void iShouldSeeAllUsersInTheList() {
		app.viewAllUsers();
	}
	@Test
	@When("I choose to add a new user and I enter the username {string} , password {string} , and role {string}")
	public void iChooseToAddANewUserAndIEnterTheUsernamePasswordAndRole(String username, String password, String role) {
		  app.addUser(username, password, role);
	}

	
	@Test
	@When("I submit the new user details")
	public void iSubmitTheNewUserDetails() {
		assertTrue(app.addedSuccessfully);
	}
	@Test
	@Then("I should see a success message {string}")
	public void iShouldSeeASuccessMessage(String message) {
		app.printMessage(message);
	}

}

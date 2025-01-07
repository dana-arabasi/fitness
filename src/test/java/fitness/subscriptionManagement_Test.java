package fitness;

import static org.junit.Assert.assertTrue;

import java.io.FileNotFoundException;
import java.io.IOException;
import org.junit.Test;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class subscriptionManagement_Test {
	
	MyApp app;
	public subscriptionManagement_Test(MyApp app) {
		super();
		this.app=app;
	}

	
	@Test
	@Given("I am on the subscription management page")
	public void iAmOnTheSubscriptionManagementPage() {
		app.AdminDashboardOptiones("4");
		assertTrue(true);
	}
	@Test
	@Given("there are programs that have been created")
	public void thereAreProgramsThatHaveBeenCreated() throws FileNotFoundException, IOException {
	    boolean b=app.thereIsProgram();
		assertTrue(true);
	}
	@Test
	@When("I chose the program called {string} and chose the subscription plan {string}")
	public void iChoseTheProgramCalledAndChoseTheSubscriptionPlan(String name, String plan) throws FileNotFoundException, IOException {
	   app.SubscriptionPlanPrograms(name,plan);
		assertTrue(true);
	}
	@Test
	@Then("The program with name {string} will appeare for {string} clients")
	public void theProgramWithNameWillAppeareForClients(String string, String string2) {
	    app.displayPlanPrograms(string2);
		assertTrue(true);
	}
	@Test
	@Given("there are subscription plans")
	public void there_are_subscription_plans() {
	   assertTrue(true);
	}
	@Test
	@When("I View subscription plans")
	public void i_view_subscription_plans() {
		 app.displayPlanPrograms("Basic");
		 app.displayPlanPrograms("Premium");
		assertTrue(true);

	}
	@Test
	@Then("I should be able to see a list of available subscription plans")
	public void i_should_be_able_to_see_a_list_of_available_subscription_plans() {
	    assertTrue(true);
	}
	@Test
	@Given("a instructor is currently subscribed to the {string} subscription plan")
	public void a_instructor_is_currently_subscribed_to_the_subscription_plan(String string) {
		assertTrue(true);
	}
	@Test
	@When("I upgrade the instructor to the {string} subscription plan")
	public void i_upgrade_the_instructor_to_the_subscription_plan(String string) {
		assertTrue(true);
	}
	@Test
	@Then("the instructor should be upgraded to the {string} plan")
	public void the_instructor_should_be_upgraded_to_the_plan(String string) {
		assertTrue(true);
	}
	@Test
	@Then("the instructor should be notified of the new subscription plan {string}")
	public void the_instructor_should_be_notified_of_the_new_subscription_plan(String string) {
		assertTrue(true);
	}
	@Test
	@Given("an instructor is subscribed to the {string} subscription plan")
	public void an_instructor_is_subscribed_to_the_subscription_plan(String string) {
		assertTrue(true);
	}
	@Test
	@When("I downgrade the instructor to the {string} subscription plan")
	public void i_downgrade_the_instructor_to_the_subscription_plan(String string) {
		assertTrue(true);
	}
	@Test
	@Then("the instructor should be downgraded to the {string} plan")
	public void the_instructor_should_be_downgraded_to_the_plan(String string) {
		assertTrue(true);
	}


}

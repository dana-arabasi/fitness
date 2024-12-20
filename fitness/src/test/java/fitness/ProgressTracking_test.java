package fitness;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ProgressTracking_test {
	
	MyApp app;
	 
	public ProgressTracking_test(MyApp app){
		super();
		this.app=app;
	}
	
	@Given("I am on the  Progress Tracking page")
	public void i_am_on_the_progress_tracking_page() {
		app.navigateTo("Progress Tracking page");
	}

	@When("I select a client {string}")
	public void i_select_a_client(String clientName) {
		// app.selectClient(clientName); 
	}

	@Then("I should see a detailed progress report")
	public void i_should_see_a_detailed_progress_report() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("I should have the option to download the report as a PDF")
	public void i_should_have_the_option_to_download_the_report_as_a_pdf() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Given("the client {string} has completed {int}% of the assigned tasks")
	public void the_client_has_completed_of_the_assigned_tasks(String string, Integer int1) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@When("I checks the {string} progress")
	public void i_checks_the_progress(String string) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("the system should display {string} for the client")
	public void the_system_should_display_for_the_client(String string) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("send a reminder message {string}")
	public void send_a_reminder_message(String string) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Given("the client {string} has only completed {int}% of their program")
	public void the_client_has_only_completed_of_their_program(String string, Integer int1) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@When("I review the progress")
	public void i_review_the_progress() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("the system should send a motivational reminder {string}")
	public void the_system_should_send_a_motivational_reminder(String string) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Given("the client {string} has attended {int} out of {int} sessions")
	public void the_client_has_attended_out_of_sessions(String string, Integer int1, Integer int2) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@When("I check the attendance records for {string}")
	public void i_check_the_attendance_records_for(String string) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("send a reminder to {string} about\" missing the last two sessions\"")
	public void send_a_reminder_to_about_missing_the_last_two_sessions(String string) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}



}

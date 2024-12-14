package fitness;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.util.Vector;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class UpdateProgram {
	 ProductionCode c;
	 Instructor instuctor;
	 FitnessProgram program;
	 Vector<FitnessProgram> programList;

	public UpdateProgram(ProductionCode c) {
		super();
		this.c=c;
		this.instuctor=new  Instructor();
	    this.program=new FitnessProgram();
	    this.programList = new Vector<>();
	}
	@When("the instructor leaves the program title empty")
	public void theInstructorLeavesTheProgramTitleEmpty() {
		program.enterProgramTitle(""); 
	    boolean fillTitle = program.isTitleFill();
	    assertFalse("The program title should not be filled", fillTitle);
	}

	@Then("the instructor should see an error message {string}")
	public void theInstructorShouldSeeAnErrorMessage(String string) {
		instuctor.setConfirmationMessage(string);
		 String confirmationMessage = instuctor.getConfirmationMessage();
		 assertEquals("The confirmation message should match", string, confirmationMessage);
	}

	@Then("the program should not be updated")
	public void theProgramShouldNotBeUpdated() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@When("the instructor leaves the duration empty")
	public void theInstructorLeavesTheDurationEmpty() {
		   program.enterProgramDuration(0); 
	       boolean fillDuration = program.isDurationFill();
	       assertFalse("The program duration should not be filled", fillDuration);
	}

	@When("the instructor leaves the goals field empty")
	public void theInstructorLeavesTheGoalsFieldEmpty() {
		program.enterProgramGoals(""); 
	    boolean fillGoals = program.isGoalsFill();
	    assertFalse("The goals should not be filled", fillGoals);
	}

	@When("the instructor leaves the media fields empty")
	public void theInstructorLeavesTheMediaFieldsEmpty() {
		program.uploadVideo("");
		program.uploadImage("");
		program.uploadDocument("");
	    boolean uploadVideo = program.isUploadVideo();
	    boolean uploadImage = program.isUploadImage();
	    boolean uploadDocument = program.isUploadDocument();
	    assertFalse("No media should be uploaded", uploadVideo || uploadImage || uploadDocument);
	}

	@When("the instructor uploads an invalid media file type \\(e.g., {string})")
	public void theInstructorUploadsAnInvalidMediaFileType_e_g(String string) {
		String invalidFilePath = "path/to/"+ string;
	    boolean uploadSuccess = program.uploadFile(invalidFilePath);
	    assertFalse("The system should reject files with invalid types", uploadSuccess);
	}

	@When("the instructor leaves the price field empty \\(if not required)")
	public void the_instructor_leaves_the_price_field_empty_if_not_required() {
		 program.setProgramPrice(0.0);
		 boolean setPrice = program.isTheProgramPriceSet();
		 assertFalse("The instructor did not set a price", setPrice);
	}

	@Then("the program should be updated successfully without a price")
	public void the_program_should_be_updated_successfully_without_a_price() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@When("the instructor leaves the group session schedule empty")
	public void the_instructor_leaves_the_group_session_schedule_empty() {
		 String sessionDate = ""; 
		 String sessionTime = ""; 
		 String sessionDescription=""; 
		 program.setGroupSessionSchedule(sessionDate, sessionTime,sessionDescription);
		 boolean setGroupSessionSchedule=program.isTheGroupSessionScheduleSet();
		 assertFalse("the instructor should not schedule the Group session  ",setGroupSessionSchedule);
	}

	@When("the instructor decides to cancel the changes")
	public void the_instructor_decides_to_cancel_the_changes() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("the instructor should be returned to the program list page without saving changes")
	public void the_instructor_should_be_returned_to_the_program_list_page_without_saving_changes() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@When("the instructor does not make any changes to the program details")
	public void the_instructor_does_not_make_any_changes_to_the_program_details() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("the instructor should see a message {string}")
	public void the_instructor_should_see_a_message(String string) {
		instuctor.setConfirmationMessage(string);
		 String confirmationMessage = instuctor.getConfirmationMessage();
		 assertEquals("The confirmation message should match", string, confirmationMessage);
	}

	@Then("the program should remain unchanged")
	public void the_program_should_remain_unchanged() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@When("the instructor leaves the difficulty level field empty")
	public void the_instructor_leaves_the_difficulty_level_field_empty() {
		program.selectDifficultyLevel(""); 
	    boolean fillDifficultyLevel = program.isDifficultyLevelFill();
	    assertFalse("The difficulty level should not be filled", fillDifficultyLevel);
	}

	@Then("the system should show an error message {string}")
	public void the_system_should_show_an_error_message(String string) {
		instuctor.setConfirmationMessage(string);
		 String confirmationMessage = instuctor.getConfirmationMessage();
		 assertEquals("The confirmation message should match", string, confirmationMessage);
	}


	@Given("the instructor has an existing program")
	public void the_instructor_has_an_existing_program() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@When("the instructor selects the program to edit")
	public void the_instructor_selects_the_program_to_edit() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@When("the instructor updates the program title, duration, difficulty level, goals, price,media or group sessions")
	public void the_instructor_updates_the_program_title_duration_difficulty_level_goals_price_media_or_group_sessions() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@When("the instructor saves the changes")
	public void the_instructor_saves_the_changes() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("the program should be updated successfully")
	public void the_program_should_be_updated_successfully() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@When("the instructor updates the price to {string}{int}")
	public void the_instructor_updates_the_price_to(String string, Integer int1) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}






}

package fitness;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Update_test {
	 
	MyApp app;
	 
	public Update_test(MyApp app){
		super();
		this.app=app;
	}
	
	
	@Given("I have an existing program")
	public void i_have_an_existing_program() {
	   assertTrue(app.programListNotEmpty());
	}

	@Given("I am  on the program management page")
	public void i_am_on_the_program_management_page() {
		app.navigateTo(" Program ManagementDashboard");
	}

	@When("I select update {string} and choose  the program with title {string} to edit and update title to {string} , duration {string}, difficulty level {string}, goals {string},\\(video tutorials {string}, images {string}, or documents  {string} ) or price {string} .")
	public void i_select_update_and_choose_the_program_with_title_to_edit_and_update_title_to_duration_difficulty_level_goals_video_tutorials_images_or_documents_or_price1(String action, String searchTitle, String UpdatedTitle, String duration, String level, String goals, String videoPath, String imagePath, String documentPath, String price) {
		if (action.equals("Edit")) {
			app.editProgram(searchTitle,UpdatedTitle, duration,  level,  goals,  videoPath, imagePath,  documentPath,  price);
		    }
	}

	@Then("i submit")
	public void i_submit() {
		 assertTrue(true);
	}

	@Then("the program should be updated successfully")
	public void the_program_should_be_updated_successfully() {
		 assertTrue(app.programUpdationSuccess());
	}

	@Then("the program should not be updated")
	public void the_program_should_not_be_updated() {
		assertEquals("Program update failed as expected.", app.getMessage());
	}

	@When("I select update {string} and choose  the program with title {string} to edit and update title to {string} , duration {string}, difficulty level {string}, goals {string},\\(video tutorials  {string}, images  {string}, or documents   {string} ) or price {string} .")
	public void i_select_update_and_choose_the_program_with_title_to_edit_and_update_title_to_duration_difficulty_level_goals_video_tutorials_images_or_documents_or_price11(String action, String searchTitle, String UpdatedTitle, String duration, String level, String goals, String videoPath, String imagePath, String documentPath, String price) {
		if (action.equals("Edit")) {
			app.editProgram(searchTitle,UpdatedTitle, duration,  level,  goals,  videoPath, imagePath,  documentPath,  price);
		    }
	}




	@When("I select update {string} and choose  the program with title {string} to edit and update title to {string} , duration {string}, difficulty level {string}, goals {string},\\(video tutorials {string}, images {string}, or documents  {string} ) or price {string}.")
	public void i_select_update_and_choose_the_program_with_title_to_edit_and_update_title_to_duration_difficulty_level_goals_video_tutorials_images_or_documents_or_price(String action, String searchTitle, String UpdatedTitle, String duration, String level, String goals, String videoPath, String imagePath, String documentPath, String price)  {
		if (action.equals("Edit")) {
			
			app.editProgram(searchTitle,UpdatedTitle, duration,  level,  goals,  videoPath, imagePath,  documentPath,  price);
		    }
	}}


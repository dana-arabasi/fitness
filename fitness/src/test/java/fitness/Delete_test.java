package fitness;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Delete_test {
 
	MyApp app;
	 
	public Delete_test(MyApp app){
		super();
		this.app=app;
	}
	
	
	
	@When("I select delete {string} and choose the program with title  {string} to delete")
	public void iSelectDeleteAndChooseTheProgramWithTitleToDelete(String delete, String programTitle) {
		 if (delete.equals("Delete")) {
				app.deleteProgram(programTitle);
			}
	}
	
	@Then("the program should be deleted successfully")
	public void theProgramShouldBeDeletedSuccessfully() {
		 assertTrue(app.programDeletionSuccess());
	}
	
	
	}





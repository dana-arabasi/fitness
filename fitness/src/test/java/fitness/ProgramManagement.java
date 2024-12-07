package fitness;

import static org.junit.Assert.assertTrue;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ProgramManagement {
	 ProductionCode c;
	 Instructor instuctor;
	 FitnessProgram program;

	public ProgramManagement(ProductionCode c) {
		super();
		this.c=c;
		this.instuctor=new  Instructor();
	    this.program=new FitnessProgram();
	}

	@Given("I am logged in as an instructor")
	 public void iAmLoggedInAsAnInstructor() {
	 instuctor.login();
	 boolean loginSuccess = instuctor.isLogedIn();
	 assertTrue("Instructor should be logged in", loginSuccess);
	 
	}
	
	@Given("the instructor is on the program management page")
	  public void theInstructorIsOnTheProgramManagementPage() {
	  instuctor.OnProgramManagementPage();
	  boolean onPage = instuctor.isOnProgramManagementPage();
      assertTrue("Instructor should be on the program management page", onPage);
		
	}
	@When("the instructor enters the program title, duration, difficulty level, and goals")
	public void theInstructorEntersTheProgramTitleDurationDifficultyLevelAndGoals() {
		String title = "Beginner Yoga";
	    int duration = 30; 
	    String difficultyLevel = "Easy";
	    String goals = "Improve flexibility and reduce stress";
	    
	    program.enterProgramTitle(title);
	    program.enterProgramDuration(duration);
	    program.selectDifficultyLevel(difficultyLevel);
	    program.enterProgramGoals(goals);
	    boolean fillTitle=program.isTitleFill();
	    boolean fillDuration=program.isDurationFill();
	    boolean fillDifficultyLevel=program.isDifficultyLevelFill();
	    boolean fillGoals=program.isGoalsFill();
	    
	    assertTrue("Instructor should fill the title ",fillTitle);
	    assertTrue("Instructor should fill the duration ",fillDuration); 
	    assertTrue("Instructor should fill the difficulty level ",fillDifficultyLevel); 
	    assertTrue("Instructor should fill thegoals ",fillGoals); 
	}
	@When("the instructor uploads video tutorials, images, or documents")
	public void theInstructorUploadsVideoTutorialsImagesOrDocuments() {
		 String videoPath = "path/to/video.mp4";
		    String imagePath = "path/to/image.jpg";
		    String documentPath = "path/to/document.pdf";
		    program.uploadVideo(videoPath);
		    program.uploadImage(imagePath);
		    program.uploadDocument(documentPath);
		    boolean uploadVideo= program.isUploadVideo();
		    boolean uploadImage= program.isUploadImage();
		    boolean uploadDocument= program.isUploadDocument();
		    assertTrue("Instructor should fill the title ",uploadVideo||uploadImage||uploadDocument);
		    
	}
	@When("the instructor sets a price for the program if applicable")
	public void theInstructorSetsAPriceForTheProgramIfApplicable() {
		double price = 19.99; 
		program.setProgramPrice(price);
		boolean setPrice=program.isTheProgramPriceSet();
		 assertTrue("the instructor does not set a price ",setPrice);

	}
	@When("the instructor sets the schedule for group sessions")
	public void theInstructorSetsTheScheduleForGroupSessions() {
		
		 String sessionDate = "2023-12-15"; 
		 String sessionTime = "10:00 AM"; 
		 String sessionDescription="in-person"; 
		 program.setGroupSessionSchedule(sessionDate, sessionTime,sessionDescription);
		 boolean setGroupSessionSchedule=program.isTheGroupSessionScheduleSet();
		 assertTrue("the instructor should schedule the Group session  ",setGroupSessionSchedule);
	  
	}
	@Then("the program should be created successfully")
	public void theProgramShouldBeCreatedSuccessfully() {
	    
	}
	@Then("the instructor should see a confirmation message {string}")
	public void theInstructorShouldSeeAConfirmationMessage(String string) {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}
	@Then("the program should appear in the program list")
	public void theProgramShouldAppearInTheProgramList() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}



}

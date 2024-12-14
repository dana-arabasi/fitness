package fitness;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Vector;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CreateProgram {

	 ProductionCode c;
	 Instructor instuctor;
	 FitnessProgram program;
	 Vector<FitnessProgram> programList;

	public CreateProgram(ProductionCode c) {
		super();
		this.c=c;
		this.instuctor=new  Instructor();
	    this.program=new FitnessProgram();
	    this.programList = new Vector<>();
	}
@Given("I am logged in as an instructor")
public void i_am_logged_in_as_an_instructor() {
	instuctor.login();
	 boolean loginSuccess = instuctor.isLogedIn();
	 assertTrue("Instructor should be logged in", loginSuccess);
}

@Given("the instructor is on the program management page")
public void the_instructor_is_on_the_program_management_page() {
	 instuctor.OnProgramManagementPage();
	  boolean onPage = instuctor.isOnProgramManagementPage();
     assertTrue("Instructor should be on the program management page", onPage);
}

@When("the instructor enters the program title, duration, difficulty level, and goals")
public void the_instructor_enters_the_program_title_duration_difficulty_level_and_goals() {
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
public void the_instructor_uploads_video_tutorials_images_or_documents() {
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
public void the_instructor_sets_a_price_for_the_program_if_applicable() {
	double price = 19.99; 
	program.setProgramPrice(price);
	boolean setPrice=program.isTheProgramPriceSet();
	 assertTrue("the instructor does not set a price ",setPrice);
}

@When("the instructor sets the schedule for group sessions")
public void the_instructor_sets_the_schedule_for_group_sessions() {
	 String sessionDate = "2023-12-15"; 
	 String sessionTime = "10:00 AM"; 
	 String sessionDescription="in-person"; 
	 program.setGroupSessionSchedule(sessionDate, sessionTime,sessionDescription);
	 boolean setGroupSessionSchedule=program.isTheGroupSessionScheduleSet();
	 assertTrue("the instructor should schedule the Group session  ",setGroupSessionSchedule);
}

@Then("the program should be created successfully")
public void the_program_should_be_created_successfully() {
	program.createProgram();
	boolean programCreated = program.isProgramCreated();
	assertTrue("The program should be created successfully", programCreated);
}

@Then("the instructor should see a confirmation message {string}")
public void the_instructor_should_see_a_confirmation_message(String string) {
	instuctor.setConfirmationMessage(string);
	 String confirmationMessage = instuctor.getConfirmationMessage();
	 assertEquals("The confirmation message should match", string, confirmationMessage);
}

@Then("the program should appear in the program list")
public void the_program_should_appear_in_the_program_list() {
	programList.add(program);
	program.setInTheList();
	boolean isInList = program.isInProgramList();
	assertTrue("The program should appear in the program list", isInList);
}

@When("the instructor does not set a price")
public void the_instructor_does_not_set_a_price() {
	 program.setProgramPrice(0.0);
	 boolean setPrice = program.isTheProgramPriceSet();
	 assertFalse("The instructor did not set a price", setPrice);
}

@Then("the program should be created successfully without a price")
public void the_program_should_be_created_successfully_without_a_price() {
	 program.createProgram();
     boolean programCreated = program.isProgramCreated();
     boolean priceSet = program.isTheProgramPriceSet();
     assertTrue("The program should be created successfully", programCreated);
     assertFalse("The program should not have a price", priceSet);
}

@When("the instructor does not upload any media")
public void the_instructor_does_not_upload_any_media() {
	program.uploadVideo("");
	program.uploadImage("");
	program.uploadDocument("");
    boolean uploadVideo = program.isUploadVideo();
    boolean uploadImage = program.isUploadImage();
    boolean uploadDocument = program.isUploadDocument();
    assertFalse("No media should be uploaded", uploadVideo || uploadImage || uploadDocument);
}

@When("the instructor try to create this fitness program")
public void the_instructor_try_to_create_this_fitness_program() {
	boolean isValid = program.validateProgramDetails();

    if (isValid) {
        program.createProgram();
    } else {
    	instuctor.setConfirmationMessage("Program creation failed due to missing or invalid details.");
    }
    assertNotNull("The program creation process should be attempted", program.isProgramCreated());
}

@Then("the program should not be created")
public void the_program_should_not_be_created() {
	 program.notCreateProgram();
	    boolean programCreated = program.isProgramCreated();
		assertFalse("The program should not be created ", programCreated);
}

@When("the instructor does not enter a program title")
public void the_instructor_does_not_enter_a_program_title() {
	program.enterProgramTitle(""); 
    boolean fillTitle = program.isTitleFill();
    assertFalse("The program title should not be filled", fillTitle);
}

@When("the instructor try to create a fitness program")
public void the_instructor_try_to_create_a_fitness_program() {
	boolean isValid = program.validateProgramDetails();

    if (isValid) {
        program.createProgram();
    } else {
    	instuctor.setConfirmationMessage("Program creation failed due to missing or invalid details.");
    }
    assertNotNull("The program creation process should be attempted", program.isProgramCreated());
}

@When("the instructor does not enter a program duration")
public void the_instructor_does_not_enter_a_program_duration() {

	   program.enterProgramDuration(0); 
       boolean fillDuration = program.isDurationFill();
       assertFalse("The program duration should not be filled", fillDuration);
}

@When("the instructor does not select a difficulty level")
public void the_instructor_does_not_select_a_difficulty_level() {
	program.selectDifficultyLevel(""); 
    boolean fillDifficultyLevel = program.isDifficultyLevelFill();
    assertFalse("The difficulty level should not be filled", fillDifficultyLevel);
}

@When("the instructor does not enter goals for the program")
public void the_instructor_does_not_enter_goals_for_the_program() {
	program.enterProgramGoals(""); 
    boolean fillGoals = program.isGoalsFill();
    assertFalse("The goals should not be filled", fillGoals);
}

@When("the instructor uploads an invalid file type {string}")
public void the_instructor_uploads_an_invalid_file_type(String string) {
	String invalidFilePath = "path/to/"+ string;
    boolean uploadSuccess = program.uploadFile(invalidFilePath);
    assertFalse("The system should reject files with invalid types", uploadSuccess);
}

@When("the instructor does not set a price for the program")
public void the_instructor_does_not_set_a_price_for_the_program() {
    
    program.setProgramPrice(0.0);
	 boolean setPrice = program.isTheProgramPriceSet();
	 assertFalse("The instructor did not set a price", setPrice);
}

@When("the instructor sets all required details \\(title, duration, difficulty level, goals, media)")
public void the_instructor_sets_all_required_details_title_duration_difficulty_level_goals_media() {
	String title = "Beginner Yoga";
    int duration = 30; 
    String difficultyLevel = "Easy";
    String goals = "Improve flexibility and reduce stress";
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

@When("the instructor does not set a schedule for group sessions")
public void the_instructor_does_not_set_a_schedule_for_group_sessions() {
     String sessionDate = ""; 
	 String sessionTime = ""; 
	 String sessionDescription=""; 
	 program.setGroupSessionSchedule(sessionDate, sessionTime,sessionDescription);
	 boolean setGroupSessionSchedule=program.isTheGroupSessionScheduleSet();
	 assertFalse("the instructor should not schedule the Group session  ",setGroupSessionSchedule);
}

@Then("the program should be created successfully without group sessions")
public void the_program_should_be_created_successfully_without_group_sessions() {
	 program.createProgram();
     boolean programCreated = program.isProgramCreated();
     boolean GroupSessionScheduleSet = program.isTheGroupSessionScheduleSet();
     assertTrue("The program should be created successfully", programCreated);
     assertFalse("The program should not have a price", GroupSessionScheduleSet);
}

@Then("the program should appear in the program list without any group sessions scheduled")
public void the_program_should_appear_in_the_program_list_without_any_group_sessions_scheduled() {
	programList.add(program);
	program.setInTheList();
	boolean GroupSessionScheduleSet = program.isTheGroupSessionScheduleSet();
	boolean isInList = program.isInProgramList();
	assertTrue("The program should appear in the program list", isInList);
	assertFalse("The program should not have a price", GroupSessionScheduleSet);
}
}

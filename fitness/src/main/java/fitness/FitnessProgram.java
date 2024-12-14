package fitness;

import java.util.Arrays;
import java.util.List;

public class FitnessProgram {
	private String title;
	private int duration;
	private String difficultyLevel;
	private String goals;
	private String video;
	private String image;
	private String document;
	private double price;
	private String sessionDate;
	private String sessionDescription;
	private String sessionTime;
	private int isProgramCreated;
	private boolean isInTheList;
	
 
	public FitnessProgram() {
		 title="";
		 duration=0;
		 difficultyLevel="";
		 goals="";
		 video="";
		 image="";
		 document="";
		 price=0.0;
		 sessionDate="";
		 sessionDescription="";
		 sessionTime="";
		 isProgramCreated=0;
		 isInTheList=false;
	} 
	public void enterProgramTitle(String title) {
	 
		this.title=title;
		
	}
	public void enterProgramDuration(int duration) {
		 
		this.duration=duration;
		
	}
	public void selectDifficultyLevel(String difficultyLevel2) {
		 
		difficultyLevel=difficultyLevel2;
		
	}
	public void enterProgramGoals(String goals2) {
		
		goals=goals2;
		
	}
	public boolean isTitleFill() {
		if(title.isEmpty())
		return false;
		else 
		return true;
	}
	public boolean isDurationFill() {
		if(duration==0)
		return false;
		else
		return true;
		
	}
	public boolean isDifficultyLevelFill() {
		if(difficultyLevel.isEmpty())
		return false;
		else
		return true;
	}
	public boolean isGoalsFill() {
		if(goals.isEmpty())
			return false;
			else
			return true;		
	}
	public void uploadVideo(String videoPath) {
		 
		 video = videoPath;
		
	}
	public void uploadImage(String imagePath) {
		
		image=imagePath;
	}
	public void uploadDocument(String documentPath) {
		
		document=documentPath;
	}
	public boolean isUploadVideo() {
		
		if(video.isEmpty())
			return false;
		else
			return true;
	}
	public boolean isUploadImage() {
		if(image.isEmpty())
			return false;
		else
			return true;
	}
	public boolean isUploadDocument() {
		if(document.isEmpty())
			return false;
		else
			return true;
	}
	public void setProgramPrice(double price) {
	 this.price=price;
		
	}
	public boolean isTheProgramPriceSet() {
		if(price==0)
		  return false;
		else
		  return true;
	}
	public void setGroupSessionSchedule(String sessionDate, String sessionTime, String sessionDescription) {
		
		this.sessionDate=sessionDate;
		this.sessionTime=sessionTime;
		this.sessionDescription=sessionDescription;
		
	}
	public boolean isTheGroupSessionScheduleSet() {
		if(sessionDate.isEmpty()||sessionTime.isEmpty()||sessionDescription.isEmpty())
		   return false;
		else
		   return true;	 
		
	}
	public boolean isProgramCreated() {
		if(this.isProgramCreated==1)
			return true;
		else
		return false;
	}
	public void setInTheList() {
		this.isInTheList=true;
		
	}
	public boolean isInProgramList() {
		if(this.isInTheList)
			return true;
		else
		return false;
	}
	public void createProgram() {
		this.isProgramCreated=1;
		
	}
	public boolean validateProgramDetails() {
		if(isTitleFill()&&isDurationFill()&&isDifficultyLevelFill()&&isGoalsFill()&&(isUploadVideo()||isUploadImage()||isUploadDocument()))
		return true;
		else 
			return false;
	}
	public void notCreateProgram() {
		this.isProgramCreated=0;
		
	}
	public boolean uploadFile(String invalidFilePath) {
		 String fileExtension = getFileExtension(invalidFilePath);
	        List<String> allowedFileTypes = Arrays.asList("mp4", "jpg", "png", "pdf");
	        if (allowedFileTypes.contains(fileExtension.toLowerCase())) {
	            // Simulate successful upload
	            return true;
	        } else {
	          
	            return false;
	        }
	}
	
	  private String getFileExtension(String filePath) {
	        int lastDotIndex = filePath.lastIndexOf(".");
	        if (lastDotIndex == -1 || lastDotIndex == filePath.length() - 1) {
	            return ""; // No extension found
	        }
	        return filePath.substring(lastDotIndex + 1);
	    }
	

}

package fitness;

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
	
 
	public FitnessProgram() {
		 title="";
		 duration=0;
		 difficultyLevel="";
		 goals="";
		 video="";
		 image="";
		 document="";
		 price=0;
		 sessionDate="";
		 sessionDescription="";
		 sessionTime="";
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
	
	
	

}

package fitness;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

public class ProgramCatalog {
	private List<Program> programs = new ArrayList<Program>();
    private Map<String, Boolean> userEnrollments = new HashMap<String, Boolean>();
	
	
    public ProgramCatalog() {
        programs.add(new Program("Weightlifting for Beginners", "Beginner", "Muscle Building", "12 weeks", "Build strength and muscle","Mon/Wed/Fri - 7:00 PM"));
        programs.add(new Program("Yoga for Flexibility", "Beginner", "Flexibility", "8 weeks", "Improve flexibility and balance","Mon/Wed/Fri - 8:00 PM"));
        programs.add(new Program("Intermediate Strength Training", "Intermediate", "Muscle Building", "16 weeks", "Increase strength and endurance","Mon/Wed/Fri - 10:00 PM"));
        programs.add(new Program("Advanced Yoga", "Advanced", "Flexibility", "12 weeks", "Master advanced yoga poses","Mon/Wed/Fri - 11:00 PM"));
    }
	
    public List<Program> getPrograms() {
        return programs;
    }

    public List<Program> filterPrograms(String difficulty, String focusArea) {
        List<Program> filteredPrograms = new ArrayList<Program>(programs);

        if (difficulty != null && !difficulty.isEmpty()) {
            List<Program> tempFilteredPrograms = new ArrayList<Program>();
            for (Program p : filteredPrograms) {
                if (p.getDifficulty().equalsIgnoreCase(difficulty)) {
                    tempFilteredPrograms.add(p);
                }
            }
            filteredPrograms = tempFilteredPrograms;
        }

        if (focusArea != null && !focusArea.isEmpty()) {
            List<Program> tempFilteredPrograms = new ArrayList<Program>();
            for (Program p : filteredPrograms) {
                if (p.getFocusArea().equalsIgnoreCase(focusArea)) {
                    tempFilteredPrograms.add(p);
                }
            }
            filteredPrograms = tempFilteredPrograms;
        }

        System.out.println("Filtered programs: " + filteredPrograms);
        return filteredPrograms;
    }

    public boolean enrollUser(String userId, String programName) {
        Program program = findProgramByName(programName);
        if (program != null) {
            program.addUser(userId); // Add user to the program's enrolledUsers list
            userEnrollments.put(userId + ":" + programName, true); 
            System.out.println("User " + userId + " enrolled in: " + programName);
            return true;
        } else {
            System.out.println("Program not found: " + programName);
            return false;
        }
    }
    public boolean isUserEnrolled(String userId, String programName) {
        // First check the userEnrollments map
        if (userEnrollments.getOrDefault(userId + ":" + programName, true)) {
            return true;
        }
        Program program = findProgramByName(programName);
        if (program != null) {
            return program.getEnrolledUsers().contains(userId);
        }

        return false;
        
    }

    private Program findProgramByName(String name) {
        for (Program program : programs) {
            if (program.getName().equals(name)) {
                return program;
            }
        }
        return null;
    }
	
	
	class Program {
		 private String name;
	        private String difficulty;
	        private String focusArea;
	        private String duration;
	        private String description;
	        private String schedule;
	        private List<String> enrolledUsers;

	        public Program(String name, String difficulty, String focusArea, String duration, String description, String schedule) {
	            this.name = name;
	            this.difficulty = difficulty;
	            this.focusArea = focusArea;
	            this.duration = duration;
	            this.description = description;
	            this.schedule = schedule;
	            this.enrolledUsers = new ArrayList<String>();
	        }

	        public String getName() {
	            return name;
	        }

	        public String getDifficulty() {
	            return difficulty;
	        }

	        public String getFocusArea() {
	            return focusArea;
	        }

	        public String getDuration() {
	            return duration;
	        }

	        public String getDescription() {
	            return description;
	        }

	        public String getSchedule() {
	            return schedule;
	        }

	        public void addUser(String userId) {
	            enrolledUsers.add(userId);
	        }

	        public List<String> getEnrolledUsers() {
	            return enrolledUsers;
	        }

	        @Override
	        public String toString() {
	            return "Program{name='" + name + "', difficulty='" + difficulty + "', focusArea='" + focusArea + "', duration='" + duration + "', description='" + description + "', schedule='" + schedule + "'}";
	        }
	    
	    
    }


	public Program getProgramByName(String programName) {
		for (Program program : programs) {
	        if (program.getName().equals(programName)) {
	            return program;
	        }
	    }
	    return null;
	}

		
	

	
	
	

} 


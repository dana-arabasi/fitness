package fitness;

public class User {
	 private Object id; 
    private int age;
    private String fitnessGoals;
    private String dietaryPreferences;
    private boolean isDeleted;
    private boolean isLoggedOut;

    public User() {
        this.id = null;
    }
    

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getFitnessGoals() {
        return fitnessGoals;
    }

    public void setFitnessGoals(String fitnessGoals) {
        this.fitnessGoals = fitnessGoals;
    }

    public String getDietaryPreferences() {
        return dietaryPreferences;
    }

    public void setDietaryPreferences(String dietaryPreferences) {
        this.dietaryPreferences = dietaryPreferences;
    }
    
    public Object getId() {
        return id;
    }

    
    public void setId(String id) {
        this.id = id;
    }


    
    public String createAccount() {
        if (age <= 0) {
          
            return "Invalid age.";
        }
        if (fitnessGoals == null || fitnessGoals.isEmpty()) {
          
            return "Invalid fitness goals.";
        }
        if (dietaryPreferences == null || dietaryPreferences.isEmpty()) {
          
            return "Invalid dietary preferences.";
        }
        this.id = generateId();
        return "Profile created successfully!";
    }

    private Object generateId() {
		
    	return (int) (Math.random() * 10000);
	}

	
    public String updateDietaryPreferences() {
        if (dietaryPreferences == null || dietaryPreferences.isEmpty()) {
            
            return "Invalid dietary preferences.";
        }
        return "Dietary preferences updated successfully!";
    }

	public void deleteAccount() {
		
		 isDeleted = true;
		 logout();
		
	}

	public String confirmDeleteAccount() {
		
		if (isDeleted) {
            return "Account deleted successfully.";  
        } else {
            return "Account deletion failed."; 
        }
	}

	public boolean isDeleted() {
		
		return isDeleted;
	}
	
	 public void logout() {
	        isLoggedOut = true;
	    }

	public boolean isLoggedOut() {
		
		 return isLoggedOut;
	}

	
}




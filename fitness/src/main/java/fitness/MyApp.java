package fitness;



import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MyApp {

	private static final String FILE_ADMIN = "files/admin.txt";
	private static final String FILE_CLIENT = "files/clients.txt";
	private static final String FILE_INSTRUCTOR = "files/instructors.txt";
	
	private boolean isUserLoggedIn;
	private boolean AdminLoggedIn;
	public ArrayList<Admin> admin;
	public ArrayList<Instructor>instructors;
	public ArrayList<Client>clients;
	private String loggedName;
	private String loggedPassword;
	private String ROLE;
	private boolean UserLoggedIn;
	private boolean userDashOpen;
	
	public boolean InstructorLoggedIn;
	private String currentPage;
	private boolean clientLoggedIn;
	private ArrayList<Program> Programs;
	private String lastMessage;
	private Program currentProgram;
	public Client client;
	private boolean updateMessage;
	private Program updatedProgram;
	private boolean deletedProductSuccessfully;
	
	
	   public MyApp() throws FileNotFoundException, IOException {
	        super();
	        this.client = new Client();
	        this.client.setApp(this);
	    
	        this.clients = new ArrayList<>();
	        this.instructors = new ArrayList<>();
	        this.admin = new ArrayList<>();
	        this.Programs = new ArrayList<>();
	        

	        loadData(FILE_CLIENT, "client");
	        loadData(FILE_INSTRUCTOR, "instructor");
	        loadData(FILE_ADMIN, "Admin");
	        loadPrograms();
	        //   loadOrders();
	    }
	   
	   private void loadData(String fileName, String role) {
	        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
	            String line;
	            while ((line = br.readLine()) != null) {
	                String[] parts = line.split(",");
	                if (parts.length == 2) {
	                    String name = parts[0];
	                    String password = parts[1];
	                    addRole(name, password, role);
	                }
	            }
	        } catch (IOException e) {
	            // e.printStackTrace();
	        }
	    }
	   private void addRole(String name, String password, String role) {
	        switch (role) {
	            case "client":
	                this.clients.add(new Client (name, password));
	                break;
	            case "instructor":
	                this.instructors.add(new Instructor(name, password));
	                break;
	            case "Admin":
	                this.admin.add(new Admin(name, password));
	                break;
	            default:
	                //System.err.println("Error: Unrecognized role '" + role + "'.");
	                break;
	        }
	    }
	   
	   private void loadPrograms() throws FileNotFoundException, IOException {
	        try (BufferedReader br = new BufferedReader(new FileReader("files/programs.txt"))) {
	            String line;
	            while ((line = br.readLine()) != null) {
	                String[] parts = line.split(",");
	                if (parts.length == 8) {
	                    String title = parts[0];
	                    String duration = parts[1];
	                    String level = parts[2];
	                    String goals=parts[3];
	                    String videoPath=parts[4];
	                    String imagePath=parts[5];
	                    String documentPath=parts[6];
	                    String price=parts[7];
	                    Program a = new Program(title, duration, level, goals, videoPath, imagePath, documentPath, price);
	                    Programs.add(a);
	                }
	            }
	        }
	    }
	
		public void login(String username, String password, String role) {
		 boolean found = false;
	        switch (role) {
	            case "Client":
	                found = loginClient(username, password);
	                break;
	            case "Instructor":
	                found = loginInstructor(username, password);
	                break;
	            case "Admin":
	                found = loginAdmin(username, password);
	                break;
	            default:
	                System.err.println("Error: Unrecognized role '" + role + "'");
	                throw new IllegalArgumentException("Invalid role: " + role);
	        }
	        if (found) {
	            openUserDash();
	            loggedName = username;
	            ROLE = role;
	            loggedPassword = password;
	        }
	}

	private void openUserDash() {
		if (!UserLoggedIn) return;
        userDashOpen = true;
        System.out.println("Welcome user");
		
	}

	private boolean loginAdmin(String username, String password) {
		 for (Admin a : admin) {
	            if (a.getUsername().equals(username) && a.getPassword().equals(password)) {
	                isUserLoggedIn = true;
	                AdminLoggedIn = true;
	                return true;
	            }
	        }
	        return false;
	}

	private boolean loginInstructor(String username, String password) {
		for (Instructor a : instructors) {
            if (a.getUsername().equals(username) && a.getPassword().equals(password)) {
                isUserLoggedIn = true;
                InstructorLoggedIn = true;
                return true;
            }
        }
        return false;
	}

	private boolean loginClient(String username, String password) {
		for (Client a : clients) {
            if (a.getUsername().equals(username) && a.getPassword().equals(password)) {
                isUserLoggedIn = true;
                clientLoggedIn = true;
                return true;
            }
        }
        return false;
	}

	public void navigateTo(String page) {
		 if (InstructorLoggedIn ||AdminLoggedIn) {
	            currentPage = page;
	        } else {
	            throw new AssertionError("User not logged in or invalid user role.");
	        }
		
	}

	public void CreateProgram(String title, String duration, String level, String goals, String videoPath, String imagePath, String documentPath, String price) {
		if (title.isEmpty() || duration.isEmpty() || level.isEmpty() || goals.isEmpty()) {
	        lastMessage = "All required fields must be filled.";
	        currentProgram = null;
	        return;
	    }
	    if (videoPath.isEmpty() && imagePath.isEmpty() && documentPath.isEmpty()) {
	        lastMessage = "At least one media file (video, image, or document) is required";
	        currentProgram = null;
	        return;
	    }
	    if(price.contains("-")) {
	    	lastMessage= "Price must be a valid positive amount";	
	    	 return;
	    }
	    
	    String videoExtension = getFileExtension(videoPath);
	    String imageExtension = getFileExtension(imagePath);
	    String docExtension = getFileExtension(documentPath);
        List <String> allowedFileTypes = Arrays.asList("mp4", "jpg", "png", "pdf");

        if ((!videoPath.isEmpty() && !allowedFileTypes.contains(videoExtension.toLowerCase())) ||
            (!imagePath.isEmpty() && !allowedFileTypes.contains(imageExtension.toLowerCase())) ||
            (!documentPath.isEmpty() && !allowedFileTypes.contains(docExtension.toLowerCase()))) {
            lastMessage = "Invalid file format";
            currentProgram = null;
            return;
        }

	    currentProgram = new Program(title, duration, level, goals, videoPath, imagePath, documentPath, price);
	    Programs.add( currentProgram);
	    lastMessage = "Program created successfully";
	        rewriteFile("files/Programs.txt", Programs);  
	}
	
	private String getFileExtension(String filePath) {
        int lastDotIndex = filePath.lastIndexOf(".");
        if (lastDotIndex == -1 || lastDotIndex == filePath.length() - 1) {
            return ""; // No extension found
        }
        return filePath.substring(lastDotIndex + 1);
    }
	private void rewriteFile(String filePath, ArrayList<?> list) {
		 try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, false))) {
	            for (Object obj : list) {
	                if (obj instanceof Client) {
	                    writer.write(((Client) obj).getUsername() + "," + ((Client) obj).getPassword());
	                } else if (obj instanceof Instructor) {
	                    writer.write(((Instructor) obj).getUsername() + "," + ((Instructor) obj).getPassword());
	                } else if (obj instanceof Admin) {
	                    writer.write(((Admin) obj).getUsername() + "," + ((Admin) obj).getPassword());
	                } else if (obj instanceof Program) {
	                    writer.write(((Program) obj).getTitle() + "," + ((Program) obj).getDuration() + "," + ((Program) obj).getLevel() + "," +((Program) obj).getGoals()+ "," +((Program) obj).getVedioPath()+ "," +((Program) obj).getImagePath()+ "," +((Program) obj).getDocumentPath()+ "," +((Program) obj).getPrice() );
	                
	                }
	                writer.newLine();
	            }
	        } catch (IOException e) {
	            // System.err.println("An error occurred while rewriting the file: " + filePath + " " + e.getMessage());
	        }
		
	}

	public void editProgram(String searchtitle,String title, String duration, String level, String goals, String videoPath, String imagePath, String documentPath, String price ) {
		 String updatedline = title + "," + duration + "," + level +"," +goals +"," + videoPath +"," + imagePath +"," + documentPath +"," +price;
		 try {
			 if (title.isEmpty() || duration.isEmpty() || level.isEmpty() || goals.isEmpty()) {
		        lastMessage = "Program update failed as expected.";
		        
		        return;
		    }
		    if (videoPath.isEmpty() && imagePath.isEmpty() && documentPath.isEmpty()) {
		        lastMessage =  "Program update failed as expected.";
		       
		        return;
		    }
		    if(price.contains("-")) {
		    	lastMessage= "Program update failed as expected.";	
		    	 return;
		    }
		    
		    String videoExtension = getFileExtension(videoPath);
		    String imageExtension = getFileExtension(imagePath);
		    String docExtension = getFileExtension(documentPath);
	        List <String> allowedFileTypes = Arrays.asList("mp4", "jpg", "png", "pdf");

	        if ((!videoPath.isEmpty() && !allowedFileTypes.contains(videoExtension.toLowerCase())) ||
	            (!imagePath.isEmpty() && !allowedFileTypes.contains(imageExtension.toLowerCase())) ||
	            (!documentPath.isEmpty() && !allowedFileTypes.contains(docExtension.toLowerCase()))) {
	            lastMessage = "Program update failed as expected.";
	            
	            return;
	        }
	            List<String> lines = Files.readAllLines(Paths.get("files/programs.txt"));
	            List<String> updatedLines = new ArrayList<>();
	            for (String line : lines) {
	                if (line.contains(searchtitle)) {
	                	
	                    updatedLines.add(updatedline); // Replace the line
	                    updateMessage = true;
	            	    lastMessage = "Program updated successfully";

	                } else {
	                    updatedLines.add(line); // Keep the line unchanged
	                }
	            }
	            Files.write(Paths.get("files/programs.txt"), updatedLines);
	            System.out.println("File has been updated successfully.");
	        } catch (IOException e) {
	            //  e.printStackTrace();
	        }
	}

	public boolean isProgramInList(String name) {
		  for (Program product : Programs) {
	            if (product.getTitle().equals(name)) {
	                return true;
	            }
	        }
	        return false;
	}

	public boolean submitDetails() {
		if (isFormValid()) {
	       
	        System.out.println("Details submitted successfully.");
	        return true;
	    } else {
	        System.out.println("Details submission failed.");
	        return false;
	    }
	}
	
	private boolean isFormValid() {
	   
	    return !(currentProgram.getTitle().isEmpty() || currentProgram.getDuration().isEmpty() || 
	             currentProgram.getLevel().isEmpty() || currentProgram.getGoals().isEmpty());
	}

	public boolean programCreationSuccess() {
		if (currentProgram != null && Programs.contains(currentProgram)) {
	        System.out.println("Program created successfully.");
	        return true;
	    }
	    System.out.println("Program creation failed.");
	    return false;
	}

	public String getMessage() {
		 return lastMessage; 
	}
	
	public String getCurrentUsername() {
        return loggedName;
    }

	public boolean programListNotEmpty() {
		return !(Programs.isEmpty());
	}

	public boolean programUpdationSuccess() {
		  return updateMessage;
		
	}

	public void deleteProgram(String programTitle) {
		boolean programExists = Programs.stream().anyMatch(program -> program.getTitle().equals(programTitle));

			if (programExists) {
				
				Programs.removeIf(program -> program.getTitle().equals(programTitle));
				rewriteFile("files/products.txt", Programs); 
				deletedProductSuccessfully = true;
				lastMessage = "program deleted successfully";
			} else {
				
				deletedProductSuccessfully = false;
				lastMessage = "this program dose not exist";
}

       
        	
		
	}

	public boolean programDeletionSuccess() {
		return deletedProductSuccessfully;
	}

	
}

	



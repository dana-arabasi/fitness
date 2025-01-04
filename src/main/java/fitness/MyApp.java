package fitness;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MyApp {
	// Constants
    private static final String FILE_Client = "files/clients.txt";
    private static final String FILE_Instructor= "files/instructors.txt";
    private static final String FILE_InstructorReg= "files/instructorsreg.txt";
    private static final String FILE_ADMIN = "files/admin.txt";
    private static final String  loginHistoryFile= "files/login.txt";

    // Instance variables
    private String filePath = "";
    public boolean isUserLoggedIn;
    public boolean isSignedUp;
    public ArrayList<Client> clients;
    public ArrayList<Admin> admin;
    public ArrayList<Instructor> instructors;
    public ArrayList<Instructor> instructorsreg;
    public ArrayList<Program> programs;
    public ArrayList<String> activeprograms;
    public ArrayList<String> compprograms;
    public boolean AdminLoggedIn;
    public boolean userDashOpen;
    public boolean adminDashbordOpen;
    public boolean userManagementPageOpen;
    public boolean isUserListVisible;
    public boolean isSigndUp;
    public boolean addedSuccessfully;
    public boolean updatedSuccessfully;
    public boolean deletedSuccessfully;
    public boolean updateMessage;
    public boolean deletedProductSuccessfully;
    public boolean reportGenerated;
    public boolean discountMessagepos;
    public boolean messageSentToUser;
    public boolean messageSentToSupplier;
    public static  String loggedName;
    private String ROLE;
    private String loggedPassword;
    private String currentPage;
    public boolean contentManagementPageOpen;
    public boolean reportShown;
    public ContentManagement contentmanagement;
    public Client client;
	public boolean InstructorLoggedIn;
	private boolean ClientLoggedIn;
	private boolean UserLoggedIn;
	private String lastMessage;
	private Program currentProgram;
	private boolean isInstructorListVisible;
	private int totalLogins=0;
	private int loginCount=0;
	private boolean subscriptionmanagementpageOpen;
	private boolean programMonitoringPageOpen;
	
	
	 public MyApp() throws FileNotFoundException, IOException {
	        super();
	        this.client = new Client();
	        this.client.setApp(this);
	        contentmanagement = new ContentManagement();
	        this.clients = new ArrayList<>();
	        this.instructors = new ArrayList<>();
	        this.instructorsreg= new ArrayList<>();
	        this.activeprograms=new ArrayList<>();
	        this.compprograms=new ArrayList<>();
	        this.admin = new ArrayList<>();
	        this.programs = new ArrayList<>();
	      

	        loadData(FILE_Client, "Client");
	        loadData(FILE_Instructor, "Instructor");
	        loadData(FILE_ADMIN, "Admin");
	        loadData(FILE_InstructorReg,"Reg");
	        //loadPrograms();
	        //   loadOrders();
	    }

	/*  private void loadPrograms() throws FileNotFoundException, IOException {
	        try (BufferedReader br = new BufferedReader(new FileReader("files/products.txt"))) {
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
	                    programs.add(a);
	                }
	            }
	        }
	    }*/

	private void addRole(String name, String password, String role2) {
		
	        switch (role2) {
	            case "Client":
	                this.clients.add(new Client (name, password));
	                break;
	            case "Instructor":
	                this.instructors.add(new Instructor(name, password));
	                break;
	            case "Admin":
	                this.admin.add(new Admin(name, password));
	                break;
	            case "Reg":
	            	this.instructorsreg.add(new Instructor(name, password));
	            	break;
	            default:
	                //System.err.println("Error: Unrecognized role '" + role + "'.");
	                break;
	        
	    }
		
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

	
	
	

	public void login(String username, String password, String role) throws IOException {
		 boolean found = false;
	        switch (role) {
	            case "Client":
	                found = loginClient(username, password);
	                totalLogins++;
	                System.out.println(username + " logged in.");
	                try (FileWriter fileWriter = new FileWriter(loginHistoryFile, true);
	                        PrintWriter printWriter = new PrintWriter(fileWriter)) {
	                       printWriter.println("User: " + username + " logged in.");
	                   }
	                break;
	            case "Instructor":
	                found = loginInstructor(username, password);
	                totalLogins++;
	                System.out.println(username + " logged in.");
	                try (FileWriter fileWriter = new FileWriter(loginHistoryFile, true);
	                        PrintWriter printWriter = new PrintWriter(fileWriter)) {
	                       printWriter.println("User: " + username + " logged in.");
	                   }
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
                ClientLoggedIn = true;
                return true;
            }
        }
        return false;
	}

	public void AdminDashboardpage() {
		  adminDashbordOpen = true;
		  System.out.println("1. User Management Page");
          System.out.println("2. Program Monitoring Page");
          System.out.println("3. Content Management Page");
          System.out.println("4. Subscription Management Page");
          System.out.println("5. Logout");
	}

	public void AdminDashboardOptiones(String string) {
		switch (string) {
        case "1":
            userManagementPageOpen = true;
            System.out.println("User Management Page is now open.");
            System.out.println("Options:");
            System.out.println("1. View All Users");
            System.out.println("2. Add User");
            System.out.println("3. Delete User");
            System.out.println("4. Update User");
            System.out.println("5.  instructor registrations");
            System.out.println("6.  user activity and engagement statistics");
            //System.out.println("6.1.  user activity ");
            //System.out.println("6.2.   engagement statistics");
            System.out.println("7. Back to Admin Dashboard");
            break;
        case "2":
        	programMonitoringPageOpen=true;
        	ProgramMonitoring();
            break;
        case "3":
            contentManagementPageOpen = true;
            System.out.println("1. View Recipe");
            System.out.println("2. Delete Recipe");
            System.out.println("3. View feedback");
            System.out.println("4. Respond feedback");
            System.out.println("5. Delete feedback");
            break;
        case"4":
        	subscriptionmanagementpageOpen=true;
        	 System.out.println("1. View subscription plans ");
             System.out.println("2. Identify programs for each subscription plans");
             System.out.println("3.  Upgrade a subscription plan for a instructor");
             System.out.println("4.  Downgrade a subscription plan for a instructor");
        	
        	break;
        	
        default:
            //System.err.println("Error: Unrecognized option '" + option + "'.");
            break;
    }
		
	}

	private void ProgramMonitoring() {
		 System.out.println("1. Most Popular Programs");
         System.out.println("2. Profit Reports");
         System.out.println("3. Financial Report");
         System.out.println("4. Program Activity");
	}
	
	
	
	

	public void viewAllUsers() {
		System.out.println("List of all users:");
        for (Client client : clients) {
            System.out.println("Username: " + client.getUsername());
        }
        for (Instructor instructor : instructors) {
            System.out.println("instructor: " + instructor.getUsername());
        }
        isUserListVisible = true;
		
	}

	public void addUser(String username, String password, String role2) {
		 SignUp(username, password, role2);
	        String message = "User added successfully.";
	        addedSuccessfully = true;
	        printMessage(message);
		
	}

	void printMessage(String message) {
		 System.out.println(message);
		
	}

	public void SignUp(String username, String password, String role2) {
		switch (role2) {
        case "Client":
            filePath = FILE_Client;
            clients.add(new Client(username, password));
            break;
        case "Instructor":
            filePath = FILE_Instructor;
            instructors.add(new Instructor(username, password));
            break;
        case "Admin":
            filePath = FILE_ADMIN;
            admin.add(new Admin(username, password));
            break;
        default:
            // System.err.println("Error: Unrecognized role '" + role + "'.");
            return;
		
	}
		  updateFile(filePath, username, password, false);
	        isSignedUp = true;
	        printMessage(role2 + " added successfully!");
	        isSigndUp = true;
	
}

	private void updateFile(String filePath2, String username, String password, boolean isDelete) {
		 try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
	            if (!isDelete) {
	                writer.write(username + "," + password);
	                writer.newLine();
	            }
	        } catch (IOException e) {
	            // System.err.println("An error occurred while updating the file: " + filePath + " " + e.getMessage());
	        }
		
	}

	public Object getCurrentUsername() {
		  return loggedName;
	
	}

	public void updateUser(String oldUsername, String newUsername, String newPassword) {
		 for (Client client : clients) {
	            if (client.getUsername().equals(oldUsername)) {
	            	client.setUsername(newUsername);
	            	client.setPassword(newPassword);
	                rewriteFile("files/clients.txt", clients);
	                System.out.println("client updated successfully!");
	                String message = "User updated successfully.";
	                updatedSuccessfully = true;
	                printMessage(message);
	                return;
	            }
	        }
	        for (Instructor instructor : instructors) {
	            if (instructor.getUsername().equals(oldUsername)) {
	            	instructor.setUsername(newUsername);
	            	instructor.setPassword(newPassword);
	                rewriteFile("files/instructors.txt", instructors);
	                System.out.println("instructor updated successfully!");
	                String message = "User updated successfully.";
	                updatedSuccessfully = true;
	                printMessage(message);
	                return;
	            }
	        }
	        for (Admin adminUser : admin) {
	            if (adminUser.getUsername().equals(oldUsername)) {
	                adminUser.setUsername(newUsername);
	                adminUser.setPassword(newPassword);
	                rewriteFile("files/admin.txt", admin);
	                System.out.println("Admin updated successfully!");
	                String message = "User updated successfully.";
	                updatedSuccessfully = true;
	                printMessage(message);
	                return;
	            }
	        }

	        System.out.println("User " + oldUsername + " not found.");
	}
		
	

	private void rewriteFile(String filePath, ArrayList<?> list)  {
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, false))) {
            for (Object obj : list) {
                if (obj instanceof Client) {
                    writer.write(((Client) obj).getUsername() + "," + ((Client) obj).getPassword());
                } else if (obj instanceof Instructor) {
                    writer.write(((Instructor) obj).getUsername() + "," + ((Instructor) obj).getPassword());
                
                } else if (obj instanceof Admin) {
                    writer.write(((Admin) obj).getUsername() + "," + ((Admin) obj).getPassword());
                } 
                writer.newLine();
            }
        } catch (IOException e) {
            // System.err.println("An error occurred while rewriting the file: " + filePath + " " + e.getMessage());
        }
		
	}

	public void deleteUser(String username) {
		 clients.removeIf(client -> client.getUsername().equals(username));
		 instructors.removeIf(instructor -> instructor.getUsername().equals(username));
	     admin.removeIf(adminUser -> adminUser.getUsername().equals(username));

	        rewriteFile("files/clients.txt", clients);
	        rewriteFile("files/instructors.txt", instructors);
	        rewriteFile("files/admin.txt", admin);

	        System.out.println("User " + username + " deleted successfully!");
	        String message = "User deleted successfully.";
	        deletedSuccessfully = true;
	        printMessage(message);
		
	}
	public void SignUpUser(String username, String password, String role2) {
		switch (role2) {
        case "Client":
            filePath = FILE_Client;
            clients.add(new Client(username, password));
            break;
        case "Instructor":
            filePath = FILE_InstructorReg;
            instructorsreg.add(new Instructor(username, password));
            break;
        case "Admin":
            filePath = FILE_ADMIN;
            admin.add(new Admin(username, password));
            break;
        default:
            // System.err.println("Error: Unrecognized role '" + role + "'.");
            return;
		
	}
		  updateFile(filePath, username, password, false);
	        isSignedUp = true;
	        printMessage(role2 + " added successfully!");
	        isSigndUp = true;
	
}
	public void viewAllInstructors() {
		System.out.println("List of all instructor registrations:");
       
        for (Instructor instructor : instructorsreg) {
            System.out.println("instructor: " + instructor.getUsername());
        }
        isInstructorListVisible = true;
		
	}
	public boolean isInstructorInList(String name) {
        for (Instructor instructorreg : instructorsreg) {
            if (instructorreg.getUsername().equalsIgnoreCase(name)) {
                return true; // Instructor found
            }
        }
        return false; // Instructor not found
    }
public void approveInsructor(String name) {
	for (Instructor instructorreg : instructorsreg) {
        if (instructorreg.getUsername().equals(name)) {
        	instructors.add(instructorreg);
        	instructorsreg.remove(instructorreg);
        	 rewriteFile("files/instructors.txt", instructors);
        	 rewriteFile("files/instructorsreg.txt", instructorsreg);
        }
		
		
	} 
	
}

public void rejectInstructor(String name) {
	for (Instructor instructor : instructorsreg) {
        if (instructor.getUsername().equals(name)) {
        	instructorsreg.remove(instructor);
        	rewriteFile("files/instructorsreg.txt", instructorsreg);
        }
		
		
	} 
	 
	
}

public void selectSection(String string, String string2) throws FileNotFoundException, IOException {
	switch(string) {
	case "1":
		displayUserActivity();
	case "2":
		displayEngagementStatistics(string2);
		break;
		
	}
}

private void displayEngagementStatistics(String string2) throws FileNotFoundException, IOException {
	try (BufferedReader br = new BufferedReader(new FileReader("files/clientProgram.txt"))) {
        String line;
        double TotalPrograms = 0;
        while ((line = br.readLine()) != null) {
            String[] parts = line.split(",");
            if (parts.length == 5) {
                String clientName = parts[0];
                if(clientName.equalsIgnoreCase(string2))
                {
                	TotalPrograms++;
                	
                }
                
            }
        }
        
        System.out.println("Total programs for this user  : " + TotalPrograms); 
        
    }
	
}

private void displayUserActivity() {
	System.out.println("Total logins: " + totalLogins);
	try {
		System.out.println("login History: " );
        java.nio.file.Files.lines(java.nio.file.Paths.get(loginHistoryFile))
            .forEach(System.out::println); // Print each line from the file
    } catch (IOException e) {
        System.out.println("Error reading the login history file.");
        e.printStackTrace();
    }
	
}

public boolean isUserLoggedIn(String username) {
	try (BufferedReader reader = new BufferedReader(new FileReader(loginHistoryFile))) {
        String line;
        while ((line = reader.readLine()) != null) {
            if (line.contains("User: " + username + " logged in.")) {
            	System.out.println("This User is logged in.");
                return true; // User is already in the file
            }
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
    return false; // User is not in the file
}

public void countUserLogins(String username) {
	 try (BufferedReader reader = new BufferedReader(new FileReader(loginHistoryFile))) {
         String line;
         while ((line = reader.readLine()) != null) {
             if (line.contains("User: " + username + " logged in.")) {
                 loginCount++; // Increment the count if the line contains the username
             }
             System.out.println("Total this user logged in : " + loginCount); 
         }
     } catch (IOException e) {
         e.printStackTrace();
     }
	
	
}

public void selectReport(String reportType) throws FileNotFoundException, IOException {
	switch(reportType) {
	case "1":
		getMostPopularPrograms ();
		break;
	case "2":
		getProfitReports();
		break;
	case "3":
		getFinancialReport();
		break;
	case "4":
		getProgramActivity();
		break;
		
	}
	
}

private void getFinancialReport() throws FileNotFoundException, IOException {
	try (BufferedReader br = new BufferedReader(new FileReader("files/mostpopularprograms.txt"))) {
        String line;
        double TotalSales = 0;
        double Profit = 0;
        int quantity = 0;
        while ((line = br.readLine()) != null) {
            String[] parts = line.split(",");
            if (parts.length == 3) {
                //  String purchasedName = parts[0];
                String quan = parts[1];
                String purchasedPrice = parts[2];
                TotalSales += (Double.parseDouble(purchasedPrice) * Double.parseDouble(quan));
                quantity += Double.parseDouble(quan);
            }
        }
        Profit = TotalSales - quantity * 50;
        System.out.println("The Total number of sales: " + quantity);
        System.out.println("The total sales is: " + TotalSales);
        System.out.println("The profit is: " + Profit);
        reportGenerated = true;
    }
	
}

/*private void getSalesReport() throws FileNotFoundException, IOException {
	 try (BufferedReader br = new BufferedReader(new FileReader("files/mostpopularprograms.txt"))) {
         String line;
         double TotalSales = 0;
         double Profit = 0;
         int quantity = 0;
         while ((line = br.readLine()) != null) {
             String[] parts = line.split(",");
             if (parts.length == 3) {
                 //  String purchasedName = parts[0];
                 String quan = parts[1];
                 String purchasedPrice = parts[2];
                 TotalSales += (Double.parseDouble(purchasedPrice) * Double.parseDouble(quan));
                 quantity += Double.parseDouble(quan);
             }
         }
         Profit = TotalSales - quantity * 50;
         System.out.println("The Total number of sales: " + quantity);
         System.out.println("The total sales is: " + TotalSales);
         System.out.println("The profit is: " + Profit);
         reportGenerated = true;
     }
	
}*/

private void getProfitReports() throws FileNotFoundException, IOException {
	try (BufferedReader br = new BufferedReader(new FileReader("files/mostpopularprograms.txt"))) {
        String line;
        double TotalSales = 0;
        double Profit = 0;
        int quantity = 0;
        while ((line = br.readLine()) != null) {
            String[] parts = line.split(",");
            if (parts.length == 3) {
                String purchasedName = parts[0];
                String quan = parts[1];
                String purchasedPrice = parts[2];
                TotalSales += (Double.parseDouble(purchasedPrice) * Double.parseDouble(quan));
                quantity += Double.parseDouble(quan);
            }
        }
        Profit = TotalSales - quantity * 50;
        System.out.println("The profit is: " + Profit);
        reportGenerated = true;
    }
    reportShown = true;
	
}

private void getMostPopularPrograms() throws FileNotFoundException, IOException {
	try (BufferedReader br = new BufferedReader(new FileReader("files/mostpopularprograms.txt"))) {
        String line;
        int quantity = 0;
        String name = "";
        while ((line = br.readLine()) != null) {
            String[] parts = line.split(",");
            if (parts.length == 3) {
                String productname = parts[0];
                String quan = parts[1];
                if (quantity < Integer.parseInt(quan)) {
                    quantity = Integer.parseInt(quan);
                    name = productname;
                }
            }
        }
        System.out.println("The highest number of sales: " + quantity);
        System.out.println("The most popular programs is: " + name);
    }
	
}

public void getProgramActivity() throws FileNotFoundException, IOException {
	try (BufferedReader br = new BufferedReader(new FileReader("files/programactivity.txt"))) {
		String line;
        String activity="" ;
        String name = "";
        while ((line = br.readLine()) != null) {
            String[] parts = line.split(",");
            if (parts.length == 2) {
                String programname = parts[0];
                String acti = parts[1];
                if(acti.equals("active")) {
                	name=programname;
                	activeprograms.add(name);
                }
                else if(acti.equals("completed")) {
                	
                	name=programname;
                	compprograms.add(name);
                }
                }
		
		
		
	}
        
	
}
}

public void printActiveProgram() {
	 for (String active : activeprograms) {
		 System.out.println(active);
	
}
}

public void printCompletedProgram() {
	for (String comp : compprograms) {
		 System.out.println(comp);
	
}
	}

public boolean thereIsProgram() throws FileNotFoundException, IOException {
	try (BufferedReader br = new BufferedReader(new FileReader("files/programs.txt"))) {
        String line;
        if ((line = br.readLine()) != null) {
        	return true;
        	}
        else 
        	return false;
	


}
}

public void SubscriptionPlanPrograms(String name, String plan) throws FileNotFoundException, IOException {
		try (BufferedReader br = new BufferedReader(new FileReader("files/programs.txt"))) {
	        String line;
	        while ((line = br.readLine()) != null) {
	        	 String[] parts = line.split(",");
	        	 if (parts.length == 8) {
	                 String programname = parts[0];
	                
	                 if(programname.equalsIgnoreCase(name)) {
	                	 if (plan.equalsIgnoreCase("Basic")) {
	                	 try (BufferedWriter writer = new BufferedWriter(new FileWriter("files/BasicProgram.txt", false))) {
	                		 writer.write(line);
	     	                writer.newLine();
	                	 }
	     	             try (BufferedWriter writer1 = new BufferedWriter(new FileWriter("files/PremiumProgram.txt", false))) {
		                		 writer1.write(line);
		     	                writer1.newLine();
	                	 }
	                 }
	                	 else if (plan.equalsIgnoreCase("Premium")) {
	                		 try (BufferedWriter writer1 = new BufferedWriter(new FileWriter("files/PremiumProgram.txt", false))) {
		                		 writer1.write(line);
		     	                writer1.newLine();
	                	 }
	                			
	                		}

	        	
	        	}
	        
		
	       }
		}
	}
	
	}

public void displayPlanPrograms(String string2) {
	if(string2.equalsIgnoreCase("Basic")) {
	try (BufferedReader br = new BufferedReader(new FileReader("files/BasicProgram.txt"))) {
        String line;
        System.out.println("Basic Programs:");
        while ((line = br.readLine()) != null) {
            System.out.println(line);
        }
	
    }
	catch (IOException e) {
        e.printStackTrace(); 
    }
	}
	else if (string2.equalsIgnoreCase("Premium")){
		try (BufferedReader br = new BufferedReader(new FileReader("files/PremiumProgram.txt"))) {
	        String line;
	        System.out.println("Premium Programs:");
	        while ((line = br.readLine()) != null) {
	            System.out.println(line);
	        }
	}
	catch (IOException e) {
        e.printStackTrace(); 
    }
	
}
	
}





}


	






































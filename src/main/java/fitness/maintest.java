package fitness;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class maintest {
	 public static void main(String[] args) throws FileNotFoundException, IOException {
		
	     try (Scanner scanner = new Scanner(System.in)) {
	            MyApp app = new MyApp();
	            System.out.println("Welcome to the Fitness Management System!");

	            while (true) {
	                displayMainMenu();
	                String choice = scanner.nextLine();

	                switch (choice) {
	                    case "1":
	                        signUp(app, scanner);
	                        break;
	                    case "2":
	                        login(app, scanner);
	                        break;
	                    case "3":
	                        System.out.println("Exiting the system. Goodbye!");
	                        return;
	                    default:
	                        System.out.println("Invalid choice. Please try again.");
	                        break;
	                }
	            }
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }

	    private static void displayMainMenu() {
	        System.out.println("Please choose an option:");
	        System.out.println("1. Sign Up");
	        System.out.println("2. Login");
	        System.out.println("3. Exit");
	    }

	    private static void signUp(MyApp app, Scanner scanner) throws IOException {
	        System.out.println("Enter Username:");
	        String username = scanner.nextLine();
	        System.out.println("Enter Password:");
	        String password = scanner.nextLine();
	        
	        System.out.println("Enter Role ( Instructor, Client):");
	        System.out.println("1. Instructor");
	        System.out.println("2. Client");
	        String role = scanner.nextLine();
	        String roleyser=""; 
	        switch(role) {
	        case "1":
	        	roleyser="Instructor";
	        	break;
	        case "2":
	        	roleyser="Client";
	        	break;
	        default:
	        	 System.out.println("Invalid choice -_-");
	        }
	        app.SignUpUser(username, password, roleyser);
	    }

	    private static void login(MyApp app, Scanner scanner) throws IOException {
	        System.out.println("Enter Username:");
	        String username = scanner.nextLine();
	        System.out.println("Enter Password:");
	        String password = scanner.nextLine();
	        System.out.println("Enter Role (Admin, Instructor, Client):");
	        System.out.println("1. Admin");
	        System.out.println("2. Instructor");
	        System.out.println("3. Client");
	        String role = scanner.nextLine();
	        String roleyser=""; 
	        switch(role) {
	        case "1":
	        	roleyser="Admin";
	        	break;
	        case "2":
	        	roleyser="Instructor";
	        	break;
	        case "3":
	        	roleyser="Client";
	        	break;
	        default:
	        	 System.out.println("Invalid choice -_-");
	        }
	       
	        app.login(username, password, roleyser);

	        if (app.isUserLoggedIn) {
	            Client client = app.client; // Assuming `app.user` gives the current logged-in user
	            client.setApp(app); // Set the MyApp instance in the user for any necessary references

	            switch (roleyser) {
	                case "Admin":
	                    adminDashboard(app, scanner);
	                    break;
	                case "Instructor":
	                	instructorDashboard(app, scanner);
	                    break;
	                case "Client":
	                    clientDashboard(client,app, scanner);
	                    break;
	                default:
	                    
	                    break;
	            }
	        } else {
	            System.out.println("Login failed. Please check your credentials.");
	        }
	    }

	    private static void adminDashboard(MyApp app, Scanner scanner) throws IOException {
	        while (true) {
	            app.AdminDashboardpage();
	            System.out.println("Enter your choice:");
	            String choice = scanner.nextLine();
	            switch (choice) {
	                case "1":
	                  
	                    userManagement(app, scanner);
	                    break;
	                case "2":
	                   
	                    handleReports(app, scanner);
	                    break;
	                case "3":
	                    
	                    contentManagement(app, scanner);
	                    break;
	                case "4":
	                	
	                	subscripationManagement(app, scanner);
	                	break;
	                
	                default:
	                    System.out.println("Returning to main menu.");
	                    return;
	            }
	        }
	    }
	    
	    private static void contentManagement(MyApp app, Scanner scanner) throws IOException {
	    	while(true) {
	    		app.AdminDashboardOptiones("3");
	           
	        String contentManagementOption = scanner.nextLine();
	        if (contentManagementOption.equalsIgnoreCase("1")) {
	        	app.contentmanagement.viewRecipes();
	        } else if (contentManagementOption.equalsIgnoreCase("2")) {
	        	 System.out.println("Enter program name ");
	        	 String programname = scanner.nextLine();
	        	app.contentmanagement.deleteRecipes(programname);
	        }else if (contentManagementOption.equalsIgnoreCase("3")) {
	           System.out.println("Enter client name ");
	       	   String clientname = scanner.nextLine();
	       	   System.out.println("response to  users feedback ");
	    	   String response = scanner.nextLine();
	        	app.contentmanagement.responseFeedback(clientname,response);
	        }else if(contentManagementOption.equalsIgnoreCase("4")) {
	    		app.contentmanagement.viewFeedback();

	        }else if (contentManagementOption.equalsIgnoreCase("5")) {
	        	System.out.println("Enter client name ");
	        	   String name = scanner.nextLine();
	        	app.contentmanagement.deleteFeedback( name);
	        }
	        else if (contentManagementOption.equalsIgnoreCase("6")) {
	        	return;
	        }
	        
	    	}
	    }

	    private static void subscripationManagement(MyApp app, Scanner scanner) throws FileNotFoundException, IOException {
	    	while(true) {
	    		app.AdminDashboardOptiones("4");
	        String subscripationOption = scanner.nextLine();
	        if (subscripationOption.equalsIgnoreCase("1")) {
	        	   System.out.println("Enter program name ");
	        	   String prog = scanner.nextLine();
	        	   System.out.println("Enter subscription plan you want ");
	        	   System.out.println("1.  Basic");
	               System.out.println("2.  Premium");
	               String plan = scanner.nextLine();
	               String p="";

	               switch (plan) {
	                   case "1":
	                       p="Basic";
	                       break;
	                   case "2":
	                	   p="Premium";
	                       break;
	        	}
	               app.SubscriptionPlanPrograms(prog,p);
	        } else if (subscripationOption.equalsIgnoreCase("2")) {
	        	app.displayPlanPrograms("Basic");
	   		    app.displayPlanPrograms("Premium");
	        }
	    	}
		}

		private static void handleReports(MyApp app, Scanner scanner) throws IOException {
			while(true) {
				 app.AdminDashboardOptiones("2");
	          System.out.println("5. Back to Admin Dashboard");
	        String reportOption = scanner.nextLine();
	        switch(reportOption) {
	        case "1":
	        	app.selectReport("1");
	        	break;
	        case "2":
	        	 app.selectReport("2");
	        	 break;
	        case "3":
	        	app.selectReport("3");
	        	break;
	        case "4":
	        	app.selectReport("4");
	        	break;
	        case "5":
	        	return;
	        }
	          
			}
	    }

	    private static void userManagement(MyApp app, Scanner scanner) throws IOException {
	        while (true) {
	        	app.AdminDashboardOptiones("1");
	            String choice = scanner.nextLine();

	            switch (choice) {
	                case "1":
	                    app.viewAllUsers();
	                    break;
	                case "2":
	                    addUser(app, scanner);
	                    break;
	                case "3":
	                    deleteUser(app, scanner);
	                    break;
	                case "4":
	                    updateUser(app, scanner);
	                    break;
	                case "5":
	                	instructorRegistrations(app,scanner);
	                	break;
	                case "6":
	                	 userActivity(app,scanner);
	                	 break;
	                case "7":
	                    return;
	                default:
	                    System.out.println("Invalid option. Please try again.");
	                    break;
	            }
	        }
	    }

	    private static void userActivity(MyApp app, Scanner scanner) throws FileNotFoundException, IOException {
	    	System.out.println("1. views overall user activity statistics");
	        System.out.println("2. views user engagement statistics ");
	        System.out.println("3. views detailed activity of a specific user");
	        String userActivityoption = scanner.nextLine();
	        switch(userActivityoption) {
	        case "1":
	        	app.selectSection("1", "");
				break;
	        case "2":
	        	String user = scanner.nextLine();
				app.selectSection("2", user);
				break;
	        case "3":
	        	String spuser = scanner.nextLine();
				if (app.isUserLoggedIn(spuser)) {
					app.countUserLogins(spuser);
				}
				break;
	        default:
	       	 System.out.println("Invalid choice -_-");
	        	
	        }
			
		}

		private static void instructorRegistrations(MyApp app, Scanner scanner) {
			System.out.println("1. View instructor registrations");
			System.out.println("2. Approve a new instructor registration ");
			System.out.println("3. Reject a new instructor registration ");
			int instructorregistrations = scanner.nextInt();
			switch (instructorregistrations) {
			 case 1:
				app.viewAllInstructors();
				break;
			 case 2:
				System.out.print("Enter username for the Instructor you want to add: ");
				String Instructorusernameadmin = scanner.nextLine();
				if (app.isInstructorInList(Instructorusernameadmin)) {
					app.approveInsructor(Instructorusernameadmin);
				}
				break;
		 	case 3:
				System.out.print("Enter username for the Instructor you want to delete: ");
				String delInstructorusernameadmin = scanner.nextLine();
				if (app.isInstructorInList(delInstructorusernameadmin)) {
					app.rejectInstructor(delInstructorusernameadmin);
				}
				break;
			}
		}

//		private static void displayUserManagementMenu() {
//	        System.out.println("User Management Options:");
//	        System.out.println("1. View All Users");
//	        System.out.println("2. Add User");
//	        System.out.println("3. Delete User");
//	        System.out.println("4. Update User");
//	        System.out.println("5. instructor registrations");
//	        System.out.println("6. user activity and engagement statistics");
//	        System.out.println("7. Back to Admin Dashboard");
//	    }

	    private static void addUser(MyApp app, Scanner scanner) throws IOException {
	        System.out.println("Enter new Username:");
	        String newUsername = scanner.nextLine();
	        System.out.println("Enter Password:");
	        String newPassword = scanner.nextLine();
	        System.out.println("Enter Role:");
	        System.out.println("1. Admin");
	        System.out.println("2. Instructor");
	        System.out.println("3. Client");
	        String newRole = scanner.nextLine();
	        String roleyser=""; 
	        switch(newRole) {
	        case "1":
	        	roleyser="Admin";
	        	break;
	        case "2":
	        	roleyser="Instructor";
	        	break;
	        case "3":
	        	roleyser="Client";
	        	break;
	        default:
	        	 System.out.println("Invalid choice -_-");
	        }
	       
	        app.addUser(newUsername, newPassword, roleyser);
	    }

	    private static void deleteUser(MyApp app, Scanner scanner) throws IOException {
	        System.out.println("Enter Username to delete:");
	        String deleteUsername = scanner.nextLine();
	        app.deleteUser(deleteUsername);
	    }

	    private static void updateUser(MyApp app, Scanner scanner) throws IOException {
	        System.out.println("Enter current Username:");
	        String oldUsername = scanner.nextLine();
	        System.out.println("Enter new Username:");
	        String newUsername = scanner.nextLine();
	        System.out.println("Enter new Password:");
	        String newPassword = scanner.nextLine();
	        app.updateUser(oldUsername, newUsername, newPassword);
	    }

	    private static void instructorDashboard(MyApp app, Scanner scanner) throws IOException {
	        while (true) {
	            displayInstructorMenu();
	            String choice = scanner.nextLine();

	            switch (choice) {
	                case "1":
	                    managePrograms(app, scanner);
	                    break;
	                case "2":
	                	clientInteraction(app,scanner);
	                    break;
	                case "3":
	                	progressTracking(app,scanner);
	                    break;
	                case "4":
	                    return;
	                default:
	                    System.out.println("Invalid choice. Please try again.");
	                    break;
	            }
	        }
	    }

	    private static void progressTracking(MyApp app, Scanner scanner) {
	    	while (true) {
		    	displayProgressTrackingMenu();
		    	 String choice = scanner.nextLine();

		            switch (choice) {
		                case "1":
		                	 MonitorClientProgress(app, scanner);
		                    break;
		                case "2":
		                	Sendreminders(app, scanner);
		                    break;
		                case "3":
		                	return;
		                
		                default:
		                    System.out.println("Invalid choice. Please try again.");
		                    break;
		            }
			}
			
		}

		private static void Sendreminders(MyApp app, Scanner scanner) {
			System.out.println("Enter client's name:");
	        String ClientName = scanner.nextLine();
	    	System.out.println("Enter the reminder message:");
	        String message = scanner.nextLine();
			app.sendReminder(ClientName,message);
			
		}

		private static void MonitorClientProgress(MyApp app, Scanner scanner) {
			   System.out.println("Enter client's name:");
		        String ClientName = scanner.nextLine();
		        app.selectClient(ClientName);		      			
		}

		private static void displayProgressTrackingMenu() {
			System.out.println(" Progress Tracking :");
	        System.out.println("1. Monitor client progress ");
	        System.out.println("2. Send motivational reminders or recommendations.");
	        System.out.println("3. Back to Instructor Dashboard");
			
			
		}

		private static void clientInteraction(MyApp app, Scanner scanner) throws IOException {
	    	while (true) {
	    	displayClientInteractionMenu();
	    	 String choice = scanner.nextLine();

	            switch (choice) {
	                case "1":
	                	message(app, scanner);
	                    break;
	                case "2":
	                	feedback(app, scanner);
	                    break;
	                case "3":
	                	Respond(app, scanner);
	                    break;
	                case "4":
	                    return;
	                default:
	                    System.out.println("Invalid choice. Please try again.");
	                    break;
	            }
		}
	    }
		private static void Respond(MyApp app, Scanner scanner) throws FileNotFoundException, IOException {
			System.out.println("Client's query :");
			 String filePath= "files/messagesToInstructor.txt";  
		        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
		            String line;
		            if((line = br.readLine()) != null) {
		            while ((line = br.readLine()) != null) {
		    			System.out.println(line);
		            }
		            }
		            else {
		    			System.out.println("there is no query");

		            }
		            
		            }
		        System.out.println("Enter client's name:");
		        String ClientName = scanner.nextLine();
		        System.out.println("Enter the Respond to the query");
		        String message = scanner.nextLine();
		        app.respondToQuery(ClientName,message);
		        
		        }

		

		private static void feedback(MyApp app, Scanner scanner) throws IOException {
			System.out.println("Enter client's name:");
	        String ClientName = scanner.nextLine();
	        System.out.println("Enter the feedback message");
	        String message = scanner.nextLine();
	        app.provideFeedbackOrUploadReport(ClientName,message);
	       
			
		}

		private static void message(MyApp app, Scanner scanner) {
			System.out.println("Enter client's name:");
	        String ClientName = scanner.nextLine();
	        System.out.println("Enter the message");
	        String message = scanner.nextLine();
	        app.sendMessageToUser(ClientName, message);	
	       

		}

		private static void displayClientInteractionMenu() {
			System.out.println("Client Interaction");
	        System.out.println("1. Send a message to a client ");
	        System.out.println("2. Send a feedback to a client");
	        System.out.println("3. Respond to a query");
	        System.out.println("4. Back to Instructor Dashboard");
			
		}

		private static void displayInstructorMenu() {
	        System.out.println("Instructor Dashboard:");
	        System.out.println("1. Program Management");
	        System.out.println("2. Client Interaction");
	        System.out.println("3. Progress Tracking");
	        System.out.println("4. Back to Main Menu");
	    }

	
	    private static void managePrograms(MyApp app, Scanner scanner) throws IOException {
	        while (true) {
	        	scanner.nextLine();
	            displayProgramManagementMenu();
	            String choice = scanner.nextLine();

	            switch (choice) {
	                case "1":
	                    addProgram(app, scanner);
	                    break;
	                case "2":
	                    editProgram(app, scanner);
	                    break;
	                case "3":
	                    deleteProgram(app, scanner);                    
	                    break;
	                case "4":
	                	selectCompletedPrograms(app, scanner);
	                	break;
	                case "5":
	                	return;
	                default:
	                    System.out.println("Invalid choice. Please try again.");
	                    break;
	            }
	        }
	    }

	    private static void selectCompletedPrograms(MyApp app, Scanner scanner) {
	    	String filePath= "files/programs.txt";  
	    	String Path= "files/completedPrograms.txt";
	    	   int i=1;
	    	   int n1=1;
	    	   String line;
	        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
	            String line1;
	            while ((line1 = br.readLine()) != null) {
	            	String[] clientData = line1.split(",");
	            	  System.out.println(i+"."+"Title: "+ clientData[0].trim() +"duration: "+ clientData[1].trim() + "Difficulty level: "+ clientData[2].trim() +"goals: "+ clientData[3].trim()+"price: " + clientData[7].trim()+"session Type: " + clientData[8].trim()+"session Days: " + clientData[9].trim()+"session Days: " + clientData[9].trim());
	            	  i++;
	            }
	        } catch (IOException e) {
	            System.err.println("Error reading the program file: " + e.getMessage());
	        }
	        System.out.println("Enter Program number:");
	        String choice = scanner.nextLine();
	        int number = Integer.parseInt(choice);
	        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
	            
	            while ((line = br.readLine()) != null) {
	            	String[] clientData = line.split(",");
	            	  if(number==n1) {
	            		  try (BufferedWriter writer = new BufferedWriter(new FileWriter(Path, true))) {
	          	            writer.write(line);
	          	            writer.newLine();
	          	               
	          	        } catch (IOException e) {
	          	            e.printStackTrace();
	          	        }
	            		  app.deleteProgram(clientData[0]);
	          	        System.out.println("The operation done successfully");

	            	  }
	            	  n1++; 
	            	  }
	            	  } catch (IOException e) {
	          	            e.printStackTrace();
	          	        }
	            
	        
	        
	        
		}

		private static void displayProgramManagementMenu() {
	        System.out.println("Program Management:");
	        System.out.println("1. Create program");
	        System.out.println("2. update program");
	        System.out.println("3. Delete program");
	        System.out.println("4. select completed programs");
	        System.out.println("5. Back to Instructor Dashboard");
	    }

	    private static void addProgram(MyApp app, Scanner scanner) throws IOException {
	        System.out.println("Enter Program title:");
	        String programTitle = scanner.nextLine();
	        System.out.println("Enter Program duration:");
	        String programDuration = scanner.nextLine();
	        System.out.println("Enter Program difficulty level:");
	        System.out.println("1. Beginner");
			 System.out.println("2. Intermediate");
			 System.out.println("3. Advanced");
		        String num = scanner.nextLine();
		        String programLevel = "";
		        switch(num) {
		        case "1":
		        	programLevel="Beginner";
		        	break;
		        case "2":
		        	programLevel="Intermediate";
		        	break;
		        case "3":
		        	programLevel="Advanced";
		        	break;
		        default:
                   System.out.println("Invalid choice. Please try again.");
                   break;
		        }
	       
	        System.out.println("Enter Program goals:");
	        System.out.println("1. weight loss");
			 System.out.println("2. muscle building");
			 System.out.println("3. flexibility");
		        String n = scanner.nextLine();
		        String programGoals = "";
		        switch(n) {
		        case "1":
		        	programGoals="weight loss";
		        	break;
		        case "2":
		        	programGoals="muscle building";
		        	break;
		        case "3":
		        	programGoals="flexibility";
		        	break;
		        default:
                  System.out.println("Invalid choice. Please try again.");
                  break;
		        }
	        
	        System.out.println("Enter Program Video path:");
	        String programVideo = scanner.nextLine();
	        System.out.println("Enter Program images path:");
	        String programImages = scanner.nextLine();
	        System.out.println("Enter Program documents path:");
	        String programDoc = scanner.nextLine();
	        System.out.println("Enter Program Price:");
	        String programPrice = scanner.nextLine();
	        System.out.println("Enter group sessions type :");
	        System.out.println("1. online");
	        System.out.println("2. in-person");
	        String number = scanner.nextLine();
	        String sessionsType = "";
	        switch (number) {
	        case "1":
	        	sessionsType="online";
                break;
            case "2":
            	sessionsType="in-person";
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
                break;
	        }
	        System.out.println("Enter group sessions days :");
	        String sessionsDay = scanner.nextLine();
	        System.out.println("Enter group sessions times ::");
	        String sessionsTime = scanner.nextLine();
	        System.out.println("Do you want to send a notification to clients?");
	        System.out.println("1. yes");
	        System.out.println("2. no");
	        String choice = scanner.nextLine();
	        app.CreateProgram(programTitle, programDuration, programLevel,programGoals,programVideo,programImages,programDoc,programPrice,sessionsType,sessionsDay,sessionsTime);
	        System.out.println(app.getMessage());
	       if(app. isProgramInList(programTitle)) {
	        switch (choice) {
	        case "1":
               app.sendNotificationToALLClients(programTitle,"A new program has been added");
                break;
            case "2":
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
                break;
	        }
	    }}

	    private static void editProgram(MyApp app, Scanner scanner) throws IOException {
	    	System.out.println("Enter Program title to edit:");
	        String programSearchTitle = scanner.nextLine();
	    	System.out.println("Enter the new title:");
	        String programTitle = scanner.nextLine();
	        System.out.println("Enter the new duration:");
	        String programDuration = scanner.nextLine();
	        System.out.println("Enter the new difficulty level:");
	        System.out.println("1. Beginner");
			 System.out.println("2. Intermediate");
			 System.out.println("3. Advanced");
		        String num = scanner.nextLine();
		        String programLevel = "";
		        switch(num) {
		        case "1":
		        	programLevel="Beginner";
		        	break;
		        case "2":
		        	programLevel="Intermediate";
		        	break;
		        case "3":
		        	programLevel="Advanced";
		        	break;
		        default:
                  System.out.println("Invalid choice. Please try again.");
                  break;
		        }
	       
	        
	        System.out.println("Enter the new goals:");
	        System.out.println("1. weight loss");
			 System.out.println("2. muscle building");
			 System.out.println("3. flexibility");
		        String n = scanner.nextLine();
		        String programGoals = "";
		        switch(n) {
		        case "1":
		        	programGoals="weight loss";
		        	break;
		        case "2":
		        	programGoals="muscle building";
		        	break;
		        case "3":
		        	programGoals="flexibility";
		        	break;
		        default:
                 System.out.println("Invalid choice. Please try again.");
                 break;
		        }
	        
	        System.out.println("Enter the new Video path:");
	        String programVideo = scanner.nextLine();
	        System.out.println("Enter the new images path:");
	        String programImages = scanner.nextLine();
	        System.out.println("Enter the new documents path:");
	        String programDoc = scanner.nextLine();
	        System.out.println("Enter the new Price:");
	        String programPrice = scanner.nextLine();
	        System.out.println("Enter the new group sessions type :");
	        System.out.println("1. online");
	        System.out.println("2. in-person");
	        String number = scanner.nextLine();
	        String sessionsType = "";
	        switch (number) {
	        case "1":
	        	sessionsType="online";
                break;
            case "2":
            	sessionsType="in-person";
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
                break;
	        }
	        System.out.println("Enter the new group sessions days :");
	        String sessionsDay = scanner.nextLine();
	        System.out.println("Enter the new group sessions times :");
	        String sessionsTime = scanner.nextLine();
	        System.out.println("Do you want to send a notification to clients?");
	        System.out.println("1. yes");
	        System.out.println("2. no");
	        String choice = scanner.nextLine();
	        app.editProgram(programSearchTitle,programTitle, programDuration, programLevel,programGoals,programVideo,programImages,programDoc,programPrice,sessionsType,sessionsDay,sessionsTime);
	        System.out.println(app.getMessage());
	        if(app. isProgramInList(programTitle)) {
	        switch (choice) {
	        case "1":
               app.sendNotificationToClients(programTitle, "There has been an update to the program");
                break;
            case "2":
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
                break;
	        }
	    }}

	    private static void deleteProgram(MyApp app, Scanner scanner) throws IOException {
	    	String filePath= "files/programs.txt";  
	    	   int i=1;
	    	   int n1=1;
	    	   String line;
	        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
	            String line1;
	            while ((line1 = br.readLine()) != null) {
	            	String[] clientData = line1.split(",");
	            	  System.out.println(i+"."+"Title: "+ clientData[0].trim() +"duration: "+ clientData[1].trim() + "Difficulty level: "+ clientData[2].trim() +"goals: "+ clientData[3].trim()+"price: " + clientData[7].trim()+"session Type: " + clientData[8].trim()+"session Days: " + clientData[9].trim()+"session Days: " + clientData[9].trim());
	            	  i++;
	            }
	        } catch (IOException e) {
	            System.err.println("Error reading the program file: " + e.getMessage());
	        }
	        System.out.println("Enter Program number:");
	        String choice = scanner.nextLine();
	        int number = Integer.parseInt(choice);
           try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
	            
	            while ((line = br.readLine()) != null) {
	            	String[] clientData = line.split(",");
	            	  if(number==n1) {
	            		  app.deleteProgram(clientData[0]);
	            		  System.out.println(app.getMessage());
	            	  }
	            	  else {
	            		  n1++;
	            	  }
	            	  }
           } catch (IOException e) {
	            System.err.println("Error reading the program file: " + e.getMessage());
	        }
	    }

	    

    

	  
	    private static void clientDashboard(Client user, MyApp app, Scanner scanner) throws IOException {
	        while (true) {
	            printDashboard(); // Assuming this prints the available options
	            System.out.println("Enter your choice:");
	            String choice = scanner.nextLine();

	            switch (choice) {
	                case "1":
	                	accountManagement(user, scanner,app);
	                    break;
	                case "2":
	                	programExplorationAndEnrollment(user, scanner,app);
	                    break;
	                case "3":
	                	progressTrackingForClient(user, scanner,app);
	                    break;
	                case "4":
	                	feedbackAndReviews(user, scanner,app);
	                    break;                    
	                case "5":
	                	Notifications(user, scanner,app);
	                    break;
	                case "6":
	                	communicate(user, scanner,app);
	                	break;
	                case "7":
	                	readfeedbacksfrominstructorsandAdmin(user, scanner,app);
	                case "8":
	                	 System.out.println("Logging out...");
		                    return;
	                default:
	                    System.out.println("Invalid choice. Please try again.");
	                    break;
	            }
	        }
	    }

	   
	    private static void readfeedbacksfrominstructorsandAdmin(Client user, Scanner scanner, MyApp app) {
	    	 while (true) {
			displayfeedbackmenu();
			System.out.println("Enter your choice:");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                	feedbackFromAdmin(user, app, scanner);
                    break;
                case "2":
                	feedbackFromInstructor(user, app, scanner);
                    return; // Exit after deleting the account
                case "3":
                    System.out.println("Returning to client Dashboard...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
	
			
	    	 }	
		private static void feedbackFromInstructor(Client user, MyApp app, Scanner scanner) {
			System.out.println(" feedback From Admin:");
	    	String filePath= "files/feedbackToClients.txt";  
	        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
	            String line;
	            while ((line = br.readLine()) != null) {
	            	String[] clientData = line.split(",");
	            	if(clientData[0].equalsIgnoreCase(app.getCurrentUsername())) {
	            	  System.out.println(clientData[1]);
	            }}
	        } catch (IOException e) {
	            System.err.println("Error reading the clients file: " + e.getMessage());
	        }
		}

		private static void feedbackFromAdmin(Client user, MyApp app, Scanner scanner) {
			System.out.println(" feedback From Admin:");
	    	String filePath= "files/responseFeedback.txt";  
	        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
	            String line;
	            while ((line = br.readLine()) != null) {
	            	String[] clientData = line.split(",");
	            	if(clientData[0].equalsIgnoreCase(app.getCurrentUsername())) {
	            	  System.out.println(clientData[1]);
	            }}
	        } catch (IOException e) {
	            System.err.println("Error reading the clients file: " + e.getMessage());
	        }
			
		}

		private static void displayfeedbackmenu() {
			System.out.println("reed feedbacks from::");
	        System.out.println("1. Admin");
	        System.out.println("2. Instructor");
	        System.out.println("3. Back to client Dashboard");
		
		}

		private static void progressTrackingForClient(Client user, Scanner scanner, MyApp app) {
	    	app.selectClient(app.getCurrentUsername());
		}

		private static void feedbackAndReviews(Client user, Scanner scanner, MyApp app) {
	    	System.out.println("Enter program title:");
	        String program = scanner.nextLine();
	    	System.out.println("Enter your feedback:");
	        String feedback = scanner.nextLine();
	        String content =app.getCurrentUsername()+","+program+","+feedback;
	        String path = "files/feedback.txt";
	        try (BufferedWriter writer = new BufferedWriter(new FileWriter(path, true))) {
	            writer.write(content);
	            writer.newLine();
	            System.out.println("feedback sent successfully.");
	            
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
			
		}

		private static void Notifications(Client user, Scanner scanner, MyApp app) {
            System.out.println(" Your Notifications:");
	    	String filePath= "files/notificationToClients.txt";  
	        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
	            String line;
	            while ((line = br.readLine()) != null) {
	            	String[] clientData = line.split(",");
	            	if(clientData[0].equalsIgnoreCase(app.getCurrentUsername())) {
	            	  System.out.println(clientData[1]);
	            }}
	        } catch (IOException e) {
	            System.err.println("Error reading the clients file: " + e.getMessage());
	        }
		}

		private static void programExplorationAndEnrollment(Client user, Scanner scanner, MyApp app) throws IOException {
	    	 while (true) {
	    		  displayProgramExplorationAndEnrollmentMenu(); // Assuming this prints the available options
		            System.out.println("Enter your choice:");
		            String choice = scanner.nextLine();

		            switch (choice) {
		                case "1":
		                	BrowseProgramsByfilters(user, app, scanner);
		                    break;
		                case "2":
		                	EnrollInPrograms(user, app, scanner);
		                    return; // Exit after deleting the account
		                case "3":
		                    System.out.println("Returning to client Dashboard...");
		                    return;
		                default:
		                    System.out.println("Invalid choice. Please try again.");
		                    break;
		            }
		        }
			
		}

		private static void EnrollInPrograms(Client user, MyApp app, Scanner scanner) {
			String filePath="";  
			if(user.getisPremium()) {
				filePath= "files/programs.txt";  
			}else if(user.getisBasic()) {
				filePath= "files/BasicProgram.txt";  
			}
	        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
	            String line;
	            while ((line = br.readLine()) != null) {
	            	String[] clientData = line.split(",");
	            	  System.out.println("Title: "+ clientData[0].trim() +"duration: "+ clientData[1].trim() + "Difficulty level: "+ clientData[2].trim() +"goals: "+ clientData[3].trim()+"price: " + clientData[7].trim()+"session Type: " + clientData[8].trim()+"session Days: " + clientData[9].trim()+"session Days: " + clientData[9].trim());
	            }
	        } catch (IOException e) {
	            System.err.println("Error reading the program file: " + e.getMessage());
	        }
	        System.out.println("////////////////////////////////////////////////");
	        System.out.println("Enter the program title to enroll in:");
	        String choice = scanner.nextLine();
	       if( app.isProgramInList(choice)) {
	    	   String path= "files/clientPrograms.txt"; 
	    	   String content = app.getCurrentUsername() + "," + choice + ",0%,0 tasks,0/20 sessions";
		        try (BufferedWriter writer = new BufferedWriter(new FileWriter(path, true))) {
		            writer.write(content);
		            writer.newLine();
		            System.out.println("Enrolled In the program successfully.");
		           
		        } catch (IOException e) {
		            e.printStackTrace();
		        }
	       }
	        
	        
		}

		private static void BrowseProgramsByfilters(Client user, MyApp app, Scanner scanner) {
			 while (true) {
	    		  displayBrowseProgramsMenu(); // Assuming this prints the available options
		            System.out.println("Enter your choice:");
		            String choice = scanner.nextLine();

		            switch (choice) {
		                case "1":
		                	Difficultylevel(user, app, scanner);
		                    break;
		                case "2":
		                	Focusarea(user, app, scanner);
		                    return; // Exit after deleting the account
		                case "3":
		                    System.out.println("Returning to Program Exploration and Enrollment...");
		                    return;
		                default:
		                    System.out.println("Invalid choice. Please try again.");
		                    break;
		            }
		        }
			
			
		}

		private static void Focusarea(Client user, MyApp app, Scanner scanner) {
			System.out.println("Enter your Focus area:");
			 System.out.println("1. weight loss");
			 System.out.println("2. muscle building");
			 System.out.println("3. flexibility");
		        String num = scanner.nextLine();
		        String Focusarea="";
		        switch(num) {
		        case "1":
		        	Focusarea="weight loss";
		        	break;
		        case "2":
		        	Focusarea="muscle building";
		        	break;
		        case "3":
		        	Focusarea="flexibility";
		        	break;
		        default:
                   System.out.println("Invalid choice. Please try again.");
                   break;
		        }
		        boolean clientFound = false;
		        String filePath="";  
				if(user.getisPremium()) {
					filePath= "files/programs.txt";  
				}else if(user.getisBasic()) {
					filePath= "files/BasicProgram.txt";  
				}
			        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
			            String line;
			            while ((line = br.readLine()) != null) {
			                String[] clientData = line.split(",");
			                if (clientData.length > 0 && clientData[3].trim().equalsIgnoreCase(Focusarea)) {
			                    clientFound = true;
			                    System.out.println("Program Information:");
			                    System.out.println("Title: " + clientData[0].trim());
			                    if (clientData.length > 1) {
			                        System.out.println("duration: " + clientData[1].trim());
			                    }
			                        if (clientData.length > 2) {
			                        System.out.println("Difficulty level: " + clientData[2].trim());
			                    }
			                    if (clientData.length > 3) {
			                        System.out.println("goals: " + clientData[3].trim());
			                    }
			                    if (clientData.length > 7) {
			                        System.out.println("price: " + clientData[7].trim());
			                        
			                        
			                    }
			                    if (clientData.length > 8) {
			                        System.out.println("session Type: " + clientData[8].trim());
			                        
			                    }
			                    if (clientData.length > 9) {
			                        System.out.println("session Days: " + clientData[9].trim());
			                        
			                    } 
			                    
			                    if (clientData.length > 10) {
			                        System.out.println("session Times: " + clientData[10].trim());
			                        System.out.println("//////////////////////////////////////////////");
 
			                    }
			                    
			                    break;
			                }
			            }
			            
			            if (!clientFound) {
			                System.out.println("program with Difficulty level \"" + Focusarea + "\" not found .");
			            }
			        } catch (IOException e) {
			            System.err.println("Error reading the clients file: " + e.getMessage());
			        }
			
		}

		private static void Difficultylevel(Client user, MyApp app, Scanner scanner) {
			 System.out.println("Enter the Difficulty level you want:");
			 System.out.println("1. Beginner");
			 System.out.println("2. Intermediate");
			 System.out.println("3. Advanced");
		        String num = scanner.nextLine();
		        String Difficultylevel="";
		        switch(num) {
		        case "1":
		        	Difficultylevel="Beginner";
		        	break;
		        case "2":
		        	Difficultylevel="Intermediate";
		        	break;
		        case "3":
		        	Difficultylevel="Advanced";
		        	break;
		        default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
		        }
		        boolean clientFound = false;
		        String filePath="";  
				if(user.getisPremium()) {
					filePath= "files/programs.txt";  
				}else if(user.getisBasic()) {
					filePath= "files/BasicProgram.txt";  
				}
			        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
			            String line;
			            while ((line = br.readLine()) != null) {
			                String[] clientData = line.split(",");
			                if (clientData.length > 0 && clientData[2].trim().equalsIgnoreCase(Difficultylevel)) {
			                    clientFound = true;
			                    System.out.println("Program Information:");
			                    System.out.println("Title: " + clientData[0].trim());
			                    if (clientData.length > 1) {
			                        System.out.println("duration: " + clientData[1].trim());
			                    }
			                        if (clientData.length > 2) {
			                        System.out.println("Difficulty level: " + clientData[2].trim());
			                    }
			                    if (clientData.length > 3) {
			                        System.out.println("goals: " + clientData[3].trim());
			                    }
			                    if (clientData.length > 7) {
			                        System.out.println("price: " + clientData[7].trim());
			                        
			                        
			                    }
			                    if (clientData.length > 8) {
			                        System.out.println("session Type: " + clientData[8].trim());
			                        
			                    }
			                    if (clientData.length > 9) {
			                        System.out.println("session Days: " + clientData[9].trim());
			                        
			                    } 
			                    
			                    if (clientData.length > 10) {
			                        System.out.println("session Times: " + clientData[10].trim());
			                        System.out.println("//////////////////////////////////////////////");
 
			                    }
			                    
			                    break;
			                }
			            }
			            
			            if (!clientFound) {
			                System.out.println("program with Difficulty level \"" + Difficultylevel + "\" not found .");
			            }
			        } catch (IOException e) {
			            System.err.println("Error reading the clients file: " + e.getMessage());
			        }
			    
				
			
		}

		private static void displayBrowseProgramsMenu() {
			System.out.println(" Browse programs by filters:");
	        System.out.println("1. Difficulty level ");
	        System.out.println("2. Focus area");
	        System.out.println("3. Back to Program Exploration and Enrollment");
			
		}

		private static void displayProgramExplorationAndEnrollmentMenu() {
			System.out.println("Program Exploration and Enrollment:");
	        System.out.println("1. Browse programs by filters");
	        System.out.println("2. Enroll in programs and view schedules.");
	        System.out.println("3. Back to client Dashboard");
		}

		private static void accountManagement(Client user, Scanner scanner, MyApp app) throws IOException {
	    	 while (true) {
	    		  displayAccountManagementMenu(); // Assuming this prints the available options
		            System.out.println("Enter your choice:");
		            String choice = scanner.nextLine();

		            switch (choice) {
		                case "1":
		                    updateAccount(user, app, scanner);
		                    break;
		                case "2":
		                    deleteAccount(user, app, scanner);
		                    return; // Exit after deleting the account
		                case "3":
		                	UpgradeDowngradeyourAccount(user, app, scanner);
		                	break;
		                case "4":
		                	  System.out.println("Returning to client Dashboard...");
			                    return;
		                default:
		                    System.out.println("Invalid choice. Please try again.");
		                    break;
		            }
		        }
			
		}


		private static void UpgradeDowngradeyourAccount(Client user, MyApp app, Scanner scanner) {
			while (true) {
				System.out.println("what do you want ?");
		    	System.out.println("1. Upgrade your account ");
		    	System.out.println("2. Downgrade your account");
		    	System.out.println("3. Back to Account Management page");
		            System.out.println("Enter your choice:");
		            String choice = scanner.nextLine();

		            switch (choice) {
		                case "1":
		                	UpgradeAccount(user, app, scanner);
		                    break;
		                case "2":
		                	DowngradeAccount(user, app, scanner);
		                    return; // Exit after deleting the account
		                case "3":
		                	 System.out.println("Returning to Account Management page...");
			                    return;

		                default:
		                    System.out.println("Invalid choice. Please try again.");
		                    break;
		            }
		        }
			
			
		}

		private static void DowngradeAccount(Client user, MyApp app, Scanner scanner) {
			if(user.getisPremium()) {
				user.setisBasic(true);
				user.setisPremium(false);
				System.out.println("your account is downgraded successfully");
			}
			else {
				System.out.println("your account is already basic...");
			}
			
			
		}

		private static void UpgradeAccount(Client user, MyApp app, Scanner scanner) {
			if(user.getisBasic()) {
				user.setisBasic(false);
				user.setisPremium(true);
				System.out.println("your account is upgraded successfully");
			}
			else {
				System.out.println("your account is already premium...");
			}
			
		}

		public static void printDashboard() {
			System.out.println("Client Dashboard :");
	    	System.out.println("1. Account Management");
	    	System.out.println("2. Program Exploration and Enrollment");
	    	System.out.println("3. Progress Tracking");
	    	System.out.println("4. send Feedback and Reviews");
	    	System.out.println("5. Notifications");
	    	System.out.println("6. send message to instructor");
	    	System.out.println("7. read feedbacks from instructors and Admin");
	    	System.out.println("8. Logout");
	    }
	    
	    

	    

	    

	    private static void communicate(Client user, Scanner scanner,MyApp app) {
	        System.out.println("Enter instructor name to communicate with:");
	        String userType = scanner.nextLine();
	        System.out.println("Enter your message:");
	        String message = scanner.nextLine();
	        app.sendClientQuery(app.getCurrentUsername(),userType, message);
	    }

	   

	    private static void displayAccountManagementMenu() {
	        System.out.println("Manage Personal Account:");
	        System.out.println("1. Update Account Information");
	        System.out.println("2. Delete Account");
	        System.out.println("3. Upgrade/Downgrade your Account");
	        System.out.println("4. Back to Client Dashboard");
	    }

	    private static void updateAccount(Client user, MyApp app, Scanner scanner) throws IOException {
	        System.out.println("Enter your current username:");
	        String currentUsername = scanner.nextLine();
	        
	        if (!currentUsername.equals(app.getCurrentUsername())) {
	            System.out.println("Incorrect username. Cannot update account.");
	            return;
	        }

	        System.out.println("Enter new Username:");
	        String newUsername = scanner.nextLine();
	        System.out.println("Enter new Password:");
	        String newPassword = scanner.nextLine();

	        app.updateUser(currentUsername, newUsername, newPassword);

	        // Update the User object with new details
	        user.setUsername(newUsername);
	        user.setPassword(newPassword);

	        System.out.println("Account updated successfully.");
	    }

	    private static void deleteAccount(Client user, MyApp app, Scanner scanner) throws IOException {
	        System.out.println("Are you sure you want to delete your account? This action cannot be undone. (yes/no)");
	        String confirmation = scanner.nextLine();

	        if ("yes".equalsIgnoreCase(confirmation)) {
	            app.deleteUser(user.getUsername());
	            System.out.println("Account deleted successfully. Logging out...");
	            user.setUsername(null); // Clear the current user session
	            user.setPassword(null);
	        } else {
	            System.out.println("Account deletion canceled.");
	        }
	    }

	   
	}
	 
		 
		 
	

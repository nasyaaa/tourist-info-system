/*
*This is  class TestMilestone2  , driver class for the program

*Assignment OOPDS Milestone 2
*Lecture Section : TC02
*Date : 2018 - 02 - 12
*/

import java.util.*;
import java.io.*;

public class TestMilestone2{
	
	public static void main(String[] args){
		
		Scanner input = new Scanner(System.in);
		
		do{
			try{
				City c = new City();
				System.out.println("\n========================================================================\n\t\tHi, Welcome to This Program ! \n\t\t\t->Main Menu<-\n");
				System.out.print("Are you user or admin ? \n\n1 . Admin\n2 . User\n3 . Quit program\n\nSelection -> ");
				
				Scanner input1 = new Scanner(System.in);
				int sel = input1.nextInt();
				
				if (sel == 1){
					adminMenu();
				}
				else if (sel == 2){
					userMenu();
				}
				else if (sel == 3){
					endProgram();
				}
				else {
					System.out.print("Error Message : Number selected is not available at choices.\n");
				}
				
			}		
			catch(InputMismatchException ex){
				System.out.print("\n\t\tError Message : Use Integer Only!\n");
				continue;				
			}
			catch(NoSuchElementException ex){
				System.out.print("\n\t\tError Message : Use Integer Only!\n");
				continue;				
			}
			catch(Exception ex){
				System.out.print("\nError Message : Unknown Error Occured Somewhere.Restart Program.");
				continue;
			}
			
		}while(true);	
		
		
	}
	
	//Direct to admin main menu part
	public static void adminMenu(){
		
		do{
				try{
					System.out.print ("\n\n========================================================================\n\t\t\t->Welcome Admin<-\nSelect the number to continue.\n");
					System.out.print("\n1 . Add City\n2 . Add Attraction\n3 . Delete City\n4 . Delete Attraction\n5 . Load City File And All Attractions File \n6 . Add City Flights Data\n7 . Delete City Flights Data\n8 . Quit Program\n9 . Main Program\n\nSel -> ");
					Scanner input2 = new Scanner(System.in);
					int selAdmin = input2.nextInt();
					
					if (selAdmin == 1){
						adminAddCity();
					}
					else if (selAdmin == 2){
						adminAddAttraction();
					}
					else if (selAdmin == 3){
						adminDeleteCity();
					}
					else if (selAdmin == 4){
						adminDeleteAttraction();
					}
					else if (selAdmin == 5){
						adminLoadFile();
					}
					else if (selAdmin == 6){
						adminAddFlight();
					}
					else if (selAdmin == 7){
						adminRemoveFlight();
					}
					else if (selAdmin == 8){
						endProgram();
					}
					else if (selAdmin == 9){
						return;
					}
					else{
						System.out.println("Error Message : Number selected is not available at choices.");
					}
				}
				catch(InputMismatchException ex){
					System.out.print("\n\t\tError Message : Use Integer Only!\n");
					continue;				
				}
				catch(NoSuchElementException ex){
					System.out.print("\n\t\tError Message : Use Integer Only!\n");
					continue;				
				}
				catch(Exception ex){
					System.out.print("\nError Message : Unknown Error Occured Somewhere.\n");
					continue;
				}
		}while(true);
	}
	
	//Direct admin to add new city part
	public static void adminAddCity(){
		City c = new City();
				
		do{
			try{
				System.out.println("====================================City List====================================\n");
				c.loadCity();
				System.out.print("\n");	
				
				Scanner inputCode = new Scanner(System.in);
				System.out.print("\nInsert City Code : ");
				int codeCity = inputCode.nextInt();
				
				Scanner inputName = new Scanner(System.in);	
				System.out.print("Insert City Name : ");
				String nameCity = inputName.nextLine();
					
				System.out.print("\n\nDo you want to save the data created ? \nPress 1 for yes.Press other button for not.\nChoice -> ");
				Scanner inputStatus = new Scanner(System.in);
				int status = inputStatus.nextInt();
				City city1 = new City(codeCity,nameCity);
				
				if (status == 1 ){
					city1.saveCityData(codeCity,nameCity);
					System.out.print("\nMessage : Data saved.\n\n");
					adminMenu();
				}
				else{
					System.out.print("\nMessage : Data not saved.\n\n");
					adminMenu();
				}
			}
			catch(InputMismatchException ex){
					System.out.print("\n\t\tError Message : Use Integer Only!\n");
					continue;				
			}
			catch(NoSuchElementException ex){
				System.out.print("\n\t\tError Message : Use Integer Only!\n");
				continue;				
			}
			catch(Exception ex){
				System.out.print("\nError Message : Unknown Error Occured Somewhere.Restart Program.");
				return;
			}
		}while(true);	
	}
	
	//Direct admin to add new attraction part
	public static void adminAddAttraction(){
		City c = new City();
		
		do{
			try{
				System.out.print("========================================================================\n");
				System.out.print("\nWhich city code would you like to add attraction to? \n");
				c.loadCity();
				
				System.out.print("\nCity code -> ");
				Scanner inputCode = new Scanner(System.in);
				int cityCode = inputCode.nextInt();
				
				boolean exists = c.searchCity(cityCode);
				
				if (exists == true){
					System.out.print("========================================================================\n");
					System.out.print("Choose type of attraction to be inserted.\n\nFor type Sport -> 100\nFor type Culture -> 200\nFor type Shopping -> 300\n\nCode type ->");
					
					Scanner input = new Scanner(System.in);
					int sel = input.nextInt();
					
					if(sel == 100){
						
						Scanner inputName = new Scanner(System.in);
						System.out.print("\nPlace Name : ");
						String nameAtt = inputName.nextLine();
						
						Scanner inputType = new Scanner(System.in);
						System.out.print("Type of Place : ");
						String placeType = inputType.nextLine();
						
						Scanner inputHour = new Scanner(System.in);
						System.out.print("Operation Hour : ");
						String opHour = inputHour.nextLine();
						
						Scanner inputLevel = new Scanner(System.in);
						System.out.print("Difficulty Level : ");
						String level = inputLevel.nextLine();
														
						Sport s = new Sport();
						s.insertToFile(cityCode,nameAtt,100,placeType,opHour,level);
						System.out.print("Message : Data inserted succeed.");
						adminMenu();
					}
					
					else if (sel == 200){
														
						Scanner inputName = new Scanner(System.in);
						System.out.print("\nPlace Name : ");
						String nameAtt = inputName.nextLine();
						
						Scanner inputType = new Scanner(System.in);
						System.out.print("Type of Place : ");
						String placeType = inputType.nextLine();
						
						Scanner inputHour = new Scanner(System.in);
						System.out.print("Operation Hour : ");
						String opHour = inputHour.nextLine();
						
						Scanner inputFee = new Scanner(System.in);
						System.out.print("Entrance Fee : ");
						String fee = inputFee.nextLine();
						
						Culture cult = new Culture();
						cult.insertToFile(cityCode,nameAtt,200,placeType,opHour,fee);
						System.out.print("Message : Data inserted succeed.");
						adminMenu();	
					}
					
					else if (sel == 300){
						 List<String> dataShop = new ArrayList<String>();
						
						 Scanner inputName = new Scanner(System.in);
						 System.out.print("\nPlace Name : ");
						 String nameAtt = inputName.nextLine();
						
						 Scanner inputType = new Scanner(System.in);
						 System.out.print("Type of Place : ");
						 String placeType = inputType.nextLine();
						
						 Scanner inputHour = new Scanner(System.in);
						 System.out.print("Operation Hour : ");
						 String opHour = inputHour.nextLine();
						
						 Scanner inputShop = new Scanner(System.in);
						 System.out.print("Shop Highlights (press 0 to stop insert) : ");
						 
						 String stop = inputShop.nextLine();;
						  
						while(!stop.equals("0")){
							dataShop.add(stop);
							stop = inputShop.nextLine();
						}		
						
						Shopping mall = new Shopping();
						mall.insertToFile(cityCode,nameAtt,300,placeType,opHour,dataShop);
						System.out.print("Message : Data inserted succeed.");
						adminMenu();
					}
					
					else {
						System.out.println("\n\t\tError Message : The number selected is not found!\n");
					} 
				} 
				
				else if (exists == false){
					System.out.print("Error Message : City code wrong or not found!");
				}
			}
			catch(InputMismatchException ex){
				System.out.print("\n\t\tError Message : Use Integer Only!\n");
				continue;				
			}
			catch(NoSuchElementException ex){
				System.out.print("\n\t\tError Message : Use Integer Only!\n");
				continue;				
			}
			catch(Exception ex){
				System.out.print("\nError Message : Unknown Error Occured Somewhere.Restart Program.");
				return;
			}
			
		}while(true);			
	}
	
	//Direct admin to delete city and attractions related part
	public static void adminDeleteCity(){
		City c = new City();
		
		do{
			try{
				System.out.print("========================================================================\n");
				System.out.print("\nWhich city code would you like to delete ? \n");
				c.loadCity();
				
				Scanner inputCode = new Scanner(System.in);
				System.out.print("\nCity code -> ");
				int cityCode = inputCode.nextInt();
				
				boolean exists = c.searchCity(cityCode);
				
				if (exists == true){
					c.deleteCity(cityCode);
					System.out.println("Message : Deletion successful.");
					adminMenu();
				}
				else if(exists == false){
					System.out.println("Error Message : Data does not exist.");
					adminMenu();
				}
			}
			catch(InputMismatchException ex){
				System.out.print("\n\t\tError Message : Use Integer Only!\n");
				continue;				
			}
			catch(NoSuchElementException ex){
				System.out.print("\n\t\tError Message : Use Integer Only!\n");
				continue;				
			}
			catch(Exception ex){
				System.out.print("\nError Message : Unknown Error Occured Somewhere.Restart Program.");
				return;
			}
			
		}while(true);
	}
	
	//Direct admin to delete attraction by name part
	public static void adminDeleteAttraction(){
		City c = new City();
		
		do{
			try{
				System.out.println("====================================City List====================================\n");
				c.loadCity();
				System.out.print("\n");

				System.out.println("====================================Attraction List====================================\n");
				c.loadAttraction();
				System.out.print("\n");

				System.out.print("========================================================================\n");
				System.out.print("\nWhich city code would you like to delete attraction to? \n");
				c.loadCity();
				
				System.out.print("\nCity code -> ");
				Scanner inputCodeDelete = new Scanner(System.in);
				int cityCode = inputCodeDelete.nextInt();
				
				boolean exists = c.searchCity(cityCode);
				
				if (exists == true){
					System.out.print("========================================================================\n");
					System.out.print("Choose type of attraction to be deleted.\n\nFor type Sport -> 100\nFor type Culture -> 200\nFor type Shopping -> 300\n\nCode type ->");
					
					Scanner inputTypeCity = new Scanner(System.in);
					int typeCode = inputTypeCity.nextInt();
					
					if (typeCode == 100){
						
						System.out.print("\nEnter name of attraction to be deleted : ");
						Scanner inputNameAtt = new Scanner(System.in);
						String delAtt = inputNameAtt.nextLine();
						
						c.deleteAttraction(100,delAtt);
						System.out.println("\nMessage : Deletion successful.\n");
						adminMenu();
					}
					else if (typeCode == 200){
						System.out.print("\nEnter name of attraction to be deleted : ");
						Scanner inputNameAtt = new Scanner(System.in);
						String delAtt = inputNameAtt.nextLine();
						
						c.deleteAttraction(200,delAtt);
						System.out.println("\nMessage : Deletion successful.\n");
						adminMenu();
					}
					else if (typeCode == 300){
						System.out.print("\nEnter name of attraction to be deleted : ");
						Scanner inputNameAtt = new Scanner(System.in);
						String delAtt = inputNameAtt.nextLine();
						
						c.deleteAttraction(300,delAtt);
						System.out.println("\nMessage : Deletion successful.\n");
						adminMenu();
					}
					else {
						System.out.println("Error Message : Code type not found.");
					}
				}	
			}
			catch(InputMismatchException ex){
				System.out.print("\n\t\tError Message : Use Integer Only!\n");
				continue;				
			}
			catch(NoSuchElementException ex){
				System.out.print("\n\t\tError Message : Use Integer Only!\n");
				continue;				
			}
			catch(Exception ex){
				System.out.print("\nError Message : Unknown Error Occured Somewhere.Restart Program.");
				return;
			}
			
		}while(true);		
	}
	
	//Direct admin to load all file part
	public static void adminLoadFile(){
		City c = new City();
		
		System.out.println("====================================City List====================================\n");
		c.loadCity();
		System.out.print("\n");	
		System.out.println("====================================Attraction List====================================\n");
		c.loadAttraction();
		c.loadFlight();
		System.out.print("\n");
		adminMenu();
	}
	
	//Direct admin to add flight data part
	public static void adminAddFlight(){
		City c = new City();
			
		do{
			try{
				c.loadFlight();
				System.out.print("\n\n========================================================================\n");
				c.loadCity();
				System.out.print("\nWhich city that needs to be added flight?Insert city code.\n");
				System.out.print("From city (code) : ");
				
				Scanner inputFrom = new Scanner(System.in);
				int fromCode = inputFrom.nextInt();
				
				boolean exist1 = c.searchCity(fromCode);
				
				if(exist1 == true){
					System.out.print("To city (code) : ");
					Scanner inputTo = new Scanner(System.in);
					int toCode = inputTo.nextInt();
					
					boolean exist2 = c.searchCity(toCode);
					
					if (exist2 == true){
						
						if (toCode == fromCode){
						System.out.print("\nError Message : Code city has been entered.\n");
						}
						
						else{
							boolean exist3 = c.searchFlight(fromCode,toCode);
							
							if(exist3 == true){
								System.out.print("\nMessage : Flight data inserted already exist\n");
							}
							else if (exist3 == false){
								c.addFlightData(fromCode,toCode);
							}
							
							adminMenu();
						}						
					}
					else if(exist2 == false){
						System.out.print("\nError Message : No city found with the code.\n");
					}				
					
				}
				else if (exist1 == false){
					System.out.print("\nError Message : No city found with the code.\n");
				}
				
			}
			catch(InputMismatchException ex){
				System.out.print("\n\t\tError Message : Use Integer Only!\n");
				continue;				
			}
			catch(NoSuchElementException ex){
				System.out.print("\n\t\tError Message : Use Integer Only!\n");
				continue;				
			}
			catch(Exception ex){
				System.out.print("\nError Message : Unknown Error Occured Somewhere.Restart Program.");
				return;
			}
			
		}while(true);
	}
	
	//Direct admin to remove flight data
	public static void adminRemoveFlight(){
		City c = new City();
		
		do{
			try{
				c.loadFlight();
				System.out.print("\n\n========================================================================\n");
				c.loadCity();
				System.out.print("\nWhich flight city data that needs to be deleted?Insert city code.\n");
				System.out.print("From city (code) : ");
				
				Scanner inputFrom = new Scanner(System.in);
				int fromCode = inputFrom.nextInt();
				
				boolean exist1 = c.searchCity(fromCode);
				
				if(exist1 == true){
					System.out.print("To city (code) : ");
					Scanner inputTo = new Scanner(System.in);
					int toCode = inputTo.nextInt();
					
					boolean exist2 = c.searchCity(toCode);
					
					if (exist2 == true){
						
						if (toCode == fromCode){
						System.out.print("\nError Message : Code city has been entered.\n");
						}
						
						else{
							boolean exist3 = c.searchFlight(fromCode,toCode);
							
							if(exist3 == true){
								c.deleteFlightData(fromCode,toCode);
								System.out.print("\n\nMessage : Deletion successful.\n");	
							}
							else if (exist3 == false){
								System.out.print("\nMessage : Flight data to be deleted does not exist\n");
							}					
							
						}						
					}
					else if(exist2 == false){
						System.out.print("\nError Message : No city found with the code.\n");
					}
					
					
				}
				else if (exist1 == false){
					System.out.print("\nError Message : No city found with the code.\n");
				}
				
				adminMenu();
			}
			catch(InputMismatchException ex){
				System.out.print("\n\t\tError Message : Use Integer Only!\n");
				continue;				
			}
			catch(NoSuchElementException ex){
				System.out.print("\n\t\tError Message : Use Integer Only!\n");
				continue;				
			}
			catch(Exception ex){
				System.out.print("\nError Message : Unknown Error Occured Somewhere.Restart Program.");
				return;
			}
			
		}while(true);
	}
	
	//Direct to user main menu
	public static void userMenu(){
	City c = new City();	
		
		do{
			try{
				System.out.println("\n========================================================================\n\t\t\tHi User! \n\t\t\t->Main Menu<-\n");
				System.out.print("Enter the number to select features.\n\n1 . See All Attractions in City\n2 . See Attraction in City According to Categories\n3 . Check flight exist \n4 . Quit Program.\n\nSelection -> ");
				
				Scanner inputSel = new Scanner(System.in);
				int  choice = inputSel.nextInt();
				
				if (choice == 1){
					userSeeAllAttraction();					
				}
				else if(choice == 2){
					userSeeAttAccType();
				}
				else if(choice == 3){
					userCheckFlight();
				}
				else if(choice == 4){
					endProgram();
				}
				else {
					System.out.println("Error Message : Number selected is not available at choices.");
				}
			}
			catch(InputMismatchException ex){
				System.out.print("\n\t\tError Message : Use Integer Only!\n");
				continue;				
			}
			catch(NoSuchElementException ex){
				System.out.print("\n\t\tError Message : Use Integer Only!\n");
				continue;				
			}
			catch(Exception ex){
				System.out.print("\nError Message : Unknown Error Occured Somewhere.Restart Program.");
				return;
			}			
			
		}while(true);
	}
	
	//Direct user to check flight available or not part
	public static void userCheckFlight(){
		City c = new City();
		do{
			try{
				System.out.print("\n========================================================================\n");
				c.loadCity();
				System.out.print("\nWhich city flight data need to be viewed ? Insert city code.\n");
				System.out.print("From city (code) : ");
				
				Scanner inputFrom = new Scanner(System.in);
				int fromCode = inputFrom.nextInt();
				
				boolean exist1 = c.searchCity(fromCode);
				if(exist1 == true){
					System.out.print("To city (code) : ");
					Scanner inputTo = new Scanner(System.in);
					int toCode = inputTo.nextInt();
					
					boolean exist2 = c.searchCity(toCode);
					
					if (exist2 == true){
						
						if (toCode == fromCode){
						System.out.print("\nError Message : Code city has been entered.\n");
						}
						
						else{
							boolean exist3 = c.searchFlight(fromCode,toCode);
							
							if(exist3 == true){
								System.out.print("\nResult : Direct flight exist.\n");
							}
							else if (exist3 == false){
								System.out.print("\nResult : Direct flight does exist.\n");
							}
							
							Scanner inputBack = new Scanner(System.in);
							System.out.print("\nPress 1 to go to back.Else , press any number.\n\nSelection ->");
							int back = inputBack.nextInt();
							
							if (back == 1){
								userMenu();
							}
						}						
					}
					else if(exist2 == false){
						System.out.print("\nError Message : No city found with the code.\n");
					}
					
					
				}
				else if (exist1 == false){
					System.out.print("\nError Message : No city found with the code.\n");
				}
				
			}
			catch(InputMismatchException ex){
				System.out.print("\n\t\tError Message : Use Integer Only!\n");
				continue;				
			}
			catch(NoSuchElementException ex){
				System.out.print("\n\t\tError Message : Use Integer Only!\n");
				continue;				
			}
			catch(Exception ex){
				System.out.print("\nError Message : Unknown Error Occured Somewhere.Restart Program.");
				return;
			}
			
		}while(true);
	}
	
	//Direct user to view attraction of a city
	public static void userSeeAllAttraction(){
		City c = new City();
		do{
			try{
				System.out.println("\n========================================================================\n");
				c.loadCity();
				System.out.print("\n");	
				
				Scanner inputCode = new Scanner(System.in);
				System.out.print("\nInsert City Code : ");
				int codeCity = inputCode.nextInt();
				
				boolean exists = c.searchCity(codeCity);
				if(exists == true){
					System.out.println("\n=============================Attraction List==============================\n");
					c.displayAttractionNameAccCity(codeCity);
					
					System.out.print("\nWhich attraction would you like to view ? \n\nAttraction Name -> ");
					Scanner inputSee = new Scanner(System.in);
					String name = inputSee.nextLine();
					System.out.print("\n\n");
					c.displayAttractionDesc(name,codeCity);
				}
				
				else if (exists == false){
					System.out.print("\nError Message : Data does not exist.\n");
				}
				
				Scanner inputBack = new Scanner(System.in);
				System.out.print("\n\nPress 1 to direct to main menu . Else , press any key.\n\nSelection ->");
				int back = inputBack.nextInt();
				
				if (back == 1){
					userMenu();
				}
			}
			catch(InputMismatchException ex){
				System.out.print("\n\t\tError Message : Use Integer Only!\n");
				continue;				
			}
			catch(NoSuchElementException ex){
				System.out.print("\n\t\tError Message : Use Integer Only!\n");
				continue;				
			}
			catch(Exception ex){
				System.out.print("\nError Message : Unknown Error Occurred Somewhere.Restart Program.");
				return;
			}
			
		}while(true);
	}
	
	//Direct user to view attraction according to type and city
	public static void userSeeAttAccType(){
		City c = new City();
		
		do{
			try{
				System.out.println("\n========================================================================\n");
				c.loadCity();
				System.out.print("\n");	
				
				Scanner inputCode = new Scanner(System.in);
				System.out.print("\nInsert City Code : ");
				int codeCity = inputCode.nextInt();
				
				boolean exists = c.searchCity(codeCity);
				if (exists == true){
					System.out.print("\n\nChoose type of attraction to be inserted.\n\nFor type Sport -> 100\nFor type Culture -> 200\nFor type Shopping -> 300\n\nCode type ->");
					Scanner inputType = new Scanner(System.in);
					
					int typeCat = inputType.nextInt();
					if (typeCat == 100){
						System.out.println("\n=============================Attraction List==============================\n");
						c.displayAttractionNameAccType(codeCity,100);
						
						System.out.print("\nWhich attraction would you like to view ? \n\nAttraction Name -> ");
						Scanner inputSee = new Scanner(System.in);
						String name = inputSee.nextLine();
						System.out.print("\n\n");
						c.displayAttractionDesc(name,codeCity);
					}
					else if (typeCat == 200){
						System.out.println("\n=============================Attraction List==============================\n");
						c.displayAttractionNameAccType(codeCity,200);
						
						System.out.print("\nWhich attraction would you like to view ? \n\nAttraction Name -> ");
						Scanner inputSee = new Scanner(System.in);
						String name = inputSee.nextLine();
						System.out.print("\n\n");
						c.displayAttractionDesc(name,codeCity);
					}
					else if (typeCat == 300){
						System.out.println("\n=============================Attraction List==============================\n");
						c.displayAttractionNameAccType(codeCity,300);
						
						System.out.print("\nWhich attraction would you like to view ? \n\nAttraction Name -> ");
						Scanner inputSee = new Scanner(System.in);
						String name = inputSee.nextLine();
						System.out.print("\n\n");
						c.displayAttractionDesc(name,codeCity);
					}
					else{
						System.out.println("\nError Message : Code type does not exist.\n");
					}				
				}
				else if (exists == false){
					System.out.print("\nError Message : Data does not exist.\n");
				}
				
				Scanner inputBack = new Scanner(System.in);
				System.out.print("\n\nPress 1 to direct to main menu . Else , press any key.\n\nSelection ->");
				int back = inputBack.nextInt();
				
				if (back == 1){
					userMenu();
				}	
				
			}
			catch(InputMismatchException ex){
				System.out.print("\n\t\tError Message : Use Integer Only!\n");
				continue;				
			}
			catch(NoSuchElementException ex){
				System.out.print("\n\t\tError Message : Use Integer Only!\n");
				continue;				
			}
			catch(Exception ex){
				System.out.print("\nError Message : Unknown Error Occurred Somewhere.Restart Program.");
				return;
			}
		}while(true);
		
	}
	
	//Quit program
	public static void endProgram(){
		System.out.print("\n------------------------- You have chosen to quit this program.Thank you and have a nice day! ;) --------------------------\n");
		System.exit(0);
	}

}
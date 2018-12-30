/*
*This is  class City  , helper class for the program

*Assignment OOPDS Milestone 2
*Lecture Section : TC02
*Date : 2018 - 02 - 12
*/

import java.util.*;
import java.io.*;

public class City{
	private String nameCity;
	private int codeCity;
	
	public City(){}
	public City(int codeCity,String nameCity){
		this.nameCity = nameCity;
		this.codeCity = codeCity;
		
	}
	
	//Return city name 
	public String getNameCity(){
		return nameCity;
	}
	
	//Return city code
	public int getCodeCity(){
		return codeCity;
	}
	
	//Return true if city exist from City.txt
	public boolean searchCity(int s){
		boolean found = false;
		
		ArrayList<City> list = getListCity();
		
		for(City values:list)
			if (values.getCodeCity() == s){
				found = true;
			}
		
		
		if (found != true){
			return false;
		}
		
		return true;
	}	
	
	//Return true if flight exists
	public boolean searchFlight(int fromCode,int toCode){
		boolean result = false;
		String placeFrom = "";
		String placeTo = "";
		
		
		for (City values : getListCity()){
			if(values.getCodeCity() == fromCode){
				placeFrom = values.getNameCity();
			}				
		}
		
		for (City values : getListCity()){
			if(values.getCodeCity() == toCode){
				placeTo = values.getNameCity();
			}	
		}
		
		String same = placeFrom + ":" + placeTo;
		
		
		
		for (String values : getFlightList()){
			if (values.contains(same)){
				result = true;
			}
		}
		
		return result;
	}
	
	//Return list of cities from City.txt
	public ArrayList<City> getListCity(){
		ArrayList<City> x = new ArrayList<>();
		
		try{
			Scanner scan = new Scanner(new File("City.txt"));
			ArrayList<City> cityList = new ArrayList<>();			
			while(scan.hasNextLine()){
				String lines = scan.nextLine();
				String[] data = lines.split(",");
				String code = data[0];
				String name = data[1];
				int codeNum = Integer.parseInt(code);
				City c = new City(codeNum,name);
				cityList.add(c);
			}
			x = cityList;
			scan.close();
		}
		catch(Exception e){
			System.out.println("Error Message : Error has occured somewhere.");
		}
		
		return (x);
	}
	
	//Return list of flights from Flight.txt
	public ArrayList<String> getFlightList(){
		ArrayList<String> x = new ArrayList<>();
		
		try{
			Scanner s = new Scanner(new File("Flight.txt"));
			ArrayList<String> flight = new ArrayList<>();	
			while (s.hasNextLine()){
				flight.add(s.nextLine());
			}
			x = flight;
			s.close();
		}
		catch(Exception e){
			System.out.println("Error Message : Error has occured somewhere.");
		}
		
		return (x);
	}
	
	//Save new city data to City.txt
	public void saveCityData(int s,String nameCity){
		try{
			FileWriter fw = new FileWriter(("City.txt"),true);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(s + "");
			bw.write(",");
			bw.write(nameCity);
			bw.newLine();
			bw.close();
			fw.close();
		}
		catch(IOException e){
			System.out.println("Error Message : File error .");
		}
	}
	
	//Load file City.txt
	public void loadCity(){
		ArrayList<City> listCity = getListCity();
			
		for(City values:listCity)
			System.out.print(values.toString());
		
	}
	
	//Load all Attraction file -> Sport.txt , Culture.txt , Shopping.txt
	public void loadAttraction(){
		
		try{
			System.out.print("\nSports Attraction : \n\n");
			
			Scanner scanSport = new Scanner (new File("Sport.txt"));
			
			while (scanSport.hasNextLine()){
				String line = scanSport.nextLine();
				System.out.println(line);
			}
			
			System.out.print("\n\nCulture Attraction : \n\n");
			
			Scanner scanCul = new Scanner (new File("Culture.txt"));
			
			while (scanCul.hasNextLine()){
				String line = scanCul.nextLine();
				System.out.println(line);
			}
			
			System.out.print("\n\nShopping Attraction : \n\n");
			
			Scanner scanShop = new Scanner (new File("Shopping.txt"));
			
			while (scanShop.hasNextLine()){
				String line = scanShop.nextLine();
				System.out.println(line);
			}
		}
		catch (Exception e){
			System.out.println("File not found!");
		}	
	}
	
	//Load file Flight.txt
	public void loadFlight(){
		try{
			ArrayList<String> cityFromList = new ArrayList<>();
			ArrayList<String> cityToList = new ArrayList<>();
			BufferedReader br = new BufferedReader(new FileReader("Flight.txt"));
			String fileRead = br.readLine();
			
			while(fileRead != null){
				
				String[] data = fileRead.split(":");
				String fromFile = data[0];
				String toFile = data[1];
				cityFromList.add(fromFile);
				cityToList.add(toFile);
				fileRead = br.readLine();
			}
			br.close();
			
			System.out.println("\n=============================Flight Data List==============================\n");
			
			for (int i = 0 ; i<cityFromList.size() ; i++){
				System.out.print(cityFromList.get(i) + " -> " + cityToList.get(i) + "\n");
			}
			
		}
		catch(Exception e){
			System.out.println(e.toString());
			return;
		}
	}
	
	//Delete data City from user input and attractions in it 
	public void deleteCity(int s){
		int x = 0;
		String code = "";		
		ArrayList<City> list1 = getListCity();
		
		try{
			FileWriter file1 = new FileWriter("City.txt");
			file1.write("");
			file1.close();
			
			for (City values : list1){
				if(values.getCodeCity() != s){
					x = values.getCodeCity();
					code = x + "";
					
					FileWriter fw = new FileWriter(("City.txt"),true);
					BufferedWriter bw = new BufferedWriter(fw);
					bw.write(code);
					bw.write(",");
					bw.write(values.getNameCity());
					bw.newLine();
					bw.close();
					fw.close();
				}
			}
			
			Culture.deleteFromCity(s);
			Sport.deleteFromCity(s);			
			Shopping.deleteFromCity(s);
			
		}
		catch(Exception e){
			System.out.println("Error Message : File error!");
		}	
	}
	
	//Delete one attractions given by user
	public void deleteAttraction(int t , String name){
		if (t == 100){
			Sport.deleteAttractionTypeSp(name);
		}
		
		else if (t == 200){
			Culture.deleteAttractionTypeCl(name);
		}
		
		else {
			Shopping.deleteAttractionTypeSh(name);
		}	
	}
	
	//Add new flight data to Flight.txt
	public void addFlightData(int fromCode , int toCode){
		try{
			String placeFrom = "";
			String placeTo = "";
			
			for (City values : getListCity()){
				if(values.getCodeCity() == fromCode){
					placeFrom = values.getNameCity();
				}
				else if(values.getCodeCity() == toCode){
					placeTo = values.getNameCity();
				}	
			}
			
			FileWriter fw = new FileWriter(("Flight.txt"),true);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(placeFrom);
			bw.write(":");
			bw.write(placeTo);
			bw.newLine();
			bw.close();
			fw.close();
		}
		catch(Exception e){
			System.out.print("Error Message : Error has occured somewhere.");
			return;
		}
	}
	
	//Delete flight data existed from Flight.txt
	public void deleteFlightData(int fromCode , int toCode){
		try{
			String placeFrom = "";
			String placeTo = "";
			
			for (City values : getListCity()){
				if(values.getCodeCity() == fromCode){
					placeFrom = values.getNameCity();
				}
				else if(values.getCodeCity() == toCode){
					placeTo = values.getNameCity();
				}	
			}
			
			String toBeDeleted = placeFrom + ":" + placeTo;
						
			File inFile = new File("Flight.txt");
			File temp = new File("Flight.tmp");
			
			BufferedReader br = new BufferedReader(new FileReader("Flight.txt"));
			PrintWriter pw = new PrintWriter(new FileWriter(temp));

			String lines = null;
			
			while ((lines = br.readLine()) != null) {
				if (!lines.equals(toBeDeleted)) {

				  pw.println(lines);
				  pw.flush();
				}
			}
			pw.close();
			br.close();
			
			if (!inFile.delete()) {
				System.out.println("Error Message : File access problem.");
				return;
			}	
			
			if (!temp.renameTo(inFile)){
				System.out.println("Error Message : Could not rename file.");
			}
			
		}
		catch(Exception e){
			System.out.println(e.toString());
			return;
		}		
	}
	
	//Display City name and ID city	
	public String toString(){
		return getCodeCity() + " . " + getNameCity() + "\n";
	}	
	
	//Display All Attraction Name Place for one city
	public void displayAttractionNameAccCity(int s){
		boolean available = false;
				
		try{
			ArrayList<Attraction> att1  = new ArrayList<>();
			
			Sport sp = new Sport();
			ArrayList<Sport> spList = sp.getListSport(s);
			for (Sport values : spList){
				att1.add(values);				
			}
			
			Culture cl = new Culture();
			ArrayList<Culture> clList = cl.getListCulture(s);
			for (Culture values : clList){
				att1.add(values);
			}
			
			Shopping sh = new Shopping();
			ArrayList<Shopping> shList = sh.getListShopping(s);
			for (Shopping values : shList){
				att1.add(values);
			}
			
			for(Attraction values : att1){
				System.out.print(values.toStringName());
				available = true;
			}
						
			if (available == false){
				System.out.print("\nMessage : No attraction available yet for this city.\n");
			}
		}
		catch (Exception e){
			System.out.print("\nError Message : Error in accessing file.\n ");
		}	
	}

	//Display All Attraction Name Place for one city according to type
	public void displayAttractionNameAccType(int s,int t){
		boolean available = false;
			
		try{
			if (t == 100){
				
				Sport sp = new Sport();
				ArrayList<Sport> spList = sp.getListSport(s);
				for (Sport values : spList){
					System.out.print(values.toStringName());
					available = true;
				}	
			}
			else if (t == 200){
				Culture cl = new Culture();
				ArrayList<Culture> clList = cl.getListCulture(s);
				for (Culture values : clList){
					System.out.print(values.toStringName());
					available = true;
				}				
			}
			else{
				Shopping sh = new Shopping();
				ArrayList<Shopping> shList = sh.getListShopping(s);
				for (Shopping values : shList){
					System.out.print(values.toStringName());
					available = true;
				}				
			}			
			if (available == false){
				System.out.println("Error Message : Attraction has not existed yet for city");
			}
		}
		catch (Exception e){
			System.out.print("\nError Message : Error in accessing file.\n ");
		}	
	}
	
	//Display attraction name and description
	public void displayAttractionDesc(String name,int s){
		try{
			boolean available = false;				
		
			ArrayList<Attraction> att1  = new ArrayList<>();
			
			Sport sp = new Sport();
			ArrayList<Sport> spList = sp.getListSport(s);
			for (Sport value1 : spList){
				att1.add(value1);				
			}
			
			Culture cl = new Culture();
			ArrayList<Culture> clList = cl.getListCulture(s);
			for (Culture value2 : clList){
				att1.add(value2);
			}
			
			Shopping sh = new Shopping();
			ArrayList<Shopping> shList = sh.getListShopping(s);
			for (Shopping value3 : shList){
				att1.add(value3);
			}
			
			for(Attraction value4 : att1){
				if (value4.getName().contains(name)){
					System.out.print(value4.toString());
					available = true;
				}				
			}
						
			if (available == false){
				System.out.print("\nMessage : Attraction Not Exist Or Wrong Name Inserted\n");
			}
		}
		catch (Exception e){
			System.out.print("\nError Message : Error in accessing file.\n ");
		}	
	}
}
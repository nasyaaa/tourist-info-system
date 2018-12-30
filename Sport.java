/*
*This is  class Sport  , helper class for the program

*Assignment OOPDS Milestone 2
*Lecture Section : TC02
*Date : 2018 - 02 - 12
*/

import java.io.*;
import java.util.*;

class Sport extends Attraction{
	private String level;
	
	public Sport(){}
	
	public Sport(int cityCode,String name,int typeId,String placeType,String operationHour, String level){
		super(cityCode,name,typeId,placeType,operationHour);
		this.level = level;
		
	}
	
	//insert new data to Sport.txt file
	public void insertToFile(int cityCode,String name,int typeId,String placeType,String operationHour, String level){
		try{
			FileWriter fw = new FileWriter(("Sport.txt"),true);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(cityCode + "");
			bw.write(",");
			bw.write(name);
			bw.write(",");
			bw.write(typeId + "");
			bw.write(",");
			bw.write(placeType);
			bw.write(",");
			bw.write(operationHour);
			bw.write(",");
			bw.write(level);
			bw.newLine();
			bw.close();
			fw.close();
		}
		catch(IOException e){
			System.out.println("Error Message : File error .");
		}
	}
	
	//Return list of Culture from Sport.txt	
	public static ArrayList<Sport> getListSport(int m){
		ArrayList<Sport> x = new ArrayList<>();
		int codeNum;
		String namePlace;
		int typeNum;
		String placeType;
		String opHour;
		String level;
		
		try{
			ArrayList<Sport> spList = new ArrayList<>();
			
			BufferedReader br = new BufferedReader(new FileReader("Sport.txt"));
			String fileRead = br.readLine();
			
			while(fileRead != null){
				
				String[] data = fileRead.split(",");				
				codeNum = Integer.parseInt(data[0]);
				namePlace = data[1];
				typeNum = Integer.parseInt(data[2]);
				placeType = data[3];
				opHour = data[4];
				level = data[5];
				
				if(codeNum == m){
					Sport s = new Sport(codeNum,namePlace,typeNum,placeType,opHour,level);
					spList.add(s);
				}
				fileRead = br.readLine();
			}
			br.close();
			x = spList;
		}
		catch(Exception e){
			System.out.println("Error Message : Error has occured somewhere.");
		}
		
		return (x);
	}
		
	//Return level of difficulty of the activity
	public String getLevel(){
		return level;
	}
	
	//Display Description of place
	public String toString(){
		return getName() + "\nOperation Hour : " + getOperationHour() + "\nType Of Place Sports : " 
		+ getPlaceType() + "\nLevel : " + level + "\n\n";
	}

	//Delete All Sport attractions that start with given city ID 
	public static void deleteFromCity(int s){
		try{
			
			String s1 = s + "";
			File inFile = new File("Sport.txt");
			File temp = new File("Sport.tmp");
			
			BufferedReader br = new BufferedReader(new FileReader("Sport.txt"));
			PrintWriter pw = new PrintWriter(new FileWriter(temp));

			String lines = null;
			
			while ((lines = br.readLine()) != null) {
				if (!lines.startsWith(s1)) {

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
			System.out.println("Error Message : Error occured somewhere.\n");
		}	
	}
	
	//Delete Sport attraction that contains user input name
	public static void deleteAttractionTypeSp(String name){
		int codeNum;
		String namePlace;
		int typeNum;
		String placeType;
		String opHour;
		String level;
		
		try{
			ArrayList<Sport> spList = new ArrayList<>();
			
			BufferedReader br = new BufferedReader(new FileReader("Sport.txt"));
			String fileRead = br.readLine();
			
			while(fileRead != null){
				
				String[] data = fileRead.split(",");				
				codeNum = Integer.parseInt(data[0]);
				namePlace = data[1];
				typeNum = Integer.parseInt(data[2]);
				placeType = data[3];
				opHour = data[4];
				level = data[5];
				
				if (!namePlace.contains(name)){
					Sport s = new Sport(codeNum,namePlace,typeNum,placeType,opHour,level);
					spList.add(s);					
				}	
				fileRead = br.readLine();
			}
			br.close();
			
			FileWriter file1 = new FileWriter("Sport.txt");
			file1.write("");
			file1.close();
			
			for (Sport values : spList){
				codeNum = values.getCityCode();
				namePlace = values.getName();
				typeNum = 100;
				placeType = values.getPlaceType();
				opHour = values.getOperationHour();
				level = values.getLevel();
				values.insertToFile(codeNum,namePlace,typeNum,placeType,opHour,level);
			}
		}
		catch(Exception e){
			System.out.println("Error Message : Error occured somewhere.\n");
		}
	}
	
	//Display place name only
	public String toStringName(){
		return "* Sport * " + getName() + "\n";
	}
}
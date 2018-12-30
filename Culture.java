/*
*This is  class Culture  , helper class for the program

*Assignment OOPDS Milestone 2
*Lecture Section : TC02
*Date : 2018 - 02 - 12
*/

import java.util.*;
import java.io.*;

class Culture extends Attraction{
	private String entranceFee;
	
	public Culture(){}
	
	public Culture (int cityCode,String name ,int typeId,String placeType , String operationHour , String entranceFee)
	{
		super(cityCode,name,typeId,placeType,operationHour);
		this.entranceFee = entranceFee;	
		
	}
	
	//insert new data to Culture.txt file
	public void insertToFile(int cityCode,String name ,int typeId,String placeType , String operationHour , String entranceFee){
		try{
			FileWriter fw = new FileWriter(("Culture.txt"),true);
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
			bw.write(entranceFee);
			bw.newLine();
			bw.close();
			fw.close();
		}
		catch(IOException e){
			System.out.println("Error Message : File error .");
		}
	}
	
	//Return list of Culture from Culture.txt
	public static ArrayList<Culture> getListCulture(int s){
		ArrayList<Culture> x = new ArrayList<>();
		
		try{
			ArrayList<Culture> culList = new ArrayList<>();	
			BufferedReader br = new BufferedReader(new FileReader("Culture.txt"));
			String fileRead = br.readLine();			
			ArrayList<Sport> spList = new ArrayList<>();	
			
			while(fileRead != null){
				
				String[] data = fileRead.split(",");				
				int codeNum = Integer.parseInt(data[0]);
				String namePlace = data[1];
				int typeNum = Integer.parseInt(data[2]);
				String placeType = data[3];
				String opHour = data[4];
				String fee = data[5];
					
				if (codeNum == s){
					Culture c = new Culture(codeNum,namePlace,typeNum,placeType,opHour,fee);
					culList.add(c);
				}
				
				fileRead = br.readLine();
			}
			br.close();
			x = culList;
		}
		catch(Exception e){
			System.out.println("Error Message : Error has occured somewhere.");
		}
		
		return (x);
	}
	
	//Return entrance fee for the place
	public String getEntranceFee(){
		return entranceFee;
	}
	
	//Delete All Culture attractions that start with given city ID 
	public static void deleteFromCity(int s){
		try{
			
			String s1 = s + "";
			File inFile = new File("Culture.txt");
			File temp = new File("Culture.tmp");
			
			BufferedReader br = new BufferedReader(new FileReader("Culture.txt"));
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
	
	//Delete Culture attraction that contains user input name
	public static void deleteAttractionTypeCl(String name){
		int codeNum;
		String namePlace;
		int typeNum;
		String placeType;
		String opHour;
		String entranceFee;
		
		try{
			ArrayList<Culture> clList = new ArrayList<>();
			
			BufferedReader br = new BufferedReader(new FileReader("Culture.txt"));
			String fileRead = br.readLine();
			
			while(fileRead != null){
				
				String[] data = fileRead.split(",");				
				codeNum = Integer.parseInt(data[0]);
				namePlace = data[1];
				typeNum = Integer.parseInt(data[2]);
				placeType = data[3];
				opHour = data[4];
				entranceFee = data[5];
				
				if (!namePlace.contains(name)){
					Culture s = new Culture(codeNum,namePlace,typeNum,placeType,opHour,entranceFee);
					clList.add(s);					
				}	
				fileRead = br.readLine();
			}
			br.close();
			
			FileWriter file1 = new FileWriter("Culture.txt");
			file1.write("");
			file1.close();
			
			for (Culture values : clList){
				codeNum = values.getCityCode();
				namePlace = values.getName();
				typeNum = 100;
				placeType = values.getPlaceType();
				opHour = values.getOperationHour();
				entranceFee = values.getEntranceFee();
				values.insertToFile(codeNum,namePlace,typeNum,placeType,opHour,entranceFee);
			}
		}
		catch(Exception e){
			System.out.println("Error Message : Error occured somewhere.\n");
		}
	}
	
	//Display Description of place 
	public String toString(){
		return getName() + "\nOperation Hour : " + getOperationHour() + "\nType Of Place Sports : " 
		+ getPlaceType() + "\nEntrance Fee : " + entranceFee + "\n\n";
	}

	//Display place name only
	public String toStringName(){
		return "* Culture * " + getName() + "\n";
	}
}
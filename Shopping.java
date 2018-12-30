/*
*This is  class Shopping  , helper class for the program

*Assignment OOPDS Milestone 2
*Lecture Section : TC02
*Date : 2018 - 02 - 12
*/

import java.io.*;
import java.util.*;

class Shopping extends Attraction{
	private List<String> shops = new ArrayList<String>();
	
	public Shopping(){}
	
	public Shopping(int cityCode , String name , int typeId , String placeType , String operationHour , List<String> shops){
		super(cityCode,name,typeId,placeType,operationHour);
		this.shops = shops;		
	}
	
	//insert new data to Shopping.txt file
	public void insertToFile(int cityCode , String name , int typeId , String placeType , String operationHour , List<String> shops){
		try{
			FileWriter fw = new FileWriter(("Shopping.txt"),true);
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
			bw.write(getShopList(shops));
			bw.newLine();
			bw.close();
			fw.close();
		}
		catch(IOException e){
			System.out.println("Error Message : File error .");
		}
	}
	
	//Delete shopping attraction that contains user input name
	public static void deleteAttractionTypeSh(String name){
		int codeNum;
		String namePlace;
		int typeNum;
		String placeType;
		String opHour;
		String shops;
				
		try{
			ArrayList<Shopping> shList = new ArrayList<>();
			
			BufferedReader br = new BufferedReader(new FileReader("Shopping.txt"));
			String fileRead = br.readLine();
			
			while(fileRead != null){
				
				String[] data = fileRead.split(",");				
				codeNum = Integer.parseInt(data[0]);
				namePlace = data[1];
				typeNum = Integer.parseInt(data[2]);
				placeType = data[3];
				opHour = data[4];
				shops = data[5];				
				List<String> shopsDataNew = Arrays.asList(shops.split(";|\\[|\\]"));	
				
				if (!namePlace.contains(name)){
					Shopping s = new Shopping(codeNum,namePlace,typeNum,placeType,opHour,shopsDataNew);
					shList.add(s);					
				}	
				fileRead = br.readLine();
			}
			br.close();
			
			FileWriter file1 = new FileWriter("Shopping.txt");
			file1.write("");
			file1.close();
			
			for (Shopping values : shList){
				codeNum = values.getCityCode();
				namePlace = values.getName();
				typeNum = 100;
				placeType = values.getPlaceType();
				opHour = values.getOperationHour();
				List<String> shopsDataNew = values.getShops();
				values.insertToFile(codeNum,namePlace,typeNum,placeType,opHour,shopsDataNew);
			}
		}
		catch(Exception e){
			System.out.println("Error Message : Error occured somewhere.\n");
		}
	}
	
	//Return list of Culture from Shopping.txt
	public static ArrayList<Shopping> getListShopping(int m){
		ArrayList<Shopping> x = new ArrayList<>();
		
		try{
			BufferedReader br = new BufferedReader(new FileReader("Shopping.txt"));
			String fileRead = br.readLine();
			
			ArrayList<Shopping> spList = new ArrayList<>();			
			while(fileRead != null){
				String[] data = fileRead.split(",");				
				String code = data[0];
				int codeNum = Integer.parseInt(code);
				String namePlace = data[1];
				String typeId = data[2];
				int typeNum = Integer.parseInt(typeId);
				String placeType = data[3];
				String opHour = data[4];
				String shops = data[5];				
				List<String> shopsDataNew = Arrays.asList(shops.split(";|\\[|\\]")); 
					
				if(codeNum == m){
					Shopping s = new Shopping(codeNum,namePlace,typeNum,placeType,opHour,shopsDataNew);
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
	
	//Delete All Shopping attractions that start with given city ID 	
	public static void deleteFromCity(int s){
		try{
			
			String s1 = s + "";
			File inFile = new File("Shopping.txt");
			File temp = new File("Shopping.tmp");
			
			BufferedReader br = new BufferedReader(new FileReader("Shopping.txt"));
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
	
	//Return list of shops available	
	public List<String> getShops(){
		return shops;
	}
	
	//Return string of shops available in this place	
	public String getShopList( List<String> shops){
		String list = "[";
		
		for (int i = 0 ; i<shops.size() ; i++){
			if (i != 0){
				
				list = list + ";" + shops.get(i);
			}			
			else {
				list = list + shops.get(i);
			}
		}		
		list = list + "]";
		
		return list;
	}
	
	//Display Description of place
	public String toString(){
		return "\t\t" + getName() + "\nPlace Type : " + getPlaceType() + "\nOperation Hour : " + getOperationHour() + "\nPlace Highlights :  " + getShopList(shops);
	}
	
	//Display place name only
	public String toStringName(){
		return "* Shopping * " + getName() + "\n";
	}
}
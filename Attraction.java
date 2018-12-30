/*
*This is  class Attraction  , helper class for the program

*Assignment OOPDS Milestone 2
*Lecture Section : TC02
*Date : 2018 - 02 - 12
*/

import java.util.*;

abstract class Attraction<E extends Attraction> {
	
	private String name;
	private int typeId ;
	private String operationHour;
	private City city;
	private String placeType;
	private int cityCode;
		
	protected Attraction(){}
	
	protected Attraction(int cityCode,String name ,int typeId,String placeType,String operationHour){
		this.cityCode = cityCode;
		this.name = name;
		this.typeId = typeId;
		this.placeType = placeType;	
		this.operationHour = operationHour;
	}	
	
	//Return city code of the place
	public int getCityCode(){
		return cityCode;
	}
	
	//Return name of place
	public String getName(){
		return name;
	}	
	
	//Return ID for every type (100 Sport , 200 Culture , 300 Shopping) 
	public int getTypeId(){
		return typeId;
	}
	
	//Return type of place 
	public String getPlaceType(){
		return placeType;
	}
	
	//Return operation hour
	public String getOperationHour(){
		return operationHour;
	}	
	
	//Display Description of place
	public abstract String toString();
	
	//Display place name only
	public abstract String toStringName();	
}
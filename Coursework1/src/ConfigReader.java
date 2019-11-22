import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ConfigReader {
	//represents a line in the file
	public String line;

	protected BufferedReader reader;
	
	//instantiates an array list of lines in the file
	ArrayList<String[]> listOfEachLine = new ArrayList<String[]>();
	private int totalNoOfHouseMembers;

	//configreader constructor reads file
	//and catches I/O exceptions if needs be
	public ConfigReader(String fileName) {
		try {
			reader = new BufferedReader(new FileReader(fileName));
		} catch (FileNotFoundException e) {
			System.out.println("File not found.");
			e.printStackTrace();
		}
		//populates list of the lines
		listOfEachLine = getLineList();
		//adds up number of house members and assigns the total totalNoOfHouseMembers
		totalNoOfHouseMembers = tallyHouseMembers();
	}
	
	
	//returns a line in the file
		public String getLine() {
			try{
			line = reader.readLine();
			return line;
			}
			catch (IOException e) {
				e.printStackTrace();
				return null;
			}		
		}
		
	//checks if file is ready to be used
	public boolean isReady()  {
			try{
			return reader.ready();
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}	
	}		

	
	
	
	public ArrayList<String[]> getLineList(){
		String[] lineSegments;
		ArrayList<String[]> listOfLines = new ArrayList<String[]>();
		//loops through the file
		while(isReady()&& (line = getLine()) != null){
			//splits each line
			lineSegments = line.split("[:,]+");
			//populates the arraylist with the arrays of line segments
			listOfLines.add(lineSegments);
		}
		
		return listOfLines;
	}
	
	public ArrayList<String[]> getAppliances(){
		ArrayList<String[]> listOfAppliances = new ArrayList<String[]>();
		
		//checks each through split string arrays in arraylist
		for (String[] l : listOfEachLine){
			//if the first (word in the line) value in the array
			//isn't person
			if(l[0] != "Person")
			{
				//add the array to the list of appliances
				listOfAppliances.add(l);
			} else //but if it is 'Person'...
				break;
		}
		
		return listOfAppliances;
	}
	
	//checks each through split string arrays in arraylist
	//if the first (word in thr line) value in the array
	//is person and they they are really a person
	//add the array to the arraylist

	public ArrayList<String[]> getPeople(int noOfListedMembers){
		ArrayList<String[]> listOfHouseMembers = new ArrayList<String[]>();
		int members = 0;
		Boolean isAPerson = false;
		
		for (String[] l : listOfEachLine){
			
			if(l[0].equals("Person")){
				 members++;
				if (members == noOfListedMembers){
					isAPerson = true;
				} else if (members > noOfListedMembers){
					return listOfHouseMembers;
				}
			}
			if(isAPerson == true){
				listOfHouseMembers.add(l);
			}
		}
		return listOfHouseMembers;	
	}
	//if the array from the line is for a person
	//increment number of house members
	public Integer tallyHouseMembers(){
		Integer noOfHouseMembers = 0;
		for (String[] l : listOfEachLine){
			
			if (l[0].equals("Person")){
				noOfHouseMembers++;
				
			}
			
		}	
		return noOfHouseMembers;
		
	}
	//getter method for number of house members
	public Integer getNoOfHouseMmebers(){
		return totalNoOfHouseMembers;
	}
	
	
}

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public abstract class Person {
	//variables to do with person
	public String name;
	public int age;
	public String gender;

	HashMap<Integer, String> taskList;
	
	//constructor adds properties to person
	//and instanciates taskLists
	public Person(String name, int age, String gender){
		this.name = name;
		this.age = age;
		this.gender = gender;
		taskList = new HashMap<Integer, String>();
	}
	

	//getter and setter names for properties
	public void setName(String name){
		this.name = name;
		
	}
	public void setAge(int age){
		this.age = age;
		
	}
	
	public void setGender(String gender){
		this.gender = gender;
	}
	
	public String getName(){
		return name;
		
	}
	
	public int getAge(){
		return age;
		
	}

	public String getGender(){
		return gender;
	}
	
	//adds task and time to complete task
	//to a hashmap with the time as the key
	//and the task as the value
	public void addTask(int timeOfDay, String task)
	{
		taskList.put(timeOfDay, task);
	}
	
	//removes task from task list
	public void removeTask(int timeOfDay){
		taskList.remove(timeOfDay);
	}
	
	//returns task corresponding to 
	//time of day passed into the method
	public String lookForTask(int timeOfDay) {
	String task;
		task = taskList.get(timeOfDay);
		return task;	
	}
	
	//for each time of day
	//get task to do
	//go through each appliance and check if the task can be performed on that appliance
	//(if it can be, it will be performed. see checkTask() in each appliance)
	public void timePasses(int timeOfDay, ArrayList<Appliance> listOfAppliances) {
		String task;
		task = lookForTask(timeOfDay);
		
		for (Appliance a: listOfAppliances ){
			a.checkTask(task);
		}
		
	}
	

}

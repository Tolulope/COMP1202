import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class House {
	//meter variables
	public Meter electricMeter;
	public Meter gasMeter;
	public Meter waterMeter;
	
	//usage variables
	public  int electricityUse;
	public  int gasUse;
	public  int waterUse;
	
	//time variable
	public int timeOfDay = 0;
	
	//static variables
	public static House house;
	public static ConfigReader config;
	
	//arraylists - appliances, meters, people
	ArrayList<Appliance> listOfAppliances;
	ArrayList<Meter> listOfMeters;
	ArrayList<Person> houseMembers;
	
	public House() {
		//instatitates arraylists
		listOfAppliances = new ArrayList<Appliance>();
		listOfMeters = new ArrayList<Meter>();
		houseMembers = new ArrayList<Person>();
	}
	
	
	//attaches meters to house
	//but only if there isn't one of the same type already
	public void addHouseMeter(Meter meter) {
		
		if (listOfMeters.contains(meter.getType())) {
			System.out.println("There's already a meter of this type!");
			} else {	
				listOfMeters.add(meter);
			}
		}
			
		
	//if the list is not 'full'
	//and if the the appliance uses those resources
	//add meter to appliance
	public void addMeterToAppliance(Appliance appliance) {
		
		if (listOfAppliances.size() < 25) {
			listOfAppliances.add((appliance));
			if (appliance.getElectricityUse() != 0 ) {
				appliance.addAppMeter(electricMeter);
			}
			if (appliance.getGasUse() != 0 ) {
				appliance.addAppMeter(gasMeter);
			}
			if (appliance.getWaterUse() != 0 ) {
				appliance.addAppMeter(waterMeter);
			}
		} else {
			System.out.println("Sorry, can't allow you to add any more appliances :)");
		}
		
	}
	
	//iterates through list
	//and removes the appliance passed into the method
	public void removeAppliance(Appliance applianceToRemove) {
		Iterator<Appliance> removeItr = listOfAppliances.iterator();
		while (removeItr.hasNext()){
			Appliance a = (Appliance) removeItr.next();
			if ((a.getAppliance()).equals(applianceToRemove)) {
				removeItr.remove();	
			} 
			break;
		}
		
	}

	//returns number of appliances
	public int numAppliances() {
		 int numAppliances = listOfAppliances.size();
		return numAppliances;
	}
	
	//returns list of appliances
	public ArrayList<Appliance> getAppList(){
		return listOfAppliances;
	}
	
	//creates a new person
	//depending on their age, they will be a child or an adult
	public void newPerson(String name, int age, String gender){
		if(age < 18)
		{
			welcomeToFam(new Child(name, age, gender));
		} else {
			welcomeToFam(new GrownUp(name, age, gender));
		}
	}

	//add person to house memebers list
	public void welcomeToFam(Person person) {
		houseMembers.add(person);
	}
	
	//add relevant task to person if name passed into method is theirs
	public void assignTask(String name, int timeOfday, String task){
		for (Person houseMem : houseMembers){
			if (name.equals(houseMem.getName())){
				houseMem.addTask(timeOfday, task);
			}
		}
	}
	
	
	
	public void timePasses(){
		//if a person has a task to do (appliance to switch on)
		//do the task
		for (Person person : houseMembers){
			person.timePasses(timeOfDay, listOfAppliances);
		 }
		//every appliance has timePasses called on it
		//if appliance is on, it will use up resources
		for (Appliance appliance : listOfAppliances) {
			appliance.timePasses();
		}
				
		timeOfDay++;
		System.out.println("The time of day is:" + timeOfDay );
		
	}

	//one day of activities in the house
	public void go() {
		for (int i = 0; i<96; i++){
			
			timePasses();
		}
		
		for (Meter meter: listOfMeters){
			System.out.println(meter.getType() + " meter use for the day is " + meter.getConsumed());
		}
	}
	
	

	//adds the house 
	public static void addHouse() {
		house = new House();

	}

	// checks length of array of line segments
	//depending on the length, creates a new meter given the parameters
	public static void addMeter(String[] stringBunch) {
		if (stringBunch.length == 1) {
			house.addMeter(stringBunch[0], 0, false);
		} else if (stringBunch.length == 2) {
			house.addMeter((stringBunch[0]), Integer.parseInt(stringBunch[1]), false);
		} else if (stringBunch.length == 3) {
			house.addMeter((stringBunch[0]), Integer.parseInt(stringBunch[1]),
					Boolean.valueOf(stringBunch[2]));

		}
	}

	//depending on the name of the meter, add relevant meter to house
	public void addMeter(String meterName, int startValue, Boolean canGenerate) {
		
		if (meterName.equals("ElectricMeter")) {
			listOfMeters.add(electricMeter = new ElectricMeter(startValue, canGenerate));
		}
		if (meterName.equals("GasMeter")) {
			listOfMeters.add(gasMeter = new GasMeter(startValue, canGenerate));
		}
		if (meterName.equals("WaterMeter")) {
			listOfMeters.add(waterMeter = new WaterMeter(startValue, canGenerate));
		}
	}

	//depending on the first element of the line segment array
	//add appliance
	private static void switchAddComponent(String[] stringBunch)

	{
		switch (stringBunch[0]) {
		case "Refrigerator":
			addRefrigerator(stringBunch);
			break;
		case "House":
			addHouse();
			break;
		case "ElectricMeter":
			addMeter(stringBunch);
			break;
		case "GasMeter":
			addMeter(stringBunch);
			break;
		case "WaterMeter":
			addMeter(stringBunch);
			break;
		case "Boiler":
			addBoiler(stringBunch);
			break;
		case "DishWasher":
			addDishwasher(stringBunch);
			break;
		case "ElectricCooker":
			addElectricCooker(stringBunch);
			break;
		case "GasCooker":
			addGasCooker(stringBunch);
			break;
		case "ElectricShower":
			addElectricShower(stringBunch);
			break;
		case "PowerShower":
			addPowerShower(stringBunch);
			break;
		case "Kettle":
			addKettle(stringBunch);
			break;
		case "NightLight":
			addNightLight(stringBunch);
			break;
		case "TV":
			addTV(stringBunch);
			break;
		case "WashingMachine":
			addWashingMachine(stringBunch);
			break;
		}
	}
	
	
	
	/*For the following add[INSERT APPLIANCE NAME HERE] methods:
	 * checks length of array of line segments
	 * depending on the length, creates a new appliance given the parameters
	 */

	public static void addBoiler(String[] stringBunch) {
		if (stringBunch.length == 1) {
			Boiler boiler = new Boiler();
			house.addMeterToAppliance(boiler);
		} else if (stringBunch.length == 2) {
			Boiler boiler = new Boiler(Integer.parseInt(stringBunch[1]));
			house.addMeterToAppliance(boiler);
		} else if (stringBunch.length == 3) {
			Boiler boiler = new Boiler(Integer.parseInt(stringBunch[1]), Integer.parseInt(stringBunch[2]));
			house.addMeterToAppliance(boiler);
		} else if (stringBunch.length == 4) {
			Boiler boiler = new Boiler(Integer.parseInt(stringBunch[1]), Integer.parseInt(stringBunch[2]),
					Integer.parseInt(stringBunch[3]));
			house.addMeterToAppliance(boiler);
		}
	}

	public static void addDishwasher(String[] stringBunch) {
		if (stringBunch.length == 1) {
			house.addMeterToAppliance(new Dishwasher());
		} else if (stringBunch.length == 2) {
			house.addMeterToAppliance(new Dishwasher(Integer.parseInt(stringBunch[1])));
		} else if (stringBunch.length == 3) {
			house.addMeterToAppliance(
					new Dishwasher(Integer.parseInt(stringBunch[1]), Integer.parseInt(stringBunch[2])));
		} else if (stringBunch.length == 4) {
			house.addMeterToAppliance(new Dishwasher(Integer.parseInt(stringBunch[1]), Integer.parseInt(stringBunch[2]),
					Integer.parseInt(stringBunch[3])));
		}
	}

	public static void addElectricCooker(String[] stringBunch) {
		if (stringBunch.length == 1) {
			house.addMeterToAppliance(new ElectricCooker());
		} else if (stringBunch.length == 2) {
			house.addMeterToAppliance(new ElectricCooker(Integer.parseInt(stringBunch[1])));
		} else if (stringBunch.length == 3) {
			house.addMeterToAppliance(
					new ElectricCooker(Integer.parseInt(stringBunch[1]), Integer.parseInt(stringBunch[2])));
		} else if (stringBunch.length == 4) {
			house.addMeterToAppliance(new ElectricCooker(Integer.parseInt(stringBunch[1]),
					Integer.parseInt(stringBunch[2]), Integer.parseInt(stringBunch[3])));
		}
	}

	
	public static void addElectricShower(String[] stringBunch) {
		if (stringBunch.length == 1) {
			house.addMeterToAppliance(new ElectricShower());
		} else if (stringBunch.length == 2) {
			house.addMeterToAppliance(new ElectricShower(Integer.parseInt(stringBunch[1])));
		} else if (stringBunch.length == 3) {
			house.addMeterToAppliance(
					new ElectricShower(Integer.parseInt(stringBunch[1]), Integer.parseInt(stringBunch[2])));
		} else if (stringBunch.length == 4) {
			house.addMeterToAppliance(new ElectricShower(Integer.parseInt(stringBunch[1]),
					Integer.parseInt(stringBunch[2]), Integer.parseInt(stringBunch[3])));
		}
	}

	public static void addGasCooker(String[] stringBunch) {
		if (stringBunch.length == 1) {
			house.addMeterToAppliance(new GasCooker());
		} else if (stringBunch.length == 2) {
			house.addMeterToAppliance(new GasCooker(Integer.parseInt(stringBunch[1])));
		} else if (stringBunch.length == 3) {
			house.addMeterToAppliance(new GasCooker(Integer.parseInt(stringBunch[1]), Integer.parseInt(stringBunch[2])));
		} else if (stringBunch.length == 4) {
			house.addMeterToAppliance(new GasCooker(Integer.parseInt(stringBunch[1]), Integer.parseInt(stringBunch[2]),
					Integer.parseInt(stringBunch[3])));
		}
	}


	public static void addKettle(String[] stringBunch) {
		if (stringBunch.length == 1) {
			house.addMeterToAppliance(new Kettle());
		} else if (stringBunch.length == 2) {
			house.addMeterToAppliance(new Kettle(Integer.parseInt(stringBunch[1])));
		} else if (stringBunch.length == 3) {
			house.addMeterToAppliance(new Kettle(Integer.parseInt(stringBunch[1]), Integer.parseInt(stringBunch[2])));
		} else if (stringBunch.length == 4) {
			house.addMeterToAppliance(new Kettle(Integer.parseInt(stringBunch[1]), Integer.parseInt(stringBunch[2]),
					Integer.parseInt(stringBunch[3])));
		}
	}

	public static void addNightLight(String[] stringBunch) {
		if (stringBunch.length == 1) {
			house.addMeterToAppliance(new NightLight());
		} else if (stringBunch.length == 2) {
			house.addMeterToAppliance(new NightLight(Integer.parseInt(stringBunch[1])));
		} else if (stringBunch.length == 3) {
			house.addMeterToAppliance(
					new NightLight(Integer.parseInt(stringBunch[1]), Integer.parseInt(stringBunch[2])));
		} else if (stringBunch.length == 4) {
			house.addMeterToAppliance(new NightLight(Integer.parseInt(stringBunch[1]), Integer.parseInt(stringBunch[2]),
					Integer.parseInt(stringBunch[3])));
		}
	}
	
	public static void addPowerShower(String[] stringsBunch) {
		if (stringsBunch.length == 1) {
			house.addMeterToAppliance(new PowerShower());
		} else if (stringsBunch.length == 2) {
			house.addMeterToAppliance(new PowerShower(Integer.parseInt(stringsBunch[1])));
		} else if (stringsBunch.length == 3) {
			house.addMeterToAppliance(
					new PowerShower(Integer.parseInt(stringsBunch[1]), Integer.parseInt(stringsBunch[2])));
		} else if (stringsBunch.length == 4) {
			house.addMeterToAppliance(new PowerShower(Integer.parseInt(stringsBunch[1]), Integer.parseInt(stringsBunch[2]),
					Integer.parseInt(stringsBunch[3])));
		}
	}

	public static void addRefrigerator(String[] stringBunch) {

		if (stringBunch.length == 1) {
			Refrigerator fridge = new Refrigerator();
			house.addMeterToAppliance(fridge);
		} else if (stringBunch.length == 2) {
			Refrigerator fridge = new Refrigerator(Integer.parseInt(stringBunch[1]));
			house.addMeterToAppliance(fridge);
		} else if (stringBunch.length == 3) {
			Refrigerator fridge = new Refrigerator(Integer.parseInt(stringBunch[1]),
					Integer.parseInt(stringBunch[2]));
			house.addMeterToAppliance(fridge);
		} else if (stringBunch.length == 4) {
			Refrigerator fridge = new Refrigerator(Integer.parseInt(stringBunch[1]),
					Integer.parseInt(stringBunch[2]), Integer.parseInt(stringBunch[3]));
			house.addMeterToAppliance(fridge);
		}
	}

	public static void addTV(String[] stringBunch) {
		if (stringBunch.length == 1) {
			house.addMeterToAppliance(new TV());
		} else if (stringBunch.length == 2) {
			house.addMeterToAppliance(new TV(Integer.parseInt(stringBunch[1])));
		} else if (stringBunch.length == 3) {
			house.addMeterToAppliance(new TV(Integer.parseInt(stringBunch[1]), Integer.parseInt(stringBunch[2])));
		} else if (stringBunch.length == 4) {
			house.addMeterToAppliance(new TV(Integer.parseInt(stringBunch[1]), Integer.parseInt(stringBunch[2]),
					Integer.parseInt(stringBunch[3])));
		}
	}

	public static void addWashingMachine(String[] arrayOfStrings) {
		if (arrayOfStrings.length == 1) {
			house.addMeterToAppliance(new WashingMachine());
		} else if (arrayOfStrings.length == 2) {
			house.addMeterToAppliance(new WashingMachine(Integer.parseInt(arrayOfStrings[1])));
		} else if (arrayOfStrings.length == 3) {
			house.addMeterToAppliance(new WashingMachine(Integer.parseInt(arrayOfStrings[1]), Integer.parseInt(arrayOfStrings[2])));
		} else if (arrayOfStrings.length == 4) {
			house.addMeterToAppliance(new WashingMachine(Integer.parseInt(arrayOfStrings[1]),
					Integer.parseInt(arrayOfStrings[2]), Integer.parseInt(arrayOfStrings[3])));
		}
	}

	//depending on the task given in the file
	//assign task to the relevant house member
	private static void switchAssignTask(String[] taskBunch, String name) {
		switch (taskBunch[0]) {
		case "Person":
			house.newPerson(taskBunch[1], Integer.parseInt(taskBunch[2]), taskBunch[3]);
			break;
		case "Cook":
			house.assignTask(name, Integer.parseInt(taskBunch[1]), "Cook");
			break;
		case "Shower":
			house.assignTask(name, Integer.parseInt(taskBunch[1]), "Shower");
			break;
		case "Boil":
			house.assignTask(name, Integer.parseInt(taskBunch[1]), "Boil");
			break;
		case "DoWashing":
			house.assignTask(name, Integer.parseInt(taskBunch[1]), "DoWashing");
			break;
		case "TurnOffBoiler":
			house.assignTask(name, Integer.parseInt(taskBunch[1]), "TurnOffBoiler");
			break;
		case "TurnOffNightLight":
			house.assignTask(name, Integer.parseInt(taskBunch[1]), "TurnOffNightLight");
			break;
		case "TurnOffTV":
			house.assignTask(name, Integer.parseInt(taskBunch[1]), "TurnOffTV");
			break;
		case "TurnOnBoiler":
			house.assignTask(name, Integer.parseInt(taskBunch[1]), "TurnOnBoiler");
			break;
		case "TurnOnNightLight":
			house.assignTask(name, Integer.parseInt(taskBunch[1]), "TurnOnNightLight");
			break;
		case "TurnOnTV":
			house.assignTask(name, Integer.parseInt(taskBunch[1]), "TurnOnTV");
			break;
		case "WashDishes":
			house.assignTask(name, Integer.parseInt(taskBunch[1]), "WashDishes");
			break;
			//extension cases:
		case "IsCold":
			house.assignTask(name, Integer.parseInt(taskBunch[1]), "IsCold");
			break;
		case "HeatUp":
			house.assignTask(name, Integer.parseInt(taskBunch[1]), "HeatUp");
			break;
		case "HasGoosebumps":
			house.assignTask(name, Integer.parseInt(taskBunch[1]), "HasGoosebumps");
			break;
		case "IsVeryCold":
			house.assignTask(name, Integer.parseInt(taskBunch[1]), "IsVeryCold");
			break;
		}
	}
	

	public static void main(String[] args) {
		
		try {
			try {
				  // first check to see if the program was run with the command line argument
			    if(args.length < 1) {
			        System.out.println("Error, usage: java ClassName inputfile");
				System.exit(1);
			    }
			  String file = args[0];
			  //read file
				config = new ConfigReader(file);
			} catch (Exception e) {
				throw new IOException();
			}
			//get appliances from file
			ArrayList<String[]> listOfAppliances = config.getAppliances();
			//add each appliance to the house
			for (String[] s : listOfAppliances) {
				switchAddComponent(s);
			}
			
			for (int i = 1; i <= config.tallyHouseMembers(); i++) {
				//get the house members
				ArrayList<String[]> listOfHouseMembers = new ArrayList<String[]>();
				//add them to the house
				listOfHouseMembers = config.getPeople(i);
				
				//assignTasks to house members
				String nameOfMember = listOfHouseMembers.get(0)[1];
				for (String[] task : listOfHouseMembers) {
					switchAssignTask(task, nameOfMember);
				}
			}
			//set the house in motion
			house.go();
		
		} catch (IOException ioe) {
			System.err.println(ioe + ": Can't find configuration file");
		}
	
	}
}
	

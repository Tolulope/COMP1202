
public class Boiler extends Appliance {
	//variable to do with temperature
	public double temperature;
	public double targetTemperature;
	//is false by default as this is rare
	public boolean hasSetNewTemp = false;
	
	public boolean isHeating;
	
	// default constructor followed by constructors 
	//depending on how much information is initially given
	//this is to help when reading from the config file
	public Boiler() {
		this(0, 1, 0);
	
	}
		
	public Boiler(int electricityUse, int gasUse, int waterUse) {
		super(electricityUse, gasUse, waterUse, 0);
	}
	public Boiler(int electricityUse, int gasUse){
		this(electricityUse, gasUse, 0);
	}
	public Boiler(int electricityUse, int gasUse, int waterUse, double temperature) {
		super(electricityUse, gasUse, waterUse, 0);
		this.temperature = temperature;
	}
	public Boiler(double temperature) {
		this(0, 1, 0);
		this.temperature = temperature;
	}
	
	
	
	//overriding turnOn() and turnOff() methods
	//so that we can keep close track of the boiler
	public boolean turnOn() {
		isOn = true;
		System.out.println("The boiler is now on");
		return isOn;
	}
	
	public boolean turnOff() {
		isOn = false;
		System.out.println("The boiler is now off");
		return isOn;
	}
	

	//determines whether the task received 
	//is suitable for this appliance
	//if so, perform task given
	   public void checkTask(String task){
		if (task == "TurnOnBoiler") {
			turnOn();
		} else if (task == "TurnOffBoiler"){
			turnOff();
		} else if (task == "IsCold"){
			isHeating = true;
			heatUp(2.5);
		} else if (task == "HeatUp"){
			isHeating = true;
			heatUp();
		} else if (task == "HasGoosebumps"){
			isHeating = true;
			heatUp(1.5);
		} else if (task == "IsVeryCold"){	
			isHeating = true;
			heatUp(4);
		}
			
	}
	
	//setter and getter methods for appliance name
	public void setName() {
		applianceName = "Boiler";
	}
	public String getName() {
		return applianceName;
	}

	//sets base temperature for the house directly
	public void setTemperature(double temperature) {
		this.temperature = temperature;
	}
	
	//sets base temperature for the house from config
	public void setTemperature(String temperature) {
		this.temperature = Double.parseDouble(temperature);
	}
		
	
	//if person knows what they want to temperature to be
	//they can set it
	public void setNewTemperature(double temperature){
		this.targetTemperature = temperature;
		hasSetNewTemp = true;
		
	}
	
	public double getTemperature() {
		return temperature;
	}
	
	//increments the temperature when heating up
	public void incrementTemperature() {
		temperature++;
	}
	
	//increments the temperature by however many degrees
	//the person in the house would like
	public void incrementTemperature(double degrees){
			temperature += degrees;
	}
	
	//decrements the temperature when heating up
	public void decrementTemperature() {
		temperature--;
	}
	
	//decrements the temperature by however many degrees
	//the person in the house would like
	public void decrementTemperature(double degrees){
			temperature -= degrees;
	}
	
	//decrements the temperature by 0.5 degrees 
	//(each 15 minutes the boiler is off)
	//I decided to make this a method 
	//to be compatible with other temperature scales
	//if there were a need to be
	public void defaultDecrementTemperature(){
		
		//if the boiler isn't on, it isn'tbheating up the house, 
		//so the temperature should naturally fall a bit
		//making sure the house doesn't get too cold
		if(temperature <= 17.0){
			heatUp();
		} else{
			temperature -= 0.5;
		}
		}
	
	//heat Up by a degree
	//can be looped through in the future if needs be
	public void heatUp() {
		incrementTemperature();
		
	}
	
	//heats up by certain value
	//default values have been put into the checkTask method
	//but if functionality was built to input temperature to heat up by,
	//this is very useful
	public void heatUp(double degrees){
		incrementTemperature(degrees);
	}
	
	
	public void timePasses(){
		
		if (isHeating = true){
			 for(Meter meter: appMeters){
			 if (meter.getType().equals("Gas")){
					meter.incrementConsumed(gasUse);
				}
			 }
		} 	else if (isHeating = false){
			 for(Meter meter: appMeters){
			 if (meter.getType().equals("Gas")){
					meter.incrementConsumed(0);
				}
			 }
		}
		
		//checks to see if the appliance is on
		if (isOn == true){
		
			 timePassed++;	
			 //for each meter attached to the appliance
			for(Meter meter: appMeters){
				//if it's an electric meter, 
				//increment the electricity used in 15 minutes 
				if (meter.getType().equals("Electric")){
					meter.incrementConsumed(electricityUse);
					//if it's a water meter, 
					//increment the water used in 15 minutes 
				} else if (meter.getType().equals("Water")){
					meter.incrementConsumed(waterUse);
					//if it's a gas meter, 
					//increment the gas used in 15 minutes 
				} else if (meter.getType().equals("Gas")){
					meter.incrementConsumed(gasUse);
				}
			
				if (hasSetNewTemp = true){
					temperature = targetTemperature;
				}
			
				}
				} else {
					//cools the house down by half a degree by default
			defaultDecrementTemperature();
		}
		
	
		System.out.println("House temperature is now: " + temperature);	
	}
	
}
	




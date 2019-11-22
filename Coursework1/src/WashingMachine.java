
public class WashingMachine extends Appliance{
	
	// default constructor followed by constructors 
	//depending on how much information is initially given
	//this is to help when reading from the config file
	public WashingMachine() {
		this(2, 0, 1);

	}
	
	public WashingMachine(int electricityUse, int gasUse, int waterUse){
		super(electricityUse, gasUse, waterUse, 8);
	}
	public WashingMachine(int electricityUse, int gasUse) {
		this(electricityUse, gasUse, 1);
	}

	public WashingMachine(int electricityUse) {
		this(electricityUse, 0, 1);
	}


	//turns on washing machine so that it uses resources when timePasses
	public void doWashing(){
		turnOn();
	}

	//determines whether the task received 
	//is suitable for this appliance
	//if so, perform task given
	public void checkTask(String task){
		if (task == "DoWashing") {
		doWashing();
		}
		
	}
	
	//setter and getter methods for appliance name
	public void setName() {
		applianceName = "WashingMachine";
	}
	public String getName() {
		return applianceName;
	}



		
}



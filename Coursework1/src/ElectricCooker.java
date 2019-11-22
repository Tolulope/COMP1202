
public class ElectricCooker extends Cooker {
	// default constructor followed by constructors 
	//depending on how much information is initially given
	//this is to help when reading from the config file
	public ElectricCooker() {
		this(5, 0, 0);
	}
	public ElectricCooker(int electricityUse, int gasUse, int waterUse) {
		super(electricityUse, gasUse, waterUse, 4);
	}
	public ElectricCooker(int electricityUse, int gasUse){
		this(electricityUse, gasUse, 0);
	}
	public ElectricCooker(int electricityUse){
		this(electricityUse, 0, 0);
	}

	//determines whether the task received 
	//is suitable for this appliance
	//if so, perform task given
	public void checkTask(String task){
		if (task == "Cook") {
		cook();
		} 		
	}
	
	//setter and getter methods for appliance name
	public void setName() {
		applianceName = "ElectricCooker";
	}
	public String getName() {
		return applianceName;
	}

}

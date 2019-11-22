
public class ElectricShower extends Shower {

	// default constructor followed by constructors 
	//depending on how much information is initially given
	//this is to help when reading from the config file
	public ElectricShower() {
		this(12, 0, 4);
	}
	public ElectricShower(int electricityUse, int gasUse, int waterUse) {
		super(electricityUse, gasUse, waterUse, 1);
	}
	public ElectricShower(int electricityUse, int gasUse){
		this(electricityUse, gasUse, 4);
	}
	public ElectricShower(int electricityUse){
		this(electricityUse, 0, 4);
	}
	
	//determines whether the task received 
	//is suitable for this appliance
	//if so, perform task given
	public void checkTask(String task){
		if (task == "Shower") {
		shower();
		}
	}
	
	//setter and getter methods for appliance name
	public void setName() {
		applianceName = "ElectricShower";
	}
	public String getName() {
		return applianceName;
	}
}

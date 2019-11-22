
public class Kettle extends Appliance {
	// default constructor followed by constructors 
	//depending on how much information is initially given
	//this is to help when reading from the config file
	public Kettle() {
		this(20, 0, 1);
	}
	public Kettle(int electricityUse, int gasUse, int waterUse) {
		super(electricityUse, gasUse, waterUse, 1);
	}
	public Kettle(int electricityUse, int gasUse){
		this(electricityUse, gasUse, 1);
	}
	public Kettle(int electricityUse){
		this(electricityUse, 0, 1);
	}


	//turns on kettle so that it uses resources when timePasses
	public void boil(){
		turnOn();
	}
	
	//determines whether the task received 
	//is suitable for this appliance
	//if so, perform task given
	public void checkTask(String task){
		if (task == "BoilKettle") {
		boil();
		}
	}
	

	//setter and getter methods for appliance name
	public void setName() {
		applianceName = "Kettle";
	}
	public String getName() {
		return applianceName;
	}
}

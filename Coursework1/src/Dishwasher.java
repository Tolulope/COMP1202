
public class Dishwasher extends Appliance{
	// default constructor followed by constructors 
	//depending on how much information is initially given
	//this is to help when reading from the config file
	public Dishwasher() {
		this(2, 0, 1);
		
	}
	public Dishwasher(int electricityUse, int gasUse, int waterUse) {
		super(electricityUse, gasUse, waterUse, 6);
	}
	public Dishwasher(int electricityUse, int gasUse){
		this(electricityUse, gasUse, 1);
	}
	public Dishwasher(int electricityUse){
		this(electricityUse, 0, 1);
	}
	

	//turns on dishwasher so that it uses resources when timePasses
	public void washDishes() {
	turnOn();
	}
	
	//determines whether the task received 
	//is suitable for this appliance
	//if so, perform task given
	public void checkTask(String task){
	if (task == "washDishes") {
	washDishes();
	}
		
}
	


	//setter and getter methods for appliance name
	public void setName() {
	applianceName = "Dishwasher";
}
	public String getName() {
	return applianceName;
}



}
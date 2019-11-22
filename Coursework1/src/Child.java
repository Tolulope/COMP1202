
public class Child extends Person{

	public Child(String name, int age, String gender) {
		super(name, age, gender);
	}

	//overriding addTask method 
	//to make sure that children only do what they are allowed to
	public void addTask(int timeOfDay, String task) {
		try {
			if ( task == "TurnOnCooker" || task == "TurnOffCooker"|| 
					task == "TurnOnBoiler" || task == "TurnOffBoiler" ||
					task == "Boilkettle" ) {
				throw new Exception("A child can't do this! Nice Try Child!");
			} else if (task == "turnOffTV"){
				throw new Exception("A child doesn't usually do this!");
			} else {
				super.addTask(timeOfDay, task);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}	

}

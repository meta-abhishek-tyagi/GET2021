package Assignment8;

class Parrot extends Bird {
	
	//Constructor initializing the animalName
	Parrot(){
		super();
		animalName = "parrot";
	}
	
	//setters
	@Override
	void setId(int id) {
		this.id = id;
	}	
	@Override
	void setName(String name) {
		this.name = name;
	}
	@Override
	void setAge(double age){
		this.age = age;
	}
	@Override
	void setWeight(double weight){
		this.weight = weight;
	}
		
	//getters
	@Override
	String getName(){
		return name;
	}
	@Override
	String getType(){
		return type;
	}
	@Override
	String getAnimalName() {
		return animalName;
	}
	@Override
	int getId() {
		return id;
	}
	@Override
	String getSound() {
		return "Chirp";
	}
}


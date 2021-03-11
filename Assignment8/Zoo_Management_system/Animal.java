package Assignment8;

import java.util.*;
abstract class Animal {
     protected String animalName;
     protected String type;
     protected double weight;
     protected double age;
     protected int id;
     protected String name;

     //return the sound of the animal
     abstract String getSound(); 
     
     //return the name of the animal like lion, snake, etc.
     abstract String getAnimalName(); 
     
     //return the type of the animal like mammal,reptile etc.
     abstract String getType(); 
     
     //return the name of a animal like there will be a name of lion is sheru
     abstract String getName(); 
     
     //set the name of the animal like for lion name will be sheru
     abstract void setName(String nameInp); 
     
     //set the age of the animal 
     abstract void setAge(double age); 
     
     //set the weight of the animal 
     abstract void setWeight(double weight);
     
     //set the id of a animal 
     abstract void setId(int animalId); 
     
     //return the id of the animal
     abstract int getId(); 
}


















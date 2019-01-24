//============================================================================
//Name        : Dog.java
//Course      : CS 2261: Objected-Oriented Programming
//Date        : 10/28/2018
//Author      : Yu Kuwahara
//============================================================================

// extends Mammal
// don't need to do hunger twice
// have attributes of fun, cleanliness, loyalty 

import java.util.Random;

public class Dog extends Mammal
{
	private int fun;
	private int cleanliness;
	private int loyalty;
	
	// declare a constructor
	public Dog(String name)
	{
		Random rand = new Random();
		
		// attributes
		super.name = name;
		super.hunger = rand.nextInt(100) + 1;
		super.sex = rand.nextBoolean();
		super.weight = rand.nextInt(101) + 50;
		fun = rand.nextInt(100) + 1;
		cleanliness = rand.nextInt(100) + 1;
		Loyalty();
		
	}
	
	// getters 
	public int getFun() 
	{ 
		return fun; 
	}
	
	public int getHunger()
	{ 
		return super.hunger; 
	}
	
	public int getCleanliness() 
	{ 
		return cleanliness; 
	}
	
	// setters	
	public void setFun(int Fun) 
	{ 
		fun = Fun; 
	}
	
	public void setHunger(int Hunger) 
	{ 
		super.hunger = Hunger;
	}
	
	public void setCleanliness(int Cleanliness)
	{ 
		cleanliness = Cleanliness; 
	}
	
	// methods
	// it sets that the loyalty should be decided by how fun the dog is and how much the dog is not hungry
	private void Loyalty()
	{
		loyalty = Math.max(fun, 100 - super.hunger);
	}
	
	// it displays the information about the dog below the information about the owner
	public String toString()
	{
		// set Loyalty before outputting string
		Loyalty();
		
		String string = "DOG ERROR";
		
		string = "\t\tName:\t\t" + super.name + "\n" +
				"\t\tWeight:\t\t" + super.weight + "\n";
		
		// set sex string
		String sex;
		if(super.sex)
			sex = "Female";
		else
			sex = "Male";
		
		string += "\t\tSex:\t\t" + sex + "\n" +
				"\t\tHunger:\t\t" + super.hunger + "\n" +
				"\t\tFun:\t\t" + fun + "\n" +
				"\t\tCleanliness:\t" + cleanliness + "\n" +
				"\t\tLoyalty:\t" + loyalty + "\n";
		
		string += "\n";
		
		return string;
	}
	
	// it makes sure that none of the values of the attributes becomes negative
	public void validateAttributes()
	{
		if(super.hunger > 100)
			super.hunger = 100;
		
		if(fun > 100)
			fun = 100;
		
		if(cleanliness > 100)
			cleanliness = 100;

		if(super.hunger < 0)
			super.hunger = 0;
		
		if(fun < 0)
			fun = 0;
		
		if(cleanliness < 0)
			cleanliness = 0;
	}
	
	// it makes leave the dog if the dog is not loyal
	public boolean notLoyal()
	{
		if(loyalty <= 0)
		{
			System.out.println(super.name + " left...");
			return true;
		}
		else
			return false;
	}

}
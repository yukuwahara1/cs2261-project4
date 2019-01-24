//============================================================================
//Name        : Human.java
//Course      : CS 2261: Objected-Oriented Programming
//Date        : 10/28/2018
//Author      : Yu Kuwahara
//============================================================================

// extends Mammal
// have attributes of money, dogfood, and array list of dog
// methods: walks, bathes, toString, passTheTime, buysFood with getters and setters

// import these to work with array list 
import java.util.*;

public class Human extends Mammal
{
	private int money;
	public int dogFood;
	private ArrayList<Dog> dogs; // ArrayList is like a vector
	
	// constructor to create info about the owner
	public Human(String name)
	{
		Random random = new Random();
		Scanner input = new Scanner(System.in);
		
		// members
		// use super since mammal also has the same attributes
		super.name = name; // the owner's name
		super.hunger = random.nextInt(100) + 1;
		super.sex = random.nextBoolean();
		super.weight = random.nextInt(50) + 10;
		dogFood = random.nextInt(50) + 5;
		
		// declare an ArrayList to hold one or two dogs
		int numDogs = random.nextInt(2) + 1;
		// create an instance of the ArrayList for each of the owners
		dogs = new ArrayList<Dog>(numDogs);
		
		for(int i = 1; i <= numDogs; ++i)
		{
		
			String dogName;
			switch(i)
			{
			case 1:
				// ask the name of the first dog
				System.out.print("Enter " + name + "'s 1st dog's name: ");
				dogName = input.next();
				dogs.add(new Dog(dogName));
				break;
				
				// ask the name of the second dog
			case 2:
				System.out.print("Enter " + name + "'s 2nd dog's name: ");
				dogName = input.next();
				dogs.add(new Dog(dogName));
				break;
			}
		}
		
		// for some reasons, it threw errors if I close the input scanner
		// input.close();
	}

	// methods
	// it adds 50 for fun, minus 10% for cleanliness, and add 10% for hunger
	public void walks()
	{
		for(Dog dog : dogs)
		{
			dog.setFun(dog.getFun() + 50); // + 50 fun
			dog.setCleanliness((int)(dog.getCleanliness() * .9)); // - 10% cleanliness
			dog.setHunger((int)(dog.getHunger() * 1.1)); // + 10% hunger
			dog.validateAttributes();
		}
	}

	// it adds 50 for hunger, minus 10% for cleanliness, and add 10% for fun
	public void feeds()
	{
		for(Dog dog : dogs)
		{
			dog.setHunger(dog.getHunger() + 50); // + 50 hunger
			dog.setCleanliness((int)(dog.getCleanliness() * .9)); // - 10% cleanliness
			dog.setFun((int)(dog.getFun() * 1.1)); // + 10% fun
			dog.validateAttributes();
			
			--dogFood; // -1 dogfood
		}
	}

	// it sets cleanliness as 100 and minus 10% for fun
	public void bathes()
	{
		for(Dog dog : dogs)
		{
			dog.setFun((int)(dog.getFun() * .9)); // - 10% fun
			dog.setCleanliness(100); // set cleanliness as 100
			dog.validateAttributes();
		}
	}

	// it displays all the information about both the owner 
	public String toString()
	{
	String s = "HUMAN ERROR"; 
		
		s =	super.name + ":\n" +
				"\tWeight:\t" + super.weight + "\n";
				
		// set sex string
		String sex;
		if(super.sex)
			sex = "Female";
		else
			sex = "Male";
		
		s += "\tSex:\t" + sex + "\n" +
				"\tHunger:\t" + super.hunger + "\n" +
				"\tMoney:\t" + money + "\n" +
				"\tDogs:\t" + dogs.size() + "\n";
		
		// append dogs to string s
		for(Dog dog : dogs) //for each dog in dogs.
		{
			s += dog.toString();
		}
		
		return s;
	}

	// it subtracts 1 for dog’s fun
	public void passTheTime()
	{
		for(Dog dog : dogs)
		{
			dog.setFun(dog.getFun() - 1); //-1 fun
			dog.validateAttributes();
		}
			
		money += 10;
	}

	// if the owner has more than 10 money, it adds 50 for dogfood and subtracts 10 for the owner’s money
	public void buyFood()
	{
		if(money >= 10)
		{
			dogFood += 50;
			money -= 10;
		}
	}
	
	// if it has loyalty, change the loyalty of the dog to yes, if not change it to no
	public boolean checkLoyalty()
	{
		boolean hasLoyalty = true;
		for(Dog dog : dogs)
		{
			if(dog.notLoyal())
				hasLoyalty = false;
		}
		
		return hasLoyalty;
	}

}
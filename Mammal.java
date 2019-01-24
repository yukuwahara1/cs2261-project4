//============================================================================
//Name        : Mammal.java
//Course      : CS 2261: Objected-Oriented Programming
//Date        : 10/28/2018
//Author      : Yu Kuwahara
//============================================================================

// this class will have attributes of name, weight, hunger, and sex

public abstract class Mammal 
{
	// subclass needs to access these values so protected instead of private
	// protected: package and class can also access to these values
	
	// members
	protected String name;
	protected int weight;
	protected int hunger;
	protected boolean sex; // female for true and male for false
	
	// method
	public abstract String toString();
}


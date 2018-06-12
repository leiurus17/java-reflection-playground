package com.gowpar.reflection;

import java.lang.reflect.Constructor;
import java.util.Arrays;

public class ReflectionExample {

	public static void main(String[] args) {
		
		// Obtain the class object if we know the name of the class
		Class rental = RentCar.class;
		
		try {
			// get the absolute name of the class
			String rentalClassPackage = rental.getName();
			System.out.println("Class Name is: " + rentalClassPackage);
			
			// get the simple name of the class (without package info)
			String rentalClassNoPackage = rental.getSimpleName();
			System.out.println("Class Name without package is: " + rentalClassNoPackage);

			// get the package name of the class
			Package rentalPackage = rental.getPackage();
			System.out.println("Package Name is: " + rentalPackage);
			
			// get all the constructors of the class
			Constructor<?>[] constructors = rental.getConstructors();
			System.out.println("Constructors are: " + Arrays.toString(constructors));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}

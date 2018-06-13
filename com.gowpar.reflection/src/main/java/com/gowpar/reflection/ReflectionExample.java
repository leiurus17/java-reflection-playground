package com.gowpar.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
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

			// get Constructors with specific argument
			Constructor constructor = rental.getConstructor(Integer.TYPE);

			// initializing an object of the RentCar class
			RentCar rent = (RentCar) constructor.newInstance(455);

			// get all methods of the class including declared methods of
			// superclasses
			// in that case, superclass of RentCar is the class java.lang.Object
			Method[] allmethods = rental.getMethods();
			System.out.println("Methods are: " + Arrays.toString(allmethods));
			for (Method method : allmethods) {
				System.out.println("method = " + method.getName());
			}

			// get all methods declared in the class
			// but excludes inherited methods.
			Method[] declaredMethods = rental.getDeclaredMethods();
			System.out.println("Declared Methods are: " + Arrays.toString(declaredMethods));
			for (Method dmethod : declaredMethods) {
				System.out.println("method = " + dmethod.getName());
			}

			// get method with specific name and parameters
			Method oneMethod = rental.getMethod("computeRentalCost", new Class[] { Integer.TYPE });
			System.out.println("Method is: " + oneMethod);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}

/*
when we create a class memory will not be alloacted until we create an object for the class
*/

// Java program to demonstrate memory usage before and after object creation

class Car {
    // Instance variables
    String model;
    int year;

    // Constructor to initialize the model and year
    public Car(String model, int year) {
        this.model = model;
        this.year = year;
    }

    // Method to display the information of the car
    public void displayInfo() {
        System.out.println("Model: " + model + ", Year: " + year);
    }

    // Main method to run the program
    public static void main(String[] args) {
        // Get free memory before car object creation
        long beforeMemory = Runtime.getRuntime().freeMemory();
        System.out.println("Free memory before object creation: " + beforeMemory);

        // Create an object of the Car class (allocates memory)
        Car car = new Car("Toyota", 2020);

        // Get free memory after car object creation
        long afterMemory = Runtime.getRuntime().freeMemory();
        System.out.println("Free memory after object creation: " + afterMemory);

        // Display the information of the created car object
        car.displayInfo();

        // Calculate and display the memory used by the object
        System.out.println("Memory used by the object: " + (beforeMemory - afterMemory));
    }
}
	
package jdp2e.builder.demo;

import java.util.LinkedList;

//The common interface
interface Builder
{
     void startUpOperations();
     void buildBody();
     void insertWheels();
     void addHeadlights();
     void  endOperations();
     /*The following method is used to retrieve the object that is constructed.*/
     Product getVehicle();
}
//Car class
class Car implements Builder
{
    private String brandName;
    private Product product;
    public Car(String brand)
    {
        product = new Product();
        this.brandName = brand;
    }
    public void startUpOperations()
    {   
    	//Starting with brand name
        product.add(String.format("Car model is :%s",this.brandName));
    }
    public void buildBody()
    {
        product.add("This is a body of a Car");
    }
    public void insertWheels()
    {
        product.add("4 wheels are added");
    }       

    public void addHeadlights()
    {
        product.add("2 Headlights are added");
    }
    public void endOperations()
    {   //Nothing in this case
    }

    public Product getVehicle()
    {
        return product;
    }	
}
//Motorcycle class
class MotorCycle implements Builder
{
    private String brandName;
    private Product product;        
    public MotorCycle(String brand)
    {
        product = new Product();
        this.brandName = brand;
    }
    public void startUpOperations()
    {   //Nothing in this case
    }

    public  void buildBody()
    {
        product.add("This is a body of a Motorcycle");
    }

    public void insertWheels()
    {
        product.add("2 wheels are added");
    }
    
    public void addHeadlights()
    {
        product.add("1 Headlights are added");
    }
    public void endOperations()
    {
        //Finishing up with brand name
        product.add(String.format("Motorcycle model is :%s", this.brandName));
    }
    public Product getVehicle()
    {
        return product;
    }
}

// Product class 
class Product
{
   /* You can use any data structure that you prefer. 
	I have used LinkedList<String> in this case.*/
    private LinkedList<String> parts;
    public Product()
    {
        parts = new LinkedList<String>();
    }

    public void add(String part)
    {
       //Adding parts
        parts.addLast(part);
    }

    public void showProduct()
    {
    	System.out.println("\nProduct completed as below :");
        for (String part: parts)
        System.out.println(part);
    }
}
// Director class 
class Director
{
    Builder builder;
    // Director knows how to use the builder and the sequence of steps.
    public void construct(Builder builder)
    {
        this.builder = builder;
        builder.startUpOperations();
        builder.buildBody();
        builder.insertWheels();
        builder.addHeadlights();
        builder.endOperations();        
    }
}
public class BuilderPatternExample {

	public static void main(String[] args) {
		System.out.println("***Builder Pattern Demo***");
        Director director = new Director();

        Builder fordCar = new Car("Ford");
        Builder hondaMotorycle = new MotorCycle("Honda");

        // Making Car
        director.construct(fordCar);
        Product p1 = fordCar.getVehicle();
        p1.showProduct();
                    
        //Making MotorCycle
        director.construct(hondaMotorycle );
        Product p2 = hondaMotorycle.getVehicle();
        p2.showProduct();
	}
}

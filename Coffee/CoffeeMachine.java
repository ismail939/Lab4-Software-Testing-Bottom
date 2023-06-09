package Coffee;

import java.util.Scanner;

public class CoffeeMachine{
public static Scanner scan = new Scanner(System.in);
    private double coffee_powder, milk, water;
    public int Coffee_Count = 0;
    
    public CoffeeMachine(){ //Default Constructor Initialization...
        this.coffee_powder=0;
        this.milk=0;
        this.water=0;
    }
    public double getMilk() {
    	return this.milk;
    }
    public double getcoffee_powder() {
    	return this.coffee_powder;
    }
    public double getWater() {
    	return this.water;
    }
    public void SetIngredient(){   //Calling for Filling Ingredient...
        System.out.println("\nFilling...");
        this.coffee_powder = 500.0;
        this.milk = 1;
        this.water= 2;
        System.out.println("Filling Completed.");
    }
    public void GetIngredient(){   //To Get Status
            System.out.println("Available Coffee Power(Gram) "+String.format("%.1f",this.coffee_powder));
            System.out.println("Available Milk(Liter) "+String.format("%.1f", this.milk));
            System.out.println("Available Water(Liter) "+String.format("%.1f", this.water));
    }
    public void CleanMachine(){    //Initialization with Null In order to Clean Machine
        System.out.println("\nCleaning Machine...");
        this.coffee_powder = 0;
        this.milk = 0;
        this.water= 0;
        System.out.println("Cleaning Completed.");
    }
    public void makecoffee(boolean check){  //Coffee Selection Menulllllllllllllllllllllllllllllllllllllllllllllllllllll
        System.out.println("\n ------------------ ");
        System.out.println("|   Select Type:   |\n ------------------ \n| 1:  Black Coffee |\n| 2:  Milk Coffee  |\n| 0   to Discard   |");
        System.out.println(" ------------------ \n");
        
        if(check) {
        	this.BlackCoffee();
        	return;
        }
        Scanner s=new Scanner(System.in);
        int t = s.nextInt();
        switch(t){
            case 1:
                this.BlackCoffee();     //Call to BlackCoffee Method
                break;
            case 2:
                this.MilkCoffee();      //Call to MilkCoffee Method
                break;
            case 0:
                break;
        }
    }
    public void BlackCoffee(){
        if(this.coffee_powder >= 10 && this.water >= 0.2){
            System.out.println("\nMaking Black Coffee...");
            System.out.println("\nTaking 10gm of Coffee Powder.");
            this.coffee_powder = this.coffee_powder - 10;
            System.out.println("Taking 0.2 liter of Water.");
            this.water = this.water - 0.2;
            System.out.println("\nYour Black Coffee is Ready.");
            this.Coffee_Count++;
        }
        else{
            System.out.println("\nAvailable Coffee Power(Gram) "+String.format("%.1f",this.coffee_powder));
            System.out.println("Available Water(Liter) "+String.format("%.1f", this.water));
            System.out.println("\nSome Iteams Are Not Available, Please Fill before Making Coffee.");
        }
    }
    public void MilkCoffee(){
        if(this.coffee_powder >= 10 && this.milk >= 0.4 && this.water >= 0.2){
            System.out.println("\nMaking Milk Coffee...");
            System.out.println("\nTaking 10gm of Coffee Powder.");
            this.coffee_powder = this.coffee_powder - 10;
            System.out.println("Taking 0.4 Liter of Milk.");
            this.milk = this.milk - 0.4;
            System.out.println("Taking 0.2 liter of Water.");
            this.water = this.water - 0.2;
            System.out.println("\nYour Milk Coffee is Ready.");
            this.Coffee_Count++;
        }
        else{
            System.out.println("\nAvailable Coffee Power(Gram) "+String.format("%.1f",this.coffee_powder));
            System.out.println("Available Milk(Liter) "+String.format("%.1f", this.milk));
            System.out.println("Available Water(Liter) "+String.format("%.1f", this.water));
            System.out.println("\nSome Iteams Are Not Available, Please Fill before Making Coffee.");
        }
    }
    public void start(boolean check){    //public Start to accese all private method of this class
        System.out.println(" ----------------------------------------------------------------");
        System.out.println("|                   Coffee Machine By Manikant                   |");
        System.out.println(" ----------------------------------------------------------------");
        //System.out.println("Currently We Have Following Operations, Select as your Need:- ");
        System.out.println("\nCurrent Status: ");
        this.GetIngredient();
        boolean t = true;
   
        System.out.println("\n -------------------------------- ");
        System.out.println("|1:     Status of Ingredient     |\n -------------------------------- \n|2:      Fill Ingredient         |\n -------------------------------- \n|3:       Clean Machine          |\n -------------------------------- \n|4:        Make Coffee           |\n -------------------------------- \n|5: How many Coffee We have made?|\n -------------------------------- \n|6:        Exit                  |");
        System.out.println(" -------------------------------- \n\n");
        
        
        Scanner s=new Scanner(System.in);
        char c = s.nextLine().charAt(0);
        switch(c){
            case '1': 
                System.out.println("------------- Status ------------");
                this.GetIngredient();
                System.out.println("---------------------------------");
                break;
            case '2':
                this.SetIngredient();
                break;
            case '3':
                this.CleanMachine();
                break;
            case '4':
                this.makecoffee(check);
                break;
            case '5':
                System.out.println("\nWe Have Made "+this.Coffee_Count+" Coffees.");
                break;
            case '6':
                System.out.println("\nExiting...\n");
                t = false;
                break;
        }   
    
    }
}
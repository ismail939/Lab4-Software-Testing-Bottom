package CoffeeTest;
import static org.junit.jupiter.api.Assertions.*;
import java.io.*;
//import java.io.ByteArrayInputStream;

import org.junit.jupiter.api.Test;

import Coffee.CoffeeMachine;




class CoffeeMachineTest {

	@Test
	void ConstructorTest1() {
		CoffeeMachine cm=new CoffeeMachine();
		assertEquals(cm.getcoffee_powder(), 0, "coffee powder is not right");
		assertEquals(cm.getMilk(), 0, "Milk is not right");
		assertEquals(cm.getWater(), 0, "Water is not right");
	}
	@Test
	void SetIngredientsTest2() {
		CoffeeMachine cm=new CoffeeMachine();
		cm.SetIngredient();
		assertEquals(cm.Coffee_Count, 0, "coffee powder is not right");
		assertEquals(cm.getcoffee_powder(), 500.0, "coffee powder is not right");
		assertEquals(cm.getMilk(), 1, "Milk is not right");
		assertEquals(cm.getWater(), 2, "Water is not right");
	}
	@Test
	void CleanMachineTest3() {
		CoffeeMachine cm=new CoffeeMachine();
		cm.CleanMachine();
		assertEquals(cm.getcoffee_powder(), 0, "coffee powder is not right");
		assertEquals(cm.getMilk(), 0, "Milk is not right");
		assertEquals(cm.getWater(), 0, "Water is not right");
	}
	
	@Test
	void getIngredientsTest4() {
		CoffeeMachine cm=new CoffeeMachine();
		String expected = "Available Coffee Power(Gram) "+String.format("%.1f",cm.getcoffee_powder());
		expected +="\nAvailable Milk(Liter) "+String.format("%.1f", cm.getMilk());
		expected+= "\nAvailable Water(Liter) "+String.format("%.1f", cm.getWater());
		expected+='\n';
	    ByteArrayOutputStream baos = new ByteArrayOutputStream();
	    PrintStream printStream = new PrintStream(baos);
	    System.setOut(printStream);
	    cm.GetIngredient();
	    String actual = baos.toString();
	    assertEquals(expected, actual , "Output is wrong");
	}
	
	/**/
	
	
	
	@Test
	void BlackCoffee1Test5() {   // "if true" scenario
		CoffeeMachine cm=new CoffeeMachine();
		cm.SetIngredient();
		String expected = "\nMaking Black Coffee...\n"+"\nTaking 10gm of Coffee Powder.\n"+"Taking 0.2 liter of Water.\n"+"\nYour Black Coffee is Ready.\n";
	    ByteArrayOutputStream baos = new ByteArrayOutputStream();
	    PrintStream printStream = new PrintStream(baos);
	    System.setOut(printStream);
	    double expectedCP=cm.getcoffee_powder()-10;
	    double expectedW=cm.getWater()-0.2;
	    double expectedM=cm.getMilk();
	    cm.BlackCoffee();
	    String actual = baos.toString();
	    assertEquals(expected, actual , "Output is wrong");
	    assertEquals(expectedCP, cm.getcoffee_powder(), "Output is wrong !!");
	    assertEquals(expectedW, cm.getWater(), "Output is wrong !!");
	    assertEquals(expectedM, cm.getMilk(), "Output is wrong !!");
	    assertEquals(1, cm.Coffee_Count, "no of coffees is wrong");
		}
	@Test
	void BlackCoffee2Test6() {    // "else true" scenario
		CoffeeMachine cm=new CoffeeMachine();
		String expected="\nAvailable Coffee Power(Gram) "+String.format("%.1f",cm.getcoffee_powder());
		expected+="\nAvailable Water(Liter) "+String.format("%.1f", cm.getWater());
		expected+="\n\nSome Iteams Are Not Available, Please Fill before Making Coffee.\n";
	    ByteArrayOutputStream baos = new ByteArrayOutputStream();
	    PrintStream printStream = new PrintStream(baos);
	    System.setOut(printStream);
	    double expectedCP=cm.getcoffee_powder();
	    double expectedW=cm.getWater();
	    double expectedM=cm.getMilk();
	    cm.BlackCoffee();
	    String actual = baos.toString();
	    assertEquals(expected, actual , "Output is wrong");
	    assertEquals(expectedCP, cm.getcoffee_powder(), "Output is wrong !!");
	    assertEquals(expectedW, cm.getWater(), "Output is wrong !!");
	    assertEquals(expectedM, cm.getMilk(), "Output is wrong !!");
	    assertEquals(0, cm.Coffee_Count, "no of coffees is wrong");
	}
	
	@Test
	void MilkCoffee1Test7() {    // "if true" scenario
		CoffeeMachine cm=new CoffeeMachine();
		cm.SetIngredient();
		String expected="\nMaking Milk Coffee...\n";
		expected+="\nTaking 10gm of Coffee Powder.\n";
		expected+="Taking 0.4 Liter of Milk.\n";
		expected+="Taking 0.2 liter of Water.\n";
		expected+="\nYour Milk Coffee is Ready.\n";
	    ByteArrayOutputStream baos = new ByteArrayOutputStream();
	    PrintStream printStream = new PrintStream(baos);
	    System.setOut(printStream);
	    double expectedCP=cm.getcoffee_powder()-10;
	    double expectedW=cm.getWater()-0.2;
	    double expectedM=cm.getMilk()-0.4;
	    cm.MilkCoffee();
	    String actual = baos.toString();
	    assertEquals(expected, actual , "Output is wrong");
	    assertEquals(expectedCP, cm.getcoffee_powder(), "Output is wrong !!");
	    assertEquals(expectedW, cm.getWater(), "Output is wrong !!");
	    assertEquals(expectedM, cm.getMilk(), "Output is wrong !!");
	    assertEquals(1, cm.Coffee_Count, "no of coffees is wrong");
	}
	@Test
	void MilkCoffee2Test8() {    // "else true" scenario
		CoffeeMachine cm=new CoffeeMachine();
		String expected="\nAvailable Coffee Power(Gram) "+String.format("%.1f",cm.getcoffee_powder());
		expected+="\nAvailable Milk(Liter) "+String.format("%.1f", cm.getMilk());
		expected+="\nAvailable Water(Liter) "+String.format("%.1f", cm.getWater());
		expected+="\n\nSome Iteams Are Not Available, Please Fill before Making Coffee.\n";
	    ByteArrayOutputStream baos = new ByteArrayOutputStream();
	    PrintStream printStream = new PrintStream(baos);
	    System.setOut(printStream);
	    double expectedCP=cm.getcoffee_powder();
	    double expectedW=cm.getWater();
	    double expectedM=cm.getMilk();
	    cm.MilkCoffee();
	    String actual = baos.toString();
	    assertEquals(expected, actual , "Output is wrong");
	    assertEquals(expectedCP, cm.getcoffee_powder(), "Output is wrong !!");
	    assertEquals(expectedW, cm.getWater(), "Output is wrong !!");
	    assertEquals(expectedM, cm.getMilk(), "Output is wrong !!");
	    assertEquals(0, cm.Coffee_Count, "no of coffees is wrong");
	}
	
	
	@Test
	void MakeCoffeeCase0Test9() {    
		CoffeeMachine cm=new CoffeeMachine();
		String expected="\n ------------------ \n";
		expected+="|   Select Type:   |\n ------------------ \n| 1:  Black Coffee |\n| 2:  Milk Coffee  |\n| 0   to Discard   |\n";
		expected+=" ------------------ \n\n";
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
	    PrintStream printStream = new PrintStream(baos);
	    System.setOut(printStream);
		String userInput = "0";
		ByteArrayInputStream bais = new ByteArrayInputStream(userInput.getBytes());
		System.setIn(bais);
	    cm.makecoffee();
	    String actual = baos.toString();
	    assertEquals(expected, actual, "Output is different than expected");
	}

	@Test
	void MakeCoffeeCase1Test10() {    
		CoffeeMachine cm=new CoffeeMachine();
		String expected="\n ------------------ \n";
		expected+="|   Select Type:   |\n ------------------ \n| 1:  Black Coffee |\n| 2:  Milk Coffee  |\n| 0   to Discard   |\n";
		expected+=" ------------------ \n\n";
		expected+="\nAvailable Coffee Power(Gram) "+String.format("%.1f",cm.getcoffee_powder());
		expected+="\nAvailable Water(Liter) "+String.format("%.1f", cm.getWater());
		expected+="\n\nSome Iteams Are Not Available, Please Fill before Making Coffee.\n";
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
	    PrintStream printStream = new PrintStream(baos);
	    System.setOut(printStream);
		String userInput = "1";
		ByteArrayInputStream bais = new ByteArrayInputStream(userInput.getBytes());
		System.setIn(bais);
	    cm.makecoffee();
	    String actual = baos.toString();
	    assertEquals(expected, actual, "Output is different than expected");
	}
	
	@Test
	void MakeCoffeeCase2Test11() {    
		CoffeeMachine cm=new CoffeeMachine();
		String expected="\n ------------------ \n";
		expected+="|   Select Type:   |\n ------------------ \n| 1:  Black Coffee |\n| 2:  Milk Coffee  |\n| 0   to Discard   |\n";
		expected+=" ------------------ \n\n";
		expected+="\nAvailable Coffee Power(Gram) "+String.format("%.1f",cm.getcoffee_powder());
		expected+="\nAvailable Milk(Liter) "+String.format("%.1f", cm.getMilk());
		expected+="\nAvailable Water(Liter) "+String.format("%.1f", cm.getWater());
		expected+="\n\nSome Iteams Are Not Available, Please Fill before Making Coffee.\n";
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
	    PrintStream printStream = new PrintStream(baos);
	    System.setOut(printStream);
		String userInput = "2";
		ByteArrayInputStream bais = new ByteArrayInputStream(userInput.getBytes());
		System.setIn(bais);
	    cm.makecoffee();
	    String actual = baos.toString();
	    assertEquals(expected, actual, "Output is different than expected");
	}
	
	@Test
	void startCase1Test12() {    
		CoffeeMachine cm=new CoffeeMachine();
		String expected=" ----------------------------------------------------------------\n"
				+ "|                   Coffee Machine By Manikant                   |\n"
				+ " ----------------------------------------------------------------\n"
				+ "\n"
				+ "Current Status: \n"
				+ "Available Coffee Power(Gram) 0.0\n"
				+ "Available Milk(Liter) 0.0\n"
				+ "Available Water(Liter) 0.0\n"
				+ "\n"
				+ " -------------------------------- \n"
				+ "|1:     Status of Ingredient     |\n"
				+ " -------------------------------- \n"
				+ "|2:      Fill Ingredient         |\n"
				+ " -------------------------------- \n"
				+ "|3:       Clean Machine          |\n"
				+ " -------------------------------- \n"
				+ "|4:        Make Coffee           |\n"
				+ " -------------------------------- \n"
				+ "|5: How many Coffee We have made?|\n"
				+ " -------------------------------- \n"
				+ "|6:        Exit                  |\n"
				+ " -------------------------------- ";
		expected+="------------- Status ------------\n";
		expected += "Available Coffee Power(Gram) "+String.format("%.1f",cm.getcoffee_powder());
		expected +="\nAvailable Milk(Liter) "+String.format("%.1f", cm.getMilk());
		expected+= "\nAvailable Water(Liter) "+String.format("%.1f", cm.getWater());
		expected+='\n'
		+"---------------------------------\n";
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
	    PrintStream printStream = new PrintStream(baos);
	    System.setOut(printStream);
		String userInput = "1";
		ByteArrayInputStream bais = new ByteArrayInputStream(userInput.getBytes());
		System.setIn(bais);
	    cm.start();
	    String actual = baos.toString();
	    assertEquals(expected, actual, "Output is different than expected");
	}
	
	
}

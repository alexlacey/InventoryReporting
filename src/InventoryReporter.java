/**
 *  Inventory Reporting
 * 
 *  Reports and summarizes product information
 *  
 *   @author Alex Lacey
 *   @version 09182017
 */

import java.util.*;
import java.io.*;

public class InventoryReporter {

    public static void main(String[] args) {
    	Scanner in = new Scanner(System.in); 
        System.out.print("Enter an inventory filename: ");
        String fileName = in.nextLine();
        in.close();
	    try {
	    	File file = new File(fileName);
	    	Scanner inFile = new Scanner(file);
	    	ArrayList<Product> products = loadProducts(inFile);
	        getReport(products);
	    } catch (IOException e) {
	    	System.out.print(e);
	    }
    }

    // reads the lines in the file and stores them in the ArrayList
 	public static ArrayList<Product> loadProducts(Scanner inFile) {
 	    ArrayList<Product> products = new ArrayList<Product>();
         while (inFile.hasNext()) {
             Product currentProduct = new Product();
             currentProduct.setName(inFile.nextLine());
             currentProduct.setInventoryCode(inFile.nextLine());
             currentProduct.setQuantity(Integer.parseInt(inFile.nextLine()));
             currentProduct.setPrice(Double.parseDouble(inFile.nextLine()));
             currentProduct.setType(inFile.nextLine());
             while (true) { // goes until a -1 is encounted
             	int tmp = Integer.parseInt(inFile.nextLine());
             	if (tmp == -1) {
             		break;
             	}
             	currentProduct.addUserRating(tmp);
             }
             products.add(currentProduct);
         }
         inFile.close();
 	    return products;
 	}
 	
 	// Total generation method
 	public static void getReport(ArrayList<Product> products) {
 		generateReport(products);
        highestAvgRating(products);
        lowestAvgRating(products);
        largestTotalDollarAmount(products);
        smallestTotalDollarAmount(products);
 	}
    
    // Generates the main part of the report
 	private static void generateReport(ArrayList<Product> Products) {
        int count = 0;
        System.out.println("Product Inventory Summary Report");
        System.out.println("----------------------------------------------------------------------------------");
        System.out.printf("%-33s%-10s%-6s%-7s%-7s%-7s%-7s", "Product Name", "I Code", "Type", "Rating", "# Rat.", "Quant.", "Price"); System.out.println();
        System.out.printf("%-33s%-10s%-6s%-7s%-7s%-7s%-7s", "-------------------------------", "---------", "----", "------", "------", "------", "------"); System.out.println();
	    while (count < Products.size()) {
	        System.out.printf("%-33s%-10s%-6s%-7s%6s%7s%7s", 
	        	Products.get(count).getName(), 
	        	Products.get(count).getInventoryCode(), 
	        	Products.get(count).getType(), 
	        	numberToStars(Products.get(count).getAvgUserRating()), 
	        	Products.get(count).getUserRatingCount(), 
	        	Products.get(count).getQuantity(), 
	        	Products.get(count).getPrice());
	        System.out.println();
	        count++;
	    }
	    System.out.println("----------------------------------------------------------------------------------");
	    System.out.println("Total products in the database: " + Products.size());
 	}


    // Finds the item with the highest average user rating in stock
    private static void highestAvgRating(ArrayList<Product> Products) {
        int count = 0;
        int highestRated = 1;
        while (count < Products.size()) {
            if (Products.get(count).getAvgUserRating() > Products.get(highestRated).getAvgUserRating()) {
                highestRated = count;
            }
            count++;
        }
        System.out.println("Highest Average User Rating In Stock: " + Products.get(highestRated).getName() + " (" + numberToStars(Products.get(highestRated).getAvgUserRating()) + ")");   
    }

    // Finds the item with the lowest average user rating in stock
    private static void lowestAvgRating(ArrayList<Product> Products) {
        int count = 0;
        int lowestRated = 1;
        while (count < Products.size()) {
            if (Products.get(count).getAvgUserRating() < Products.get(lowestRated).getAvgUserRating()) {
                lowestRated = count;
            }
            count++;
        }
        System.out.println("Lowest Average User Rating In Stock: " + Products.get(lowestRated).getName() + " (" + numberToStars(Products.get(lowestRated).getAvgUserRating()) + ")");   
    }

    // Finds the item with the largest total dollar amount
    private static void largestTotalDollarAmount(ArrayList<Product> Products) {
        int count = 0;
        int largestAmount = 1;
        while (count < Products.size()) {
        	if ((Products.get(count).getPrice()) * (Products.get(count).getQuantity()) > ((Products.get(largestAmount).getPrice()) * (Products.get(largestAmount).getQuantity()))){
                largestAmount = count;
            }
            count++;
        }
        System.out.println("Item With The Largest Total Dollar Amount In Inventory: " + Products.get(largestAmount).getName() + " ($" + ((Products.get(largestAmount).getPrice()) * (Products.get(largestAmount).getQuantity())) + ")");  
    }
    
    // Finds the item with the smallest total dollar amount
    private static void smallestTotalDollarAmount(ArrayList<Product> Products) {
        int count = 0;
        int smallestAmount = 1;
        while (count < Products.size()) {
        	if ((Products.get(count).getPrice()) * (Products.get(count).getQuantity()) < ((Products.get(smallestAmount).getPrice()) * (Products.get(smallestAmount).getQuantity()))){
                smallestAmount = count;
            }
            count++;
        }
        System.out.println("Item With The Smallest Total Dollar Amount In Inventory: " + Products.get(smallestAmount).getName() + " ($" + ((Products.get(smallestAmount).getPrice()) * (Products.get(smallestAmount).getQuantity())) + ")");  
    }
    
    // Converts the numerical rating into stars
    private static String numberToStars(int input) {
    	String output = "";
    	while (input > 0) {
    		output += "*";
    		input--;
    	}
    	return output;
    }
    
}
/**
 * Product
 * 
 *   A simple test for the Product and Project02 classes
 *   
 *   @author Alex Lacey
 *   @version 09182017
 */

import java.util.*;
import java.io.*;

public class ProductTest {

	// Main test code, which uses the loadProducts and showProducts methods from the Project02 class
	public static void main(String[] args) {
	    String filePath = "/Users/alexlacey/Desktop/testFile.txt";
	    try {
	    	File file = new File(filePath);
	    	Scanner inFile = new Scanner(file);
	    	ArrayList<Product> products = Project02.loadProducts(inFile);
	    	Project02.getReport(products);
	    } catch (IOException e) {
	    	System.out.print(e);
	    }
	}

}
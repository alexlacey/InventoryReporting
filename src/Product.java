/**
 * Product
 * 
 *   A simple class framework used to demonstrate the design
 *   of Java classes.
 *   
 *   @author Alex Lacey
 *   @version 09182017
 */

import java.util.ArrayList;

public class Product {

    private String name;
    private String type;
    private double price;
    private int quantity;
    private String code;
    private ArrayList<Integer> ratings;

    public Product() {
        this.name = "";
        this.type = "";
        this.price = 0;
        this.quantity = 0;
        this.code = "";
        this.ratings= new ArrayList<Integer>();
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public String getName() {
        return name;
    }
    
    public void setType(String type) {
        this.type = type;
    }
    
    public String getType() {
        return type;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    
    public double getPrice() {
        return price;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
    public int getQuantity() {
        return quantity;
    }
    
    public void setInventoryCode(String code) {
        this.code = code;
    }
    
    public String getInventoryCode() {
        return code;
    }
    
    public void addUserRating(int rating) {
		this.ratings.add(rating);
	}
	
	public int getUserRating(int index) {
		return this.ratings.get(index);
	}
	
	public int getUserRatingCount() {
		return this.ratings.size();
	}
	
	public int getAvgUserRating() {
		int total = 0;
		if (this.ratings.size() == 0) {
			return 0;
		}
		for (Integer rating : this.ratings){
			total += rating;
		}
		return total/this.ratings.size();
	}

}

package OnlineStore;

import java.util.*;
public class Store {
	ArrayList<Product> products;
	HashMap<Integer,Integer> stock;
	
	Store()
	{
		products= new ArrayList<Product>();
		stock= new HashMap<Integer,Integer>();
	}
	
	void addProducts(Product product,int qty)
	{
		products.add(product);
		stock.put(product.getId(), qty);
	}
	
	synchronized void sale(HashMap<Integer,Integer> carts)
	{
		for(Map.Entry<Integer, Integer> item: carts.entrySet())
		{
			int sqty=stock.get(item.getKey());
			if(sqty>=item.getValue())
			{
				int nqty=sqty-item.getValue();
				stock.replace(item.getKey(), nqty);
			}
		}
	}
	
	void productsDisplay()
	{
		System.out.println("========================================================");
		System.out.printf("%-15s%-15s%-15s%-15s\n========================================================\n","PID","PName","Price","Quantity");
		for(Product p: products)
		{
			System.out.printf("%-15d%-15s%-15.2f%-15d\n",p.getId(),p.getName(),p.getPrice(),stock.get(p.getId()));
		}
	}

	
	

}
package OnlineStore;

import java.util.*;
public class Process {

	public static void main(String[] args) {
		
		Store ms=new Store();
		ms.addProducts(new Product(101,"Shirt",450),50);
		ms.addProducts(new Product(110,"T-Shirt",200),150);
		ms.addProducts(new Product(205,"Jeans",300),75);
		ms.addProducts(new Product(121,"Casuals",650),40);
		ms.addProducts(new Product(115,"Coat suit",1150),150);
		ms.addProducts(new Product(134,"Kids shirt",350),50);
		ms.addProducts(new Product(225,"Denim Shirt",450),50);
		ms.addProducts(new Product(144,"Dhotis",150),50);
		ms.addProducts(new Product(196,"Kurtas",350),50);
		ms.addProducts(new Product(125,"pijamas",550),50);
		
		ms.productsDisplay();
		
		Random r=new Random();
		int n= r.nextInt(5)+1;
		Customer[] customers=new Customer[n];
		System.out.println(n+" Customers created");
		
		for(int i=0;i<n;i++)
		{
			customers[i]= new Customer("Customer"+(i+1),ms);
		}
		
		for(int i=0;i<n;i++)
		{
			customers[i].start();
		}
		
		for(int i=0;i<n;i++)
		{
			try {
				customers[i].join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
		
		for(int i=0;i<n;i++)
		{
			System.out.println("Customer"+(i+1)+"Purchase details");
			customers[i].viewCart();
		}
		
		ms.productsDisplay();
	}

}

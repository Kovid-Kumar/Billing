package com.ecommerce.bill;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.ecommerce.entity.Product;

public class ShopingInput {

	

	public static Billing getInput(List<Product> products) {
		Billing inputDetails=new Billing();
		inputDetails.setProducts(new ArrayList<Product>());
		Scanner input = new Scanner(System.in);
		System.out.println("Please enter your details carefully and discounts based on your mobile number");
        System.out.print("Your name   : ");
        inputDetails.setName(input.nextLine());
        System.out.print("Your mobile : ");
        inputDetails.setMobile(input.nextLine());
        while(true){
        	System.out.println("----------------------------------------------------------------------------");
        	System.out.println("Please choose products by their Sr.No. or 0 for exit");
        	System.out.println("-----------------------------------------------");
        	System.out.println("Sr.No.| Name               | Price |");
        	System.out.println("------------------------------------");
        	int i=1;
        	for (Product product : products) {
        		System.out.println(formate(""+i++,6)+"|"+formate(product.getName(),20)+"|"+formate(product.getPrice(),7)+"|");
			}
        	System.out.println("------------------------------------");
        	System.out.print("Enter your choice       : ");
        	
        	int choice;
        	int count;
        	try {
        		choice=Integer.parseInt(input.nextLine());
        		if(choice==0){
            		break;
            	}
        		System.out.print("Enter pices/Kg(s) count : ");
        		count=Integer.parseInt(input.nextLine());
        		if(choice<0 || choice>i-1){
        			choice=choice/0;
        		}
			} catch (Exception e) {
				System.out.println("Wrong Choice");
				continue;
			}
        	
        	if(choice==0){
        		break;
        	}else{
        		Product product=products.get(choice-1);
        		product.setPices(count);
        		inputDetails.getProducts().add(product);
        	}
        }
		return inputDetails;
	}

	public static String formate(String str, int i) {
		String tempStr=str;
		if(str.length()<i){
			for (int j = str.length(); j <i; j++) {
				tempStr+=" ";
			}
		}
			
		return tempStr;
	}
}

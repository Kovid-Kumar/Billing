package com.ecommerce.bill;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.ecommerce.entity.Customer;
import com.ecommerce.entity.Employee;
import com.ecommerce.entity.Product;

public class Billing {

	private String name;
	private String mobile;
	private List<Customer> customers;
	private List<Employee> employee;
	private List<Product> products;
	private boolean isAffiliate=false;
	private boolean oldCustomer=false;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public List<Customer> getCustomers() {
		return customers;
	}
	public void setCustomers(List<Customer> customers) {
		this.customers = customers;
	}
	public List<Product> getProducts() {
		return products;
	}
	public void setProducts(List<Product> products) {
		this.products = products;
	}
	public void showInvoice() {
			System.out.println("\n\n\n\n\n   ------------***   Your Invoice  ***----------------");
		try {
			System.out.println("Name : "+ShopingInput.formate(name,15)+"    Mobile : "+mobile);
			System.out.println("--------------------------------------------------------------");
        	System.out.println("Sr.No.| Name               | Price | Items(count) | Cost(Rs) |");
        	System.out.println("--------------------------------------------------------------");
        	int i=1;
        	double total=0;
        	int discountableAmount=0;
        	for (Product product : products) {
        		int cost=product.calculateCost();
        		total=total+cost;
        		if(!"Grocery".equals(product.getCatagory())){
        			discountableAmount=discountableAmount+cost;
        		}
        		System.out.println(ShopingInput.formate(""+i++,6)+"|"+ShopingInput.formate(product.getName(),20)
        		+"|"+ShopingInput.formate(product.getPrice(),7)+"|"+ShopingInput.formate(""+product.getPices(),14)+"|"
        		+ShopingInput.formate(""+cost,10)+"|");
			}
        	System.out.println("                                                 ------------");
        	System.out.println("Sub total                                           "+ShopingInput.formate(""+total,10));
        	if(isCoustomer()){
        		double discount=(discountableAmount*30)/100;
        		total=total-discount;
        		System.out.println("30% Discount for employee                          "+ShopingInput.formate("-"+discount,10));
        		
        	}else if(isAffiliate){
        		double discount=(discountableAmount*10)/100;
        		total=total-discount;
        		System.out.println("10% Discount for Affiliate                          "+ShopingInput.formate("-"+discount,10));
        		
        	}else if(oldCustomer){
        		double discount=(discountableAmount*5)/100;
        		total=total-discount;
        		System.out.println("5% Discount for old customer                        "+ShopingInput.formate("-"+discount,10));
        		
        	}
        	double discount=((int)(total/100))*5;
        	total=total-discount;
        	System.out.println("Extra Discount                                     "+ShopingInput.formate("-"+discount,10));
        	System.out.println("                                                 ------------");
        	System.out.println("Total payable amount                                "+ShopingInput.formate(""+total,10));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	private boolean isCoustomer() {
		boolean flag=false;
		for (Employee emp : employee) {
			if(mobile.equals(emp.getMobile())){
				flag=true;
				break;
			}
		}
		for (Customer customer : customers) {
			if(mobile.equals(customer.getMobile())){
				
				if("Y".equals(customer.getIsAffiliate())){
					isAffiliate=true;
				}
				try {
					Date date=new SimpleDateFormat("dd-MM-yyyy").parse(customer.getFirstPurchageDate());  
					Calendar cal=Calendar.getInstance();
					cal.add(Calendar.YEAR, -2); 
					Date preYear = cal.getTime();
					if(date.before(preYear)){
						oldCustomer=true;
					}
				} catch (Exception e) {}
			}
		}
		return flag;
	}
	public List<Employee> getEmployee() {
		return employee;
	}
	public void setEmployee(List<Employee> employee) {
		this.employee = employee;
	}
	
}

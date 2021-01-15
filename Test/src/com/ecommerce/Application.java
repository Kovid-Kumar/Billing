package com.ecommerce;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import com.ecommerce.bill.Billing;
import com.ecommerce.bill.ShopingInput;
import com.ecommerce.entity.Customer;
import com.ecommerce.entity.Employee;
import com.ecommerce.entity.Product;

public class Application {
	final static String COMMA_DELIMITER=",";
    final static String path="E:\\";
    static List<Employee> employes=readEmployeeCSV("employee.csv");
    static List<Customer> customers=readCustomerCSV("Customer.csv");
    static List<Product> products=readProductCSV("Product.csv");
    
	public static void main(String[] args) {
		Billing bill=ShopingInput.getInput(products);
		bill.setEmployee(employes);
		bill.setCustomers(customers);
		bill.showInvoice();
	}

	public static List<Employee> readEmployeeCSV(String filename){
		List<Employee> records =new ArrayList<Employee>();
		try {
			
			try (BufferedReader br = new BufferedReader(new FileReader(path+filename))) {
			    String line= br.readLine();
			    while ((line = br.readLine()) != null) {
			        String[] values = line.split(COMMA_DELIMITER);
			        
			        records.add(new Employee(values[0],values[1],values[2]));
			    }
			}
			//System.out.println(records);
		} catch (Exception e) {
			System.out.print(" Inside read Employee csv : ");
			e.printStackTrace();
		}
		return records;
	}
	public static List<Customer> readCustomerCSV(String filename){
		List<Customer> records =new ArrayList<Customer>();
		try {
			
			try (BufferedReader br = new BufferedReader(new FileReader(path+filename))) {
			    String line= br.readLine();
			    while ((line = br.readLine()) != null) {
			        String[] values = line.split(COMMA_DELIMITER);
			        
			        records.add(new Customer(values[0],values[1],values[2],values[3],values[4]));
			    }
			}
			//System.out.println(records);
		} catch (Exception e) {
			System.out.print(" Inside read Customer csv : ");
			e.printStackTrace();
		}
		return records;
	}
	public static List<Product> readProductCSV(String filename){
		List<Product> records =new ArrayList<Product>();
		try {
			
			try (BufferedReader br = new BufferedReader(new FileReader(path+filename))) {
			    String line= br.readLine();
			    while ((line = br.readLine()) != null) {
			        String[] values = line.split(COMMA_DELIMITER);
			        
			        records.add(new Product(values[0],values[1],values[2],values[3]));
			    }
			}
			//System.out.println(records);
		} catch (Exception e) {
			System.out.print(" Inside read Product csv : ");
			e.printStackTrace();
		}
		return records;
	}
}

package Customer;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.Set;


public class CustomerTest {

	public static void main(String[] args) {
		 List<Customer> custSet = new ArrayList<>();
	        custSet.add(new Customer(101, "Harith",2000));
	        custSet.add(new Customer(102, "Sara",3000));     
	        custSet.add(new Customer(103, "Talal",4000));
	        custSet.add(new Customer(104, "Ghassan", 5000));

	        for (Customer emp : custSet) {
	            System.out.println(emp);
	        }
	
	 List<Customer> custList = new ArrayList<>();
     Scanner scanner = new Scanner(System.in);

    
        while (true) {
            System.out.println("1. Add Customer");
            System.out.println("2. Update Customer");
            System.out.println("3. Delete Customer");
            System.out.println("4. Show All Customers");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); 
            switch (choice) {
            case 1:
                addCustomer(scanner,custList);
                break;
            case 2:
                updateCustomer(scanner,custList);
                break;
            case 3:
                deleteCustomer(scanner,custList);
                break;
            case 4:
                showCustomers(custList);
                break;
            case 5:
                System.out.println("Exiting program...");
                return;
            default:
                System.out.println("Invalid choice! Please try again.");
            }
        }
	}
                private static void addCustomer(Scanner scanner,List<Customer> custList ) {
                    System.out.print("Enter Customer ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine(); 
                    System.out.print("Enter Customer Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Balance: ");
                    double balance = scanner.nextDouble();
                    scanner.nextLine();

                    Customer newCustomer = new Customer(id, name, balance);

                    if (custList.add(newCustomer)) {
                        System.out.println("Customer added successfully!");
                    } else {
                        System.out.println("Customer ID already exists. Cannot add duplicate.");
                    
                }
            }   
                private static void updateCustomer(Scanner scanner,List<Customer> custList ) {
                    System.out.print("Enter Customer ID to update: ");
                    int id = scanner.nextInt();
                    scanner.nextLine(); 

                    for (Customer customer : custList) {
                        if (customer.getCustId() == id) {
                            System.out.print("Enter new Name: ");
                            String newName = scanner.nextLine();
                            System.out.print("Enter new Balance: ");
                            double newBalance = scanner.nextDouble();
                            scanner.nextLine(); 

                            customer.setCustName(newName);
                            customer.setBalance(newBalance);
                            System.out.println("Customer details updated successfully!");
                            return;
                        }
                    }
                    System.out.println("Customer not found!");
                
                } 
                private static void deleteCustomer(Scanner scanner,List<Customer> custList) {
                	 System.out.print("Enter Customer ID to delete: ");
                     int id = scanner.nextInt();
                     scanner.nextLine();

                     Iterator<Customer> iterator = custList.iterator();
                     while (iterator.hasNext()) {
                         Customer customer = iterator.next();
                         if (customer.getCustId() == id) {
                             iterator.remove();  // Safe removal using iterator
                             System.out.println("Customer deleted successfully!");
                             return;
                         }
                     }
                     System.out.println("Customer not found!");}
                private static void showCustomers(List<Customer> custList) {
                    if (custList.isEmpty()) {
                        System.out.println("No customers available.");
                    } else {
                        System.out.println("Customer List:");
                        for (Customer customer : custList) {
                            System.out.println(customer);
                        }
                    }
                }
            }




                
   
         


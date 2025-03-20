package com.training.collection;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CollectionDemo {
	
	public static void main(String[] args) {
//		List<String> names = new ArrayList<>();
//		names.add("Ahmed");
//		names.add("Hassan");
//		names.add("Ali");
//		names.add("Fatimah");
//		names.add("Ali");
//		
//		for(String name:names) {
//			System.out.println(name);
//		}
//		
//		Set<String> names = new HashSet<>();
//        names.add("Ahmed");
//        names.add("Hassan");
//        names.add("Ali");
//        names.add("Fatimah");
//        names.add("Ali");
//
//        for (String name : names) {
//            System.out.println(name);
//        }
        
//		Iterator<String> iter = names.iterator();
//		while(iter.hasNext()) {
//			System.out.println(iter.next());
//		}

        Set<Employee> empSet = new HashSet<>();
        empSet.add(new Employee(101, "Harith", "IT", 2000));
        empSet.add(new Employee(102, "Sara", "IT", 2000));     
        empSet.add(new Employee(103, "Talal", "IT", 2000));
        empSet.add(new Employee(104, "Harith", "IT", 2000));

        for (Employee emp : empSet) {
            System.out.println(emp);
        }
        
}
}

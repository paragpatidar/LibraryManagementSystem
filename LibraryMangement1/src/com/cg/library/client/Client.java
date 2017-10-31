package com.cg.library.client;

import java.util.Scanner;

import com.cg.library.entities.BookInventory;
import com.cg.library.service.LibraryService;
import com.cg.library.service.LibraryServiceImpl;

public class Client {

	@SuppressWarnings("resource")
	public static void main(String[] args) {

		LibraryService service = new LibraryServiceImpl();
		
	
		Scanner sc = new Scanner(System.in);
		System.out.println("Username - ");
		String userName = sc.next();
		System.out.println("Password - ");
		String password = sc.next();
		
		if(userName.equals("parag")&&password.equals("parag"))
		{
			System.out.println("\n\n\n************Listing All books*************");
			for(BookInventory bookInventory:service.getAllBooks()) {
				System.out.println(bookInventory);
			}
		}
		else
		{
			System.out.println("Not a valid User");
		}
		
	
		
		

		
		

		
		
		

	}
}

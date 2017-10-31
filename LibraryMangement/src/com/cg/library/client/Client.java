package com.cg.library.client;

import java.util.Scanner;

import com.cg.library.entities.BookInventory;
import com.cg.library.service.LibraryService;
import com.cg.library.service.LibraryServiceImpl;

public class Client {

	@SuppressWarnings({ "resource", "unused" })
	public static void main(String[] args) {

		LibraryService service = new LibraryServiceImpl();


		Scanner sc = new Scanner(System.in);
		System.out.println("Username - ");
		String userName = sc.next();
		System.out.println("Password - ");
		String password = sc.next();
		int status = service.validateUser(userName, password);

		if(status==1)//librarian************************
		{
			System.out.println("Welcome "+userName+" You are librarian");

			System.out.println("\n1.Display ALL Books\n2.Add a book\n3.Delete a book"
					+ "\n4.Modify a Book\n5.Issue request\n6.Return Book");
			Scanner sa = new Scanner(System.in);
			System.out.println("Please select your operation - ");
			int choice = sa.nextInt();

			switch(choice)
			{
			case 1 : System.out.println("\n\n\n************Listing All books*************");
			for(BookInventory bookInventory:service.getAllBooks()) {
				System.out.println(bookInventory);
			}
			break;
			case 2 :
				BookInventory bookNew = new BookInventory();
				System.out.println("Enter Details \n");
				System.out.println("Enter Book Id ");
				Scanner sb = new Scanner(System.in);
				String bookId = sb.nextLine();
				bookNew.setBookId(bookId);
				System.out.println("Enter Book Name ");
				String bookName = sb.nextLine();
				bookNew.setBookName(bookName);
				System.out.println("Enter Book Author 1 ");
				String author1 = sb.nextLine();
				bookNew.setAuthor1(author1);
				System.out.println("Enter Book Author 2 ");
				String author2 = sb.nextLine();
				bookNew.setauthor2(author2);

				bookNew = service.insertBook(bookNew);

				System.out.println("Book inserted with Id "+bookNew.getBookId());

				break;
			default : System.out.println("You r in defau;t section");	 
			}	
		}
		else if(status==0)//Student******************
		{
			System.out.println("Welcome "+userName+" You are student");

			System.out.println("\n1.Display ALL Books\n2.Place a request");
			Scanner sa = new Scanner(System.in);
			System.out.println("Please select your operation - ");
			int choice = sa.nextInt();
			switch(choice)
			{
			case 1 : 
				System.out.println("\n\n\n************Listing All books*************");
				for(BookInventory bookInventory:service.getAllBooks()) {
					System.out.println(bookInventory);
				}
			case 2 :
				System.out.println();

			}


		}
		else
		{
			System.out.println("Not a valid User");
		}












	}
}

package com.cg.library.controller;

import java.io.IOException;
import java.util.Scanner;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cg.library.service.LibraryService;
import com.cg.library.service.LibraryServiceImpl;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	LibraryService service ;
	int status;
    public LoginController() {
        super();
        service = new LibraryServiceImpl();

    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings("resource")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("User Name - ");
		String userName = sc.next();
		System.out.println("Password - ");
		String password = sc.next();
		
		status = service.validateUser(userName, password);
		
		if(status==1){
			RequestDispatcher rd = request.getRequestDispatcher("LibraryController");
			rd.forward(request,response);
		}
		else{
			System.err.println("Not a valid user");
		}
		
		
	}

}

package com.cg.library.controller;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cg.library.entities.BookInventory;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cg.library.entities.Users;
import com.cg.library.exception.LibraryException;
import com.cg.library.service.ILibraryService;

@Controller
public class LibraryController {
	
	@Autowired
	ILibraryService service;
	

	@RequestMapping(value="/display")
	public String displayBook(Model model,@RequestParam("userName") String userName)
	{
		try
		{
			List<BookInventory> allBook=service.getAllBooks();
			model.addAttribute("allBook", allBook);
			model.addAttribute("userName", userName);
		}
		catch(LibraryException le)
		{
			model.addAttribute("message",le.getMessage());
			return "Error";
		}
		return "DisplayBook";
	}

	/**
	 * Method used for validating user
	 * @param model
	 * @param userName
	 * @param password
	 * @return
	 */
	@RequestMapping(value="/login.htm",method=RequestMethod.POST)
	public String login(Model model,@RequestParam("userName") String userName, @RequestParam("password") String password){
		try {
			int i=service.validateUser(userName, password);
			model.addAttribute("userName", userName);
			if(i==0)
			  return "StudentOperation";
			else
			  return "LibrarianOperation";	
		} catch (LibraryException e) {
			model.addAttribute("message",e.getMessage());
			return "Error";
		}
	}
	
	/**
	 * Method for handling show all book request
	 * @param model
	 * @return
	 */
	@RequestMapping("/showAll.htm")
	public String showAllBooks(Model model){
		try {
			model.addAttribute("bookList",service.getAllBooks());
			return "BookSearch";
		} catch (LibraryException e) {
			model.addAttribute("message",e.getMessage());
			return "Error";
		}
	}
	
	/**
	 * Method redirects request to sign up page
	 * @param model
	 * @return
	 */
	@RequestMapping("signUp.htm")
	public String newUser(Model model){
		model.addAttribute("user",new Users());
		model.addAttribute("librarian",new String[]{"Please select","true","false"});
		return "SignUp";
	}
	
	/**
	 * Takes data of new user and persist in table
	 * @param model
	 * @param user
	 * @return
	 */
	@RequestMapping(value="/signUp.htm",method=RequestMethod.POST)
	public String signUp(Model model, @ModelAttribute("user") Users user){
		try {
			user = service.addUser(user);
			model.addAttribute("message", "User added with user Id = "+user.getUserId());
			return "Success";
		} catch (LibraryException e) {
			model.addAttribute("message",e.getMessage());
			return "Error";
		}

	}
	

}

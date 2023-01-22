package web.customer.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import web.customer.springdemo.dao.CustomerDAO;
import web.customer.springdemo.entity.Customer;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	//need to inject to customer DAO
	@Autowired
	private CustomerDAO customerDAO;
	
	@RequestMapping("/list")
	public String listCustomers(Model theModel) {
		
		//Get customers from the dao
		
		List<Customer>theCustomers = customerDAO.getCustomers();
		
		//add the custemers to the model
		
		theModel.addAttribute("customers",theCustomers);
		
		return "list-customers";
	}
}

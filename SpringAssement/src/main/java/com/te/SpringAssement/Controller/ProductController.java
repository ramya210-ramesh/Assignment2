package com.te.SpringAssement.Controller;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.te.SpringAssement.Services.ProductService;
import com.te.SpringAssement.bean.ProductDetails;

@Controller
public class ProductController {
	@Autowired
	private ProductService service;

	@GetMapping("/login")
	public String logIn() {
		return "loginform";

	}

	@PostMapping("/welcome")
	public String data(int id, String password, ModelMap map, HttpServletRequest request) {
		ProductDetails details = service.authenticate(id, password);
		HttpSession session = request.getSession();
		session.setAttribute("loggedIn", details);
		if (details != null) {
			map.addAttribute("data", details.getName());
			return "welcome";
		} else {
			map.addAttribute("errMsg", "Enter valid data");
			return "loginform";
		}

	}

	@GetMapping("/add")
	public String addForm(@SessionAttribute(name = "loggedIn", required = false) ProductDetails details2,
			ModelMap map) {
		if (details2 != null) {
			return "addForm";
		} else {
			map.addAttribute("errMsg", "login Again!!");
			return "loginform";
		}
	}

	@PostMapping("/add")
	public String addData(ProductDetails details, ModelMap map,
			@SessionAttribute(name = "loggedIn", required = false) ProductDetails details2) {
		if (details2 != null) {
			if (service.addData(details)) {
				map.addAttribute("msg", "Data Inserted successsfully!!");
			} else {

				map.addAttribute("errMsg", "Something went wrong!!");

			}
			return "addForm";
		} else {
			map.addAttribute("errMsg", "please login first!!");
			return "login";
		}
	}

	@GetMapping("/delete")
	public String deleteform(@SessionAttribute(name = "loggedIn", required = false) ProductDetails details,
			ModelMap map) {
		if (details != null) {
			return "deleteform";
		} else {
			map.addAttribute("errMsg", "Login First!!");
			return "loginform";
		}
	}

	@PostMapping("/delete")
	public String deleteData(ModelMap map, int id,
			@SessionAttribute(name = "loggedIn", required = false) ProductDetails details) {
		if (details != null) {
			if (service.deleteData(id)) {
				map.addAttribute("msg", "Data Deleted Success!!");

			} else {
				map.addAttribute("msg", "Data not found for this id");

			}
			return "deleteform";
		}

		else {
			map.addAttribute("errMsg", "Please login first!!!");
			return "loginform";
		}
	}

	@GetMapping("/getdata")
	public String getData(@SessionAttribute(name = "loggedIn", required = false) ProductDetails details,
			ModelMap map) {
		if (details != null) {
			return "getform";
		} else {
			map.addAttribute("errMsg", "Login First!!");
			return "loginform";
		}
	}

	@PostMapping("/getdata")
	public String getData(ProductDetails details, ModelMap map, int id,
			@SessionAttribute(name = "loggedIn", required = false) ProductDetails details2) {
		if (details2 != null) {
			ProductDetails details3 = service.getData(id);
			if (details3 != null) {
				map.addAttribute("data", details3);
			} else {
				map.addAttribute("msg", "Data not Found for this id :" + id);
			}
			return "getform";
		} else {
			map.addAttribute("errmsg", "Please login First!!!");
			return "loginform";
		}
	}

	@GetMapping("/update")
	public String updateData(@SessionAttribute(name = "loggedIn", required = false) ProductDetails details,
			ModelMap map) {
		if (details != null) {
			map.addAttribute("data", details);
			return "updateform";
		} else {
			map.addAttribute("errMsg", "Login First!!");
			return "loginform";
		}
	}

	@PostMapping("/update")
	public String updateData(@SessionAttribute(name = "loggedIn", required = false) ProductDetails details,
			ProductDetails details2, ModelMap map) {
		if (details != null) {
			if (service.updateData(details2, details.getId())) {
				map.addAttribute("msg", "Data updated successfully");
				map.addAttribute("data", details);
			} else {
				map.addAttribute("msg", "Something went Wrong!!!!");
			}
			return "updateform";
		} else {
			map.addAttribute("errmsg", "Please login First!!!");
			return "loginform";
		}
	}



	@GetMapping("/getall")
	public String allData(@SessionAttribute(name = "loggedIn", required = false) ProductDetails details2,
			ModelMap map) {
			List<ProductDetails> list =service.getAll();
			if (list != null) {
				map.addAttribute("data", list); 
			return "getallform";
		} else {
			map.addAttribute("errMsg", "please login first!");
			return "loginform";
		}
	}
	
	
	@GetMapping("/logout")
	public String logout(ModelMap map, HttpSession session) {
		session.invalidate();
		map.addAttribute("errMsg", "logged Out successfully");
		return "loginform";

	}
}

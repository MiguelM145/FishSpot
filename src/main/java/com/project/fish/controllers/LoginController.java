package com.project.fish.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.project.fish.models.Fish;
import com.project.fish.models.FishUser;
import com.project.fish.models.LoginUser;
import com.project.fish.models.User;
import com.project.fish.services.FishService;
import com.project.fish.services.FishUserService;
import com.project.fish.services.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class LoginController {
	@Autowired
	private UserService userService;
	
	@Autowired
	private FishService fishService; 
	
	@Autowired
	private FishUserService fishUserService; 
	
	//redirects from / to the login location
	@GetMapping("/")
	public String index() {
		return "redirect:/home"; 
	}
	
	//main login/register route
	@GetMapping("/home")
	public String Home(Model model) {
		model.addAttribute("newUser", new User());
		model.addAttribute("newLogin", new LoginUser());
		return "index.jsp"; 
	}
	
	//register route
	@PostMapping("/register")
	public String register(@Valid @ModelAttribute("newUser") User newUser,
			BindingResult result, Model model, HttpSession session) {
		
		userService.register(newUser, result);
		
		if(result.hasErrors()) {
			model.addAttribute("newLogin", new LoginUser());
			return "index.jsp";
		}
		
		session.setAttribute("userId", newUser.getId());
		
		return "redirect:/dashboard";
	}
	
	//login route if fails goes back to main page if not redirects to dash
	@PostMapping("/login")
	public String login(@Valid @ModelAttribute("newLogin") LoginUser newLogin,
			BindingResult result, Model model, HttpSession session) {
		
		User user = userService.login(newLogin, result);
		
		if(result.hasErrors()) {
			model.addAttribute("newUser", new User());
			return "index.jsp";
		}
		
		session.setAttribute("userId", user.getId());
		
		return "redirect:/dashboard"; 
	
	}
	
	//checks if user is logged in then loads dash board
	@GetMapping("/dashboard")
	public String welcome(ModelMap map, HttpSession session) {
		
		Long userId = (Long) session.getAttribute("userId");
		
		if(userId == null) {
			return "redirect:/";
		}
		
		User user = userService.findById(userId); 
		
		map.addAttribute("teams", fishService.allFish());
		map.addAttribute("user",user);	
		
		return "dashboard.jsp";
	}
	
	//equals userID stores in session to null
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.setAttribute("userId", null);
		return "redirect:/"; 
	}
	
	@GetMapping("/fishs/new/{fish}")
	public String newFish(@PathVariable("fish") Long fish,@ModelAttribute("fishies") FishUser fishUser, HttpSession session, Model model) {
	Long userId = (Long) session.getAttribute("userId");
		
		if(userId == null) {
			return "redirect:/"; 
		}

		User user = userService.findById(userId); 
		model.addAttribute("user",user);
		model.addAttribute("fishId", fish);
		return "newFish.jsp"; 
	}
	
	@PostMapping("/fishs/new")
	public String createNewFish(@Valid @ModelAttribute("fishies")FishUser fishUser, BindingResult result) {
			
		if(result.hasErrors()) {
			return "newFish.jsp";
		}else {
			fishUserService.createFishUser(fishUser);
			return "redirect:/dashboard"; 
		}
	}
	
	@GetMapping("/fishs/{id}")
	public String viewTeam(@PathVariable("id") Long id, Model model, HttpSession session) {
		Long userId = (Long) session.getAttribute("userId");
		
		if(userId == null) {
			return "redirect:/"; 
		}
		
	
		User foundUser = userService.findById(userId);
		model.addAttribute("loggedUser", foundUser);
		model.addAttribute("fish", fishUserService.allFishUsers());
		return "view.jsp"; 
	}
	
	@GetMapping("/fishs/edit/{id}")
	public String edit(@PathVariable("id") Long id, Model model, HttpSession session) {
		Long userId = (Long) session.getAttribute("userId");
		
		if(userId == null) {
			return "redirect:/"; 
		}

		model.addAttribute("fish", fishUserService.findFishUsers(id));
		return "editFish.jsp"; 
	}
	
	@PostMapping("/fishs/edit/{id}")
	public String update(@PathVariable("id") Long id, @Valid @ModelAttribute("fish") FishUser fish, BindingResult result) {
		if(result.hasErrors()) {
			return "editFish.jsp";
		}else {
			fishUserService.updateFishUser(fish);
			return "redirect:/dashboard"; 
		}
	}
	
	@RequestMapping("/fishs/delete/{id}")
	public String delete(@PathVariable("id") Long id) {
		fishUserService.deletefishUser(fishUserService.findFishUsers(id));
		return "redirect:/dashboard"; 
	}
	
	@GetMapping("/fishs/desc/{id}")
	public String viewDesc(@PathVariable("id") Long id, Model model, HttpSession session) {
Long userId = (Long) session.getAttribute("userId");
		
		if(userId == null) {
			return "redirect:/"; 
		}
		
	
		User foundUser = userService.findById(userId);
		model.addAttribute("loggedUser", foundUser);
		model.addAttribute("fish", fishUserService.findFishUsers(id));
		return "viewDesc.jsp"; 
	}
	
}
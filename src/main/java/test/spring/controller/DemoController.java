package test.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import test.spring.Query;
import test.spring.data.User;

 
// Annotation
@Controller
 
// Class
public class DemoController 
{	
	String text = "";
	User user;
	
	@Autowired
	Query query;
	
	@RequestMapping("/")
	@ResponseBody
	public ModelAndView index(ModelMap model)
	{
        //model.addAttribute("attribute", "forwardWithForwardPrefix");
        return new ModelAndView("forward:/login");
	}
	
	@GetMapping("/login")//default page
    public String login(@RequestParam(name="fail", required=false) String fail, Model model)
    {
		model.addAttribute("fail", fail);
    	return "login";
    }
	@PostMapping("/trylogin")
	@ResponseBody
	public ModelAndView tryLogin(@RequestBody(required=true) String post, Model model)
	{
		String u_p[] = post.split("&");
		String u_[] = u_p[0].split("=");
		String p_[] = u_p[1].split("=");
		try
		{
			user = query.getUser(u_[1], p_[1]);
		}catch(org.springframework.dao.EmptyResultDataAccessException e)
		{
			model.addAttribute("attribute", "redirectWithRedirectPrefix");
	        return new ModelAndView("redirect://localhost:8080/login?fail=wrong%20username%20or%20password");
		}
		return new ModelAndView("redirect:/home");
	}
	
	@RequestMapping("/register")
    public String register()
    {
        return "register";
    }
	@PostMapping("/tryregister")
	@ResponseBody
	public ModelAndView tryRegister(@RequestBody(required=true) String post, Model model)
	{
		String u_p[] = post.split("&");
		String u_[] = u_p[0].split("=");
		String p_[] = u_p[1].split("=");
		try
		{
			query.newUser(u_[1], p_[1]);
			user = query.getUser(u_[1], p_[1]);
		}catch(org.springframework.dao.EmptyResultDataAccessException e)
		{
			model.addAttribute("attribute", "redirectWithRedirectPrefix");
	        return new ModelAndView("redirect://localhost:8080/login?fail=fail%20to%20login");
		}
		return new ModelAndView("redirect:/home");
	}

	@RequestMapping("/home")
    public ModelAndView home(Model model) 
    {					 
		model.addAttribute("username", user.getUsername());
		
		model.addAttribute("id", user.getID());
		model.addAttribute("realname", user.getRealname());
		model.addAttribute("address", user.getAddress());
		model.addAttribute("carlicensestatus", user.getcarlicenseStatus());
		model.addAttribute("motorcyclelicensestatus", user.getmotorcyclelicensestatus());
		model.addAttribute("employment", user.getEmployment());

        return new ModelAndView();
    }
	
	@RequestMapping("/update")
	public String update()
	{
		
		return "update";
		
	}
	
	@GetMapping("/processupdate")
	@ResponseBody
    public ModelAndView note(@RequestParam(name="realname") String realname,
    				   @RequestParam(name="address") String address,
    				   @RequestParam(name="carlicensestatus", defaultValue= "off") boolean carlicensestatus,
    				   @RequestParam(name="motorcyclelicensestatus", defaultValue= "off") boolean motorcyclelicensestatus,
    				   @RequestParam(name="employment") String employment,
    				   ModelMap model)
    {					 //user homescreen, contain user's notes marked by label on screen (id hidden)
    	query.updateUserData(realname, address, carlicensestatus, motorcyclelicensestatus, employment, user.getUsername());
    	user.setAll(realname, address, carlicensestatus, motorcyclelicensestatus, employment);
    	//model.addAttribute("attribute", "redirectWithRedirectPrefix");
        return new ModelAndView("redirect:/home", model);
    }
	
	@RequestMapping("/logout")
	@ResponseBody
	public ModelAndView logout(Model model)
	{
		user = null;
		return new ModelAndView("redirect:/login");
		
	}
	
	@RequestMapping("/deleteuser")
	@ResponseBody
	public ModelAndView deleteUser(Model model)
	{
		query.deleteUser(user.getUsername());
		return new ModelAndView("redirect:/login");
		
	}
}

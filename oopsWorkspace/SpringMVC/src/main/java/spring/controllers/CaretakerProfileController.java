package spring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import spring.model.Request;
import spring.service.CaretakerProfileService;

@Controller
public class CaretakerProfileController {
	
	private CaretakerProfileService CaretakerProfileService;
	
	@Autowired(required=true)
	//@Qualifier(value="CaretakerProfileService")
	public void setCaretakerProfileService(CaretakerProfileService ps){
		System.out.println("In caretaker profile");
		this.CaretakerProfileService = ps;
	}
	
	@RequestMapping(value = "/user/viewProfile")
	public String createRequest(@ModelAttribute("request") Request r, Model model) {
		System.out.println("Here it is......");
		
	
	   // return "redirect:/request";
		return "profile";
	}
	//@PathVariable("Name") String name,
	/*@RequestMapping(value = "/user/pet", method = RequestMethod.GET)
	public String listCaretakerProfiles(Model model) {
		System.out.println("In listCaretakerProfiles");
		model.addAttribute("CaretakerProfile", new CaretakerProfile());
	//	model.addAttribute("listCaretakerProfiles", this.CaretakerProfileService.listCaretakerProfiles());
		return "pet";
	}*/
	
	//For add and update CaretakerProfile both
	/*@RequestMapping(value= "/CaretakerProfile/add", method = RequestMethod.POST)
	public String addCaretakerProfile(@ModelAttribute("CaretakerProfile") CaretakerProfile p)
	{
		
		boolean error=false;
		
		//if(p.getId() == 0){
			//new CaretakerProfile, add it
			error=this.CaretakerProfileService.addCaretakerProfile(p);
			
			if(error)
			{
				return "invalid-CaretakerProfilename";
			}
			else
			{
				return "register-success";
			}
		//}else{
			//existing CaretakerProfile, call update
			//this.CaretakerProfileService.updateCaretakerProfile(p);
		//}
		
	}
	
	@RequestMapping("/remove/{CaretakerProfileId}")
    public String removeCaretakerProfile(@PathVariable("CaretakerProfileId") int id){
		
        this.CaretakerProfileService.removeCaretakerProfile(id);
        return "redirect:/CaretakerProfiles";
    }
 
    @RequestMapping("/edit/{CaretakerProfileId}")
    public String editCaretakerProfile(@PathVariable("CaretakerProfileId") int id, Model model){
        model.addAttribute("CaretakerProfile", this.CaretakerProfileService.getCaretakerProfileById(id));
        model.addAttribute("listCaretakerProfiles", this.CaretakerProfileService.listCaretakerProfiles());
        return "CaretakerProfile";
    }
    
  
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {
       return "redirect:CaretakerProfiles";
    }
    
    @RequestMapping(value= "/CaretakerProfile/login", method = RequestMethod.POST)
	public String loginCaretakerProfile(Model model, @ModelAttribute("CaretakerProfile") CaretakerProfile p){
    	
   // 	System.out.println("in login");
    	boolean retVal=this.CaretakerProfileService.validateCaretakerProfile(p);
		int CaretakerProfileId=0;
    	if(!retVal)
    	{
    	//	System.out.println("Doesn't exist");
    		return "redirect:/invalid-login";
    	}
    	else
    	{
    	//	System.out.println("Exists");
    		System.out.println("CaretakerProfile Type is" + p.getCaretakerProfileType());
    		CaretakerProfileId=p.getCaretakerProfileId();
    		model.addAttribute("CaretakerProfileId",CaretakerProfileId);
    		model.addAttribute("CaretakerProfilename",p.getCaretakerProfilename());
    		model.addAttribute("firstName",p.getFirstName());

    		if(p.getCaretakerProfileType()=="Admin")
    		{
    			return "adminDashboard";
    		}
    		else if((p.getCaretakerProfileType()).equals("caretaker"))
    		{
    			model.addAttribute("CaretakerProfileCount",this.CaretakerProfileService.getCaretakerProfileCount(CaretakerProfileId));
    			model.addAttribute("contactInfo",this.CaretakerProfileService.isContactInfoSet(CaretakerProfileId));
    			return "caretakerDashboard";
    		}
    		else 
    		{
    			
    			return "caretakerDashboard";
    		}
    	}
		
	}
    
    @RequestMapping(value= "/CaretakerProfile/signup", method = RequestMethod.POST)
  	public String signupCaretakerProfile(Model model, @ModelAttribute("CaretakerProfile") CaretakerProfile p){
      	
     // 	System.out.println("in login");
    	if(p.getCaretakerProfileType()=="")
    	{
    		model.addAttribute("invalidInput","Error: CaretakerProfile role cannot be empty");
    		return "signup";
    	}
    	if(p.getCaretakerProfileName()=="")
    	{
    		model.addAttribute("invalidInput","Error: CaretakerProfilename cannot be empty");
    		return "signup";
    	}
      	boolean retVal=this.CaretakerProfileService.addCaretakerProfile(p);
  		
      	if(retVal)
      	{
      		model.addAttribute("invalidInput","Error: CaretakerProfilename exists");
      		return "signup";
      	}
      	else
      	{
      	//	System.out.println("Exists");
      		return "register-success";
      	}
  		
  	}
      
    
    @RequestMapping(value = "/invalid-login", method = RequestMethod.GET)
    public String dispLoginError() {
       return "loginError";
    }*/
}
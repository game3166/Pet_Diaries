package spring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import spring.model.Request;
import spring.model.User;

import spring.service.RequestService;

@Controller
public class RequestController {
	
	private RequestService requestService;
	
	@Autowired(required=true)
	@Qualifier(value="requestService")
	public void setRequestService(RequestService rs){
		this.requestService = rs;
	}
	
	@RequestMapping(value = "/request", method = RequestMethod.GET)
	public String listRequest(Model model) {
		model.addAttribute("request", new Request());
		model.addAttribute("listRequest", this.requestService.listRequest());
		return "request";
	}
	
	//For add and update person both
	@RequestMapping(value= "/request/add", method = RequestMethod.POST)
	public String publishRequest(@ModelAttribute("request") Request r){
		
		if(r.getRequestId() == 0){
			//new person, add it
			this.requestService.publishRequest(r);
		}else{
			//existing person, call update
			this.requestService.editRequest(r);
		}
		
		return "redirect:/request";
				
	}
	
	@RequestMapping("delete/{id}")
    public String deleteOldRequest(@PathVariable("id") int id){
		
        this.requestService.deleteOldRequest(id);
        return "redirect:/request";
    }
	
    @RequestMapping("/update/{id}")
    public String editRequest(@PathVariable("id") int id, Model model){
        model.addAttribute("request", this.requestService.getRequestById(id));
        model.addAttribute("listRequest", this.requestService.listRequest());
        return "request";
    }
    
	@RequestMapping(value = "/validate/{id}", method = RequestMethod.GET)
    public String validateRequest(@PathVariable("id") int id,@ModelAttribute("request") Request r,
    		@ModelAttribute("user") User p,
    		Model model){
	
		r = this.requestService.getRequestById(id);			
		//model.addAttribute("ownerId", r.getOwnerId());
        //model.addAttribute("petType", r.getPetType());
        //model.addAttribute("petBreed", r.getPetBreed());
        //model.addAttribute("fromDate", r.getFromDate());
        //model.addAttribute("toDate", r.getToDate());
        r.setValidRequest(true);
        model.addAttribute("listRequest", this.publishRequest(r));
        model.addAttribute("listRequest", this.requestService.listRequest());
	    return "request";
    }


}
package pl.dmcs.mww.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import pl.dmcs.mww.model.AppUser;

@Controller
public class AppUserController {

	@RequestMapping(value = "/appUsers")
	public ModelAndView showAppUsers() {
		return new ModelAndView("appUser", "appUserJSP", new AppUser());
	}

	@RequestMapping(value = "addAppUser", method = RequestMethod.POST)
	public String addAppUser(@ModelAttribute("appUserJSP") AppUser appUser) {
		System.out.format("First Name: %s, Last name: %s, Tel.: %s, email: %s \n",
				appUser.getFirstName(), appUser.getLastName(),
				appUser.getTelephone(), appUser.getEmail());

		return "redirect:appUsers.html";
	}
}
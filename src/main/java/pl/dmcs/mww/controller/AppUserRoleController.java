package pl.dmcs.mww.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.dmcs.mww.model.AppUserRole;
import pl.dmcs.mww.service.AppUserRoleService;

@Controller
public class AppUserRoleController {

	@Autowired
	private AppUserRoleService appUserRoleService;

	@RequestMapping(value="/appUserRole")
	public String showUserRole(Model model) {
		model.addAttribute("appUserRole", new AppUserRole());
		return "appUserRole";
	}

	@RequestMapping(value = "/addAppUserRole", method = RequestMethod.POST)
	public String addUserRole(@ModelAttribute("appUserRole") AppUserRole appUserRole, BindingResult result) {
		appUserRoleService.addAppUserRole(appUserRole);
		return "redirect:appUsers.html";
	}
}

package pl.dmcs.mww.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import pl.dmcs.mww.model.AppUser;
import pl.dmcs.mww.model.AppUserRole;
import pl.dmcs.mww.service.AddressService;
import pl.dmcs.mww.service.AppUserRoleService;
import pl.dmcs.mww.service.AppUserService;
import pl.dmcs.mww.validator.AppUserValidator;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Controller
public class AppUserController {

	@Autowired
	AppUserService appUserService;
	@Autowired
	AddressService addressService;
	@Autowired
	AppUserRoleService appUserRoleService;

	AppUserValidator appUserValidator = new AppUserValidator();

	@RequestMapping(value = "/appUsers")
	public String showAppUsers(Model model, HttpServletRequest request) {

		int appUserId = ServletRequestUtils.getIntParameter(request, "appUserId" , -1);

		if (appUserId > 0) {
			AppUser appUser = appUserService.getAppUser(appUserId);
			appUser.setPassword("");
			appUser.setAddress(addressService.getAddress(appUserService.getAppUser(appUserId).getAddress().getId()));
			model.addAttribute("selectedAddress", appUserService.getAppUser(appUserId).getAddress().getId());
			model.addAttribute("appUser", appUserService.getAppUser(appUserId));
		}
		else {
			model.addAttribute("appUser", new AppUser());
		}
		model.addAttribute("appUserList", appUserService.listAppUser());
		model.addAttribute("addressList", addressService.listAddresses());
		model.addAttribute("appUserRoleList", appUserRoleService.listAppUserRole());

		return "appUser";
	}

	@RequestMapping(value = "/addAppUser", method = RequestMethod.POST)
	public String addAppUser(@Valid @ModelAttribute("appUser") AppUser appUser, BindingResult result, Model model) {

		System.out.println("First Name: " + appUser.getFirstName() +
				" Last Name: " + appUser.getLastName() + " Tel.: " +
				appUser.getTelephone() + " Email: " + appUser.getEmail());

		appUserValidator.validate(appUser, result);

		if(result.getErrorCount() == 0) {
			if (appUser.getId() == 0)
				appUserService.addAppUser(appUser);
			else
				appUserService.editAppUser(appUser);
			return "redirect:appUsers.html";
		}
		model.addAttribute("appUserList", appUserService.listAppUser());
		return "appUser";
	}

	@RequestMapping("/delete/{appUserId}")
	public String deleteUser(@PathVariable("appUserId") Long appUserId) {
		appUserService.removeAppUser(appUserId);
		return "redirect:/appUsers.html";
	}
}
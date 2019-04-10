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
import pl.dmcs.mww.model.Address;
import pl.dmcs.mww.model.Address;
import pl.dmcs.mww.service.AddressService;
import pl.dmcs.mww.service.AddressService;
import pl.dmcs.mww.validator.AddressValidator;

import javax.servlet.http.HttpServletRequest;

@Controller
public class AddressController {

	@Autowired
	AddressService addressService;
	AddressValidator addressValidator = new AddressValidator();

	@RequestMapping(value = "/address")
	public String showAddresses(Model model, HttpServletRequest request) {

		int addressId = ServletRequestUtils.getIntParameter(request, "addressId", -1);

		if (addressId > 0)
			model.addAttribute("address", addressService.getAddress(addressId));
		else
			model.addAttribute("address", new Address());

		model.addAttribute("addressList", addressService.listAddresses());

		return "address";
	}

	@RequestMapping(value = "addAddress", method = RequestMethod.POST)
	public String addAddress(@ModelAttribute("address") Address address, BindingResult result, Model model) {

		System.out.println("City:" + address.getCity() +
				" Country: " + address.getCountry() + " Street.: " +
				address.getStreet() + " House No.: " + address.getHouseNo());

		addressValidator.validate(address, result);

		if(result.getErrorCount() == 0) {
			if (address.getId() == 0)
				addressService.addAddress(address);
			else
				addressService.editAddress(address);
			return "redirect:address.html";
		}
		model.addAttribute("addressList", addressService.listAddresses());
		return "address";
	}

	@RequestMapping("address/delete/{addressId}")
	public String deleteUser(@PathVariable("addressId") Long addressId) {
		addressService.removeAddress(addressId);
		return "redirect:/address.html";
	}
}

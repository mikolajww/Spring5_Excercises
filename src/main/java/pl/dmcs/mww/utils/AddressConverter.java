package pl.dmcs.mww.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import pl.dmcs.mww.model.Address;
import pl.dmcs.mww.service.AddressService;

public class AddressConverter implements Converter<String, Address> {

	@Autowired
	AddressService addressService;

	@Override
	public Address convert(String source) {
		return addressService.getAddress(Integer.parseInt(source));
	}
}

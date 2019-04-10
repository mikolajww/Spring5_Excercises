package pl.dmcs.mww.service;

import pl.dmcs.mww.model.Address;

import java.util.List;

public interface AddressService {
	void addAddress(Address address);
	void editAddress(Address address);
	List<Address> listAddresses();
	void removeAddress(long id);
	Address getAddress(long id);
}

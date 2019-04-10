package pl.dmcs.mww.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.dmcs.mww.dao.AddressRepository;
import pl.dmcs.mww.model.Address;

import java.util.List;

@Service
public class AddressServiceImpl implements AddressService {
	@Autowired
	AddressRepository addressRepository;

	@Override
	public void addAddress(Address address) {
		addressRepository.save(address);
	}

	@Override
	public void editAddress(Address address) {
		addressRepository.save(address);
	}

	@Override
	public List<Address> listAddresses() {
		return addressRepository.findAll();
	}

	@Override
	public void removeAddress(long id) {
		addressRepository.delete(id);
	}

	@Override
	public Address getAddress(long id) {
		return addressRepository.findById(id);
	}
}

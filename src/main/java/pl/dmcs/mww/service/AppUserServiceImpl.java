package pl.dmcs.mww.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.dmcs.mww.dao.AppUserRepository;
import pl.dmcs.mww.model.AppUser;

import java.util.List;

@Service
public class AppUserServiceImpl implements AppUserService{

	@Autowired
	AppUserRepository appUserRepository;

	@Transactional
	public void addAppUser(AppUser appUser) {
		appUserRepository.save(appUser);
	}

	@Transactional
	public void editAppUser(AppUser appUser) {
		appUserRepository.save(appUser);
	}

	@Transactional
	public List<AppUser> listAppUser() {
		return appUserRepository.findAll();
	}

	@Transactional
	public void removeAppUser(long id) {
		appUserRepository.delete(id);
	}

	@Transactional
	public AppUser getAppUser(long id) {
		return appUserRepository.findById(id);
	}
}

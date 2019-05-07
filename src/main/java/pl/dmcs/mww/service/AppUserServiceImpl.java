package pl.dmcs.mww.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.dmcs.mww.dao.AppUserRepository;
import pl.dmcs.mww.dao.AppUserRoleRepository;
import pl.dmcs.mww.model.AppUser;

import java.util.List;

@Service
public class AppUserServiceImpl implements AppUserService{
	@Autowired
	AppUserRepository appUserRepository;

	@Autowired
	AppUserRoleRepository appUserRoleRepository;

	@Transactional
	public void addAppUser(AppUser appUser) {
		appUser.getAppUserRole().add(appUserRoleRepository.findByRole("ROLE_USER"));
		appUser.setPassword(hashPassword(appUser.getPassword()));
		appUserRepository.save(appUser);
	}

	@Transactional
	public void editAppUser(AppUser appUser) {
		appUser.getAppUserRole().add(appUserRoleRepository.findByRole("ROLE_USER"));
		appUser.setPassword(hashPassword(appUser.getPassword()));
		appUserRepository.save(appUser);
	}

	private String hashPassword(String password)
	{
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		return passwordEncoder.encode(password);
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
	@Transactional
	public AppUser findByLogin(String login) {
		return appUserRepository.findByLogin(login);
	}

}

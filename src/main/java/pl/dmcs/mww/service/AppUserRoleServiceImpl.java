package pl.dmcs.mww.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.dmcs.mww.dao.AppUserRoleRepository;
import pl.dmcs.mww.model.AppUserRole;

import java.util.List;

@Service
public class AppUserRoleServiceImpl implements AppUserRoleService {

	@Autowired
	AppUserRoleRepository appUserRoleRepository;

	@Override
	public void addAppUserRole(AppUserRole appUserRole) {
		appUserRoleRepository.save(appUserRole);
	}

	@Override
	public List<AppUserRole> listAppUserRole() {
		return appUserRoleRepository.findAll();
	}

	@Override
	public AppUserRole getAppUserRole(long id) {
		return appUserRoleRepository.getOne(id);
	}
}

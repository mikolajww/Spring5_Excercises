package pl.dmcs.mww.service;

import pl.dmcs.mww.model.AppUserRole;

import java.util.List;

public interface AppUserRoleService {

	void addAppUserRole(AppUserRole appUserRole);
	List<AppUserRole> listAppUserRole();
	AppUserRole getAppUserRole(long id);
}

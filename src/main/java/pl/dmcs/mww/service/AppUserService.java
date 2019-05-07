package pl.dmcs.mww.service;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import pl.dmcs.mww.model.AppUser;

import java.util.List;

public interface AppUserService {
	@Secured("ROLE_ADMIN")
	public void addAppUser(AppUser user);

	@PreAuthorize("hasRole('ROLE_ADMIN') OR (#appUser.login == principal.username)")
	public void editAppUser(AppUser user);

	public List<AppUser> listAppUser();

	@Secured("ROLE_ADMIN")
	public void removeAppUser (long id);
	public AppUser getAppUser(long id);
	public AppUser findByLogin(String login);
}

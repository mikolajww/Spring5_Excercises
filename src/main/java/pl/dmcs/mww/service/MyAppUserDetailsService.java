package pl.dmcs.mww.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.dmcs.mww.model.AppUser;
import pl.dmcs.mww.model.AppUserRole;

@Service("myAppUserDetailsService")
public class MyAppUserDetailsService implements UserDetailsService {
 
	@Autowired
	private AppUserService appUserService;

	@Transactional(readOnly=true)
	@Override
	public UserDetails loadUserByUsername(final String login) throws UsernameNotFoundException {
 
		AppUser appUser = appUserService.findByLogin(login);
		List<GrantedAuthority> authorities = buildUserAuthority(appUser.getAppUserRole());
		return buildUserForAuthentication(appUser, authorities);
	}
 
	// Converts AppUser user to org.springframework.security.core.userdetails.User
	private User buildUserForAuthentication(AppUser appUser, List<GrantedAuthority> authorities) {

		return new User(appUser.getLogin(), appUser.getPassword(), appUser.isEnabled(),
				true, true, true, authorities);
	}
 
	private List<GrantedAuthority> buildUserAuthority(Set<AppUserRole> appUserRoles) {
 
		Set<GrantedAuthority> setAuths = new HashSet<GrantedAuthority>();
		// Build user's authorities
		for (AppUserRole appUserRole : appUserRoles) {
			setAuths.add(new SimpleGrantedAuthority(appUserRole.getRole()));
		}
		List<GrantedAuthority> result = new ArrayList<GrantedAuthority>(setAuths);
		return result;
	}
}


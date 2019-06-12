package pl.dmcs.mww.utils;

import java.util.HashSet;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import pl.dmcs.mww.model.AppUserRole;
import pl.dmcs.mww.service.AppUserRoleService;

public class AppUserRoleConverter implements Converter<String, Set<AppUserRole>> {

	@Autowired
	AppUserRoleService appUserRoleService;
	
	@Override
	public Set<AppUserRole> convert(String source) {
		
		Set<AppUserRole> userRoleList = new HashSet<AppUserRole>(0);
		
			userRoleList.add(appUserRoleService.getAppUserRole(Integer.parseInt(source)));
		
		return userRoleList;
	}
}



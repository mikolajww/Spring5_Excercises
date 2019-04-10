package pl.dmcs.mww.dao;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.dmcs.mww.model.AppUser;

@Transactional
@Repository
public interface AppUserRepository extends JpaRepository<AppUser, Long> {

	List<AppUser> findByLastName(String lastName);
	AppUser findById(long id);

}


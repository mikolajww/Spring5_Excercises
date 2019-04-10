package pl.dmcs.mww.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.dmcs.mww.model.Address;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {
	List<Address> findByCity(String city);
	Address findById(long id);

}

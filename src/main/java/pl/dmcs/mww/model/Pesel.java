package pl.dmcs.mww.model;

import javax.persistence.*;

@Entity
public class Pesel {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	long id;

	private String pesel;

	@OneToOne(mappedBy = "pesel")
	private AppUser appUser;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getPesel() {
		return pesel;
	}

	public void setPesel(String pesel) {
		this.pesel = pesel;
	}

	public AppUser getAppUser() {
		return appUser;
	}

	public void setAppUser(AppUser appUser) {
		this.appUser = appUser;
	}
}

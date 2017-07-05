package br.unb.fga.server.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import br.unb.fga.das.model.User;

@Entity
public class Gun extends User {

	@Id
	@GeneratedValue
	private Long id;
	private int magazineCapacity;
	private String caliber;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getMagazineCapacity() {
		return magazineCapacity;
	}

	public void setMagazineCapacity(int magazineCapacity) {
		this.magazineCapacity = magazineCapacity;
	}

	public String getCaliber() {
		return caliber;
	}

	public void setCaliber(String caliber) {
		this.caliber = caliber;
	}	
}

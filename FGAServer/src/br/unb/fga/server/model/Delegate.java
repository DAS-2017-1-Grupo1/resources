package br.unb.fga.server.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import br.unb.fga.das.model.User;

@Entity
public class Delegate extends User {

	@Id
	@GeneratedValue
	private long Id;
	private String department;

	public long getId() {
		return Id;
	}

	public void setId(long id) {
		Id = id;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}
	
	public String toString(){
		return "\nID: "+Id+"\nNome:"+getName()+"\nDelegacia: "+department+"\nNúmero do distintivo:"+getRegistration();
	}
}

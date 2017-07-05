package br.unb.fga.das.model;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class Allocation {
	public abstract void setRegistration(String registration);
	public abstract void setPatrimonyCode(Long patrimonyCode);
}

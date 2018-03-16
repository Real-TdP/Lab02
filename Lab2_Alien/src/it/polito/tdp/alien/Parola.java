package it.polito.tdp.alien;
import java.util.*;

public class Parola {
	
	private String aliena;
	private List<String> ita =new LinkedList<String>();
	
	public Parola(String aliena, String ita) {
		this.ita.add(ita);
		this.aliena = aliena;
	}

	public Collection<String> getIta() {
		return ita;
	}

	public void addIta(String ita) {
		this.ita.add(ita);
	}

	public String getAliena() {
		return aliena;
	}

	public void setAliena(String aliena) {
		this.aliena = aliena;
	}
	
	
	
	
	

}

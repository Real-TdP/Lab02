package it.polito.tdp.alien;

import java.util.*;

public class Dictionary {
	List<Parola> dict = new LinkedList<Parola>();

	public Dictionary() {
	}
	
	
	
	public boolean addWord(String aliena,String ita){
		if(!checkWord(aliena, ita))
			return false;
		for(Parola p:dict)
			if(p.getAliena().equals(aliena)){	
				p.addIta(ita);
				
				return true;
			}

		Parola p = new Parola(aliena,ita);
		dict.add(p);
		return true;
	}
	
	public Collection<String> searchWord(String aliena){
		for(Parola p:dict){
			if(p.getAliena().equals(aliena)){			
				return p.getIta();
			}
				
		}
		return null;
	}
	
	
	public boolean checkWord(String aliena,String ita){
		aliena.toLowerCase();
		ita.toLowerCase();
		if(aliena.isEmpty()||ita.isEmpty())
			return false;
		
		
		
		
		return true;
	}
	
	
	
	
	

}

package it.polito.tdp.alien;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Dictionary {
	List<Parola> dict = new LinkedList<Parola>();

	public Dictionary() {
	}
	
	
	
	public boolean addWord(String aliena,String ita){
		if(!(checkWord(aliena)&&checkWord(ita)))
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
	
	public Parola searchWord(String aliena){
		for(Parola p:dict)
			if(p.getAliena().equals(aliena))		
				return p;
		return null;
	}
	public List<Parola> searchWord(String aliena1,String aliena2){
		List<Parola> x = new LinkedList<Parola>();
		for(Parola p:dict) {
			if(p.getAliena().matches(aliena1+"."+aliena2))
					x.add(p);
		}
		return x;
	}
	
	
	public boolean checkWord(String word){
		if(word.isEmpty())
			return false;
		Matcher m = Pattern.compile("^[a-zA-Z]+$").matcher(word);
		if(!m.find())
			return false;
		
		
		return true;
	}
	
	
	
	
	

}

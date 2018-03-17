package it.polito.tdp.alien;

import java.util.*;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class AlienController {
	Dictionary d = new Dictionary();
	
	
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtTrans;

    @FXML
    private Button btnTranslate;

    @FXML
    private TextArea txtLog;

    @FXML
    private Button btnClear;

    @FXML
    void doClear(ActionEvent event) {
    	txtLog.clear();
    	txtTrans.clear();

    }

    @FXML
    void doTranslate(ActionEvent event) {
    	String tmp = txtTrans.getText();
    	String txt[]= tmp.split(" ");
    	if(txt.length==1){
    		List<String> x = new LinkedList<String>();
    		List<Parola> y = new LinkedList<Parola>();
    		if(txt[0].matches("([a-zA-Z]+||^)\\?([a-zA-z]+||$)")) {
    			System.out.println(txt[0]);
    			String txxt[]=txt[0].split("\\?");
    			if(txxt.length==1)
    				y=d.searchWord(txxt[0], "");
    			else
    				y=d.searchWord(txxt[0], txxt[1]);
    		}
    		else {
    			if(!d.checkWord(txt[0])) {
        			txtLog.appendText("Errore nella sintassi, caratteri consentiti:  [a-z][A-Z]\nRiprova\n");
        			return;
        		}
    			y.add( d.searchWord(txt[0]));
    		}
    		
    		for(Parola p:y) {
    			x= p.getIta();
        		if(x==null)
        			txtLog.appendText("Nessuna parola trovata! \n");
        		else if(x.size()==1)
        			txtLog.appendText("La parola in lingua italiana è:  "+x.get(0)+"\n");
        		else if(x.size()>1){
        			String tx="Le parole in lingua italiana per \""+p.getAliena()+"\" sono:  \n";
        			for(String t:x)
        				tx+="- "+t+"\n";
        			txtLog.appendText(tx);
        		}
    		}
    			
    		txtTrans.clear();
    	}
    	else
    		if(d.addWord(txt[0], txt[1]))
    			txtLog.appendText("Traduzione aggiornata correttamente\n");
    		else
    			txtLog.appendText("Errore nella sintassi, caratteri consentiti:  [a-z][A-Z]\n");      	  
    	txtTrans.clear();   
    	
    }
  
    
    
    

    @FXML
    void initialize() {
        assert txtTrans != null : "fx:id=\"txtTrans\" was not injected: check your FXML file 'Alien.fxml'.";
        assert btnTranslate != null : "fx:id=\"btnTranslate\" was not injected: check your FXML file 'Alien.fxml'.";
        assert txtLog != null : "fx:id=\"txtLog\" was not injected: check your FXML file 'Alien.fxml'.";
        assert btnClear != null : "fx:id=\"btnClear\" was not injected: check your FXML file 'Alien.fxml'.";

    }
}

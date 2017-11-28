package com.huerta.bean;
import com.huerta.model.Elemento;
import java.io.Serializable;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.HashMap;

@ManagedBean(name="obj")
@SessionScoped
public class ViewManager implements Serializable{
  private String key;
  private String value;
  private String last;
  private boolean good;
  private List<Elemento> listClaves = new ArrayList<Elemento>();
  private Map<String,String> hash;
  private String probar="";
  
 public List<Elemento> getListClaves() {
    
    return listClaves;
}
public void setListClaves(List<Elemento> listClaves) {
	this.listClaves = listClaves;
}
public ViewManager() {
     good=false;
     hash = new HashMap<String, String>();
  }
  public String getLast() {
    return last;
  }
  public Map<String,String> getHash() {
    
    return hash;
  }
  public String getKey() {
    return key;
  }
public String getProbar() {
    return probar;
  }

  public void setKey(String key) {
    this.key = key;
  }
  public boolean isGood() {
    return good;
  }
  public String getValue() {
    return value;
  }

  public void setLast(String last) {
    this.last = last;
  }

  public void setValue(String value) {
    this.value = value;
  }
  
  public void add() {
	
	if (!hash.containsKey(this.key)) {
		hash.put(this.key, this.value);
		probar="¡ Añadido correctamente !";
	}else {
		probar="La clave esta introducida, porfavor introduzca otra clave.";
	}
  }
  
  public void show() {    
	if(!good){
		listClaves = new ArrayList<Elemento>();
   	 	for(Map.Entry<String,String> entry : hash.entrySet()) {
      		listClaves.add(new Elemento(entry.getKey(),entry.getValue()));
		this.good=true;
    		}
	}else{
		listClaves = new ArrayList<Elemento>();
		this.good=false;
	}
  }
  
  
}

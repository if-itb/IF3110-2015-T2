package org.tusiri.ws.token_validity;

public class TokenValidity {
	private boolean isValid;
	private int idUser;
	
	public boolean getIsValid(){
		return isValid;	
	}
	
	public void setIsValid(boolean isValid){
		this.isValid = isValid;
	}
	
	public int getIdUser(){
		return idUser;
	}
	
	public void setIdUser(int idUser){
		this.idUser = idUser;
	}
}

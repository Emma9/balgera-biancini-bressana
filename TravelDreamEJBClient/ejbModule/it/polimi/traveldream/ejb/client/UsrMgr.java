package it.polimi.traveldream.ejb.client;

import it.polimi.traveldream.entities.UserDTO;

import javax.ejb.Local;

@Local
public interface UsrMgr {

	public void save(UserDTO user);
    
    public void update(UserDTO user);
   
    public void unregister();
   
    public UserDTO getUserDTO();
    
    public String getPrincipalEmail();   
    

	
}

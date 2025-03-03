package it.polimi.traveldream.entities;



import java.io.Serializable;
import java.util.Date;
//import java.util.List;


import javax.persistence.*;




/**
 * Entity implementation class for Entity: DisponibilitaPerData
 *
 */
@Entity
@IdClass(DisponibilitaPerDataPK.class)
public class DisponibilitaPerData implements Serializable {

	@Id   
	private int codiceComponente;
	@Id
	@Temporal(TemporalType.DATE)
	private Date data;
	private int disponibilita;
	private static final long serialVersionUID = 1L;
	
	

	
	
	/*@ManyToMany(mappedBy="disponibilitaPerData")
	private List<Componente> componenti;*/
	
	
	/**
	 * 
	 */
	public DisponibilitaPerData() {
		super();
	}   
	  
	/**
	 * @return data
	 */
	public Date getData() {
		return this.data;
	}

	/**
	 * @param data
	 */
	public void setData(Date data) {
		this.data = data;
	}  
	
	/**
	 * @return disponibilita
	 */
	public int getDisponibilita() {
		return this.disponibilita;
	}

	/**
	 * @param disponibilita
	 */
	public void setDisponibilita(int disponibilita) {
		this.disponibilita = disponibilita;
	}

	/**
	 * @return the codiceComponente
	 */
	public int getCodiceComponente() {
		return codiceComponente;
	}

	/**
	 * @param codiceComponente the codiceComponente to set
	 */
	public void setCodiceComponente(int codiceComponente) {
		this.codiceComponente = codiceComponente;
	}

	
   
}

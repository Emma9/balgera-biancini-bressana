package it.polimi.traveldream.ejb.client;

import it.polimi.traveldream.entities.ComponenteDTO;


import it.polimi.traveldream.entities.DisponibilitaPerDataDTO;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.Remote;

@Remote
public interface ComponenteBeanRemote {

	
	/**
	 * @param tipologia
	 * @param luogo
	 * @param descrizione
	 * @param costo
	 * @param dataInizioValidita
	 * @param dataFineValidita
	 * @param disponibilitaDaSettare
	 * @return codiceComponente
	 */
	public int createComponente(String tipologia,String luogo, String descrizione,
			int costo, Date dataInizioValidita, Date dataFineValidita,
			int disponibilitaDaSettare);
	
	/**@param codiceComponente*/
	public void removeComponente(int codiceComponente);

	/**
	 * @param codiceComponente
	 * @param tipologia
	 * @param luogo
	 * @param descrizione
	 * @param costo
	 * @param dataInizioValidita
	 * @param dataFineValidita
	 * @param disponibilitaDaSettare
	 */
	public void updateComponente(int codiceComponente, String tipologia, String luogo,
			String descrizione, int costo, Date dataInizioValidita, Date dataFineValidita,
			int disponibilitaDaSettare) ;
	
	/**@param codiceComponente
	 * @return ComponenteDTO*/
	public ComponenteDTO findByCodiceComponente(int codiceComponente);
	
	/**
	 * @param luogo
	 * @return ArrayList<ComponenteDTO>
	 */
	public ArrayList<ComponenteDTO> findByLuogo(String luogo);
	
	
	/**
	 * @param termine
	 * @return ArrayList<ComponenteDTO>
	 */
	public ArrayList<ComponenteDTO> findByTermine(String termine);
	
	/**@return ArrayList<codiceComponente>*/
	public ArrayList<ComponenteDTO> findAll();
	
	/**@param dataPartenza
	 * @param dataRitorno
	 * @param componenteDTO
	 * @return true if componente is valid, otherwise false
	 */
	public boolean verificaValiditaComponente (Date dataPartenza, Date dataRitorno, ComponenteDTO componenteDTO);
	
	/**@param componente
	 * @param data
	 * @return int
	 */
	public int disponibilitaInData(ComponenteDTO componente, Date data);
	
	

	/**
	 * @param disponibilita
	 * @param data
	 * @param componente
	 * @return true if componente is available, otherwise false
	 */
	public boolean verificaDisponibilitaComponenteInUnaData(
			int disponibilitaRichiesta, Date data, ComponenteDTO componente);
	
	/**@param disponibilitaRichiesta
	 * @param dataPartenza
	 * @param dataRitorno
	 * @param componente
	 * @return true if componente is available in the requested period, otherwise false
	 */
	public boolean verificaDisponibilitaComponenteInPeriodo(
			int disponibilitaRichiesta, Date dataPartenza, Date dataRitorno,
			ComponenteDTO componente);
	
	
	/**
	 * @param codiceComponente
	 * @return true if codiceComponente is present in the DB, otherwise false
	 */
	public boolean verificaPresenzaComponente(int codiceComponente) ; 
	
	/**@param tipologia
	 * @return true if tipologia is valid, otherwise false
	 */
	public boolean verificaTipologia(String tipologia);
	
	public List<DisponibilitaPerDataDTO> creaListaDisponibilitaPerData(int codiceComponente, Date dataInizioValidita, Date dataFineValidita,int disponibilitaDaSettare);
	
}
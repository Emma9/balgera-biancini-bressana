package it.polimi.traveldream.web.beans;

import it.polimi.traveldream.ejb.client.PacchettoPersonalizzatoBeanRemote;
import it.polimi.traveldream.ejb.client.UserBeanRemote;
import it.polimi.traveldream.ejb.client.UsrMgr;
import it.polimi.traveldream.entities.PacchettoDTO;
import it.polimi.traveldream.entities.PacchettoPersonalizzatoDTO;

import java.io.Serializable;
import java.util.ArrayList;

import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

@ManagedBean()
@SessionScoped
public class GiftListClienteBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 345L;

	@EJB
	private UserBeanRemote utenteRemoto;

	@EJB
	private PacchettoPersonalizzatoBeanRemote pacchettoPersRemoto;

	@EJB
	private UsrMgr usermanager;

	private Long idCliente;

	// PACCHETTO SELEZIONATO
	private PacchettoPersonalizzatoDTO pacchettoSelezionato;

	// LISTA PACCHETTI INVIATA ALLA PAGINA WEB
	private ArrayList<PacchettoPersonalizzatoDTO> pacchettiRicercati = new ArrayList<PacchettoPersonalizzatoDTO>();

	/**
	 * @return the pacchettoSelezionato
	 */
	public PacchettoDTO getPacchettoSelezionato() {
		return pacchettoSelezionato;
	}

	/**
	 * @param pacchettoSelezionato
	 *            the pacchettoSelezionato to set
	 */
	public void setPacchettoSelezionato(
			PacchettoPersonalizzatoDTO pacchettoSelezionato) {
		this.pacchettoSelezionato = pacchettoSelezionato;
	}

	/**
	 * @return the pacchettiRicercati
	 */
	public ArrayList<PacchettoPersonalizzatoDTO> getPacchettiRicercati() {
		return pacchettiRicercati;
	}

	/**
	 * @param pacchettiRicercati
	 *            the pacchettiRicercati to set
	 */
	public void setPacchettiRicercati(
			ArrayList<PacchettoPersonalizzatoDTO> pacchettiRicercati) {
		this.pacchettiRicercati = pacchettiRicercati;
	}

	/**
	 * @return the idCliente
	 */
	public Long getIdCliente() {
		return idCliente;
	}

	/**
	 * @param idCliente
	 *            the idCliente to set
	 */
	public void setIdCliente(Long idCliente) {
		this.idCliente = idCliente;
	}

	public String mostraGiftList() {

		FacesContext context = FacesContext.getCurrentInstance();
		HttpServletRequest request = (HttpServletRequest) context
				.getExternalContext().getRequest();

		try {

			pacchettiRicercati.clear();

			String mail = usermanager.getUserDTO().getEmail();

			ArrayList<PacchettoPersonalizzatoDTO> pacchClie = pacchettoPersRemoto
					.findByEmailCliente(mail);

			for (int i = 0; i < pacchClie.size(); i++) {

				if (pacchClie.get(i).getStato().equalsIgnoreCase("giftlist")) {

					pacchettiRicercati.add(pacchClie.get(i));

				}

			}

			return "giftListCliente";

		} catch (EJBException e) {

			context.addMessage(null, new FacesMessage("Operazione fallita"));

			return "index";

		}

	}

}
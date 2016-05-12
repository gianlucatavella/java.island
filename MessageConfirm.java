/* ø ø ø ø ø ø ø ø ø ø ø ø ø ø ø ø ø ø ø ø ø ø ø ø ø ø ø ø ø ø ø ø ø ø ø ø ø ø
   ø  by Gianluca Tavella - gianluca.tavella@libero.it                       ø
   ø                                                                         ø
   ø  JAVA ISLAND PROJECT - http://www.geocities.com/javaisland2001          ø
   ø  Febbraio 2002                                                          ø
   ø  MessageConfirm - Classe utilizzata per la visualizzazione di un        ø
   ø  messaggio di testo in una finestrella al centro dello schermo con 2    ø
   ø  pulsanti "Sì" e "No" che permettono di scegliere l'opzione desiderata. ø
   ø ø ø ø ø ø ø ø ø ø ø ø ø ø ø ø ø ø ø ø ø ø ø ø ø ø ø ø ø ø ø ø ø ø ø ø ø ø
 ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *	
 *                                                                              
 ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *
 */
package island.swing; 
/*
 * import dei package necessari
 */
import javax.swing.*;
import java.awt.event.*;

/**
 * Classe che permette la visualizzazione di un messaggio di testo in una finestra
 * al centro dello schermo con l'opzione "Sì" - "No".
 * <br>La finestra contiene il messaggio, un simbolo di "Domanda", un titolo 
 * e 2 pulsanti "Sì" e "No" che permettono di scegliere.
 * <br>Al metodo {@link #isYes(String, String)} dell'oggetto devono essere passate 2 stringhe,
 * la prima con il messaggio e la secondo con il titolo della finestra.
 * Se non si desidera visualizzare
 * il titolo è possibile inserire il valore <code>null</code> al posto della stringa
 * con il titolo.
 * <br> L'opzione di default è "Sì", per cambiarla utilizzare il metodo
 * {@link #isYes(String, String, int)}. 
 * <br>In un applicazione il sistema più comodo per usare questa classe è 
 * sintetizzato nel seguente esempio:
 * <pre>
 * if (new MessageConfirm().isYes("Uscire senza salvare?",
 *		 "Applicazione XXX", MessageConfirm.OPTION_NO)){
 *	...
 * </pre>
 * 
 */ 
public class MessageConfirm{
	/**
	 * Opzione "Sì"
	 */
	public static int OPTION_YES = 0;
	/**
	 * Opzione "No"
	 */
	public static int OPTION_NO = 1;
	
	/**
	 * Metodo per verificare l'opzione selezionata.
	 * <br>L'opzione già selezionata di default è "Sì", per cambiarla usare il
	 * metodo {@link #isYes(String, String, int)}.
	 * @param msg Stringa con il messaggio da visualizzare
	 * @param title Stringa con il titolo della finestra
	 * @return <code>true</code> se è stato premuto "Sì"
	 * <br><code>false</code> altrimenti
	 */
	public boolean isYes(String msg, String title){
		Object[] opzioni = {"Sì","No"};
		int n = JOptionPane.showOptionDialog(null, msg,
													title,
													JOptionPane.YES_NO_OPTION,
													JOptionPane.QUESTION_MESSAGE,
													null,
													opzioni,
													opzioni[0]);
		/*
		 * verifica della scelta selezionata
		 */											
		if (n == JOptionPane.YES_OPTION){
			return true;
		}else{
			return false;
		}		
	}
	/**
	 * Metodo per verificare l'opzione selezionata.
	 * <br>Per cambiare il default utilizzare i campi OPTION_YES e OPTION_NO
	 * @param msg Stringa con il messaggio da visualizzare
	 * @param title Stringa con il titolo della finestra
	 * @param sn Opzione di default 
	 * @return <code>true</code> se è stato premuto "Sì"
	 * <br><code>false</code> altrimenti
	 */
	public boolean isYes(String msg, String title, int sn){
		Object[] opzioni = {"Sì","No"};
		int n = JOptionPane.showOptionDialog(null, msg,
													title,
													JOptionPane.YES_NO_OPTION,
													JOptionPane.QUESTION_MESSAGE,
													null,
													opzioni,
													opzioni[sn]);
		/*
		 * verifica della scelta selezionata
		 */											
		if (n == JOptionPane.YES_OPTION){
			return true;
		}else{
			return false;
		}		
	}

}
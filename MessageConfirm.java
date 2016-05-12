/* � � � � � � � � � � � � � � � � � � � � � � � � � � � � � � � � � � � � � �
   �  by Gianluca Tavella - gianluca.tavella@libero.it                       �
   �                                                                         �
   �  JAVA ISLAND PROJECT - http://www.geocities.com/javaisland2001          �
   �  Febbraio 2002                                                          �
   �  MessageConfirm - Classe utilizzata per la visualizzazione di un        �
   �  messaggio di testo in una finestrella al centro dello schermo con 2    �
   �  pulsanti "S�" e "No" che permettono di scegliere l'opzione desiderata. �
   � � � � � � � � � � � � � � � � � � � � � � � � � � � � � � � � � � � � � �
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
 * al centro dello schermo con l'opzione "S�" - "No".
 * <br>La finestra contiene il messaggio, un simbolo di "Domanda", un titolo 
 * e 2 pulsanti "S�" e "No" che permettono di scegliere.
 * <br>Al metodo {@link #isYes(String, String)} dell'oggetto devono essere passate 2 stringhe,
 * la prima con il messaggio e la secondo con il titolo della finestra.
 * Se non si desidera visualizzare
 * il titolo � possibile inserire il valore <code>null</code> al posto della stringa
 * con il titolo.
 * <br> L'opzione di default � "S�", per cambiarla utilizzare il metodo
 * {@link #isYes(String, String, int)}. 
 * <br>In un applicazione il sistema pi� comodo per usare questa classe � 
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
	 * Opzione "S�"
	 */
	public static int OPTION_YES = 0;
	/**
	 * Opzione "No"
	 */
	public static int OPTION_NO = 1;
	
	/**
	 * Metodo per verificare l'opzione selezionata.
	 * <br>L'opzione gi� selezionata di default � "S�", per cambiarla usare il
	 * metodo {@link #isYes(String, String, int)}.
	 * @param msg Stringa con il messaggio da visualizzare
	 * @param title Stringa con il titolo della finestra
	 * @return <code>true</code> se � stato premuto "S�"
	 * <br><code>false</code> altrimenti
	 */
	public boolean isYes(String msg, String title){
		Object[] opzioni = {"S�","No"};
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
	 * @return <code>true</code> se � stato premuto "S�"
	 * <br><code>false</code> altrimenti
	 */
	public boolean isYes(String msg, String title, int sn){
		Object[] opzioni = {"S�","No"};
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
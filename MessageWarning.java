/* ø ø ø ø ø ø ø ø ø ø ø ø ø ø ø ø ø ø ø ø ø ø ø ø ø ø ø ø ø ø ø ø ø ø ø ø ø ø
   ø  by Gianluca Tavella - gianluca.tavella@libero.it                       ø
   ø                                                                         ø
   ø  JAVA ISLAND PROJECT - http://www.geocities.com/javaisland2001          ø
   ø  Febbraio 2002                                                          ø
   ø  MessageWarning - Classe utilizzata per la visualizzazione di un        ø
   ø  messaggio di testo in una finestrella al centro dello schermo con un   ø
   ø  solo pulsante "OK" che permette di chiuderla                           ø
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
 * al centro dello schermo con il simbolo "Attenzione".
 * <br>La finestra contiene il messaggio, un simbolo di "Attenzione", un titolo 
 * ed un unico pulsante "OK" che permette di chiuderla.
 * <br>Al costruttore dell'oggetto devono essere passate 2 stringhe, la prima con il
 * messaggio e la secondo con il titolo della finestra. Se non si desidera visualizzare
 * il titolo è possibile inserire il valore <code>null</code> al posto della stringa
 * con il titolo.
 * <br>In un applicazione il sistema più comodo per usare questa classe è 
 * sintetizzato nel seguente esempio:
 * <pre>
 * new MessageWarning("Errore di scrittura, ripetere l'operazione.", "Applicazione XXX");
 * </pre>
 * 
 */ 
public class MessageWarning{
	/**
	 * Crea un nuovo oggetto in base ai parametri e lo visualizza.
	 * <br>
	 * @param msg Stringa con il messaggio da visualizzare
	 * @param title Stringa con il titolo della finestra
	 */
	
	public MessageWarning(String msg, String title){
		JOptionPane.showMessageDialog(null, 
				msg, title,
				JOptionPane.WARNING_MESSAGE);

	}
}
/* � � � � � � � � � � � � � � � � � � � � � � � � � � � � � � � � � � � � � �
   �  by Gianluca Tavella - gianluca.tavella@libero.it                       �
   �                                                                         �
   �  JAVA ISLAND PROJECT - http://www.geocities.com/javaisland2001          �
   �  Febbraio 2002                                                          �
   �  MessageInformation - Classe utilizzata per la visualizzazione di un    �
   �  messaggio di testo in una finestrella al centro dello schermo con un   �
   �  solo pulsante "OK" che permette di chiuderla                           �
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
 * al centro dello schermo con il simbolo "Informazione".
 * <br>La finestra contiene il messaggio, un simbolo di "Informazione", un titolo 
 * ed un unico pulsante "OK" che permette di chiuderla.
 * <br>Al costruttore dell'oggetto devono essere passate 2 stringhe, la prima con il
 * messaggio e la secondo con il titolo della finestra. Se non si desidera visualizzare
 * il titolo � possibile inserire il valore <code>null</code> al posto della stringa
 * con il titolo.
 * <br>In un applicazione il sistema pi� comodo per usare questa classe � 
 * sintetizzato nel seguente esempio:
 * <pre>
 * new MessageInformation("Inserire tutti i campi", "Applicazione XXX");
 * </pre>
 * 
 */ 
public class MessageInformation{
	/**
	 * Crea un nuovo oggetto in base ai parametri e lo visualizza.
	 * <br>
	 * @param msg Stringa con il messaggio da visualizzare
	 * @param title Stringa con il titolo della finestra
	 */
	
	public MessageInformation(String msg, String title){
		JOptionPane.showMessageDialog(null, 
				msg, title,
				JOptionPane.INFORMATION_MESSAGE);

	}
}
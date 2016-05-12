/* ø ø ø ø ø ø ø ø ø ø ø ø ø ø ø ø ø ø ø ø ø ø ø ø ø ø ø ø ø ø ø ø ø ø ø ø ø ø
   ø  by Gianluca Tavella - gianluca.tavella@libero.it                       ø
   ø                                                                         ø
   ø  JAVA ISLAND PROJECT - http://www.geocities.com/javaisland2001          ø
   ø  Agosto 2001                                                            ø
   ø  ISBN - Controlla la correttezza del codice ISBN                        ø
   ø ø ø ø ø ø ø ø ø ø ø ø ø ø ø ø ø ø ø ø ø ø ø ø ø ø ø ø ø ø ø ø ø ø ø ø ø ø
 ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
*/
package island.util;
/**
 * Classe per il controllo della correttezza del codice ISBN (International Standard Book Number).
 * <br>In particolare questa classe si occupa solamente di stabilire la correttezza
 * del codice, non è detto che questo codice ISBN in realtà esista.<br>
 * Non è necessario istanziare l'oggetto, poiché l'unico metodo presente 
 * {@link #isValid(String)} è un metodo statico.<br>
 * Tipicamente si può utilizzare in un'istruzione del tipo "if (..." come <br>
 * <pre>                                                                        
 * if (ISBN.isValid(<i>stringa con il codice ISBN</i>)){ 
 *	...                                                          
 * </pre>
 * Prima del controllo tutti i trattini (-) vengono eliminati, quindi non è necessario eliminare
 * i trattini dal codice ISBN del tipo<br>
 * <code>"00-0000-000-0"</code>
 * <br><br>
 * Un esempio su come utilizzare questa classe è riportato nell'esempio seguente: 
 * <a href="../ProvingChecks.java">ProvingChecks.java</a>
 */
public class ISBN{
	/**
	 * Metodo di classe che verifica la correttezza del codice ISBN.
	 * <br>Restituisce il valore <code>true</code> se il codice ISBN è corretto,
	 * <code>false</code> altrimenti.
	 *
	 * @return <code>true</code> se il codice ISBN è corretto<br><code>false</code>
	 * se non è corretto.
	 *	
	 * @param isbn	Stringa contenente il codice ISBN da controllare.
	 *
	 */ 
   public static boolean isValid(String isbn){
   		// rimozione dei trattini e degli spazi iniziali e finali
   		isbn = StringMng.removeChars('-', isbn).trim();
   		// verifica che la lunghezza del codice sia pari a 10
   		if (isbn.length() != 10){
   			return false;
   		}
   		// converte la stringa in una matrice di caratteri (maiuscoli)
   		char[] charsIsbn = isbn.toUpperCase().toCharArray();
   		// inizializza la variabile somma
   		int somma = 0;
   		// verifica che i caratteri del codice (tranne l'ultimo) siano cifre
   		try{
   			// aggiunge alla somma il valore della moltiplicazione tra le cifre ed
   			// i valori 9, 8, 7, ..., 2 a seconda della posizione (1a cifra per 9,
   			// 2a cifra per 8,...)
   			for (int i = 0; i < 9; i++){
	   			somma += Integer.parseInt(String.valueOf(charsIsbn[i])) * (10 - i);
   			}
   			// calcola il carattere di controllo in base alla sottrazione tra 11 ed il
   			// resto della divisione della somma per 11
   			int checkDigit = 11 - (somma%11);
   			// verifica che l'ultimo carattere del codice corrisponda al carattere di 
   			// controllo, in questo caso il valore che risulterà sara true.
   			return (((checkDigit == 10) && (charsIsbn[9] == 'X')) 
   					|| (Integer.parseInt(String.valueOf(charsIsbn[9])) == checkDigit));
   		}catch (NumberFormatException e){
   			// se i caratteri del codice (tranne l'ultimo) non sono cifre viene fatto
   			// tornare il valore false
   			return false;
   		}				
   	}
}   				
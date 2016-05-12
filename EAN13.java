/* ø ø ø ø ø ø ø ø ø ø ø ø ø ø ø ø ø ø ø ø ø ø ø ø ø ø ø ø ø ø ø ø ø ø ø ø ø ø
   ø  by Gianluca Tavella - gianluca.tavella@libero.it                       ø
   ø                                                                         ø
   ø  JAVA ISLAND PROJECT - http://www.geocities.com/javaisland2001          ø
   ø  Agosto 2001                                                            ø
   ø  EAN13 - Controlla la correttezza del codice EAN (13 cifre)             ø
   ø ø ø ø ø ø ø ø ø ø ø ø ø ø ø ø ø ø ø ø ø ø ø ø ø ø ø ø ø ø ø ø ø ø ø ø ø ø
 ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
*/
package island.util;
/**
 * Classe per il controllo della correttezza del codice EAN 13 (European Article Numbering).
 * <br>In particolare questa classe si occupa solamente di stabilire la correttezza
 * del codice, non è detto che questo codice EAN13 in realtà esista.<br>
 * Non è necessario istanziare l'oggetto, poiché l'unico metodo presente 
 * {@link #isValid(String)} è un metodo statico.<br>
 * Tipicamente si può utilizzare in un'istruzione del tipo "if (..." come <br>
 * <pre>                                                                        
 * if (EAN13.isValid(<i>stringa con il codice EAN13</i>)){ 
 *	...                                                          
 * </pre>
 * L'EAN13 è il codice di distribuzione commerciale più usato a livello mondiale.
 * <br><br>
 * Un esempio su come utilizzare questa classe è riportato nell'esempio seguente: 
 * <a href="../ProvingChecks.java">ProvingChecks.java</a>
 */

public class EAN13{
	/**
	 * Metodo di classe che verifica la correttezza del codice EAN13.
	 * <br>Restituisce il valore <code>true</code> se il codice EAN13 è corretto,
	 * <code>false</code> altrimenti.
	 *
	 * @return <code>true</code> se il codice EAN13 è corretto<br><code>false</code>
	 * se non è corretto.
	 *	
	 * @param ean Stringa contenente il codice EAN13 da controllare.
	 *
	 */ 
	public static boolean isValid(String ean){
		// elimina gli spazi all'inizio e alla fine della stringa
		ean = ean.trim();
		// verifica che il codice abbia lunghezza pari a 13 caratteri
		if (ean.length() != 13){
			return false;
		}
		// verifica che sia composto solo da cifre	
		try{
			Long.parseLong(ean);
			// converte la stringa ean in una matrice di caratteri
			char[] charsEan = ean.toCharArray();
			// inizializza variabile somma
			int somma = 0;
			// aggiunge alla somma il valore delle cifre dispari
			for (int i = 0; i < 13; i += 2){
				somma += Integer.parseInt(String.valueOf(charsEan[i]));
			}
			// aggiunge alla somma il valore delle cifre pari moltiplicato per 3
			for (int i = 1; i < 13; i += 2){
				somma += Integer.parseInt(String.valueOf(charsEan[i])) * 3;
			}
			// fa ritornare il valore true la divisione tra la somma ed il valore 10 
			// è senza resto, altrimenti fa ritornare false
			return (somma%10 == 0);	
		}catch (NumberFormatException e){
			// se il codice non è composto solo da cifre viene fatto ritornare il
			// valore false
			return false;
		}
	}
}				
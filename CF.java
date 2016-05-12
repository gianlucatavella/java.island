/* ø ø ø ø ø ø ø ø ø ø ø ø ø ø ø ø ø ø ø ø ø ø ø ø ø ø ø ø ø ø ø ø ø ø ø ø ø ø
   ø  by Gianluca Tavella - gianluca.tavella@libero.it                       ø
   ø                                                                         ø
   ø  JAVA ISLAND PROJECT - http://www.geocities.com/javaisland2001          ø
   ø  Giugno 2001                                                            ø
   ø  CF - Controlla la correttezza del Codice Fiscale                       ø
   ø ø ø ø ø ø ø ø ø ø ø ø ø ø ø ø ø ø ø ø ø ø ø ø ø ø ø ø ø ø ø ø ø ø ø ø ø ø
 ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Classe CF: controlla che la stringa passata        
 * 			contenga un codice fiscale corretto.                                     
 * 			Tipicamente si può utilizzare in un'istruzione "if (..." come    
 *                                                                           
 * 			if (CF.isValid("stringa con il codice fiscale")){ 
 *				...                                                          
 *
 *          Non è necessario istanziare l'oggetto, poiché l'unico metodo è
 *          un metodo statico.
 ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *
 */
package island.util.ita; 
/*
 * import dei package
 */
import island.util.*; 
/**
 * Classe per il controllo della correttezza del Codice Fiscale.
 * <br>In particolare questa classe si occupa solamente di stabilire la correttezza
 * di un Codice Fiscale, non è detto che questo Codice Fiscale in realtà esista.<br>
 * Non è necessario istanziare l'oggetto, poiché l'unico metodo presente 
 * {@link #isValid(String)} è un metodo statico.<br>
 * Tipicamente si può utilizzare in un'istruzione del tipo "if (..." come <br>
 * <pre>                                                                        
 * if (CF.isValid(<i>stringa con il codice fiscale</i>)){ 
 *	...                                                          
 * </pre>
 * Prima del controllo tutti gli spazi vengono eliminati, quindi non è necessario eliminare
 * gli spazi dal codice fiscale del tipo<br>
 * <code>"XXX XXX 00X00 X000X"</code>
 * <br><br>
 * Un esempio su come utilizzare questa classe è riportato nell'esempio seguente: 
 * <a href="../../ProvingChecks.java">ProvingChecks.java</a>
 */ 
public class CF{
	/*
	 * Metodo di classe, restituisce 'true' se la stringa passata contiene un 
	 * codice fiscale corretto, 'false' altrimenti 
	 */
	/**
	 * Metodo di classe che verifica la correttezza del Codice Fiscale.
	 * <br>Restituisce il valore <code>true</code> se il Codice Fiscale è corretto,
	 * <code>false</code> altrimenti.
	 *
	 * @return <code>true</code> se il Codice Fiscale è corretto<br><code>false</code>
	 * se non è corretto.
	 *	
	 * @param parCF	Stringa contenente il Codice Fiscale da controllare.
	 *
	 */ 
	public static boolean isValid(String parCF){
		// conversione della stringa in caratteri maiuscoli
		String cf = parCF.toUpperCase();
		/*
		 *	eliminazione degli eventuali spazi
		 */
		cf = StringMng.removeChars(' ', cf);
		/*
		 * verifica della lunghezza del codice fiscale
		 */
		if (cf.length() == 16){
			/*
			 * creazione della matrice con i caratteri dell'alfabeto
			 */
			char[] Carattere = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I',
								'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 
								'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', '0',
								'1', '2', '3', '4', '5', '6', '7', '8', '9'};
			/*
			 * creazione della matrice con i valori attribuiti ai caratteri 
			 * dispari, corrispondenti alla matrice di caratteri
			 */
			int[] ValoriDispari = {1, 0, 5, 7, 9, 13, 15, 17, 19, 21, 2, 4,
								   18, 20, 11, 3, 6, 8, 12, 14, 16, 10, 22,
								   25, 24, 23, 1, 0, 5, 7, 9, 13, 15, 17, 19,
								   21};
			/*
			 * creazione della matrice con i valori attribuiti ai caratteri 
			 * pari, corrispondenti alla matrice di caratteri
			 */
			int[] ValoriPari = new int[36];
			for (int i = 0; i < 26; i++){
				ValoriPari[i] = i;
			}
			for (int i = 26; i < 36; i++){
				ValoriPari[i] = i - 26;
			}				
			// conversione della stringa da esaminare ad una matrice di caratteri
			char[] caratteriCF = cf.toCharArray();
			int valore = 0;
			for (int i = 0; i < caratteriCF.length - 1; i++){
				/*
				 * somma delle posizioni pari in base ai valori 
				 * corrispondenti contenuti nell'array ValoriPari
				 * (tranne l'ultimo carattere che è quello di controllo)
				 */
				if ((i+1) % 2 == 0){
					for (int j = 0; j < Carattere.length; j++){
						
						if (caratteriCF[i] == Carattere[j]){
							valore += ValoriPari[j];
						}
					}
					/*
					 * somma delle posizioni dispari in base ai valori 
					 * corrispondenti contenuti nell'array ValoriDispari
					 */
				}else{
					for (int j = 0; j < Carattere.length; j++){
						if (caratteriCF[i] == Carattere[j]){
							valore += ValoriDispari[j];
						}
					}
				}
			}
			/*
			 * ottenimento del resto della divisione per 26 e 
			 * valutazione del carattere di controllo (ultimo carattere)
			 */
			valore %= 26;
			for (int i = 0; i < 26; i++){
				/*
				 * verifica che il valore dell'ultimo carattere corrisponda
				 * al valore ottenuto attraverso l'algoritmo di somma precedente
				 */ 
				if (caratteriCF[caratteriCF.length - 1] == Carattere[i]){
					if (valore == i){
						return true;
					}else{
						return false;
					}
				}
			}			
			return false;						
									
		}else{
			return false;
		}				    
	    
	}
}			
/* ø ø ø ø ø ø ø ø ø ø ø ø ø ø ø ø ø ø ø ø ø ø ø ø ø ø ø ø ø ø ø ø ø ø ø ø ø ø
   ø  by Gianluca Tavella - gianluca.tavella@libero.it                       ø
   ø                                                                         ø
   ø  JAVA ISLAND PROJECT - http://www.geocities.com/javaisland2001          ø
   ø  Agosto 2001                                                            ø
   ø  StringMng - Gestione delle stringhe                                    ø
   ø ø ø ø ø ø ø ø ø ø ø ø ø ø ø ø ø ø ø ø ø ø ø ø ø ø ø ø ø ø ø ø ø ø ø ø ø ø
 ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
*/
package island.util;
/**
 * Questa classe contiene metodi statici per la gestione di oggetti di tipo String.
 */
public class StringMng{
	/**
	 * Metodo di classe che rimuove tutte le occorrenze di un determinato carattere
	 * da una stringa.
	 * @param c Carattere da rimuovere
	 * @param s Stringa da cui rimuovere il determinato carattere 
	 * @return Stringa senza le eventuali occorrenze del carattere parametro.
	 */
	public static String removeChars(char c, String s){
		// trasforma la stringa in una matrice di caratteri
		char[] caratteri = s.toCharArray();
		// crea una nuova stringa vuota
		String stringaSenzaCarattere = new String();
		/*
		 * Scorre la matrice di caratteri e li aggiunge alla nuova stringa solamente
		 * se i caratteri sono diversi da quello da togliere
		 */
		for (int i = 0; i < caratteri.length; i++){
			if (caratteri[i] != c){
				stringaSenzaCarattere += caratteri[i];
			}
		}
		// ritorna la stringa le occorrenze del carattere da togliere
		return stringaSenzaCarattere;
	}
	/**
	 * Metodo di classe che divide una stringa in più stringhe di lunghezza inferiore
	 * senza dividere le parole.
	 * <br>In particolare, la stringa viene divisa in stringhe di lunghezza massima pari a
	 * quella impostata a seconda di dove si trovano gli spazi.
	 * <br>Se il parametro è inferiore a 2 la stringa viene divisa in stringhe da un carattere.
	 * @param s Stringa da dividere
	 * @param lung Lunghezza massima delle stringhe divise 
	 * @return Matrice di stringhe di lunghezza massima pari al parametro
	 */
	public static String[] getSubStringsInt(String s, int lung){
		// se la lunghezza parametro è maggiore della lunghezza della stringa di partenza
		// viene fatta tornare una sola stringa uguale a quella di partenza
		if (s.length() < lung){
			String[] stringapiena =	new String[1];
			stringapiena[0] = s;
			return stringapiena;
		}	
		int numero = 0;
		char[] caratteri = s.toCharArray();
		String[] sottos = new String[s.length()];
		// se la lunghezza parametro è inferiore a 2 vengono fatte tornare  
		// stringhe di un solo carattere
		if (lung < 2){
			for (int i = 0; i < sottos.length; i++){
				char[] c = new char[1];
				c[0] = caratteri[i];				
				sottos[i] = new String(c);
			}
			return sottos;
		}
		// divisione delle stringhe
		for (int i = lung; i > 0; i--){
			// verifica che il carattere sia uno spazio, altrimenti il ciclo continua
			// a ritroso fino a trovare uno spazio
			if (caratteri[i] == ' '){
				sottos[numero] = new String(caratteri, 0, i);
				s = new String(caratteri, i+1, caratteri.length - i-1);
				numero++;
				caratteri = s.toCharArray();
				i = lung;
				// se la stringa rimasta è l'ultima il ciclo si interrompe
				if (s.length() <= lung){
					sottos[numero] = new String(caratteri);
					numero++;
					break;
				}	
			}
			// se si arriva al primo carattere e non si trovano spazi
			// la parola viene divisa
			if (i == 1){
				sottos[numero] = new String(caratteri, 0, lung);
				if (caratteri[lung] == ' ' && lung > 2){
					s = new String(caratteri, lung + 1, caratteri.length - lung - 1);
				}else{
					s = new String(caratteri, lung, caratteri.length - lung);
				}	
				numero++;
				caratteri = s.toCharArray();
				i = lung;
				// se la stringa rimasta è l'ultima il ciclo si interrompe
				if (s.length() <= lung){
					sottos[numero] = new String(caratteri);
					numero++;
					break;
				}	
			}
		}
		// return delle stringhe
		String[] sottostringhe = new String[numero];
		for (int i = 0; i < numero; i++){
			sottostringhe[i] = sottos[i];
		}
		return sottostringhe;			
	}			
			
}				
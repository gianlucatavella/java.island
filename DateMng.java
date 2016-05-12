/* � � � � � � � � � � � � � � � � � � � � � � � � � � � � � � � � � � � � � �
   �  by Gianluca Tavella - gianluca.tavella@libero.it                       �
   �                                                                         �
   �  JAVA ISLAND PROJECT - http://www.geocities.com/javaisland2001          �
   �  Settembre 2001                                                         �
   �  DateMng - Verifica delle date in base al calendario gregoriano         �
   � � � � � � � � � � � � � � � � � � � � � � � � � � � � � � � � � � � � � �
 ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *	
 *                                                                              
 ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 *
 */
package island.util;
/*
 * import dei package
 */
import java.util.*; 
/**
 * Questa classe contiene metodi statici per la gestione di date.
 * <br>Le date possono essere rappresentate:
 * <br>1) da tre numeri interi: giorno del mese, mese e anno
 * <br>2) da una stringa del tipo "gg/mm/aaaa" (es. "12/05/2001" o "01/01/2030")
 * <br>prestare attenzione ad inserire anche gli zeri.
 * <br>
 * <br>Il calendario di riferimento � quello Gregoriano. 
 * <br>Non � necessario istanziare l'oggetto, poich� i metodi presente 
 * sono metodi statici.<br>
 * Tipicamente si pu� utilizzare in un'istruzione del tipo "if (..." come <br>
 * <pre>
 *                                                                          
 * if (DateMng.isValid(gg, mm, aaaa)){ 
 *	...                                                          
 * </pre>
 * oppure
  * <pre>
 *                                                                          
 * if (DateMng.isValid(stringaData)){ 
 *	...                                                          
 * </pre>
 * 
 */
public class DateMng{
	/**
	 * Metodo che verifica la validit� di una data.
	 * <br>Ritorna il valore <code>true</code> se la data rappresentata dai parametri � valida.
	 * 
	 * @return <code>true</code> se la data � valida
	 *     <br><code>false</code> altrimenti
	 * @param day	 Giorno
	 * @param month	 Mese
	 * @param year	 Anno 
	 */
	public static boolean isValid(int day, int month, int year){
		/*
		 * numero dei giorni del mese
		 */
		int numDays = 0;
		/* 
		 * In base al mese e all'anno assegna un valore al numero dei giorni del mese
		 */
		switch (month) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                numDays = 31;
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                numDays = 30;
                break;
            case 2:
            	/*
            	 * verifica se l'anno inserito � bisestile
            	 */
                if ( ((year % 4 == 0) && !(year % 100 == 0))
                     || (year % 400 == 0) )
                    numDays = 29;
                else
                    numDays = 28;
                break;
        }
        /*
         * controlla che il giorno inserito sia compatibile con il mese e l'anno
         * immesso
         */
        if (day <= numDays){
        	return true;
        }else{
        	return false;
        }
	}
	/**
	 * Metodo che verifica la validit� di una data.
	 * <br>Ritorna il valore <code>true</code> se la data rappresentata dalla stringa � valida.
	 * 
	 * @return <code>true</code> se la data � valida
	 *     <br><code>false</code> altrimenti
	 * @param data	 Data nel formato stringa "gg/mm/yyyy"
	 */
	public static boolean isValid(String data){
		/*
		 * inizializzazione dei valori in base alla stringa
		 */
		if (data.length() != 10){
			return false;
		}	
		int day;
		int month;
		int year;
		try{
			day = Integer.parseInt(data.substring(0, 2));
			month = Integer.parseInt(data.substring(3, 5));
			year = Integer.parseInt(data.substring(6, 10));
		}catch (Exception e){
			return false;
		}	
		return DateMng.isValid(day, month, year);
	}
	/**
	 * Questo metodo crea e restituisce un oggetto GregorianCalendar
	 * a partire da una data in formato stringa ("gg/mm/aaaa").
	 * @param data	 Data nel formato stringa "gg/mm/yyyy"
	 * @return GregorianCalendar inizializzato alla data inserita se la data � valida,
	 * se la data non � valida il GregorianCalendar � inizializzato alla data corrente.
	 */
	public static GregorianCalendar getGregorianCalendar(String data){
		if (isValid(data)){
			GregorianCalendar Cal = new GregorianCalendar(
					Integer.parseInt(data.substring(6, 10)),
					Integer.parseInt(data.substring(3, 5))-1,
					Integer.parseInt(data.substring(0, 2)));
			return Cal;
		}else{
			GregorianCalendar Cal =	new GregorianCalendar();
			return Cal;
		}			
	}
	/**
	 * Questo metodo restituisce una stringa con il giorno della settimana  
	 * (Es: "Luned�", "Gioved�") a partire da una data in formato stringa.
	 * @param data	 Data nel formato stringa "gg/mm/yyyy"
	 * @return Stringa con il giorno della settimana, se la data non � valida
	 * viene fatta tornare una stringa vuota "".
	 */
	public static String getGiornoSettimana(String data){
		if (isValid(data)){
			GregorianCalendar cal = getGregorianCalendar(data);
			if (cal.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY){
				return "Domenica";
			}	
			if (cal.get(Calendar.DAY_OF_WEEK) == Calendar.MONDAY){
				return "Luned�";
			}	
			if (cal.get(Calendar.DAY_OF_WEEK) == Calendar.TUESDAY){
				return "Marted�";
			}	
			if (cal.get(Calendar.DAY_OF_WEEK) == Calendar.WEDNESDAY){
				return "Mercoled�";
			}	
			if (cal.get(Calendar.DAY_OF_WEEK) == Calendar.THURSDAY){
				return "Gioved�";
			}	
			if (cal.get(Calendar.DAY_OF_WEEK) == Calendar.FRIDAY){
				return "Venerd�";
			}	
			if (cal.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY){
				return "Sabato";
			}	

		}
		return "";
	}		
		
		
}	

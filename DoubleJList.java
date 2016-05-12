/* ø ø ø ø ø ø ø ø ø ø ø ø ø ø ø ø ø ø ø ø ø ø ø ø ø ø ø ø ø ø ø ø ø ø ø ø ø ø
   ø  by Gianluca Tavella - gianluca.tavella@libero.it                       ø
   ø                                                                         ø
   ø  JAVA ISLAND PROJECT - http://www.geocities.com/javaisland2001          ø
   ø  Settembre 2001                                                         ø
   ø  DoubleJList - Classe per la gestione delle due liste con le voci da    ø
   ø  spostare da una parte all'altra (es., Interfaccia Classic di WS_FTP,   ø
   ø  creazione guidata maschera di Microsoft Access )                       ø
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
 * Classe per la gestione di una coppia di liste con le voci disponibili
 * nella lista "Source" da spostare nella lista "Target" per la selezione.
 * <br>Esempi: liste visualizzate durante la creazione guidata maschera
 * di Microsoft Access o interfaccia classica di WS_FTP.
 * <br>Un possibile utilizzo potrebbe essere quello proposto nell'esempio seguente:
 * <a href="../ProvingDJ.java">ProvingDJ.java</a>
 * <br><br>
 * <img src="dj.gif">
 */ 
public class DoubleJList{
	//////////////////////////////////////////////////////////
	////////////////// Oggetti di classe /////////////////////
	//////////////////////////////////////////////////////////
	/* lista con le voci disponibili*/
	private JList listSource;
	/* lista contenente le voci selezionate */
	private JList listTarget;
	/* modello di default per la lista con le voci disponibili */
	private DefaultListModel listSourceModel = new DefaultListModel();
	/* modello di default per la lista contenente le voci selezionate */
	private DefaultListModel listTargetModel = new DefaultListModel();
	/* Matrice con le voci da visualizzare nella lista Source */
	private String[] elemSource;
	/* Matrice con le voci da visualizzare nella lista Target */
	private String[] elemTarget;
	/* Primo pulsante a cui si vuole associare il fatto di essere disabilitato
	  * nel momento in cui nella lista Source non ci sia nessuna voce. */
	private JButton buttonSource1 = new JButton();
	/* Secondo pulsante a cui si vuole associare il fatto di essere disabilitato
	  * nel momento in cui nella lista Source non ci sia nessuna voce. */
	private JButton buttonSource2 = new JButton();
	/* Secondo pulsante a cui si vuole associare il fatto di essere disabilitato
	  * nel momento in cui nella lista Source non ci sia nessuna voce. */
	private JButton buttonSource3 = new JButton();
	/* Primo pulsante a cui si vuole associare il fatto di essere disabilitato
	  * nel momento in cui nella lista Target non ci sia nessuna voce. */
	private JButton buttonTarget1 = new JButton();
	/* Secondo pulsante a cui si vuole associare il fatto di essere disabilitato
	  * nel momento in cui nella lista Target non ci sia nessuna voce. */
	private JButton buttonTarget2 = new JButton();
	/* Terzo pulsante a cui si vuole associare il fatto di essere disabilitato
	  * nel momento in cui nella lista Ttarget non ci sia nessuna voce. */
	private JButton buttonTarget3 = new JButton();
	/**
	 * Crea un nuovo oggetto in base ai parametri.
	 * <br>
	 * Nel caso alcuni parametri non siano necessari è possibile passare al costruttore
	 * il valore <code>null</code> al posto del parametro.
	 * <br>Si badi tuttavia che almeno una matrice di stringhe e le due JList devono essere passate al costruttore per
	 * poter creare un oggetto funzionale.
	 * <br>
	 * @param parElemSource Matrice di stringhe con le voci da visualizzare nella
	 *        lista <i>source</i>
	 * @param parElemTarget Matrice di stringhe con le voci da visualizzare nella
	 *        lista <i>target</i>
	 * @param parListSource lista <i>source</i>
	 * @param parListTarget lista <i>target</i>
	 * @param parButtonSource1 pulsante a cui vuole essere associato il fatto di rimanere
	 * 		  disabilitato nel momento in cui la lista <i>source</i> sia vuota
	 * @param parButtonSource2 pulsante a cui vuole essere associato il fatto di rimanere
	 * 		  disabilitato nel momento in cui la lista <i>source</i> sia vuota
	 * @param parButtonSource3 pulsante a cui vuole essere associato il fatto di rimanere
	 * 		  disabilitato nel momento in cui la lista <i>source</i> sia vuota
	 * @param parButtonTarget1 pulsante a cui vuole essere associato il fatto di rimanere
	 * 	 	  disabilitato nel momento in cui la lista <i>target</i> sia vuota
	 * @param parButtonTarget2 pulsante a cui vuole essere associato il fatto di rimanere
	 * 		  disabilitato nel momento in cui la lista <i>target</i> sia vuota
	 * @param parButtonTarget3 pulsante a cui vuole essere associato il fatto di rimanere
	 * 		  disabilitato nel momento in cui la lista <i>target</i> sia vuota
	 */
	
	public DoubleJList(String[] parElemSource, String[] parElemTarget, 
						JList parListSource, JList parListTarget,
						JButton parButtonSource1, JButton parButtonSource2,
						JButton parButtonSource3, JButton parButtonTarget1,
						JButton parButtonTarget2, JButton parButtonTarget3){
		/*
		 * passa i parametri agli oggetti di classe
		 */
		elemSource = parElemSource;
		elemTarget = parElemTarget;
		listSource = parListSource;
		listTarget = parListTarget;
		/*
		 * verifica quali pulsanti vengono passati e li assegna agli
		 * oggetti JButton di classe
		 */
		if (parButtonSource1 != null){
			buttonSource1 = parButtonSource1;
		}
		if (parButtonSource2 != null){
			buttonSource2 = parButtonSource2;
		}
		if (parButtonSource3 != null){
			buttonSource3 = parButtonSource3;
		}
		if (parButtonTarget1 != null){
			buttonTarget1 = parButtonTarget1;
		}	
		if (parButtonTarget2 != null){
			buttonTarget2 = parButtonTarget2;
		}	
		if (parButtonTarget3 != null){
			buttonTarget3 = parButtonTarget3;
		}	
		
		// gestione dell'evento doppioclick
		MouseListener mouseListenerSource = new MouseAdapter() {
		    public void mouseClicked(MouseEvent e) {
		        if (e.getClickCount() == 2) {
					addSelection();
		         }
		    }
		};
		listSource.addMouseListener(mouseListenerSource);

		// gestione dell'evento doppioclick
		MouseListener mouseListenerTarget = new MouseAdapter() {
		    public void mouseClicked(MouseEvent e) {
		        if (e.getClickCount() == 2) {
					removeSelection();
		         }
		    }
		};
		listTarget.addMouseListener(mouseListenerTarget);
		
		/* verifica che le stringhe non siano nulle e le assegna ai modelli
		 * di default delle liste
		 */ 
		if (elemSource != null){
			for (int i = 0; i < elemSource.length; i++){
				listSourceModel.addElement(elemSource[i]);
			}
		}		
		if (elemTarget != null){
			for (int i = 0; i < elemTarget.length; i++){
				listTargetModel.addElement(elemTarget[i]);
			}
		}
		listTarget.setModel(listTargetModel);
		listSource.setModel(listSourceModel);
		
		/*
		 * disabilita i pulsanti se le rispettive liste sono vuote
		 */
		if (sourceIsEmpty()){
			buttonSource1.setEnabled(false);
			buttonSource2.setEnabled(false);
			buttonSource3.setEnabled(false);
		}	
		if (targetIsEmpty()){
			buttonTarget1.setEnabled(false);
			buttonTarget2.setEnabled(false);
			buttonTarget3.setEnabled(false);
		}	
	}
	/**
	 * Aggiunge alla lista <i>target</i> gli elementi selezionati dalla lista <i>source</i>.
	 */
	
	public void addSelection(){
		// verifica almeno un elemento della lista source sia selezionato
		if (!listSource.isSelectionEmpty()){
			// array con gli indici degli elementi selezionati
			int[] selected = listSource.getSelectedIndices();	
			// aggiunge gli elementi selezionati al modello della lista target
			for (int i = 0; i < selected.length; i++){
				listTargetModel.addElement(listSourceModel.get(selected[i]));
			}
			// toglie gli elementi selezionati dal modello della lista source
			for (int i = selected.length; i > 0 ; i--){
				listSourceModel.remove(selected[i - 1]);
			}
			// assegna i modelli alle rispettive liste
			listTarget.setModel(listTargetModel);
			listSource.setModel(listSourceModel);
			// seleziona l'elemento successivo dalla lista source oppure
			// l'ultimo elemento
			if (listSourceModel.getSize() > selected[0]){
				listSource.setSelectedIndex(selected[0]);
			}else if (listSourceModel.getSize() > 0 
					&& listSourceModel.getSize() <= selected[0] ){
				listSource.setSelectedIndex(listSourceModel.getSize() - 1);
			}
			// disabilita i pulsanti se la lista source è vuota	
			if (sourceIsEmpty()){
				buttonSource1.setEnabled(false);
				buttonSource2.setEnabled(false);
				buttonSource3.setEnabled(false);
			}
			// abilita i pulsanti se la lista target non è vuota	
			if (!targetIsEmpty()){
				buttonTarget1.setEnabled(true);
				buttonTarget2.setEnabled(true);
				buttonTarget3.setEnabled(true);
			}	
		}	
	}
	/**
	 * Rimuove dalla lista <i>target</i> gli elementi selezionati e li sposta nella lista <i>source</i>.
	 */
	
	public void removeSelection(){
		// verifica almeno un elemento della lista target sia selezionato
		if (!listTarget.isSelectionEmpty()){
			// array con gli indici degli elementi selezionati
			int[] selected = listTarget.getSelectedIndices();	
			// aggiunge gli elementi selezionati al modello della lista source
			for (int i = 0; i < selected.length; i++){
				listSourceModel.addElement(listTargetModel.get(selected[i]));
			}
			// toglie gli elementi selezionati dal modello della lista target
			for (int i = selected.length; i > 0 ; i--){
				listTargetModel.remove(selected[i - 1]);
			}
			// assegna i modelli alle rispettive liste
			listTarget.setModel(listTargetModel);
			listSource.setModel(listSourceModel);
			// seleziona l'elemento successivo dalla lista source oppure
			// l'ultimo elemento
			if (listTargetModel.getSize() > selected[0]){
				listTarget.setSelectedIndex(selected[0]);
			}else if (listTargetModel.getSize() > 0 
					&& listTargetModel.getSize() <= selected[0] ){
				listTarget.setSelectedIndex(listTargetModel.getSize() - 1);
			}	
			// disabilita i pulsanti se la lista target è vuota	
			if (targetIsEmpty()){
				buttonTarget1.setEnabled(false);
				buttonTarget2.setEnabled(false);
				buttonTarget3.setEnabled(false);
			}	
			// abilita i pulsanti se la lista source non è vuota	
			if (!sourceIsEmpty()){
				buttonSource1.setEnabled(true);
				buttonSource2.setEnabled(true);
				buttonSource3.setEnabled(true);
			}
		}		
	}
	/**
	 * Aggiunge alla lista <i>target</i> tutti gli elementi presenti nella lista
	 * <i>source</i>.
	 */
	public void addAll(){
		// verifica che nella lista source vi sia almeno un elemento
		if (!listSourceModel.isEmpty()){
			// aggiunge tutti gli elementi della lista source al modello della
			// lista target
			for (int i = 0; i < listSourceModel.getSize(); i++){
				listTargetModel.addElement(listSourceModel.get(i));
			}
			// elimina tutti gli elementi dalla lista source
			listSourceModel.clear();
			// assegna i modelli alle rispettive liste
			listTarget.setModel(listTargetModel);
			listSource.setModel(listSourceModel);
			// disabilita i pulsanti associati alla lista source
			buttonSource1.setEnabled(false);
			buttonSource2.setEnabled(false);
			buttonSource3.setEnabled(false);
			// abilita i pulsanti associati alla lista target
			if (!targetIsEmpty()){
				buttonTarget1.setEnabled(true);
				buttonTarget2.setEnabled(true);
				buttonTarget3.setEnabled(true);
			}
		}		
	}
	/**
	 * Toglie dalla lista <i>target</i> tutti gli elementi presenti e li sposta nella lista
	 * <i>source</i>.	
	 */
	public void removeAll(){
		// verifica che nella lista target vi sia almeno un elemento
		if (!listTargetModel.isEmpty()){
			// aggiunge tutti gli elementi della lista target al modello della
			// lista source
			for (int i = 0; i < listTargetModel.getSize(); i++){
				listSourceModel.addElement(listTargetModel.get(i));
			}
			// elimina tutti gli elementi dalla lista target
			listTargetModel.clear();
			// assegna i modelli alle rispettive liste
			listTarget.setModel(listTargetModel);
			listSource.setModel(listSourceModel);
			// disabilita i pulsanti associati alla lista target
			buttonTarget1.setEnabled(false);
			buttonTarget2.setEnabled(false);
			buttonTarget3.setEnabled(false);
			// abilita i pulsanti associati alla lista source
			if (!sourceIsEmpty()){
				buttonSource1.setEnabled(true);
				buttonSource2.setEnabled(true);
				buttonSource3.setEnabled(true);
			}
		}		
	}
	/**
	 * Controlla se nella lista <i>source</i> siano presenti elementi o meno.
	 * @return <code>true</code> se nella lista <i>source</i> è presente almeno un elemento
	 * <br><code>false</code> altrimenti
	 */
	public boolean sourceIsEmpty(){
		if (listSourceModel.isEmpty()){
			return true;
		}else{
			return false;
		}
	}			
	/**
	 * Controlla se nella lista <i>target</i> siano presenti elementi o meno.
	 * @return <code>true</code> se nella lista <i>target</i> è presente almeno un elemento
	 * <br><code>false</code> altrimenti
	 */
	public boolean targetIsEmpty(){
		if (listTargetModel.isEmpty()){
			return true;
		}else{
			return false;
		}
	}
	/**
	 * Restituisce una matrice di stringhe con gli elementi presenti nella lista <i>source</i>.
	 * @return Matrice di stringhe con le voci presenti nella lista <i>source</i>
	 */
	public String[] getSource(){
		// crea array di stringhe in base alla dimensione della lista
		String[] elemSource = new String[listSourceModel.getSize()];
		// scorre la lista e assegna i vari elementi alla matrice di stringhe
		for (int i = 0; i < listSourceModel.getSize(); i++){
			elemSource[i] = listSourceModel.get(i).toString();
		}
		// fa ritornare la matrice di stringhe
		return elemSource;
	}
	/**
	 * Restituisce una matrice di stringhe con gli elementi presenti nella lista <i>target</i>.
	 * @return Matrice di stringhe con le voci presenti nella lista <i>target</i>
	 */
	public String[] getTarget(){
		// crea array di stringhe in base alla dimensione della lista
		String[] elemTarget = new String[listTargetModel.getSize()];
		// scorre la lista e assegna i vari elementi alla matrice di stringhe
		for (int i = 0; i < listTargetModel.getSize(); i++){
			elemTarget[i] = listTargetModel.get(i).toString();
		}
		// fa ritornare la matrice di stringhe
		return elemTarget;
	}	
}
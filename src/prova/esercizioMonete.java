package prova;

import java.util.ArrayList;
import java.util.List;

public class esercizioMonete {
	int combo=0;
	private List<Integer> monete= new ArrayList<Integer>();
	List<Combinazione> combinazioni = new ArrayList<Combinazione>();

	
	public esercizioMonete(int a,int b,int c,int d,int e){
		monete.add(a);
		monete.add(b);
		monete.add(c);
		monete.add(d);
		monete.add(e);
//System.out.println(monete.size());
	}
	
	
	public void contaSoluzioni (int nCombinazioniCercate){
		this.combo=nCombinazioniCercate;
		List<Combinazione> combinazioni = new ArrayList<Combinazione>();
		int fatto =0; //numero di combinazioni trovate

		combinazioni= cerca(combinazioni, fatto);
		
		for (int i =0;i<combinazioni.size();i++){
			System.out.println(combinazioni.get(i).toString());}
}

	private List<Combinazione> cerca(List<Combinazione> combinazioni, int fatto) {

		if (fatto == combo){
			System.out.println("Finito");}
		else {
			Combinazione e= creaCombinazione(120);
			
			if (!combinazioni.contains(e)&& combinazioni.size()<=combo)
			{
			combinazioni.add(e);
			

			cerca(combinazioni,fatto+1);}
		}
		
		return combinazioni;
	}
	Combinazione combinazione = new Combinazione();


	private Combinazione creaCombinazione(int totale) {
		if (totale==0)
			System.out.println("fine");
		else{
			int molt=0;

			molt= scegliMoltiplicatore(monete.get(0),totale);
			combinazione.aggiungiValore(molt);
			totale-=molt*monete.get(0);

			molt= scegliMoltiplicatore(monete.get(1),totale);
			combinazione.aggiungiValore(molt);
			totale-=molt*monete.get(1);

			molt= scegliMoltiplicatore(monete.get(2),totale);
			combinazione.aggiungiValore(molt);
			totale-=molt*monete.get(2);

			molt= scegliMoltiplicatore(monete.get(3),totale);
			combinazione.aggiungiValore(molt);
			totale-=molt*monete.get(3);

			molt= scegliMoltiplicatore(monete.get(4),totale);
			combinazione.aggiungiValore(molt);
			totale-=molt*monete.get(4);

			System.out.println(combinazione.toString());

			return combinazione; }
		System.out.println(combinazione.toString());
		return combinazione;
	}


	private int scegliMoltiplicatore(int moneta, int totale) {
		int molt =0;
		if (totale%moneta==0)
			molt=totale/moneta;
		else 
			molt= (totale-(totale/moneta))/moneta;
//System.out.println(Integer.toString(molt));
		return molt;
		
			
	
	}
	
	public static void main(String[] args) {
		
		esercizioMonete es= new esercizioMonete(2,3,7,31,45);
		es.trovaCombinazioni(111) ;
		//es.contaSoluzioni(10);
		/*es.contaSoluzioni (10);*/
		//es.scegliMoltiplicatore(1,120);
		//es.creaCombinazione(120);

	}


	private void trovaCombinazioni(int totale) {

		int step = 0 ;
		Combinazione c = new Combinazione() ;
		
		ricorsiva(step, this.monete, c, totale) ;
		
		System.out.println(combinazioni.size()) ;
		
	}
	
	private void ricorsiva( int step, List<Integer> monete, Combinazione c, int totale) {
		
		int somma = c.getSomma(monete) ;
		
		if(step==monete.size()) {
			// caso terminale
			if(somma==totale) {
				System.out.println(c); 
				combinazioni.add(new Combinazione(c)) ;
			}
			
		} else {
			// caso normale
			
			for( int quante = 0 ; somma+ quante * monete.get(step) <= totale ; quante++ ) {
				
				// "provo" a mettere "quante" monete
				c.aggiungiValore(quante);
				ricorsiva(step+1, monete, c, totale) ;
				c.rimuoviValore(step);
			}

		}
			
		
		
	}
	
}
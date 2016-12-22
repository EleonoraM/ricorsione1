package prova;

import java.util.ArrayList;
import java.util.List;

public class Combinazione {

	private List<Integer> valori;

	public Combinazione (){
		valori = new ArrayList<Integer>();
	}
	
	public Combinazione(Combinazione altro) {
		// per clonare una Combinazione
		
		valori = new ArrayList<>( altro.getValori() ) ;
		
	}
	
	public void aggiungiValore (int i){
		if (valori.size()<=5)
			valori.add(i);
		else throw new RuntimeException();
	}
	public void rimuoviValore (int pos){
		valori.remove(pos);
	}

	@Override
	public String toString() {
		return "Combinazione " + valori + " \n";
	}

	public List<Integer> getValori() {
		return valori;
	}

	public int getSomma(List<Integer> monete) {
		int somma = 0 ;
		for(int i=0; i<valori.size(); i++) {
			somma += valori.get(i) * monete.get(i) ;
		}
		return somma ;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((valori == null) ? 0 : valori.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Combinazione other = (Combinazione) obj;
		if (valori == null) {
			if (other.valori != null)
				return false;
		} else if (!valori.equals(other.valori))
			return false;
		return true;
	}
	
}


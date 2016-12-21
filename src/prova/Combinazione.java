package prova;

import java.util.ArrayList;
import java.util.List;

public class Combinazione {

	private List<Integer> valori;
	private int somma ;

	public Combinazione (){
		valori = new ArrayList<Integer>();
		somma=0;
	}

	public boolean sommaOK (){
		somma+=valori.get(0)*1;
		somma+=valori.get(1)*3;
		somma+=valori.get(2)*7;
		somma+=valori.get(3)*31;
		somma+=valori.get(4)*45;
		if (somma!=120)
			return false;
		return true;
	}
	public void aggiungiValore (int i){
		if (valori.size()<=5)
			valori.add(i);
		else throw new RuntimeException();
	}
	public void rimuoviValore (int i){
		valori.remove(i);
	}

	@Override
	public String toString() {
		return "Combinazione " + valori + " \n";
	}

	public List<Integer> getValori() {
		return valori;
	}

	public int getSomma() {
		return somma;
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


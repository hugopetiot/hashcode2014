public class Serveur implements Comparable {
	int capacite;
	int taille;
	int ligne;
	int emplacement;
	Groupe groupe;
	
	
	public Serveur(int c,int t){
		capacite=c;
		taille=t;
		ligne=-1;
		emplacement=-1;
		groupe=null;		
	}
	
	
	public boolean place(){
		if(emplacement==-1)
			return false;
		return true;
	}
	double getRatio(){return capacite/taille;}
	int getCapacite(){return capacite;}
	void setCapacite(int c){capacite=c;}
	int getTaille(){return taille;}
	void setTaille(int c){taille=c;}
	int getLigne(){return ligne;}
	void setLigne(int c){ligne=c;}
	int getEmplacement(){return emplacement;}
	void setEmplacement(int c){emplacement=c;}
	Groupe getGroupe(){return groupe;}
	void setGroupe(Groupe g){groupe=g;}


	public int compareTo(Object o) {
		Serveur s=(Serveur)o;
		if(getRatio()<s.getRatio())
			return 1;
		if(getRatio()>s.getRatio())
			return -1;
		return 0;
	}
	public String toString(){
		return "["+taille+"]"+"["+capacite+"]";
	}


	
	
	
}
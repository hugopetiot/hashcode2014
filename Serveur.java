public class Serveur {
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
	
	
	
}
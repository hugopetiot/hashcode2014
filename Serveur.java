public class Serveur {
	int capacite;
	int taille;
	int ligne;
	int emplacement;
	Pool p;
	
	public Serveur(int c,int t){
		capacite=c;
		taille=t;
		ligne=-1;
		emplacement=-1;
		p=null;
	}
	
	int getCapacite(){return capacite;}
	void setCapacite(int c){capacite=c;}
	int getTaille(){return taille;}
	void setTaille(int c){taille=c;}
	int getLigne(){return ligne;}
	void setLigne(int c){ligne=c;}
	int getEmplacement(){return emplacement;}
	void setEmplacement(int c){emplacement=c;}
	Pool getPool(){return p;}
	void setPool(Pool pool){p=pool;}
	
	
	
}
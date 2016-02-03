import java.util.ArrayList;

public class Datacenter{
	int rangees, emplacements, emplacementsIndisponibles, groupes, serveurs;
	Serveur[][] data;
	ArrayList<Serveur> listeServ;
	
	public Datacenter(int r, int e, int ei, int g, int s){
		rangees = r;
		emplacements = e;
		emplacementsIndisponibles = ei;
		groupes = g;
		serveurs = s;
		listeServ = new ArrayList<Serveur>();
		data = new Serveur[rangees][emplacements];
		for(int i=0;i<rangees;i++){
			for(int j=0;i<emplacements;i++){
				data[i][j] = null;
			}
		}
	}
	
	public void ajoutIndisponible(int r, int e){
		// Emplacement indisponible (capacité = -1, taille = -1)
		data[r][e] = new Serveur(-1, -1);
	}

	
	public void ajoutListeServeur(int capa, int taille){
		listeServ.add(new Serveur(capa, taille));
	}
	
	
	int getRangees(){
		return rangees;
	}
	void setRangees(int r){
		rangees = r;
	}
	
	int getEmplacements(){
		return emplacements;
	}
	void setEmplacements(int e){
		emplacements = e;
	}
}
import java.util.ArrayList;
import java.util.Collections;

public class Datacenter{
	int rangees, emplacements, emplacementsIndisponibles, serveurs;
	Serveur[][] data;
	ArrayList<Serveur> listeServ;
	ArrayList<Groupe> groupes;
	int nombre;
	boolean full;
	
	
	public Datacenter(int r, int e, int ei, int g, int s){
		rangees = r;
		emplacements = e;
		emplacementsIndisponibles = ei;

		serveurs = s;
		listeServ = new ArrayList<Serveur>();
		groupes= new ArrayList<Groupe>(g);
		for(int i=0;i<g;i++){
			groupes.add(new Groupe(r,e));
		}
		data = new Serveur[rangees][emplacements];
		for(int i=0;i<rangees;i++){
			for(int j=0;j<emplacements;j++){
				data[i][j] = null;
			}
		}
		nombre=0;
		full=false;
	}
	
	public void etat() {
		int nbserv =0;
		for(int i=0;i<rangees;i++){
			for(int j=0;j<emplacements;j++){
				System.out.print(data[i][j]+"\t");
				if(data[i][j] != null)
					nbserv++;
			}
			System.out.println("");
		}
		System.out.println("nbserv : "+nbserv);
	}
	
	public void ajoutIndisponible(int r, int e){
		// Emplacement indisponible (capacité = -1, taille = -1)
		data[r][e] = new Serveur(-1, -1);
		nombre++;
		if(nombre==rangees*emplacements)
			full=true;
		
	}

	
	public void ajoutListeServeur(int taille, int capa){
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
	
	public boolean plus_de_possibilite(){
		for(Groupe g : groupes){
			if(g.Liste_Serveur.size()!=0)
				return false;
		}
		return true;
	}
	
	public void rangement1(){
		Collections.sort(listeServ);
		
		Groupe gr=null;
		
		for(Serveur s : listeServ){
			double min=-1;
			int i=0;
			for(Groupe g : groupes){
				
				if((g.getCapacite()<min)||(min==-1)){
					gr=g;
					min=g.getCapacite();
				}
			}
			gr.add(s);

		}
		
		for(Groupe g : groupes)
			System.out.println("Groupe de capacit� :"+g.getCapacite());
		while((!full)&&(!plus_de_possibilite())){
			double max=10000000;
			gr=null;
			for(Groupe g : groupes){
				if(g.Liste_Serveur.size()!=0){
				if(g.capacite()<=max){

					
					max=g.capacite();

					gr=g;
					
					
				}
				}
			}
			gr.affecte(this);
		}
		System.out.println("On arrete a cause du full ?"+full+" Ou plus de possibilit� "+plus_de_possibilite());
		
	}
	public void rangement2(){
		Collections.sort(listeServ);
		
		Groupe gr=null;
		
		for(Serveur s : listeServ){
			double min=-1;
			int i=0;
			for(Groupe g : groupes){
				
				if((g.getCapacite()<min)||(min==-1)){
					gr=g;
					min=g.getCapacite();
				}
			}
			gr.add(s);

		}
		
		for(Groupe g : groupes)
			System.out.println("Groupe de capacit� :"+g.getCapacite());
		while((!full)&&(!plus_de_possibilite())){
			double max=0;
			gr=null;
			for(Groupe g : groupes){
				if(g.Liste_Serveur.size()!=0){
				if(g.getRegret()>=max){

					
					max=g.getRegret();

					gr=g;
					
					
				}
				}
			}
			gr.affecte(this);
		}
		System.out.println("On arrete a cause du full ?"+full+" Ou plus de possibilit� "+plus_de_possibilite());
		
	}
	
	
	public double score(){
		double ret=-1;
		for(Groupe g : groupes){
			System.out.println("Minimum de ce groupe :"+g.capacite());
			if((g.capacite()<ret)||(ret==-1))
				ret=g.capacite();
		}
		return ret;
	}


}
	

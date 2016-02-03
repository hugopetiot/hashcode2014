public class Datacenter{
	int rangees, emplacements, emplacementsIndisponibles, groupes, serveurs;
	Serveur[][] data;
	
	
	public Datacenter(int r, int e, int ei, int g, int s){
		rangees = r;
		emplacements = e;
		emplacementsIndisponibles = ei;
		groupes = g;
		serveurs = s;
		data = new Serveur[rangees][emplacements];
		for(int i=0;i<rangees;i++){
			for(int j=0;i<emplacements;i++){
				data[i][j] = null;
			}
		}
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
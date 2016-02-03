public class Datacenter{
	int rangees, emplacements, emplacementsIndisponibles, groupes, serveurs;
	int[][] data;
	
	
	public Datacenter(int r, int e, int ei, int g, int s){
		rangees = r;
		emplacements = e;
		emplacementsIndisponibles = ei;
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
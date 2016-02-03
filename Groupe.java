import java.util.ArrayList;

public class Groupe {
	ArrayList<Serveur> Liste_Serveur;
	Serveur[][] organisation;
	int ligne;
	int dispo;
	
	public Groupe(int l,int d){
		Liste_Serveur= new ArrayList<Serveur>();
		organisation=new Serveur[l][d];
	}
	
	public double getRegret(){
		for(int i=0;i<Liste_Serveur.size();i++){
			if(!Liste_Serveur.get(i).place()){
				if(i!=Liste_Serveur.size()-1)
					return Liste_Serveur.get(i).getRatio();
				return Liste_Serveur.get(i).getRatio()-Liste_Serveur.get(i+1).getRatio();
			}
		}
		return -1;
	}
	double capacite(){
		double capacite=0;
		double tmp=0;
		for(int k=0; k<ligne;k++){
			tmp=0;
			for(int i=0;i<ligne;i++){
				if(i!=k){
					for(int j=0;j<dispo;j++){
						if (organisation[i][j]!=null){
							tmp=tmp+organisation[i][j].getCapacite();
							j=j+organisation[i][j].getTaille()-1;
						}
					}
				}
			}
			if(tmp>capacite)
				capacite=tmp;
		}
		return capacite;
	}
}

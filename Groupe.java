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

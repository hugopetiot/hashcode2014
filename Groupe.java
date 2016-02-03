import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Groupe {
	ArrayList<Serveur> Liste_Serveur;
	Serveur[][] organisation;
	int ligne;
	int dispo;
	
	public Groupe(int l,int d){
		Liste_Serveur= new ArrayList<Serveur>();
		organisation=new Serveur[l][d];
		for(int i=0;i<ligne;i++){
			for(int j=0;j<dispo;j++){
				organisation[i][j]=null;
			}
		}
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
	
	double getCapacite(){
		double ret=0;
		for(Serveur s : Liste_Serveur){
			ret=ret+s.getCapacite();
		}
		return ret;	
	}
	public void add(Serveur s){Liste_Serveur.add(s);}
	
	public void affecte(Datacenter d){
		int[] indice= ligne_inf();
		for(int i=0;i<ligne;i++){
			
			int j=0;
			int tmp=0;
			while(j<dispo){
				if(d.data[indice[i]][j]==null){
					tmp++;
					if(Liste_Serveur.get(0).getTaille()==tmp){
						for(int k=0;k<Liste_Serveur.get(0).getTaille();k++){
							d.data[indice[i]][j]=Liste_Serveur.get(0);
							organisation[indice[i]][j]=Liste_Serveur.get(0);
							Liste_Serveur.remove(0);
							return;
						}
					}
				}
				else{tmp=0;}	
			}				
		}
		Liste_Serveur.remove(0);				
	}
	
	public int[] ligne_inf(){
		double[] ret=new double[ligne];
		for(int i=0;i<ligne;i++){
			double tmp=0;
			for(int j=0;j<dispo;j++){
				tmp=tmp+organisation[i][j].getCapacite();
			}
			ret[i]=tmp;
		}
		int i, j;
	 
	    int[] cpt=new int[ligne];
	    int[] classement=new int[ligne];
	 
	    for (i=1; i<ligne; i++){
	      for (j=0; j<i; j++){
	    	  if(ret[i]>=ret[j])
	    		  cpt[i]++;
	    	  else
	    		  cpt[j]++;
	      }
	    }
	    for (i=0; i<ligne; i++) classement[cpt[i]]=i;
	    return classement;
		
	}

	
}

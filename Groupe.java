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
		ligne=l;
		dispo=d;
		organisation=new Serveur[l][d];
		
		for(int i=0;i<ligne;i++){
			for(int j=0;j<dispo;j++){
				organisation[i][j]=null;
			}
		}
	}
	
	public double getRegret(){
		
		if(Liste_Serveur.size()>1)
				return Liste_Serveur.get(0).getRatio()-Liste_Serveur.get(1).getRatio();
		if(Liste_Serveur.size()==1)
			return Liste_Serveur.get(0).getRatio();
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
		if( Liste_Serveur.size()==0)
			return;
		


		int[] indice= ligne_inf(d);

		for(int i=0;i<ligne;i++){
			int j=0;
			int tmp=0;


			while(j<dispo){

				if(d.data[indice[i]][j]==null){
					tmp++;
					if(Liste_Serveur.get(0).getTaille()==tmp){
						for(int k=0;k<Liste_Serveur.get(0).getTaille();k++){
							//System.out.println(j-k);
							d.data[indice[i]][j-k]=Liste_Serveur.get(0);
							organisation[indice[i]][j-k]=Liste_Serveur.get(0);
							
							

							
						}

						d.nombre=Liste_Serveur.get(0).getTaille()+d.nombre;
						if(d.nombre>=ligne*dispo)
							d.full=true;
						Liste_Serveur.remove(0);
						return;
					}
				}
				else{tmp=0;}
				j++;
			}				
		}
		Liste_Serveur.remove(0);				
	}
	
	public int[] ligne_inf(Datacenter d){


		double[] ret=new double[ligne];
		for(int i=0;i<ligne;i++){
			double tmp=0;
			for(int j=0;j<dispo;j++){
				if(d.data[i][j]!=null)
					tmp=tmp+d.data[i][j].getCapacite();
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
		for( i=0;i<ligne;i++){
			//System.out.print(classement[i]+" "+ret[classement[i]]+"\t");
		}
		//System.out.println();
			return classement;
		
	}

	
	
}

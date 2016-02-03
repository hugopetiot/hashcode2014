import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
	static Scanner in = new Scanner(System.in);

	public Datacenter loadData(File f){
		Datacenter datac = null;		
		int rangees, emplacements, emplacementsIndisponibles, groupes, serveurs;
		try {
			FileInputStream fis = new FileInputStream(f);
			in = new Scanner(fis);
			//2rangéesde5emplacements,1emplacementindisponible,2groupeset5serveurs.
			rangees = in.nextInt();
			emplacements= in.nextInt(); 
			emplacementsIndisponibles= in.nextInt(); 
			groupes= in.nextInt(); 
			serveurs= in.nextInt();
			
			datac = new Datacenter(rangees, emplacements, emplacementsIndisponibles, groupes, serveurs);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return datac;
	}
}

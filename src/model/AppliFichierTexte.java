package model;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


public class AppliFichierTexte {
	

	public static void fileWriter(Patient p) throws IOException {
		
		DateFormat format = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		Date date = new Date();
		          
		String nouvelleLigne = p.getNom()+" "+p.getPrenom()+" "+format.format(date).toString()+"\n";
		
		FileWriter fw = new FileWriter("hopital.txt", true);
		BufferedWriter bw = new BufferedWriter(fw);
		PrintWriter pw = new PrintWriter(bw);
		
		pw.append(nouvelleLigne);
		
		pw.close();
		
	}
}


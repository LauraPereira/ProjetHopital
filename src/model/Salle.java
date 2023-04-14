package model;

import java.util.ArrayList;

public class Salle {

	private int id;
	private Medecin med;
	private static ArrayList<Visite> lstVisite = new ArrayList<Visite>();

	public Salle(int id, Medecin med) {
		super();
		this.id = id;
		this.med = med;
		this.lstVisite = lstVisite;
	}

	public ArrayList<Visite> getLstVisite() {
		return lstVisite;
	}

	public void addVisite(Visite v) {
		lstVisite.add(v);
	}

	public void viderLst() {
		lstVisite.clear();
	}

}

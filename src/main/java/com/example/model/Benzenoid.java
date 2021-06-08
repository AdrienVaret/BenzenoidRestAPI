package com.example.model;

public class Benzenoid {

	private Long id;
	
	private String name;
	
	private int nbHexagons;
	
	private int nbCarbons;
	
	private int nbHydrogens;
	
	private double irregularity;

	public Benzenoid() { }
	
	public Benzenoid(Long id, String name, int nbHexagons, int nbCarbons, int nbHydrogens, double irregularity) {

		this.id = id;
		this.name = name;
		this.nbHexagons = nbHexagons;
		this.nbCarbons = nbCarbons;
		this.nbHydrogens = nbHydrogens;
		this.irregularity = irregularity;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public int getNbHexagons() {
		return nbHexagons;
	}

	public int getNbCarbons() {
		return nbCarbons;
	}

	public int getNbHydrogens() {
		return nbHydrogens;
	}

	public double getIrregularity() {
		return irregularity;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setNbHexagons(int nbHexagons) {
		this.nbHexagons = nbHexagons;
	}

	public void setNbCarbons(int nbCarbons) {
		this.nbCarbons = nbCarbons;
	}

	public void setNbHydrogens(int nbHydrogens) {
		this.nbHydrogens = nbHydrogens;
	}

	public void setIrregularity(double irregularity) {
		this.irregularity = irregularity;
	}
}

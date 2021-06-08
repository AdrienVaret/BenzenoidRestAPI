package com.example.model;

public class BenzenoidData {

	private Long id;

	private String name;

	private int nbHexagons;

	private int nbCarbons;

	private int nbHydrogens;

	private double irregularity;

	private String operatorId;

	private String operatorName;

	private String operatorHexagons;

	private String operatorCarbons;

	private String operatorHydrogens;

	private String operatorIrregularity;

	public BenzenoidData() {

	}

	public BenzenoidData(Long id, String name, int nbHexagons, int nbCarbons, int nbHydrogens, double irregularity,
			String operatorId, String operatorName, String operatorHexagons, String operatorCarbons,
			String operatorHydrogens, String operatorIrregularity) {

		this.id = id;
		this.name = name;
		this.nbHexagons = nbHexagons;
		this.nbCarbons = nbCarbons;
		this.nbHydrogens = nbHydrogens;
		this.irregularity = irregularity;
		this.operatorId = operatorId;
		this.operatorName = operatorName;
		this.operatorHexagons = operatorHexagons;
		this.operatorCarbons = operatorCarbons;
		this.operatorIrregularity = operatorIrregularity;
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

	public String getOperatorId() {
		return operatorId;
	}

	public String getOperatorName() {
		return operatorName;
	}

	public String getOperatorHexagons() {
		return operatorHexagons;
	}

	public String getOperatorCarbons() {
		return operatorCarbons;
	}

	public String getOperatorHydrogens() {
		return operatorHydrogens;
	}

	public String getOperatorIrregularity() {
		return operatorIrregularity;
	}

}

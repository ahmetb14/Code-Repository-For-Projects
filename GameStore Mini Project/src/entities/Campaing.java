package entities;

import abstracts.Entity;

public class Campaing implements Entity {

	private int id;
	private String campaingName;
	private double campaingDiscountRate;

	public Campaing(int id, String campaingName, double campaingDiscountRate) {

		this.id = id;
		this.campaingName = campaingName;
		this.campaingDiscountRate = campaingDiscountRate;

	}

	public int getId() {

		return id;
	}

	public void setId(int id) {

		this.id = id;
	}

	public String getCampaingName() {

		return campaingName;
	}

	public void setCampaingName(String campaingName) {

		this.campaingName = campaingName;
	}

	public double getCampaingDiscountRate() {

		return campaingDiscountRate;
	}

	public void setCampaingDiscountRate(double campaingDiscountRate) {

		this.campaingDiscountRate = campaingDiscountRate;
	}

}

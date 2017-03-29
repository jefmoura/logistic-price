package logistic.price.product;

public class Package {

	private double width;
	private double length;
	private double height;
	private double weight;
	private double normalizedWeight;
	
	public Package() {}

	public Package(double width, double length, double height, double weight) {

		this.width = width;
		this.length = length;
		this.height = height;
		this.weight = weight/1000;
		this.normalizedWeight = calcNormalizedWeight();
	}

	public double getNormalizedWeight() {
		return normalizedWeight;
	}

	/*
	 * Volumetric weight is a formula applied by carriers to take into account
	 * volume as a function of weight
	 */
	public double calcVolumetricWeight() {

		double volWeight = (width * length * height) / 5000;

		return volWeight;
	}

	/*
	 * The greater value of an actual weight or a volumetric weight
	 */
	public double calcNormalizedWeight() {

		double volWeight;
		double normalized;

		volWeight = this.calcVolumetricWeight();
		if (weight > volWeight) {
			normalized = weight;
		} else {
			normalized = volWeight;
		}
		
		return Math.ceil(normalized * 2) / 2.0;
	}

}

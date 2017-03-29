package product.logistic.price;

import static org.junit.Assert.*;

import org.junit.Test;

public class PackageTest {

	@Test
	public void testVolumetricWeight() {
		// Check volumetric weight is used in normalized weight
		double width = 26.0;
		double length = 10.0;
		double height = 11.0;
		double weight = 400.0;
		double volumetricWeight;
		Package pack = new Package(width, length, height, weight);

		volumetricWeight = pack.calcVolumetricWeight();
		assertEquals(volumetricWeight, 1.0, 0.00);
		assertEquals(pack.getNormalizedWeight(), 1.0, 0.00);
	}

	@Test
	public void testNormalWeight1() {
		// Check normal weight is used in normalized weight
		double width = 5.0;
		double length = 6.0;
		double height = 7.0;
		double weight = 1200.0;
		double volumetricWeight;
		Package pack = new Package(width, length, height, weight);

		volumetricWeight = pack.calcVolumetricWeight();
		assertEquals(volumetricWeight, 1.0, 0.00);
		assertEquals(pack.getNormalizedWeight(), 1.2, 0.00);
	}

	@Test
	public void testNormalWeight2() {
		// Check normal weight is used in normalized weight
		double width = 6.0;
		double length = 10.0;
		double height = 8.0;
		double weight = 1233.0;
		double volumetricWeight;
		Package pack = new Package(width, length, height, weight);

		volumetricWeight = pack.calcVolumetricWeight();
		assertEquals(volumetricWeight, 1.0, 0.00);
		assertEquals(pack.getNormalizedWeight(), 1.233, 0.00);
	}

}

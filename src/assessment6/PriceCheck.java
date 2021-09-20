package assessment6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

public class PriceCheck {
	/**
	 * You have an old grocery shop that instead of scanning their sold proudcts
	 * once sold, they type in the prices, which leaves room for mistyping sold
	 * prices. Given 4 lists: soldItems = ['eggs', 'milk', 'apple'], soldPrices =
	 * [1.00, 2.50, 2.1], productsAvailable = ['eggs', 'lemons', 'milk', 'apple'],
	 * productPrices = [1.01, 0.5, 2.50, 2.1], Find the number of items with
	 * mistyped prices
	 */

	@Test
	public void test1() {
		List<String> products = new ArrayList<>(Arrays.asList("eggs", "milk", "cheese"));
		List<Float> productPrices = new ArrayList<>(Arrays.asList((float) 2.89, (float) 3.29, (float) 5.79));
		List<String> productSold = new ArrayList<>(Arrays.asList("eggs", "eggs", "cheese", "milk"));
		List<Float> soldPrice = new ArrayList<>(Arrays.asList((float) 2.89, (float) 2.99, (float) 5.97, (float) 3.29));

		Assert.assertEquals(2, priceCheck(products, productPrices, productSold, soldPrice));
	}

	private static int priceCheck(List<String> products, List<Float> productPrices, List<String> productSold,
			List<Float> soldPrice) {
		int count = 0;

		HashMap<String, Float> itemMap = new HashMap<String, Float>();
		HashMap<String, Float> soldMap = new HashMap<String, Float>();
		List<String> itemPrice = new ArrayList<String>();

		for (int i = 0; i < products.size(); i++) {
			itemMap.put(products.get(i), productPrices.get(i));
		}

		for (int i = 0; i < products.size(); i++) {
			soldMap.put(productSold.get(i), soldPrice.get(i));
		}
		for (Map.Entry<String, Float> newEntry : soldMap.entrySet()) {
			if (!newEntry.getValue().equals(itemMap.get(newEntry.getKey()))) {
				count++;
			}
		}
		return count;

	}
}

package basic;

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
		List<String> productSold = new ArrayList<>(Arrays.asList("eggs", "milk", "apple"));
		List<Float> soldPrice = new ArrayList<>(Arrays.asList((float) 1.00, (float) 2.50, (float) 2.1));
		List<String> products = new ArrayList<>(Arrays.asList("eggs", "milk", "lemons", "apple"));
		List<Float> productPrices = new ArrayList<>(Arrays.asList((float) 1.01, (float) 2.50, (float) 0.5, (float) 2.1));

		Assert.assertEquals(1, priceCheck(products, productPrices, productSold, soldPrice));
	}

	private static int priceCheck(List<String> products, List<Float> productPrices, List<String> productSold,
			List<Float> soldPrice) {
		int count = 0;
		Map<String, Float> itemMap = new HashMap<String, Float>();
		Map<String, Float> soldMap = new HashMap<String, Float>();
		
		for (int i = 0; i < products.size(); i++) {
			itemMap.put(products.get(i), productPrices.get(i));
		}
		for (int i = 0; i < productSold.size(); i++) {
			soldMap.put(productSold.get(i), soldPrice.get(i));
		}
		for(Map.Entry<String, Float> map:soldMap.entrySet()) {
			if(!map.getValue().equals(itemMap.get(map.getKey())))
					count++;
		}
		return count;

	}
}

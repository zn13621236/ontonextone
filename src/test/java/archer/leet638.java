package archer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

class leet638 {

	@Test
	void test() {
		List<Integer> price = Arrays.asList(2, 5);
		List<Integer> offer1 = Arrays.asList(3, 0 , 5);
		List<Integer> offer2 = Arrays.asList(1, 2 , 10);
		List<List<Integer>> aList = new ArrayList<>();
		aList.add(offer1);
		aList.add(offer2);
		List<Integer> needs = Arrays.asList(3, 2);
		
		shoppingOffers(price,aList, needs);
	}

	public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
		int n = price.size();
		int result = 0;
		for (int i = 0; i < n; i++) {
			result += price.get(i) * needs.get(i);
		}

		for (List<Integer> offer : special) {
			boolean isValid = true;
			for (int i = 0; i < n; i++) {
				if (needs.get(i) - offer.get(i) < 0) {
					isValid = false;
				}

				needs.set(i, needs.get(i) - offer.get(i));
			}
			if (isValid) {
				result = Math.min(result, shoppingOffers(price, special, needs) + offer.get(offer.size() - 1));
			}

			for (int i = 0; i < n; i++) {
				needs.set(i, needs.get(i) + offer.get(i));
			}
		}
		return result;
	}
}

package Searching;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BurgerProblem implements Ingredients {

    public static boolean canPrepareBurger(long burgerCount, Map<String, Integer> ingredientMap,
            Map<String, Integer> ingredientInStock, Map<String, Integer> ingredientPrice, long amountInHand) {

        long diff = ingredientInStock.get(BREAD) - (ingredientMap.get(BREAD) * burgerCount);
        if (diff < 0) {
            amountInHand += ingredientPrice.get(BREAD) * diff;
        }
        diff = ingredientInStock.get(SAUCE) - (ingredientMap.get(SAUCE) * burgerCount);
        if (diff < 0) {
            amountInHand += ingredientPrice.get(SAUCE) * diff;
        }
        diff = ingredientInStock.get(CHEESE) - (ingredientMap.get(CHEESE) * burgerCount);
        if (diff < 0) {
            amountInHand += ingredientPrice.get(CHEESE) * diff;
        }

        return amountInHand >= 0;

    }

    public static long performBinarySearch(Map<String, Integer> ingredientMap, Map<String, Integer> ingredientInStock,
            Map<String, Integer> ingredientPrice, long amountInHand) {
        int count = 0;
        for (int value : ingredientInStock.values()) {
            count = Math.max(count, value);
        }
        long low = 1;
        long high = count + amountInHand;
        while (low <= high) {
            long mid = (low + high) / 2;
            if (!canPrepareBurger(mid, ingredientMap, ingredientInStock, ingredientPrice, amountInHand)) {
                high = mid - 1;
            } else {
                if (!canPrepareBurger(mid + 1, ingredientMap, ingredientInStock, ingredientPrice, amountInHand)) {
                    return mid;
                } else {
                    low = mid + 1;
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] tempIpString = br.readLine().split(" ");
        Map<String, Integer> ingredientMap = new HashMap<>();
        int burgerCount = 0;
        int sauceCount = 0;
        int cheeseCount = 0;
        for (char c : tempIpString[0].toCharArray()) {
            if (c == 'B') {
                burgerCount++;
            } else if (c == 'S') {
                sauceCount++;
            } else if (c == 'C') {
                cheeseCount++;
            }
        }
        ingredientMap.put(BREAD, burgerCount);
        ingredientMap.put(SAUCE, sauceCount);
        ingredientMap.put(CHEESE, cheeseCount);

        tempIpString = br.readLine().split(" ");
        Map<String, Integer> ingredientInStock = new HashMap<>();
        ingredientInStock.put(BREAD, Integer.parseInt(tempIpString[0]));
        ingredientInStock.put(SAUCE, Integer.parseInt(tempIpString[1]));
        ingredientInStock.put(CHEESE, Integer.parseInt(tempIpString[2]));

        tempIpString = br.readLine().split(" ");
        Map<String, Integer> ingredientPrice = new HashMap<>();
        ingredientPrice.put(BREAD, Integer.parseInt(tempIpString[0]));
        ingredientPrice.put(SAUCE, Integer.parseInt(tempIpString[1]));
        ingredientPrice.put(CHEESE, Integer.parseInt(tempIpString[2]));

        long amountInHand = Long.parseLong(br.readLine());
        System.out.println(performBinarySearch(ingredientMap, ingredientInStock, ingredientPrice, amountInHand));
    }

}

interface Ingredients {
    public final String BREAD = "BREAD";
    public final String SAUCE = "SAUCE";
    public final String CHEESE = "CHEESE";
}

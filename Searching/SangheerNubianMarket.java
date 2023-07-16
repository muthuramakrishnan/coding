package Searching;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class SangheerNubianMarket {
    public static boolean canBuy(int[] basePrice, int coins, int budget) {
        long price = 0l;
        int numSov = basePrice.length;
        if (coins > numSov) {
            return false;
        }
        long[] prices = new long[numSov];
        for (int i = 0; i < numSov; i++) {
            prices[i] = (long) basePrice[i] + ((long) coins * (long) (i + 1));
        }
        Arrays.sort(prices);
        for (int i = 0; i < coins; i++) {
            price += prices[i];
        }
        if (price > budget) {
            return false;
        }
        return true;
    }

    public static int binarySearch(int[] basePrice, int budget) {
        int numSov = basePrice.length;
        int low = 1;
        int high = numSov;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (!canBuy(basePrice, mid, budget)) {
                high = mid - 1;
            } else {
                if (!canBuy(basePrice, mid + 1, budget)) {
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
        int numSov = Integer.parseInt(tempIpString[0]);
        int budget = Integer.parseInt(tempIpString[1]);
        int[] basePrice = new int[numSov];
        tempIpString = br.readLine().split(" ");
        for (int i = 0; i < numSov; i++) {
            basePrice[i] = Integer.parseInt(tempIpString[i]);
        }
        int numCoinsCanBuy = binarySearch(basePrice, budget);
        long totalAmtSpent = 0;
        long[] prices = new long[numSov];
        for (int i = 0; i < numSov; i++) {
            prices[i] = (long) basePrice[i] + ((long) numCoinsCanBuy * (long) (i + 1));
        }
        Arrays.sort(prices);
        for (int i = 0; i < numCoinsCanBuy; i++) {
            totalAmtSpent += prices[i];
        }
        System.out.println(numCoinsCanBuy + " " + totalAmtSpent);
    }
}
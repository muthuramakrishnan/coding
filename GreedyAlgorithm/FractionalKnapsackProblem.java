import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class FractionalKnapsackProblem {

    private static class ItemDetail {
        int value, weight;
        double valueToWeightRatio;

        ItemDetail(int value, int weight, double valueToWeightRatio) {
            this.value = value;
            this.weight = weight;
            this.valueToWeightRatio = valueToWeightRatio;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");

        int n = Integer.parseInt(s[0]);
        int totalCapacity = Integer.parseInt(s[1]);

        ItemDetail[] myItems = new ItemDetail[n];
        for (int i = 0; i < n; i++) {
            s = br.readLine().split(" ");
            int value = Integer.parseInt(s[0]);
            int weight = Integer.parseInt(s[1]);
            double valueToWeightRatio = (double) value / weight;
            myItems[i] = new ItemDetail(value, weight, valueToWeightRatio);
        }

        Arrays.sort(myItems, (a, b) -> {
            double sortType = b.valueToWeightRatio - a.valueToWeightRatio;
            return sortType < 0 ? -1 : sortType > 0 ? 1 : 0;
        });

        double currBagWeight = 0;
        double currBagValue = 0;
        for (int i = 0; i < n; i++) {
            if (currBagWeight + myItems[i].weight <= totalCapacity) {
                currBagValue += myItems[i].value;
                currBagWeight += myItems[i].weight;
            } else {
                double capAvailable = totalCapacity - currBagWeight;
                double reductionFactor = 1 / (myItems[i].weight / capAvailable);
                currBagValue += (reductionFactor * myItems[i].value);
                break;
            }
        }
        System.out.println(currBagValue);
    }
}

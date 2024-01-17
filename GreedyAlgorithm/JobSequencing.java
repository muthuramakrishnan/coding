import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class JobSequencing {

    private static class Job {
        int deadline;
        int profit;

        Job(int deadline, int profit) {
            this.deadline = deadline;
            this.profit = profit;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");

        int n = Integer.parseInt(s[0]);
        Job[] jobs = new Job[n];
        for (int i = 0; i < n; i++) {
            s = br.readLine().split(" ");
            jobs[i] = new Job(Integer.parseInt(s[0]), Integer.parseInt(s[1]));
        }

        // sort it by max profit;
        Arrays.sort(jobs, (a, b) -> {
            return b.profit - a.profit;
        });
        // n = totalDays;
        // do the work as late as possible
        int[] profitDays = new int[n + 1];
        int maxProfit = 0;
        for (int i = 0; i < n; i++) {
            int lastDay = Math.min(jobs[i].deadline, n);
            for (int j = lastDay; j >= 1; j--) {
                if (profitDays[j] == 0) {
                    profitDays[j] = jobs[i].profit;
                    maxProfit += profitDays[j];
                    break;
                }
            }
        }
        System.out.println(maxProfit);
    }
}

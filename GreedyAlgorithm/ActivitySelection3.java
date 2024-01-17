import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class ActivitySelection3 {
    private static class Activity {
        int startTime;
        int endTime;

        Activity(int startTime, int endTime) {
            this.startTime = startTime;
            this.endTime = endTime;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");

        int n = Integer.parseInt(s[0]);
        int k = Integer.parseInt(s[1]);
        Activity[] activities = new Activity[n];
        for (int i = 0; i < n; i++) {
            s = br.readLine().split(" ");
            activities[i] = new Activity(Integer.parseInt(s[0]), Integer.parseInt(s[1]));
        }

        Arrays.sort(activities, (a, b) -> {
            return a.endTime - b.endTime;
        });

        List<Integer> endTimeList = new ArrayList<>(IntStream.of(new int[k]).boxed().toList());
        int activiesAssigned = 0;
        for (int i = 0; i < n; i++) {
            Activity activity = activities[i];

            int bestEndTime = 0;
            int bestEndTimeIdx = -1;
            for (int j = 0; j < endTimeList.size(); j++) {
                int currEndTime = endTimeList.get(j);
                if (activity.startTime >= currEndTime && bestEndTime <= currEndTime) {
                    bestEndTime = currEndTime;
                    bestEndTimeIdx = j;
                }
            }
            if (bestEndTimeIdx != -1) {
                endTimeList.set(bestEndTimeIdx, activity.endTime);
                activiesAssigned++;
            }
        }
        System.out.println(activiesAssigned);
    }
}

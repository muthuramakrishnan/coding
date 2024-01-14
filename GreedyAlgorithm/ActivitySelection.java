import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class ActivitySelection {
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
        Activity[] activity = new Activity[n];
        for (int i = 0; i < n; i++) {
            s = br.readLine().split(" ");
            int startTime = Integer.parseInt(s[0]);
            int endTime = Integer.parseInt(s[1]);
            activity[i] = new Activity(startTime, endTime);
        }

        Arrays.sort(activity, (a, b) -> {
            return a.endTime - b.endTime;
        });

        int lastChosenEndTime = 0;
        int totalActivitiesChosen = 0;
        for (int i = 0; i < n; i++) {
            if (activity[i].startTime >= lastChosenEndTime) {
                totalActivitiesChosen++;
                lastChosenEndTime = activity[i].endTime;
            }
        }
        System.out.println(totalActivitiesChosen);
    }
}

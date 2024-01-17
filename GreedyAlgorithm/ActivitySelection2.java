import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class ActivitySelection2 {
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

        int lastEndTime1 = 0;
        int lastEndTime2 = 0;
        int person1Task = 0;
        int person2Task = 0;
        for (int i = 0; i < n; i++) {
            if (activity[i].startTime >= lastEndTime1 && activity[i].startTime >= lastEndTime2) {
                if (lastEndTime1 > lastEndTime2) {
                    lastEndTime1 = activity[i].endTime;
                    person1Task++;
                } else {
                    lastEndTime2 = activity[i].endTime;
                    person2Task++;
                }
            } else if (activity[i].startTime >= lastEndTime1) {
                lastEndTime1 = activity[i].endTime;
                person1Task++;
            } else if (activity[i].startTime >= lastEndTime2) {
                lastEndTime2 = activity[i].endTime;
                person2Task++;
            }
        }
        System.out.println(person1Task + person2Task);
    }
}

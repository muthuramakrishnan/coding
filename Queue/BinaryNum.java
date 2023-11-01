package Queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BinaryNum {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().strip());

        StringBuilder str = new StringBuilder("");
        while (n != 0) {
            str = str.insert(0, n % 2);
            n = n / 2;
        }
        System.out.println(str);
    }
}

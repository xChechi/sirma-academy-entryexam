import java.util.Scanner;

public class CountingOrcs {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = Integer.parseInt(sc.nextLine());
        int increase = Integer.parseInt(sc.nextLine());
        int hour = Integer.parseInt(sc.nextLine());

        int totalOrcs = 0;

        for (int i = 0; i < hour; i++) {
            int currentOrcs;
            if (i == 0) {
                currentOrcs = count;
            } else currentOrcs = count + i * increase;
            totalOrcs += currentOrcs;
        }

        System.out.println(totalOrcs);
    }
}
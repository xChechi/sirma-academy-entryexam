import java.util.Scanner;

public class ArchiveSearch {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String keyword = sc.nextLine();

        String[] archive = input.split(",");
        int firstOccur = -1;
        int lastOccur = -1;

        for (int i = 0; i < archive.length; i++) {
            if (archive[i].trim().equals(keyword)) {
                if (firstOccur == -1) {
                    firstOccur = i;
                }
                lastOccur = i;
            }
        }

        if (firstOccur != -1) {
            System.out.println("First Occurrence: " + firstOccur);
            System.out.println("Last Occurrence: " + lastOccur);
        } else {
            System.out.println("Record not found");
        }
    }
}

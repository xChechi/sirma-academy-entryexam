import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class CavalryFormation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] input = sc.nextLine().split(", ");
        List<Integer> formation = new ArrayList<>();
        for (String rider : input) {
            formation.add(Integer.parseInt(rider));
        }

        List<String> output = new ArrayList<>();
        List<Integer> previousFormation = new ArrayList<>(formation);
        boolean centerCommandLast = false;
        boolean endCommandEncountered = false;
        while (true) {
            if (endCommandEncountered) {
                break;
            }
            if (!sc.hasNextLine()) {
                break;
            }
            String command = sc.nextLine();
            String[] parts = command.split(" ");
            if (command.equals("end")) {
                endCommandEncountered = true;
                if (!centerCommandLast) {
                    break;
                }
            }
            switch (parts[0]) {
                case "destroy":
                    int destroyIndex = Integer.parseInt(parts[1]);
                    if (destroyIndex >= 0 && destroyIndex < formation.size()) {
                        formation.remove(destroyIndex);
                    }
                    break;
                case "swap":
                    int index1 = Integer.parseInt(parts[1]);
                    int index2 = Integer.parseInt(parts[2]);
                    if (index1 >= 0 && index1 < formation.size() && index2 >= 0 && index2 < formation.size()) {
                        Collections.swap(formation, index1, index2);
                    }
                    break;
                case "add":
                    int newRider = Integer.parseInt(parts[1]);
                    formation.add(newRider);
                    break;
                case "insert":
                    int insertIndex = Integer.parseInt(parts[2]);
                    if (insertIndex >= 0 && insertIndex <= formation.size()) {
                        int riderID = Integer.parseInt(parts[1]);
                        formation.add(insertIndex, riderID);
                    }
                    break;
                case "center":
                    int centerStart = (formation.size() - 1) / 2;
                    int centerEnd = formation.size() / 2;
                    if (formation.size() % 2 == 0) {
                        output.add(formation.get(centerStart) + " " + formation.get(centerEnd));
                    } else {
                        output.add(formation.get(centerStart).toString());
                    }
                    centerCommandLast = true;
                    if (endCommandEncountered) {
                        break;
                    }
                    break;
                default:
                    break;
            }

            if (!parts[0].equals("center")) {
                String currentFormation = joinFormation(formation);
                if (!currentFormation.equals(joinFormation(previousFormation))) {
                    output.add(currentFormation);
                    previousFormation = new ArrayList<>(formation);
                }
            }
        }

        for (String line : output) {
            System.out.println(line);
        }
    }

    private static String joinFormation(List<Integer> formation) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < formation.size(); i++) {
            builder.append(formation.get(i));
            if (i < formation.size() - 1) {
                builder.append(" ");
            }
        }
        return builder.toString();
    }
}
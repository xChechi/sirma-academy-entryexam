import java.util.Scanner;

public class CouncilVotes {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        String[] votes = input.split(",");
        int yesVote = 0;
        int noVote = 0;
        int abstainVote = 0;

        for (String vote : votes) {
            switch (vote.trim()) {
                case "Yes" -> yesVote++;
                case "No" -> noVote++;
                case "Abstain" -> abstainVote++;
            }
        }

        if (yesVote > noVote && yesVote > abstainVote) {
            System.out.println("Yes");
        } else if (noVote > yesVote && noVote > abstainVote) {
            System.out.println("No");
        } else if (abstainVote > yesVote && abstainVote > noVote) {
            System.out.println("Abstain");
        } else System.out.println("Tie");
    }
}

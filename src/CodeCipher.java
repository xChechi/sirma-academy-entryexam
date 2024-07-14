import java.util.Scanner;

public class CodeCipher {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        if (input.isEmpty() || input.length() > 100) {
            return;
        }
        int number = Integer.parseInt(sc.nextLine());
        if (number < 1 || number > 25) {
            return;
        }

        StringBuilder output = new StringBuilder();

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            char decrypted = c;

            if (Character.isLowerCase(c)) {
                decrypted = (char) (c - number);
                if (decrypted < 'a') {
                    decrypted += 26;
                }
                } else if (Character.isUpperCase(c)) {
                    decrypted = (char) (c - number);
                    if (decrypted < 'A') {
                        decrypted += 26;
                   }
                }

            if (!Character.isLetter(c)) {
                decrypted = (char) (c - number);
                if (decrypted < ' ') {
                    decrypted += 33;
                }
            }
            output.append(decrypted);
        }
        System.out.println(output);

    }
}

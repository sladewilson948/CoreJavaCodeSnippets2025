package something;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GenerateValidCards {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Welcome to my application");
        System.out.println("Let's make some valid cards!!");

        System.out.print("Enter the amount of card numbers you want to generate: ");
        int n = input.nextInt();

        Instant start = Instant.now();
        List<String> cards = makeNValidCardNumbers(n);
        writeCardsToFile(cards);
        Instant end = Instant.now();

        System.out.println("Added " + n + " cards in text file");
        System.out.println("Time taken: " + Duration.between(start, end).toSeconds() + " seconds");
        input.close();
    }

    public static List<String> makeNValidCardNumbers(int n) {
        List<String> validCards = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            validCards.add(generateValidCardNumber());
        }
        return validCards;
    }

    public static String generateValidCardNumber() {
        int[] digits = new int[15];
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 15; i++) {
            digits[i] = (int) (Math.random() * 10);
            sb.append(digits[i]);
            if (i == 3 || i == 7 || i == 11) sb.append(" ");
        }

        // Compute Luhn check digit
        int sum = 0;
        for (int i = 14; i >= 0; i--) {
            int digit = digits[i];
            if ((14 - i) % 2 == 0) { // double every second digit from right
                digit *= 2;
                if (digit > 9) digit -= 9;
            }
            sum += digit;
        }

        int checkDigit = (10 - (sum % 10)) % 10;
        sb.append(checkDigit);

        return sb.toString();
    }

    public static void writeCardsToFile(List<String> cardNumbers) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("card.txt"))) {
            writer.write("Adding " + cardNumbers.size() + " card numbers to file\n");
            for (String card : cardNumbers) {
                writer.write(card);
                writer.newLine();
            }
        } catch (IOException e) {
            System.err.println("Something went wrong while writing to file.");
            e.printStackTrace();
        }
    }
}
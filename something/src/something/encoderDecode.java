package something;

import java.util.*;

public class encoderDecode {

    private Map<String, String> encodedToOriginal = new HashMap<>();

    public String encodeString(String textVal) {
        Map<Character, Integer> freqMap = new LinkedHashMap<>();
        StringBuilder sb = new StringBuilder();

        String cleanText = textVal.replace(" ", "").toLowerCase();

        for (char ch : cleanText.toCharArray()) {
            freqMap.put(ch, freqMap.getOrDefault(ch, 0) + 1);
        }

        for (Map.Entry<Character, Integer> entry : freqMap.entrySet()) {
            sb.append(entry.getKey()).append(entry.getValue());
        }

        encodedToOriginal.put(sb.toString(), textVal);
        return sb.toString();
    }

    public String decodeString(String encodedVal) {
        return encodedToOriginal.getOrDefault(encodedVal, "You have not encoded this in the first place!");
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        encoderDecode obj = new encoderDecode();
        System.out.println("Welcome to my encoding and decoding service");

        while (true) {
            System.out.println("\nTo encode a string press 1");
            System.out.println("To decode a string press 2");
            System.out.print("Enter option: ");
            int option = input.nextInt();
            input.nextLine(); // Consume newline

            switch (option) {
                case 1:
                    System.out.print("Enter the string you want to encode: ");
                    String toEncode = input.nextLine();
                    System.out.println("Encoded string: " + obj.encodeString(toEncode));
                    break;
                case 2:
                    System.out.print("Enter the string you want to decode: ");
                    String toDecode = input.nextLine();
                    System.out.println("Decoded string: " + obj.decodeString(toDecode));
                    break;
                default:
                    System.out.println("Invalid option!");
            }

            System.out.print("Do you want to continue? (yes/no): ");
            String ans = input.nextLine();
            if (ans.equalsIgnoreCase("no")) break;
        }

        input.close();
    }
}
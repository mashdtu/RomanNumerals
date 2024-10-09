import java.util.Scanner;

public class RomanNumerals {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        System.out.print("Enter positive integer to convert: ");
        try {
            System.out.print(romanFactors(Integer.parseInt(console.next())));
        } catch (Exception e) {
            System.out.println("Error: enter an integer");
        }
        console.close();
    }

    private static String romanFactors (int n) {
        if (n > 3999 || n < 1) { return "Error: enter a number between 1 and 3999"; }
        int[] chart = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String romanNumerals = new String();

        while (n > 0) {
            for (int k : chart) {
                if (n >= k) {
                    romanNumerals += arabicToRoman(k);
                    n -= k;
                    break;
                }
            }
        }
        return romanNumerals;
    }

    private static String arabicToRoman (int f) {
        return switch (f) {
            case 1000 -> "M";
            case 900 -> "CM";
            case 500 -> "D";
            case 400 -> "CD";
            case 100 -> "C";
            case 90 -> "XC";
            case 50 -> "L";
            case 40 -> "XL";
            case 10 -> "X";
            case 9 -> "IX";
            case 5 -> "V";
            case 4 -> "IV";
            case 1 -> "I";
            default -> "";
        };
    }
}
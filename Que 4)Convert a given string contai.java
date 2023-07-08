Que 4)Convert a given string containing real number into its float equivalent. In a way you will be implementing the wrapper class function to parse float value. Do not use any float parsing function of a class.
	 	if the given string is 12.34 it will return an float value of 12.34.

public class CustomFloatParser {
    public static void main(String[] args) {
        String str = "-12.34"; // Example input
        float result = parseFloat(str);
        System.out.println("Parsed Float: " + result);
    }

    public static float parseFloat(String str) {
        int startIndex = 0;
        int sign = 1;

        // Check for a leading minus sign for negative numbers
        if (str.charAt(0) == '-') {
            sign = -1;
            startIndex = 1;
        }

        float result = 0;
        float decimalPlace = 0.1f;

        // Convert the digits and decimal part to a float
        for (int i = startIndex; i < str.length(); i++) {
            char c = str.charAt(i);

            if (c == '.') {
                decimalPlace = 0.1f;
                continue;
            }

            int digit = c - '0'; // Convert char to int
            if (decimalPlace == 0.1f) {
                result = result * 10 + digit;
            } else {
                result = result + digit * decimalPlace;
                decimalPlace *= 0.1f;
            }
        }

        return result * sign;
    }
}

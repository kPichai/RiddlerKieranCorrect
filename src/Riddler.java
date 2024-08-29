/**
 * The Riddler:
 * A puzzle by Zach Blick
 * for Adventures in Algorithms
 * At Menlo School in Atherton, CA
 *
 * Completed by: Kieran Pichai
 */
public class Riddler {

    // Method that determines the shift of the character if it's alphabetic, accounts for wrapping
    public int determineShift(char x) {
        char shifting_base;

        // determines if the char is lower or upper case
        if (Character.isLowerCase(x)) {

            // sets the shifting base to lowercase 'a' which is the start of the alphabet for that ASCII segment
            shifting_base = 'a';
        } else {

            // sets the shifting base to uppercase 'a' which is the start of the alphabet for that ASCII segment
            shifting_base = 'A';
        }

        // Calculates the shift and also accounts for a wrap around by using modulus
        int shifted = (x - shifting_base + 9) % 26;

        // Returns the final ASCII value of the shifted char
        return shifting_base + shifted;
    }

    // Method that decodes problem one, shifts alphabetic chars by 9
    public String decryptOne(String encrypted) {
        String decrypted = "";

        // Loop that goes through the encrypted string
        for (char x : encrypted.toCharArray()) {

            // Checks if the current char is a letter or a symbol (a ',' for example)
            if (Character.isLetter(x)) {

                // If it's a letter then it calculates the new ASCII value given the 9 ASCII value shift
                decrypted += (char)(determineShift(x));
            } else {

                // If it's not a letter then it simply appends it to the decrypted string with no shift
                decrypted += x;
            }
        }

        // Returns the final decrypted string for problem 1
        return decrypted;
    }

    // Method that decodes problem 2, numerical representation of ASCII values
    public String decryptTwo(String encrypted) {
        String decrypted = "";

        // Generic integer that keeps track the current ASCII int being read in
        int cur_ascii = 0;

        // Loops through the encrypted string of ints and spaces
        for (int i = 0; i < encrypted.length() - 1; i++) {

            // Checks if the current char is a space
            if (encrypted.charAt(i) == ' ') {

                // If it is, then it appends to the decrypted string the current value stored in cur_ascii
                decrypted += (char)cur_ascii;

                // Resets cur_ascii to read in the next int
                cur_ascii = 0;

                // Continues to next loop iteration so it doesn't read in another int by mistake
                continue;
            }

            // Checks if there is still another digit of the current int to be read
            if (Character.isDigit(encrypted.charAt(i+1))) {

                // If there is then it subtracts 48 (which is the shift from 0 to the ASCII value of 0)
                cur_ascii += (int)encrypted.charAt(i) - 48;

                // Also multiplies by 10 to add a 0 to the end so when the next int is added it forms a multi-digit num
                cur_ascii *= 10;
            } else {

                // Adds the final digit in the case that the next char is a space
                cur_ascii += (int)encrypted.charAt(i) - 48;
            }
        }

        // Returns the final decrypted string
        return decrypted;
    }

    // Method that decodes the 3rd problem, reads in 8 integers as bytes then converts those to ASCII, then text
    public String decryptThree(String encrypted) {
        String decrypted = "";

        // Loops through the encrypted string in sets of 8 (bytes)
        for (int i = 0; i  < encrypted.length(); i += 8) {

            // Gets a sub string which contains a set of 8 0's and 1's
            String sub = encrypted.substring(i, i + 8);

            // Converts the sub string to an Integer in base 10 from base 2 via parseInt
            // Also appends this ASCII char to the decrypted string
            decrypted += (char)(Integer.parseInt(sub, 2));
        }

        // Returns the final decrypted string
        return decrypted;
    }

    public String decryptFour(String encrypted) {
        String decrypted = "";

        // TODO: Complete the decryptFour() function.

        return decrypted;
    }
}
/**
 * The Riddler:
 * A puzzle by Zach Blick
 * for Adventures in Algorithms
 * At Menlo School in Atherton, CA
 *
 * Completed by: Kieran Pichai
 */
public class Riddler {

    public int determineShift(char x) {
        char shifting_base;
        if (Character.isLowerCase(x)) {
            shifting_base = 'a';
        } else {
            shifting_base = 'A';
        }
        int shifted = (x - shifting_base + 9) % 26;

        return shifting_base + shifted;
    }

    public String decryptOne(String encrypted) {
        String decrypted = "";

        for (char x : encrypted.toCharArray()) {
            if (Character.isLetter(x)) {
                decrypted += (char)(determineShift(x));
            } else {
                decrypted += x;
            }
        }

        return decrypted;
    }

    public String decryptTwo(String encrypted) {
        String decrypted = "";
        int x = 0;

        for (int i = 0; i < encrypted.length() - 1; i++) {
            if (encrypted.charAt(i) == ' ') {
                decrypted += (char)x;
                x = 0;
                continue;
            }
            if (Character.isDigit(encrypted.charAt(i+1))) {
                x += (int)encrypted.charAt(i) - 48;
                x *= 10;
            } else {
                x += (int)encrypted.charAt(i) - 48;
            }
        }

        return decrypted;
    }

    public String decryptThree(String encrypted) {
        String decrypted = "";

        for (int i = 0; i  < encrypted.length(); i += 8) {
            String sub = encrypted.substring(i, i + 8);
            decrypted += (char)(Integer.parseInt(sub, 2));
        }

        return decrypted;
    }

    public String decryptFour(String encrypted) {
        String decrypted = "";

        // TODO: Complete the decryptFour() function.

        return decrypted;
    }
}

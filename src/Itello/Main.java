package Itello;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Enter a string");
        String a = in.nextLine();
        if (a.equals("")) {
            System.out.println(a);
        } else {
            String encryptionToString = getAtbashEncryption(a);
            System.out.println(encryptionToString);
        }
    }

    static String getAtbashEncryption(String a) {
        StringBuilder encryptedSentence = new StringBuilder();

        for (int currentLetter = 0; currentLetter < a.length(); currentLetter++) {

            char originalAscii = a.charAt(currentLetter);
            boolean isBigLetter = originalAscii >= 65 && originalAscii <= 90;
            boolean isSmallLetter = originalAscii >= 97 && originalAscii <= 122;
            boolean isBigSwedish = originalAscii == 'Å' || originalAscii == 'Ä' || originalAscii == 'Ö';
            boolean isSmallSwedish = originalAscii == 'å' || originalAscii == 'ä' || originalAscii == 'ö';
            boolean isNumber = originalAscii >= 48 && originalAscii <= 57;
            if (!(isBigLetter || isBigSwedish || isNumber || isSmallLetter || isSmallSwedish)) {
                encryptedSentence.append(originalAscii);
                continue;
            }
            int letterCode;
            int lengthOfAlphabet;

            if (isBigLetter || isSmallLetter||isBigSwedish || isSmallSwedish) {
                lengthOfAlphabet = 30;
            } else {
                lengthOfAlphabet = 9;
            }

            if (isBigLetter||isBigSwedish) {
                letterCode = 64;
            } else if (isSmallLetter||isSmallSwedish) {
                letterCode = 96;
            } else {
                letterCode = 48;
            }
            originalAscii = transformToNewAscii(originalAscii);
            char newAscii = (char) (lengthOfAlphabet - (originalAscii - letterCode) + letterCode);
            newAscii = transformToOldAscii (newAscii);
            encryptedSentence.append(newAscii);
        }
        return encryptedSentence.toString();
    }

    private static char transformToOldAscii(char newAscii) {
        switch (newAscii) {
            case '{':
                return 'å';
            case '|':
                return 'ä';
            case '}':
                return 'ö';
            case '[':
                return 'Å';
            case '\\':
                return 'Ä';
            case ']':
                return 'Ö';
            default:
                return newAscii;
        }
    }

    private static char transformToNewAscii(char originalAscii) {
        switch (originalAscii){
            case 'å':
                return '{';
            case  'ä':
                return '|';
            case 'ö':
                return '}';
            case 'Å':
                return '[';
            case 'Ä':
                return '\\';
            case 'Ö':
                return ']';
            default:
                return originalAscii;
        }
    }

}


import java.util.Scanner;

public class Bomb
{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Input morse code to be translated: ");
        String morse = sc.nextLine();
        double freqToRespondWith = freqFromMorse(morse);
        System.out.println(freqToRespondWith + " MHz");
    }

    // Returns the appropriate frequency, in MHz, at which to respond.
    public static double freqFromMorse(String morse) {
        double freq = 0;
        String word = morseWordDecoder(morse);
        System.out.println(word);
        switch(word) {
            case "shell": freq = 3.505; break;
            case "halls": freq = 3.515; break;
            case "slick":	freq = 3.522; break;
            case "trick": freq = 3.532; break;
            case "boxes": freq = 3.535; break;
            case "leaks": freq = 3.542; break;
            case "strobe": freq = 3.545; break;
            case "bistro": freq = 3.552; break;
            case "flick": freq = 3.555; break;
            case "bombs": freq = 3.565; break;
            case "break": freq = 3.572; break;
            case "brick": freq = 3.575; break;
            case "steak": freq = 3.582; break;
            case "sting": freq = 3.592; break;
            case "vector": freq = 3.595; break;
            case "beats": freq = 3.600; break;
        }

        if (freq == 0) { System.out.println("ERROR"); }
        return freq;
    }

    // Returns the translated word from an input of a sequence of morse code.
    private static String morseWordDecoder(String morse) {
        String word = "";
        String delimiter = " ";

        // translates morse input to a word, letter-by-letter
        while (morse.indexOf(delimiter) > 0) {
            String morseLetter = morse.substring(0, morse.indexOf(delimiter));
            String letter = "";
            letter = morseLetterDecoder(morseLetter);
            word += letter;
            morse = morse.substring(morse.indexOf(delimiter)+1);
        }
        word += morseLetterDecoder(morse); // decodes last letter

        return word;
    }

    // Returns the translated letter from an input of a letter in morse code.
    private static String morseLetterDecoder(String morseLetter) {
        String outputLetter = "";
        switch(morseLetter) {
            case ".-": outputLetter = "A"; break;
            case "-...": outputLetter = "B"; break;
            case "-.-.": outputLetter = "C"; break;
            case "-..": outputLetter = "D"; break;
            case ".": outputLetter = "E"; break;
            case "..-.": outputLetter = "F"; break;
            case "--.": outputLetter = "G"; break;
            case "....": outputLetter = "H"; break;
            case "..": outputLetter = "I"; break;
            case ".---": outputLetter = "J"; break;
            case "-.-": outputLetter = "K"; break;
            case ".-..": outputLetter = "L"; break;
            case "--": outputLetter = "M"; break;
            case "-.": outputLetter = "N"; break;
            case "---": outputLetter = "O"; break;
            case ".--.": outputLetter = "P"; break;
            case "--.-": outputLetter = "Q"; break;
            case ".-.": outputLetter = "R"; break;
            case "...": outputLetter = "S"; break;
            case "-": outputLetter = "T"; break;
            case "..-": outputLetter = "U"; break;
            case "...-": outputLetter = "V"; break;
            case ".--": outputLetter = "W"; break;
            case "-..-": outputLetter = "X"; break;
            case "-.--": outputLetter = "Y"; break;
            case "--..": outputLetter = "Z"; break;
        }
        return outputLetter.toLowerCase();
    }
}

package iostream;

import java.io.*;

public class Crypter {

    public static void encrypt(String inputPath, String outputPath, String key) throws IOException {
        try (Reader reader = new FileReader(inputPath);
             Writer writer = new FileWriter(outputPath)) {

            int keyPos = 0;
            char[] keyChars = key.toCharArray();
            int keyLength = keyChars.length;

            int currentCh;
            while ((currentCh = reader.read()) != -1) {
                char keyChar = keyChars[keyPos];

                char encryptedChar = shiftChar((char) currentCh, keyChar, true);

                writer.write(encryptedChar);

                keyPos = (keyPos + 1) % keyLength;
            }
        }
    }

    public static void decrypt(String inputPath, String outputPath, String key) throws IOException {
        try (Reader reader = new FileReader(inputPath);
             Writer writer = new FileWriter(outputPath)) {

            int keyPos = 0;
            char[] keyChars = key.toCharArray();
            int keyLength = keyChars.length;

            int currentCh;
            while ((currentCh = reader.read()) != -1) {
                char keyChar = keyChars[keyPos];

                char decryptedChar = shiftChar((char) currentCh, keyChar, false);

                writer.write(decryptedChar);

                keyPos = (keyPos + 1) % keyLength;
            }
        }
    }

    private static char shiftChar(char c, char keyChar, boolean encrypt) {
        if (encrypt) {
            return (char) ((c + keyChar) % 65536);
        } else {
            return (char) ((c - keyChar + 65536) % 65536);
        }
    }
}

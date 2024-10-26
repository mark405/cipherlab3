import java.util.HashMap;
import java.util.Map;

public class PoemCipher implements CryptographicSystem {
    private final char[][] poemGrid;
    private final Map<Character, String> charToPosition;

    public PoemCipher(String poem) {
        this.poemGrid = new char[10][10];
        this.charToPosition = new HashMap<>();
        initializePoemGrid(poem);
    }

    private void initializePoemGrid(String poem) {
        int row = 0, col = 0;
        for (char ch : poem.toCharArray()) {
            if (ch == '\n') continue;
            if (col >= 10) {
                col = 0;
                row++;
            }
            if (row >= 10) break;
            poemGrid[row][col] = ch;
            charToPosition.put(ch, (row + 1) + "/" + (col + 1));
            col++;
        }
    }

    @Override
    public String encrypt(String plaintext) {
        StringBuilder ciphertext = new StringBuilder();
        for (char ch : plaintext.toCharArray()) {
            String position = charToPosition.getOrDefault(ch, "");
            if (!position.isEmpty()) {
                ciphertext.append(position).append(",");
            } else {
                throw new IllegalArgumentException("Character " + ch + " not found in poem grid.");
            }
        }
        return ciphertext.toString();
    }

    @Override
    public String decrypt(String ciphertext) {
        StringBuilder plaintext = new StringBuilder();
        String[] positions = ciphertext.split(",");
        for (String pos : positions) {
            if (pos.isEmpty()) continue;
            String[] parts = pos.split("/");
            int row = Integer.parseInt(parts[0]) - 1;
            int col = Integer.parseInt(parts[1]) - 1;
            plaintext.append(poemGrid[row][col]);
        }
        return plaintext.toString();
    }
}

public interface CryptographicSystem {
    String encrypt(String plaintext);
    String decrypt(String ciphertext);
}
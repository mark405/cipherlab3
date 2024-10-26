public class Main {
    public static void main(String[] args) {
        String poem = """
            Мабуть, ще людство дуже молоде.
            Бо скільки б ми не загинали пальці, –
            XX вік! – а й досі де-не-де
            трапляються іще неандертальці.

            Подивишся: і що воно таке?
            Не допоможе й двоопукла лінза.
            Здається ж, люди, все у них людське,
            але душа ще з дерева не злізла.
        """;

        PoemCipher cipher = new PoemCipher(poem);

        String plaintext = "Мабуть людство";
        String encrypted = cipher.encrypt(plaintext);
        System.out.println("Encrypted: " + encrypted);

        String decrypted = cipher.decrypt(encrypted);
        System.out.println("Decrypted: " + decrypted);
    }
}
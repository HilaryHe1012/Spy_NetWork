public class Scheme2 implements EncryptionScheme {
    
    @Override
    public String encrypt(int key, String message) {
        return message + "!".repeat(key);
    }

    @Override
    public String decrypt(int key, String message) {
        return (message.substring(0, message.length() - key));
    }
}

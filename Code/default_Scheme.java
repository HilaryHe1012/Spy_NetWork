public class default_Scheme implements EncryptionScheme {

    @Override
    public String encrypt(int key, String message) {
        message = new StringBuilder(message).reverse().toString();
        return message;
    }

    @Override
    public String decrypt(int key, String message) {
        message = new StringBuilder(message).reverse().toString();
        return message;
    }
    
}

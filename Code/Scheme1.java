public class Scheme1 implements EncryptionScheme{
    
    @Override
    public String encrypt(int key, String message) {
        return message;
    }

    @Override
    public String decrypt(int key, String message) {
        return message;
    }
}

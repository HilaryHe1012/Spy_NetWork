public interface EncryptionScheme {
    public String encrypt(int key, String message);
    public String decrypt(int key, String message);
}

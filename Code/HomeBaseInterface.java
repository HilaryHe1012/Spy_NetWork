public interface HomeBaseInterface extends messageReceiver,messageSender{
    
    public void addFieldBase(FieldBaseHOMEinterface fb);
    public void removeFieldBase(FieldBaseHOMEinterface fb);
    public int getKey();
    public EncryptionScheme getScheme();
    //public void update(EncryptionScheme s, int key);
}

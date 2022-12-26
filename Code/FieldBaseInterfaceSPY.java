public interface FieldBaseInterfaceSPY { //Interface field base uses to deal with spy
    public void registerSpy(SpyInterface s);
    public EncryptionScheme getScheme();
    public int getKey();
    public void deadSignal(SpyInterface s); //calls Field base to deal with a dead spy
}

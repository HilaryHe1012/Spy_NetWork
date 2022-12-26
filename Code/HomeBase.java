public class HomeBase implements HomeBaseInterface{
    
    private static HomeBase instance;
    private int key;
    private String message;//most recent msg
    private Data<String> messages = new Data<>(); //all msgs
    private EncryptionScheme scheme = new default_Scheme();

    private Data<FieldBaseHOMEinterface> fieldBases = new Data<FieldBaseHOMEinterface>();

    private HomeBase(){} //constructor (singleton pattern)

    public static HomeBase getInstance(){ //singleton pattern
        if (instance == null) {
            instance = new HomeBase();
        }
        return instance;
    }

    private void notifySubject() { //updates all field bases that are registered
        for (int i = 0; i < fieldBases.length(); i++) {
            (fieldBases.get(i)).update();
        }
    }
    @Override
    public void addFieldBase(FieldBaseHOMEinterface fb) {
        if (!fieldBases.contains(fb)) fieldBases.addItem(fb);

        // checking the arrayList is implemented correctly
        fieldBases.print();

    }
    @Override
    public void removeFieldBase(FieldBaseHOMEinterface fb) { 
        fieldBases.removeItem(fb);

        // checking the arrayList is implementated correctly
        fieldBases.print();
    }
    
    public void setScheme(EncryptionScheme scheme) {
        this.scheme = scheme;
        update();
    }
    
    public void setKey(int key) {
        this.key = key;
        update();
    }

    // basically sets scheme and sets keys, then notifysubject
    private void update() {
        notifySubject();
    }
    @Override
    public EncryptionScheme getScheme() {
        return this.scheme;
    }
    @Override
    public int getKey() {
        return this.key;
    }

    @Override
    public void send(String msg, messageReceiver other) { //msg handling
        msg = scheme.encrypt(key, msg);
        other.receive(msg);
    }

    @Override
    public void receive(String msg) { //msg handling
        message = scheme.decrypt(key, msg);
        messages.addItem(message);
        System.out.println("Home base received message: " + this.message + " this message was originally encrypted as: " + msg);
  
    }

}

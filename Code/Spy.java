public class Spy implements SpyInterface{
    
    private EncryptionScheme scheme;
    private int key;
    private String message;
    private Data<String> messages = new Data<>();
    private boolean live = true;
    private FieldBaseInterfaceSPY fbs = new ConcreteFieldBase();

    public Spy(FieldBaseInterfaceSPY fbs) {
        this.fbs = fbs;
        fbs.registerSpy(this);
    }

    @Override
    public void update() {//final chain of the updating from homebase
        this.scheme = fbs.getScheme();
        this.key = fbs.getKey();
        System.out.println("Spy1 Shceme Updated, Key updated: " + key);
    }

    //could move both death functions into a new interface if needed 

    public boolean isDead() {
        return live;
    }
    public void die(){
        live = false;
        fbs.deadSignal(this);
    }
 
    
    public FieldBaseInterfaceSPY getFieldBase() {
        return this.fbs;
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
        System.out.println("Spy received message: " + this.message + " this message was originally encrypted as: " + msg);
  
    }
    
}

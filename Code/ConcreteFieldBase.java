public class ConcreteFieldBase implements FieldBaseInterface{
    
    private HomeBaseInterface homeBase = HomeBase.getInstance();
    private EncryptionScheme scheme;
    private int key;
    private String message;
    private Data<SpyInterface> spies = new Data<SpyInterface>();
    private Data<SpyInterface> deadSpies = new Data<SpyInterface>();
    private Data<String> messages = new Data<>();

    public ConcreteFieldBase() {
        register(); //registers on creation
    }

    @Override
    public void update() {
        this.scheme = homeBase.getScheme();
        this.key = homeBase.getKey();
        System.out.println("FieldBase1 Scheme Updated, Key updated: " + key);
        //tell spies about new keys/schemes
        notifySpies();
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
    public void unregister() { //unregister from homebase
        homeBase.removeFieldBase(this);
    }

    @Override 
    public void register() { //register to homebase
        homeBase.addFieldBase(this);
    }

    
    private void unregisterSpy(SpyInterface s) { //unregister spy
        spies.removeItem(s);
    }

    @Override
    public void registerSpy(SpyInterface s) {
        if (!spies.contains(s) & !deadSpies.contains(s)) { //not in list + not a previously recorded dead spy
            spies.addItem(s);

        };
    }

    //no one should not be able to access this except field base itself.
    private void notifySpies() {
        for (int i = 0; i < spies.length(); i++) {
            (spies.get(i)).update();
        }
    }

    @Override
    public void deadSignal(SpyInterface s) { //in case spy dies
        unregisterSpy(s);
        deadSpies.addItem(s);
    }
    
    @Override
    public void send(String msg, messageReceiver other) { //message handling
        msg = scheme.encrypt(key, msg);
        other.receive(msg);
    }

    @Override
    public void receive(String msg) { //msg handling
        message = scheme.decrypt(key, msg);
        messages.addItem(message);
        System.out.println("Field base received message: " + this.message + " this message was originally encrypted as: " + msg);
    }



    

}

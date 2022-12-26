public class Runner {

    public static void main (String[] args) {

        String m = "Hello World";
        int key = 0;
        int key1 = 5;
        HomeBase homeBase = HomeBase.getInstance();
        EncryptionScheme scheme = new Scheme2();
        ConcreteFieldBase fb = new ConcreteFieldBase();
        Spy hilary = new Spy(fb);
        Spy timothy = new Spy(fb);

        //homeBase.update();
        //homeBase.update();
        
        // home base sending message to the field base and spy
        homeBase.send(m, fb);
        homeBase.send(m, timothy);
        System.out.println("\n");
        
        // field base sending message to the home base and spy
        fb.send(m, timothy);
        fb.send(m,homeBase);
        System.out.println("\n");
        
        // spy sending message to field base, home base and other spy
        // I was wondering whether spies are allowed to send messages to other field bases as well
        hilary.send(m,fb);
        hilary.send(m,homeBase);
        hilary.send(m, timothy);
        
        

    }

}

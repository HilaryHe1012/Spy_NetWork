public interface messageReceiver {
    public void receive(String msg);
    //separate from sender so people cant send msgs on the other persons behalf

}

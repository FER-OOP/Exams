package hr.fer.oop.midterm_2017_18.task3;
public abstract class RemoteAbs extends Device implements Remote {

    private boolean isRemoteSessionActive;

    public RemoteAbs(String ID, boolean isPoweredOn, boolean isRemoteSessionActive) {
        super(ID, isPoweredOn);
    }

    @Override
    public void startRemoteSession() {
        this.isRemoteSessionActive = true;
    }

    @Override
    public void endRemoteSession() {
        this.isRemoteSessionActive = false;

    }
}

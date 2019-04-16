package rocks.zipcode.io.objectorientation;

public class Television {

    private boolean isTurnedOn;
    private TVChannel tvChannel;

    public Television() {
        this.isTurnedOn = false;
        this.tvChannel = TVChannel.getByOrdinal(0);
    }

    public Television(boolean isTurnedOn, TVChannel channel) {
        this.isTurnedOn = isTurnedOn;
        this.tvChannel = channel;
    }

    public void turnOn() {
        isTurnedOn = !isTurnedOn;
    }

    public void setChannel(Integer channel) throws IllegalStateException{

        if(isTurnedOn) {
            tvChannel = TVChannel.getByOrdinal(channel);
        } else {throw new IllegalStateException();}
    }

    public TVChannel getChannel() {
        return tvChannel;
    }
}

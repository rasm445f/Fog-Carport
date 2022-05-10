package dat.startcode.model.entities;

public class CarportLength {

    private int carportLengthID;
    private int carportLength;

    public CarportLength(int carportLengthID, int carportLength) {
        this.carportLengthID = carportLengthID;
        this.carportLength = carportLength;
    }

    public int getCarportLengthID() {
        return carportLengthID;
    }

    public int getCarportLength() {
        return carportLength;
    }
}

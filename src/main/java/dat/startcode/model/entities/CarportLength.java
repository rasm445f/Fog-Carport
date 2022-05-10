package dat.startcode.model.entities;

public class CarportLength {
    private int carportLengthID;
    private int carportLengthCM;

    public CarportLength(int carportLengthID, int carportLengthCM) {
        this.carportLengthID = carportLengthID;
        this.carportLengthCM = carportLengthCM;
    }

    public int getCarportLengthID() {
        return carportLengthID;
    }

    public int getCarportLengthCM() {
        return carportLengthCM;
    }
}

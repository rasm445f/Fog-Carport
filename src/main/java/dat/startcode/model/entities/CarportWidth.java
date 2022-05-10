package dat.startcode.model.entities;

public class CarportWidth {
    int carportWidthID;
    int carportWidthCM;

    public CarportWidth(int carportWidthID, int carportWidthCM) {
        this.carportWidthID = carportWidthID;
        this.carportWidthCM = carportWidthCM;
    }

    public int getCarportWidthID() {
        return carportWidthID;
    }

    public int getCarportWidthCM() {
        return carportWidthCM;
    }
}

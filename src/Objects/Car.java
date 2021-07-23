package Objects;

public class Car {

    private String CarManufacturer;
    private String CarModel;
    private String CarReg;
    private String CarColour;
    private int CarYear;

    public Car(String CarManufacturer, String CarModel, String CarReg, String CarColour, int CarYear) {
        this.CarManufacturer = CarManufacturer;
        this.CarModel = CarModel;
        this.CarReg = CarReg;
        this.CarColour = CarColour;
        this.CarYear = CarYear;
    }

    public String getString() {
        return CarManufacturer + " " + CarModel + " " + CarYear + " " + CarColour + " " + CarReg;
    }

    public String getCarManufacturer() {
        return CarManufacturer;
    }

    public void setCarManufacturer(String CarManufacturer) {
        this.CarManufacturer = CarManufacturer;
    }

    public String getCarModel() {
        return CarModel;
    }

    public void setCarModel(String CarModel) {
        this.CarModel = CarModel;
    }

    public String getCarReg() {
        return CarReg;
    }

    public void setCarReg(String CarReg) {
        this.CarReg = CarReg;
    }

    public String getCarColour() {
        return CarColour;
    }

    public void setCarColour(String CarColour) {
        this.CarColour = CarColour;
    }

    public int getCarYear() {
        return CarYear;
    }

    public void setCarYear(int CarYear) {
        this.CarYear = CarYear;
    }

}

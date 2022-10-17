package navigator.service.enums;

public enum VehicleEnum {
    CAR(60),BUS(40),TRAIN(50);
    public final int speed;
    VehicleEnum(int speed){
        this.speed=speed;
    }

}

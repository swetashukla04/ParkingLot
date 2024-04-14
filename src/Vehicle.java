public class Vehicle {
    private int vehicleNo;
    private VehicleType vehicleType;

    private ParkingSpot parkingSpot;

    

    public Vehicle(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    public int getVehicleNo() {
        return vehicleNo;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public ParkingSpot getParkingSpot() {
        return parkingSpot;
    }

    public void setVehicleNo(int vehicleNo) {
        this.vehicleNo = vehicleNo;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    public void setParkingSpot(ParkingSpot parkingSpot) {
        this.parkingSpot = parkingSpot;
    }

}

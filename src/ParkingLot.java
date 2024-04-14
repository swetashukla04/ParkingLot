import java.util.ArrayList;
import java.util.List;

public class ParkingLot {
    int largeSpotSize;
    int compactSpotSize;
    int bikeSpotSize;

    List<ParkingSpot> largeParkingSpotList;
    List<ParkingSpot> compactParkingSpotList;
    List<ParkingSpot> bikeParkingSpotList;

    public ParkingLot(int largeSpotSize, int compactSpotSize, int bikeSpotSize) {
        this.largeSpotSize = largeSpotSize;
        this.compactSpotSize = compactSpotSize;
        this.bikeSpotSize = bikeSpotSize;

        largeParkingSpotList = new ArrayList<>();
        compactParkingSpotList = new ArrayList<>();
        bikeParkingSpotList = new ArrayList<>();

    }

    public void parkTheVehicle(Vehicle vehicle) {
        System.out.println("We are Parking the vehicle"+vehicle.getVehicleType());
        if (VehicleType.TRUCK.equals(vehicle.getVehicleType())) {
            if (largeSpotSize > 0) {
                parkLargeVehicle(vehicle);
            } else {
                System.out.println("Large parking spots are full");
            }
        } else if (VehicleType.CAR.equals(vehicle.getVehicleType())) {
            if (compactSpotSize > 0) {
                parkCompactVehicle(vehicle);
            } else {
                System.out.println("Compact parking spots are full");
            }
        } else if (VehicleType.BIKE.equals(vehicle.getVehicleType())) {
            if (bikeSpotSize > 0) {
                parkBikeVehicle(vehicle);
            } else {
                System.out.println("Bike parking spots are full");
            }
        } else {
            System.out.println("Given vehicle parking is not available");
        }
    }

    private void parkBikeVehicle(Vehicle vehicle) {

        ParkingSpot bikeParkingSpot = new ParkingSpot(ParkingSpotType.BIKE);
        bikeParkingSpot.setFree(false);
        bikeParkingSpot.setVehicle(vehicle);
        vehicle.setParkingSpot(bikeParkingSpot);
        bikeParkingSpotList.add(bikeParkingSpot);
        bikeSpotSize--;
        System.out.println("Vehicle BIKE parked Successfully");

    }

    private void parkCompactVehicle(Vehicle vehicle) {
        ParkingSpot compactParkingSpot = new ParkingSpot(ParkingSpotType.COMPACT);
        compactParkingSpot.setFree(false);
        compactParkingSpot.setVehicle(vehicle);
        vehicle.setParkingSpot(compactParkingSpot);
        compactParkingSpotList.add(compactParkingSpot);
        compactSpotSize--;
        System.out.println("Vehicle COMPACT parked Successfully");

    }

    private void parkLargeVehicle(Vehicle vehicle) {
        ParkingSpot largeParkingSpot = new ParkingSpot(ParkingSpotType.LARGE);
        largeParkingSpot.setFree(false);
        largeParkingSpot.setVehicle(vehicle);
        vehicle.setParkingSpot(largeParkingSpot);
        largeParkingSpotList.add(largeParkingSpot);
        largeSpotSize--;
        System.out.println("Vehicle TRUCK parked Successfully");
    }

    public void unparkTheVehicle(Vehicle vehicle) {
        System.out.println("We are unparking  the vehicle" + vehicle.getVehicleType());

        ParkingSpot parkingSpot = vehicle.getParkingSpot();
        parkingSpot.setFree(true);

        if (VehicleType.BIKE.equals(vehicle.getVehicleType())) {
            bikeSpotSize++;

        } else if (VehicleType.TRUCK.equals(vehicle.getVehicleType())) {
            largeSpotSize++;
        } else {
            compactSpotSize++;
        }
        System.out.println("unpacking the vehicle successfully");

    }

}

package ood.OODCase._ParkingLot_;

public class Car extends Vehicle{
  public Car(){
    super(VehicleType.MEDIUM);
  }

  @Override
  public boolean canFitInSpot(ParkingSpot parkingSpot) {
    if (parkingSpot.getType() == ParkingSpotType.MEDIUM){
      System.out.println("Go parking in small parking spot!");
      return true;
    } else {
      System.out.println("Moto cannot fit in!");
      return false;
    }
  }
}
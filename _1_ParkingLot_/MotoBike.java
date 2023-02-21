package ood.OODCase._ParkingLot_;

public class MotoBike extends Vehicle{
  public MotoBike(){
    super(VehicleType.SMALL);
  }

  @Override
  public boolean canFitInSpot(ParkingSpot parkingSpot) {
    if (parkingSpot.getType() == ParkingSpotType.SMALL){
      System.out.println("Go parking in small parking spot!");
      return true;
    } else {
      System.out.println("Moto cannot fit in!");
      return false;
    }
  }

}
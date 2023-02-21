package ood.OODCase._ParkingLot_;

public class Bus extends Vehicle{
  public Bus(){
    super(VehicleType.LARGE);
  }

  @Override
  public boolean canFitInSpot(ParkingSpot parkingSpot) {
    if (parkingSpot.getType() == ParkingSpotType.LARGE){
      System.out.println("Go parking in small parking spot!");
      return true;
    } else {
      System.out.println("Moto cannot fit in!");
      return false;
    }
  }
}


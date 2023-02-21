package ood.OODCase._ParkingLot_;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;

public abstract class Vehicle {
  protected String name;
  protected String plateNo;
  protected Date enterTime;
  protected Date exitTime;

  private final VehicleType type; // type will not change
  protected List<ParkingSpot> parkingSpots;
  public Vehicle(VehicleType type){
    this.type = type;
    this.parkingSpots = new ArrayList<ParkingSpot>();
  }

  public VehicleType getType() {
    return type;
  }

  public abstract boolean canFitInSpot(ParkingSpot parkingSpot);

  public void parkInSpot(ParkingSpot parkingSpot){
    parkingSpot.takeSpot(this);
    parkingSpots.add(parkingSpot);
  }

  public void clearSpots(){
    for (int i = 0; i < parkingSpots.size(); i++){
      parkingSpots.get(i).leaveSpot();
    }
    parkingSpots.clear();
  }
}

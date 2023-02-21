package ood.OODCase._ParkingLot_;

public class ParkingSpot{

  private final ParkingSpotType type;
  private boolean available;
  private Vehicle vehicle;
  private int spotNo;
  private Level level;
  private int row;

  public ParkingSpotType getType() {
    return type;
  }

  public int getSpotNo() {
    return spotNo;
  }

  public int getRow() {
    return row;
  }

  public ParkingSpot(Level level, int row, int num, ParkingSpotType type){
    this.type = type;
    this.available = true;
    this.spotNo = num;
    this.row = row;
    this.level = level;
  }

  public boolean isAvailable(){
    return available;
  }

  public boolean canVehicleFit(Vehicle vehicle){
    return isAvailable() && vehicle.canFitInSpot(this);
  }

  public void takeSpot(Vehicle vehicle){
    this.vehicle = vehicle;
    this.level.spotOccupied();
    this.available = false;
  }

  public void leaveSpot(){
    this.level.spotFreed();
    this.vehicle = null;
    this.available = true;
  }

}

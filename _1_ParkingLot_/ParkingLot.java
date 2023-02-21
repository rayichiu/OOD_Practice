package ood.OODCase._ParkingLot_;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;

public class ParkingLot{

  private String name;
  private boolean available;
  private final int hourlyRate;
  private List<Level> levels; // also can write as a 2d list of parking spots

  // singleton
  private static ParkingLot parkingLot;

  private ParkingLot(int num_floor, int num_row, int spots_per_row, int hourlyRate){
    this.name = "Chiraddy";
    this.available = true;
    this.hourlyRate = hourlyRate;
    levels = new ArrayList<Level>(num_floor);
    for (int i = 0; i < num_floor; i++){
      levels.add( new Level(i, num_row, spots_per_row));
    }
  }

  // ***** need to be deleted ******
  public List<Level> getLevels() {
    return levels;
  }

  public static ParkingLot getInstance(int level, int row, int spots_per_row, int hourlyRate){
    if (parkingLot == null){
      parkingLot = new ParkingLot(level, row, spots_per_row, hourlyRate);
    }
    System.out.println("Welcome to " + parkingLot.name + " parking lot.");
    return parkingLot;
  }

  public boolean isAvailable(){
    this.available = false;
    for (int i = 0; i < levels.size(); i++){
      if (levels.get(i).isAvailable()){
        this.available = true;
      }
    }
    return this.available;
  }

  public int[] findLevelAvailable(Vehicle vehicle){
    System.out.println("enter findLevelAvailable!");
    int[] ans = {-1, -1, -1}; // floor, row, spotNo
    for (int i = 0; i < this.levels.size(); i++){
      Level lvl = this.levels.get(i);
      if (lvl.isAvailable()){
        System.out.println("findLevelAvailable ava");
        ans = lvl.findSpot(vehicle);
        return ans;
      }
    }
    System.out.println("findLevelAvailable not ava");
    return ans;
  }

  public int getAvailableCount(){
    int availableCount = 0;
    for (int i = 0; i < levels.size(); i++){
      Level lvl =  levels.get(i);
      if (lvl.isAvailable()){
        availableCount += lvl.getAvailableCount();
      }
    }
    return availableCount;
  }

  public void enter(Vehicle vehicle, Date enterTime){
    if (this.parkingLot.isAvailable()){
      System.out.println("You can enter parking lot!");
      vehicle.enterTime = enterTime;
      int[] spotInfo = this.parkingLot.findLevelAvailable(vehicle);
      if (spotInfo[0] != -1){
        ParkingSpot parkingSpot = levels.get(spotInfo[0]).getSpotList()[spotInfo[1]][spotInfo[2]];
        vehicle.parkInSpot(parkingSpot);
        return;
      }
    }
    System.out.println("The parking lot is full!");
  }

  /* here is the info related to tickets */
  public void exit(Vehicle vehicle, Date exitTime){
    vehicle.exitTime = exitTime;
    Ticket ticket = new Ticket(vehicle);

    // process payment
    try {
      payment(ticket);
    } catch (InvalidTicketException e) {
      throw new RuntimeException(e);
    }

    // enter only calculate time exit ticket
    vehicle.clearSpots();
  }

  public void payment(Ticket ticket) throws InvalidTicketException{
    if (ticket.getStatus() == 1){
      throw new InvalidTicketException("This ticket is already paid!");
    }
    long diff_in_time = ticket.getExitTime().getTime() - ticket.getEnterTime().getTime();
        System.out.println("You pay : " + diff_in_time/(1000 * 60 * 60) * hourlyRate) ;
  }

  class InvalidTicketException extends Exception{
    public InvalidTicketException(String msg){
      super(msg);
    }
  }
}

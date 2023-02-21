package ood.OODCase._ParkingLot_;

import java.util.ArrayList;
import java.util.List;

public class Level{
  private ParkingSpot[][] spotList;
  private int availableCount;
//  private boolean available; // doesn't matter if no variable
  private int floor;


  // ***** need to be deleted ******
  public ParkingSpot[][] getSpotList() {
    return spotList;
  }

  public Level(int floor, int num_row, int spots_per_row) {
//    this.availableCount = Constants.NUM_SPOTS;
    spotList = new ParkingSpot[num_row][spots_per_row];
    for (int row = 0; row < num_row; row++){
      // Moto
      for (int spot = 0; spot < spots_per_row / 4; spot++){
        ParkingSpotType vt = ParkingSpotType.SMALL;
        spotList[row][spot] = new ParkingSpot(this, row, spot, vt);
        this.availableCount ++;
      }
      // Car
      for (int spot = spots_per_row / 4; spot < spots_per_row / 4 * 3; spot++){
        ParkingSpotType vt = ParkingSpotType.MEDIUM;
        spotList[row][spot] = new ParkingSpot(this, row, spot, vt);
        this.availableCount ++;
      }
      // Bus
      for (int spot = spots_per_row / 4 * 3; spot < spots_per_row; spot++){
        ParkingSpotType vt = ParkingSpotType.LARGE;
        spotList[row][spot] = new ParkingSpot(this, row, spot, vt);
        this.availableCount ++;
      }
    }
  }

  public boolean isAvailable(){
    return (this.availableCount > 0) ? true : false;
  }

  public int getAvailableCount() {
    return availableCount;
  }

  public void spotFreed(){
    availableCount++;
  }

  public void spotOccupied() {
    availableCount--;
  }

  public int[] findSpot(Vehicle vehicle){
    int[] spotInfo = {-1, -1, -1}; // floor, row, spotNo
    for (int i = 0; i < this.spotList.length; i++){
      for (int j = 0; j < this.spotList[i].length; j++){
        ParkingSpot parkingSpot = spotList[i][j];
        if (parkingSpot.isAvailable() && parkingSpot.canVehicleFit(vehicle)){
          spotInfo[0] = this.floor;
          spotInfo[1] = i;
          spotInfo[2] = j;
          System.out.println("floor : " + spotInfo[0] + " row : " + spotInfo[1] + " spot : " + spotInfo[2] + " is available.");
          return spotInfo;
        }
      }
    }
    return spotInfo;
  }
}
package ood.OODCase._ParkingLot_;

import java.util.Calendar;
import java.util.Date;

public class Ticket {

  private String id;
  private float amount;
  private Vehicle vehicle;
  private Date enterTime;
  private Date exitTime;

  private int status; // paid : 1 or not : 0
  private int paymentMethod; // CreditCard, Debit, Cash

  public Ticket(Vehicle vehicle){
    this.status = 0;
    this.enterTime = vehicle.enterTime;
    this.exitTime = vehicle.exitTime;
    this.vehicle = vehicle;
  }
  public int getStatus() {
    return status;
  }

  public Date getExitTime() {
    return exitTime;
  }

  public Date getEnterTime() {
    return enterTime;
  }

}
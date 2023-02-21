package ood.OODCase._ParkingLot_;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {
    public static void main(String[] args) throws ParseException, ParkingLot.InvalidTicketException {
    System.out.println("Hello Parking Lot!");
    int level = 1, numRows = 1, spotsPerRow = 11, hourlyRate = 15;
    // init parking lot
    ParkingLot parkingLot = ParkingLot.getInstance(level, numRows, spotsPerRow, hourlyRate);
    DateFormat dateFormat2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    Date moto1EnterTime = dateFormat2.parse("2023-01-01 00:00:00");
    Vehicle moto1 = new MotoBike();
    parkingLot.enter(moto1, moto1EnterTime);
    System.out.println("Ava count : " + parkingLot.getAvailableCount());
    System.out.println("-----------------------------");
    Date moto2EnterTime = dateFormat2.parse("2023-01-01 00:10:00");
    Vehicle moto2 = new MotoBike();
    parkingLot.enter(moto2, moto2EnterTime);
    System.out.println("Ava count : " + parkingLot.getAvailableCount());
    System.out.println("-----------------------------");
    Date moto3EnterTime = dateFormat2.parse("2023-01-01 05:10:00");
    Vehicle moto3 = new MotoBike();
    parkingLot.enter(moto3, moto3EnterTime);
    System.out.println("Ava count : " + parkingLot.getAvailableCount());
    System.out.println("-----------------------------");
    Date moto1ExitTime = dateFormat2.parse("2023-01-01 05:30:00");
    parkingLot.exit(moto1, moto1ExitTime);

    System.out.println("Ava count : " + parkingLot.getAvailableCount());
    System.out.println("-----------------------------");
    parkingLot.enter(moto3, moto3EnterTime);
    System.out.println("Ava count : " + parkingLot.getAvailableCount());

//    System.out.println(parkingLot.getLevels().get(0).getSpotList()[0][0].isAvailable());
//    System.out.println(spots_per_row / 4);
  }
}

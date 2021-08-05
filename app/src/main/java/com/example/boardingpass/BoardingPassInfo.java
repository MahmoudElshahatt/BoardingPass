package com.example.boardingpass;

import java.sql.Timestamp;
import java.util.concurrent.TimeUnit;

public class BoardingPassInfo {

    public String passengerName;
    public String flightCode;

    public Timestamp boardingTime;
    public Timestamp departureTime;
    public Timestamp arrivalTime;

    public String departureTerminal;
    public String departureGate;
    public String seatNumber;

    public int barCodeImageResource;

    public long getMinutesUntilBoarding() {
        long millisUntilBoarding = boardingTime.getTime() - System.currentTimeMillis();
        return TimeUnit.MILLISECONDS.toMinutes(millisUntilBoarding);
    }

}

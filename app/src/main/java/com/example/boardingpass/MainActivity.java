package com.example.boardingpass;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;

import com.example.boardingpass.databinding.ActivityMainBinding;

import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding mainBinding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainBinding= DataBindingUtil.setContentView(this,R.layout.activity_main);

        BoardingPassInfo boardingPassInfo=FakeData.generateFakeBoardingPassInfo();

        BindingtheData(boardingPassInfo);
    }
    private void BindingtheData(BoardingPassInfo info){
        mainBinding.textViewPassengername.setText(info.passengerName);
        mainBinding.textViewFlightCode.setText(info.flightCode);

        SimpleDateFormat formatter = new SimpleDateFormat(getString(R.string.timeFormat), Locale.getDefault());
        String boardingTime = formatter.format(info.boardingTime);
        String departureTime = formatter.format(info.departureTime);
        String arrivalTime = formatter.format(info.arrivalTime);

        mainBinding.textViewBoardingTime.setText(boardingTime);
        mainBinding.textViewDepartureTime.setText(departureTime);
        mainBinding.textViewArrivalTime.setText(arrivalTime);

        long totalMinutesUntilBoarding = info.getMinutesUntilBoarding();
        long hoursUntilBoarding = TimeUnit.MINUTES.toHours(totalMinutesUntilBoarding);
        long minutesLessHoursUntilBoarding =
                totalMinutesUntilBoarding - TimeUnit.HOURS.toMinutes(hoursUntilBoarding);

        String hoursAndMinutesUntilBoarding = getString(R.string.countDownFormat,
                hoursUntilBoarding,
                minutesLessHoursUntilBoarding);
        mainBinding.textViewBoardingInCountdown.setText(hoursAndMinutesUntilBoarding);

        mainBinding.textViewTerminal.setText(info.departureTerminal);
        mainBinding.textViewGate.setText(info.departureGate);
        mainBinding.textViewSeat.setText(info.seatNumber);
    }

    }

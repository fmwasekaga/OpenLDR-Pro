package com.kagaconnect.openldrpro;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.kagaconnect.core.adapters.StackedCardsDataAdapter;
import com.kagaconnect.core.data.Transmission;
import com.wenchao.cardstack.CardStack;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CardStack mCardStack = findViewById(R.id.container);
        mCardStack.setContentResource(R.layout.stacked_card);
        int year = 2020;
        int month = 2;


        StackedCardsDataAdapter mCardAdapter = new StackedCardsDataAdapter(getApplicationContext());
        mCardAdapter.add(new Transmission("Bugando Medical Centre", "Disa*Lab",year,month,getDays(year,month)));
        mCardAdapter.add(new Transmission("Kilimanjaro Christian Medical Centre", "Disa*Lab",year,month,getDays(year,month)));
        mCardAdapter.add(new Transmission("Mbeya Zonal Referral Hospital", "Disa*Lab",year,month,getDays(year,month)));
        mCardAdapter.add(new Transmission("Zanzibar's Mnazi Moja Hospital", "Disa*Lab",year,month,getDays(year,month)));
        mCardAdapter.add(new Transmission("NHL-QATC", "Disa*Lab",year,month,getDays(year,month)));
        mCardAdapter.add(new Transmission("Dodoma Regional Referral Hospital", "EVLIMS",year,month,getDays(year,month)));
        mCardAdapter.add(new Transmission("Iringa Regional Referral Hospital", "EVLIMS",year,month,getDays(year,month)));
        mCardAdapter.add(new Transmission("Mtwara (Ligula) Regional Referral Hospital", "EVLIMS",year,month,getDays(year,month)));
        mCardAdapter.add(new Transmission("Morogoro Regional Referral Hospital", "EVLIMS",year,month,getDays(year,month)));
        mCardAdapter.add(new Transmission("Arusha (Mt. Meru) Regional Referral Hospital", "EVLIMS",year,month,getDays(year,month)));
        mCardAdapter.add(new Transmission("Tabora (Kitete) Regional Referral Hospital", "EVLIMS",year,month,getDays(year,month)));
        mCardAdapter.add(new Transmission("St. Francis Designated District Hospital", "EVLIMS",year,month,getDays(year,month)));
        mCardAdapter.add(new Transmission("Iringa Dream Molecular Laboratory", "EVLIMS",year,month,getDays(year,month)));
        mCardAdapter.add(new Transmission("Songea Regional Referral Hospital", "TilleLab",year,month,getDays(year,month)));
        mCardAdapter.add(new Transmission("Mbeya Regional Referral Hospital", "TilleLab",year,month,getDays(year,month)));
        mCardAdapter.add(new Transmission("Sumbawanga Reginal Referral Hospital", "TilleLab",year,month,getDays(year,month)));
        mCardAdapter.add(new Transmission("MDH Temeke Research Laboratory", "TilleLab",year,month,getDays(year,month)));
        mCardAdapter.add(new Transmission("Njombe Regional Referral Hospital", "TilleLab",year,month,getDays(year,month)));
        mCardAdapter.add(new Transmission("Bukoba Regional Referral Hospital", "TilleLab",year,month,getDays(year,month)));

        mCardStack.setAdapter(mCardAdapter);
    }

    private List<Integer> getDays(int year, int month){
        final Calendar calendar = Calendar.getInstance();
        calendar.set (Calendar.YEAR, year);
        calendar.set (Calendar.MONTH, month);

        final int lastDayOfMonth = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);

        List<Integer> days = new ArrayList<>();

        int max = 21;
        int min = 1;
        Random random = new Random();
        for(int x=1; x<max; x++)
            days.add(random.nextInt(max - min + 1) + min);

        return days;
    }
}

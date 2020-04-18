package com.kagaconnect.core.adapters;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Log;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.ViewSwitcher;

import com.kagaconnect.core.data.Transmission;
import com.kagaconnect.core.views.GridViewEx;
import com.kagaconnect.openldrpro.R;
import com.wenchao.cardstack.CardStack;

import java.text.DateFormatSymbols;
import java.util.Calendar;

public class StackedCardsDataAdapter extends ArrayAdapter<Transmission> {
    private Context context;

    public StackedCardsDataAdapter(Context context) {
        super(context, R.layout.stacked_card);

        this.context = context;
    }

    @SuppressLint("ClickableViewAccessibility")
    @Override
    public View getView(int position, View contentView, final ViewGroup parent){
        Transmission item = getItem(position);
        if(contentView == null){
            LayoutInflater inflater = LayoutInflater.from(context);
            contentView = inflater.inflate(R.layout.stacked_card, parent, false);
        }

        final Calendar calendar = Calendar.getInstance();
        calendar.set (Calendar.YEAR, item.getYear());
        calendar.set (Calendar.MONTH, item.getMonth()-1);

        final GridViewEx calendarGrid =  contentView.findViewById(R.id.calendar_grid);
        CalendarAdapter calendarAdapter = new CalendarAdapter(context, calendar, item);
        calendarAdapter.refreshDays();

        calendarGrid.setAdapter(calendarAdapter);

        String t = (position+1)+" - "+item.getName();
        TextView title = (TextView)(contentView.findViewById(R.id.title));
        title.setText(t);

        TextView system = (TextView)(contentView.findViewById(R.id.system));
        system.setText(item.getSystem());

        final int year = calendar.get(Calendar.YEAR);
        final int month = calendar.get(Calendar.MONTH);
        String i = getMonth(month)+" "+year;
        TextView info = (TextView)(contentView.findViewById(R.id.info));
        info.setText(i);

        return contentView;
    }

    public String getMonth(int month) {
        return new DateFormatSymbols().getMonths()[month];
    }

}
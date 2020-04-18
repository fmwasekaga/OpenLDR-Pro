package com.kagaconnect.core.adapters;

import java.util.Calendar;
import java.util.List;

import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.kagaconnect.core.data.Transmission;
import com.kagaconnect.openldrpro.R;

public class CalendarAdapter extends BaseAdapter {
	private static final int FIRST_DAY_OF_WEEK = Calendar.MONDAY;
    private final Calendar calendar;
    private final CalendarItem today;
    private final CalendarItem selected;
    private final LayoutInflater inflater;
    private CalendarItem[] days;
	private Transmission item;

    public CalendarAdapter(Context context, Calendar monthCalendar, Transmission item) {
    	this.calendar = monthCalendar;
    	this.today = new CalendarItem(monthCalendar);
    	this.selected = new CalendarItem(monthCalendar);
        this.calendar.set(Calendar.DAY_OF_MONTH, 1);
        this.inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		this.item = item;
    }

    @Override
	public int getCount() {
        return days.length;
    }

    @Override
	public Object getItem(int position) {
        return days[position];
    }

    @Override
	public long getItemId(int position) {
    	final CalendarItem item = days[position];
    	if (item != null) {
    		return days[position].id;
    	}
    	return -1;
    }

    @Override
	public View getView(int position, View view, final ViewGroup parent) {
        if (view == null) {
            view = inflater.inflate(R.layout.calendar_item, null);
        }
        final TextView dayView = view.findViewById(R.id.date);
        final CalendarItem currentItem = days[position];
		final Calendar cal = Calendar.getInstance();
		final int y = cal.get(Calendar.YEAR);
		final int m = cal.get(Calendar.MONTH);
		final int d = cal.get(Calendar.DAY_OF_MONTH);
		//Log.i("OpenLDR","DAY_OF_MONTH:"+d);
        if (currentItem != null) {
			dayView.setText(currentItem.text);

			if(item != null && item.getYear() <= y && item.getMonth() <= (m+1)){
				if(item.getYear() == y && item.getMonth() == (m+1)) {
					if(currentItem.day <= d) {
						dayView.setTextColor(Color.WHITE);
						List<Integer> days = item.getDays();
						if (days.contains(currentItem.day))
							view.setBackgroundColor(Color.parseColor("#22b967"));
						else
							view.setBackgroundColor(Color.parseColor("#ff0000"));
					}
				}
				else if(item.getYear() <= y && item.getMonth() <= (m+1)) {
					dayView.setTextColor(Color.WHITE);
					List<Integer> days = item.getDays();
					if (days.contains(currentItem.day))
						view.setBackgroundColor(Color.parseColor("#22b967"));
					else
						view.setBackgroundColor(Color.parseColor("#ff0000"));
				}
			}
			//view.setBackgroundColor(Color.parseColor("#f9f9f9"));
        }

        return view;
    }

    public final void setSelected(int year, int month, int day) {
    	selected.year = year;
    	selected.month = month;
    	selected.day = day;
    	notifyDataSetChanged();
    }

    public final void refreshDays() {
    	final int year = calendar.get(Calendar.YEAR);
    	final int month = calendar.get(Calendar.MONTH);
    	final int firstDayOfMonth = calendar.get(Calendar.DAY_OF_WEEK);
    	final int lastDayOfMonth = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
		final int maxWeeknumber = calendar.getActualMaximum(Calendar.WEEK_OF_MONTH);
    	final int blankies;
    	final CalendarItem[] days;

//Log.i("OpenLDR","firstDayOfMonth:"+firstDayOfMonth);
    	if (firstDayOfMonth == FIRST_DAY_OF_WEEK) {
    		blankies = 0;
        } else if (firstDayOfMonth < FIRST_DAY_OF_WEEK) {
        	blankies = Calendar.SATURDAY - (FIRST_DAY_OF_WEEK - 1);
        } else {
        	blankies = firstDayOfMonth - FIRST_DAY_OF_WEEK;
        }

    	int len = lastDayOfMonth + blankies;
    	int gap = (7*(maxWeeknumber+(firstDayOfMonth >= 6 || firstDayOfMonth == 1 ? 1 : 0)))-len;
    	days = new CalendarItem[lastDayOfMonth + blankies + gap];

        for (int day = 1, position = blankies; position < days.length; position++) {
        	if(day <= lastDayOfMonth)
        		days[position] = new CalendarItem(year, month, day++);
        }

        this.days = days;
        notifyDataSetChanged();
    }

    private static class CalendarItem {
    	public int year;
    	public int month;
    	public int day;
    	public String text;
    	public long id;

    	public CalendarItem(Calendar calendar) {
    		this(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH));
    	}

    	public CalendarItem(int year, int month, int day) {
			this.year = year;
			this.month = month;
			this.day = day;
			this.text = String.valueOf(day);
			this.id = Long.valueOf(year + "" + month + "" + day);
		}

    	@Override
    	public boolean equals(Object o) {
    		if (o != null && o instanceof CalendarItem) {
    			final CalendarItem item = (CalendarItem)o;
    			return item.year == year && item.month == month && item.day == day;
    		}
    		return false;
    	}
    }
}
package com.kagaconnect.core.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.kagaconnect.core.data.Transmission;
import com.kagaconnect.core.data.TransmissionTotal;
import com.kagaconnect.openldrpro.R;

import java.util.Calendar;
import java.util.List;

public class TotalsAdapter extends BaseAdapter {
    private Context context;
    private List<TransmissionTotal> Totals;

    public TotalsAdapter(Context context, List<TransmissionTotal> totals) {
        this.context = context;
        this.Totals = totals;
    }

    @Override
    public int getCount() {
        return Totals.size();
    }

    @Override
    public Object getItem(int position) {
        return Totals.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View contentView, final ViewGroup parent) {
        TransmissionTotal item = (TransmissionTotal)getItem(position);

        if(contentView == null){
            LayoutInflater inflater = LayoutInflater.from(context);
            contentView = inflater.inflate(R.layout.total_item, parent, false);
        }

        TextView title = (TextView)(contentView.findViewById(R.id.title));
        title.setText(item.getName());

        String r = item.getRegistered()+"";
        TextView registered = (contentView.findViewById(R.id.registered));
        registered.setText(r);

        String t = item.getTested()+" ("+item.getTestedWorkload()+")";
        TextView tested = (contentView.findViewById(R.id.tested));
        tested.setText(t);

        String a = item.getAuthorised()+" ("+item.getAuthorisedWorkload()+")";
        TextView authorized = (contentView.findViewById(R.id.authorized));
        authorized.setText(a);

        return contentView;
    }
}

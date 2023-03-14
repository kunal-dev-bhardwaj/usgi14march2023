package com.universalsompo.meta.metaapp.motor.adapters;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import com.universalsompo.meta.R;
import com.universalsompo.meta.metaapp.motor.models.ClaimFilterModel;

import java.util.ArrayList;

public class AdapterFilter extends BaseAdapter implements Filterable {
    private ArrayList<ClaimFilterModel> data;
    private Context mContext;
    private final LayoutInflater mInflater;
    private ArrayList<ClaimFilterModel> filteredData = new ArrayList<>();
    private ItemFilter mFilter = new ItemFilter();
    private int Tag = 0;

    public AdapterFilter(Context mContext, ArrayList<ClaimFilterModel> data) {
        this.mContext = mContext;
        this.data = data;
        mInflater = LayoutInflater.from(mContext);
        filteredData.addAll(data);
    }

    public AdapterFilter(Context mContext, ArrayList<ClaimFilterModel> data, int Tag) {
        this.mContext = mContext;
        this.data = data;
        mInflater = LayoutInflater.from(mContext);
        filteredData.addAll(data);
        this.Tag = Tag;
    }

    public ClaimFilterModel getData(int position) {
        return filteredData.get(position);
    }

    @Override
    public int getCount() {
        return filteredData.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holderr;
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.item_search_view, null);
            holderr = new ViewHolder();
            holderr.tv = convertView.findViewById(R.id.name_filter);
            convertView.setTag(holderr);
        } else {
            holderr = (ViewHolder) convertView.getTag();
        }
        if (Tag==1) {
            if (filteredData.get(position).getName().equals("Use Current Location")) {
                holderr.tv.setText(filteredData.get(position).getName());
                holderr.tv.setTextColor(Color.parseColor("#FF08938A"));
            } else {
                holderr.tv.setText(filteredData.get(position).getName());
                holderr.tv.setTextColor(Color.parseColor("#000000"));
            }
        } else {
            holderr.tv.setText(filteredData.get(position).getName());
            holderr.tv.setTextColor(Color.parseColor("#000000"));
        }
        return convertView;
    }

    @Override
    public Filter getFilter() {
        return mFilter;
    }

    private class ItemFilter extends Filter {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            String filterString = constraint.toString().toLowerCase();
            FilterResults results = new FilterResults();
            final ArrayList<ClaimFilterModel> list = data;
            int count = list.size();
            final ArrayList<ClaimFilterModel> nlist = new ArrayList<>(count);
            ClaimFilterModel filterableString;
            for (int i = 0; i < count; i++) {
                filterableString = list.get(i);
                if (filterableString.getName().toLowerCase().contains(filterString)) {
                    nlist.add(filterableString);
                }
            }
            results.values = nlist;
            results.count = nlist.size();
            return results;
        }

        @SuppressWarnings("unchecked")
        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            filteredData = (ArrayList<ClaimFilterModel>) results.values;
            notifyDataSetChanged();
        }
    }

    class ViewHolder {
        public TextView tv;
    }


    @Override
    public boolean isEnabled(int position) {
        return super.isEnabled(position);
    }
}

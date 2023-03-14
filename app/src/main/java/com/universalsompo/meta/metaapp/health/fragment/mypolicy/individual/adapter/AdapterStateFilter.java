package com.universalsompo.meta.metaapp.health.fragment.mypolicy.individual.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Filter;
import android.widget.Filterable;

import com.universalsompo.meta.R;
import com.universalsompo.meta.metaapp.health.fragment.mypolicy.individual.model.StateFilterModel;

import java.util.ArrayList;

public class AdapterStateFilter extends BaseAdapter implements Filterable {
    private ArrayList<StateFilterModel> data;
    private Context mContext;
    private final LayoutInflater mInflater;
    private ArrayList<StateFilterModel> filteredData = new ArrayList<>();
    private ItemFilter mFilter = new ItemFilter();
    private int Tag = 0;
    private int temp ;

    public AdapterStateFilter(Context mContext, ArrayList<StateFilterModel> data) {
        this.mContext = mContext;
        this.data = data;
        mInflater = LayoutInflater.from(mContext);
        filteredData.addAll(data);
    }

    public AdapterStateFilter(Context mContext, ArrayList<StateFilterModel> data, int Tag) {
        this.mContext = mContext;
        this.data = data;
        mInflater = LayoutInflater.from(mContext);
        filteredData.addAll(data);
        this.Tag = Tag;
    }

    public StateFilterModel getData(int position) {
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
        ViewHolder holderr = null;
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
        }else {
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
            final ArrayList<StateFilterModel> list = data;
            int count = list.size();
            final ArrayList<StateFilterModel> nlist = new ArrayList<StateFilterModel>(count);
            StateFilterModel filterableString;
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
            filteredData = (ArrayList<StateFilterModel>) results.values;
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

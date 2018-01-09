package universe.com.universe.android.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import universe.com.universe.android.R;
import universe.com.universe.android.dao.State;
import universe.com.universe.android.dao.StateList;

/**
 * Created by gaurav.pandey on 29-12-2017.
 */

public class StateAdapter extends RecyclerView.Adapter<StateAdapter.StateViewHolder> {
    private Context mContext;
    private ArrayList<State> stateLists;

    public StateAdapter(Context mContext, ArrayList<State> stateLists) {
        this.stateLists = stateLists;
        this.mContext = mContext;
    }

    @Override
    public StateViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.state_list_item, parent, false);
        return new StateViewHolder(view);
    }

    @Override
    public void onBindViewHolder(StateViewHolder holder, int position) {
        State state=stateLists.get(position);
        holder.textViewState.setText(state.getTitle());

    }

    @Override
    public int getItemCount() {
        return stateLists.size();
    }

    public class StateViewHolder extends RecyclerView.ViewHolder {
        public TextView textViewState;

        public StateViewHolder(View itemView) {
            super(itemView);
            textViewState = itemView.findViewById(R.id.textViewState);

        }
    }
}

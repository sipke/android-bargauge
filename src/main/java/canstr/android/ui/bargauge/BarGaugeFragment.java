/*
 * Copyright (c) 2017. Sipke Vriend
 *
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 *   * Redistributions of source code must retain the above copyright notice,
 *     this list of conditions and the following disclaimer.
 *   * Redistributions in binary form must reproduce the above copyright
 *     notice, this list of conditions and the following disclaimer in the
 *     documentation and/or other materials provided with the distribution.
 *   * Neither the name of canstr nor the names of its contributors may be used
 *     to endorse or promote products derived from this software without
 *     specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGE.
 */

package canstr.android.ui.bargauge;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * A fragment representing a list of gauges as bars.
 * Usage
 *
     private BarGaugeFragment mBarGaugeFragment;
     private List<GaugeContent.GaugeItem> mList;
     private MyBarGaugeRecyclerViewAdapter mAdapter;

     // Initial setup
         if (mBarGaugeFragment == null) {
             mBarGaugeFragment = new BarGaugeFragment();
             mList = GaugeContent.ITEMS;
             GaugeContent.addItem("level", 0, 1);
             GaugeContent.addItem("other", 0, 1);
             GaugeContent.addItem("three", 0, 1);
             mAdapter = new MyBarGaugeRecyclerViewAdapter(mList);
             mBarGaugeFragment.setAdapter(mAdapter);
         }

     // Updates
 -            GaugeContent.updateItem(GaugeContent.GForceA, currentInfo.Acceleration.a);
 -            GaugeContent.updateItem(GaugeContent.GForceB, currentInfo.Acceleration.b);
 -            GaugeContent.updateItem(GaugeContent.GForceC, currentInfo.Acceleration.c);
 -            GaugeContent.updateItem(GaugeContent.TurnA, currentInfo.TurnRate.a);
 -            GaugeContent.updateItem(GaugeContent.TurnB, currentInfo.TurnRate.b);
 -            GaugeContent.updateItem(GaugeContent.TurnC, currentInfo.TurnRate.c);
 -            GaugeContent.updateItem(GaugeContent.GpsSpeed, gps.velocity);
 -            GaugeContent.updateItem(GaugeContent.GpsDirection, gps.dir);
 -            GaugeContent.updateItem(GaugeContent.GpsAltitude, gps.altitude);
 -            mAdapter.notifyDataSetChanged();

 * <p/>
 */
public class BarGaugeFragment extends Fragment {

    private int mColumnCount = 1;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public BarGaugeFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_bargauge_list, container, false);

        // Set the adapter
        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            recyclerView = (RecyclerView) view;
            if (mColumnCount <= 1) {
                recyclerView.setLayoutManager(new LinearLayoutManager(context));
            } else {
                recyclerView.setLayoutManager(new GridLayoutManager(context, mColumnCount));
            }
            recyclerView.setAdapter(mAdapter);
        }
        return view;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    public void setAdapter(MyBarGaugeRecyclerViewAdapter adapter) {
        if (adapter != null) {
            mAdapter = adapter;
            mObserver = new GaugeDataObserver();
            mAdapter.registerAdapterDataObserver(mObserver);
        }
    }

    class GaugeDataObserver extends RecyclerView.AdapterDataObserver {

        private static final String TAG = "AdapterDataSetObserver";

        @Override
        public void onChanged() {
            //String blah = "we're in on Changed";
            //Log.v(TAG, TAG + ":onChanged()");
        }
    }

    private MyBarGaugeRecyclerViewAdapter mAdapter;
    private GaugeDataObserver mObserver;
    private RecyclerView recyclerView;
}

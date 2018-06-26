package com.jorgereina.calendars.calendarfragment;

import android.app.Fragment;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.jorgereina.calendars.R;
import com.jorgereina.calendars.calendarfragment.MonthFragmentPresenterContract.Presenter;
import com.jorgereina.calendars.databinding.FragmentMonthBinding;
import com.jorgereina.calendars.model.Event;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jorgereina on 6/25/18.
 */

public class MonthFragment extends Fragment implements MonthFragmentPresenterContract.View {

    private FragmentMonthBinding binding;
    private Presenter presenter;
    private List<Event> events = new ArrayList<>();
    private RecyclerView.LayoutManager layoutManager;
    private MonthAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_month, container, false);
        presenter = new MonthFragmentPresenter(this, events);
        presenter.onViewInitialized();
        adapter = new MonthAdapter(presenter);
        layoutManager = new LinearLayoutManager(getActivity());
        binding.monthEventsRv.setLayoutManager(layoutManager);
        binding.monthEventsRv.setAdapter(adapter);

        return binding.getRoot();
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);



    }

    @Override
    public void loadEventData() {
        adapter.notifyDataSetChanged();
    }

    @Override
    public void showProgress() {
        binding.progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        binding.progressBar.setVisibility(View.GONE);
    }

    @Override
    public void showDayDetails() {

    }

    @Override
    public void fetchEventError(String message) {
        Toast.makeText(getActivity(), message, Toast.LENGTH_LONG).show();
    }
}

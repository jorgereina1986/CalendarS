package com.jorgereina.calendars.dayfragment;

import android.app.Fragment;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.jorgereina.calendars.R;
import com.jorgereina.calendars.calendarfragment.MonthAdapter;
import com.jorgereina.calendars.databinding.FragmentDayBinding;
import com.jorgereina.calendars.model.Event;

import org.parceler.Parcels;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jorgereina on 6/25/18.
 */

public class DayFragment extends Fragment implements DayPresenterContract.View {

    private static final String EVENT_LIST_PARCEL = "event_list_parcel";
    private static final String DAY_PARCEL = "day_parcel";

    private DayPresenterContract.Presenter presenter;
    private FragmentDayBinding binding;
    private MonthAdapter adapter;
    private RecyclerView.LayoutManager layoutManager;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_day, container, false);
        presenter = new DayFragmentPresenter(this);
        hideProgress();
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Bundle bundle = this.getArguments();
        List<Event> events = Parcels.unwrap(bundle.getParcelable(EVENT_LIST_PARCEL));
        final int day = bundle.getInt(DAY_PARCEL);

        Toast.makeText(getActivity(), events.get(0).getTitle() + " " + day, Toast.LENGTH_LONG).show();

        binding.addEventButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.onCreateEventSelected(
                        binding.titleEt.getText().toString(),
                        String.valueOf(day),
                        binding.descriptionEt.getText().toString(),
                        binding.timeEt.getText().toString());
            }
        });
    }

    public static DayFragment newInstance(List<Event> event, int day) {
        Bundle bundle = new Bundle();
        bundle.putParcelable(EVENT_LIST_PARCEL, Parcels.wrap(event));
        bundle.putInt(DAY_PARCEL, day);
        DayFragment fragment = new DayFragment();
        fragment.setArguments(bundle);
        return fragment;
    }


    @Override
    public void showProgress() {
        binding.dayPb.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        binding.dayPb.setVisibility(View.INVISIBLE);
    }

    @Override
    public void loadEventsToRecyclerView() {
        makeToast(R.string.event_not_created);
    }

    @Override
    public void eventCreatedSuccess() {
        binding.titleEt.setText("");
        binding.descriptionEt.setText("");
        binding.timeEt.setText("");
        makeToast(R.string.event_created);
    }

    @Override
    public void eventFailedToCreate() {

    }

    private void makeToast(int message) {
        Toast.makeText(getActivity(), getString(message), Toast.LENGTH_LONG).show();
    }
}

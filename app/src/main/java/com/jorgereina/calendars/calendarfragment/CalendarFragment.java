package com.jorgereina.calendars.calendarfragment;

import android.app.Fragment;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jorgereina.calendars.R;
import com.jorgereina.calendars.databinding.FragmentCalendarBinding;

/**
 * Created by jorgereina on 6/25/18.
 */

public class CalendarFragment extends Fragment implements CalendarFragmentPresenterContract.View {

    private FragmentCalendarBinding binding;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_calendar, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


    }
}

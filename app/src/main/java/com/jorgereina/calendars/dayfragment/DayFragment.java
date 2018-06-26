package com.jorgereina.calendars.dayfragment;

import android.app.Fragment;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jorgereina.calendars.R;
import com.jorgereina.calendars.databinding.FragmentDayBinding;
import com.jorgereina.calendars.model.Event;

import org.parceler.Parcels;

/**
 * Created by jorgereina on 6/25/18.
 */

public class DayFragment extends Fragment {

    private static final String EVENT_PARCEL = "event_parcel";

    private FragmentDayBinding binding;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(
                inflater,
                R.layout.fragment_day,
                container,
                false);
        return binding.getRoot();
    }

    public static DayFragment newInstance(Event event) {
        Bundle bundle = new Bundle();
        bundle.putParcelable(EVENT_PARCEL, Parcels.wrap(event));
        DayFragment fragment = new DayFragment();
        fragment.setArguments(bundle);
        return fragment;
    }
}

package cl.vicentepc.wine.main;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import cl.vicentepc.wine.R;
import cl.vicentepc.wine.adapters.WinesAdapter;
import cl.vicentepc.wine.models.Wine;


/**
 * A simple {@link Fragment} subclass.
 */
public class WinesFragment extends Fragment {

    private WinesAdapter adapter;

    public WinesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_wine, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        RecyclerView recyclerView = view.findViewById(R.id.recyclerViewWine);
        recyclerView.setHasFixedSize(true);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);

        adapter = new WinesAdapter();
        recyclerView.setAdapter(adapter);

    }

    public void updateList(Wine wine) {
        adapter.update(wine);
        Log.e("PENDING", wine.getWineName());
    }

}

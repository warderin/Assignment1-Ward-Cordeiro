package erin.assignment1_ward_cordeiro;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.List;

import erin.assignment1_ward_cordeiro.db.SongDataSource;

/**
 * Created by Erin on 2015-09-21.
 */
public class SongFragment extends Fragment {

    public SongFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_songs, container, false);

        SongDataSource ds = new SongDataSource(this);

        List<Song> songs = ds.getSongs();

        ListView listView = (ListView) getActivity().findViewById(R.id.songList);

        SongAdapter adapter = new SongAdapter(this, android.R.layout.simple_list_item_1, songs);

        listView.setAdapter(adapter);

        return view;
    }

}

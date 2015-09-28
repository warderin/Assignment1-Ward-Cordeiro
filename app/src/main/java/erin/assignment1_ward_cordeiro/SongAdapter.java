package erin.assignment1_ward_cordeiro;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Erin on 2015-09-22.
 */
public class SongAdapter extends ArrayAdapter<Song> {

    private List<Song> songs;

    public SongAdapter(Context context, int resource, List<Song> players) {
        super(context, resource, players);
        this.songs = songs;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        if (view == null) {
            LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.song_list_item, null);
        }

        Song song = songs.get(position);

        TextView txtName = (TextView) view.findViewById(R.id.songName);
        TextView txtDuration = (TextView) view.findViewById(R.id.songDuration);

        txtName.setText(song.getName());
        txtDuration.setText("Duration: " + song.getDuration());

        return view;

    }
}

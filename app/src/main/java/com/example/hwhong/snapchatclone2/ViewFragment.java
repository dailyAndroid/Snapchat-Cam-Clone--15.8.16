package com.example.hwhong.snapchatclone2;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

/**
 * A simple {@link Fragment} subclass.
 */
public class ViewFragment extends Fragment {

    private VideoView videoView;
    private final int REQUEST_CODE = 100;

    public ViewFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.viewfrag, container, false);

        videoView = (VideoView) view.findViewById(R.id.videoView);

        return view;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == REQUEST_CODE) {
            Intent intent = getActivity().getIntent();

            Uri uri = intent.getParcelableExtra("vid");

            videoView.setVideoURI(uri);
        }
    }
}

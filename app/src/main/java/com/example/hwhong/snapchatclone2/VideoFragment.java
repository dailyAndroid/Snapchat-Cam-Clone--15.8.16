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
import android.widget.VideoView;

import java.io.File;

/**
 * A simple {@link Fragment} subclass.
 */
public class VideoFragment extends Fragment {

    private final int REQUEST_CODE = 100;


    public VideoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        Intent intent = new Intent(MediaStore.ACTION_VIDEO_CAPTURE);
        File file = getFile();
        Uri vid = Uri.fromFile(file);
        intent.putExtra(MediaStore.EXTRA_OUTPUT, vid);
        //1 means maximum quality
        intent.putExtra(MediaStore.EXTRA_VIDEO_QUALITY,1);


        startActivityForResult(intent, REQUEST_CODE);

        //startActivity(intent);

        return inflater.inflate(R.layout.vidfrag, container, false);
    }

    public File getFile() {

        File folder = new File("sdcard/vid");
        if(folder.exists()) {
            folder.mkdir();
        }

        File vidFile = new File(folder, "captured.mp4");

        return vidFile;
    }

}

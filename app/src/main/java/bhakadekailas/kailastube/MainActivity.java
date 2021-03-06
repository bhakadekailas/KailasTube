package bhakadekailas.kailastube;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentResolver;
import android.content.Context;
import android.graphics.PixelFormat;
import android.net.Uri;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Context context = MainActivity.this;

        //logic 1
        VideoView videoView = findViewById(R.id.videoView);
        videoView.setVideoPath("android.resource://" + getPackageName() + "/" + R.raw.kotlin);
        MediaController mediaController = new MediaController(context);
        videoView.setMediaController(mediaController);
        videoView.start();

        //logic 2
//        getWindow().setFormat(PixelFormat.TRANSLUCENT);
//        VideoView videoHolder = new VideoView(this);
//        videoHolder.setMediaController(new MediaController(this));
//        Uri video = getUriFromRawFile(context, R.raw.kotlin);
//        videoHolder.setVideoURI(video);
//        setContentView(videoHolder);
//        videoHolder.start();
    }

    public Uri getUriFromRawFile(Context context, int rawResourceId) {
        return new Uri.Builder()
                .scheme(ContentResolver.SCHEME_ANDROID_RESOURCE)
                .authority(context.getPackageName())
                .path(String.valueOf(rawResourceId))
                .build();
    }
}
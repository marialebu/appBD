package com.isc.itsta.proyecto;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CameraController extends Activity {
    //private static final int CAMERA_REQUEST = 10;
    static final int REQUEST_IMAGE_CAPTURE = 1;
    ImageView mimageView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.camera_controller);
        mimageView = (ImageView) this.findViewById(R.id.image_from_camera);
        Button button = (Button) this.findViewById(R.id.take_image_from_camera);
    }


    File imgFile;
    String fileCurrentPath;
    public void takeImageFromCamera(View view)  throws IOException {
        Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        File pictureDirectory = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_NOTIFICATIONS);
        String picturName = getPictureName();
        Log.i("INFO", pictureDirectory.getPath() + ' ' + picturName );
        imgFile = new File(pictureDirectory, picturName);
        Uri picturUri = Uri.fromFile(imgFile);
        cameraIntent.putExtra(MediaStore.EXTRA_OUTPUT, picturUri );
        startActivityForResult(cameraIntent, REQUEST_IMAGE_CAPTURE);

    }

    private void galleryAddPic() {
        Intent mediaScanIntent = new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE);
        Uri contentUri = Uri.fromFile(imgFile);
        mediaScanIntent.setData(contentUri);
        this.sendBroadcast(mediaScanIntent);
    }





    private String getPictureName() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd_HHmmss");
        String time_stamp = sdf.format(new Date());
        String pictname="micos_images_" + time_stamp + ".jpg";
        Log.i("INFO " , pictname);
        return pictname;

    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {

            galleryAddPic();//send broadcast message
            Log.i("", " sving pict");

        }
    }

}

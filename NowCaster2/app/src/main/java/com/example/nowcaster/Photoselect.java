package com.example.nowcaster;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.nowcaster.ml.Modelcodebasics1st;

import org.tensorflow.lite.DataType;
import org.tensorflow.lite.support.image.TensorImage;
import org.tensorflow.lite.support.tensorbuffer.TensorBuffer;

import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Arrays;

public class Photoselect extends AppCompatActivity {
    public static final int CAMERA_PERM_CODE = 101;
    public static final int CAMERA_REQUEST_CODE = 102;
    public static final int GALLERY_REQUEST_CODE = 105;
    Button cameraBtn,galleryBtn;
    String[] Labels=new String[]{"Altocumulus","Altostratus","Cumulonimbus","Cirrocumulus","Cirrus","Cirrostratus","Contrails","Cumulus","Nimbostratus","Stratocumulus","Stratus","Clear Sky","Night Sky"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Context context;
        context = this;
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_photoselect2);
        cameraBtn = findViewById(R.id.camera);
        galleryBtn = findViewById(R.id.selectfrom);
        cameraBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                askCameraPermissions();
            }
        });
        galleryBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gallery = new Intent(Intent.ACTION_PICK,MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(gallery, GALLERY_REQUEST_CODE);
            }
        });
    }
    private void askCameraPermissions() {
        if(ContextCompat.checkSelfPermission(this,Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this,new String[] {Manifest.permission.CAMERA}, CAMERA_PERM_CODE);
        }else {
            dispatchTakePictureIntent();
        }

    }
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if(requestCode == CAMERA_PERM_CODE){
            if(grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                dispatchTakePictureIntent();
            }else {
                Toast.makeText(this, "Camera Permission is Required to Use camera.", Toast.LENGTH_SHORT).show();
            }
        }
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == CAMERA_REQUEST_CODE) {
            if (resultCode == Activity.RESULT_OK) {
                Bundle bundle=data.getExtras();
                Log.d("tag", "Cameara Started");
                Bitmap bmp=(Bitmap)bundle.get("data");
                int maxAt = 0;
                Log.d("tag", "Bitmap Assigned" + data);
                bmp = Bitmap.createScaledBitmap(bmp, 150, 150, true);
                Log.d("tag", "Bitmap Scaled" + data);
                try {
                    Modelcodebasics1st model = Modelcodebasics1st.newInstance(getApplicationContext());

                    // Creates inputs for reference.
                    TensorBuffer inputFeature0 = TensorBuffer.createFixedSize(new int[]{1, 150, 150, 3}, DataType.FLOAT32);
                    TensorImage tensorImage = new TensorImage(DataType.FLOAT32);
                    tensorImage.load(bmp);
                    ByteBuffer byteBuffer = tensorImage.getBuffer();

                    inputFeature0.loadBuffer(byteBuffer);

                    // Runs model inference and gets result.
                    Modelcodebasics1st.Outputs outputs = model.process(inputFeature0);
                    TensorBuffer outputFeature0 = outputs.getOutputFeature0AsTensorBuffer();

                    // Releases model resources if no longer used.
                    model.close();

                    for (int i = 0; i < outputFeature0.getFloatArray().length; i++) {
                        maxAt = outputFeature0.getFloatArray()[i] > outputFeature0.getFloatArray()[maxAt] ? i : maxAt;
                    }
                    Log.d("tag", Labels[maxAt]);
                } catch (IOException e) {
                    // TODO Handle the exception
                }

                Intent it=new Intent(this,Result.class);
                it.putExtra("message", Labels[maxAt]);
                startActivity(it);
            }

        }
        if (requestCode == GALLERY_REQUEST_CODE) {
            if (resultCode == Activity.RESULT_OK) {
                Bitmap bmp=null;
                int maxAt = 0;
                Uri uri = data.getData();
                try {
                    bmp = MediaStore.Images.Media.getBitmap(this.getContentResolver(), uri);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                Log.d("tag", "ABsolute extra of Image is NULL" + data);

                Log.d("tag", "ABsolute bmp of Image is " + bmp);
                bmp = Bitmap.createScaledBitmap(bmp, 150, 150, true);
                try {
                    Modelcodebasics1st model = Modelcodebasics1st.newInstance(getApplicationContext());

                    // Creates inputs for reference.
                    TensorBuffer inputFeature0 = TensorBuffer.createFixedSize(new int[]{1, 150, 150, 3}, DataType.FLOAT32);
                    TensorImage tensorImage = new TensorImage(DataType.FLOAT32);
                    tensorImage.load(bmp);
                    ByteBuffer byteBuffer = tensorImage.getBuffer();

                    inputFeature0.loadBuffer(byteBuffer);

                    // Runs model inference and gets result.
                    Modelcodebasics1st.Outputs outputs = model.process(inputFeature0);
                    TensorBuffer outputFeature0 = outputs.getOutputFeature0AsTensorBuffer();

                    // Releases model resources if no longer used.
                    model.close();


                    for (int i = 0; i < outputFeature0.getFloatArray().length; i++) {
                        maxAt = outputFeature0.getFloatArray()[i] > outputFeature0.getFloatArray()[maxAt] ? i : maxAt;
                    }
                    Log.d("tag", Labels[maxAt]);
                    String a=Labels[maxAt];
                    Log.d("tag", a);
                } catch (IOException e) {
                    // TODO Handle the exception
                }

                Intent it=new Intent(this,Result.class);
                it.putExtra("message", Labels[maxAt]);
                startActivity(it);
            }

        }
    }
    private void dispatchTakePictureIntent() {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(takePictureIntent, CAMERA_REQUEST_CODE);
        }
    }
}
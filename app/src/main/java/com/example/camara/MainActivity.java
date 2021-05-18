package com.example.camara;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.media.MediaSession2Service;
import android.os.Bundle;
import android.provider.MediaStore;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btnFoto;
    ImageView ivFoto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnFoto = (Button) findViewById(R.id.btnFoto);
        ivFoto = (ImageView) findViewById(R.id.ivFoto);
    }
    public void Capturar (View view)
    {
        Toast.makeText( context:this, text:"Comenzando camaara",Toast.LENGTH_SHORT).show();
        Intent i = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(i, requestCode:0);
    }

    @Override
    protected   void onActivityResult(int requestCode, int ResultCode, Intent data)
    {
        super.onActivivityResult(requestCode, resultCode,data);
        if (resultCode == Activity.RESULT_OK)
        {
            bundle ext = data.getExtras();
            Bitmap bmp =  (Bitmap)data.getExtras().get("data");
            ivFoto.setImageBitmap(bmp);
        }
    }
}
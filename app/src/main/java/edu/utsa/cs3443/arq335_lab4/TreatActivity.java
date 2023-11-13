package edu.utsa.cs3443.arq335_lab4;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

import java.security.SecureRandom;

public class TreatActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_treat);
        //probably call all the stuff I need
        //setupPicture();

//        int[] photos = {R.drawable.image1, R.drawable.image2, R.drawable.image3, R.drawable.image4, R.drawable.image5,
//                R.drawable.image6, R.drawable.image7, R.drawable.image8, R.drawable.image9};

        displayImage();
    }

    public void displayImage(){
        int[] photos = {R.drawable.image1, R.drawable.image2, R.drawable.image3, R.drawable.image4, R.drawable.image5,
                R.drawable.image6, R.drawable.image7, R.drawable.image8, R.drawable.image9};

        ImageView imView = (ImageView)findViewById(R.id.treat_photo);
        SecureRandom secureRandom = new SecureRandom();
        int randPhoto = secureRandom.nextInt(photos.length);
        imView.setImageResource(photos[randPhoto]);
    }
}
package sg.edu.rp.c346.id19020424.myapplicationmsa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button next,learnMore;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        learnMore = findViewById(R.id.button);
        next = findViewById(R.id.button2);

        learnMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url="https://github.com/Ryan19020424";
                Intent intenturl= new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                startActivity(intenturl);
            }
        });
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentnext = new Intent(MainActivity.this,ItemListActivity.class);
                startActivity(intentnext);
            }
        });
    }
}
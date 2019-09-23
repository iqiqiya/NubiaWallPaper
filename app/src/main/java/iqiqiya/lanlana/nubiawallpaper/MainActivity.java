package iqiqiya.lanlana.nubiawallpaper;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,toastMessage("未被hook,你真笨"),Toast.LENGTH_SHORT).show();
            }
        });
    }

    public String toastMessage(String str1) {
        return str1;
    }
}

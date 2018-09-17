package android.ming.com.mouse;

import android.content.Intent;
import android.ming.com.zjmmc.utils.ZJMMCMainActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void show(View view){
        startActivity(new Intent(this, ZJMMCMainActivity.class));
    }
}

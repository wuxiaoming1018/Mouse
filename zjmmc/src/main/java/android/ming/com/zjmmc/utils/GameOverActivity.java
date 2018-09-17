package android.ming.com.zjmmc.utils;

import android.content.Intent;
import android.ming.com.zjmmc.R;
import android.ming.com.zjmmc.adapter.CorrectListAdapter;
import android.ming.com.zjmmc.data.ConfigData;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;

import static android.ming.com.zjmmc.utils.ZJMMCMainActivity.DATA_LIST;

public class GameOverActivity extends AppCompatActivity implements View.OnClickListener{

    private ImageView sunShine, reStart, playAgain;
    private ListView list;
    private ImageView close;
    private ArrayList<ConfigData> dataList;
    private CorrectListAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.zjmmc_activity_game_over);
        dataList = (ArrayList<ConfigData>) getIntent().getSerializableExtra(DATA_LIST);
        initView();
    }

    private void initView() {
        list = (ListView) findViewById(R.id.list);
        adapter = new CorrectListAdapter(this, dataList);
        list.setAdapter(adapter);

        sunShine = (ImageView) findViewById(R.id.sunShine);
        reStart = (ImageView) findViewById(R.id.reStart);
        reStart.setOnClickListener(this);
        playAgain = (ImageView) findViewById(R.id.playAgain);
        playAgain.setOnClickListener(this);
        close = (ImageView) findViewById(R.id.close);
        close.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.close) {
            setResult(RESULT_CANCELED);
            GameOverActivity.this.finish();
        } else if (id == R.id.reStart) {
            Intent intent = new Intent();
            intent.putExtra(DATA_LIST, getCorrectData(false));
            setResult(RESULT_OK, intent);
            GameOverActivity.this.finish();
        } else if (id == R.id.playAgain) {
            Intent intent = new Intent();
            intent.putExtra(DATA_LIST, dataList);
            setResult(RESULT_OK, intent);
            GameOverActivity.this.finish();
        }
    }

    private ArrayList<ConfigData> getCorrectData(boolean correct) {
        ArrayList<ConfigData> list = new ArrayList<>();
        if (dataList != null && dataList.size() > 0) {
            for (int i = 0; i < dataList.size(); i++) {
                if (dataList.get(i).isCorrect() == correct) {
                    list.add(dataList.get(i));
                }
            }
        }
        return list;
    }

}

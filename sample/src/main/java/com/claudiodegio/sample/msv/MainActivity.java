package com.claudiodegio.sample.msv;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);
    }


    @OnClick({R.id.bt_simple, R.id.bt_suggestions, R.id.bt_filter, R.id.bt_themed})
    public void onButtonClick(View view){

        Intent intent = null;

        switch (view.getId()) {
            case R.id.bt_simple:
                intent = new Intent(this, MatSearchViewActivity.class);
                break;
            case R.id.bt_suggestions:
                intent = new Intent(this, MatSearchViewSuggestionActivity.class);
                break;
            case R.id.bt_filter:
                intent = new Intent(this, MatSearchViewFilterActivity.class);
                break;
            case R.id.bt_themed:
                intent = new Intent(this, ThemedMatSearchViewActivity.class);
                break;
        }

        if (intent != null) {
            startActivity(intent);
        }
    }
}

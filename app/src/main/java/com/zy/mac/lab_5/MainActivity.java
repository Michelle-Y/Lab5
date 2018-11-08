package com.zy.mac.lab_5;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

import java.util.HashSet;
import java.util.Set;

public class MainActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener {
//    private CheckBox;
    private RadioButton radioButtonBoy, radioButtonGirl;
    private String string = new String();
    private Set<String> set = new HashSet<String>();
    private TextView textView;
    public EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        initText();
    }
    public void initText() {
        if (radioButtonGirl.isChecked()) {
            string ="It is better to travel ten thousand miles than to read ten thousand books.";
        } else {
            string="Books are a uniquely portable magic.";
        }

    }
    private void initViews() {
        textView = (TextView) findViewById(R.id.tv_result);
        radioButtonBoy = (RadioButton) findViewById(R.id.boy);
        radioButtonGirl = (RadioButton) findViewById(R.id.girl);
        radioButtonBoy.setOnCheckedChangeListener(this);
        radioButtonGirl.setOnCheckedChangeListener(this);
        editText = (EditText) findViewById(R.id.editText);
    }
    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        switch (buttonView.getId()) {
            case R.id.boy:
                if (isChecked) {
                    string="Books are a uniquely portable magic. ";
                    ImageView fox = findViewById(R.id.imageView);
                    fox.setImageResource(R.drawable.fox);
                }
                break;
            case R.id.girl:
                if (isChecked) {
                    string="It is better to travel ten thousand miles than to read ten thousand books. ";
                    ImageView travel = findViewById(R.id.imageView);
                    travel.setImageResource(R.drawable.travel);
                }
                break;
        }
    }
    public void commit(View view) {
        EditText nameValue = findViewById(R.id.editText);
        String nameText = nameValue.getText().toString();
        set.add(nameText);
        textView.setText(string.toString() + "My favorite is " + set.toString());
    }
}

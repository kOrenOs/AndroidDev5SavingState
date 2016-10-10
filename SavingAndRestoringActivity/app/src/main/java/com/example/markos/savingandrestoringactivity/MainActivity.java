package com.example.markos.savingandrestoringactivity;

import android.app.DialogFragment;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements InputDialog.InputInterface {

    private final String TEXTVIEW_STATEKEY = "TEXTVIEW_STATEKEY";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView tv = (TextView) findViewById(R.id.displayText);
        if(savedInstanceState != null){
            if(savedInstanceState.containsKey(TEXTVIEW_STATEKEY)){
                tv.setText(savedInstanceState.getString(TEXTVIEW_STATEKEY));
            }
        }
    }

    @Override
    public void getData(DialogFragment dialog, String data) {
        TextView text = (TextView) findViewById(R.id.displayText);
        text.setText(data);
    }

    public void openDialogAction(View view){
        InputDialog id = new InputDialog();
        id.show(getFragmentManager(), "");
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        TextView tv = (TextView) findViewById(R.id.displayText);
        outState.putString(TEXTVIEW_STATEKEY, tv.getText().toString());
    }
}

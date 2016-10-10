package com.example.markos.savingandrestoringactivity;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

/**
 * Created by Markos on 10. 10. 2016.
 */

public class InputDialog extends DialogFragment {

    public interface InputInterface{
        public void getData(DialogFragment dialog, String data);
    }

    private InputInterface inputInterface;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        try{
            inputInterface = (InputInterface) activity;
        }catch (ClassCastException e){
            throw new ClassCastException(activity.toString() + " must implement InputInterface");
        }
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder b = new AlertDialog.Builder(getActivity());
        LayoutInflater li = getActivity().getLayoutInflater();
        final View dialogView = li.inflate(R.layout.dialog_layout, null);
        b.setView(dialogView).setTitle("Fill in")
                .setPositiveButton("Add", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        EditText et = (EditText) dialogView.findViewById(R.id.editedText);
                        inputInterface.getData(InputDialog.this, et.getText().toString());
                    }
                })
                .setNegativeButton("Cancle", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    }
                });
        return b.create();
    }
}

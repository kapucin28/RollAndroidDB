package com.kapucin28.rollandroiddb.input;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

import com.kapucin28.rollandroiddb.R;

/**
 * Created by K@puc!n on 12-Jun-16.
 * 
 *      This class will open an alert box in which the user will
 * complete the name, email and phone of the person that will be
 * removed from the database
 */
public class RemovePersonAlert extends DialogFragment {

    // SendResult interface-------------------------------------------------------------------------
    private SendResult sendResult;
    //----------------------------------------------------------------------------------------------

    // Layout variables-----------------------------------------------------------------------------
    private LayoutInflater layoutInflater;
    private View view;
    private EditText removeID;
    private AlertDialog.Builder builder;
    //----------------------------------------------------------------------------------------------

    // OnCreate method------------------------------------------------------------------------------
    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        // Initializing views-----------------------------------------------------------------------
        layoutInflater = getActivity().getLayoutInflater();
        view = layoutInflater.inflate(R.layout.remove_person_alert_box, null);
        removeID = (EditText) view.findViewById(R.id.remove_edit_text);
        //------------------------------------------------------------------------------------------

        // Initializing builder---------------------------------------------------------------------
        builder = new AlertDialog.Builder(getActivity());
        builder.setView(view).setPositiveButton("REMOVE", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                sendResult.userInputID(removeID.getText().toString());
            }
        }).setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });

        return builder.create();
    }
    //----------------------------------------------------------------------------------------------

    // OnAttach method------------------------------------------------------------------------------
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        sendResult = (SendResult) activity;
    }
    //----------------------------------------------------------------------------------------------

    // Communicating method-------------------------------------------------------------------------
    public interface SendResult {
        void userInputID(String ID);
    }
    //----------------------------------------------------------------------------------------------
}

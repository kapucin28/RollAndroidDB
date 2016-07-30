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
 * complete the name, email and phone
 */
public class AddPersonAlert extends DialogFragment {

    // Sending Results interface--------------------------------------------------------------------
    private SendResults sendResults;
    //----------------------------------------------------------------------------------------------

    // Layout variables-----------------------------------------------------------------------------
    private LayoutInflater layoutInflater;
    private View view;
    private EditText personNameText, personEmailText, personPhoneText;
    private AlertDialog.Builder builder;
    //----------------------------------------------------------------------------------------------

    // OnCreate method------------------------------------------------------------------------------
    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        // Initializing views-----------------------------------------------------------------------
        layoutInflater = getActivity().getLayoutInflater();
        view = layoutInflater.inflate(R.layout.add_person_alert_box, null);
        personNameText = (EditText) view.findViewById(R.id.person_name_alert_box_edit_text);
        personEmailText = (EditText) view.findViewById(R.id.person_email_alert_box_edit_text);
        personPhoneText = (EditText) view.findViewById(R.id.person_phone_alert_box_edit_text);
        //------------------------------------------------------------------------------------------

        // Initializing builder---------------------------------------------------------------------
        builder = new AlertDialog.Builder(getActivity());
        builder.setView(view).setPositiveButton("CREATE", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                sendResults.userInputPersonDetails(personNameText.getText().toString(),
                        personEmailText.getText().toString(), personPhoneText.getText().toString());
            }
        }).setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        //------------------------------------------------------------------------------------------

        return builder.create();
    }
    //----------------------------------------------------------------------------------------------

    // OnAttach method------------------------------------------------------------------------------
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        sendResults = (SendResults) activity;
    }
    //----------------------------------------------------------------------------------------------

    // Communicating method-------------------------------------------------------------------------
    public interface SendResults {
        void userInputPersonDetails(String personName, String personEmail, String personPhone);
    }
    //----------------------------------------------------------------------------------------------
}

package com.kapucin28.rollandroiddb.input;

import android.app.Dialog;
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
 */
public class AddPersonAlert extends DialogFragment{

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

        return super.onCreateDialog(savedInstanceState);
    }
    //----------------------------------------------------------------------------------------------
}

package com.example.androiduibasics.modal;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;

import com.example.androiduibasics.R;

import timber.log.Timber;

public class DialogExample extends DialogFragment
{

    private FragmentActivity mContext;
    private onDialogClickListener onDialogClickListener;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        mContext = (FragmentActivity) context;
        onDialogClickListener = (DialogExample.onDialogClickListener) mContext;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {


        LayoutInflater inflater = mContext.getLayoutInflater();
        View view = inflater.inflate(R.layout.custom_toolbar, null);

        //1.Create Dialog Fragment  with Title and Message First

        AlertDialog.Builder alertDBuilder = new AlertDialog.Builder(mContext);
        alertDBuilder.setTitle(" Code ?").setMessage(" I m asking you again ");


        //2.Add Action Buttons (Positive +Negative + Neutral)
        alertDBuilder.setPositiveButton("Yes ", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                Timber.w("Pressing Ok ");
                onDialogClickListener.onClickPositive();

            }
        });


        alertDBuilder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                Timber.w("Pressing No ");
                onDialogClickListener.onClicknegative();
            }
        });


        alertDBuilder.setNeutralButton("Maybe", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                Timber.w("Pressing Maybe ");
            }
        });


        alertDBuilder.setView(view);

        AlertDialog alertDialog = alertDBuilder.create();
        return alertDialog;
    }


    @Override
    public void onDismiss(DialogInterface dialog) {
        super.onDismiss(dialog);
        Timber.w("Dissmised ");

    }

    @Override
    public void onCancel(DialogInterface dialog) {
        super.onCancel(dialog);
        Timber.w("Canceled ");
    }

    interface onDialogClickListener {

        void onClickPositive();

        void onClicknegative();

    }
}

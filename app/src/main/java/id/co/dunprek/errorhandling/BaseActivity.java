package id.co.dunprek.errorhandling;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.Toast;

import id.co.dunprek.errorhandling.model.APIError;
import id.co.dunprek.errorhandling.ui.FirstActivity;
import id.co.dunprek.errorhandling.utils.ErrorUtils;
import retrofit2.Response;


public class BaseActivity extends AppCompatActivity {

    protected void showToast(Context context, String message) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
    }


    public void showAlertNoInternet() {
        AlertDialog alertDialog = new AlertDialog.Builder(this)
                .setMessage("Koneksi Internet Tidak Tersedia")
                .setCancelable(false)
                .setPositiveButton(R.string.retry, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        recreate();
                    }
                })
                .create();
        alertDialog.show();
        //set dialog button color
        //get color
        int buttonColor = getResources().getColor(R.color.colorAccent);
        //get the positive button
        Button pbutton = alertDialog.getButton(DialogInterface.BUTTON_POSITIVE);
        //set the color to the buttton
        pbutton.setTextColor(buttonColor);
    }

    public void showAlertError(Response response) {
        APIError apiError = ErrorUtils.parseError(response);

        AlertDialog alertDialog = new AlertDialog.Builder(this)
                .setMessage(apiError.getError())
                .setCancelable(false)
                .setPositiveButton(R.string.retry, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        recreate();
                    }
                })
                .create();
        alertDialog.show();
        //set dialog button color
        //get color
        int buttonColor = getResources().getColor(R.color.colorAccent);
        //get the positive button
        Button pbutton = alertDialog.getButton(DialogInterface.BUTTON_POSITIVE);
        //set the color to the buttton
        pbutton.setTextColor(buttonColor);
    }


}

package id.co.dunprek.errorhandling.ui;

import android.Manifest;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import id.co.dunprek.errorhandling.BaseActivity;
import id.co.dunprek.errorhandling.R;
import id.co.dunprek.errorhandling.model.CheckVersion;
import id.co.dunprek.errorhandling.services.ApiClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FirstActivity extends BaseActivity {

    ApiClient apiClient;

    TextView textView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);


        textView = (TextView) findViewById(R.id.tvVersion);


        checkVersion();

    }

    private void checkVersion() {
        apiClient = new ApiClient();
        Call<CheckVersion> call = apiClient.getApiInterface().getCheckVersion();
        call.enqueue(new Callback<CheckVersion>() {

            @Override
            public void onResponse(Call<CheckVersion> call, Response<CheckVersion> response) {
                CheckVersion cv = response.body();
                if (response.isSuccessful()) {
                    if (cv.getStatus().equals("1")) {
                        CheckVersion.Result result = cv.getResult();
                        textView.setText(result.getVerDisplay());
                    } else {
                        textView.setText("no version");
                    }
                }
            }

            @Override
            public void onFailure(Call<CheckVersion> call, Throwable t) {
                Log.d("TAG", t.getMessage());
                if (t instanceof IOException) {
                    showAlertNoInternet();
                }
            }
        });
    }

}

package id.co.dunprek.errorhandling.services;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import id.co.dunprek.errorhandling.common.Constants;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class ApiClient {

    private ApiInterface mApiInterface;

    private static OkHttpClient.Builder httpClient = new OkHttpClient.Builder();


    public ApiInterface getApiInterface() {
        if (mApiInterface == null) {

            HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
            loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

            OkHttpClient.Builder client = new OkHttpClient.Builder();

            client.addInterceptor(loggingInterceptor);

            Gson gson = new GsonBuilder()
                    .setLenient()
                    .create();

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(Constants.BASE_URL +Constants.BASE_VERSION)

                    .client(client.build())
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .build();

            mApiInterface = retrofit.create(ApiInterface.class);
            Log.d("VANYA", String.valueOf(retrofit));
            Log.d("VANYA", Constants.BASE_URL+Constants.BASE_VERSION);
        }
        return mApiInterface;
    }

}

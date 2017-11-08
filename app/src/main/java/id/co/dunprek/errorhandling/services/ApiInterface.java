package id.co.dunprek.errorhandling.services;

import id.co.dunprek.errorhandling.model.CheckVersion;
import retrofit2.Call;
import retrofit2.http.GET;


public interface ApiInterface {

    @GET("pub_data/apk_ver")
    Call<CheckVersion> getCheckVersion();

}

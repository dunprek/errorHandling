package id.co.dunprek.errorhandling.utils;

import android.content.Context;

import java.io.IOException;
import java.lang.annotation.Annotation;

import id.co.dunprek.errorhandling.model.APIError;
import id.co.dunprek.errorhandling.services.ApiClient;
import okhttp3.ResponseBody;
import retrofit2.Converter;
import retrofit2.Response;

/**
 * Created by gideon on 11/8/17.
 */

public class ErrorUtils {

    public static APIError parseError(Response<?> response) {
        APIError error;

        Converter<ResponseBody, APIError> converter = ApiClient.retrofit
                        .responseBodyConverter(APIError.class, new Annotation[0]);
        try {
            error = converter.convert(response.errorBody());
        } catch (IOException e) {
            return new APIError();
        }

        return error;
    }
}

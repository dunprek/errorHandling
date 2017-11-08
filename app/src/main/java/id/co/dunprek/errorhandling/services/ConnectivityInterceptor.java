package id.co.dunprek.errorhandling.services;


import android.content.Context;

import java.io.IOException;

import id.co.dunprek.errorhandling.BaseActivity;
import id.co.dunprek.errorhandling.utils.NetworkUtil;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class ConnectivityInterceptor extends BaseActivity implements Interceptor {

    private Context mContext;



    public ConnectivityInterceptor(Context context) {
        mContext = context;
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        if (!NetworkUtil.isOnline(mContext)) {
            throw new NoConnectivityException();
        }

        Request.Builder builder = chain.request().newBuilder();
        return chain.proceed(builder.build());
    }

    public class NoConnectivityException extends IOException {

        @Override
        public String getMessage() {
            return "No connectivity exception";
        }

    }

}

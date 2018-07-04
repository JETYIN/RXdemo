package work.dylan.com.rxdemo.dagger2.module;

import android.util.Log;

import java.util.concurrent.TimeUnit;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import work.dylan.com.rxdemo.dagger2.ApiCenter;

/**
 * Created by Administrator on 2018/6/26.
 */

@Module
public class ApiModule {

    @Provides
    public OkHttpClient provideOkHttpClient() {

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient.Builder builder = new OkHttpClient.Builder().connectTimeout(10, TimeUnit.SECONDS)
                .connectTimeout(20 * 1000, TimeUnit.MILLISECONDS)
                .readTimeout(20 * 1000, TimeUnit.MILLISECONDS)
                .retryOnConnectionFailure(true) // 失败重发
                .addInterceptor(interceptor);
        Log.e("dyalan", "****provideOkHttpClient");
        return builder.build();
    }

    @Provides
    protected ApiCenter provideApiService(OkHttpClient okHttpClient) {//FIXME provides用于注解可带输入参数
        Log.e("dyalan", "****provideApiService");
        return ApiCenter.getInstance(okHttpClient);
    }
}

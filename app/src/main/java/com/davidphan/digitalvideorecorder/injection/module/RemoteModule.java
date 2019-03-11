package com.davidphan.digitalvideorecorder.injection.module;

import com.davidphan.digitalvideorecorder.data.remote.AutoValueGsonFactory;
import com.davidphan.digitalvideorecorder.data.remote.ProgramService;
import com.google.gson.GsonBuilder;
import com.google.gson.TypeAdapterFactory;

import java.util.concurrent.TimeUnit;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class RemoteModule {

    @Provides
    ProgramService provideProgramService(Retrofit retrofit) {
        return retrofit.create(ProgramService.class);
    }

    @Provides
    Retrofit provideRetrofit(OkHttpClient client, GsonConverterFactory gsonConverterFactory) {
        return new Retrofit.Builder()
                .addConverterFactory(gsonConverterFactory)
                .client(client)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl("http://dvr.apiblueprint.org/")
                .build();
    }

    @Provides
    GsonConverterFactory provideGsonConverterFactory() {
        TypeAdapterFactory autoValueGsonFactory = AutoValueGsonFactory.create();
        GsonBuilder gsonBuilder = new GsonBuilder().registerTypeAdapterFactory(autoValueGsonFactory);
        return GsonConverterFactory.create(gsonBuilder.create());
    }

    @Provides
    OkHttpClient provideOkHttpClient(HttpLoggingInterceptor loggingInterceptor) {
        return new OkHttpClient.Builder()
                .addInterceptor(loggingInterceptor)
                .connectTimeout(60, TimeUnit.SECONDS)
                .readTimeout(60, TimeUnit.SECONDS)
                .build();
    }

    @Provides
    HttpLoggingInterceptor provideLoggingInterceptor() {
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        boolean isDebug = true;
        if (isDebug) {
            loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        } else {
            loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.NONE);
        }
        return loggingInterceptor;
    }

}

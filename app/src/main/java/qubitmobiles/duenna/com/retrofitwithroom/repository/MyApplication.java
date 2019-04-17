package qubitmobiles.duenna.com.retrofitwithroom.repository;

import android.app.Application;
import android.content.Context;

import dagger.Module;
import dagger.Provides;


/**
 * Created by Bala on 08-04-2019.
 */
@Module
public class MyApplication extends Application {
    AppComponent appComponent;
    static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = this;
        appComponent = DaggerAppComponent.builder().appModule(new AppModule(this)).utilsModule(new UtilsModule()).build();
    }

    @Provides
    public AppComponent getAppComponent() {
        return appComponent;
    }

    @Override
    protected void attachBaseContext(Context context) {
        super.attachBaseContext(context);
    }

    public static Context getContext() {
        return context;
    }
}

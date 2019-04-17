package qubitmobiles.duenna.com.retrofitwithroom.repository;

import android.content.Context;



import javax.inject.Singleton;

import dagger.Component;
import qubitmobiles.duenna.com.retrofitwithroom.activity.MainActivity;
import qubitmobiles.duenna.com.retrofitwithroom.fragment.TestFragment;

/**
 * Created by Bala on 08-04-2019.
 */

@Component(modules = {AppModule.class, UtilsModule.class})
@Singleton
public interface AppComponent {
    void doInjectionRecycler(MainActivity mainActivity);
    void doInjection(TestFragment fragment);

}


package qubitmobiles.duenna.com.retrofitwithroom.utility;

import android.annotation.SuppressLint;
import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

import androidx.annotation.Nullable;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import io.reactivex.Completable;
import io.reactivex.Single;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;
import qubitmobiles.duenna.com.retrofitwithroom.Model.PolicyResponseModel;
import qubitmobiles.duenna.com.retrofitwithroom.appDatabase.AppDatabase;

/**
 * Created by Bala on 16-04-2019.
 */
public class BackgroundServiceMethod extends IntentService {

    AppDatabase appDatabase;
    Context context;
    private final CompositeDisposable mDisposable = new CompositeDisposable();

    public BackgroundServiceMethod() {
        super("BackgroundServiceMethod");
    }

    private MutableLiveData<Completable> longMutableLiveData = new MutableLiveData<>();

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        context = this;
        appDatabase = AppDatabase.getInstance(context.getApplicationContext());
        Insert();

    }

    private void Insert() {
        ArrayList<PolicyResponseModel> policyResponseModel = MySingleton.getInstance().getPolicyResponseModels();
        mDisposable.add(updateUserName(policyResponseModel)
                .subscribeOn(Schedulers.io())
                // .observeOn(AndroidSchedulers.mainThread())
                .subscribe(() -> updateInsert(policyResponseModel),
                        throwable -> Log.e("Msg", "Unable to update username", throwable)));
    }

    private Completable updateUserName(final ArrayList<PolicyResponseModel> policyResponseModels) {
        return appDatabase.policyDao().insertToLocalDB(policyResponseModels);
    }

    private void updateInsert(List<PolicyResponseModel> policyResponseModels) {

        for (int i = 0; i < policyResponseModels.size(); i++) {
            Log.d("Msg", "InsertedId" + policyResponseModels.get(i).getIdCountry());
        }
    }
}

  /*  public Single<Completable> InsertData(ArrayList<PolicyResponseModel> policyResponseModel) {
        return Single.fromCallable(new Callable<Completable>() {
            @Override
            public Completable call() throws Exception {
                return appDatabase.policyDao().insert(policyResponseModel);
            }
        });
    }*/
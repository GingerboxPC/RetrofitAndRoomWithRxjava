package qubitmobiles.duenna.com.retrofitwithroom.activity;

import android.annotation.SuppressLint;
import android.app.Application;
import android.util.Log;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import io.reactivex.Completable;
import io.reactivex.Observer;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import qubitmobiles.duenna.com.retrofitwithroom.Model.PolicyResponseModel;
import qubitmobiles.duenna.com.retrofitwithroom.appDatabase.AppDatabase;
import qubitmobiles.duenna.com.retrofitwithroom.repository.AppModule;
import qubitmobiles.duenna.com.retrofitwithroom.repository.MyApplication;
import qubitmobiles.duenna.com.retrofitwithroom.repository.Repository;

/**
 * Created by Bala on 15-04-2019.
 */
public class MainActivityViewModel extends ViewModel {
    private Repository repository;
    private final CompositeDisposable disposables = new CompositeDisposable();
    private final MutableLiveData<ArrayList<PolicyResponseModel>> policyResponseModelMutableLiveData = new MutableLiveData<>();
    private final MutableLiveData<List<PolicyResponseModel>> getDBLiveData = new MutableLiveData<>();
    AppDatabase appDatabase;

    public MainActivityViewModel(Repository repository) {
        this.repository = repository;
        appDatabase = AppDatabase.getInstance(MyApplication.getContext());
    }

    public MutableLiveData<ArrayList<PolicyResponseModel>> ResponseDataFromApi() {
        return policyResponseModelMutableLiveData;
    }

    public MutableLiveData<List<PolicyResponseModel>> getDataFromDB() {
        return getDBLiveData;
    }

    public void getPolicyResponse() {
        repository.GetPolicyListData()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ArrayList<PolicyResponseModel>>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        Log.d("API=", "1");
                    }

                    @Override
                    public void onNext(ArrayList<PolicyResponseModel> registerResponseModel) {
                        try {
                            policyResponseModelMutableLiveData.setValue(registerResponseModel);
                            Log.d("ViewResponse", "Mess:::" + registerResponseModel.get(0).getName());
                            Log.d("API=", "2");
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void onError(Throwable e) {
                        policyResponseModelMutableLiveData.setValue(new ArrayList<PolicyResponseModel>());
                        Log.d("API=", "3");
                    }

                    @Override
                    public void onComplete() {
                        Log.d("API=", "4");

                    }
                });
    }

    public void insert(ArrayList<PolicyResponseModel> policyResponseModel) {
        disposables.add(updateUserName(policyResponseModel)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(() -> Log.d("Insert", "Response" + policyResponseModel.get(0)),
                        throwable -> Log.e("Msg", "Unable to Insert or Update data", throwable)));
    }

    private Completable updateUserName(final ArrayList<PolicyResponseModel> policyResponseModels) {
        return appDatabase.policyDao().insertToLocalDB(policyResponseModels);
    }

    @SuppressLint("CheckResult")
    public void DeleteData() {
        Single.fromCallable(() -> appDatabase.policyDao().deleteAllDatas()).
                subscribeOn(Schedulers.io()).
                observeOn(AndroidSchedulers.mainThread()).
                subscribe(integer -> Log.d("Message", "DeletedMsg:::" + integer),
                        throwable -> Log.e("Msg", "Unable to Insert or Update data", throwable));
    }

    public void CallMethod() {
        disposables.add(appDatabase.policyDao().getResponseFromDB().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::handleResponse, throwable -> Log.e("RoomActivity", "Exception Getting Data")));
    }

    private void handleResponse(List<PolicyResponseModel> policyResponseModels) {
        Log.d("Message", "GetFromDatabase:::" + policyResponseModels.size());
        getDBLiveData.postValue(policyResponseModels);
    }

}

package qubitmobiles.duenna.com.retrofitwithroom.fragment;

import android.util.Log;

import java.util.ArrayList;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import qubitmobiles.duenna.com.retrofitwithroom.Model.PolicyResponseModel;
import qubitmobiles.duenna.com.retrofitwithroom.repository.Repository;

/**
 * Created by Bala on 17-04-2019.
 */
public class TestFragmentViewModel extends ViewModel {

    private Repository repository;
    private final CompositeDisposable disposables = new CompositeDisposable();
    private final MutableLiveData<ArrayList<PolicyResponseModel>> policyResponseModelMutableLiveData = new MutableLiveData<>();

    public TestFragmentViewModel(Repository repository) {
        this.repository = repository;
    }

    public MutableLiveData<ArrayList<PolicyResponseModel>> ResponseDataFromApi() {
        return policyResponseModelMutableLiveData;
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

  /*  public void startMyService(Context context) {
        context.startService(new Intent(context, BackgroundServiceMethod.class));
    }*/
}

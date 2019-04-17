package qubitmobiles.duenna.com.retrofitwithroom.fragment;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.Completable;
import io.reactivex.Single;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;
import qubitmobiles.duenna.com.retrofitwithroom.Model.PolicyResponseModel;
import qubitmobiles.duenna.com.retrofitwithroom.R;
import qubitmobiles.duenna.com.retrofitwithroom.appDatabase.AppDatabase;
import qubitmobiles.duenna.com.retrofitwithroom.utility.BackgroundServiceMethod;
import qubitmobiles.duenna.com.retrofitwithroom.repository.MyApplication;
import qubitmobiles.duenna.com.retrofitwithroom.utility.GetDatasBackground;
import qubitmobiles.duenna.com.retrofitwithroom.utility.MySingleton;
import qubitmobiles.duenna.com.retrofitwithroom.utility.ViewModelFactory;

/**
 * Created by Bala on 17-04-2019.
 */
public class TestFragment extends Fragment {
    @BindView(R.id.get_name_tv)
    TextView get_name_tv;

    @BindView(R.id.get_age_tv)
    TextView get_age_tv;

    @BindView(R.id.get_gender_tv)
    TextView get_gender_tv;

    @BindView(R.id.getButtonDataFrag)
    Button getButtonDataFrag;

    @BindView(R.id.deleteDataButtonFrag)
    Button deleteDataButtonFrag;

    @Inject
    public ViewModelFactory viewModelFactory;
    public TestFragmentViewModel testFragmentViewModel;
    private final CompositeDisposable mDisposable = new CompositeDisposable();

    Context context;
    AppDatabase appDatabase;

    public TestFragment() {

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.test_layout, container, false);
        context = getContext();
        ButterKnife.bind(this, view);
        appDatabase = AppDatabase.getInstance(getContext());
        try {
            ((MyApplication) context.getApplicationContext()).getAppComponent().doInjection(this);   // For API Initialize
            testFragmentViewModel = ViewModelProviders.of(this, viewModelFactory).get(TestFragmentViewModel.class);   // For View Model Initialize
            testFragmentViewModel.getPolicyResponse();  // Request Api Data
            testFragmentViewModel.ResponseDataFromApi().observe(this, this::PolicyResponseUpdate);  // API Response Update
        } catch (Exception e) {
            e.printStackTrace();
        }

        getButtonDataFrag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CallMethod();
                context.startService(new Intent(getActivity(), GetDatasBackground.class));
            }
        });

        deleteDataButtonFrag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    DeleteData();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        return view;
    }

    @SuppressLint("CheckResult")
    private void DeleteData() {
        Single.fromCallable(() -> appDatabase.policyDao().deleteAllDatas()).
                subscribeOn(Schedulers.io()).
                observeOn(AndroidSchedulers.mainThread()).
                subscribe(integer -> Log.d("Message", "Msg::::" + integer));
    }

    private void PolicyResponseUpdate(ArrayList<PolicyResponseModel> policyResponseModel) {
        MySingleton.getInstance().setPolicyResponseModels(policyResponseModel);
        context.startService(new Intent(getActivity(), BackgroundServiceMethod.class));
       /* if (policyResponseModel != null) {
            Log.d("Message", "Response:::" + policyResponseModel.get(0).getName());
            mDisposable.add(updateUserName(policyResponseModel)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(() -> policyResponseModel.get(0).getName(),
                            throwable -> Log.e("Msg", "Unable to update username", throwable)));

        }*/
    }

    private Completable updateUserName(final ArrayList<PolicyResponseModel> userModelClass) {
        return appDatabase.policyDao().insertToLocalDB(userModelClass);
    }

    private void CallMethod() {
        mDisposable.add(appDatabase.policyDao().getResponseFromDB().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::handleResponse, throwable -> Log.e("RoomActivity", "Exception Getting Coupons")));

    }

    private void handleResponse(List<PolicyResponseModel> policyResponseModels) {
        get_name_tv.setText(String.valueOf(policyResponseModels.get(0).getName()));
        get_age_tv.setText(convertArrayToString(policyResponseModels.get(0).getAgeRange()));
        get_gender_tv.setText(convertArrayToString(policyResponseModels.get(0).getGender()));
    }

    public static String convertArrayToString(int[] strArray) {
        return Arrays.toString(strArray);
    }
}

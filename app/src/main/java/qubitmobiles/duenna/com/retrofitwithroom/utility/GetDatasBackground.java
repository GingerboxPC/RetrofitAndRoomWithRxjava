package qubitmobiles.duenna.com.retrofitwithroom.utility;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import androidx.annotation.Nullable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;
import qubitmobiles.duenna.com.retrofitwithroom.Model.PolicyResponseModel;
import qubitmobiles.duenna.com.retrofitwithroom.appDatabase.AppDatabase;

/**
 * Created by Bala on 16-04-2019.
 */
public class GetDatasBackground extends IntentService {
    private final CompositeDisposable mDisposable = new CompositeDisposable();
    AppDatabase appDatabase;
    Context context;

    public GetDatasBackground() {
        super("GetDatasBackground");
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        context = this;
        appDatabase = AppDatabase.getInstance(context.getApplicationContext());
        MethodToGetdata();
    }

    private void MethodToGetdata() {
        mDisposable.add(appDatabase.policyDao().getResponseFromDB().subscribeOn(Schedulers.io())
                .subscribe(this::handleResponse, throwable -> Log.e("Service", "Exception Getting Coupons")));
    }

    private void handleResponse(List<PolicyResponseModel> policyResponseModels) {
        Log.d("Service", "NameOne" + policyResponseModels.get(0).getName());
        Log.d("Service", "NameOne" + convertArrayToString(policyResponseModels.get(0).getAgeRange()));
        Log.d("Service", "NameOne" + convertArrayToString(policyResponseModels.get(0).getGender()));
        Log.d("Service", "Country" + policyResponseModels.get(0).getIdCountry());
    }

    public static String convertArrayToString(int[] strArray) {
        return Arrays.toString(strArray);
    }
}

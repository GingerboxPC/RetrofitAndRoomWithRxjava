package qubitmobiles.duenna.com.retrofitwithroom.activity;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;

import androidx.appcompat.app.AppCompatActivity;
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
import qubitmobiles.duenna.com.retrofitwithroom.appDatabase.UserDataSource;
import qubitmobiles.duenna.com.retrofitwithroom.repository.MyApplication;
import qubitmobiles.duenna.com.retrofitwithroom.utility.ViewModelFactory;


public class MainActivity extends AppCompatActivity {

    @Inject
    public ViewModelFactory viewModelFactory;

    public MainActivityViewModel mainActivityViewModel;
    Context context;
    private final CompositeDisposable mDisposable = new CompositeDisposable();

    UserDataSource userDataSource;
    AppDatabase appDatabase;

    @BindView(R.id.get_name_tv)
    TextView get_name_tv;

    @BindView(R.id.get_age_tv)
    TextView get_age_tv;

    @BindView(R.id.get_gender_tv)
    TextView get_gender_tv;

    @BindView(R.id.getButtonData)
    Button getButtonData;

   /* @BindView(R.id.deleteDataButtonAct)
    Button deleteDataButtonAct;*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = MainActivity.this;
        ButterKnife.bind(this);
        try {
            appDatabase = AppDatabase.getInstance(context.getApplicationContext());   // Initialize AppDatabase
            ((MyApplication) getApplication()).getAppComponent().doInjectionRecycler(this);     // Initialize API
            mainActivityViewModel = ViewModelProviders.of(this, viewModelFactory).get(MainActivityViewModel.class); // Initialize ViewModel
            mainActivityViewModel.getPolicyResponse();  // To Call API
            mainActivityViewModel.ResponseDataFromApi().observe(this, this::PolicyResponseUpdate);    // Response From API Call and  Insert Local database
            mainActivityViewModel.getDataFromDB().observe(this, this::DatabaseResponse);   //  After Insert Local DB, Get Data from Database show to UI
        } catch (Exception e) {
            e.printStackTrace();
        }

        getButtonData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    mainActivityViewModel.CallMethod();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

       /* deleteDataButtonAct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    mainActivityViewModel.DeleteData();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });*/
    }

    /*Response From API To Store Local Database*/
    private void PolicyResponseUpdate(ArrayList<PolicyResponseModel> policyResponseModels) {
        Log.d("ResponseSize", "::::::" + policyResponseModels.size());
        try {
            if (policyResponseModels.size() > 0) {
                mainActivityViewModel.insert(policyResponseModels);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void DatabaseResponse(List<PolicyResponseModel> policyResponseModels) {
        try {
            get_name_tv.setText(String.valueOf(policyResponseModels.get(0).getName()));
            get_age_tv.setText(convertArrayToString(policyResponseModels.get(0).getAgeRange()));
            get_gender_tv.setText(convertArrayToString(policyResponseModels.get(0).getGender()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String convertArrayToString(int[] strArray) {
        return Arrays.toString(strArray);
    }
}


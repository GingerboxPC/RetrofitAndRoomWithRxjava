package qubitmobiles.duenna.com.retrofitwithroom.utility;

import android.content.Context;

import java.util.ArrayList;

import qubitmobiles.duenna.com.retrofitwithroom.Model.PolicyResponseModel;

/**
 * Created by Bala on 16-04-2019.
 */
public class MySingleton {
    public ArrayList<PolicyResponseModel> policyResponseModels;
    private static MySingleton ourInstance;

    public static MySingleton getInstance() {
        if (ourInstance == null)
            ourInstance = new MySingleton();
        return ourInstance;
    }
    private MySingleton() {

    }

    public ArrayList<PolicyResponseModel> getPolicyResponseModels() {
        return policyResponseModels;
    }

    public void setPolicyResponseModels(ArrayList<PolicyResponseModel> policyResponseModels) {
        this.policyResponseModels = policyResponseModels;
    }


}

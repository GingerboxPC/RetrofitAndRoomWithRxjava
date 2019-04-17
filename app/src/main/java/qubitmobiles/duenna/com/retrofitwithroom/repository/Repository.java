package qubitmobiles.duenna.com.retrofitwithroom.repository;


import java.util.ArrayList;

import javax.inject.Singleton;

import io.reactivex.Observable;
import qubitmobiles.duenna.com.retrofitwithroom.Model.PolicyResponseModel;
import qubitmobiles.duenna.com.retrofitwithroom.Model.RegisterResponseModel;

/**
 * Created by Bala on 08-04-2019.
 */
@Singleton
public class Repository {
    private ApiCallInterface apiCallInterface;
  //  ApiCallInterface apiService = UtilsApi.getAPIService();

    public Repository() {

    }

    public Repository(ApiCallInterface apiCallInterface) {
        this.apiCallInterface = apiCallInterface;
    }

    public Observable<RegisterResponseModel> executeLogin(String mobileNumber, String password, String city, String state) {
        return apiCallInterface.login(mobileNumber, password, city, state);
    }

    public Observable<ArrayList<PolicyResponseModel>> GetPolicyListData() {
        return apiCallInterface.getPolicyList();
    }

    /*public Observable<VideoResponseStreamList> GetNewsValues() {
        return apiService.getStreamList();
    }
*/
}

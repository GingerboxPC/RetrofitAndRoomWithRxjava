package qubitmobiles.duenna.com.retrofitwithroom.repository;


import java.util.ArrayList;

import io.reactivex.Observable;
import qubitmobiles.duenna.com.retrofitwithroom.Model.PolicyResponseModel;
import qubitmobiles.duenna.com.retrofitwithroom.Model.RegisterResponseModel;
import qubitmobiles.duenna.com.retrofitwithroom.Model.VideoResponseStreamList;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by Bala on 08-04-2019.
 */
public interface ApiCallInterface {

    @FormUrlEncoded
    @POST(Urls.LOGIN)
    Observable<RegisterResponseModel> login(@Field("MobileNo") String mobileNumber, @Field("Name") String password, @Field("CityID") String city, @Field("StateID") String state);

    @GET(Urls.NEWS)
    Observable<VideoResponseStreamList> getStreamList();

    @GET(Urls.Policy)
    Observable<ArrayList<PolicyResponseModel>> getPolicyList();
}

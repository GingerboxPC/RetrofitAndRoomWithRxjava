package qubitmobiles.duenna.com.retrofitwithroom.appDatabase;


import java.util.ArrayList;
import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Flowable;
import io.reactivex.Maybe;
import io.reactivex.Single;
import qubitmobiles.duenna.com.retrofitwithroom.Model.PolicyResponseModel;

/**
 * Created by Bala on 12-04-2019.
 */
public interface InterfaceDatabaseHelper {
    public Flowable<List<PolicyResponseModel>> getCoupons();

    Completable insertOrUpdateUser(ArrayList<PolicyResponseModel> coupon);

    public Maybe<PolicyResponseModel> getCouponByStore(String storeIn);

    public Single<PolicyResponseModel> getOneCoupon();

    public void deleteAllCoupons();

    public Flowable<PolicyResponseModel> getUserModel();

    public void deleteByUserId(long userId);

    public Single<Integer> deleteByUser(long userId);
}



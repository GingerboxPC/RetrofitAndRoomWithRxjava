package qubitmobiles.duenna.com.retrofitwithroom.appDatabase;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;

import javax.inject.Singleton;

import io.reactivex.Completable;
import io.reactivex.Flowable;
import io.reactivex.Maybe;
import io.reactivex.Single;
import qubitmobiles.duenna.com.retrofitwithroom.Model.PolicyResponseModel;

/**
 * Created by Bala on 13-04-2019.
 */
@Singleton
public class UserDataSource implements InterfaceDatabaseHelper {

    private final PolicyDao mUserDao;

    public UserDataSource(PolicyDao mUserDao) {
        this.mUserDao = mUserDao;

    }

    @Override
    public Flowable<List<PolicyResponseModel>> getCoupons() {
        return null;
    }

    @Override
    public Completable insertOrUpdateUser(ArrayList<PolicyResponseModel> policyResponseModel) {
        return mUserDao.insertToLocalDB(policyResponseModel);
    }

    @Override
    public Maybe<PolicyResponseModel> getCouponByStore(String storeIn) {
        return null;
    }

    @Override
    public Single<PolicyResponseModel> getOneCoupon() {
        return null;
    }

    @Override
    public void deleteAllCoupons() {

    }

    @Override
    public Flowable<PolicyResponseModel> getUserModel() {
        return null;
    }

    @Override
    public void deleteByUserId(long userId) {

    }

    @Override
    public Single<Integer> deleteByUser(long userId) {
        return null;
    }

    /*@Override
    public Flowable<List<UserModelClass>> getCoupons() {
        return mUserDao.getCoupons();
    }

    @Override
    public Maybe<UserModelClass> getCouponByStore(String storeIn) {
        return null;
    }

    @Override
    public Single<UserModelClass> getOneCoupon() {
        return mUserDao.getOneCoupon();
    }

    public Completable insertOrUpdateUser(UserModelClass user) {
        return mUserDao.insertCoupon(user);
    }

    @Override
    public void deleteAllCoupons() {
        mUserDao.deleteAllCoupons();
    }

    @Override
    public Flowable<UserModelClass> getUserModel() {
        return mUserDao.getUser();
    }

    @Override
    public void deleteByUserId(long userId) {
        mUserDao.deleteByUserId(userId);
    }

    @Override
    public Single<Integer> deleteByUser(long userId) {
        return null;
    }*/


}





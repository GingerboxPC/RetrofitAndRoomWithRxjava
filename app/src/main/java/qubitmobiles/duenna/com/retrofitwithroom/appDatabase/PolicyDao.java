package qubitmobiles.duenna.com.retrofitwithroom.appDatabase;

import java.util.ArrayList;
import java.util.List;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import io.reactivex.Completable;
import io.reactivex.Flowable;
import io.reactivex.Single;
import io.reactivex.disposables.Disposable;
import qubitmobiles.duenna.com.retrofitwithroom.Model.PolicyResponseModel;

/**
 * Created by Bala on 12-04-2019.
 */

@Dao
public interface PolicyDao {

    @Query("SELECT * FROM policyresponsemodel")
    Flowable<List<PolicyResponseModel>> getResponseFromDB();

    @Query("SELECT * FROM policyresponsemodel LIMIT 1")
    Single<PolicyResponseModel> getOneResponseFromDB();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    Completable insertToLocalDB(ArrayList<PolicyResponseModel> coupon);

    @Query("DELETE FROM policyresponsemodel")
    int deleteAllDatas();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    Completable insert(ArrayList<PolicyResponseModel> coupon);

}

/*
// Single Call
    @Query("SELECT * FROM policyresponsemodel LIMIT 1")
    Flowable<PolicyResponseModel> getUserName();


    @Query("DELETE FROM policyresponsemodel WHERE name = :name")
    abstract void deleteByUserId(String name);

    @Query("DELETE FROM policyresponsemodel WHERE name  IN(:name)")
    Single<Integer> deleteByUser(final String... name);   */

package qubitmobiles.duenna.com.retrofitwithroom.appDatabase;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;


import androidx.room.TypeConverter;
import qubitmobiles.duenna.com.retrofitwithroom.Model.PolicyModel;
import qubitmobiles.duenna.com.retrofitwithroom.Model.PolicyResponseModel;

/**
 * Created by Bala on 15-04-2019.
 */

public class Converters {
    @TypeConverter
    public String fromOptionValuesList(ArrayList<PolicyModel> policyModelList) {
        if (policyModelList == null) {
            return (null);
        }
        Gson gson = new Gson();
        Type type = new TypeToken<List<PolicyModel>>() {
        }.getType();
        String json = gson.toJson(policyModelList, type);
        return json;
    }

    @TypeConverter // note this annotation
    public ArrayList<PolicyModel> toOptionValuesList(String optionValuesString) {
        if (optionValuesString == null) {
            return (null);
        }
        Gson gson = new Gson();
        Type type = new TypeToken<ArrayList<PolicyModel>>() {
        }.getType();
        ArrayList<PolicyModel> productCategoriesList = gson.fromJson(optionValuesString, type);
        return productCategoriesList;
    }



}

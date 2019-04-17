package qubitmobiles.duenna.com.retrofitwithroom.appDatabase;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

import androidx.room.TypeConverter;
import qubitmobiles.duenna.com.retrofitwithroom.Model.PolicyModel;

/**
 * Created by Bala on 15-04-2019.
 */

public class IntArrayConverters {
    @TypeConverter
    public String fromOptionValuesList(int[] policyModelList) {
        if (policyModelList == null) {
            return (null);
        }
        Gson gson = new Gson();
        Type type = new TypeToken<int[]>() {
        }.getType();
        String json = gson.toJson(policyModelList, type);
        return json;
    }

    @TypeConverter // note this annotation
    public int[] toOptionValuesList(String optionValuesString) {
        if (optionValuesString == null) {
            return (null);
        }
        Gson gson = new Gson();
        Type type = new TypeToken<int[]>() {
        }.getType();
        int[] productCategoriesList = gson.fromJson(optionValuesString, type);
        return productCategoriesList;
    }



}

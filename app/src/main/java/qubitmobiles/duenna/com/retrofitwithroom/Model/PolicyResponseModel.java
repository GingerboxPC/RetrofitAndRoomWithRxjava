package qubitmobiles.duenna.com.retrofitwithroom.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;
import qubitmobiles.duenna.com.retrofitwithroom.appDatabase.Converters;
import qubitmobiles.duenna.com.retrofitwithroom.appDatabase.IntArrayConverters;

/**
 * Created by SIVAMURUGU on 11-Apr-19.
 */

@Entity
public class PolicyResponseModel {

    @PrimaryKey(autoGenerate = true)
    private int idCountry;

    @SerializedName("name")
    @ColumnInfo(name = "name")
    private String name;

    @TypeConverters(IntArrayConverters.class)
    @SerializedName("ageRange")
    @ColumnInfo(name = "ageRange")
    private int[] ageRange;

    @TypeConverters(IntArrayConverters.class)
    @SerializedName("gender")
    @ColumnInfo(name = "gender")
    private int[] gender;

    @TypeConverters(IntArrayConverters.class)
    @SerializedName("strictnessLevel")
    @ColumnInfo(name = "strictnessLevel")
    private int[] strictnessLevel;


    @SerializedName("isDefault")
    @ColumnInfo(name = "isDefault")
    private boolean isDefault;

    @TypeConverters(Converters.class)
    @ColumnInfo(name = "policyRules")
    @SerializedName("policyRules")
    private ArrayList<PolicyModel> policyRules = new ArrayList<>();

    public int getIdCountry() {
        return idCountry;
    }

    public void setIdCountry(int idCountry) {
        this.idCountry = idCountry;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int[] getAgeRange() {
        return ageRange;
    }

    public void setAgeRange(int[] ageRange) {
        this.ageRange = ageRange;
    }

    public int[] getGender() {
        return gender;
    }

    public void setGender(int[] gender) {
        this.gender = gender;
    }

    public int[] getStrictnessLevel() {
        return strictnessLevel;
    }

    public void setStrictnessLevel(int[] strictnessLevel) {
        this.strictnessLevel = strictnessLevel;
    }

    public boolean isDefault() {
        return isDefault;
    }

    public void setDefault(boolean aDefault) {
        isDefault = aDefault;
    }

    public ArrayList<PolicyModel> getPolicyRules() {
        return policyRules;
    }

    public void setPolicyRules(ArrayList<PolicyModel> policyRules) {
        this.policyRules = policyRules;
    }
}

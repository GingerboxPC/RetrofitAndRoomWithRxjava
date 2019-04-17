package qubitmobiles.duenna.com.retrofitwithroom.Model;

import com.google.gson.annotations.SerializedName;

import androidx.room.ColumnInfo;
import androidx.room.Entity;

/**
 * Created by SIVAMURUGU on 11-Apr-19.
 */

@Entity
public class PolicyModel {


    @SerializedName("policyID")
    @ColumnInfo
    private String policyID;

    @SerializedName("featureID")
    @ColumnInfo
    private String featureID;

    @SerializedName("day")
    @ColumnInfo
    private int day;

    @SerializedName("fromTime")
    @ColumnInfo
    private String fromTime;

    @SerializedName("toTime")
    @ColumnInfo
    private String toTime;

    @SerializedName("duration")
    @ColumnInfo
    private int duration;

    @SerializedName("additionalValue")
    @ColumnInfo
    private int[] additionalValue;

    public String getPolicyID() {
        return policyID;
    }

    public void setPolicyID(String policyID) {
        this.policyID = policyID;
    }

    public String getFeatureID() {
        return featureID;
    }

    public void setFeatureID(String featureID) {
        this.featureID = featureID;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public String getFromTime() {
        return fromTime;
    }

    public void setFromTime(String fromTime) {
        this.fromTime = fromTime;
    }

    public String getToTime() {
        return toTime;
    }

    public void setToTime(String toTime) {
        this.toTime = toTime;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int[] getAdditionalValue() {
        return additionalValue;
    }

    public void setAdditionalValue(int[] additionalValue) {
        this.additionalValue = additionalValue;
    }
}

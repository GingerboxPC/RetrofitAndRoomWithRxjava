package qubitmobiles.duenna.com.retrofitwithroom.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class RegisterResponseModel {

    @SerializedName("ResponseCode")
    private int responseCode;
    @Expose

    @SerializedName("ResponseMessage")
    private String responseMessage;
    @Expose


    @SerializedName("Data")
    private RegisterData data;


    public void setResponseCode(int responseCode) {
        this.responseCode = responseCode;
    }

    public int getResponseCode() {
        return responseCode;
    }

    public void setData(RegisterData data) {
        this.data = data;
    }

    public RegisterData getData() {
        return data;
    }

    public void setResponseMessage(String responseMessage) {
        this.responseMessage = responseMessage;
    }

    public String getResponseMessage() {
        return responseMessage;
    }

    @Override
    public String toString() {
        return
                "RegisterResponseModel{" +
                        "responseCode = '" + responseCode + '\'' +
                        ",data = '" + data + '\'' +
                        ",responseMessage = '" + responseMessage + '\'' +
                        "}";
    }

    public class RegisterData {

        @SerializedName("MobileNo")
        private String mobileNo;

        @SerializedName("EmailID")
        private String emailID;

        @SerializedName("CityID")
        private int cityID;

        @SerializedName("ProfileImage")
        private Object profileImage;

        @SerializedName("StateID")
        private int stateID;

        @SerializedName("ID")
        private int iD;

        @SerializedName("Pwd")
        private Object pwd;

        @SerializedName("RoleID")
        private Object roleID;

        @SerializedName("Name")
        private String name;

        public void setMobileNo(String mobileNo) {
            this.mobileNo = mobileNo;
        }

        public String getMobileNo() {
            return mobileNo;
        }

        public void setEmailID(String emailID) {
            this.emailID = emailID;
        }

        public String getEmailID() {
            return emailID;
        }

        public void setCityID(int cityID) {
            this.cityID = cityID;
        }

        public int getCityID() {
            return cityID;
        }

        public void setProfileImage(Object profileImage) {
            this.profileImage = profileImage;
        }

        public Object getProfileImage() {
            return profileImage;
        }

        public void setStateID(int stateID) {
            this.stateID = stateID;
        }

        public int getStateID() {
            return stateID;
        }

        public void setID(int iD) {
            this.iD = iD;
        }

        public int getID() {
            return iD;
        }

        public void setPwd(Object pwd) {
            this.pwd = pwd;
        }

        public Object getPwd() {
            return pwd;
        }

        public void setRoleID(Object roleID) {
            this.roleID = roleID;
        }

        public Object getRoleID() {
            return roleID;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        @Override
        public String toString() {
            return
                    "Data{" +
                            "mobileNo = '" + mobileNo + '\'' +
                            ",emailID = '" + emailID + '\'' +
                            ",cityID = '" + cityID + '\'' +
                            ",profileImage = '" + profileImage + '\'' +
                            ",stateID = '" + stateID + '\'' +
                            ",iD = '" + iD + '\'' +
                            ",pwd = '" + pwd + '\'' +
                            ",roleID = '" + roleID + '\'' +
                            ",name = '" + name + '\'' +
                            "}";
        }
    }

}

    /*public RegisterResponseModel(int ResponseCode, String ResponseMessage, RegisterData registerData) {
        this.responseCode = ResponseCode;
        this.data = registerData;
        this.responseMessage = ResponseMessage;
    }

    public static RegisterResponseModel getDatas(RegisterData registerData) {
        return new RegisterResponseModel(1, null, registerData);
    }*/
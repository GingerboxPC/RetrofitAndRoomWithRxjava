package qubitmobiles.duenna.com.retrofitwithroom.Model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class VideoResponseStreamList {

		@SerializedName("ResponseCode")
		private int responseCode;

		@SerializedName("Data")
		private List<VideosDataItemsList> data;

		@SerializedName("ResponseMessage")
		private String responseMessage;

		public void setResponseCode(int responseCode){
			this.responseCode = responseCode;
		}

		public int getResponseCode(){
			return responseCode;
		}

		public void setData(List<VideosDataItemsList> data){
			this.data = data;
		}

		public List<VideosDataItemsList> getData(){
			return data;
		}

		public void setResponseMessage(String responseMessage){
			this.responseMessage = responseMessage;
		}

		public String getResponseMessage(){
			return responseMessage;
		}

		@Override
		public String toString(){
			return
					"LatestDataStreamList{" +
							"responseCode = '" + responseCode + '\'' +
							",data = '" + data + '\'' +
							",responseMessage = '" + responseMessage + '\'' +
							"}";
		}
		public class VideosDataItemsList {

			@SerializedName("ChangedDateTime")
			private String changedDateTime;

			@SerializedName("Heading")
			private String heading;

			@SerializedName("NewsDetail")
			private String newsDetail;

			@SerializedName("UserName")
			private String userName;

			@SerializedName("FilePath")
			private String FilePath;

			@SerializedName("ChangedBy")
			private int changedBy;

			@SerializedName("NewsTypeID")
			private int newsTypeID;

			@SerializedName("StateID")
			private int stateID;

			@SerializedName("language")
			private String language;

			@SerializedName("City")
			private String city;

			@SerializedName("NewsStatus")
			private int newsStatus;

			@SerializedName("EditorName")
			private String editorName;

			@SerializedName("CityID")
			private int cityID;

			@SerializedName("UserID")
			private int userID;

			@SerializedName("State")
			private String state;

			@SerializedName("ID")
			private int iD;

			@SerializedName("NewsTypeName")
			private Object newsTypeName;

			@SerializedName("NewsStatusName")
			private String newsStatusName;

			@SerializedName("LanguageID")
			private int languageID;

			public void setChangedDateTime(String changedDateTime){
				this.changedDateTime = changedDateTime;
			}

			public String getChangedDateTime(){
				return changedDateTime;
			}

			public void setHeading(String heading){
				this.heading = heading;
			}

			public String getHeading(){
				return heading;
			}

			public void setNewsDetail(String newsDetail){
				this.newsDetail = newsDetail;
			}

			public String getNewsDetail(){
				return newsDetail;
			}

			public void setUserName(String userName){
				this.userName = userName;
			}

			public String getUserName(){
				return userName;
			}

			public void setEditedFilePath(String editedFilePath){
				this.FilePath = editedFilePath;
			}

			public String getEditedFilePath(){
				return FilePath;
			}

			public void setChangedBy(int changedBy){
				this.changedBy = changedBy;
			}

			public int getChangedBy(){
				return changedBy;
			}

			public void setNewsTypeID(int newsTypeID){
				this.newsTypeID = newsTypeID;
			}

			public int getNewsTypeID(){
				return newsTypeID;
			}

			public void setStateID(int stateID){
				this.stateID = stateID;
			}

			public int getStateID(){
				return stateID;
			}

			public void setLanguage(String language){
				this.language = language;
			}

			public String getLanguage(){
				return language;
			}

			public void setCity(String city){
				this.city = city;
			}

			public String getCity(){
				return city;
			}

			public void setNewsStatus(int newsStatus){
				this.newsStatus = newsStatus;
			}

			public int getNewsStatus(){
				return newsStatus;
			}

			public void setEditorName(String editorName){
				this.editorName = editorName;
			}

			public String getEditorName(){
				return editorName;
			}

			public void setCityID(int cityID){
				this.cityID = cityID;
			}

			public int getCityID(){
				return cityID;
			}

			public void setUserID(int userID){
				this.userID = userID;
			}

			public int getUserID(){
				return userID;
			}

			public void setState(String state){
				this.state = state;
			}

			public String getState(){
				return state;
			}

			public void setID(int iD){
				this.iD = iD;
			}

			public int getID(){
				return iD;
			}

			public void setNewsTypeName(Object newsTypeName){
				this.newsTypeName = newsTypeName;
			}

			public Object getNewsTypeName(){
				return newsTypeName;
			}

			public void setNewsStatusName(String newsStatusName){
				this.newsStatusName = newsStatusName;
			}

			public String getNewsStatusName(){
				return newsStatusName;
			}

			public void setLanguageID(int languageID){
				this.languageID = languageID;
			}

			public int getLanguageID(){
				return languageID;
			}

			@Override
			public String toString(){
				return
						"DataItem{" +
								"changedDateTime = '" + changedDateTime + '\'' +
								",heading = '" + heading + '\'' +
								",newsDetail = '" + newsDetail + '\'' +
								",userName = '" + userName + '\'' +
								",FilePath = '" + FilePath + '\'' +
								",changedBy = '" + changedBy + '\'' +
								",newsTypeID = '" + newsTypeID + '\'' +
								",stateID = '" + stateID + '\'' +
								",language = '" + language + '\'' +
								",city = '" + city + '\'' +
								",newsStatus = '" + newsStatus + '\'' +
								",editorName = '" + editorName + '\'' +
								",cityID = '" + cityID + '\'' +
								",userID = '" + userID + '\'' +
								",state = '" + state + '\'' +
								",iD = '" + iD + '\'' +
								",newsTypeName = '" + newsTypeName + '\'' +
								",newsStatusName = '" + newsStatusName + '\'' +
								",languageID = '" + languageID + '\'' +
								"}";
			}
		}
}



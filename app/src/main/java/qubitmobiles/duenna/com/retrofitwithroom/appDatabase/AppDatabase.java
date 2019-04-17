package qubitmobiles.duenna.com.retrofitwithroom.appDatabase;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Embedded;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;
import qubitmobiles.duenna.com.retrofitwithroom.Model.PolicyResponseModel;

/**
 * Created by Bala on 12-04-2019.
 */

@Database(entities = {PolicyResponseModel.class}, version = 1, exportSchema = false)
@TypeConverters({Converters.class})
public abstract class AppDatabase extends RoomDatabase {
    private static AppDatabase appDatabase = null;
    public static AppDatabase getInstance(Context context) {
        if (appDatabase == null) {
            appDatabase = Room.databaseBuilder(context.getApplicationContext(),
                    AppDatabase.class, "MainDatabase.db").build();
        }
        return appDatabase;
    }

    public abstract PolicyDao policyDao();

}

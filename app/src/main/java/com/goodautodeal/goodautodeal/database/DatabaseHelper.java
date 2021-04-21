package com.goodautodeal.goodautodeal.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.goodautodeal.goodautodeal.database.table.FavouriteModel;

@Database(entities = {FavouriteModel.class}, version = 1, exportSchema = false)
public abstract class DatabaseHelper extends RoomDatabase {
    public static DatabaseHelper databaseHelper;

    public static DatabaseHelper getInstance(Context context) {
        if (databaseHelper == null) {
            databaseHelper = Room.databaseBuilder(context, DatabaseHelper.class, "gad_eDB")
                    .allowMainThreadQueries().build();
        }
        return databaseHelper;
    }

    public abstract GADDao gadDao();

}

package com.goodautodeal.goodautodeal.database;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.goodautodeal.goodautodeal.database.table.FavouriteModel;

import java.util.List;

@Dao
public interface GADDao {

    @Insert
    void insertFavouriteAd(FavouriteModel favouriteModel);


    @Query("SELECT * from favourite_table")
    List<FavouriteModel> getFavouriteModel();
}


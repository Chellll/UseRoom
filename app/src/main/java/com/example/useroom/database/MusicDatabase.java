package com.example.useroom.database;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;

@Database(entities = {Album.class, Song.class}, version = 1)
public abstract class MusicDatabase extends RoomDatabase {

    abstract MusicDao getMusicDao();

}

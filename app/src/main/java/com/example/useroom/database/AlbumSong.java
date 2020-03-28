package com.example.useroom.database;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "albumsong",
        foreignKeys = {
        @ForeignKey(entity = Album.class, parentColumns = "id", childColumns = "album_id"),
        @ForeignKey(entity = Song.class, parentColumns = "id", childColumns = "song_id")
})
public class AlbumSong {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    private int mId;

    @ColumnInfo(name = "album_id")
    private int mAlbomId;

    @ColumnInfo(name = "song_id")
    private int mSongId;

    public AlbumSong(int id, int albomId, int songId) {
        mId = id;
        mAlbomId = albomId;
        mSongId = songId;
    }

    public AlbumSong() {

    }

    public int getId() {
        return mId;
    }

    public void setId(int id) {
        mId = id;
    }

    public int getAlbomId() {
        return mAlbomId;
    }

    public void setAlbomId(int albomId) {
        mAlbomId = albomId;
    }

    public int getSongId() {
        return mSongId;
    }

    public void setSongId(int songId) {
        mSongId = songId;
    }
}

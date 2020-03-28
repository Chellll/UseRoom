package com.example.useroom;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.useroom.database.Album;
import com.example.useroom.database.MusicDao;
import com.example.useroom.database.MusicDatabase;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    Button mAddBtn;
    Button mGetBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final MusicDao musicDao = ((AppDelegate)getApplicationContext()).getMusicDatabase().getMusicDao();

        mAddBtn = findViewById(R.id.add);
        mGetBtn = findViewById(R.id.get);

        mAddBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                musicDao.insertAlbums(createAlbums());
            }
        });
        
        mGetBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showToast(musicDao.getAlbums());
            }

        });

    }

    private void showToast(List<Album> albums) {
        StringBuilder builder = new StringBuilder();
        for(int i = 0, size = albums.size(); i < size; i++){
            builder.append(albums.get(i).toString()).append('\n');
        }
        Toast.makeText(this, builder.toString(), Toast.LENGTH_SHORT).show();
    }

    private List<Album> createAlbums() {

        List<Album> albums = new ArrayList<>();
        for(int i = 0; i < 10; i++ ){
            albums.add(new Album(i,"album " + 1, "release " + System.currentTimeMillis()));
        }

        return albums;

    }
}

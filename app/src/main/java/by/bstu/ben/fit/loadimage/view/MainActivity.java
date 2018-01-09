package by.bstu.ben.fit.loadimage.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;

import by.bstu.ben.fit.loadimage.R;
import by.bstu.ben.fit.loadimage.adapter.RVAdapter;
import by.bstu.ben.fit.loadimage.adapter.RecyclerItemClickListener;
import by.bstu.ben.fit.loadimage.model.Image;
import by.bstu.ben.fit.loadimage.network.ImageService;
import by.bstu.ben.fit.loadimage.presenters.MainPresenter;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    RVAdapter adapter;

    RecyclerView rv;
    LinearLayoutManager llm;

    MainPresenter mainPresenter;
    ImageService imageService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rv = (RecyclerView) findViewById(R.id.rvImages);
        llm = new LinearLayoutManager(MainActivity.this);
        rv.setLayoutManager(llm);

        imageService = new ImageService();
        mainPresenter = new MainPresenter(this, imageService);
        mainPresenter.loadPosts();

        rv.addOnItemTouchListener(new RecyclerItemClickListener(this, new RecyclerItemClickListener.OnItemClickListener() {
            @Override public void onItemClick(View view, int position) {
                Object obj = adapter.getItem(position);
                Image img = (Image)obj;
                Intent intent = new Intent(MainActivity.this,InfoActivity.class);
                intent.putExtra("image",img);
                startActivity(intent);
            }
        }));
    }

    public void displayPosts(List<Image> posts) {

        adapter = new RVAdapter(posts,MainActivity.this);
        rv.setAdapter(adapter);
    }
}

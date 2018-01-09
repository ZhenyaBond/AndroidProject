package by.bstu.ben.fit.loadimage.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import by.bstu.ben.fit.loadimage.R;
import by.bstu.ben.fit.loadimage.model.Image;
import by.bstu.ben.fit.loadimage.network.ImageService;
import by.bstu.ben.fit.loadimage.presenters.InfoPresenter;


public class InfoActivity extends AppCompatActivity {

    TextView title;
    TextView id;
    TextView albumID;
    TextView url;
    TextView thumbnailUrl;

    InfoPresenter infoPresenter;
    ImageService imageService;

    Image img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        title = (TextView)findViewById(R.id.textViewTitle);
        id = (TextView)findViewById(R.id.textViewID);
        albumID = (TextView)findViewById(R.id.textViewAlbumID);
        url = (TextView)findViewById(R.id.textViewURL);

        img = getIntent().getParcelableExtra("image");

        imageService = new ImageService();
        infoPresenter = new InfoPresenter(this, imageService);
        infoPresenter.loadPost();
    }

    public int getPostId() {
        return Integer.parseInt(img.id);
    }

    public void displayPost(Image image) {
        id.setText(image.id);
        albumID.setText(image.albumId);
        title.setText(image.title);
        url.setText(image.url);
    }


}

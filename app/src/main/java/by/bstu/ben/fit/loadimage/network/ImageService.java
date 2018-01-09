package by.bstu.ben.fit.loadimage.network;

import by.bstu.ben.fit.loadimage.model.Image;

import java.util.List;

import retrofit.RestAdapter;
import retrofit.http.GET;
import retrofit.http.Path;
import rx.Observable;


public class ImageService {
    private static final String BASE_STRING = "http://jsonplaceholder.typicode.com";
    private ImageApi imgAPI;

    public ImageService() {
        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint(BASE_STRING)
                .build();

        imgAPI = restAdapter.create(ImageApi.class);
    }

    public ImageApi getApi() {
        return imgAPI;
    }

    public interface ImageApi {

        @GET("/photos")
        Observable<List<Image>>
        getPhotos();

        @GET("/photos/{id}")
        Observable<Image>
        getPhotoID(@Path("id") int postId);
    }
}
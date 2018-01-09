package by.bstu.ben.fit.loadimage.presenters;

import by.bstu.ben.fit.loadimage.model.Image;
import by.bstu.ben.fit.loadimage.network.ImageService;
import by.bstu.ben.fit.loadimage.view.MainActivity;

import java.util.List;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class MainPresenter {
    MainActivity mainActivity;
    ImageService imageService;

    public MainPresenter(MainActivity view, ImageService service) {

        mainActivity = view;
        imageService = service;
    }

    public void loadPosts() {

        imageService.getApi()
                .getPhotos()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List<Image>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(List<Image> images) {

                        mainActivity.displayPosts(images);
                    }
                });
    }
}
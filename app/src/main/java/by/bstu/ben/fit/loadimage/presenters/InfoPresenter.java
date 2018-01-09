package by.bstu.ben.fit.loadimage.presenters;

import by.bstu.ben.fit.loadimage.model.Image;
import by.bstu.ben.fit.loadimage.network.ImageService;
import by.bstu.ben.fit.loadimage.view.InfoActivity;

import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class InfoPresenter {

    InfoActivity infoActivity;
    ImageService imageService;

    public InfoPresenter(InfoActivity view, ImageService service) {

        infoActivity = view;
        imageService = service;
    }

    public void loadPost() {

        imageService.getApi()
                .getPhotoID(infoActivity.getPostId())
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Image>() {
                    @Override
                    public void onCompleted() {}

                    @Override
                    public void onError(Throwable e) {}

                    @Override
                    public void onNext(Image image) {
                        infoActivity.displayPost(image);
                    }
                });
    }
}
package by.bstu.ben.fit.loadimage.model;


import android.os.Parcel;
import android.os.Parcelable;


public class Image implements Parcelable {
    public String albumId;
    public String id;
    public String title;
    public String url;

    protected Image(Parcel in) {
        String[] data = new String[4];
        in.readStringArray(data);
        albumId = data[0];
        id = data[1];
        title = data[2];
        url = data[3];
    }

    public static final Parcelable.Creator<Image> CREATOR = new Parcelable.Creator<Image>() {
        @Override
        public Image createFromParcel(Parcel in) {
            return new Image(in);
        }

        @Override
        public Image[] newArray(int size) {
            return new Image[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeStringArray(new String[] {albumId, id, title, url});
    }
}

package http.retrofit.progress;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by liht on 2018/1/23 0023.
 */

public class Download implements Parcelable {

    private int progress;
    private long currentFileSize;
    private long totalFileSize;

    private int currentFileSize_KB;
    private int totalFileSize_KB;

    private static final int KB = 1024;

    public int getCurrentFileSize_KB() {
        long r = currentFileSize/KB;
        if(r > Integer.MAX_VALUE){
            return -1;
        }
        return (int)r;
    }

    public int getTotalFileSize_KB() {
        long r = totalFileSize/KB;
        if(r > Integer.MAX_VALUE){
            return -1;
        }
        return (int)r;
    }

    public int getProgress() {
        return progress;
    }

    public void setProgress(int progress) {
        this.progress = progress;
    }

    public long getCurrentFileSize() {
        return currentFileSize;
    }

    public void setCurrentFileSize(long currentFileSize) {
        this.currentFileSize = currentFileSize;
    }

    public long getTotalFileSize() {
        return totalFileSize;
    }

    public void setTotalFileSize(long totalFileSize) {
        this.totalFileSize = totalFileSize;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.progress);
        dest.writeLong(this.currentFileSize);
        dest.writeLong(this.totalFileSize);
    }

    public Download() {
    }

    protected Download(Parcel in) {
        this.progress = in.readInt();
        this.currentFileSize = in.readLong();
        this.totalFileSize = in.readLong();
    }

    public static final Creator<Download> CREATOR = new Creator<Download>() {
        @Override
        public Download createFromParcel(Parcel source) {
            return new Download(source);
        }

        @Override
        public Download[] newArray(int size) {
            return new Download[size];
        }
    };
}

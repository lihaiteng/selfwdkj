package http.retrofit.progress;

/**
 * Created by liht on 2018/1/23 0023.
 */

public interface DownloadProgressListener {
    void update(long bytesRead, long contentLength, boolean done);
}

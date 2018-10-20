package http.retrofit.error;

import http.retrofit.HttpStatus;

/**
 * Created by LiHT on 2017/5/26.
 */

public class RequestException extends RuntimeException{
    private String mErrorCode;

    private HttpStatus httpStatus;

    public RequestException(String errorCode, String errorMessage) {
        super(errorMessage);
        mErrorCode = errorCode;
    }

    public RequestException(int errorCode, String errorMessage) {
        super(errorMessage);
        mErrorCode = String.valueOf(errorCode);
    }

    public RequestException(HttpStatus httpStatus){
        super(httpStatus.getShowMsg());
        this.httpStatus = httpStatus;
    }

    //根据错误code判断错误类型
//    public boolean isTokenExpried() {
//        return mErrorCode ==
//    }

    public HttpStatus getHttpStatus(){
        return httpStatus;
    }
}

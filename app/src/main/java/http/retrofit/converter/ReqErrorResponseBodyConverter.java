package http.retrofit.converter;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.Charset;

import http.retrofit.HttpStatus;
import http.retrofit.error.RequestException;
import okhttp3.MediaType;
import okhttp3.ResponseBody;
import retrofit2.Converter;
import utils.log.LogUtil;

import static okhttp3.internal.Util.UTF_8;

/**
 * Created by LiHT on 2017/5/26.
 */

public class ReqErrorResponseBodyConverter<T> implements Converter<ResponseBody, T> {
    private final Gson gson;
    private final TypeAdapter<T> adapter;

    ReqErrorResponseBodyConverter(Gson gson, TypeAdapter<T> adapter) {
        this.gson = gson;
        this.adapter = adapter;
    }

    @Override public T convert(ResponseBody value) throws IOException,RequestException{
        String response = value.string();
        HttpStatus httpStatus;
        try {
            httpStatus = gson.fromJson(response, HttpStatus.class);//只对外围的请求相应状态字段解析
        }catch (Exception e){
            LogUtil.d("外围字段转HttpStatus异常");
            return null;
        }
        if (!httpStatus.requestIfSuccess()) {//判断是否请求成功
            value.close();
//            throw new RequestException(httpStatus.getResult(), httpStatus.getShowMsg());
            throw new RequestException(httpStatus);
        }
        MediaType contentType = value.contentType();
        Charset charset = contentType != null ? contentType.charset(UTF_8) : UTF_8;
        InputStream inputStream = new ByteArrayInputStream(response.getBytes());
        Reader reader = new InputStreamReader(inputStream, charset);
        JsonReader jsonReader = gson.newJsonReader(reader);
        try {
            return adapter.read(jsonReader);
        } catch (Exception e){
            LogUtil.d("Gson转实体异常");
            return null;
        } finally {
            value.close();
        }
    }
}

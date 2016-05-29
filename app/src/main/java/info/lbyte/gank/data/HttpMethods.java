package info.lbyte.gank.data;

import java.util.concurrent.TimeUnit;

import info.lbyte.gank.service.TypeService;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by zhangbinbin on 16/5/29.
 */
public class HttpMethods {
    public static final String BASE_URL = "http://gank.io/api/";

    private static final int DEFAULT_TIMEOUT = 5;

    private Retrofit mRetrofit;
    private TypeService mTypeService;

    //私有构造方法
    private HttpMethods() {
        OkHttpClient.Builder httpClientBuilder = new OkHttpClient.Builder();
        httpClientBuilder.connectTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS);

        mRetrofit = new Retrofit.Builder()
                .client(httpClientBuilder.build())
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .baseUrl(BASE_URL)
                .build();

        mTypeService = mRetrofit.create(TypeService.class);
    }

    //在访问HttpMethods创建单例
    private static class SingletonHolder {
        private static final HttpMethods INSTANCE = new HttpMethods();
    }

    //获取单例
    public static HttpMethods getInstance() {
        return SingletonHolder.INSTANCE;
    }

    /**
     * 用于获取某种类型的干货数据
     *
     * @param subscriber 观察者对象
     * @param type       数据类型 可选[data,福利,Android,iOS]
     * @param count      请求个数
     * @param page       页码
     */
    public void getTypeData(Subscriber<TypeData> subscriber, String type, int count, int page) {
        mTypeService.getTypeData(type,count,page)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }


}

package info.lbyte.gank.service;

import info.lbyte.gank.data.TypeData;
import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

/**
 * Created by zhangbinbin on 16/5/29.
 */
public interface TypeService {
    @GET("data/{type}/{count}/{page}")
    Observable<TypeData> getTypeData(@Path("type") String type,
                                     @Path("count") int count, @Path("page") int page);
}

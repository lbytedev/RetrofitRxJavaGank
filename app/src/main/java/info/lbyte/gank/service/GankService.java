package info.lbyte.gank.service;

import info.lbyte.gank.data.GankDayData;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by zhangbinbin on 16/5/28.
 */
public interface GankService {
    @GET("day/{day}")
    Call<GankDayData> getTodayGank(@Path("day")String day);
}

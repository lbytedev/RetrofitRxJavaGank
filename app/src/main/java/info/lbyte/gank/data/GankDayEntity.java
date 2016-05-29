package info.lbyte.gank.data;

import java.util.List;

/**
 * Created by zhangbinbin on 16/5/28.
 */
public class GankDayEntity {
    private List<DataEntity> Android;
    private List<DataEntity> App;
    private List<DataEntity> iOS;
    private List<DataEntity> 休息视频;
    private List<DataEntity> 前端;
    private List<DataEntity> 拓展资源;
    private List<DataEntity> 福利;

    public List<DataEntity> getAndroid() {
        return Android;
    }

    public void setAndroid(List<DataEntity> android) {
        Android = android;
    }

    public List<DataEntity> getApp() {
        return App;
    }

    public void setApp(List<DataEntity> app) {
        App = app;
    }

    public List<DataEntity> getiOS() {
        return iOS;
    }

    public void setiOS(List<DataEntity> iOS) {
        this.iOS = iOS;
    }

    public List<DataEntity> get休息视频() {
        return 休息视频;
    }

    public void set休息视频(List<DataEntity> 休息视频) {
        this.休息视频 = 休息视频;
    }

    public List<DataEntity> get前端() {
        return 前端;
    }

    public void set前端(List<DataEntity> 前端) {
        this.前端 = 前端;
    }

    public List<DataEntity> get拓展资源() {
        return 拓展资源;
    }

    public void set拓展资源(List<DataEntity> 拓展资源) {
        this.拓展资源 = 拓展资源;
    }

    public List<DataEntity> get福利() {
        return 福利;
    }

    public void set福利(List<DataEntity> 福利) {
        this.福利 = 福利;
    }
}

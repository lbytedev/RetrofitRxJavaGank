package info.lbyte.gank.data;


/**
 * Created by zhangbinbin on 16/5/28.
 */
public class GankDayData {
    private String[] category;
    private boolean error;
    private GankDayEntity results;


    public String[] getCategory() {
        return category;
    }

    public void setCategory(String[] category) {
        this.category = category;
    }

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public GankDayEntity getResults() {
        return results;
    }

    public void setResults(GankDayEntity results) {
        this.results = results;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("catogory:").append(category.toString())
                .append("error: ").append(error)
                .append("result: ").append(results.getAndroid().size());
        return sb.toString();
    }
}

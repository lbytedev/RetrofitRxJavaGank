package info.lbyte.gank.data;

import java.util.List;

/**
 * Created by zhangbinbin on 16/5/29.
 */
public class TypeData {
    private boolean error;
    private List<DataEntity> results;

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public List<DataEntity> getResults() {
        return results;
    }

    public void setResults(List<DataEntity> results) {
        this.results = results;
    }
}

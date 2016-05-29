package info.lbyte.gank;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import info.lbyte.gank.View.GankRecyclerViewAdapter;
import info.lbyte.gank.data.DataEntity;
import info.lbyte.gank.data.HttpMethods;
import info.lbyte.gank.data.TypeData;
import rx.Subscriber;

/**
 * Created by zhangbinbin on 16/5/28.
 */
public class GankFragment extends Fragment {
    private RecyclerView mRecyclerView;
    private List<DataEntity> mDatas = new ArrayList<>();
    private GankRecyclerViewAdapter mAdapter;
    private String mType;


    public GankFragment() {

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mType = getArguments().getString("type");
        HttpMethods.getInstance().getTypeData(new Subscriber<TypeData>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(TypeData typeData) {
                for (DataEntity entity : typeData.getResults()) {
                    mDatas.add(entity);
                }
                mAdapter.notifyDataSetChanged();
            }
        },mType,50,1);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_gank, container, false);
        mRecyclerView = (RecyclerView) rootView.findViewById(R.id.recyclerView);
        return rootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initRecyclerView();

    }

    private void initRecyclerView() {
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mAdapter = new GankRecyclerViewAdapter(getActivity(), mDatas);
        mRecyclerView.setAdapter(mAdapter);
    }

}

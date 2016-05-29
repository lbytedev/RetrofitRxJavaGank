package info.lbyte.gank.View;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

import info.lbyte.gank.R;
import info.lbyte.gank.data.DataEntity;

/**
 * Created by zhangbinbin on 16/5/28.
 */
public class GankRecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static final int TYPE_PICTURE = 0x0010;
    private static final int TYPE_ARTICAL = 0x0011;

    private List<DataEntity> mDatas;
    private Context mContext;

    public GankRecyclerViewAdapter(Context context,List<DataEntity> datas) {
        mContext = context;
        this.mDatas = datas;
    }

    public void setData(List<DataEntity> data){
        mDatas = data;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView;
        switch (viewType){
            case TYPE_PICTURE:
                itemView = LayoutInflater.from(mContext).inflate(R.layout.item_gank_fuli,parent,false);
                return new PictureViewHolder(itemView);
            default:
                itemView = LayoutInflater.from(mContext).inflate(R.layout.item_gank_ganhuo,parent,false);
                return new GanHuoViewHolder(itemView);
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        switch (getItemViewType(position)){
            case TYPE_PICTURE:
                bindFuli((PictureViewHolder) holder,position);
                break;
            case TYPE_ARTICAL:
                bindGankHuo((GanHuoViewHolder) holder,position);
                break;
        }
    }

    private void bindGankHuo(GanHuoViewHolder holder,int position) {
        DataEntity entity = mDatas.get(position);
        holder.mTvDesc.setText(entity.getDesc());
        holder.mTvAuthor.setText(entity.getWho());
    }

    private void bindFuli(PictureViewHolder holder,int position) {
        Uri uri = Uri.parse(mDatas.get(position).getUrl());
        holder.simpleDraweeView.setImageURI(uri);
    }


    @Override
    public int getItemCount() {
        return mDatas.size();
    }



    @Override
    public int getItemViewType(int position) {
        if (mDatas.get(position).getType().equals("福利"))
            return TYPE_PICTURE;
        else return TYPE_ARTICAL;
    }


    class PictureViewHolder extends RecyclerView.ViewHolder {
        public SimpleDraweeView simpleDraweeView;

        public PictureViewHolder(View itemView) {
            super(itemView);
            simpleDraweeView = (SimpleDraweeView) itemView.findViewById(R.id.simple_drawee_view);
        }
    }

    class GanHuoViewHolder extends RecyclerView.ViewHolder {

        public TextView mTvDesc;
        public TextView mTvAuthor;
        public GanHuoViewHolder(View itemView) {
            super(itemView);
            mTvDesc = (TextView) itemView.findViewById(R.id.tv_desc);
            mTvAuthor = (TextView) itemView.findViewById(R.id.tv_author);
        }
    }
}

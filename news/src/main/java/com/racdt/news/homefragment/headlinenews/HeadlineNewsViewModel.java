package com.racdt.news.homefragment.headlinenews;

import android.widget.Toast;

import androidx.lifecycle.MutableLiveData;

import com.racdt.base.BaseApplication;
import com.racdt.base.mvvm.model.BaseMvvmModel;
import com.racdt.base.mvvm.model.IBaseModelListener;
import com.racdt.base.mvvm.model.PagingResult;
import com.racdt.news.homefragment.api.NewsChannelsBean;

import java.util.List;

public class HeadlineNewsViewModel implements IBaseModelListener<List<NewsChannelsBean.ChannelList>> {
    protected NewsChannelModel model;
    //假如有多个api可以在这里定义多个model ————》
    public MutableLiveData<List<NewsChannelsBean.ChannelList>> dataList = new MutableLiveData<>();

    public HeadlineNewsViewModel(){
//        dataList.setValue(new ArrayList<>());直接用postValue 可以不初始化
        model = new NewsChannelModel();
        model.register(this);
        model.getCachedDataAndLoad();
    }

    @Override
    public void onLoadSuccess(BaseMvvmModel model, List<NewsChannelsBean.ChannelList> channelLists, PagingResult... results) {
        if(model instanceof NewsChannelModel) {//《————然后在这里做区分
//            dataList.getValue().clear();
//            dataList.getValue().addAll(channelLists);
            dataList.postValue(channelLists);
        }
    }

    @Override
    public void onLoadFail(BaseMvvmModel model, String message, PagingResult... results) {
        Toast.makeText(BaseApplication.sApplication, message, Toast.LENGTH_LONG).show();
    }
}

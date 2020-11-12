package com.racdt.news.homefragment.headlinenews;

import com.racdt.base.mvvm.model.BaseMvvmModel;
import com.racdt.network.TecentNetworkApi;
import com.racdt.network.observer.BaseObserver;
import com.racdt.news.homefragment.api.NewsApiInterface;
import com.racdt.news.homefragment.api.NewsChannelsBean;

import java.util.List;

//要做反序列话，所以要知道原始的数据类型 所以泛型中加入NewsChannelsBean
public class NewsChannelModel extends BaseMvvmModel<NewsChannelsBean, List<NewsChannelsBean.ChannelList>> {

    public NewsChannelModel() {
        super(false,"NEWS_CHANNEL_PREF_KEY");
    }

        @Override
    public void load(){
        TecentNetworkApi.getService(NewsApiInterface.class)
                .getNewsChannels()
                .compose(TecentNetworkApi.getInstance().
                        applySchedulers(new BaseObserver<NewsChannelsBean>(this,this)));
    }

    @Override
    public void onSuccess(NewsChannelsBean newsChannelsBean, boolean isFromCache) {
        notifyResultToListener(newsChannelsBean,newsChannelsBean.showapiResBody.channelList,isFromCache);

    }

    @Override
    public void onFailure(Throwable e) {
        loadFail(e.getMessage());
    }
}

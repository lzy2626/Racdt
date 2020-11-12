package com.racdt.common.views.picturetitleview;

import android.content.Context;
import android.view.View;

import com.racdt.base.customview.BaseCustomView;
import com.racdt.common.R;
import com.racdt.common.databinding.PictureTitleViewBinding;
import com.racdt.webview.WebviewActivity;

public class PictureTitleView extends BaseCustomView<PictureTitleViewBinding, PictureTitleViewModel> {
    public PictureTitleView(Context context) {
        super(context);
    }

    @Override
    public int getLayoutId() {
        return R.layout.picture_title_view;
    }

    @Override
    public void onRootClicked(View view) {
        WebviewActivity.startCommonWeb(getContext(), "News", data.jumpUri);
    }

    @Override
    protected void setDataToView(PictureTitleViewModel pictureTitleViewModel) {
        binding.setViewModel(pictureTitleViewModel);
    }
}

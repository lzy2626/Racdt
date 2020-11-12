package com.racdt.common.views.titleview;

import android.content.Context;
import android.view.View;

import com.racdt.base.customview.BaseCustomView;
import com.racdt.common.R;
import com.racdt.common.databinding.TitleViewBinding;
import com.racdt.webview.WebviewActivity;

public class TitleView extends BaseCustomView<TitleViewBinding, TitleViewModel> {
    public TitleView(Context context) {
        super(context);
    }

    @Override
    public int getLayoutId() {
        return R.layout.title_view;
    }

    @Override
    public void onRootClicked(View view) {
        WebviewActivity.startCommonWeb(getContext(), "News", data.jumpUri);
    }

    @Override
    protected void setDataToView(TitleViewModel titleViewModel) {
        binding.setViewModel(titleViewModel);
    }
}

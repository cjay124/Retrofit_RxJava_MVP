package com.example.y.mvp.fragment;


import android.support.v4.view.ViewPager;
import android.view.View;

import com.example.y.mvp.R;
import com.example.y.mvp.adapter.TabNameAdapter;
import com.example.y.mvp.mvp.Bean.TabNameInfo;
import com.example.y.mvp.mvp.presenter.BasePresenter;
import com.example.y.mvp.mvp.presenter.TabNamePresenterImpl;
import com.example.y.mvp.mvp.view.BaseView;
import com.example.y.mvp.utils.ActivityUtils;
import com.example.y.mvp.utils.UIUtils;
import com.example.y.mvp.utils.theme.widget.ThemeTabLayout;

import java.util.LinkedList;
import java.util.List;

/**
 * by 12406 on 2016/5/1.
 */
public class ImageViewPagerFragment extends BaseFragment implements BaseView.TabNameView {

    private ThemeTabLayout tabLayout;
    private ViewPager viewPager;

    private TabNameAdapter tabNameAdapter;
    private List<TabNameInfo> data;

    @Override
    public View initView() {
        return View.inflate(UIUtils.getActivity(), R.layout.fragment_viewpager, null);
    }

    @Override
    protected void initById() {
        tabLayout = getView(R.id.tab_layout);
        viewPager = getView(R.id.viewPager);
    }

    @Override
    public void initData() {


        BasePresenter.TabNamePresenter tabNamePresenter = new TabNamePresenterImpl(this);
        tabNamePresenter.requestNetWork();

        data = new LinkedList<>();
        tabNameAdapter = new TabNameAdapter(getChildFragmentManager(), data);
    }


    @Override
    public void setData(List<TabNameInfo> datas) {
        if (!datas.isEmpty()) {
            data.addAll(datas);
            viewPager.setAdapter(tabNameAdapter);
            tabLayout.setupWithViewPager(viewPager);
        }
    }

    @Override
    public void netWorkError() {
        ActivityUtils.Toast(UIUtils.getString(R.string.network_error));
    }

    @Override
    public void hideProgress() {

    }

    @Override
    public void showProgress() {

    }

    @Override
    public void showFoot() {

    }

    @Override
    public void hideFoot() {

    }
}

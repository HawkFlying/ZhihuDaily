package com.baiiu.zhihudaily;

import com.baiiu.zhihudaily.base.BaseFragment;

/**
 * author: baiiu
 * date: on 17/10/27 11:18
 * description:
 */
public class GankListFragment extends BaseFragment {

    public static GankListFragment instance() {
        return new GankListFragment();
    }

    @Override public int provideLayoutId() {
        return R.layout.fragment_gank;
    }
}

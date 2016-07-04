package com.example.y.mvp.mvp.presenter;

import com.example.y.mvp.mvp.Bean.NewsDetailInfo;
import com.example.y.mvp.mvp.model.BaseDataBridge;
import com.example.y.mvp.mvp.model.BaseModel;
import com.example.y.mvp.mvp.model.NewsDetailModelImpl;
import com.example.y.mvp.mvp.view.BaseView;

/**
 * by 12406 on 2016/5/30.
 */
public class NewsDetailPresenterImpl extends BasePresenterImpl<BaseView.NewsDetailView>
        implements BasePresenter.NewsDetailPresenter, BaseDataBridge.NewsDetailData {

    private final BaseModel.NewsDetailModel newsDetailModel;

    public NewsDetailPresenterImpl(BaseView.NewsDetailView view) {
        super(view);
        newsDetailModel = new NewsDetailModelImpl();
    }

    @Override
    public void requestNetWork(int id) {
       // 业务逻辑开始执行
        view.showProgress();
        newsDetailModel.netWorkNewsDetail(id, this);//接口形式回调给present


    }

    @Override
    public void addData(NewsDetailInfo datas) {
        view.setData(datas); //真正添加数据的还是view成 回调为了获取数据而已
        view.hideProgress();
    }


    @Override
    public void error() {
        view.hideProgress();
        view.netWorkError();
    }
}

package com.example.y.mvp.mvp.presenter;

import com.example.y.mvp.activity.NewsDetailActivity;
import com.example.y.mvp.mvp.Bean.NewsListInfo;
import com.example.y.mvp.mvp.model.BaseDataBridge;
import com.example.y.mvp.mvp.model.BaseModel;
import com.example.y.mvp.mvp.model.NewsListModelImpl;
import com.example.y.mvp.mvp.view.BaseView;

import java.util.List;

/**
 * by 12406 on 2016/5/15.
 */
public class NewsListPresenterImpl extends BasePresenterImpl<BaseView.NewsListView>
        implements BasePresenter.NewsListPresenter, BaseDataBridge.NewsListData {
//到处用接口为了扩展方便
    private final BaseModel.NewsListModel newsListModel;//  BaseDataBridge.NewsListData 回调接口拿到数据

    public NewsListPresenterImpl(BaseView.NewsListView view) {
        super(view);
        this.newsListModel = new NewsListModelImpl();
    }


    @Override
    public void requestNetWork(int id, int page, boolean isNull) {
        //请求之前提示dialog
        if (page == 1) {
            view.showProgress();
        } else {
            if (!isNull) {
                view.showFoot();
            }
        }


        //真正请求通过this 接口对象回调请求获取的数据集合  this 获取拿到数据至于怎么拿到是mode 成中network 的工作
        //  network 传入参数订阅者 订阅者回调获取的值 然后 这边 adddate 和error 又再次将数据回调到present
        // present处理回调的数据 将回调的数据给view成 及activity 成获取 present 成数据 最后显示出来
        newsListModel.netWorkNewList(id, page, this);
    }

    @Override
    public void onClick(NewsListInfo info) {
        NewsDetailActivity.startIntent(info.getId());
    }


    @Override
    public void addData(List<NewsListInfo> tngou) {
     //   、、拿到数据后添加数据 隐藏脚

        view.setData(tngou);
        view.hideFoot();
        view.hideProgress();
    }

    @Override
    public void error() {
        //数据获取错误
        view.hideFoot();
        view.hideProgress();
        view.netWorkError();
    }
}

package com.example.y.mvp.mvp.model;

/**
 * by y on 2016/5/27.
 */
public interface BaseModel<T> {


    void netWork(T model);

    interface TabNewsModel extends BaseModel<BaseDataBridge.TabNewsData> {

    }

    interface TabNameModel extends BaseModel<BaseDataBridge.TabNameData> {
    }

    interface NewsListModel {  //方法不太一样 另外处理  吃出定义接口
        void netWorkNewList(int id, int page, BaseDataBridge.NewsListData newsListData);
    }

    interface NewsDetailModel {
        void netWorkNewsDetail(int id, BaseDataBridge.NewsDetailData newsDetailData);
    }

    interface ImageNewModel {
        void netWorkNew(int id, int rows, BaseDataBridge.ImageNewData imageNewData);
    }

    interface ImageListModel {
        void netWorkList(int id, int page, BaseDataBridge.ImageListData imageListData);
    }

    interface ImageDetailModel {  //h获取详情
        void netWorkDetail(int id, BaseDataBridge.ImageDetailData imageDetailData);
    }

    interface JokeTextListModel {
        void netWorkJoke(int page, BaseDataBridge.JokeTextList jokeList);
    }

    interface JokePicListModel {
        void netWorkJoke(int page, BaseDataBridge.JokePicList jokeList);
    }

}

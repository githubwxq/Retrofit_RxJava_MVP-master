package com.example.y.mvp.mvp.model;


import com.example.y.mvp.mvp.Bean.BaseBean;
import com.example.y.mvp.network.MySubscriber;
import com.example.y.mvp.network.NetWorkRequest;

/**
 * by y on 2016/4/29.
 */
public class ImageDetailModelImpl implements BaseModel.ImageDetailModel {

//回调给present 中有view 和mode 然后结合   数据 与 数据回调接口结合 最终给上层提供数据 数据层 将数据给present层 本类中有其他类的接口以为这本类为被订阅者
    @Override
    public void netWorkDetail(int id, final BaseDataBridge.ImageDetailData imageDetailData) {

        NetWorkRequest.imageDetail(id, new MySubscriber<BaseBean.ImageDetailBean>() {

            @Override
            public void onError(Throwable e) {
                super.onError(e);
                imageDetailData.error();
            }

            @SuppressWarnings("unchecked")
            @Override
            public void onNext(BaseBean.ImageDetailBean imageDetailBean) {
                super.onNext(imageDetailBean);
                imageDetailData.addData(imageDetailBean.getList());
            }
        });
    }


}

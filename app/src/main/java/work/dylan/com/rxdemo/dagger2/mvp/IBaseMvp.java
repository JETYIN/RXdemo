package work.dylan.com.rxdemo.dagger2.mvp;

/**
 * Created by Administrator on 2018/6/26.
 */

//FIXME
public interface IBaseMvp {//FIXME 此类用于定义mvp的基类接口

    interface IBasePresenter<T> {//FIXME presenter基类接口

        void attach(T view);//FIXME presenter与view的绑定，T为实现View层接口的任意activity,为IBaseView的实现类

        void detach();
    }

    interface IBaseView {//FIXME view层基类接口

        void showError();//网络任务失败

        void complete();//网络任务完成
    }
}

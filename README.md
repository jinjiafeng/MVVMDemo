
# MVVM基础框架搭建

此框架采用ViewModel+LiveData+Rxjava2+Dagger2+Retrofit搭建

首先放上一张基本架构图

![MVVMComponent](/images/MVVMComponent.png)

#### ViewModel优点

- ViewModel不持有View视图的引用，可以有效的减少内存泄漏
- 存储Activity中的数据，知道Activity完全销毁，常用于屏幕旋转后的数据保存
- 可以共享同一个Activity中Fragment之间的数据

#### LiveData的优点

- 能够在页面销毁的时候主动解除监听，消除内存泄漏
- 不会在后台处理事件
- 数据更新，对同一个liveData源监听的观察者会正确的收到最新的数据

#### 项目整体框架

1. Activity/Fragment 持有ViewModel的引用，并对ViewModel中的LiveData对象进行监听，当有调用liveData.setValue/postValue 方法,onChanged()方法会被执行。

   ```
   mViewModel.mMsgLiveData.observe(this, new Observer<Object>() {
       @Override
       public void onChanged(@Nullable Object object) {
                   
               }
           });
   ```

2. ViewModel持有用于数据访问的DataManager，网络请求采用的是Retrofit+Rxjava2，在onSubcribe()方法中对livedata数据进行更新，选择Rxjava是为了方便线程切换和数据处理。最后需要在ViewModel的onCleared()暂停rxjava网络请求，防止内存泄露。

   ```
    @Override
       protected void onCleared() {
           super.onCleared();
           mCompositeDisposable.clear();
       }
   ```

3. Model层封装DataManager统一进行获取，类关系如下：

   ![](/images/DataManager.png)




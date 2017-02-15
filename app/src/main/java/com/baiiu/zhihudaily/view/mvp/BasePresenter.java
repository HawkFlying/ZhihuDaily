package com.baiiu.zhihudaily.view.mvp;

import rx.Subscription;
import rx.subscriptions.CompositeSubscription;

/**
 * Base class that implements the Presenter interface and provides a base implementation for
 * attachView() and detachView(). It also handles keeping a reference to the mvpView that
 * can be accessed from the children classes by calling getMvpView().
 */
public abstract class BasePresenter<T extends MvpView> implements MVPPresenter<T> {

    private T mMvpView;
    protected CompositeSubscription mCompositeSubscription;

    @Override public void attachView(T mvpView) {
        mMvpView = mvpView;
        mCompositeSubscription = new CompositeSubscription();
    }

    protected void addSubscription(Subscription subscription) {
        if (subscription == null) {
            return;
        }
        mCompositeSubscription.add(subscription);
    }

    @Override public void detachView() {
        mMvpView = null;
        if (mCompositeSubscription != null && mCompositeSubscription.hasSubscriptions()) {
            mCompositeSubscription.unsubscribe();
            mCompositeSubscription = null;
        }
    }

    public boolean isViewAttached() {
        return mMvpView != null;
    }

    public T getMvpView() {
        checkViewAttached();
        return mMvpView;
    }

    public void checkViewAttached() {
        if (!isViewAttached()) throw new MvpViewNotAttachedException();
    }

    public static class MvpViewNotAttachedException extends RuntimeException {
        public MvpViewNotAttachedException() {
            super("Please call Presenter.attachView(MvpView) before" + " requesting data to the Presenter");
        }
    }
}


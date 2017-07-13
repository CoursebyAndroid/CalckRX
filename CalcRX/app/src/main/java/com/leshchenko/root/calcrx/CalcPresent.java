package com.leshchenko.root.calcrx;

import android.graphics.drawable.Drawable;


import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import com.jakewharton.rxbinding.widget.RxTextView;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;


/**
 * Created by Root on 17.06.2017.
 */

public class CalcPresent implements IPresenter
{


    private static final String TAG = "CalcPresent " ;
    private IView calcView;

    public CalcPresent(IView calcView)
    {
        this.calcView = calcView;
    }

    private boolean isEditEmpty(CharSequence charSequence)
    {
        return charSequence.length() == 0 ? false : true;
    }

    private boolean isValueValid(CharSequence value){
        return value.toString().matches("[0-9]");
    }

    private boolean isOperandValid(CharSequence value){
        return value.toString().matches("[*||+||/||-]");
    }

    @Override
    public Observable<CharSequence> listerFirstValue(EditText et, Drawable isTrue, Drawable isFalse)
    {
        rx.Observable<CharSequence> listnerValue = RxTextView.textChanges(et);
        listnerValue.map(this::isValueValid)
                .subscribe(isEmpty -> et.setCompoundDrawablesRelativeWithIntrinsicBounds(null, null, (isEmpty ? isTrue : isFalse), null));


        return listnerValue;
    }

    @Override
    public Observable<CharSequence> listerSecondValue(EditText et, Drawable isTrue, Drawable isFalse)
    {
        rx.Observable<CharSequence> listnerValue = RxTextView.textChanges(et);
        listnerValue.map(this::isValueValid)
                .subscribe(isEmpty -> et.setCompoundDrawablesRelativeWithIntrinsicBounds(null, null, (isEmpty ? isTrue : isFalse), null));

        return listnerValue;
    }

    @Override
    public Observable<CharSequence> listerOper(EditText et, Drawable isTrue, Drawable isFalse)
    {
        rx.Observable<CharSequence> listnerValue = RxTextView.textChanges(et);
        listnerValue.map(this::isOperandValid)
                .subscribe(isEmpty -> et.setCompoundDrawablesRelativeWithIntrinsicBounds(null, null, (isEmpty ? isTrue : isFalse), null));
        return listnerValue;
    }

    @Override
    public void showBtn(Object... params)
    {
        Button btn = (Button) params[0];
        Observable<CharSequence> listerFirstValue =(Observable<CharSequence>) params[1];
        Observable<CharSequence> listerOper =(Observable<CharSequence>) params[2];
        Observable<CharSequence> listerSecondValue =(Observable<CharSequence>) params[3];
        Observable<Boolean>booleanObservable =
               Observable.combineLatest(listerFirstValue,listerOper,listerSecondValue,(o1,o2,o3)
        -> isValueValid(o1) && isOperandValid(o2) && isValueValid(o3));
        booleanObservable.subscribe(new Subscriber<Boolean>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(Boolean aBoolean) {
                Observable<Boolean> observable = Observable.just(aBoolean);
                observable.subscribeOn(Schedulers.newThread())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(isVisable -> btn.setVisibility(isVisable ? View.VISIBLE : View.GONE));
            }
        });

    }


    public void calc(Object... params)
    {

    }

    @Override
    public void doCalc(String str)
    {

    }

    @Override
    public void saveDate(String str)
    {

    }

    @Override
    public void deleteData(String str)
    {

    }

    @Override
    public void readData(String str) {

    }
}

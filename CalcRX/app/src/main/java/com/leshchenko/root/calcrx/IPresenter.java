package com.leshchenko.root.calcrx;
import android.graphics.drawable.Drawable;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Objects;

import rx.Observable;


/**
 * Created by Root on 17.06.2017.
 */

public interface IPresenter
{
    Observable<CharSequence> listerFirstValue(EditText et, Drawable isTrue, Drawable isFalse);
    Observable<CharSequence>listerSecondValue(EditText et, Drawable isTrue,Drawable isFalse);
    Observable<CharSequence>listerOper(EditText et, Drawable isTrue,Drawable isFalse);
    void showBtn(Object ...params);
    int calc(String fv, String op, String sv);

    Observable<Integer> doCalc(String fv, String op, String sv);

    void saveDate(String str);
    void deleteData(String str);
    void readData(String str);
}

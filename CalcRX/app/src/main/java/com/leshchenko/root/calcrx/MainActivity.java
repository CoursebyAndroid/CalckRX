package com.leshchenko.root.calcrx;

import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import rx.Observable;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, IView {
    private EditText val1, val2, op;
    private TextView res;
    private Drawable mInvalidvalue, mValidValue;
    private Button btnRES;
    private IPresenter iPresenter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        val1 = (EditText) findViewById(R.id.id_txt_val_1);
        op = (EditText) findViewById(R.id.id_txt_op);
        val2 = (EditText) findViewById(R.id.id_txt_val_2);
        res = (TextView) findViewById(R.id.id_txt_result);
        btnRES = (Button) findViewById(R.id.btn_result);
        mInvalidvalue = getResources().getDrawable(android.R.drawable.presence_online);
        mValidValue = getResources().getDrawable(android.R.drawable.presence_busy);

        iPresenter = new CalcPresent(this);

        Observable<CharSequence> observableValueA = iPresenter.listerFirstValue(val1, mInvalidvalue, mValidValue);
        Observable<CharSequence> observableOperand = iPresenter.listerOper(op, mInvalidvalue, mValidValue);
        Observable<CharSequence> observableValueB = iPresenter.listerSecondValue(val2, mInvalidvalue, mValidValue);

        iPresenter.showBtn(btnRES, observableValueA, observableOperand, observableValueB);
        btnRES.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        String fv = String.valueOf(val1.getText());
        String opr = String.valueOf(op.getText());
        String sv = String.valueOf(val2.getText());
        switch (v.getId()) {
            case R.id.btn_result:
                iPresenter.doCalc(fv, opr, sv).subscribe(result -> {
                     String str = String.valueOf(result);
                    res.setText(str);
                });
                break;
        }

//        Calc calc = new Calc( val1,  val2,  op);
//        switch (v.getId()){
//            case R.id.btn_result:
//                int rex = calc.getRes();
//                res.setText(String.valueOf(rex));
//                break;
//        }

    }

    @Override
    public void ShowToast(String str) {

    }

    @Override
    public void getResult(String str) {

    }
}

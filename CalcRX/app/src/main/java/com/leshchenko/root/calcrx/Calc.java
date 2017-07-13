package com.leshchenko.root.calcrx;

import android.widget.EditText;

/**
 * Created by Root on 17.06.2017.
 */

public class Calc
{
private int res;
    public Calc(EditText val1, EditText val2, EditText op) {

        int numA=Integer.parseInt(String.valueOf(val1.getText()));
        int numB=Integer.parseInt(String.valueOf(val2.getText()));
        String oper = String.valueOf((op.getText()));

        switch (oper)
        {
            case "+": res = numA+numB; break;
            case "-": res = numA-numB; break;
            case "/": res = numA/numB; break;
            case "*": res = numA*numB; break;
        }

    }

    public int getRes() {return res;}
}

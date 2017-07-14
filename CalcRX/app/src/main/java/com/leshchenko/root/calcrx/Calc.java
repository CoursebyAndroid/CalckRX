package com.leshchenko.root.calcrx;

import android.widget.EditText;

/**
 * Created by Root on 17.06.2017.
 */

public class Calc
{
private int res;
    public Calc(String val1, String op,String val2) {

        int numA=Integer.parseInt(String.valueOf(val1));
        int numB=Integer.parseInt(String.valueOf(val2));
        String oper = String.valueOf((op));

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

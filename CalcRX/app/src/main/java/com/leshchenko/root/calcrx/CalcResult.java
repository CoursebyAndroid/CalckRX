package com.leshchenko.root.calcrx;

/**
 * Created by Root on 22.06.2017.
 */

public class CalcResult
{
    //=======================VALUE======================================
    //private Long id;
    private String numA;
    private String op;
    private String numB;
    private String res;

    //==========CONSTRUCTOR==========================================
    public CalcResult(String numA, String op, String numB, String res) {
        this.numA = numA;
        this.op = op;
        this.numB = numB;
        this.res = res;
    }


//=============TO STRING =================
    @Override
    public String toString() {
        return "CalcResult{" +
                "numA='" + numA + '\'' +
                ", op='" + op + '\'' +
                ", numB='" + numB + '\'' +
                ", res='" + res + '\'' +
                '}';
    }

    //============GET AND SET================
    public String getNumA() {
        return numA;
    }

    public void setNumA(String numA) {
        this.numA = numA;
    }

    public String getOp() {
        return op;
    }

    public void setOp(String op) {
        this.op = op;
    }

    public String getNumB() {
        return numB;
    }

    public void setNumB(String numB) {
        this.numB = numB;
    }

    public String getRes() {
        return res;
    }

    public void setRes(String res) {
        this.res = res;
    }
}

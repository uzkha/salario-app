package com.example.meusalario.model;

public class Irff {

    private double aliquota;
    private double deducao;

    public Irff(double salario){

        if(salario <= 1093.98){
            this.setAliquota(0);
            this.setDeducao(0);
        }else if(salario >= 1903.99 && salario <= 2826.65){
            this.setAliquota(7.5);
            this.setDeducao(142.80);
        }else if(salario >= 2826.66 && salario <= 3751.05){
            this.setAliquota(15);
            this.setDeducao(354.80);
        }else if(salario >= 3751.06 && salario <= 4664.68){
            this.setAliquota(22.5);
            this.setDeducao(636.13);
        }else{
            this.setAliquota(27.5);
            this.setDeducao(869.36);
        }

    }

    public double getAliquota() {
        return aliquota;
    }

    public void setAliquota(double aliquota) {
        this.aliquota = aliquota;
    }

    public double getDeducao() {
        return deducao;
    }

    public void setDeducao(double deducao) {
        this.deducao = deducao;
    }
}

package com.example.meusalario.model;

public class Inss {

    private double aliquota;
    private double deducao;

    public Inss(double salario){

        if(salario <= 1045){
            this.setAliquota(7.5);
            this.setDeducao(0);
        }else if(salario >= 1045.01 && salario <= 2089.60){
            this.setAliquota(9);
            this.setDeducao(15.67);
        }else if(salario >= 2089.61 && salario <= 3134.40){
            this.setAliquota(12);
            this.setDeducao(78.36);
        }else if(salario >= 3134.41 && salario <= 6101.06){
            this.setAliquota(14);
            this.setDeducao(141.05);
        }else{
            this.setAliquota(0);
            this.setDeducao(0);
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

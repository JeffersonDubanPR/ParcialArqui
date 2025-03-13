package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public class Telefonica {
    private int id;
    private int minutosLocales;
    private int minutosLargaDistancia;
    private int minutosCelular;
    private int costoTotal;

    public Telefonica(int id) {
        this.id = id;
        this.minutosLocales = 0;
        this.minutosLargaDistancia = 0;
        this.minutosCelular = 0;
        this.costoTotal = 0;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMinutosLocales() {
        return minutosLocales;
    }

    public void setMinutosLocales(int minutosLocales) {
        this.minutosLocales = minutosLocales;
    }

    public int getMinutosLargaDistancia() {
        return minutosLargaDistancia;
    }

    public void setMinutosLargaDistancia(int minutosLargaDistancia) {
        this.minutosLargaDistancia = minutosLargaDistancia;
    }

    public int getMinutosCelular() {
        return minutosCelular;
    }

    public void setMinutosCelular(int minutosCelular) {
        this.minutosCelular = minutosCelular;
    }

    public int getCostoTotal() {
        return costoTotal;
    }

    public void setCostoTotal(int costoTotal) {
        this.costoTotal = costoTotal;
    }

    public void registrarLlamada(int tipo, int minutos) {
        switch (tipo) {
            case 1 -> minutosLocales += minutos;
            case 2 -> minutosLargaDistancia += minutos;
            case 3 -> minutosCelular += minutos;
        }
        calcularCostoTotal();
        System.out.println("\n Llamada registrada en la cabina " + id);
    }

    private void calcularCostoTotal() {
        costoTotal = (minutosLocales * 50) + (minutosLargaDistancia * 350) + (minutosCelular * 150);
    }

    public void mostrarInfo() {
        System.out.println("\n Cabina " + id);
        System.out.println(" - Minutos Locales: " + minutosLocales + " | Costo: $" + (minutosLocales * 50));
        System.out.println(" - Minutos Larga Distancia: " + minutosLargaDistancia + " | Costo: $" + (minutosLargaDistancia * 350));
        System.out.println(" - Minutos Celular: " + minutosCelular + " | Costo: $" + (minutosCelular * 150));
        System.out.println(" - Costo Total: $" + costoTotal);
    }

    public void reiniciar() {
        minutosLocales = 0;
        minutosLargaDistancia = 0;
        minutosCelular = 0;
        costoTotal = 0;
        System.out.println("\n Cabina " + id + " ha sido reiniciada.");
    }
}











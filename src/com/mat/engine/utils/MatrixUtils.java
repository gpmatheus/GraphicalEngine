
package com.mat.engine.utils;

public class MatrixUtils {


    public static double[][] matmul(double[][] a, double[][] b) {

        if (b.length == 0)
            throw new RuntimeException("There was un unexpected entry value");

        double[][] result = new double[b.length][b[0].length];

        // o promeiro for é para cada linha da matriz da esquerda
        for (int i = 0; i < a.length; i++) {

            // o segundo for é para cada coluna da matriz da direita
            for (int j = 0; j < b[0].length; j++) {

                //o terceiro for é para multiplicar cada elemento da linha da esquerda pela coluna da direita
                for (int m = 0; m < b.length && m < a[i].length; m++) {

                    result[i][j] += a[i][m] * b[m][j];
                }
            }
        }

        return result;
    }
}
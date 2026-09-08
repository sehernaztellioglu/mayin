package org.example;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.util.List;
import javax.swing.JButton;


class main{

    static JFrame frame = new JFrame();
    static JPanel panel = new JPanel();

    static JButton[][] butonlar = new JButton[15][15];

    static void dugmeOlusturma(int boyut) {

        for (int i = 0; i < boyut ; i++) {
            for (int j = 0; j < boyut ; j++) {

                butonlar[i][j] = new JButton();
                panel.add(butonlar[i][j]);

                butonlar[i][j].addActionListener(e -> {
                    JButton tiklanan = (JButton) e.getSource();

                    if (Boolean.TRUE.equals(tiklanan.getClientProperty("mayin"))) {
                        tiklanan.setText("*");
                    } else {
                        tiklanan.setText(
                                String.valueOf(tiklanan.getClientProperty("sayi"))
                        );
                    }
                });
            }
        }
    }






   static void komsulariSayiArtirma(int boyut){

       for (int i = 1; i < boyut - 1; i++) {
           for (int j = 1; j < boyut - 1; j++) {

               int sayac = 0;

               if (Boolean.TRUE.equals(butonlar[i-1][j-1].getClientProperty("mayin"))) {
                   sayac++;
               }

               if (Boolean.TRUE.equals(butonlar[i-1][j].getClientProperty("mayin"))) {
                   sayac++;
               }

               if (Boolean.TRUE.equals(butonlar[i-1][j+1].getClientProperty("mayin"))) {
                   sayac++;
               }

               if (Boolean.TRUE.equals(butonlar[i][j-1].getClientProperty("mayin"))) {
                   sayac++;
               }

               if (Boolean.TRUE.equals(butonlar[i][j+1].getClientProperty("mayin"))) {
                   sayac++;
               }

               if (Boolean.TRUE.equals(butonlar[i+1][j-1].getClientProperty("mayin"))) {
                   sayac++;
               }

               if (Boolean.TRUE.equals(butonlar[i+1][j].getClientProperty("mayin"))) {
                   sayac++;
               }

               if (Boolean.TRUE.equals(butonlar[i+1][j+1].getClientProperty("mayin"))) {
                   sayac++;
               }

               butonlar[i][j].putClientProperty("sayi", sayac);
           }
       }
   }


    public static void main(String[] args) {

        dugmeOlusturma(15);





        Random random = new Random();

        for (int i = 0; i < 5; i++) {

            int satir = random.nextInt(butonlar.length);
            int sutun = random.nextInt(butonlar[satir].length);


            butonlar[satir][sutun].putClientProperty("mayin", true);


        }


        komsulariSayiArtirma(15);


        panel.setLayout(new GridLayout(15,15));
        frame.add(panel);

        frame.setSize(300, 300);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
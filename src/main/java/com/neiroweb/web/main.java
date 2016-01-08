package com.neiroweb.web;

import java.awt.image.BufferedImage;

/**
 * Created by Константин on 03.01.2016.
 */
public class main {
    public static void main(String args[])
    {
        Character ch=new Character('А');
        Neuron[] neurons=new Neuron[32];
       for (int i=0;i<32;i++){
        neurons[i] = new Neuron(ch);
        neurons[i].getName();
        ch++;
        }

        BufferedImage img= Neuron.createBImage("C:/Project/neiroweb/nweb/img/A.jpg");
        int pixels[][]=Neuron.convertTo2DWithoutUsingGetRGB(img);
        int i=0;

    }
}

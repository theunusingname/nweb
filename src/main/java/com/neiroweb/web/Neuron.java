package com.neiroweb.web;

import java.util.Vector;

/**
 * Created by Константин on 29.12.2015.
 */
public class Neuron {
    String name;
    int input[][];
    int memory [][];

    public Neuron(String name) {
        this.name = name;
        this.memory=new int[30][30];
        this.input=new int[30][30];
    }
}

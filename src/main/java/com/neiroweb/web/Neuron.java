package com.neiroweb.web;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.*;
import java.io.File;
import java.io.IOException;
import java.util.Vector;

/**
 * Created by Константин on 29.12.2015.
 */
public class Neuron {
    String name;
    int input[][];
    int memory [][];
    BufferedImage letter=null;


    public Neuron(String name) {
        this.name = name;
        this.memory=new int[30][30];
        this.input=new int[30][30];
        this.loadImage();
        }


    public Neuron(Character name) {
        this.name=name.toString();
        this.memory=new int[30][30];
        this.input=new int[30][30];
        this.loadImage();

        }


    private void loadImage(){
        File file=new File("C:/Project/neiroweb/nweb/img/"+name+".bmp");
        try {
            letter = ImageIO.read(file);
        } catch (IOException e) {
            System.out.println("reading from file error");
        }
    }

    public static BufferedImage createBImage(String filename){
        BufferedImage output=null;
        File file=new File(filename);
        try {
            output = ImageIO.read(file);
        } catch (IOException e) {
        }
        return output;
    }

    public String getName() {
        System.out.println(name);
        return name;
    }

    public int lookAt(BufferedImage iLetter){
        int wheight=0;
        int[] iarray=new int[256];
        Raster data=iLetter.getData();
        data.getPixel(0,0,iarray);
        return wheight;
    }

    public static int[][] convertTo2DWithoutUsingGetRGB(BufferedImage image) {

        final byte[] pixels = ((DataBufferByte) image.getRaster().getDataBuffer()).getData();
        final int width = image.getWidth();
        final int height = image.getHeight();
        final boolean hasAlphaChannel = image.getAlphaRaster() != null;

        int[][] result = new int[height][width];
        if (hasAlphaChannel) {
            final int pixelLength = 4;
            for (int pixel = 0, row = 0, col = 0; pixel < pixels.length; pixel += pixelLength) {
                int argb = 0;
                argb += (((int) pixels[pixel] & 0xff) << 24); // alpha
                argb += ((int) pixels[pixel + 1] & 0xff); // blue
                argb += (((int) pixels[pixel + 2] & 0xff) << 8); // green
                argb += (((int) pixels[pixel + 3] & 0xff) << 16); // red
                result[row][col] = argb;
                col++;
                if (col == width) {
                    col = 0;
                    row++;
                }
            }
        } else {
            final int pixelLength = 3;
            for (int pixel = 0, row = 0, col = 0; pixel < pixels.length; pixel += pixelLength) {
                int argb = 0;
                //argb += -16777216; // 255 alpha
                argb += ((int) pixels[pixel] & 0xff); // blue
                argb += ((int) pixels[pixel + 1] & 0xff); // green
                argb += ((int) pixels[pixel + 2] & 0xff); // red
                result[row][col] = argb/pixelLength;
                col++;
                if (col == width) {
                    col = 0;
                    row++;
                }
            }
        }

        return result;
    }

    //public int lookAt(String fileName){

    //}


}

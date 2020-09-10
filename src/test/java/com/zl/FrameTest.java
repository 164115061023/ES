package com.zl;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class FrameTest {


    public static void main(String[] args) {
        Frame frame = new Frame();
        frame.setSize(800,600);
        frame.setTitle("tan ke");
        frame.setResizable(false);
        frame.setVisible(true);


        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

    }

}

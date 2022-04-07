package com.mat.engine;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JSlider;

public class Screen extends JFrame {

    private Panel panel = Panel.getPanel();
    
    public Screen() {
        JSlider slider = new JSlider();
        slider.setOrientation(JSlider.VERTICAL);
        slider.setMinimum(45);
        slider.setMaximum(120);
        slider.setValue(45);
        slider.addChangeListener(l -> {
            panel.setProjectorFov((double) slider.getValue());
            panel.repaint();
        });
        setName("Engine");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setSize(700, 700);
        setVisible(true);
        add(panel, BorderLayout.CENTER);
        add(slider, BorderLayout.EAST);
    }
}

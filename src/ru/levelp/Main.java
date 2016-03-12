package ru.levelp;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;

/**
 * Created by natalie on 12.03.16.
 */
public class Main {

    private static int i = 12;

    public static void main(String[] args) {

//    1) Создать текстовый редактор:
//    - должно быть текстовое поле (JTextArea)
//    - должны быть кнопки увеличения и уменьшения шрифта (гугл)
//    - дожна быть кнопка Clear
//    * Добавить вертикальный скролл
//    * Добавить отступы между компонентами

        JFrame mainFrame = new JFrame("Text Edit");
        mainFrame.setBounds(200, 200, 400, 400);
        mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JTextArea text = new JTextArea();
        mainFrame.add(BorderLayout.CENTER, text);


        Font font = new Font("TimesRoman", Font.PLAIN, i);
        text.setFont(font);

        text.setLineWrap(true); // перенос строки
        text.setWrapStyleWord(true); // перенос по словам

        mainFrame.add(new JScrollPane(text)); // scrollbar

        JToolBar bar = new JToolBar(); // тулбар с кнопками

        JButton fontUp = new JButton("Font PLUS"); // кнопки +/- на тулбаре
        JButton fontDown = new JButton("Font MINUS");

        bar.add(fontUp);
        bar.addSeparator();
        bar.add(fontDown);

        mainFrame.add(BorderLayout.NORTH, bar);

        fontUp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Font font1 = new Font("TimesRoman", Font.PLAIN, i++);
                text.setFont(font1);
            }
        });

        fontDown.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Font font1 = new Font("TimesRoman", Font.PLAIN, i--);
                text.setFont(font1);
            }
        });

        mainFrame.setVisible(true);

    }

}

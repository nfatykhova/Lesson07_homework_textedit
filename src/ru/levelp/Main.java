package ru.levelp;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 * Created by natalie on 12.03.16.
 */
public class Main {

    private static int fontSize;

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

        fontSize = 12;
        Font font = new Font("TimesRoman", Font.PLAIN, fontSize);
        text.setFont(font);

        text.setLineWrap(true); // перенос строки
        text.setWrapStyleWord(true); // перенос по словам

        mainFrame.add(new JScrollPane(text)); // scrollbar

        JToolBar bar = new JToolBar(); // тулбар с кнопками

        JButton fontUp = new JButton("Font +"); // кнопки +/- на тулбаре
        JButton fontDown = new JButton("Font -");
        JButton clear = new JButton("Clear");
        JTextField size = new JTextField();
        size.setText("Font size " + fontSize);

        bar.add(size);
        bar.addSeparator();
        bar.add(fontUp);
        bar.addSeparator();
        bar.add(fontDown);
        bar.addSeparator();
        bar.add(clear);

        mainFrame.add(BorderLayout.NORTH, bar);

        fontUp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                text.setFont(new Font("TimesRoman", Font.PLAIN, ++fontSize));
                size.setText("Font size " + fontSize);
            }
        });

        fontDown.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                text.setFont(new Font("TimesRoman", Font.PLAIN, --fontSize));
                size.setText("Font size " + fontSize);
            }
        });

        clear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                text.setText(null);
            }
        });

        mainFrame.setVisible(true);

    }

}

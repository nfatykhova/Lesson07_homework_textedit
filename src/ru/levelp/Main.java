package ru.levelp;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import javax.swing.*;

/**
 * Created by natalie on 12.03.16.
 */
public class Main {

    private static int fontSize;

    public static void main(String[] args) {

        /*
        save, save as, open - joptiondialog
         */

        JFrame mainFrame = new JFrame("Text Edit");
        mainFrame.setBounds(200, 200, 400, 400);
        mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        JMenu editMenu = new JMenu("Edit");
        JMenuItem newFileMenuItem = new JMenuItem("New");
        JMenuItem openFileMenuItem = new JMenuItem("Open");
        JMenuItem saveFileMenuItem = new JMenuItem("Save");
        JMenuItem saveAsFileMenuItem = new JMenuItem("Save As");
        JMenuItem clearEditMenuItem = new JMenuItem("Clear");

        fileMenu.add(newFileMenuItem);
        fileMenu.add(openFileMenuItem);
        fileMenu.add(saveFileMenuItem);
        fileMenu.add(saveAsFileMenuItem);

        editMenu.add(clearEditMenuItem);

        menuBar.add(fileMenu);
        menuBar.add(editMenu);

        JTextArea text = new JTextArea();
        mainFrame.add(BorderLayout.CENTER, text);

        try {
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(
                            new FileInputStream("mytextedit.txt")
                    )
            );

            String text;
            while ((text = reader.readLine()) != null) {
         //       text ; вывести текст
                // settext для jtextarea или заюзать другой эл-т

            }

        } catch (FileNotFoundException exc) {
            exc.printStackTrace();
        } catch (IOException exc) {
            exc.printStackTrace();
            }

        fontSize = 12;
        Font font = new Font("TimesRoman", Font.PLAIN, fontSize); // text.getFont().getName()
        text.setFont(font);

        text.setLineWrap(true); // перенос строки
        text.setWrapStyleWord(true); // перенос по словам

        mainFrame.add(new JScrollPane(text)); // scrollbar

        JToolBar bar = new JToolBar(); // тулбар с кнопками

        JButton fontUp = new JButton("Font +"); // кнопки +/- на тулбаре
        JButton fontDown = new JButton("Font -");
        JButton clear = new JButton("Clear");
        JButton save = new JButton("Save");

        save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    PrintWriter writer = new PrintWriter(
                            new FileOutputStream("mytextedit.txt", true), false
                    );

                    writer.println(text.getText());
                    writer.flush();
                    writer.close();

                } catch (IOException exc) {
                    exc.printStackTrace();
                }
            }
        });

        JTextField size = new JTextField();
        size.setText("Font size " + fontSize);

        bar.add(size);
        bar.addSeparator();
        bar.add(fontUp);
        bar.addSeparator();
        bar.add(fontDown);
        bar.addSeparator();
        bar.add(clear);
        bar.addSeparator();
        bar.add(save);

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

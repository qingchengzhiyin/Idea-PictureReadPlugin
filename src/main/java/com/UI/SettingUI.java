package com.UI;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class SettingUI {
    private JTextField urlPath;
    private JButton urlButton;
    private JLabel urlLabel;
    private JPanel mainPanel;

    public SettingUI() {
        urlButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser jFileChooser = new JFileChooser();
                FileNameExtensionFilter filter = new FileNameExtensionFilter("Image Files", "jpg", "png", "gif", "jpeg");
                jFileChooser.setFileFilter(filter);
                jFileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
                jFileChooser.showOpenDialog(mainPanel);
                File file = jFileChooser.getSelectedFile();
                urlPath.setText(file.getPath());
            }
        });
    }

    public JTextField getUrlPath() {
        return urlPath;
    }

    public JPanel getMainPanel() {
        return mainPanel;
    }
}

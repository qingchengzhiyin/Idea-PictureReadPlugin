package com.Factory;

import com.UI.SettingUI;
import com.intellij.openapi.options.ConfigurationException;
import com.intellij.openapi.options.SearchableConfigurable;
import com.louis.Config;
import org.jetbrains.annotations.Nls;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;
import java.io.File;
import java.io.RandomAccessFile;
import java.nio.charset.StandardCharsets;

public class SettingFactory implements SearchableConfigurable {
    private SettingUI settingUI =new SettingUI();
    @Override
    public @NotNull String getId() {
        return "test.id"; }
    @Override
    public @Nls(capitalization = Nls.Capitalization.Title) String getDisplayName()
    {
        return "test-config"; }
    @Override
    public @Nullable JComponent createComponent() {
        return settingUI.getMainPanel();
    }
    @Override
    public boolean isModified() {
        return true; }

    @Override
    public void apply() throws ConfigurationException {
        String url = settingUI.getUrlPath().getText();

        try {
            File file = new File(url);
            RandomAccessFile randomAccessFile = new RandomAccessFile(file, "r");
            randomAccessFile.seek(0);

            byte[] bytes = new byte[1024*1024];
            int readSize = randomAccessFile.read(bytes);

            byte[] copy = new byte[readSize];
            System.arraycopy(bytes,0,copy,0,readSize);

            String str = new String(copy, StandardCharsets.UTF_8);

            ImageIcon icon = new ImageIcon(file.getPath());
            Config.readUI.getPictureLabel().setIcon(icon);

        }catch (Exception e){

        }

    }
}

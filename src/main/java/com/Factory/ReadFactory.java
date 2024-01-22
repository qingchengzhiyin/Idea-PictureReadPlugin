package com.Factory;

import com.UI.ReadUI;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.wm.ToolWindow;
import com.intellij.openapi.wm.ToolWindowFactory;
import com.intellij.ui.content.Content;
import com.intellij.ui.content.ContentFactory;
import com.louis.Config;
import org.jetbrains.annotations.NotNull;

public class ReadFactory implements ToolWindowFactory {
    private ReadUI readUI = new ReadUI();

    @Override
    public void createToolWindowContent(@NotNull Project project, @NotNull ToolWindow toolWindow) {
        ContentFactory contentFactory = ContentFactory.getInstance();
        Content content = contentFactory.createContent(readUI.getMainPanel(), "", false);
        toolWindow.getContentManager().addContent(content);
        Config.readUI = readUI;
    }
}

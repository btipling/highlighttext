import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.editor.Document;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.editor.markup.*;
import com.intellij.openapi.fileEditor.FileEditorManager;
import com.intellij.openapi.project.Project;
import com.intellij.ui.JBColor;

import java.awt.*;

/**
 * Created by bjorn on 3/17/15.
 */
public class HighlightAllText extends AnAction {
    RangeHighlighter rangeHighlighter;
    public void actionPerformed(AnActionEvent e) {
        final Project project = e.getProject();
        if (project == null) {
            return;
        }
        Editor editor = FileEditorManager.getInstance(project).getSelectedTextEditor();
        if (editor == null) {
            return;
        }
        TextAttributes attributes = new TextAttributes();
        JBColor color = JBColor.GREEN;
        attributes.setEffectColor(color);
        attributes.setEffectType(EffectType.SEARCH_MATCH);
        attributes.setBackgroundColor(new Color(255, 0, 0, 50));
        attributes.setForegroundColor(Color.WHITE);
        MarkupModel markupModel = editor.getMarkupModel();
        Document doc = editor.getDocument();
        rangeHighlighter = markupModel.addRangeHighlighter(0, doc.getTextLength(),
                HighlighterLayer.ERROR + 100, attributes, HighlighterTargetArea.EXACT_RANGE);


    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hr.fer.oop.summer_2020_21.task5;

import com.github.difflib.text.DiffRow;
import com.github.difflib.text.DiffRowGenerator;
import java.text.BreakIterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import javax.swing.JLabel;
import javax.swing.JTextPane;
import javax.swing.SwingWorker;

/**
 *
 * @author kpripuzic
 */
public class DiffWorker extends SwingWorker<String, Pair<Integer>> {

    private int deleted = 0, added = 0; //counters
    private String leftText, rightText;
    private JLabel deletedLabel, addedLabel; //counter labels
    private JTextPane textPane;

    public DiffWorker(String leftText, String rightText, JLabel deletedLabel, JLabel addedLabel, JTextPane textPane) {
        this.leftText = leftText;
        this.rightText = rightText;
        this.deletedLabel = deletedLabel;
        this.addedLabel = addedLabel;
        this.textPane = textPane;
    }//end of Diffworker constructor

    private List<String> splitSentences(String text) {
        List<String> result = new LinkedList<>();
        BreakIterator breakIterator = BreakIterator.getSentenceInstance();
        breakIterator.setText(text);
        int index = 0;
        while (breakIterator.next() != BreakIterator.DONE) {
            String sentence = text.substring(index, breakIterator.current());
            result.add(sentence);
            index = breakIterator.current();
        }
        return result;
    }//end of splitSentences

    @Override
    protected String doInBackground() throws Exception {
        //get differences
        DiffRowGenerator generator = DiffRowGenerator.create()
                .showInlineDiffs(true).mergeOriginalRevised(true)
                .inlineDiffByWord(true)
                .oldTag((t, f) -> f ? "<strike>" : "</strike>")//tag for deleted words
                .newTag((t, f) -> f ? "<b>" : "</b>")//tag for added words
                .build();
        List<DiffRow> rows = generator.generateDiffRows(
                splitSentences(leftText), splitSentences(rightText));
        StringBuilder sb = new StringBuilder("<html>");

        //do something with each DiffRow in rows
        for (DiffRow row : rows) {
            String rowString = row.getOldLine();
            Pair<Integer> pair = new Pair<>(
                    countOccurances(rowString, "<strike>"),
                    countOccurances(rowString, "<b>"));

            //TODO – update return value, publish chunks
            publish(pair);
            sb.append(rowString);
        }
        sb.append("</html>");
        return sb.toString();
    } //end of doInBackground method

    @Override
    protected void process(List<Pair<Integer>> chunks) {
        //TODO
        for (Pair<Integer> chunk : chunks) {
            deleted += chunk.getFirst();
            added += chunk.getSecond();
            deletedLabel.setText("Deleted substrings: " + deleted);
            addedLabel.setText("Added substrings: " + added);
        }
    } //end of process method

    @Override
    protected void done() {
        //TODO
        try {
            String result = this.get();
            textPane.setText(result);
        } catch (InterruptedException | ExecutionException ex) {
            //do nothing
        }
    }// end of done method

    private int countOccurances(String string, String find) {
        int lastIndex = 0;
        int count = 0;

        while (lastIndex != -1) {
            lastIndex = string.indexOf(find, lastIndex);
            if (lastIndex != -1) {
                count++;
                lastIndex += find.length();
            }
        }
        return count;
    } //end of countOccurances method
} //end of DiffWorker class


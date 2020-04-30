/*
 * Copyright 2020 alazar.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package gui;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JTable;
import javax.swing.table.TableColumn;

/**
 *
 * @author alazar
 */
public class SortDateThread extends Thread {
    JFileChooser chooserFile;

    public SortDateThread(JFileChooser chooserJFile) {
        super();
        chooserFile = chooserJFile;
    }
    
    public void run() {
        try {
            sleep(800);//0.8sec
        } catch (InterruptedException ex) {
            Logger.getLogger(SortDateThread.class.getName()).log(Level.SEVERE, null, ex);
        }
        List<?> list = SwingUtils.getDescendantsOfType(JTable.class, chooserFile);
        if (SwingUtils.getDescendantsOfType(JTable.class, chooserFile).size()!=0) {
           //  Find the JTable on the file chooser panel and manually do the sort: date modified
            JTable table = SwingUtils.getDescendantsOfType(JTable.class, chooserFile).get(0);
            TableColumn column3 = table.getColumnModel().getColumn(3);
            column3.setPreferredWidth(130);
            table.getRowSorter().toggleSortOrder(3);
            table.getRowSorter().toggleSortOrder(3);
            // fix? https://stackoverflow.com/questions/49454949/java-jfilechooser-detail-view-sorting-by-date-not-running-with-java-9
        }
    }
}

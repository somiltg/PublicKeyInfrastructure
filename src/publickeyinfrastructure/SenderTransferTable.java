/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package publickeyinfrastructure;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import java.util.Vector;
import javax.swing.JProgressBar;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author somil
 */
public class SenderTransferTable extends AbstractTableModel
        implements Observer {
    
private static final String[] columnNames = {"User(IP)","Filepath/Message","Transferred Size","Total Size","Transfer Speed",
    "Progress", "Time left","Status"};  
    private static final Class[] columnClasses = {String.class,
    String.class,String.class,String.class,String.class, JProgressBar.class, String.class,String.class};
     
    // The table's list of downloads.
    private ArrayList<SenderSideTransfer> transferList = new ArrayList<SenderSideTransfer>();
    public void addTransfer(SenderSideTransfer transfer) {
         
        // Register to be notified when the transfer changes.
        transfer.addObserver(this);
        transferList.add(transfer);
        fireTableRowsInserted(getRowCount()-1, getRowCount()-1);
    }
     
    // Get a transfer for the specified row.
    public SenderSideTransfer getTransfer(int row) {
        return (SenderSideTransfer) transferList.get(row);
    }
     
    // Remove a transfer from the list.
    public void clearTransfer(int row) {
        transferList.remove(row);
        fireTableRowsDeleted(row, row);
    }
    
    public String getColumnName(int col) {
        return columnNames[col];
    }
     
    public Class getColumnClass(int col) {
        return columnClasses[col];
    }

    public int getRowCount() {
        return transferList.size();
    }

    @Override
    public int getColumnCount() {
       return columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
      SenderSideTransfer transfer;
    transfer = (SenderSideTransfer) transferList.get(rowIndex);
        switch (columnIndex) {
            case 0: // IP USER
                return transfer.getUserName()+"("+transfer.getIP()+")"; 
            case 1: return transfer.getFilePath()==null?transfer.getMessage():transfer.getFilePath();
            case 2:    return transfer.getBytesTransferred();
            case 3: return transfer.getSize();
            case 4:return transfer.getTransferSpeed();
            case 5: return transfer.getProgress();
            case 6:return transfer.getTimeForTransfer();
            case 7: // Status
                return EndUser.SENDER_STATUSES[transfer.getStatus()];
        }
        return "";
    }
    
    @Override
    public void update(Observable o, Object arg) {
        int index=transferList.indexOf(o);
        fireTableRowsUpdated(index, index);
    }
    
}

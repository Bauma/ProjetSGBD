package modele;

import javax.swing.table.AbstractTableModel;

public class ZModel extends AbstractTableModel {

    private Object[][] data = new Object[0][0];
    private String[] title;

    //Constructeur
    public ZModel(Object[][] data, String[] title){
        this.data = data;
        this.title = title;
    }

    //Retourne le nombre de colonnes
    public int getColumnCount() {
        return this.title.length;
    }

    //Retourne le nombre de lignes
    public int getRowCount() {
        return this.data.length;
    }

    //Retourne la valeur à l'emplacement spécifié
    public Object getValueAt(int row, int col) {
        return this.data[row][col];
    }

    public void setData(Object[][] newData){
        data = newData;
        super.fireTableDataChanged();
    }

}
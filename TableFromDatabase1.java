/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Inst;

import java.awt.BorderLayout;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.Vector;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author 
 */
public class TableFromDatabase1 extends JFrame {
    
    private static String SQL = null;
    private static final String DB_DRIVER = "org.apache.derby.jdbc.ClientDriver";
    private static final String DB_CONNECTION = "jdbc:derby://localhost:1527/Instrum";
    private static final String DB_USER = "app";
    private static final String DB_PASSWORD = "app";
    
    public TableFromDatabase1()
    {
        Vector<Object> columnNames = new Vector<Object>();
        Vector<Object> data = new Vector<Object>();

        
        try
        {
            Class.forName( DB_DRIVER );
            Connection connection = DriverManager.getConnection( DB_CONNECTION, DB_USER, DB_PASSWORD );

            //  Read data from a table
            
            String sql = "SELECT ZAYAVKI.KODZ, ZAYAVKI.DATEZ,INSTRUMENTS.NANE, ZAYAVKI.KOL, ZAYAVKI.EDIZM, PODR.NAMEC, WORKERS.NAMEW \n" +
            "FROM ZAYAVKI, INSTRUMENTS, PODR, WORKERS\n" +
            "WHERE ZAYAVKI.KODINST=INSTRUMENTS.KOD and PODR.KODC = ZAYAVKI.KODC and WORKERS.KODW = ZAYAVKI.KODSOTR";
            
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery( sql );
            ResultSetMetaData md = rs.getMetaData();
            int columns = md.getColumnCount();

            //  Get column names
            
            columnNames.addElement("Код заявки");
            columnNames.addElement("Дата заявки");
            columnNames.addElement("Инструмент");
            columnNames.addElement("Количество");
            columnNames.addElement("Единица измерения");
            columnNames.addElement("Цех (подразделение)");
            columnNames.addElement("Сотрудник");
            this.setSize(650, 480);
            this.setVisible(true);          
            //for (int i = 1; i <= columns; i++)
            //{
               // columnNames.addElement( md.getColumnName(i) );
            //}

            //  Get row data

            while (rs.next())
            {
                Vector<Object> row = new Vector<Object>(columns);

                for (int i = 1; i <= columns; i++)
                {
                    row.addElement( rs.getObject(i) );
                }

                data.addElement( row );
            }

            rs.close();
            stmt.close();
            connection.close();
        }
        catch(Exception e)
        {
            System.out.println( e );
        }

        //  Create table with database data

        DefaultTableModel model = new DefaultTableModel(data, columnNames)
        {
        	@Override
            public Class getColumnClass(int column)
            {
                for (int row = 0; row < getRowCount(); row++)
                {
                    Object o = getValueAt(row, column);

                    if (o != null)
                    {
                        return o.getClass();
                    }
                }

                return Object.class;
            }
        };
	JTable table1 = new JTable( model );
        JScrollPane scrollPane11 = new JScrollPane( table1 );
        getContentPane().add( scrollPane11 );
        JPanel buttonPanel = new JPanel();
        getContentPane().add( buttonPanel, BorderLayout.SOUTH );
}
public static void main(String[] args)
    {
        TableFromDatabase1 frame = new TableFromDatabase1();
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
    
}

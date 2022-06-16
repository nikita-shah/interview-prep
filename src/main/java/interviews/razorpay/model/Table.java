/* created by nikita */
package interviews.razorpay.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Table {

    String tableName;
    List<Row> rows;
    HashMap<String, Column> columnInfo;

    public Table(String tableName, HashMap<String, Column> columnInfo) {
        this.tableName = tableName;
        this.columnInfo = columnInfo;
    }

    public Table createTable(String tableName, HashMap<String, Column> columnInfo) {
        Table table = new Table(tableName, columnInfo);
        rows = new ArrayList<Row>();
        return table;

    }

    public List<Row> getAllRecords(String tableName) {
        return this.rows;
    }



    public void insertRecord(String tableName, HashMap<String, Object> dataSet) {
        List<Row> rows = this.rows;
        Row row = new Row();

        if (!this.tableName.equalsIgnoreCase(tableName)) {

        } else {

            for (Map.Entry<String, Object> data : dataSet.entrySet()) {
                Column column;
                String inputColumnName = data.getKey();
                Object inputColumnValue = data.getValue(); //String or Int expected
                Column matchingColumn = columnInfo.get(inputColumnName);
                //String dataTypeExpected = matchingColumn.getDataType();
                /*check for validations*/
                //todo : check for mandatory attribute

                if (matchingColumn == null) {
                    break;
                }
                //matching column found
                /* else{

                     if(dataTypeExpected == "String")
                     {
                         if(inputColumnValue.getClass()!= String.class)
                         return false;
                     }
                     else if (dataTypeExpected == "Integer")
                     {
                         if(inputColumnValue.getClass()!= Integer.class)
                             return false;
                     }
                     //datatype matched
                     Column column = new Column(dataTypeExpected,)



                 }*/
                if (inputColumnValue.getClass() == matchingColumn.getColumnType()) {
                    // Class<T>type,T data, String columnName
                    column = new Column(inputColumnValue.getClass(), inputColumnValue, inputColumnName);

                    row.getColumnList().add(column);
                }


            }
        }
        // check mandatory attribute here
        //throw an exception if not
        rows.add(row);
    }

}

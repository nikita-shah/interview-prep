/* created by nikita */
package interviews.razorpay.model;

public class Column<T>{

    Class<T> typeParameterClass;
    T data;
   // String dataType;
    String columnName;
    boolean isMandatory;


    public Column( Class<T>type,T data, String columnName) {
        typeParameterClass = type;
        validateData(data);
        this.data = data;
        this.columnName = columnName;
    }

    private boolean validateData(T data) {
        if (data instanceof String)
        {
            if (data.toString().length() > 20 )
            {
                return false;
            }

        }
        return true;
    }

    //to be used for createTable
    public Column( Class<T>type,String columnName, boolean isMandatory) {
        typeParameterClass = type;
        this.columnName = columnName;
        this.isMandatory = isMandatory;
    }

    public Class<T> getColumnType ()
    {
        return typeParameterClass;
    }

  /*  public String getDataType() {
        return dataType;
    }*/
//TODO: validations/constraints  to be taken care of there for char size and int range

}



/*


Class Table
{
   String tableName;
 List<Row>rows
//List <String> columnNames // to do
Hash<String columnName, Column> columnInfo;
}









Class Column<T>{
String columnName;
T data;
boolean isMandatory;

//validations/constraints  to be taken care of there for char size and int range
}

 */
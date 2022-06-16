/* created by nikita */
package interviews.razorpay.model;

import java.util.ArrayList;
import java.util.List;

public class Row {
    List<Column> columnList;

    public List  getColumnList()
    {
        if (columnList == null)
        {
            columnList =  new ArrayList<>();
        }
        return columnList;
    }
}


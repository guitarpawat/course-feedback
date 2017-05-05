/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coursefeedback.db;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Pawat Nakpiphatkul
 */
public class DBQuery {
    private String command;
    private List<Object> bindValues = new ArrayList<>();
    
    protected DBQuery() {}
    
    protected void setPreparedCommand(String cmd) {
        command = cmd;
    }
    
    protected String getPreparedCommand() {
        return command;
    }
    
    protected void addBindValue(Object value) {
        bindValues.add(value);
    }
    
    protected void removeAllBindValue() {
        bindValues.clear();
    }
    
    protected Object[] getBindValues() {
        return bindValues.toArray();
    }
    
    protected void setBindValues(List values) {
        bindValues = values;
    }
    
    protected void clear() {
        command = "";
        bindValues.clear();
    }
}

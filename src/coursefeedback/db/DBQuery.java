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

    protected DBQuery() {
    }

    protected final void setPreparedCommand(String cmd) {
        command = cmd;
    }

    protected final String getPreparedCommand() {
        return command;
    }

    protected final void addBindValue(Object value) {
        bindValues.add(value);
    }

    protected final void removeAllBindValue() {
        bindValues.clear();
    }

    protected final Object[] getBindValues() {
        return bindValues.toArray();
    }

    protected final void setBindValues(List values) {
        bindValues = values;
    }

    protected final void clearQuery() {
        command = "";
        bindValues.clear();
    }
}

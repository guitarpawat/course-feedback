/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coursefeedback.db;

import java.util.ArrayList;
import java.util.List;

/**
 * Class for create prepared statement and bind value.
 * @author Pawat Nakpiphatkul
 */
public class DBQuery {

    private String command;
    private List<Object> bindValues = new ArrayList<>();

    /**
     * Constructor for initialize DBQuery.
     */
    protected DBQuery() {
    }

    /**
     * Set the prepared statement command.
     * @param cmd is a prepared statement query string.
     */
    protected final void setPreparedCommand(String cmd) {
        command = cmd;
    }

    /**
     * Get the prepared statement command.
     * @return the prepared statement query string.
     */
    protected final String getPreparedCommand() {
        return command;
    }

    /**
     * Add bind value.
     * @param value is bind value.
     */
    protected final void addBindValue(Object value) {
        bindValues.add(value);
    }

    /**
     * Removes all bind value.
     */
    protected final void removeAllBindValue() {
        bindValues.clear();
    }

    /**
     * Get bind values.
     * @return array of object of bind values.
     */
    protected final Object[] getBindValues() {
        return bindValues.toArray();
    }

    /**
     * Set the bind values.
     * @param values is a list of bind values.
     */
    protected final void setBindValues(List values) {
        bindValues = values;
    }

    /**
     * Clear all query.
     */
    protected final void clearQuery() {
        command = "";
        bindValues.clear();
    }
}

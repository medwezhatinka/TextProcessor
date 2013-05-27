/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package by.epam.lab.model.entity;

import java.util.Objects;

/**
 *
 * @author Soldier
 */
public class Code implements ElementText {

    private String code;

    public Code(String code) {
        this.setCode(code);
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        if (code != null && !code.isEmpty()) {
            this.code = code;
        }
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 17 * hash + Objects.hashCode(this.code);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Code other = (Code) obj;
        if (!Objects.equals(this.code, other.code)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return getClass().getName() + "{code=" + code + '}';
    }

    @Override
    public String getValue() {
        return code;
    }
}

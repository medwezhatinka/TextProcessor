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
public class Symbol {

    private String symbol;

    public Symbol(String symbol) {
        this.setSymbol(symbol);
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        if (symbol != null && !symbol.trim().isEmpty()) {
            this.symbol = symbol;
        }

    }

    public boolean isConsonant() {
        if (symbol.matches("[AaEeYyUuIiOoЕеАаОоЭэЯяЮюЁёы]")) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 11 * hash + Objects.hashCode(this.symbol);
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
        final Symbol other = (Symbol) obj;
        if (!Objects.equals(this.symbol, other.symbol)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return getClass().getName() + "{symbol=" + symbol + "}\n";
    }
}

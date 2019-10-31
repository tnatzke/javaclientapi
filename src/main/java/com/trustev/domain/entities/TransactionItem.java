package com.trustev.domain.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.List;
import java.util.function.Function;

/**
 * Items Object – contains details on Item Name, Quantity and Item Value. Please see Items Object for further parameter information.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TransactionItem extends IdBase<TransactionItem> {

    private String name;
    private int quantity;
    private double itemValue;

    /**
     * @return The Name of the Item being purchased.
     */
    @JsonProperty("Name")
    public String getName() {
        return name;
    }

    /**
     * @param name The Name of the Item being purchased.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return The Quantity of the Item being purchased.
     */
    @JsonProperty("Quantity")
    public int getQuantity() {
        return quantity;
    }


    /**
     * @param quantity The Quantity of the Item being purchased.
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /**
     * @return The Value of the Item being purchased.
     */
    @JsonProperty("ItemValue")
    public double getItemValue() {
        return itemValue;
    }

    /**
     * @param itemValue The Value of the Item being purchased.
     */

    public void setItemValue(double itemValue) {
        this.itemValue = itemValue;
    }

    @Override
    protected void buildSignificationProperties(List<Function<TransactionItem, Comparable>> props) {
        props.add(TransactionItem::getName);
        props.add(TransactionItem::getQuantity);
        props.add(TransactionItem::getItemValue);
        super.buildSignificationProperties(props);
    }
}

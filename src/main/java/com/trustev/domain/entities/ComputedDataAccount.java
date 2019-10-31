package com.trustev.domain.entities;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import java.util.function.Function;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ComputedDataAccount extends Base<ComputedDataAccount> {

    private boolean customerHas1ExistingAccount;
    private boolean customerHas2ExistingAccounts;
    private boolean customerHas3ExistingAccounts;
    private boolean customerHas4ExistingAccounts;
    private boolean customerHasMoreThan5ExistingAccounts;

    @JsonProperty("CustomerHas1ExistingAccount")
    public boolean isCustomerHas1ExistingAccount() {
        return customerHas1ExistingAccount;
    }


    public void setCustomerHas1ExistingAccount(boolean customerHas1ExistingAccount) {
        this.customerHas1ExistingAccount = customerHas1ExistingAccount;
    }

    @JsonProperty("CustomerHas2ExistingAccounts")
    public boolean isCustomerHas2ExistingAccounts() {
        return customerHas2ExistingAccounts;
    }


    public void setCustomerHas2ExistingAccounts(boolean customerHas2ExistingAccounts) {
        this.customerHas2ExistingAccounts = customerHas2ExistingAccounts;
    }

    @JsonProperty("CustomerHas3ExistingAccounts")
    public boolean isCustomerHas3ExistingAccounts() {
        return customerHas3ExistingAccounts;
    }


    public void setCustomerHas3ExistingAccounts(boolean customerHas3ExistingAccounts) {
        this.customerHas3ExistingAccounts = customerHas3ExistingAccounts;
    }

    @JsonProperty("CustomerHas4ExistingAccounts")
    public boolean isCustomerHas4ExistingAccounts() {
        return customerHas4ExistingAccounts;
    }


    public void setCustomerHas4ExistingAccounts(boolean customerHas4ExistingAccounts) {
        this.customerHas4ExistingAccounts = customerHas4ExistingAccounts;
    }


    @JsonProperty("CustomerHasMoreThan5ExistingAccounts")
    public boolean isCustomerHasMoreThan5ExistingAccounts() {
        return customerHasMoreThan5ExistingAccounts;
    }


    public void setCustomerHasMoreThan5ExistingAccounts(boolean customerHasMoreThan5ExistingAccounts) {
        this.customerHasMoreThan5ExistingAccounts = customerHasMoreThan5ExistingAccounts;
    }

    @Override
    protected void buildSignificationProperties(List<Function<ComputedDataAccount, Comparable>> props) {
        props.add(ComputedDataAccount::isCustomerHas1ExistingAccount);
        props.add(ComputedDataAccount::isCustomerHas2ExistingAccounts);
        props.add(ComputedDataAccount::isCustomerHas3ExistingAccounts);
        props.add(ComputedDataAccount::isCustomerHas4ExistingAccounts);
        props.add(ComputedDataAccount::isCustomerHasMoreThan5ExistingAccounts);
        super.buildSignificationProperties(props);
    }
}
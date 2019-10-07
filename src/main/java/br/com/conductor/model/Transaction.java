package br.com.conductor.model;

import java.time.LocalDate;
import java.util.Objects;

import javax.validation.Valid;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Transaction Enitity
 */
@ApiModel(description = "Transaction Enitity")
@Validated
public class Transaction   {
  @JsonProperty("idTransaction")
  private Integer idTransaction = null;

  @JsonProperty("account")
  private Account account = null;

  @JsonProperty("value")
  private Double value = null;

  @JsonProperty("transactionDate")
  private LocalDate transactionDate = null;

  public Transaction idTransaction(Integer idTransaction) {
    this.idTransaction = idTransaction;
    return this;
  }

  /**
   * Transaction ID
   * @return idTransaction
  **/
  @ApiModelProperty(value = "Transaction ID")


  public Integer getIdTransaction() {
    return idTransaction;
  }

  public void setIdTransaction(Integer idTransaction) {
    this.idTransaction = idTransaction;
  }

  public Transaction account(Account account) {
    this.account = account;
    return this;
  }

  /**
   * Get account
   * @return account
  **/
  @ApiModelProperty(value = "")

  @Valid

  public Account getAccount() {
    return account;
  }

  public void setAccount(Account account) {
    this.account = account;
  }

  public Transaction value(Double value) {
    this.value = value;
    return this;
  }

  /**
   * Value
   * @return value
  **/
  @ApiModelProperty(value = "Value")


  public Double getValue() {
    return value;
  }

  public void setValue(Double value) {
    this.value = value;
  }

  public Transaction transactionDate(LocalDate transactionDate) {
    this.transactionDate = transactionDate;
    return this;
  }

  /**
   * Transaction Date
   * @return transactionDate
  **/
  @ApiModelProperty(value = "Transaction Date")

  @Valid

  public LocalDate getTransactionDate() {
    return transactionDate;
  }

  public void setTransactionDate(LocalDate transactionDate) {
    this.transactionDate = transactionDate;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Transaction transaction = (Transaction) o;
    return Objects.equals(this.idTransaction, transaction.idTransaction) &&
        Objects.equals(this.account, transaction.account) &&
        Objects.equals(this.value, transaction.value) &&
        Objects.equals(this.transactionDate, transaction.transactionDate);
  }

  @Override
  public int hashCode() {
    return Objects.hash(idTransaction, account, value, transactionDate);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Transaction {\n");
    
    sb.append("    idTransaction: ").append(toIndentedString(idTransaction)).append("\n");
    sb.append("    account: ").append(toIndentedString(account)).append("\n");
    sb.append("    value: ").append(toIndentedString(value)).append("\n");
    sb.append("    transactionDate: ").append(toIndentedString(transactionDate)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}


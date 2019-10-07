package br.com.conductor.model;

import java.time.LocalDate;
import java.util.Objects;

import javax.validation.Valid;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Account Enitity
 */
@ApiModel(description = "Account Enitity")
@Validated

public class Account   {
  @JsonProperty("idAccount")
  private Integer idAccount = null;

  @JsonProperty("person")
  private Person person = null;

  @JsonProperty("balance")
  private Double balance = null;

  @JsonProperty("limiteWithdrawalDaily")
  private Double limiteWithdrawalDaily = null;

  @JsonProperty("activeFlag")
  private Boolean activeFlag = null;

  @JsonProperty("accountType")
  private Integer accountType = null;

  @JsonProperty("createDate")
  private LocalDate createDate = null;

  public Account idAccount(Integer idAccount) {
    this.idAccount = idAccount;
    return this;
  }

  /**
   * Account ID
   * @return idAccount
  **/
  @ApiModelProperty(value = "Account ID")


  public Integer getIdAccount() {
    return idAccount;
  }

  public void setIdAccount(Integer idAccount) {
    this.idAccount = idAccount;
  }

  public Account person(Person person) {
    this.person = person;
    return this;
  }

  /**
   * Get person
   * @return person
  **/
  @ApiModelProperty(value = "")

  @Valid

  public Person getPerson() {
    return person;
  }

  public void setPerson(Person person) {
    this.person = person;
  }

  public Account balance(Double balance) {
    this.balance = balance;
    return this;
  }

  /**
   * Balance
   * @return balance
  **/
  @ApiModelProperty(value = "Balance")


  public Double getBalance() {
    return balance;
  }

  public void setBalance(Double balance) {
    this.balance = balance;
  }

  public Account limiteWithdrawalDaily(Double limiteWithdrawalDaily) {
    this.limiteWithdrawalDaily = limiteWithdrawalDaily;
    return this;
  }

  /**
   * Limit Withdrawal Daily
   * @return limiteWithdrawalDaily
  **/
  @ApiModelProperty(value = "Limit Withdrawal Daily")


  public Double getLimiteWithdrawalDaily() {
    return limiteWithdrawalDaily;
  }

  public void setLimiteWithdrawalDaily(Double limiteWithdrawalDaily) {
    this.limiteWithdrawalDaily = limiteWithdrawalDaily;
  }

  public Account activeFlag(Boolean activeFlag) {
    this.activeFlag = activeFlag;
    return this;
  }

  /**
   * Flag Active
   * @return activeFlag
  **/
  @ApiModelProperty(value = "Flag Active")


  public Boolean isActiveFlag() {
    return activeFlag;
  }

  public void setActiveFlag(Boolean activeFlag) {
    this.activeFlag = activeFlag;
  }

  public Account accountType(Integer accountType) {
    this.accountType = accountType;
    return this;
  }

  /**
   * Account Type
   * @return accountType
  **/
  @ApiModelProperty(value = "Account Type")


  public Integer getAccountType() {
    return accountType;
  }

  public void setAccountType(Integer accountType) {
    this.accountType = accountType;
  }

  public Account createDate(LocalDate createDate) {
    this.createDate = createDate;
    return this;
  }

  /**
   * Create Date
   * @return createDate
  **/
  @ApiModelProperty(value = "Create Date")

  @Valid

  public LocalDate getCreateDate() {
    return createDate;
  }

  public void setCreateDate(LocalDate createDate) {
    this.createDate = createDate;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Account account = (Account) o;
    return Objects.equals(this.idAccount, account.idAccount) &&
        Objects.equals(this.person, account.person) &&
        Objects.equals(this.balance, account.balance) &&
        Objects.equals(this.limiteWithdrawalDaily, account.limiteWithdrawalDaily) &&
        Objects.equals(this.activeFlag, account.activeFlag) &&
        Objects.equals(this.accountType, account.accountType) &&
        Objects.equals(this.createDate, account.createDate);
  }

  @Override
  public int hashCode() {
    return Objects.hash(idAccount, person, balance, limiteWithdrawalDaily, activeFlag, accountType, createDate);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Account {\n");
    
    sb.append("    idAccount: ").append(toIndentedString(idAccount)).append("\n");
    sb.append("    person: ").append(toIndentedString(person)).append("\n");
    sb.append("    balance: ").append(toIndentedString(balance)).append("\n");
    sb.append("    limiteWithdrawalDaily: ").append(toIndentedString(limiteWithdrawalDaily)).append("\n");
    sb.append("    activeFlag: ").append(toIndentedString(activeFlag)).append("\n");
    sb.append("    accountType: ").append(toIndentedString(accountType)).append("\n");
    sb.append("    createDate: ").append(toIndentedString(createDate)).append("\n");
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


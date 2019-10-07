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
public class Person   {
  @JsonProperty("idPerson")
  private Integer idPerson = null;

  @JsonProperty("name")
  private String name = null;

  @JsonProperty("cpf")
  private LocalDate cpf = null;

  @JsonProperty("birthDate")
  private LocalDate birthDate = null;

  public Person idPerson(Integer idPerson) {
    this.idPerson = idPerson;
    return this;
  }

  /**
   * Person ID
   * @return idPerson
  **/
  @ApiModelProperty(value = "Person ID")


  public Integer getIdPerson() {
    return idPerson;
  }

  public void setIdPerson(Integer idPerson) {
    this.idPerson = idPerson;
  }

  public Person name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Name
   * @return name
  **/
  @ApiModelProperty(value = "Name")


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Person cpf(LocalDate cpf) {
    this.cpf = cpf;
    return this;
  }

  /**
   * CPF
   * @return cpf
  **/
  @ApiModelProperty(value = "CPF")

  @Valid

  public LocalDate getCpf() {
    return cpf;
  }

  public void setCpf(LocalDate cpf) {
    this.cpf = cpf;
  }

  public Person birthDate(LocalDate birthDate) {
    this.birthDate = birthDate;
    return this;
  }

  /**
   * Birth Date
   * @return birthDate
  **/
  @ApiModelProperty(value = "Birth Date")

  @Valid

  public LocalDate getBirthDate() {
    return birthDate;
  }

  public void setBirthDate(LocalDate birthDate) {
    this.birthDate = birthDate;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Person person = (Person) o;
    return Objects.equals(this.idPerson, person.idPerson) &&
        Objects.equals(this.name, person.name) &&
        Objects.equals(this.cpf, person.cpf) &&
        Objects.equals(this.birthDate, person.birthDate);
  }

  @Override
  public int hashCode() {
    return Objects.hash(idPerson, name, cpf, birthDate);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Person {\n");
    
    sb.append("    idPerson: ").append(toIndentedString(idPerson)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    cpf: ").append(toIndentedString(cpf)).append("\n");
    sb.append("    birthDate: ").append(toIndentedString(birthDate)).append("\n");
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


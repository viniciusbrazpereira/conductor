package br.com.conductor.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.validation.Valid;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Error API responses
 */
@ApiModel(description = "Error API responses")
@Validated
public class ApiErrorResponse   {
  @JsonProperty("code")
  private String code = null;

  @JsonProperty("message")
  private String message = null;

  @JsonProperty("description")
  private String description = null;

  @JsonProperty("errors")
  @Valid
  private List<Error> errors = null;

  public ApiErrorResponse code(String code) {
    this.code = code;
    return this;
  }

  /**
   * Error CODE
   * @return code
  **/
  @ApiModelProperty(value = "Error CODE")


  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public ApiErrorResponse message(String message) {
    this.message = message;
    return this;
  }

  /**
   * Error Description
   * @return message
  **/
  @ApiModelProperty(value = "Error Description")


  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public ApiErrorResponse description(String description) {
    this.description = description;
    return this;
  }

  /**
   * Error Details
   * @return description
  **/
  @ApiModelProperty(value = "Error Details")


  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public ApiErrorResponse errors(List<Error> errors) {
    this.errors = errors;
    return this;
  }

  public ApiErrorResponse addErrorsItem(Error errorsItem) {
    if (this.errors == null) {
      this.errors = new ArrayList<Error>();
    }
    this.errors.add(errorsItem);
    return this;
  }

  /**
   * Membership Erros
   * @return errors
  **/
  @ApiModelProperty(value = "Membership Erros")

  @Valid

  public List<Error> getErrors() {
    return errors;
  }

  public void setErrors(List<Error> errors) {
    this.errors = errors;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ApiErrorResponse apiErrorResponse = (ApiErrorResponse) o;
    return Objects.equals(this.code, apiErrorResponse.code) &&
        Objects.equals(this.message, apiErrorResponse.message) &&
        Objects.equals(this.description, apiErrorResponse.description) &&
        Objects.equals(this.errors, apiErrorResponse.errors);
  }

  @Override
  public int hashCode() {
    return Objects.hash(code, message, description, errors);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ApiErrorResponse {\n");
    
    sb.append("    code: ").append(toIndentedString(code)).append("\n");
    sb.append("    message: ").append(toIndentedString(message)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    errors: ").append(toIndentedString(errors)).append("\n");
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


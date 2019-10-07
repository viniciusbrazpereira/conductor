package br.com.conductor.model;

import java.util.Objects;

import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Error Enitity
 */
@ApiModel(description = "Error Enitity")
@Validated

public class Error   {
  @JsonProperty("code")
  private String code = null;

  @JsonProperty("message")
  private String message = null;

  @JsonProperty("nativeMessage")
  private String nativeMessage = null;

  @JsonProperty("trackid")
  private String trackid = null;

  public Error code(String code) {
    this.code = code;
    return this;
  }

  /**
   * Error ID
   * @return code
  **/
  @ApiModelProperty(value = "Error ID")


  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public Error message(String message) {
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

  public Error nativeMessage(String nativeMessage) {
    this.nativeMessage = nativeMessage;
    return this;
  }

  /**
   * Native Error description
   * @return nativeMessage
  **/
  @ApiModelProperty(value = "Native Error description")


  public String getNativeMessage() {
    return nativeMessage;
  }

  public void setNativeMessage(String nativeMessage) {
    this.nativeMessage = nativeMessage;
  }

  public Error trackid(String trackid) {
    this.trackid = trackid;
    return this;
  }

  /**
   * (Optional) Track ID of transaction
   * @return trackid
  **/
  @ApiModelProperty(value = "(Optional) Track ID of transaction")


  public String getTrackid() {
    return trackid;
  }

  public void setTrackid(String trackid) {
    this.trackid = trackid;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Error error = (Error) o;
    return Objects.equals(this.code, error.code) &&
        Objects.equals(this.message, error.message) &&
        Objects.equals(this.nativeMessage, error.nativeMessage) &&
        Objects.equals(this.trackid, error.trackid);
  }

  @Override
  public int hashCode() {
    return Objects.hash(code, message, nativeMessage, trackid);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Error {\n");
    
    sb.append("    code: ").append(toIndentedString(code)).append("\n");
    sb.append("    message: ").append(toIndentedString(message)).append("\n");
    sb.append("    nativeMessage: ").append(toIndentedString(nativeMessage)).append("\n");
    sb.append("    trackid: ").append(toIndentedString(trackid)).append("\n");
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


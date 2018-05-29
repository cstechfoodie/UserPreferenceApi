package io.swagger.model;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Client
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-05-24T21:01:11.236Z")
@RedisHash("Client")
public class Client implements Serializable {

	private static final long serialVersionUID = -8243145429438016231L;

	@Id
	@JsonProperty("uuid")
	private String uuid = null;

	@JsonProperty("first_name")
	private String firstName = null;

	@JsonProperty("last_name")
	private String lastName = null;

	@JsonProperty("actions")
	private Map<String, ClientAction> actions = null;

	public Client uuid(String uuid) {
		this.uuid = uuid;
		return this;
	}

	/**
	 * Unique identifier for the activity
	 * 
	 * @return uuid
	 **/
	@ApiModelProperty(value = "Unique identifier for the activity")

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public Client firstName(String firstName) {
		this.firstName = firstName;
		return this;
	}

	/**
	 * First name of the Uber user.
	 * 
	 * @return firstName
	 **/
	@ApiModelProperty(value = "First name of the Uber user.")

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public Client lastName(String lastName) {
		this.lastName = lastName;
		return this;
	}

	/**
	 * Last name of the Uber user.
	 * 
	 * @return lastName
	 **/
	@ApiModelProperty(value = "Last name of the Uber user.")

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the last_ops
	 */
	public Map<String, ClientAction> getActions() {
		return actions;
	}

	/**
	 * @param last_ops
	 *            the last_ops to set
	 */
	public void setActions(Map<String, ClientAction> actions) {
		this.actions = actions;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Client client = (Client) o;
		return Objects.equals(this.uuid, client.uuid) && Objects.equals(this.firstName, client.firstName)
				&& Objects.equals(this.lastName, client.lastName);
	}

	@Override
	public int hashCode() {
		return Objects.hash(uuid, firstName, lastName);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class Client {\n");

		sb.append("    uuid: ").append(toIndentedString(uuid)).append("\n");
		sb.append("    firstName: ").append(toIndentedString(firstName)).append("\n");
		sb.append("    lastName: ").append(toIndentedString(lastName)).append("\n");
		sb.append("    All Actions: ").append("\n");
		if (actions.size() > 0) {
			actions.forEach((key, value) -> {
				sb.append("    action ID: " + key + ": ").append(value).append("\n");
			});
		}
		else{
			sb.append("    No Recent Actions ").append("\n");
		}
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

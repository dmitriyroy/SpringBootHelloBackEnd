package hello.been;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Contact {

    @JsonProperty("contId")
    private int contId;
    @JsonProperty("name")
    private String name;

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + this.contId;
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
        final Contact other = (Contact) obj;
        if (this.contId != other.contId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Contact:{ contId:" + contId + ", name:" + name + "}";
    }

}

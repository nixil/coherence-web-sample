package my.coherenceweb.sample;

import java.io.Serializable;

/**
 * Created by matrix on 14-9-24.
 */
public class SessionObject implements Serializable {
    private static final long serialVersionUID = -6384209559654494141L;

    private String value;

    @Override
    public String toString() {
        return "SessionObject{" +
                "value='" + value + '\'' +
                '}';
    }

    public SessionObject(String value) {
        this.value = value;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}

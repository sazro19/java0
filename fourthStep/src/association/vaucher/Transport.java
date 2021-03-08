package association.vaucher;

import java.util.Objects;

public class Transport extends VoucherParameter {

    private String name;

    public Transport(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transport transport = (Transport) o;
        return name.equals(transport.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}

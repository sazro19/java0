package association.vaucher;

import java.util.Objects;

public class Days extends VoucherParameter {

    private int days;

    public Days(int days) {
        this.days = days;
    }

    public int getDays() {
        return days;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Days days1 = (Days) o;
        return days == days1.days;
    }

    @Override
    public int hashCode() {
        return Objects.hash(days);
    }
}

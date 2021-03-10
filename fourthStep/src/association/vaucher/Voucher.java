package association.vaucher;

import java.util.Objects;

public class Voucher {

    private Type type;

    private Transport transport;

    private Food food;

    private Days days;

    public Voucher(Type type, Transport transport, Food food, Days days) {
        this.type = type;
        this.transport = transport;
        this.food = food;
        this.days = days;
    }

    public Type getType() {
        return type;
    }

    public VoucherParameter getTransport() {
        return transport;
    }

    public VoucherParameter getFood() {
        return food;
    }

    public VoucherParameter getDays() {
        return days;
    }

    public int getIntDays() {
        return days.getDays();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Voucher voucher = (Voucher) o;
        return type == voucher.type && transport.equals(voucher.transport) &&
                food.equals(voucher.food) && days.equals(voucher.days);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, transport, food, days);
    }
}

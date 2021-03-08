package association.vaucher;

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
}

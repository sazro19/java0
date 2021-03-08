package association.vaucher;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class VoucherService {

    private List<Voucher> voucherList = new ArrayList<>();


    public VoucherService(List<Voucher> voucherList) {
        this.voucherList = voucherList;
    }

    public List<Voucher> offerVoucherList(Type type) {
        List<Voucher> result = new ArrayList<>();
        for (Voucher voucher : voucherList) {
            if (voucher.getType().equals(type)) {
                result.add(voucher);
            }
        }
        return result;
    }

    public List<Voucher> offerVoucherList(Type type, VoucherParameter... parameters) {
        List<VoucherParameter> parameterList = Arrays.asList(parameters);
        List<Voucher> result = new ArrayList<>();
        for (Voucher voucher : voucherList) {
            if (voucher.getType().equals(type) &&
                    (parameterList.contains(voucher.getDays()) ||
                            parameterList.contains(voucher.getFood()) ||
                            parameterList.contains(voucher.getTransport()))) {
                result.add(voucher);
            }
        }
        return result;
    }

    public List<Voucher> sortedVoucherListByDays() {
        List<Voucher> result = voucherList;
        result.sort(Comparator.comparing(Voucher::getIntDays));
        return result;
    }
}

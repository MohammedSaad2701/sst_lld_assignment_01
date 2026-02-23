public class LaundryAddOnPricing implements AddOnPricing {

    public boolean supports(AddOn addOn) {
        return addOn == AddOn.LAUNDRY;
    }

    public double price() {
        return 500.0;
    }
}
public class MessAddOnPricing implements AddOnPricing {

    public boolean supports(AddOn addOn) {
        return addOn == AddOn.MESS;
    }

    public double price() {
        return 1000.0;
    }
}
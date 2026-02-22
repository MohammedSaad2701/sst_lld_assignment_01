public class DefaultRoomPricing implements RoomPricing {

    public boolean supports(int roomType) {
        return true; 
    }

    public double basePrice() {
        return 16000.0;
    }
}

public class SingleRoomPricing implements RoomPricing {

    public boolean supports(int roomType) {
        return LegacyRoomTypes.SINGLE == roomType;
    }

    public double basePrice() {
        return 14000.0;
    }

}
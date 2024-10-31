package StoreInventory;

public class ElectronicItem extends Item {
    private int voltage;

    ElectronicItem(String name, int voltage) {
        super(name);
        this.voltage = voltage;
    }

    public int getVoltage() {
        return voltage;
    }

    public void setVoltage(int voltage) {
        this.voltage = voltage;
    }
}
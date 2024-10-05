interface PoweredDevice {
    void powerOn();
    void powerOff();
}

interface NetworkEnabled {
    void connectToNetwork(String networkName);
    void disconnectFromNetwork();
}

class SmartPhone implements PoweredDevice, NetworkEnabled {
    private String model;
    private boolean isPoweredOn;
    private String connectedNetwork;

    public SmartPhone(String model) {
        this.model = model;
        this.isPoweredOn = false;
        this.connectedNetwork = null;
    }

    public void powerOn() {
        if (!isPoweredOn) {
            isPoweredOn = true;
            System.out.println(model + " is now powered on.");
        } else {
            System.out.println(model + " is already powered on.");
        }
    }

    public void powerOff() {
        if (isPoweredOn) {
            isPoweredOn = false;
            connectedNetwork = null;
            System.out.println(model + " is now powered off.");
        } else {
            System.out.println(model + " is already powered off.");
        }
    }

    public void connectToNetwork(String networkName) {
        if (isPoweredOn) {
            connectedNetwork = networkName;
            System.out.println(model + " connected to " + networkName);
        } else {
            System.out.println("Can't connect to " + networkName + " because " + model + " is OFF.");
        }
    }

    public void disconnectFromNetwork() {
        if (connectedNetwork != null) {
            System.out.println(model + " disconnected from " + connectedNetwork);
            connectedNetwork = null;
        } else {
            System.out.println(model + " is not connected to any network.");
        }
    }

    @Override
    public String toString() {
        String powerStatus = isPoweredOn ? "ON" : "OFF";
        String networkInfo = (connectedNetwork != null) ? "Connected to " + connectedNetwork : "Not connected to any network";
        return "Model: " + model + ", Power: " + powerStatus + ", " + networkInfo;
    }
}

public class Q1 {
    public static void main(String[] args) {
        SmartPhone myPhone = new SmartPhone("Samsoong S234");

        myPhone.powerOn();
        myPhone.connectToNetwork("SSL_GENIE");
        System.out.println(myPhone);
        myPhone.disconnectFromNetwork();
        myPhone.powerOff();
        System.out.println(myPhone);
    }
}

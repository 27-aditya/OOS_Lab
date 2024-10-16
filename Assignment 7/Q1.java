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

    @Override
    public void powerOn() {
        if (!isPoweredOn) {  
            isPoweredOn = true; 
            System.out.println(model + " is powered on."); 
        } else {
            System.out.println(model + " is already powered on."); 
        }
    }

    @Override
    public void powerOff() {
        if (isPoweredOn) {  
            isPoweredOn = false; 
            connectedNetwork = null; 
            System.out.println(model + " is powered off."); 
        } else {
            System.out.println(model + " is already powered off."); 
        }
    }

    @Override
    public void connectToNetwork(String networkName) {
        if (isPoweredOn) { 
            connectedNetwork = networkName; 
            System.out.println(model + " is connected to " + networkName + "."); 
        } else {
            System.out.println(model + " cannot connect to a network because it is powered off."); 
        }
    }

    @Override
    public void disconnectFromNetwork() {
        if (isPoweredOn && connectedNetwork != null) { 
            System.out.println(model + " is disconnected from " + connectedNetwork + "."); 
            connectedNetwork = null; 
        } else if (connectedNetwork == null) {  
            System.out.println(model + " is not connected to any network."); 
        } else {
            System.out.println(model + " cannot disconnect because it is powered off."); 
        }
    }

    @Override
    public String toString() {
        String powerState = isPoweredOn ? "Powered On" : "Powered Off"; 
        String networkState = (connectedNetwork != null) ? connectedNetwork : "Not Connected"; 
        return "Model: " + model + ", Power State: " + powerState + ", Connected Network: " + networkState; 
    }
}

public class Q1 {
    public static void main(String[] args) {
        SmartPhone myPhone = new SmartPhone("Galaxy S21");

        System.out.println(myPhone); 
        myPhone.powerOn(); 
        myPhone.connectToNetwork("Home WiFi"); 
        System.out.println(myPhone); 
        myPhone.disconnectFromNetwork();
        System.out.println(myPhone); 
        myPhone.powerOff(); 
        System.out.println(myPhone);
    }
}

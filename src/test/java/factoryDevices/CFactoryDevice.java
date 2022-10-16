package factoryDevices;

public class CFactoryDevice {

    public static IDevice make(String vStrDeviceType) {
        IDevice device;

        switch (vStrDeviceType.toLowerCase()) {
            case "android":
                device = new CAndroidDevice();
                break;
            case "ios":
                device = new CIosDevice();
                break;
            default:
                device = null;
                System.out.println("ERROR : No Soportado");
                break;
        }

        return device;
    }
}

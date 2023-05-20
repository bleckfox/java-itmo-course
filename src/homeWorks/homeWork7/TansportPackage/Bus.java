package homeWorks.homeWork7.TansportPackage;

import homeWorks.homeWork7.TansportPackage.interfaces.ITransport;

/**
 * Класс автобуса
 */
public class Bus extends Transport implements ITransport {

    /**
     * Признак наличия WiFi
     */
    private boolean WiFi = false;

    public Bus(String registerNumber, String color) {
        super(registerNumber, color);
    }

    public Bus(int damage, String registerNumber, String color){
        super(damage, registerNumber, color);
    }

    /**
     * Метод ремонта для автобуса
     */
    @Override
    public void repair() {
        this.damage = defaultRepair(this.damage);
        if (!hasWiFi()){
            enableWiFi();
        }
    }

    /**
     * Метод получения WiFi
     * @return Состояние подключения WiFi
     */
    public boolean hasWiFi(){
        return WiFi;
    }

    /**
     * Метод включения WiFi
     */
    public void enableWiFi(){
        if (!WiFi){
            WiFi = true;
        }
    }

    /**
     * Метод отключения WiFi
     */
    public void disableWiFi(){
        if (WiFi){
            WiFi = false;
        }
    }
}

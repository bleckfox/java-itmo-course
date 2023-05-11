package homeWork7.TansportPackage.interfaces;

import homeWork7.HelperPackage.Helper;

/**
 * Интерфейс транспорта
 */
public interface ITransport {

    /**
     * Метод ремонта для транспора по умолчанию
     */
    default public int defaultRepair(int damage){
        Helper.checkTansportDamaged(damage);
        return --damage;
    }



}

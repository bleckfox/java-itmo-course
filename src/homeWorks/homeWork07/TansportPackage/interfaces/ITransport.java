package homeWorks.homeWork07.TansportPackage.interfaces;

import homeWorks.homeWork07.HelperPackage.Helper;

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

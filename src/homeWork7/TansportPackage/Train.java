package homeWork7.TansportPackage;

import homeWork7.HelperPackage.Helper;
import homeWork7.TansportPackage.interfaces.ITransport;

/**
 * Класс поезда
 */
public class Train extends Transport implements ITransport {

    /**
     * Количество вагонов в поезде
     */
    private int trainCarriage;

    public Train(String registerNumber, int trainCarriage) {
        super(registerNumber, "Синий");

        Helper.checkTrainCarriage(trainCarriage);
        this.trainCarriage = trainCarriage;
    }

    public Train(int damage, String registerNumber, int trainCarriage){
        super(damage, registerNumber, "Синий");

        Helper.checkTrainCarriage(trainCarriage);
        this.trainCarriage = trainCarriage;
    }

    /**
     * Метод ремонта для поезда
     */
    @Override
    public void repair() {
        this.damage = defaultRepair(this.damage);
        // не совсем понятно, как определяется добавлять вагон или нет
        // из задания -> "может быть добавлен вагон"
        // не до конца ясно условие добавления
        // поэтому использую Random()

        if (Math.random() < 0.5){
            int carriages = (int) (Math.random() * 10);
            addTrainCarriage(carriages);
        }

    }

    /**
     * Метод получения количества вагонов поезда
     * @return Количество вагонов
     */
    public int getTrainCarriage(){
        return this.trainCarriage;
    }

    /**
     * Метод добавления вагонов
     * @param carriage Количество добавляемых вагонов
     */
    public void addTrainCarriage(int carriage){
        Helper.checkTrainCarriage(carriage);
        this.trainCarriage += carriage;
    }

    /**
     * Метод удаления вагонов
     * @param carriage Количество добавляемых вагонов
     */
    public void deleteTrainCarriage(int carriage){
        Helper.checkTrainCarriage(carriage);
        if (carriage >= this.trainCarriage){
            throw new IllegalArgumentException("Вы хотите удалить количество вагонов больше, чем сейчас есть!");
        }
        this.trainCarriage -= carriage;
    }

}

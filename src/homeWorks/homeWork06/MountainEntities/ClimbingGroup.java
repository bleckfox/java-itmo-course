package homeWorks.homeWork06.MountainEntities;

import java.util.ArrayList;

/**
 * Модель группы восхождения на гору
 */
public class ClimbingGroup {
    /**
     * Идет ли набор в группу
     */
    private boolean recruitClimbers = true;

    /**
     * Список альпинистов в группе
     */
    private final ArrayList<Climber> climbers = new ArrayList<>();

    /**
     * Гора для восхождения
     */
    private Mountain mountain;

    public ClimbingGroup(){
        System.out.println("Создана новая группа. Укажите гору, и добавьте альпинистов");
    }

    public ClimbingGroup(boolean recruitClimbers){
        isRecruiting(recruitClimbers);
    }

    public ClimbingGroup(Mountain mountain){
        setMountain(mountain);
    }

    public ClimbingGroup(boolean recruitClimbers, Mountain mountain){
        isRecruiting(recruitClimbers);
        setMountain(mountain);
    }

    /**
     * Указание идет ли набор в группу
     * @param recruiting значение
     */
    public void isRecruiting(boolean recruiting){
        this.recruitClimbers = recruiting;
    }

    /**
     * Добавление альпиниста в группу
     * @param climber Новый альпинист
     */
    public void addClimber(Climber climber){
        if (recruitClimbers){
            this.climbers.add(climber);
            System.out.printf("Альпинист %s добавлен в группу\n",
                    climber.getName());
        }
    }

    /**
     * Получение списока альпинистов
     */
    public void getClimbers(){
        System.out.println("Имя -> \tадрес");
        for (var climber : this.climbers) {
            System.out.printf("%s -> \t%s\n",
                    climber.getName(),
                    climber.getAddress());
        }
        // Просто пустая строка после вывода
        System.out.println();
    }

    /**
     * Получение горы
     * @return Гора
     */
    public Mountain getMountain() { return this.mountain; }

    /**
     * Указание горы для восхождения
     * @param mountain Новая гора
     */
    public void setMountain(Mountain mountain){
        this.mountain = mountain;
    }
}

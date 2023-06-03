package homeWorks.homeWork14.task1;

public enum FruitType {
    APPLE, PEAR, BANANA, APRICOT;

    public String getName(){
        String name = this.name();
        return name.substring(0,1).toUpperCase() + name.substring(1).toLowerCase();
    }
}

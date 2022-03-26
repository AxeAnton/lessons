package ru.itmo.lessons.lesson7.base;

// нельзя создать экземпляр
public interface AttackAble {
    /* public можно не писать */ void attack(BattleUnit enemy);
    // метод с реализацией
    default void someVoid(){
        System.out.println("Метод с реализацией");
    }
}

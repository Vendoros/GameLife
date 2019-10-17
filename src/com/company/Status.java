package com.company;

public enum Status {
    NONE,   //1 этап
    BORN,   //2 этап
    LIFE,   //1 этап
    DEAD;   //2 этап

    //шаг1
    public Status prepare(int around) {
        switch (this) {
            case NONE: //если вокруг клетки есть 3 другие клетки BORN инача NONE
                return (around == 3) ? BORN : NONE;
            case LIFE://если вокруг клетки <=1 или >=4 клетки то DEAD иначе LIFE
                return (around <= 1 || around >= 4) ? DEAD : LIFE;
            default:
                return this;
        }
    }

    //шаг2
    public Status replays() {
        switch (this) {
            case BORN://если клетка BORN то переходит в LIFE
                return LIFE;
            case DEAD://если клетка DEAD то переходит в NONE
                return NONE;
            default:
                return this;
        }
    }
}

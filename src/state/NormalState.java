package state;

import exceptions.StateSelectException;
import models.Goods;

public class NormalState implements State{
    //Изменение состояния с "нормальное" на "нормальное". Выброс ошибки
    @Override
    public void onNormal(Goods goods) throws StateSelectException {
        throw new StateSelectException("Ошибка! Товар уже имеет состояние \"нормальное\"");
    }

    //Изменение состояния с "нормальное" на "слегка испорчен"
    @Override
    public void OnSlightlySpoiled(Goods goods) {
        goods.setStateObj( new SlightlySpoiledState());
        goods.setState("Слегка испорчен");
        goods.setCoefficient(0.95);
        System.out.printf("Состояние товара изменено на %s%n", goods.getState());
    }

    //Изменение состояния с "нормальное" на "половина испортилась". Выброс ошибки
    @Override
    public void OnHalfSpoiled(Goods goods) throws StateSelectException {
        throw new StateSelectException("Ошибка! Состояние товара не может имениться с \"нормальное\" на \"половина испортилась\" (Изменение состояния товара возможно только на одну ступень)");
    }

    //Изменение состояния с "нормальное" на "почти весь пропал. Выброс ошибки
    @Override
    public void OnAlmostGone(Goods goods) throws StateSelectException {
        throw new StateSelectException("Ошибка! Состояние товара не может имениться с \"нормальное\" на \"почти весь пропал\" (Изменение состояния товара возможно только на одну ступень)");
    }

    //Изменение состояния с "нормальное" на "испорчен в хлам". Выброс ошибки
    @Override
    public void OnTotallyRuined(Goods goods) throws StateSelectException {
        throw new StateSelectException("Ошибка! Состояние товара не может имениться с \"нормальное\" на \"испорчен в хлам\" (Изменение состояния товара возможно только на одну ступень)");
    }
}

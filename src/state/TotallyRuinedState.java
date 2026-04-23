package state;

import exceptions.StateSelectException;
import models.Goods;

public class TotallyRuinedState implements State{
    //Изменение состояния с "испорчен в хлам" на "нормальное". Выброс ошибки
    @Override
    public void onNormal(Goods goods) throws StateSelectException {
        throw new StateSelectException("Ошибка! Состояние товара не может измениться с \"испорчен в хлам\" на \"нормальное\"");
    }

    //Изменение состояния с "испорчен в хлам" на "слегка испорчен". Выброс ошибки
    @Override
    public void OnSlightlySpoiled(Goods goods) throws StateSelectException {
        throw new StateSelectException("Ошибка! Состояние товара не может измениться с \"испорчен в хлам\" на \"слегка испорчен\"");
    }

    //Изменение состояния с "испорчен в хлам" на "слегка испорчен". Выброс ошибки
    @Override
    public void OnHalfSpoiled(Goods goods) throws StateSelectException {
        throw new StateSelectException("Ошибка! Состояние товара не может измениться с \"испорчен в хлам\" на \"половина испортилась\"");
    }

    //Изменение состояния с "испорчен в хлам" на "испорчен в хлам". Выброс ошибки
    @Override
    public void OnAlmostGone(Goods goods) throws StateSelectException {
        throw new StateSelectException("Ошибка! Состояние товара не может измениться с \"испорчен в хлам\" на \"почти весь испортился\"");
    }

    //Изменение состояния с "испорчен в хлам" на "испорчен в хлам". Выброс ошибки
    @Override
    public void OnTotallyRuined(Goods goods) throws StateSelectException {
        throw new StateSelectException("Ошибка! Товар уже имеет состояние \"испорчен в хлам\"");
    }
}

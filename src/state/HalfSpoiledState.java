package state;

import exceptions.StateSelectException;
import models.Goods;

public class HalfSpoiledState implements State{
    //Изменение состояния с "половина испортилась" на "нормальное". Выброс ошибки
    @Override
    public void onNormal(Goods goods) throws StateSelectException {
        throw new StateSelectException("Ошибка! Состояние товара не может измениться с \"половина испортилась\" на \"нормальное\"");
    }

    //Изменение состояния с "половина испортилась" на "слегка испорчен". Выброс ошибки
    @Override
    public void OnSlightlySpoiled(Goods goods) throws StateSelectException {
        throw new StateSelectException("Ошибка! Состояние товара не может измениться с \"половина испортилась\" на \"слегка испорчен\"");
    }

    //Изменение состояния с "половина испортилась" на "слегка испорчен". Выброс ошибки
    @Override
    public void OnHalfSpoiled(Goods goods) throws StateSelectException {
        throw new StateSelectException("Ошибка! Товар уже имеет состояние \"половина испортилась\"");
    }

    //Изменение состояния с "половина испортилась" на "почти весь пропал"
    @Override
    public void OnAlmostGone(Goods goods) {
        goods.setStateObj(new AlmostGoneState());
        goods.setState("Половина испортилась");
        goods.setCoefficient(0.25);
        System.out.printf("Состояние товара изменено на %s%n", goods.getState());
    }

    //Изменение состояния с "половина испортилась" на "испорчен в хлам". Выброс ошибки
    @Override
    public void OnTotallyRuined(Goods goods) throws StateSelectException {
        throw new StateSelectException("Ошибка! Состояние товара не может измениться с \"половина испортилась\" на \"испорчен в хлам\"");
    }
}

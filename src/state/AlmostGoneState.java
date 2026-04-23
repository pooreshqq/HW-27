package state;

import exceptions.StateSelectException;
import models.Goods;

public class AlmostGoneState implements State{
    //Изменение состояния с "почти весь пропал" на "нормальное". Выброс ошибки
    @Override
    public void onNormal(Goods goods) throws StateSelectException {
        throw new StateSelectException("Ошибка! Состояние товара не может измениться с \"почти весь пропал\" на \"нормальное\"");
    }

    //Изменение состояния с "почти весь пропал" на "слегка испорчен". Выброс ошибки
    @Override
    public void OnSlightlySpoiled(Goods goods) throws StateSelectException {
        throw new StateSelectException("Ошибка! Состояние товара не может измениться с \"почти весь пропал\" на \"слегка испорчен\"");
    }

    //Изменение состояния с "почти весь пропал" на "слегка испорчен". Выброс ошибки
    @Override
    public void OnHalfSpoiled(Goods goods) throws StateSelectException {
        throw new StateSelectException("Ошибка! Состояние товара не может измениться с \"почти весь пропал\" на \"половина испортилась\"");
    }

    //Изменение состояния с "почти весь пропал" на "почти весь пропал". Выброс ошибки
    @Override
    public void OnAlmostGone(Goods goods) throws StateSelectException {
        throw new StateSelectException("Ошибка! Товар уже имеет состояние \"почти весь пропал\"");
    }

    //Изменение состояния с "почти весь пропал" на "испорчен в хлам"
    @Override
    public void OnTotallyRuined(Goods goods) throws StateSelectException {
        goods.setStateObj(new TotallyRuinedState());
        goods.setState("Испорчен в хлам");
        goods.setCoefficient(0.1);
        System.out.printf("Состояние товара изменено на %s%n", goods.getState());
    }
}

package state;

import exceptions.StateSelectException;
import models.Goods;

public class SlightlySpoiledState implements State{
    //Изменение состояния с "нормальное" на "нормальное". Выброс ошибки
    @Override
    public void onNormal(Goods goods) throws StateSelectException {
        throw new StateSelectException("Ошибка! Состояние товара не может измениться с \"слегка испорчен\" на \"нормальное\"");
    }

    //Изменение состояния с "нормальное" на "слегка испорчен". Выброс ошибки
    @Override
    public void OnSlightlySpoiled(Goods goods) throws StateSelectException {
        throw new StateSelectException("Ошибка! Товар уже имеет состояние \"слегка испорчен\"");
    }

    //Изменение состояния с "нормальное" на "половина испортилась"
    @Override
    public void OnHalfSpoiled(Goods goods) {
        goods.setStateObj(new HalfSpoiledState());
        goods.setState("Половина испортилась");
        goods.setCoefficient(0.55);
        System.out.printf("Состояние товара изменено на %s%n", goods.getState());
    }

    //Изменение состояния с "нормальное" на "почти весь пропал. Выброс ошибки
    @Override
    public void OnAlmostGone(Goods goods) throws StateSelectException{
        throw new StateSelectException("Ошибка! Состояние товара не может измениться с \"слегка испорчен\" на \"почти весь пропал\"");
    }

    //Изменение состояния с "нормальное" на "испорчен в хлам". Выброс ошибки
    @Override
    public void OnTotallyRuined(Goods goods) throws StateSelectException {
        throw new StateSelectException("Ошибка! Состояние товара не может измениться с \"слегка испорчен\" на \"испорчен в хлам\"");
    }
}

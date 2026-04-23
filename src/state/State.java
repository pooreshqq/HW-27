package state;

import exceptions.StateSelectException;
import models.Goods;

public interface State {
    //переключение на состояние "нормальное"
    public void onNormal(Goods goods) throws StateSelectException;

    //переключение на состояние "слегка испорчен"
    public void OnSlightlySpoiled(Goods goods) throws StateSelectException;

    //переключение на состояние "половина испортилась"
    public void OnHalfSpoiled(Goods goods) throws StateSelectException;

    //переключение на состояние "почти весь пропал"
    public void OnAlmostGone(Goods goods) throws StateSelectException;

    //переключение на состояние "испорчен в хлам"
    public void OnTotallyRuined(Goods goods) throws StateSelectException;
}

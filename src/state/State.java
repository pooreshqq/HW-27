package state;

public interface State {
    //переключение на состояние "нормальное"
    public void onNormal();

    //переключение на состояние "слегка испорчен"
    public void OnSlightlySpoiled();

    //переключение на состояние "половина испортилась"
    public void OnHalfSpoiled();

    //переключение на состояние "почти весь пропал"
    public void OnAlmostGone();

    //переключение на состояние "испорчен в хлам"
    public void OnTotallyRuined();
}

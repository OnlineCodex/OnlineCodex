package oc.wh40k.units.im;

import oc.*;

public class IMTarantulaAirDefenceBattery extends Eintrag {
    OptionsUpgradeGruppe o1;
    OptionsZaehlerGruppe o3;
    AnzahlPanel squad;

    public IMTarantulaAirDefenceBattery() {
        name = "Tarantula Air Defence Battery";
        squad = new AnzahlPanel(ID, randAbstand, cnt, "Tarantula Air Defence Battery", 1, 3, getPts("Tarantula Air Defence Battery"));
        add(squad);

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Air defense missiles", getPts("Air defense missiles")));
        add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
    }

    @Override
    public void refreshen() {
        o1.alwaysSelected();
        o1.setPreis(0, squad.getModelle() * getPts("Air defense missiles"));
    }
}

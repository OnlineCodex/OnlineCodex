package oc.wh40k.units.im;

import oc.AnzahlPanel;
import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;

public class IMTarantulaAirDefenceBattery extends Eintrag {
	private final OptionsUpgradeGruppe o1;
	private final AnzahlPanel squad;

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

package oc.wh40k.units.im;

import oc.AnzahlPanel;
import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;

public class IMAggressorSquad extends Eintrag {
	private final OptionsUpgradeGruppe o1;
	private final AnzahlPanel squad;

    public IMAggressorSquad() {
        name = "Aggressor Squad";
        squad = new AnzahlPanel(ID, randAbstand, cnt, "Aggressor", 3, 6, getPts("Aggressor Squad"));
        add(squad);

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Boltstorm gauntlets/Fragstorm", "Auto boltstorm gauntlets & Fragstorm grenade launcher", getPts("Auto boltstorm gauntlets") + getPts("Fragstorm grenade launcher")));
        ogE.addElement(new OptionsGruppeEintrag("Flamestorm gauntlets", getPts("Flamestorm gauntlets")));
        add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

    }

    @Override
    public void refreshen() {
        o1.setPreis(0, squad.getModelle() * (getPts("Auto boltstorm gauntlets") + getPts("Fragstorm grenade launcher")));
        o1.setPreis(1, squad.getModelle() * (getPts("Flamestorm gauntlets")));
        o1.alwaysSelected();

        if (squad.getModelle() < 6)
            power = 6;
        else
            power = 12;
    }
}

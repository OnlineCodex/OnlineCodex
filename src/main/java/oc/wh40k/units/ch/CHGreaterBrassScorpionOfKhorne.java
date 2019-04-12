package oc.wh40k.units.ch;

import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;

public class CHGreaterBrassScorpionOfKhorne extends Eintrag {
	private final OptionsUpgradeGruppe o1;
	private final OptionsUpgradeGruppe o2;
	private final OptionsUpgradeGruppe o3;
	private final OptionsUpgradeGruppe o4;

    public CHGreaterBrassScorpionOfKhorne() {
        name = "Greater Brass Scorpion of Khorne";
        grundkosten = getPts("Greater Brass Scorpion of Khorne");

        ogE.addElement(new OptionsGruppeEintrag("Hellcrusher claws", getPts("Hellcrusher claws")));
        add(o1 = new OptionsUpgradeGruppe(randAbstand, cnt, "", ogE));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Scorpion cannon", getPts("Scorpion cannon")));
        add(o2 = new OptionsUpgradeGruppe(randAbstand, cnt, "", ogE));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Soulshatter bombard", getPts("Soulshatter bombard")));
        add(o3 = new OptionsUpgradeGruppe(randAbstand, cnt, "", ogE));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Twin hellmaw blasters", getPts("Twin hellmaw blasters")));
        add(o4 = new OptionsUpgradeGruppe(randAbstand, cnt, "", ogE));

        complete();
    }

    @Override
    public void refreshen() {
        o1.alwaysSelected();
        o2.alwaysSelected();
        o3.alwaysSelected();
        o4.alwaysSelected();
    }
}

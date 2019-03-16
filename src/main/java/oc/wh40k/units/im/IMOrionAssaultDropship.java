package oc.wh40k.units.im;

import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;

public class IMOrionAssaultDropship extends Eintrag {
	private final OptionsUpgradeGruppe o1, o2, o3;

    public IMOrionAssaultDropship() {
        name = "Orion Assault Dropship";
        grundkosten = getPts("Orion Assault Dropship");
        power = 12;

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("2 Arachnus heavy blaze cannons", 2*getPts("Arachnus heavy blaze cannon")));
        add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
        o1.setSelected(0, true);

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("2 Twin Lastrum bolt cannons", 2*getPts("Twin Lastrum bolt cannon")));
        add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
        o2.setSelected(0, true);

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("2 Spiculus heavy bolt launchers", 2*getPts("Spiculus heavy bolt launcher")));
        add(o3 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
        o3.setSelected(0, true);
        
        complete();
    }

    @Override
    public void refreshen() {
        o1.alwaysSelected();
        o2.alwaysSelected();
        o3.alwaysSelected();
    }
}

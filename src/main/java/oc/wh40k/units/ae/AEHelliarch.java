package oc.wh40k.units.ae;

import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerVater;

public class AEHelliarch extends RuestkammerVater {

    OptionsUpgradeGruppe o1;

    public AEHelliarch() {
    }

    @Override
    public void initButtons(boolean... defaults) {
        ogE.addElement(new OptionsGruppeEintrag("Hellglaive", getPts("Hellglaive")));
        ogE.addElement(new OptionsGruppeEintrag("Splinter pistol & stunclaw", getPts("Splinter pistol") + getPts("Stunclaw")));
        ogE.addElement(new OptionsGruppeEintrag("Splinter pistol & power sword", getPts("Splinter pistol") + getPts("Power sword (Drukhari)")));
        ogE.addElement(new OptionsGruppeEintrag("Splinter pistol & agoniser", getPts("Splinter pistol") + getPts("Agoniser")));
        add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
        o1.setSelected(0, true);

        seperator();

        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Phantasm grenade launcher", getPts("Phantasm grenade launcher")));

        sizeSetzen();
    }

    @Override
    public void refreshen() {
        o1.setLegal(o1.isSelected());
    }

}

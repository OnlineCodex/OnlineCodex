package oc.wh40k.units.ne;

import oc.AnzahlPanel;
import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;

public class NETriarchStalker extends Eintrag {

    OptionsUpgradeGruppe o1;
    AnzahlPanel squad;

    public NETriarchStalker() {
        name = "Triarch Stalker";
        grundkosten = getPts("Triarch Stalker") + getPts("Massive forelimbs");

        add(ico = new oc.Picture("oc/wh40k/images/NEJagdlaeuferdesTriarchats.jpg"));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Heat ray", getPts("Heat ray")));
        ogE.addElement(new OptionsGruppeEintrag("Particle shredder", getPts("Particle shredder")));
        ogE.addElement(new OptionsGruppeEintrag("Twin heavy gauss cannno", getPts("Twin heavy gauss cannon")));
        add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

        complete();
    }

    @Override
    public void refreshen() {
        if (!o1.isSelected()) o1.setSelected(0, true);
        power = 8;
    }

}

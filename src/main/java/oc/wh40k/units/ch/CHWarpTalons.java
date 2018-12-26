package oc.wh40k.units.ch;

import oc.AnzahlPanel;
import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;

public class CHWarpTalons extends Eintrag {

    AnzahlPanel marines;
    OptionsUpgradeGruppe mark;

    public CHWarpTalons() {

        name = "Warp Talons";
        grundkosten = 0;
        add(marines = new AnzahlPanel(ID, randAbstand, cnt, "Warp Talons", 5, 15, getPts("Warp Talons") + getPts("Lightning claw pair")));
        add(ico = new oc.Picture("oc/wh40k/images/Moschaboy.gif"));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Mark of Khorne", 0));
        ogE.addElement(new OptionsGruppeEintrag("Mark of Nurgle", 0));
        ogE.addElement(new OptionsGruppeEintrag("Mark of Tzeentch", 0));
        ogE.addElement(new OptionsGruppeEintrag("Mark of Slaanesh", 0));
        add(mark = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

        complete();

    }


    @Override
    public void refreshen() {

        power = 9 +
                ((marines.getModelle() == 10) ? 9 : 0);
    }
}

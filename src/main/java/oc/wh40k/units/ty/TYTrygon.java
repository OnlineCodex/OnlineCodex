package oc.wh40k.units.ty;

import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;

public class TYTrygon extends Eintrag {

    public TYTrygon() {
        name = "Trygon";
        grundkosten = getPts("Trygon") + getPts("Bio-electric pulse") + getPts("Massive Scything Talons (Trygon)");
        power = 8;

        add(ico = new oc.Picture("oc/wh40k/images/TYTrygon.jpg"));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Toxinspike", getPts("Toxinspike")));
        ogE.addElement(new OptionsGruppeEintrag("Prehensile Pincer", getPts("Prehensile Pincer tail")));
        add(new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));

        seperator();

        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Adrenal glands", getPts("Adrenal glands (Monsters)")));
        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Toxin sacs", getPts("Toxin sacs (Trygon)")));

        complete();
    }

    @Override
    public void refreshen() {
    }

}

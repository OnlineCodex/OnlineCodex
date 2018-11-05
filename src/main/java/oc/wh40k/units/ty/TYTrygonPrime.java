package oc.wh40k.units.ty;

import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;

public class TYTrygonPrime extends Eintrag {

    OptionsUpgradeGruppe o1;
    OptionsEinzelUpgrade oe1;
    OptionsEinzelUpgrade oe2;

    public TYTrygonPrime() {
        name = "Trygon Prime";
        grundkosten = getPts("Trygon Prime") + getPts("Bio-electric pulse with containment spines") + getPts("Massive Scything Talons (two or more pairs)(Tervigon)");
        power = 10;

        add(ico = new oc.Picture("oc/wh40k/images/TYTrygon.jpg"));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Biostatic rattle", getPts("Biostatic rattle")));
        ogE.addElement(new OptionsGruppeEintrag("Prehensile Pincer", getPts("Prehensile Pincer tail")));
        ogE.addElement(new OptionsGruppeEintrag("Toxinspike", getPts("Toxinspike")));
        add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));

        seperator();

        add(oe1 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Adrenal glands", getPts("Adrenal glands (Monsters)")));
        add(oe2 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Toxin sacs", getPts("Toxin sacs (Trygon Prime)")));

        complete();
    }

    @Override
    public void refreshen() {
        o1.alwaysSelected();
    }

}

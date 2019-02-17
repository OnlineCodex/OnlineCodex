package oc.wh40k.units.ty;

import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;

public class TYTrygon extends Eintrag {

    private final OptionsUpgradeGruppe o1;
    private final OptionsEinzelUpgrade oe1;
    private final OptionsEinzelUpgrade oe2;

    public TYTrygon() {
        name = "Trygon";
        grundkosten = getPts("Trygon") + getPts("Bio-electric pulse") + getPts("Massive Scything Talons (Trygon)");
        power = 8;

        add(ico = new oc.Picture("oc/wh40k/images/TYTrygon.jpg"));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Toxinspike", getPts("Toxinspike")));
        ogE.addElement(new OptionsGruppeEintrag("Prehensile Pincer", getPts("Prehensile Pincer tail")));
        add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));

        seperator();

        add(oe1 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Adrenal glands", getPts("Adrenal glands (Monsters)")));
        add(oe2 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Toxin sacs", getPts("Toxin sacs (Trygon)")));

        complete();
    }

    @Override
    public void refreshen() {
    }

}

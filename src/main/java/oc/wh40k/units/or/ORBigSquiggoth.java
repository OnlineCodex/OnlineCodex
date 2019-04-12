package oc.wh40k.units.or;

import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;

public class ORBigSquiggoth extends Eintrag {
	public ORBigSquiggoth() {
        name = "Big Squiggoth";
        grundkosten = 180;

        add(ico = new oc.Picture("oc/wh40k/images/BigSquiggoth.jpg"));


        ogE.addElement(new OptionsGruppeEintrag("Kannon", 20));
        ogE.addElement(new OptionsGruppeEintrag("Lobba", 25));
        ogE.addElement(new OptionsGruppeEintrag("Zzap Gun", 20));
        add(new OptionsUpgradeGruppe(randAbstand, cnt, "", ogE));

        seperator();

        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Snakebite Combat Drugs", 15));

        complete();
    }

    //@OVERRIDE
    @Override
	public void refreshen() {
    }

}

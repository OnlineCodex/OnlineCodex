package oc.wh40k.units.or;

import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerVater;

public class ORTrukkKammer extends RuestkammerVater {

	private OptionsUpgradeGruppe fahrzeugausruestung;

    public ORTrukkKammer() {
        grundkosten = 30;
    }

    public void initButtons(boolean... defaults) {
        add(ico = new oc.Picture("oc/wh40k/images/Pikk-Up.gif"));


        seperator();

        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Bazzukka", 0));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Rote Farbä", 5));
        ogE.addElement(new OptionsGruppeEintrag("Vastärktä Rammä", 5));
        ogE.addElement(new OptionsGruppeEintrag("Stikkbombschleuda", 5));
        ogE.addElement(new OptionsGruppeEintrag("Zusätzlich Panzerung", 10));
        ogE.addElement(new OptionsGruppeEintrag("Grothälfaz", 10));
        ogE.addElement(new OptionsGruppeEintrag("Abrizzbirnä", 10));
        ogE.addElement(new OptionsGruppeEintrag("Entaplankä", 15));
        add(fahrzeugausruestung = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 9));

        sizeSetzen();
    }

    // @OVERRIDE
    public void refreshen() {
    }

}

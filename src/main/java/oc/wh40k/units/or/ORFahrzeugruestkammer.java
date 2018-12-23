package oc.wh40k.units.or;

import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerVater;

public class ORFahrzeugruestkammer extends RuestkammerVater {

    public ORFahrzeugruestkammer() {
        ogE.addElement(new OptionsGruppeEintrag("Rote Farbä", 5));
        ogE.addElement(new OptionsGruppeEintrag("Vastärktä Rammä", 5));
        ogE.addElement(new OptionsGruppeEintrag("Stikkbombschlueda", 5));
        ogE.addElement(new OptionsGruppeEintrag("Zusätzlich Panzerung", 10));
        ogE.addElement(new OptionsGruppeEintrag("Grothälfaz", 10));
        ogE.addElement(new OptionsGruppeEintrag("Abrizzbirnä", 10));
        ogE.addElement(new OptionsGruppeEintrag("Entaplankä", 15));
        add(new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 9));

        sizeSetzen();
    }
}
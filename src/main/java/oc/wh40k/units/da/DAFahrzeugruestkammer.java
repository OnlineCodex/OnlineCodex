package oc.wh40k.units.da;

import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerVater;

public class DAFahrzeugruestkammer extends RuestkammerVater {

    OptionsUpgradeGruppe fahrzeugausruestung;

    public DAFahrzeugruestkammer() {
        grundkosten = 0;
    }

    @Override
    public void initButtons(boolean... defaults) {
        try {
        } catch (Exception e) {
        }

        ogE.addElement(new OptionsGruppeEintrag("Bulldozerschaufel", 5));
        ogE.addElement(new OptionsGruppeEintrag("Sturmbolter", 5));
        ogE.addElement(new OptionsGruppeEintrag("Suchkopfrakete", 5));
        ogE.addElement(new OptionsGruppeEintrag("Zusätzlich Panzerung", 5));
        add(fahrzeugausruestung = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 9));

        sizeSetzen();
    }

    @Override
    public void refreshen() {
    }

}

package oc.wh40k.units.ae;

import oc.Eintrag;

import oc.OptionsGruppeEintrag;

import oc.OptionsUpgradeGruppe;

public class AELelithHesperax extends Eintrag {
    OptionsUpgradeGruppe o1;

    public AELelithHesperax() {
        name = "Lelith Hesperax";
        grundkosten = getPts("Lelith Hesperax");
        power = 7;

        ogE.addElement(new OptionsGruppeEintrag("Penetrating blade", getPts("")));
        ogE.addElement(new OptionsGruppeEintrag("Impaler", getPts("")));
        add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));
        
        seperator();

        addWarlordTraits("Cult of Strife: Blood Dancer", true, "WYCH CULT");

        complete();
    }

    @Override
    public void refreshen() {
        setUnikat(true);
    }
}
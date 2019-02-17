package oc.wh40k.units.ae;

import oc.Eintrag;

import oc.KeyWord;
import oc.OptionsGruppeEintrag;

import oc.OptionsUpgradeGruppe;

import static oc.KeyWord.WYCH_CULT;

public class AELelithHesperax extends Eintrag {
	private final OptionsUpgradeGruppe o1;

    public AELelithHesperax() {
        name = "Lelith Hesperax";
        grundkosten = getPts("Lelith Hesperax");
        power = 7;

        ogE.addElement(new OptionsGruppeEintrag("Penetrating blade", getPts("")));
        ogE.addElement(new OptionsGruppeEintrag("Impaler", getPts("")));
        add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));
        
        seperator();

        addWarlordTraits("Cult of Strife: Blood Dancer", WYCH_CULT);

        complete();
    }

    @Override
    public void refreshen() {
        setUnikat(true);
    }
}
package oc.wh40k.units.ae;

import static oc.KeyWord.WYCH_CULT;

import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;

public class AELelithHesperax extends Eintrag {
	public AELelithHesperax() {
        name = "Lelith Hesperax";
        grundkosten = getPts("Lelith Hesperax");
        power = 7;

        ogE.addElement(new OptionsGruppeEintrag("Penetrating blade", getPts("")));
        ogE.addElement(new OptionsGruppeEintrag("Impaler", getPts("")));
        add(new OptionsUpgradeGruppe(randAbstand, cnt, "", ogE, 1));

        seperator();

        addWarlordTraits("Cult of Strife: Blood Dancer", WYCH_CULT);

        complete();
    }

    @Override
    public void refreshen() {
        setUnique(true);
    }
}
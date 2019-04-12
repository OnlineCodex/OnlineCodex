package oc.wh40k.units.or;

import oc.Eintrag;
import oc.OptionsEinzelZaehler;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.OptionsZaehlerGruppe;

public class ORBigTrakk extends Eintrag {

	public ORBigTrakk() {

        name = "Big Trakk (FW)";
        grundkosten = getPts("Big Trakk") + getPts("Big Shoota") * 2;
        power = 9;

        ogE.addElement(new OptionsGruppeEintrag("Big Shoota", getPts("Big Shoota")));
        ogE.addElement(new OptionsGruppeEintrag("Skorcha", getPts("Skorcha")));
        ogE.addElement(new OptionsGruppeEintrag("Rokkit Launcha", getPts("Rokkit Launcha")));
        add(new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 2));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Kannon", getPts("Kannon")));
        ogE.addElement(new OptionsGruppeEintrag("Lobba", getPts("Lobba")));
        ogE.addElement(new OptionsGruppeEintrag("Zzap gun", getPts("Zzap gun")));
        ogE.addElement(new OptionsGruppeEintrag("Supa-skrocha", getPts("Supa-skrocha")));
        ogE.addElement(new OptionsGruppeEintrag("Big lobba", getPts("Big lobba")));
        ogE.addElement(new OptionsGruppeEintrag("Killkannon", getPts("Killkannon")));
        ogE.addElement(new OptionsGruppeEintrag("Big-zzappa", getPts("Big-zzappa")));
        ogE.addElement(new OptionsGruppeEintrag("Flakka-gunz", getPts("Flakka-gunz")));
        ogE.addElement(new OptionsGruppeEintrag("Supa-kannon", getPts("Supa-kannon")));
        add(new OptionsUpgradeGruppe(randAbstand, cnt, "", ogE));

        seperator();


        add(new OptionsEinzelZaehler(ID, randAbstand, cnt, "", "Grot sponsons", 2, getPts("Grot sponsons")));

        complete();
    }

    // @OVERRIDE
    @Override
	public void refreshen() {
    }

}

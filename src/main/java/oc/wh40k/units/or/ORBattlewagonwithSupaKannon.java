package oc.wh40k.units.or;

import oc.*;

public class ORBattlewagonwithSupaKannon extends Eintrag {

    OptionsEinzelUpgrade Panzakanonä;
    OptionsUpgradeGruppe FK2;
    OptionsZaehlerGruppe KampfpanzaFK;

    public ORBattlewagonwithSupaKannon() {

        name = "Battlewagon with Supa-Kannon";
        grundkosten = getPts("Battlewagon with Supa-Kannon") + getPts("Supa-Kannon");
        power = 13;

        add(ico = new oc.Picture("oc/wh40k/images/Kampfpanza.gif"));

        ogE.addElement(new OptionsGruppeEintrag("Big shoota", getPts("Big shoota")));
        ogE.addElement(new OptionsGruppeEintrag("Rokkit launcha", getPts("Rokkit launcha")));
        add(KampfpanzaFK = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 4));

        seperator();

        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Deff rolla", getPts("Deff rolla")));
        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "'Ard Case", getPts("'Ard Case (FW)")));
        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Grabbin' klaw", getPts("Grabbin' klaw")));
        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Wreckin' ball", getPts("Wreckin' ball")));

        complete();
    }

    //@OVERRIDE
    public void refreshen() {
    }
}

package oc.wh40k.units.sm;

import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;

public class SMRelicSicaranBattleTank extends Eintrag {

    public SMRelicSicaranBattleTank() {
        name = "Relic Sicaran Battle Tank";
        grundkosten = 135;
        //TODO Relic of the armoury

        add(ico = new oc.Picture("oc/wh40k/images/PredatorExecutioner.gif"));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("2 Heavy bolters", "2 Heavy bolter sponsons", 20));
        ogE.addElement(new OptionsGruppeEintrag("2 Lascannons", "2 Lascannon sponsons", 40));
        add(new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

        seperator();

        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Hunter-killer missile", 10));
        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Dozer blade", 5));
        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Armoured Ceramite", 20));
    }

    public void refreshen() {
    }
}

//IA1 2nd Ed

package oc.wh40k.units.cm;

import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;

public class CMChaosKnightErrant extends Eintrag {

    OptionsUpgradeGruppe o1;

    public CMChaosKnightErrant() {
        name = "Chaos Knight Errant";
        grundkosten = 370;


        add(ico = new oc.Picture("oc/wh40k/images/Macharius.gif"));

        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Dirge caster", 5));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Khorne", "Daemon Knight of Khorne", 50));
        ogE.addElement(new OptionsGruppeEintrag("Nurgle", "Daemon Knight of Nurgle", 75));
        ogE.addElement(new OptionsGruppeEintrag("Tzeentch", "Daemon Knight of Tzeentch", 65));
        ogE.addElement(new OptionsGruppeEintrag("Slaanesh", "Daemon Knight of Slaanesh", 50));
        add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));

        complete();
    }

    public void refreshen() {
        getCountFromInformationVector("");
        if (buildaVater.reflectionKennungLokal == "KD") {
            o1.setSelected(0, true);
        }
    }
}


package oc.wh40k.units.ch;

import oc.*;

public class CHChaosLandRaider extends Eintrag {

    RuestkammerStarter ausruestung;
    OptionsUpgradeGruppe fkwaffen;
    OptionsUpgradeGruppe mark;

    public CHChaosLandRaider() {
        name = "Chaos Land Raider";
        grundkosten = getPts("Chaos Land Raider") + getPts("Twin lascannon") * 2 + getPts("twin heavy bolter");

        add(ico = new oc.Picture("oc/wh40k/images/ChaosLandRaider.gif"));

        seperator();

        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Havoc launcher", getPts("Havoc launcher")));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Combi-bolter", getPts("Combi-bolter")));
        ogE.addElement(new OptionsGruppeEintrag("Combi-flamer", getPts("Combi-flamer")));
        ogE.addElement(new OptionsGruppeEintrag("Combi-melta", getPts("Combi-melta")));
        ogE.addElement(new OptionsGruppeEintrag("Combi-plasma", getPts("Combi-plasma")));
        add(fkwaffen = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Mark of Khorne", 0));
        ogE.addElement(new OptionsGruppeEintrag("Mark of Nurgle", 0));
        ogE.addElement(new OptionsGruppeEintrag("Mark of Tzeentch", 0));
        ogE.addElement(new OptionsGruppeEintrag("Mark of Slaanesh", 0));
        add(mark = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

        complete();
    }

    @Override
    public void refreshen() {
        power = 19;
    }

}

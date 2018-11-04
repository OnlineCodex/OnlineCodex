package oc.wh40k.units.ch;

import oc.*;

public class CHChaosRhino extends Eintrag {

    AnzahlPanel marines;
    OptionsUpgradeGruppe fkwaffen;
    OptionsEinzelUpgrade combi;
    OptionsUpgradeGruppe mark;

    public CHChaosRhino() {

        kategorie = 1;

        name = "Chaos Rhino";
        grundkosten = getPts("Chaos Rhino");

        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Havoc launcher", getPts("Havoc launcher")));

        seperator();

        add(combi = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Combi-bolter", getPts("Combi-bolter")));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Combi-bolter", getPts("Combi-bolter")));
        ogE.addElement(new OptionsGruppeEintrag("Combi-flamer", getPts("Combi-flamer")));
        ogE.addElement(new OptionsGruppeEintrag("Combi-melta", getPts("Combi-melta")));
        ogE.addElement(new OptionsGruppeEintrag("Combi-plasma", getPts("Combi-plasma")));
        add(fkwaffen = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));
        fkwaffen.setSelected(0, true);

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
        if (!combi.isSelected()) combi.setSelected(true);
        power = 4;
    }
}

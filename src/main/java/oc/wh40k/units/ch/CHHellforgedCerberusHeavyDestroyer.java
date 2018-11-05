package oc.wh40k.units.ch;

import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;

public class CHHellforgedCerberusHeavyDestroyer extends Eintrag {

    OptionsUpgradeGruppe o1;
    OptionsUpgradeGruppe fkwaffen;
    OptionsUpgradeGruppe mark;

    public CHHellforgedCerberusHeavyDestroyer() {
        name = "Hellforged Cerberus Heavy Destroyer";
        grundkosten = getPts("Hellforged Cerberus Heavy Destroyer");

        add(ico = new oc.Picture("oc/wh40k/images/ChaosPredator.gif"));


        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Malignatas beam cannon", getPts("Malignatas beam cannon")));
        add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
        o1.setSelected(0, true);

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("2 Heavy bolter", getPts("Heavy bolter") * 2));
        ogE.addElement(new OptionsGruppeEintrag("2 Lascannons", getPts("Lascannon") * 2));
        add(new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));


        //seperator();

        //add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Havoc launcher", getPts("Havoc launcher")));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Havoc launcher", getPts("Havoc launcher")));
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
        o1.alwaysSelected();

        power = 14;
    }

}

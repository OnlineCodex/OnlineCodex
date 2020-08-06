package oc.wh40k.units.ch;

import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;

public class CHHellforgedPredator extends Eintrag {

	private final OptionsUpgradeGruppe o1;
	public CHHellforgedPredator() {
        name = "Hellforged Predator";
        grundkosten = getPts("Hellforged Predator");

        add(ico = new oc.Picture("oc/wh40k/images/ChaosPredator.gif"));


        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Plasma destroyer", getPts("Plasma destroyer")));
        ogE.addElement(new OptionsGruppeEintrag("Magna-melta cannon", getPts("Magna-melta cannon")));
        ogE.addElement(new OptionsGruppeEintrag("C-beam cannon", getPts("C-beam cannon")));
        ogE.addElement(new OptionsGruppeEintrag("Infernal flamestorm cannon", getPts("Infernal flamestorm cannon")));
        ogE.addElement(new OptionsGruppeEintrag("Predator autocannon", getPts("Predator autocannon")));
        ogE.addElement(new OptionsGruppeEintrag("Twin lascannon", getPts("Twin lascannon")));
        add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
        o1.setSelected(0, true);

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("2 Heavy bolter", getPts("Heavy bolter (other)") * 2));
        ogE.addElement(new OptionsGruppeEintrag("2 Lascannons", getPts("Lascannon (other)") * 2));
        ogE.addElement(new OptionsGruppeEintrag("2 Heavy flamers", getPts("Heavy flamer (other)") * 2));
        add(new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));


        //seperator();

        //add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Havoc launcher", getPts("Havoc launcher")));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Havoc launcher", getPts("Havoc launcher")));
        ogE.addElement(new OptionsGruppeEintrag("Combi-bolter", getPts("Combi-bolter")));
        ogE.addElement(new OptionsGruppeEintrag("Combi-flamer", getPts("Combi-flamer")));
        ogE.addElement(new OptionsGruppeEintrag("Combi-melta", getPts("Combi-melta")));
        ogE.addElement(new OptionsGruppeEintrag("Combi-plasma", getPts("Combi-plasma")));
        add(new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));


        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Mark of Khorne", 0));
        ogE.addElement(new OptionsGruppeEintrag("Mark of Nurgle", 0));
        ogE.addElement(new OptionsGruppeEintrag("Mark of Tzeentch", 0));
        ogE.addElement(new OptionsGruppeEintrag("Mark of Slaanesh", 0));
        add(new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

        complete();
    }

    @Override
    public void refreshen() {
        if (!o1.isSelected()) o1.setSelected(0, true);

        power = 12;
    }

}

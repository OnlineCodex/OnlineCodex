package oc.wh40k.units.sm;

import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;

public class SMDeimosPredator extends Eintrag {

    OptionsUpgradeGruppe wpn;

    public SMDeimosPredator() {
        name = "Deimos Predator";
        grundkosten = 75;


        add(ico = new oc.Picture("oc/wh40k/images/PredatorExecutioner.gif"));

        ogE.addElement(new OptionsGruppeEintrag("Autocannon", 0));
        ogE.addElement(new OptionsGruppeEintrag("Flamestorm cannon", 15));
        ogE.addElement(new OptionsGruppeEintrag("Plasma Destroyer", 35));//Relic of the armoury
        ogE.addElement(new OptionsGruppeEintrag("Magna Melter cannon", 45));
        ogE.addElement(new OptionsGruppeEintrag("Heavy Conversion Beamer", 65));//Relic of the armoury
        add(wpn = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("2 Heavy flamers", "2 Heavy flamer sponsons", 20));
        ogE.addElement(new OptionsGruppeEintrag("2 Heavy bolters", "2 Heavy bolter sponsons", 20));
        ogE.addElement(new OptionsGruppeEintrag("2 Lascannons", "2 Lascannon sponsons", 40));
        add(new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

        seperator();

        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Hunter-killer missile", 10));
        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Storm bolter", 10));
        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Dozer blade", 5));
        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Extra armour", 10));

    }

    public void refreshen() {
        if (!wpn.isSelected()) {
            wpn.setSelected(0, true);
        }
    }
}

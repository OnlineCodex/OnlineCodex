package oc.wh40k.units.cm;

import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;

public class CMPlagueHulkofNurgle extends Eintrag {

    OptionsUpgradeGruppe o1;
    OptionsEinzelUpgrade o2;
    OptionsEinzelUpgrade o3;

    public CMPlagueHulkofNurgle() {
        name = "Plague Hulk of Nurgle";
        grundkosten = 150;

        add(ico = new oc.Picture("oc/wh40k/images/CMPlagueHulkofNurgle.jpg"));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Iron claw", 0));
        ogE.addElement(new OptionsGruppeEintrag("Warpsword", 25));
        add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
        o1.setSelected(0, true);

        seperator();


        add(o2 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Rancid Vomit Attack", 0));
        add(o3 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Rot Cannon", 0));
//      auch wenns sinnlos ist, bitte nicht entfernen, da sonst die Fehlermeldung nicht richtig angezeigt wird

        complete();
    }

    @Override
    public void refreshen() {
        o2.setSelected(true);
        o3.setSelected(true);
    }

}

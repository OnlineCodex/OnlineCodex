package oc.wh40k.units.im;

import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerVater;

public class IMPrioris extends RuestkammerVater {

    OptionsUpgradeGruppe o1;
    OptionsUpgradeGruppe o2;
    String type = "";

    public IMPrioris() {
        grundkosten = 0;
    }

    @Override
    public void initButtons(boolean... defaults) {

        if (type.equals("Sister Superior")) {
            ogE.addElement(new OptionsGruppeEintrag("Bolt pistol", getPts("Bolt pistol (AMI)")));
            ogE.addElement(new OptionsGruppeEintrag("Plasma pistol", getPts("Plasma pistol (AMI)")));
            ogE.addElement(new OptionsGruppeEintrag("Inferno pistol", getPts("Inferno pistol")));
        } else if (type.equals("Seraphim Superior")) {
            ogE.addElement(new OptionsGruppeEintrag("Bolt pistol", getPts("Bolt pistol (AMI)")));
            ogE.addElement(new OptionsGruppeEintrag("Plasma pistol", getPts("Plasma pistol (AMI)")));
        }
        add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

        seperator();

        if (type.equals("Sister Superior")) {
            ogE.addElement(new OptionsGruppeEintrag("Boltgun", getPts("Boltgun (AMI)")));
            ogE.addElement(new OptionsGruppeEintrag("Combi-flamer", getPts("Combi-flamer (AMI)")));
            ogE.addElement(new OptionsGruppeEintrag("Combi-melta", getPts("Combi-melta (AMI)")));
            ogE.addElement(new OptionsGruppeEintrag("Combi-plasma", getPts("Combi-plasma (AMI)")));
            ogE.addElement(new OptionsGruppeEintrag("Condemnor boltgun", getPts("Condemnor boltgun")));
            ogE.addElement(new OptionsGruppeEintrag("Storm bolter", getPts("Storm bolter (AMI)")));
            ogE.addElement(new OptionsGruppeEintrag("Chainsword", getPts("Chainsword (AMI)")));
            ogE.addElement(new OptionsGruppeEintrag("Eviscerator", getPts("Eviscerator (AMI)")));
            ogE.addElement(new OptionsGruppeEintrag("Power axe", getPts("Power axe (AMI)")));
            ogE.addElement(new OptionsGruppeEintrag("Power maul", getPts("Power maul (AMI)")));
            ogE.addElement(new OptionsGruppeEintrag("Power sword", getPts("Power sword (AMI)")));
        } else if (type.equals("Seraphim Superior")) {
            ogE.addElement(new OptionsGruppeEintrag("Bolt pistol", getPts("Bolt pistol (AMI)")));
            ogE.addElement(new OptionsGruppeEintrag("Chainsword", getPts("Chainsword (AMI)")));
            ogE.addElement(new OptionsGruppeEintrag("Power sword", getPts("Power sword (AMI)")));
        }
        add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

        sizeSetzen();
    }

    @Override
    public void refreshen() {
        o1.alwaysSelected();
        o2.alwaysSelected();
    }

}

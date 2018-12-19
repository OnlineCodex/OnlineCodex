package oc.wh40k.units.im;

import oc.Eintrag;

import oc.OptionsGruppeEintrag;

import oc.OptionsUpgradeGruppe;

public class IMPreacher extends Eintrag {
    OptionsUpgradeGruppe o1, o2;

    public IMPreacher() {
        name = "Ministorum Priest";
        grundkosten = getPts("Ministorum Priest") + getPts("Frag grenades") + getPts("Krak grenades");
        power = 3;

        ogE.addElement(new OptionsGruppeEintrag("Laspistol", getPts("Laspistol (AMI)")));
        ogE.addElement(new OptionsGruppeEintrag("Bolt pistol", getPts("Bolt pistol (AMI)")));
        ogE.addElement(new OptionsGruppeEintrag("Plasma pistol", getPts("Plasma pistol (AMI)")));
        ogE.addElement(new OptionsGruppeEintrag("Inferno pistol", getPts("Inferno pistol (AMI)")));
        add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "option", ogE, 1));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Eviscerator", getPts("Eviscerator (AMI)")));
        ogE.addElement(new OptionsGruppeEintrag("Autogun", getPts("Autogun (AMI)")));
        ogE.addElement(new OptionsGruppeEintrag("Plasma gun", getPts("Plasma gun (AMI)")));
        ogE.addElement(new OptionsGruppeEintrag("Shotgun", getPts("Shotgun (AMI)")));
        ogE.addElement(new OptionsGruppeEintrag("Boltgun", getPts("Boltgun (AMI)")));
        ogE.addElement(new OptionsGruppeEintrag("Combi-flamer", getPts("Combi-flamer (AMI)")));
        ogE.addElement(new OptionsGruppeEintrag("Combi-melta", getPts("Combi-melta (AMI)")));
        ogE.addElement(new OptionsGruppeEintrag("Combi-plasma", getPts("Combi-plasma (AMI)")));
        ogE.addElement(new OptionsGruppeEintrag("Condemnor boltgun", getPts("Condemnor boltgun")));
        ogE.addElement(new OptionsGruppeEintrag("Storm bolter", getPts("Storm bolter (AMI)")));
        ogE.addElement(new OptionsGruppeEintrag("Chainsword", getPts("Chainsword (AMI)")));
        ogE.addElement(new OptionsGruppeEintrag("Power axe", getPts("Power axe (AMI)")));
        ogE.addElement(new OptionsGruppeEintrag("Power maul", getPts("Power maul (AMI)")));
        ogE.addElement(new OptionsGruppeEintrag("Power sword", getPts("Power sword (AMI)")));
        add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "option", ogE, 1));
        
        seperator();

        addWarlordTraits("", true);

        complete();
    }

    @Override
    public void refreshen() {
        o1.alwaysSelected();
    }
}
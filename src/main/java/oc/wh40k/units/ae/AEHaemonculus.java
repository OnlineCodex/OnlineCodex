package oc.wh40k.units.ae;

import oc.Eintrag;

import oc.OptionsEinzelUpgrade;

import oc.OptionsGruppeEintrag;

import oc.OptionsUpgradeGruppe;

public class AEHaemonculus extends Eintrag {
    OptionsEinzelUpgrade oe1;
    OptionsUpgradeGruppe o1, o2;

    public AEHaemonculus() {
        name = "Haemonculus";
        grundkosten = getPts("Haemonculus");
        power = 5;

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Stinger pistol", getPts("Stinger pistol")));
        ogE.addElement(new OptionsGruppeEintrag("Hexrifle", getPts("Hexrifle")));
        ogE.addElement(new OptionsGruppeEintrag("Liquifier gun", getPts("Liquifier gun")));
        ogE.addElement(new OptionsGruppeEintrag("Splinter pistol (Index)", getPts("Splinter pistol")));
        add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Haemonculus tools", getPts("Haemonculus tools")));
        ogE.addElement(new OptionsGruppeEintrag("Agoniser", getPts("Agoniser")));
        ogE.addElement(new OptionsGruppeEintrag("Electrocorrosive whip", getPts("Electrocorrosive whip")));
        ogE.addElement(new OptionsGruppeEintrag("Flesh gauntlet", getPts("Flesh gauntlet")));
        ogE.addElement(new OptionsGruppeEintrag("Mindphase gauntlet", getPts("Mindphase gauntlet")));
        ogE.addElement(new OptionsGruppeEintrag("Scissorhand", getPts("Scissorhand")));
        ogE.addElement(new OptionsGruppeEintrag("Venom blade", getPts("Venom blade")));
        add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));

        seperator();

        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Ichor injector", getPts("Ichor injector")));

        seperator();

        //Punkte für Crucible of malediction fehlen im Index und im FAQ

        add(oe1 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Crucible of malediction", getPts("Crucible of malediction")));

        seperator();
        
        addWarlordTraits("", true, "HAEMUNCULUS COVEN");

        complete();
    }

    @Override
    public void refreshen() {
        o1.alwaysSelected();
    }
}


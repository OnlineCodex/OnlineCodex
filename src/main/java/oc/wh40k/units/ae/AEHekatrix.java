package oc.wh40k.units.ae;

import oc.OptionsEinzelUpgrade;

import oc.OptionsGruppeEintrag;

import oc.OptionsUpgradeGruppe;

import oc.RuestkammerVater;

public class AEHekatrix extends RuestkammerVater {

    public AEHekatrix() {
        ogE.addElement(new OptionsGruppeEintrag("Hekatarii blade", getPts("Hekatarii blade")));
        ogE.addElement(new OptionsGruppeEintrag("Power sword", getPts("Power sword (Drukhari)")));
        ogE.addElement(new OptionsGruppeEintrag("Agoniser", getPts("Agoniser")));
        add(new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Splinter pistol", getPts("Splinter pistol")));
        ogE.addElement(new OptionsGruppeEintrag("Blast pistol", getPts("Blast pistol")));
        add(new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

        seperator();

        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Phantasm grenade launcher", getPts("Phantasm grenade launcher")));

        sizeSetzen();
    }
}
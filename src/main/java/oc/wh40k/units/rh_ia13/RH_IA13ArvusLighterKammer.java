package oc.wh40k.units.rh_ia13;

import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerVater;

public class RH_IA13ArvusLighterKammer extends RuestkammerVater {

    OptionsUpgradeGruppe o4;

    public RH_IA13ArvusLighterKammer() {
    }

    @Override
    public void initButtons(boolean... b) {

        name = "Arvus Lighter";
        grundkosten = 55;

        add(ico = new oc.Picture("oc/wh40k/images/AquilaLander.gif"));

        ogE.addElement(new OptionsGruppeEintrag("TL Multi-laser", "Twin-linked multi-laser", 10));
        ogE.addElement(new OptionsGruppeEintrag("2 Hellstrike missiles", 5));
        ogE.addElement(new OptionsGruppeEintrag("TL Autocannon", "Twin-linked Autocannon", 10));
        ogE.addElement(new OptionsGruppeEintrag("2 TL Heavy stubbers", "2 twin-linked heavy stubbers", 5));
        add(o4 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));


        seperator();

        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Flare/Chaff launcher", 10));
        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Armoured cockpit", 15));
        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Illum flares", 5));
        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Searchlight", 1));

        sizeSetzen();
    }

    public void refreshen() {
    }
}

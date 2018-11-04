package oc.wh40k.units.dk;

import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsZaehlerGruppe;
import oc.RuestkammerVater;

public class DKAvengerKammer extends RuestkammerVater {

    OptionsZaehlerGruppe o1;

    public DKAvengerKammer() {
        name = "Avenger";
        grundkosten = 150;
    }

    public void initButtons(boolean... defaults) {
        add(ico = new oc.Picture("oc/wh40k/images/ABThunderbolt.jpg"));


        ogE.addElement(new OptionsGruppeEintrag("6 Tactical Bombs", 40));
        ogE.addElement(new OptionsGruppeEintrag("2 Hellstrike missiles", 20));
        ogE.addElement(new OptionsGruppeEintrag("2 Hellfury missiles", 20));
        ogE.addElement(new OptionsGruppeEintrag("2 missile launchers", 40));
        ogE.addElement(new OptionsGruppeEintrag("2 autocannons ", 30));
        ogE.addElement(new OptionsGruppeEintrag("2 multi-lasers", 30));
        add(new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 2));

        seperator();

        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Flare/chaff launcher", 10));
        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Infra-red targeting", 5));
        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Illum flares", 5));
        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Distinctive paint", "Distinctive paint scheme/decals", 10));

        sizeSetzen();
    }

    @Override
    public void refreshen() {
    }

}

package oc.wh40k.units.ed;

import oc.OptionsGruppeEintrag;
import oc.OptionsZaehlerGruppe;
import oc.RuestkammerStarter;
import oc.RuestkammerVater;

public class EDSpecialWeaponsSquad extends RuestkammerVater {

    OptionsZaehlerGruppe o1;
    RuestkammerStarter rkTransport;

    public EDSpecialWeaponsSquad() {
        grundkosten = 45;
    }

    public void initButtons(boolean... defaults) {
        add(ico = new oc.Picture("oc/wh40k/images/IGInfantrySquad.jpg"));


        ogE.addElement(new OptionsGruppeEintrag("Sniper Rifle", 5));
        ogE.addElement(new OptionsGruppeEintrag("Flamer", 5));
        ogE.addElement(new OptionsGruppeEintrag("Grenade launcher", 5));
        ogE.addElement(new OptionsGruppeEintrag("Melta gun", 10));
        ogE.addElement(new OptionsGruppeEintrag("Plasma gun", 15));
        ogE.addElement(new OptionsGruppeEintrag("Breacher charge", 20));
        ogE.addElement(new OptionsGruppeEintrag("Lascutter", 10));
        add(o1 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 3));

        seperator();

        rkTransport = new RuestkammerStarter(ID, randAbstand, cnt, "EDValkyrie", "Valkyrie");
        rkTransport.initKammer(true);
        add(rkTransport);

        sizeSetzen();
    }

    // @OVERRIDE
    public void refreshen() {
        o1.setLegal(o1.getAnzahl() == o1.getMaxAnzahl());
    }

    @Override
    public Object getSpecialValue() {
        return o1.isLegal();
    }


}

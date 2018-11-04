package oc.wh40k.units.dk;

import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsZaehlerGruppe;
import oc.RuestkammerVater;

public class DKInfantrySquad extends RuestkammerVater {

    OptionsZaehlerGruppe o1;
    OptionsZaehlerGruppe o2x;
    OptionsZaehlerGruppe o3;
    OptionsEinzelUpgrade oe1;
    OptionsEinzelUpgrade vox;
    OptionsEinzelUpgrade stand;

    public DKInfantrySquad() {
        grundkosten = 70;
    }

    public void initButtons(boolean... defaults) {
        add(ico = new oc.Picture("oc/wh40k/images/IGInfantrySquad.jpg"));

        add(vox = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Vox-caster", 5));
        add(stand = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Platoon Standard", 10));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Lasgun", "Guardsman with Lasgun", 0));
        add(o2x = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 1));
        ogE.addElement(new OptionsGruppeEintrag("Flamer", "Guardsman with Flamer", 5));
        ogE.addElement(new OptionsGruppeEintrag("Grenade launcher", "Guardsman with Grenade launcher", 5));
        ogE.addElement(new OptionsGruppeEintrag("Melta gun", "Guardsman with Melta gun", 10));
        ogE.addElement(new OptionsGruppeEintrag("Plasma gun", "Guardsman with Plasma gun", 15));
        add(o1 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 1));

        seperator();

        add(oe1 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Watchmaster", 0));

        seperator(5);

        ogE.addElement(new OptionsGruppeEintrag("Lasgun", 0));
        ogE.addElement(new OptionsGruppeEintrag("Bolt pistol", 2));
        ogE.addElement(new OptionsGruppeEintrag("Plasma pistol", 10));
        ogE.addElement(new OptionsGruppeEintrag("Power sword", 10));
        add(o3 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "option", ogE, 2));

        seperator(5);

        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Melta-bombs", 5));

        sizeSetzen();
    }

    // @OVERRIDE
    public void refreshen() {
        oe1.setSelected(true);

        o2x.setMaxAnzahl(9 - o1.getAnzahl());
        o2x.setAnzahl(0, 9 - o1.getAnzahl());
    }

}

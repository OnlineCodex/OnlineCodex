package oc.wh40k.units.ed;

import oc.*;

public class EDVeteranSquad extends Eintrag {

    OptionsEinzelUpgrade o1;
    OptionsZaehlerGruppe o2;
    OptionsZaehlerGruppe o3;
    OptionsZaehlerGruppe o3plus;
    OptionsZaehlerGruppe o4;
    OptionsZaehlerGruppe o4x;
    OptionsZaehlerGruppe o5;
    OptionsEinzelZaehler oe1;
    OptionsEinzelZaehler oe2;
    RuestkammerStarter rkTransport;

    public EDVeteranSquad() {
        name = "Elysian Veteran Squad";
        grundkosten = 80;

        add(ico = new oc.Picture("oc/wh40k/images/IGVeteranSquad.jpg"));

        seperator();

        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Grenadiers", 30));
        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Forward Observers", 30));
        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Demolitions", 30));

        seperator();

        add(oe1 = new OptionsEinzelZaehler(0, randAbstand, cnt, "", "Vox-caster", 1, 5));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Mortar-team", "Veteran Weapons Team with Mortar", 5));
        ogE.addElement(new OptionsGruppeEintrag("Heavy bolter-team", "Veteran Weapons Team with Heavy bolter", 10));
        ogE.addElement(new OptionsGruppeEintrag("Missile launcher-team", "Veteran Weapons Team with Missile launcher", 15));
        add(o3 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 1));
        ogE.addElement(new OptionsGruppeEintrag("Flakk missiles", 15));
        add(o3plus = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 1));

        seperator();
        ogE.addElement(new OptionsGruppeEintrag("Lasgun", "Veteran with Lasgun", 0));
        add(o4x = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 9));
        ogE.addElement(new OptionsGruppeEintrag("Shotgun", "Veteran with Shotgun", 0));
        add(o4 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 9));
        ogE.addElement(new OptionsGruppeEintrag("Flamer", "Veteran with Flamer", 5));
        ogE.addElement(new OptionsGruppeEintrag("Grenade launcher", "Veteran with Grenade launcher", 5));
        ogE.addElement(new OptionsGruppeEintrag("Sniper Rifle", "Veteran with Sniper Rifle", 5));
        ogE.addElement(new OptionsGruppeEintrag("Melta gun", "Veteran with Melta gun", 10));
        ogE.addElement(new OptionsGruppeEintrag("Plasma gun", "Veteran with Plasma gun", 15));
        ogE.addElement(new OptionsGruppeEintrag("Lascutter", 1, 10));
        add(o5 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 3));
        add(oe2 = new OptionsEinzelZaehler(0, randAbstand, cnt, "", "Heavy Flamer", "Veteran with Heavy Flamer", 1, 20));

        seperator();

        add(o1 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Veteran Sergeant", 0));

        seperator(5);

        ogE.addElement(new OptionsGruppeEintrag("Shotgun", 0));
        ogE.addElement(new OptionsGruppeEintrag("Bolt pistol", 2));
        ogE.addElement(new OptionsGruppeEintrag("Power sword", 10));
        ogE.addElement(new OptionsGruppeEintrag("Plasma pistol", 10));
        ogE.addElement(new OptionsGruppeEintrag("Power fist", 15));
        add(o2 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "option", ogE, 2));

        seperator();

        rkTransport = new RuestkammerStarter(ID, randAbstand, cnt, "EDValkyrie", "Valkyrie");
        rkTransport.initKammer(true);
        add(rkTransport);

        complete();
    }

    @Override
    public void refreshen() {
        o1.setSelected(true);

        o4x.setMaxAnzahl(9 - o4.getAnzahl() - o5.getAnzahl() - oe2.getAnzahl() - o3.getAnzahl() * 2);
        o4x.setAnzahl(0, o4x.getMaxAnzahl());

        o4.setMaxAnzahl(9 - o5.getAnzahl() - oe2.getAnzahl() - o3.getAnzahl() * 2);
        o3.setMaxAnzahl((9 - o5.getAnzahl() - oe2.getAnzahl() - o4.getAnzahl() - (oe1.isSelected() ? 1 : 0)) > 1 ? 1 : 0);
        o5.setMaxAnzahl((9 - o3.getAnzahl() * 2 - oe2.getAnzahl() - o4.getAnzahl() - (oe1.isSelected() ? 1 : 0)) > 3 ? 3 : (9 - o3.getAnzahl() * 2 - oe2.getAnzahl() - o4.getAnzahl() - (oe1.isSelected() ? 1 : 0) - (oe2.isSelected() ? 1 : 0)));

        o3plus.setAktiv(o3.isSelected("Veteran Weapons Team with Missile launcher"));
    }

}

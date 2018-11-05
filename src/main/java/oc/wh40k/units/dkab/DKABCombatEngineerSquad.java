package oc.wh40k.units.dkab;

import oc.*;

public class DKABCombatEngineerSquad extends Eintrag {

    OptionsEinzelUpgrade o1;
    OptionsEinzelUpgrade o2;
    RuestkammerStarter rkTransport;
    RuestkammerStarter rkTransport2;
    AnzahlPanel squad;

    public DKABCombatEngineerSquad() {
        name = "Death Corps Combat Engineer Squad";
        grundkosten = 10;
        überschriftSetzen = true;

        add(ico = new oc.Picture("oc/wh40k/images/IGVeteranSquad.jpg"));

        seperator();

        add(squad = new AnzahlPanel(ID, randAbstand, cnt, "Engineers", 5, 10, 8));
        squad.setNichtDieErsteOption(true);

        seperator();

        add(new OptionsEinzelZaehler(0, randAbstand, cnt, "", "Vox-caster", 1, 5));
        add(new OptionsEinzelUpgrade(0, randAbstand, cnt, "", "Carcass shells", 10));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Flamer", "Engineer with Flamer", 5));
        ogE.addElement(new OptionsGruppeEintrag("Grenade launcher", "Engineer with Grenade launcher", 5));
        ogE.addElement(new OptionsGruppeEintrag("Melta gun", "Engineer with Melta gun", 10));
        ogE.addElement(new OptionsGruppeEintrag("Plasma gun", "Engineer with Plasma gun", 15));
        ogE.addElement(new OptionsGruppeEintrag("Demolition charge", "Engineer with Demolition charge", 20));
        add(new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 1));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Heavy flamer-team", "Engineer Heavy Weapons Team with Heavy flamer", 10));
        ogE.addElement(new OptionsGruppeEintrag("Mole launcher-team", "Engineer Heavy Weapons Team with Mole-launcher", 15));
        add(new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 1));

        seperator();

        add(o1 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Upgrade to Watchmaster", 0));

        seperator(5);

        ogE.addElement(new OptionsGruppeEintrag("Bolt pistol", 2));
        ogE.addElement(new OptionsGruppeEintrag("Power sword", 10));
        ogE.addElement(new OptionsGruppeEintrag("Plasma pistol", 10));
        ogE.addElement(new OptionsGruppeEintrag("Power fist", 15));
        add(new OptionsZaehlerGruppe(ID, randAbstand, cnt, "option", ogE, 2));

        seperator(5);

        add(new OptionsEinzelUpgrade(0, randAbstand, cnt, "", "Melta bombs", 5));

        seperator();

        add(o2 = new OptionsEinzelUpgrade(0, randAbstand, cnt, "", "Hades Breaching Drill", 60));

        seperator();

        rkTransport = new RuestkammerStarter(ID, randAbstand, cnt, "DKABStormChimera", "Storm Chimera");
        rkTransport.initKammer();
        add(rkTransport);

        seperator();

        rkTransport2 = new RuestkammerStarter(ID, randAbstand, cnt, "DKABCentaur", "Centaur");
        rkTransport2.initKammer();
        add(rkTransport2);

        complete();
    }

    @Override
    public void refreshen() {
        o1.setSelected(true);


        rkTransport2.setAktiv(squad.getModelle() == 5 && !rkTransport.isSelected() && !o2.isSelected());
        o2.setAktiv(!rkTransport2.isSelected() && !rkTransport.isSelected());
        rkTransport.setAktiv(!rkTransport2.isSelected() && !o2.isSelected());


    }

}

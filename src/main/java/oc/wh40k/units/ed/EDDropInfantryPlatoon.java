package oc.wh40k.units.ed;

import oc.Eintrag;
import oc.RuestkammerStarter;

public class EDDropInfantryPlatoon extends Eintrag {

    RuestkammerStarter commandSquad;
    RuestkammerStarter infantrySquad1;
    RuestkammerStarter infantrySquad2;
    RuestkammerStarter infantrySquad3;
    RuestkammerStarter infantrySquad4;
    RuestkammerStarter infantrySquad5;
    RuestkammerStarter heavyWeaponsSquad1;
    RuestkammerStarter heavyWeaponsSquad2;
    RuestkammerStarter heavyWeaponsSquad3;
    RuestkammerStarter heavyWeaponsSquad4;
    RuestkammerStarter specialWeaponsSquad1;
    RuestkammerStarter specialWeaponsSquad2;
    RuestkammerStarter specialWeaponsSquad3;
    RuestkammerStarter sentinelSquad;

    public EDDropInfantryPlatoon() {
        name = "Elysian Drop Infantry Platoon";
        grundkosten = 0;
        überschriftSetzen = true;


        add(ico = new oc.Picture("oc/wh40k/images/IGInfantryPlatoon.jpg"));


        seperator();

        commandSquad = new RuestkammerStarter(ID, randAbstand, cnt, "EDPlatoonCommandSquad", "Elysian Platoon Command Squad", 1);
        commandSquad.initKammer();
        add(commandSquad);

        seperator();

        infantrySquad1 = new RuestkammerStarter(ID, randAbstand, cnt, "EDInfantrySquad", "Elysian Infantry Squad", 1);
        infantrySquad1.initKammer();
        add(infantrySquad1);

        seperator();

        infantrySquad2 = new RuestkammerStarter(ID, randAbstand, cnt, "EDInfantrySquad", "Elysian Infantry Squad", 1);
        infantrySquad2.initKammer();
        add(infantrySquad2);

        seperator();

        infantrySquad3 = new RuestkammerStarter(ID, randAbstand, cnt, "EDInfantrySquad", "Elysian Infantry Squad", 1);
        infantrySquad3.initKammer();
        add(infantrySquad3);

        seperator();

        infantrySquad4 = new RuestkammerStarter(ID, randAbstand, cnt, "EDInfantrySquad", "Elysian Infantry Squad", 1);
        infantrySquad4.initKammer();
        add(infantrySquad4);

        seperator();

        infantrySquad5 = new RuestkammerStarter(ID, randAbstand, cnt, "EDInfantrySquad", "Elysian Infantry Squad", 1);
        infantrySquad5.initKammer();
        add(infantrySquad5);

        seperator();

        heavyWeaponsSquad1 = new RuestkammerStarter(ID, randAbstand, cnt, "EDHeavyWeaponsSquad", "Heavy Weapons Squad", 1);
        heavyWeaponsSquad1.initKammer();
        add(heavyWeaponsSquad1);

        seperator();

        heavyWeaponsSquad2 = new RuestkammerStarter(ID, randAbstand, cnt, "EDHeavyWeaponsSquad", "Heavy Weapons Squad", 1);
        heavyWeaponsSquad2.initKammer();
        add(heavyWeaponsSquad2);

        seperator();

        heavyWeaponsSquad3 = new RuestkammerStarter(ID, randAbstand, cnt, "EDHeavyWeaponsSquad", "Heavy Weapons Squad", 1);
        heavyWeaponsSquad3.initKammer();
        add(heavyWeaponsSquad3);

        seperator();

        heavyWeaponsSquad4 = new RuestkammerStarter(ID, randAbstand, cnt, "EDHeavyWeaponsSquad", "Heavy Weapons Squad", 1);
        heavyWeaponsSquad4.initKammer();
        add(heavyWeaponsSquad4);

        seperator();

        specialWeaponsSquad1 = new RuestkammerStarter(ID, randAbstand, cnt, "EDSpecialWeaponsSquad", "Elysian Special Weapons Squad", 1);
        specialWeaponsSquad1.initKammer();
        add(specialWeaponsSquad1);

        seperator();

        specialWeaponsSquad2 = new RuestkammerStarter(ID, randAbstand, cnt, "EDSpecialWeaponsSquad", "Elysian Special Weapons Squad", 1);
        specialWeaponsSquad2.initKammer();
        add(specialWeaponsSquad2);

        seperator();

        specialWeaponsSquad3 = new RuestkammerStarter(ID, randAbstand, cnt, "EDSpecialWeaponsSquad", "Elysian Special Weapons Squad", 1);
        specialWeaponsSquad3.initKammer();
        add(specialWeaponsSquad3);

        seperator();

        sentinelSquad = new RuestkammerStarter(ID, randAbstand, cnt, "EDDropSentinelSquadronKammer", "Elysian Drop Sentinel Squadron", 1);
        sentinelSquad.initKammer();
        add(sentinelSquad);

        complete();
    }

    @Override
    public void refreshen() {

        commandSquad.setAbwaehlbar(false);

        infantrySquad1.setAbwaehlbar(false);
        infantrySquad2.setAbwaehlbar(false);
        infantrySquad3.setAktiv(infantrySquad2.isSelected());
        infantrySquad4.setAktiv(infantrySquad3.isSelected());
        infantrySquad5.setAktiv(infantrySquad4.isSelected());

        heavyWeaponsSquad2.setAktiv(heavyWeaponsSquad1.isSelected());
        heavyWeaponsSquad3.setAktiv(heavyWeaponsSquad2.isSelected());
        heavyWeaponsSquad4.setAktiv(heavyWeaponsSquad3.isSelected());

        specialWeaponsSquad2.setAktiv(specialWeaponsSquad1.isSelected());


        infantrySquad1.getPanel().setLocation((int) infantrySquad1.getPanel().getLocation().getX(), (int) commandSquad.getPanel().getLocation().getY() + commandSquad.getPanel().getSize().height + 10);
        infantrySquad2.getPanel().setLocation((int) infantrySquad2.getPanel().getLocation().getX(), (int) infantrySquad1.getPanel().getLocation().getY() + infantrySquad1.getPanel().getSize().height + 10);
        infantrySquad3.getPanel().setLocation((int) infantrySquad3.getPanel().getLocation().getX(), (int) infantrySquad2.getPanel().getLocation().getY() + infantrySquad2.getPanel().getSize().height + 10);
        infantrySquad4.getPanel().setLocation((int) infantrySquad4.getPanel().getLocation().getX(), (int) infantrySquad3.getPanel().getLocation().getY() + infantrySquad3.getPanel().getSize().height + 10);
        infantrySquad5.getPanel().setLocation((int) infantrySquad5.getPanel().getLocation().getX(), (int) infantrySquad4.getPanel().getLocation().getY() + infantrySquad4.getPanel().getSize().height + 10);

        heavyWeaponsSquad1.getPanel().setLocation((int) heavyWeaponsSquad1.getPanel().getLocation().getX(), (int) infantrySquad5.getPanel().getLocation().getY() + infantrySquad5.getPanel().getSize().height + 10);
        heavyWeaponsSquad2.getPanel().setLocation((int) heavyWeaponsSquad2.getPanel().getLocation().getX(), (int) heavyWeaponsSquad1.getPanel().getLocation().getY() + heavyWeaponsSquad1.getPanel().getSize().height + 10);
        heavyWeaponsSquad3.getPanel().setLocation((int) heavyWeaponsSquad3.getPanel().getLocation().getX(), (int) heavyWeaponsSquad2.getPanel().getLocation().getY() + heavyWeaponsSquad2.getPanel().getSize().height + 10);
        heavyWeaponsSquad4.getPanel().setLocation((int) heavyWeaponsSquad4.getPanel().getLocation().getX(), (int) heavyWeaponsSquad3.getPanel().getLocation().getY() + heavyWeaponsSquad3.getPanel().getSize().height + 10);

        specialWeaponsSquad1.getPanel().setLocation((int) specialWeaponsSquad1.getPanel().getLocation().getX(), (int) heavyWeaponsSquad4.getPanel().getLocation().getY() + heavyWeaponsSquad4.getPanel().getSize().height + 10);
        specialWeaponsSquad2.getPanel().setLocation((int) specialWeaponsSquad2.getPanel().getLocation().getX(), (int) specialWeaponsSquad1.getPanel().getLocation().getY() + specialWeaponsSquad1.getPanel().getSize().height + 10);
        specialWeaponsSquad3.getPanel().setLocation((int) specialWeaponsSquad3.getPanel().getLocation().getX(), (int) specialWeaponsSquad2.getPanel().getLocation().getY() + specialWeaponsSquad2.getPanel().getSize().height + 10);

        sentinelSquad.getPanel().setLocation((int) sentinelSquad.getPanel().getLocation().getX(), (int) specialWeaponsSquad3.getPanel().getLocation().getY() + specialWeaponsSquad3.getPanel().getSize().height + 10);


        specialWeaponsSquad1.setLegal((Boolean) specialWeaponsSquad1.getKammer().getSpecialValue() || !specialWeaponsSquad1.isSelected());
        specialWeaponsSquad2.setLegal((Boolean) specialWeaponsSquad2.getKammer().getSpecialValue() || !specialWeaponsSquad2.isSelected());
        specialWeaponsSquad3.setLegal((Boolean) specialWeaponsSquad3.getKammer().getSpecialValue() || !specialWeaponsSquad3.isSelected());
    }
}

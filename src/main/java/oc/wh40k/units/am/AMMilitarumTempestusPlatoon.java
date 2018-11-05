package oc.wh40k.units.am;

import oc.Eintrag;
import oc.RuestkammerStarter;

public class AMMilitarumTempestusPlatoon extends Eintrag {

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
    RuestkammerStarter heavyWeaponsSquad5;

    RuestkammerStarter sabreSquad1;
    RuestkammerStarter sabreSquad2;
    RuestkammerStarter sabreSquad3;
    RuestkammerStarter sabreSquad4;
    RuestkammerStarter sabreSquad5;

    RuestkammerStarter specialWeaponsSquad1;
    RuestkammerStarter specialWeaponsSquad2;
    RuestkammerStarter conscriptsSquad;

    public AMMilitarumTempestusPlatoon() {
        name = "Militarum Tempestus Platoon";
        grundkosten = 0;
        überschriftSetzen = true;

        checkDraftOption();

        add(ico = new oc.Picture("oc/wh40k/images/AMInfantryPlatoon.jpg"));

        seperator();

        commandSquad = new RuestkammerStarter(ID, randAbstand, cnt, "AMMilitarumTempestusCommandSquad", "", 1);
        commandSquad.initKammer();
//		commandSquad.setGrundkosten(85);
        commandSquad.setButtonText("Command Squad\n");
        commandSquad.setName("Command Squad\n");
        commandSquad.setUeberschriftTrotzNullKostenAusgeben(true);
        add(commandSquad);

        seperator();

        infantrySquad1 = new RuestkammerStarter(ID, randAbstand, cnt, "AMMilitarumTempestusScions", "", 1);
        infantrySquad1.initKammer();
        //infantrySquad1.setGrundkosten(70);
        infantrySquad1.setButtonText("Tempestus Scions\n");
        infantrySquad1.setName("Tempestus Scions\n");
        infantrySquad1.setUeberschriftTrotzNullKostenAusgeben(true);
        add(infantrySquad1);

        seperator();

        infantrySquad2 = new RuestkammerStarter(ID, randAbstand, cnt, "AMMilitarumTempestusScions", "", 1);
        infantrySquad2.initKammer();
        //infantrySquad2.setGrundkosten(70);
        infantrySquad2.setButtonText("Tempestus Scions\n");
        infantrySquad2.setName("Tempestus Scions\n");
        infantrySquad2.setUeberschriftTrotzNullKostenAusgeben(true);
        add(infantrySquad2);

        seperator();

        infantrySquad3 = new RuestkammerStarter(ID, randAbstand, cnt, "AMMilitarumTempestusScions", "", 1);
        infantrySquad3.initKammer();
        //infantrySquad3.setGrundkosten(70);
        infantrySquad3.setButtonText("Tempestus Scions\n");
        infantrySquad3.setName("Tempestus Scions\n");
        infantrySquad3.setUeberschriftTrotzNullKostenAusgeben(true);
        add(infantrySquad3);

        seperator();
    }

    @Override
    public void refreshen() {
        infantrySquad1.setLegal(infantrySquad1.isSelected() || infantrySquad2.isSelected() || infantrySquad3.isSelected());
        infantrySquad2.setLegal(infantrySquad1.isSelected() || infantrySquad2.isSelected() || infantrySquad3.isSelected());
        infantrySquad3.setLegal(infantrySquad1.isSelected() || infantrySquad2.isSelected() || infantrySquad3.isSelected());
    }

    private void checkDraftOption() {
    }

    @Override
    public void deleteYourself() {
        super.deleteYourself();
    }

}

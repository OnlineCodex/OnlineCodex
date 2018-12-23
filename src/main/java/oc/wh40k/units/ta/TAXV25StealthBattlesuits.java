package oc.wh40k.units.ta;

import oc.*;

public class TAXV25StealthBattlesuits extends Eintrag {

    AnzahlPanel squad;
    OptionsZaehlerGruppe o1;
    OptionsEinzelZaehler o2;
    RuestkammerStarter ob2;
    RuestkammerStarter[] geister = new RuestkammerStarter[6];

    public TAXV25StealthBattlesuits() {
        name = "XV25 Stealth Battlesuits";
        überschriftSetzen = true;
        grundkosten = 0;

        addToInformationVector("TA2006GeistKampfanzugteam", 1);

        seperator();

        add(ico = new oc.Picture("oc/wh40k/images/GeistKampfanzugteam.gif"));

        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Homin beacon", getPts("Homing beacon")));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("MV1 Gun Drone", getPts("MV1 Gun Drone")));
        ogE.addElement(new OptionsGruppeEintrag("MV4 Shield Drone", getPts("MV4 Shield Drone")));
        ogE.addElement(new OptionsGruppeEintrag("MV7 Marker Drone", getPts("MV7 Marker Drone")));
        add(o1 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 2));

        seperator();

        ob2 = new RuestkammerStarter(ID, randAbstand, cnt, TAShasvreKammer.class, "Stealth Shas'vre");
        ob2.initKammer(true, true);
        ob2.setGrundkosten(getPts("XV25 Stealth Battlesuit"));
        ob2.setUeberschriftTrotzNullKostenAusgeben(true);
        add(ob2);

        for (int i = 0; i < geister.length; ++i) {
            geister[i] = new RuestkammerStarter(ID, randAbstand, cnt, new TAKampfanzugKammer(false, false, true, false), "Stealth Shas'ui");
            geister[i].setGrundkosten(getPts("XV25 Stealth Battlesuit"));
            add(geister[i]);

            geister[i].setSeperator(0);
        }

        seperator();

        complete();
    }

    @Override
    public void refreshen() {
        int Select = 0;
        int blaster = 0;
        blaster += ((TAShasvreKammer) ob2.getKammer()).o1.isSelected("Fusion blaster") ? 1 : 0;
        for (int k = 0; k < geister.length; ++k) {
            Select += (geister[k].isSelected() ? 1 : 0);
            blaster += ((TAKampfanzugKammer) geister[k].getKammer()).o5.isSelected("Fusion blaster") ? 1 : 0;
        }
        Select += (ob2.isSelected() ? 1 : 0);

        geister[5].setAktiv(!ob2.isSelected());

        if (Select < 3) {
            setFehlermeldung("Min. 3 Modelle");
        } else if (blaster > (Select / 3)) {
            setFehlermeldung("Max. " + (Select / 3) + " Fusion blaster");
        } else {
            setFehlermeldung("");
        }

        power = 6;
        if (Select > 3) {
            power += 6;
        }
        if (o1.isSelected()) {
            power++;
        }

    }
}

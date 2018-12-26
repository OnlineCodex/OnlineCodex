package oc.wh40k.units.ch;

import oc.*;

public class CHNoiseMarines extends Eintrag {

    AnzahlPanel marines;
    OptionsZaehlerGruppe bolter;

    OptionsZaehlerGruppe marinesfk;
    OptionsZaehlerGruppe pp;
    RuestkammerStarter Boss;

    public CHNoiseMarines() {

        name = "Noise Marines";
        grundkosten = 0;
        add(marines = new AnzahlPanel(ID, randAbstand, cnt, "Noise Marines", 5, 20, getPts("Noise Marines")));
        add(ico = new oc.Picture("oc/wh40k/images/Moschaboy.gif"));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Boltgun", getPts("Boltgun")));
        ogE.addElement(new OptionsGruppeEintrag("Chainsword", getPts("Chainsword")));
        ogE.addElement(new OptionsGruppeEintrag("Sonic blaster", getPts("Sonic blaster")));
        add(bolter = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, -88));
        bolter.setAnzahl(0, marines.getModelle() - 1);


        ogE.addElement(new OptionsGruppeEintrag("Blastmaster", getPts("Blastmaster")));
        add(marinesfk = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 1));

        seperator();

        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Icon of Excess", getPts("Icon of Excess")));

        seperator();

        Boss = new RuestkammerStarter(ID, randAbstand, cnt, CHWaffenkammer.class, "Noise Champion");
        ((CHWaffenkammer) Boss.getKammer()).setChampion(true);
        ((CHWaffenkammer) Boss.getKammer()).setDefaultRanged("Boltgun");
        ((CHWaffenkammer) Boss.getKammer()).setDefaultCloceCombat("Bolt pistol");
        ((CHWaffenkammer) Boss.getKammer()).setNoiseMarine(true);
        Boss.initKammer(true, true, true, true);
        Boss.setGrundkosten(getPts("Noise Champion"));
        Boss.setUeberschriftTrotzNullKostenAusgeben(true);
        add(Boss);
        Boss.setAbwaehlbar(false);

        complete();
    }


    @Override
    public void refreshen() {
        bolter.setMaxAnzahl(marines.getModelle() - 1 - marinesfk.getAnzahl());

        if (marines.getModelle() > 5)
            marinesfk.setMaxAnzahl(2);
        else
            marinesfk.setMaxAnzahl(1);

        power = 7 +
                ((marines.getModelle() == 10) ? 5 : 0) +
                ((marines.getModelle() == 15) ? 9 : 0) +
                ((marines.getModelle() == 20) ? 14 : 0);
    }
}

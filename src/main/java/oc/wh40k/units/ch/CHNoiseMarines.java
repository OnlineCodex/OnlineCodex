package oc.wh40k.units.ch;

import oc.*;

import static oc.wh40k.units.ch.CHWaffenkammer.ChaosWeaponsOption.CHAMPION;

public class CHNoiseMarines extends Eintrag {

    private final AnzahlPanel marines;
    private final OptionsZaehlerGruppe bolter;
    private final OptionsZaehlerGruppe marinesfk;

    public CHNoiseMarines() {
        name = "Noise Marines";
        grundkosten = 0;

        kategorie = 1;

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

        RuestkammerStarter boss = new RuestkammerStarter(ID, randAbstand, cnt, new CHWaffenkammer("Noise Champion", "Boltgun", "Bolt pistol", true, true, true, true, CHAMPION), "Noise Champion");
        boss.setGrundkosten(getPts("Noise Champion"));
        boss.setUeberschriftTrotzNullKostenAusgeben(true);
        boss.setAbwaehlbar(false);
        add(boss);

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
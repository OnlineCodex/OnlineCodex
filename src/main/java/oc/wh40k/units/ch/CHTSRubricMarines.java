package oc.wh40k.units.ch;

import oc.*;
import oc.wh40k.units.PsychicPowers;

import static oc.wh40k.units.PsychicPowers.PsychicPowerGroup.CHANGE;
import static oc.wh40k.units.ch.CHWaffenkammer.ChaosWeaponsOption.CHAMPION;
import static oc.wh40k.units.ch.CHWaffenkammer.ChaosWeaponsOption.SORCERER;

public class CHTSRubricMarines extends Eintrag {

    private final AnzahlPanel marines;
    private final OptionsZaehlerGruppe o1x;
    private final OptionsZaehlerGruppe marinesfk;

    public CHTSRubricMarines() {
        name = "Rubric Marines";
        grundkosten = 0;

        kategorie = 1;

        add(marines = new AnzahlPanel(ID, randAbstand, cnt, "Rubric Marines", 5, 20, getPts("Rubric Marines")));
        add(ico = new oc.Picture("oc/wh40k/images/Moschaboy.gif"));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Inferno boltgun", getPts("Inferno boltgun")));
        ogE.addElement(new OptionsGruppeEintrag("Warpflamer", getPts("Warpflamer")));
        add(o1x = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 4));
        o1x.setAnzahl(0, marines.getModelle() - 1);

        ogE.addElement(new OptionsGruppeEintrag("Soulreaper cannon", getPts("Soulreaper cannon")));
        add(marinesfk = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 0));

        seperator();

        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Icon of Flame", getPts("Icon of Flame")));

        seperator();

        RuestkammerStarter boss = new RuestkammerStarter(ID, randAbstand, cnt, new  CHWaffenkammer("Aspiring Sorcerer TS", "Inferno bolt pistol", "Inferno bolt pistol", false, true, false, false, CHAMPION, SORCERER), "Aspiring Sorcerer");
        boss.setUeberschriftTrotzNullKostenAusgeben(true);
        boss.setGrundkosten(getPts("Aspiring Sorcerer TS"));
        boss.setAbwaehlbar(false);
        add(boss);

        seperator();

        addPsychicPowers(1, CHANGE);

        complete();
    }


    @Override
    public void refreshen() {

        int maxSR = 0;
        if (marines.getModelle() >= 10) maxSR = 1;
        if (marines.getModelle() >= 20) maxSR = 2;
        marinesfk.setMaxAnzahl(maxSR);

        o1x.setMaxAnzahl(marines.getModelle() - 1 - marinesfk.getAnzahl());

        power = 8 +
                ((marines.getModelle() == 10) ? 6 : 0) +
                ((marines.getModelle() == 15) ? 12 : 0) +
                ((marines.getModelle() == 20) ? 18 : 0);
    }
}

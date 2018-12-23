package oc.wh40k.units.ch;

import oc.*;
import oc.wh40k.units.PsychicPowers;

import static oc.wh40k.units.ch.CHWaffenkammer.ChaosWeaponsOption.CHAMPION;
import static oc.wh40k.units.ch.CHWaffenkammer.ChaosWeaponsOption.SORCERER;

public class CHRubricMarines extends Eintrag {

    AnzahlPanel marines;
    OptionsZaehlerGruppe o1;
    OptionsZaehlerGruppe o1x;
    OptionsZaehlerGruppe o1xx;

    OptionsZaehlerGruppe marinesfk;
    OptionsEinzelUpgrade pp;
    RuestkammerStarter Boss;
    RuestkammerStarter psychicPowers;

    public CHRubricMarines() {

        kategorie = 1;

        name = "Rubric Marines";
        grundkosten = 0;
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

        Boss = new RuestkammerStarter(ID, randAbstand, cnt, new CHWaffenkammer(name, "Inferno bolt pistol", "Force stave", true, true, false, false, CHAMPION, SORCERER), "Aspiring Sorcerer");
        Boss.setUeberschriftTrotzNullKostenAusgeben(true);
        Boss.setGrundkosten(getPts("Aspiring Sorcerer"));
        Boss.setAbwaehlbar(false);
        add(Boss);

        RuestkammerStarter psychicPowers;

        psychicPowers = new RuestkammerStarter(ID, randAbstand, cnt, new PsychicPowers(0), "Psychic Powers");
        psychicPowers.setUeberschriftTrotzNullKostenAusgeben(true);
        psychicPowers.setAbwaehlbar(true);
        add(psychicPowers);

        complete();
    }


    @Override
    public void refreshen() {
        o1x.setMaxAnzahl(marines.getModelle() - 1 - marinesfk.getAnzahl());

        int maxSR = 0;
        if (marines.getModelle() >= 5) maxSR = 1;
        if (marines.getModelle() >= 20) maxSR = 2;
        marinesfk.setMaxAnzahl(maxSR);

        power = 8 +
                ((marines.getModelle() == 10) ? 6 : 0) +
                ((marines.getModelle() == 15) ? 12 : 0) +
                ((marines.getModelle() == 20) ? 18 : 0);
    }
}

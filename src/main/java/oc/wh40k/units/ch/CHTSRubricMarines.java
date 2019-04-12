package oc.wh40k.units.ch;

import oc.AnzahlPanel;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsZaehlerGruppe;
import oc.RuestkammerStarter;
import oc.wh40k.units.PsychicPowers;

public class CHTSRubricMarines extends Eintrag {

	private final AnzahlPanel marines;
	private final OptionsZaehlerGruppe o1x;

	private final OptionsZaehlerGruppe marinesfk;
	private final RuestkammerStarter Boss;
	private final RuestkammerStarter psychicPowers;

    public CHTSRubricMarines() {

        category = 1;

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

        Boss = new RuestkammerStarter(ID, randAbstand, cnt, CHWaffenkammer.class, "Aspiring Sorcerer");
        ((CHWaffenkammer) Boss.getKammer()).setChampion(true);
        ((CHWaffenkammer) Boss.getKammer()).setSorcerer(true);
        ((CHWaffenkammer) Boss.getKammer()).setDefaultRanged("Inferno bolt pistol");
        ((CHWaffenkammer) Boss.getKammer()).setDefaultCloceCombat("Force stave");
        Boss.initKammer(false, true, false, false);
        Boss.setUeberschriftTrotzNullKostenAusgeben(true);
        Boss.setGrundkosten(getPts("Aspiring Sorcerer TS"));
        ((CHWaffenkammer) Boss.getKammer()).type = "Aspiring Sorcerer TS";
        add(Boss);
        Boss.setAbwaehlbar(false);

        seperator();

        psychicPowers = new RuestkammerStarter(ID, randAbstand, cnt, PsychicPowers.class, "Psychic Powers");
        ((PsychicPowers) psychicPowers.getKammer()).setNumberOfPowers(1);
        ((PsychicPowers) psychicPowers.getKammer()).enableChange();
        psychicPowers.initKammer();
        psychicPowers.setUeberschriftTrotzNullKostenAusgeben(true);
        add(psychicPowers);
        psychicPowers.setAbwaehlbar(true);

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

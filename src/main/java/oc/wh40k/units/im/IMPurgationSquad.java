package oc.wh40k.units.im;

import oc.*;
import oc.wh40k.units.PsychicPowers;

import static oc.wh40k.units.PsychicPowers.PsychicPowerGroup.SANCTIC;

public class IMPurgationSquad extends Eintrag {

    AnzahlPanel squad;
    OptionsZaehlerGruppe o1;
    OptionsZaehlerGruppe o1def;
    OptionsZaehlerGruppe o2;
    OptionsZaehlerGruppe o2def;
    RuestkammerStarter rkBoss;
    RuestkammerStarter psychicPowers;

    public IMPurgationSquad() {
        name = "Purgatortrupp\n";
        grundkosten = 10;
        überschriftSetzen = true;

        squad = new AnzahlPanel(ID, randAbstand, cnt, "Purgator", 5, 10, getPts("Purgation Squad"));
        add(squad);

        add(ico = new oc.Picture("oc/wh40k/images/GKPurgatortrupp.jpg"));


        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Nemesis force sword", getPts("Nemesis force sword")));
        add(o1def = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 0));
        ogE.addElement(new OptionsGruppeEintrag("Nemesis force halberd", getPts("Nemesis force halberd")));
        ogE.addElement(new OptionsGruppeEintrag("Nemesis daemon hammer", getPts("Nemesis daemon hammer")));
        ogE.addElement(new OptionsGruppeEintrag("Nemesis warding stave", getPts("Nemesis warding stave")));
        ogE.addElement(new OptionsGruppeEintrag("Two Nemesis falchions", getPts("Two Nemesis falchions")));
        add(o1 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 0));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Storm bolter", getPts("Storm bolter (SM)")));
        add(o2def = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 0));
        ogE.addElement(new OptionsGruppeEintrag("Incinerator", getPts("Incinerator")));
        ogE.addElement(new OptionsGruppeEintrag("Psilencer", getPts("Psilencer")));
        ogE.addElement(new OptionsGruppeEintrag("Psycannon", getPts("Psycannon")));
        add(o2 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 4));

        seperator();

        rkBoss = new RuestkammerStarter(ID, randAbstand, cnt, new IMJusticar(), "Upgrade zum Justicar");
        rkBoss.setButtonText("Upgrade zum Justicar", false);
        rkBoss.setUeberschriftTrotzNullKostenAusgeben(true);
        add(rkBoss);
        rkBoss.setAbwaehlbar(false);

        seperator();

        psychicPowers = new RuestkammerStarter(ID, randAbstand, cnt, new PsychicPowers(1, SANCTIC), "Psychic Powers");
        psychicPowers.setUeberschriftTrotzNullKostenAusgeben(true);
        add(psychicPowers);
        psychicPowers.setAbwaehlbar(true);

        complete();
    }

    @Override
    public void refreshen() {
        if (!rkBoss.isSelected()) rkBoss.setSelected(true);

        int subtractor = o2.getAnzahl() + 1; // last one is the boss

        o1.setMaxAnzahl(squad.getModelle() - subtractor); // heavy weapon
        o1def.setMaxAnzahl(squad.getModelle() - o1.getAnzahl() - subtractor);
        o1def.setAnzahl(0, squad.getModelle() - o1.getAnzahl() - subtractor);

        o2def.setMaxAnzahl(squad.getModelle() - o2.getAnzahl() - 1); // last one is the boss
        o2def.setAnzahl(0, squad.getModelle() - o2.getAnzahl() - 1); // last one is the boss

        power = 7;
        if (squad.getModelle() == 10) power += 7;
    }

}

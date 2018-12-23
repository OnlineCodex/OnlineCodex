package oc.wh40k.units.ch;

import oc.*;
import oc.wh40k.units.PsychicPowers;

import static oc.wh40k.units.PsychicPowers.PsychicPowerGroup.CHANGE;

public class CHScarabOccultTerminators extends Eintrag {

    AnzahlPanel squad;
    OptionsZaehlerGruppe o1;
    OptionsZaehlerGruppe o1def;
    OptionsZaehlerGruppe o2;
    OptionsZaehlerGruppe o2def, swords, bolter;
    OptionsEinzelUpgrade plasmapistole, sorcerer;
    OptionsUpgradeGruppe ikone;
    OptionsUpgradeGruppe sor;
    OptionsZaehlerGruppe o7;
    OptionsZaehlerGruppe schwereWaffe, rak;
    RuestkammerStarter rkBoss;
    RuestkammerStarter psychicPowers;

    public CHScarabOccultTerminators() {
        //name = "Thousand Sons\n";
        grundkosten = 0;
        überschriftSetzen = true;

        squad = new AnzahlPanel(ID, randAbstand, cnt, "Scarab Occult Terminators", 5, 10, getPts("Scarab Occult Terminators"));
        add(squad);

        seperator();

        add(ico = new oc.Picture("oc/wh40k/images/ChaosSpaceMarines.jpg"));

        ogE.addElement(new OptionsGruppeEintrag("Power sword", getPts("Power sword")));
        add(swords = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 0));

        ogE.addElement(new OptionsGruppeEintrag("Inferno combi-bolter", getPts("Inferno combi-bolter")));
        add(bolter = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 0));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Heavy warpflamer", getPts("Heavy warpflamer")));
        ogE.addElement(new OptionsGruppeEintrag("Soulreaper cannon", getPts("Soulreaper cannon")));
        add(schwereWaffe = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 0));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Hellfyre missile rack", getPts("Hellfyre missile rack")));
        add(rak = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 0));

        seperator();

        rkBoss = new RuestkammerStarter(ID, randAbstand, cnt, new CHWaffenkammer("Scarab Occult Sorcerer"), "Sorcerer");
        rkBoss.setGrundkosten(getPts("Scarab Occult Sorcerer"));
        rkBoss.setUeberschriftTrotzNullKostenAusgeben(true);
        rkBoss.setAbwaehlbar(true);
        add(rkBoss);

        seperator();

        psychicPowers = new RuestkammerStarter(ID, randAbstand, cnt, new PsychicPowers(1, CHANGE), "Psychic Powers");
        psychicPowers.setUeberschriftTrotzNullKostenAusgeben(true);
        psychicPowers.setAbwaehlbar(false);
        add(psychicPowers);

        complete();
    }

    @Override
    public void refreshen() {

        swords.setMaxAnzahl(squad.getModelle() - 1);
        swords.setAnzahl(0, squad.getModelle() - 1);

        bolter.setMaxAnzahl(squad.getModelle() - schwereWaffe.getAnzahl() - 1);
        bolter.setAnzahl(0, squad.getModelle() - schwereWaffe.getAnzahl() - 1);

        int modelle = squad.getModelle();

        if (modelle >= 5) {
            schwereWaffe.setMaxAnzahl(modelle / 5);
            rak.setMaxAnzahl(modelle / 5);
        }

        power = 13 +
                ((squad.getModelle() == 10) ? 11 : 0);
    }
}

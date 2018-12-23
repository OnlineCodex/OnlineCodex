package oc.wh40k.units.ch;

import oc.*;

import static oc.wh40k.units.ch.CHWaffenkammer.ChaosWeaponsOption.CHAMPION;
import static oc.wh40k.units.ch.CHWaffenkammer.ChaosWeaponsOption.NURGLE;

public class CHPlagueMarines extends Eintrag {

    private final AnzahlPanel marines;
    private final OptionsZaehlerGruppe bolter;
    private final OptionsZaehlerGruppe knife;
    private final OptionsZaehlerGruppe marinesfk;
    private final OptionsZaehlerGruppe marinesAxe;
    private final OptionsZaehlerGruppe marinesMace;
    private final OptionsZaehlerGruppe marinesCleaver;

    public CHPlagueMarines() {
        name = "Plague Marines";
        grundkosten = 0;

        kategorie = 1;

        add(marines = new AnzahlPanel(ID, randAbstand, cnt, "Plague Marines", 5, 20, getPts("Plague Marines")));
        add(ico = new oc.Picture("oc/wh40k/images/Moschaboy.gif"));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Boltgun", getPts("Boltgun")));
        add(bolter = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, -88));
        bolter.setAnzahl(0, marines.getModelle() - 1);

        ogE.addElement(new OptionsGruppeEintrag("Plague knife", getPts("Plague knife")));
        add(knife = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, -88));
        knife.setAnzahl(0, marines.getModelle() - 1);

        ogE.addElement(new OptionsGruppeEintrag("Blight launcher", getPts("Blight launcher")));
        ogE.addElement(new OptionsGruppeEintrag("Plague spewer", getPts("Plague spewer")));
        ogE.addElement(new OptionsGruppeEintrag("Plague belcher", getPts("Plague belcher")));
        ogE.addElement(new OptionsGruppeEintrag("Flamer", getPts("Flamer")));
        ogE.addElement(new OptionsGruppeEintrag("Meltagun", getPts("Meltagun")));
        ogE.addElement(new OptionsGruppeEintrag("Plasma gun", getPts("Plasma gun")));
        add(marinesfk = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 1));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Bubotic axe", getPts("Bubotic axe")));
        ogE.addElement(new OptionsGruppeEintrag("Plague knife", getPts("Plague knife")));
        add(marinesAxe = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 1));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Mace and Axe", "Mace of CONTAGION and Bubotic Axe", getPts("Mace of CONTAGION") + getPts("Bubotic Axe")));
//		ogE.addElement(new OptionsGruppeEintrag("Bubotic Axe", getPts("Bubotic Axe")));
        add(marinesMace = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 1));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Great plague cleaver", getPts("Great plague cleaver")));
        ogE.addElement(new OptionsGruppeEintrag("Flail of corruption", getPts("Flail of corruption")));
        add(marinesCleaver = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 1));

        seperator();

        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Icon of Despair", getPts("Icon of Despair")));

        seperator();

        RuestkammerStarter boss = new RuestkammerStarter(ID, randAbstand, cnt, new CHWaffenkammer(name, "Boltgun", "Plague knife", true, true, false, false, CHAMPION, NURGLE), "Plague Champion");
        boss.setGrundkosten(getPts("Plague Champion"));
        boss.setUeberschriftTrotzNullKostenAusgeben(true);
        boss.setAbwaehlbar(false);
        add(boss);

        complete();
    }

    @Override
    public void refreshen() {
        knife.setMaxAnzahl(marines.getModelle() - 1);
        knife.setAnzahl(0, marines.getModelle() - 1);

        int bolterAnzahl = marines.getModelle() - 1 - marinesfk.getAnzahl() - marinesAxe.getAnzahl() - marinesMace.getAnzahl() - marinesCleaver.getAnzahl();

        bolter.setMaxAnzahl(bolterAnzahl);
        bolter.setAnzahl(0, bolterAnzahl);

        if (bolterAnzahl > 0) marinesfk.setMaxAnzahl(2);
        else marinesfk.setMaxAnzahl(marinesfk.getAnzahl());

        if (bolterAnzahl > 0) marinesAxe.setMaxAnzahl(marines.getModelle() - 1);
        else marinesAxe.setMaxAnzahl(marinesAxe.getAnzahl());

        if (bolterAnzahl > 0) marinesMace.setMaxAnzahl(2);
        else marinesMace.setMaxAnzahl(marinesMace.getAnzahl());

        if (bolterAnzahl > 0) marinesCleaver.setMaxAnzahl(2);
        else marinesCleaver.setMaxAnzahl(marinesCleaver.getAnzahl());

        power = 7 +
                ((marines.getModelle() == 10) ? 5 : 0) +
                ((marines.getModelle() == 15) ? 10 : 0) +
                ((marines.getModelle() == 20) ? 15 : 0);
    }
}

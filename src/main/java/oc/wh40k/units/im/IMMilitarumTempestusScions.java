package oc.wh40k.units.im;

import oc.*;

public class IMMilitarumTempestusScions extends Eintrag {

    AnzahlPanel squad;
    OptionsZaehlerGruppe o1x;
    OptionsZaehlerGruppe o1, o4;
    RuestkammerStarter kammer;


    public IMMilitarumTempestusScions() {
        name = "Militarum Tempestus Scions";
        add(squad = new AnzahlPanel(ID, randAbstand, cnt, "Militarum Tempestus Scions", 5, 10, getPts("Militarum Tempestus Scions")));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Hot-shot lasgun", getPts("Hot-shot lasgun")));
        add(o1x = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 1));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Vox-caster + HEAVY_SUPPORT laspistol", getPts("Vox-caster") + getPts("Hot-shot laspistol")));
        add(o1 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 1));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Sniper Rifle", getPts("Sniper Rifle (AM)")));
        ogE.addElement(new OptionsGruppeEintrag("Flamer", getPts("Flamer (AM)")));
        ogE.addElement(new OptionsGruppeEintrag("Grenade Launcher", getPts("Grenade Launcher")));
        ogE.addElement(new OptionsGruppeEintrag("Meltagun", getPts("Meltagun (AM 3+)")));
        ogE.addElement(new OptionsGruppeEintrag("Plasma gun", getPts("Plasma gun (AM 3+)")));
        ogE.addElement(new OptionsGruppeEintrag("Hot-shot volleygun", getPts("Hot-shot volleygun")));
        add(o4 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 4));

        seperator();

        kammer = new RuestkammerStarter(ID, randAbstand, cnt, "IMAstraMilitarumRuestkammer", "Tempestor");
        ((IMAstraMilitarumRuestkammer) kammer.getKammer()).setType("Tempestor");
        kammer.initKammer();
        add(kammer);
        kammer.setUeberschriftTrotzNullKostenAusgeben(true);
        kammer.setAbwaehlbar(false);


        complete();
    }

    @Override
    public void refreshen() {
        int scions = squad.getModelle() - 1;
        o1x.setMaxAnzahl(scions - o1.getAnzahl() - o4.getAnzahl());
        o1x.setAnzahl(0, scions - o1.getAnzahl() - o4.getAnzahl());

        o4.setMaxAnzahl(squad.getModelle() / 5 * 2);

        power = 3;
        if (squad.getModelle() > 5) {
            power = 6;
        }
    }

}

package oc.wh40k.units.im;

import oc.*;

public class IMSicarianRuststalkers extends Eintrag {

    private final AnzahlPanel squad;
    private final OptionsZaehlerGruppe o1;
    private final OptionsZaehlerGruppe o1x;

    public IMSicarianRuststalkers() {
        name = "Sicarian Ruststalkers";
        add(squad = new AnzahlPanel(ID, randAbstand, cnt, "Sicarian Ruststalkers", 5, 10, getPts("Sicarian Ruststalkers")));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Transonic r. + chordcl.", "Transonic razor. + chordclaw.", getPts("Transonic razor") + getPts("chordclaw")));
        add(o1x = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 5));
        ogE.addElement(new OptionsGruppeEintrag("Transonic blades", getPts("Transonic blades")));
        add(o1 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 5));

        seperator();

        RuestkammerStarter rkBoss = new RuestkammerStarter(ID, randAbstand, cnt, new IMAdeptusMechanicusRuestkammer("Ruststalker Princeps", false, false, false, false), "Ruststalker Princeps");
        rkBoss.setUeberschriftTrotzNullKostenAusgeben(true);
        rkBoss.setAbwaehlbar(false);
        add(rkBoss);

        complete();
    }

    @Override
    public void refreshen() {
        int princeps = 1;
        o1x.setMaxAnzahl(squad.getModelle() - o1.getAnzahl() - princeps);
        o1x.setAnzahl(0, squad.getModelle() - o1.getAnzahl() - princeps);
        o1.setMaxAnzahl(squad.getModelle() - princeps);

        power = 5;
        if (squad.getModelle() > 6) {
            power = 10;
        }
    }
}

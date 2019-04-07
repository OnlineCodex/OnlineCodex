package oc.wh40k.units.im;

import oc.AnzahlPanel;
import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsZaehlerGruppe;
import oc.RuestkammerStarter;

public class IMSicarianRuststalkers extends Eintrag {

	private final AnzahlPanel squad;
	private final OptionsZaehlerGruppe o1, o1x;
	private final RuestkammerStarter rkBoss;

	public IMSicarianRuststalkers() {
        name = "Sicarian Ruststalkers";
        add(squad = new AnzahlPanel(ID, randAbstand, cnt, "Sicarian Ruststalkers", 5, 10, getPts("Sicarian Ruststalkers")));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Transonic r. + chordcl.", "Transonic razor. + chordclaw.", getPts("Transonic razor") + getPts("chordclaw")));
        add(o1x = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 5));
        ogE.addElement(new OptionsGruppeEintrag("Transonic blades", getPts("Transonic blades")));
        add(o1 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 5));

        seperator();

        rkBoss = new RuestkammerStarter(ID, randAbstand, cnt, IMAdeptusMechanicusRuestkammer.class, "Ruststalker Princeps");
        ((IMAdeptusMechanicusRuestkammer) rkBoss.getKammer()).setType("Ruststalker Princeps");
        rkBoss.initKammer(false, false, false, false);
        rkBoss.setUeberschriftTrotzNullKostenAusgeben(true);
        add(rkBoss);
        rkBoss.setAbwaehlbar(false);

        complete();
    }

    @Override
    public void refreshen() {
        final int princeps = 1;
        o1x.setMaxAnzahl(squad.getModelle() - o1.getAnzahl() - princeps);
        o1x.setAnzahl(0, squad.getModelle() - o1.getAnzahl() - princeps);
        o1.setMaxAnzahl(squad.getModelle() - princeps);

        power = 5;
        if (squad.getModelle() > 6) {
            power = 10;
        }
    }
}

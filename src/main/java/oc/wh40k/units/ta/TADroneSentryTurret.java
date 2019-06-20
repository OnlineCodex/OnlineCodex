package oc.wh40k.units.ta;



import oc.AnzahlPanel;
import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsZaehlerGruppe;



public class TADroneSentryTurret extends Eintrag {

	private final AnzahlPanel squad;
	private final OptionsZaehlerGruppe o1;

    public TADroneSentryTurret() {

        name = "Remote Sensor Tower";

        grundkosten = 0;

        squad = new AnzahlPanel(ID, randAbstand, cnt, "Drone Sentry Turrets", 1, 4, getPts("Drone Sentry Turret"));
        add(squad);
        
        ogE.addElement(new OptionsGruppeEintrag("2 Burst cannons", getPts("Burst cannon")*2));
        ogE.addElement(new OptionsGruppeEintrag("2 missile pods", getPts("Missile pod")*2));
        ogE.addElement(new OptionsGruppeEintrag("2 fusion blasters", getPts("Fusion blaster")*2));
        ogE.addElement(new OptionsGruppeEintrag("2 plasma rifles", getPts("Plasma rifle")*2));
        add(o1 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 1));
        o1.setAnzahl(0, 1);
        
        complete();
    }



    //@OVERRIDE

    @Override
	public void refreshen() {

    	o1.setLegal(o1.getAnzahl() == squad.getModelle());
    	o1.setMaxAnzahl(squad.getModelle());
        power = 2 * squad.getModelle();

    }

}
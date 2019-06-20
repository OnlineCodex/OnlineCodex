package oc.wh40k.units.ta;

import oc.AnzahlPanel;
import oc.Eintrag;
import oc.OptionsEinzelZaehler;

//[IA3 2nd Ed]

public class TAHeavyGunDroneSquadron extends Eintrag {

	private final AnzahlPanel HeavyGunDroneTeam;
	private final OptionsEinzelZaehler o1;
	private final OptionsEinzelZaehler o2;

    public TAHeavyGunDroneSquadron() {
        name = "Heavy Gun-Drone Team";
        grundkosten = 0;

        HeavyGunDroneTeam = new AnzahlPanel(ID, randAbstand, cnt, "Heavy Gun-Drones", 2, 6, getPts("Heavy Gun Drone"));
        add(HeavyGunDroneTeam);

        add(ico = new oc.Picture("oc/wh40k/images/HeavyGunDroneTeam.jpg"));


        seperator();

        o1 = new OptionsEinzelZaehler(ID, randAbstand, cnt, "", "2 Burst cannons", 2, getPts("Burst cannon")*2);
        add(o1);
        o2 = new OptionsEinzelZaehler(ID, randAbstand, cnt, "", "Burst cannon + Markerlight", "Burst cannon and markerlight", 2, getPts("Burst cannon") + getPts("Markerlight") );
        add(o2);

        complete();
    }

    //@OVERRIDE
    @Override
	public void refreshen() {
        o1.setMaxAnzahl(HeavyGunDroneTeam.getModelle() - o2.getAnzahl());
        o1.setAnzahl(o1.getMaxAnzahl());
        o2.setMaxAnzahl(HeavyGunDroneTeam.getModelle());
        
        power = HeavyGunDroneTeam.getModelle() + 2;
    }

}

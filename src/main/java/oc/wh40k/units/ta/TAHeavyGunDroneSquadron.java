package oc.wh40k.units.ta;

import oc.AnzahlPanel;
import oc.Eintrag;
import oc.OptionsEinzelZaehler;

//[IA3 2nd Ed]

public class TAHeavyGunDroneSquadron extends Eintrag {

    AnzahlPanel HeavyGunDroneTeam;
    OptionsEinzelZaehler o1;
    OptionsEinzelZaehler o2;

    public TAHeavyGunDroneSquadron() {
        name = "Heavy Gun-Drone Team";
        grundkosten = 0;

        HeavyGunDroneTeam = new AnzahlPanel(ID, randAbstand, cnt, "Heavy Gun-Drones", 2, 6, 25);
        add(HeavyGunDroneTeam);

        add(ico = new oc.Picture("oc/wh40k/images/HeavyGunDroneTeam.jpg"));


        seperator();

        o1 = new OptionsEinzelZaehler(ID, randAbstand, cnt, "", "TL Burst cannon", "Twin-linked burst cannon", 2, 0);
        add(o1);
        o2 = new OptionsEinzelZaehler(ID, randAbstand, cnt, "", "Burst cannon +ML", "Burst cannon and markerlight", 2, 0);
        add(o2);

        complete();
    }

    //@OVERRIDE
    public void refreshen() {
        o1.setMaxAnzahl(HeavyGunDroneTeam.getModelle() - o2.getAnzahl());
        o1.setAnzahl(o1.getMaxAnzahl());
        o2.setMaxAnzahl(HeavyGunDroneTeam.getModelle());
    }

}

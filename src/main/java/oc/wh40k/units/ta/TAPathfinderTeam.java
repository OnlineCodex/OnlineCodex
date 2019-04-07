package oc.wh40k.units.ta;

import oc.AnzahlPanel;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsZaehlerGruppe;
import oc.RuestkammerStarter;

public class TAPathfinderTeam extends Eintrag {

	private final AnzahlPanel squad;
	private final OptionsEinzelUpgrade oe1, oe2, oe3;
	private final OptionsZaehlerGruppe o5;
	private final RuestkammerStarter rkBoss;

    public TAPathfinderTeam() {
        name = "Pathfinder Team";
        grundkosten = 0;

        squad = new AnzahlPanel(ID, randAbstand, cnt, "Pathfinder", 5, 10, getPts("Pathfinder Team") + getPts("Markerlight") + getPts("Pulse carbine"));
        add(squad);

        add(ico = new oc.Picture("oc/wh40k/images/Spaeherteam.gif"));

        seperator(5);

        add(oe1 = new OptionsEinzelUpgrade(0, randAbstand, cnt, "", "MB3 Recon Drone", getPts("MB3 Recon Drone")));
        add(oe2 = new OptionsEinzelUpgrade(0, randAbstand, cnt, "", "MV33 Grav-inhibitor Drone", getPts("MV33 Grav-inhibitor Drone")));
        add(oe3 = new OptionsEinzelUpgrade(0, randAbstand, cnt, "", "MV31 Pulse Accelerator Drone", getPts("MV31 Pulse Accelerator Drone")));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("MV1 Gun Drone", getPts("MV1 Gun Drone")));
        ogE.addElement(new OptionsGruppeEintrag("MV4 Shield Drone", getPts("MV4 Shield Drone")));
        ogE.addElement(new OptionsGruppeEintrag("MV7 Marker Drone", getPts("MV7 Marker Drone")));
        add(o5 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 2));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Ion rifle", getPts("Ion rifle") - getPts("Markerlight") - getPts("Pulse carbine")));
        ogE.addElement(new OptionsGruppeEintrag("Rail rifle", getPts("Rail rifle") - getPts("Markerlight") - getPts("Pulse carbine")));
        add(new OptionsZaehlerGruppe(0, randAbstand, cnt, "", ogE, 3));

        seperator();

        rkBoss = new RuestkammerStarter(ID, randAbstand, cnt, TAInfanterieKammer.class, "Upgrade zum Shas'ui");
        rkBoss.initKammer(false, false, true);
        rkBoss.setGrundkosten(0);
        rkBoss.setUeberschriftTrotzNullKostenAusgeben(true);
        add(rkBoss);

        complete();
    }

    @Override
    public void refreshen() {
        power = 3;
        if (squad.getModelle() > 5) {
            power += 2;
        }
        if (o5.isSelected()) {
            power++;
        }
        if (oe1.isSelected()) {
            power++;
        }
        if (oe2.isSelected() || oe3.isSelected()) {
            power++;
        }
    }

    @Override
    public void deleteYourself() {
        super.deleteYourself();
    }

}

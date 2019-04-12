package oc.wh40k.units.ta;

import oc.AnzahlPanel;
import oc.Eintrag;
import oc.OptionsEinzelZaehler;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.OptionsZaehlerGruppe;
import oc.RuestkammerStarter;

public class TAStrikeTeam extends Eintrag {

	private final AnzahlPanel squad;
	private final OptionsEinzelZaehler o1;
	private final OptionsUpgradeGruppe o4;
	private final OptionsZaehlerGruppe o5, o6;
	private final RuestkammerStarter rkBoss;

    public TAStrikeTeam() {
        name = "Strike Team\n";
        applyTitle = true;
        grundkosten = 0;

        squad = new AnzahlPanel(ID, randAbstand, cnt, "Fire warrior", 5, 12, getPts("Strike Team") + getPts("Photon grenades"));
        add(squad);

        add(ico = new oc.Picture("oc/wh40k/images/Feuerkriegerteam.gif"));

        seperator(5);

        add(o1 = new OptionsEinzelZaehler(ID, randAbstand, cnt, "", "Puls carbine", squad.getModelle(), getPts("Pulse carbine")));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Puls pistol", getPts("Pulse pistol")));
        add(o6 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 2));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("MV36 Guardian Drone", getPts("MV36 Guardian Drone")));
        add(o4 = new OptionsUpgradeGruppe(randAbstand, cnt, "", ogE, 1));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("DS8 missile pod", "DS8 Tactical Support Turret with missile pod", getPts("DS8 Tactical Support Turret") + getPts("Missile pod")));
        ogE.addElement(new OptionsGruppeEintrag("DS8 smart missile", "DS8 Tactical Support Turret with smart missile system", getPts("DS8 Tactical Support Turret") + getPts("Smart missile system")));
        add(new OptionsUpgradeGruppe(randAbstand, cnt, "", ogE, 1));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("MV1 Gun Drone", getPts("MV1 Gun Drone")));
        ogE.addElement(new OptionsGruppeEintrag("MV4 Shield Drone", getPts("MV4 Shield Drone")));
        ogE.addElement(new OptionsGruppeEintrag("MV7 Marker Drone", getPts("MV7 Marker Drone")));
        add(o5 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 2));

        seperator();

        rkBoss = new RuestkammerStarter(ID, randAbstand, cnt, TAInfanterieKammer.class, "Fire Warrior Shas'ui", getPts("Fire Warrior Shas'ui"));
        rkBoss.initKammer(true, false, false);
        rkBoss.setGrundkosten(getPts("Shas'ui"));
        rkBoss.setUeberschriftTrotzNullKostenAusgeben(true);
        add(rkBoss);

        complete();
    }

    @Override
    public void refreshen() {
        o1.setMaxAnzahl(squad.getModelle());

        o5.setMaxAnzahl(2 - (o4.getAnzahl()));
        o6.setMaxAnzahl(squad.getModelle() - (rkBoss.isSelected() ? 1 : 0));

        power = 2;
        if (squad.getModelle() > 5) {
            power += 2;
        }
        if (squad.getModelle() > 10) {
            power++;
        }
        if (o5.isSelected() || o4.isSelected()) {
            power++;
        }
    }

}

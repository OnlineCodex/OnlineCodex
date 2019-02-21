package oc.wh40k.units.ta;

import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsZaehlerGruppe;

public class TATidewallDroneport extends Eintrag {

	private final OptionsZaehlerGruppe ozg1;

    public TATidewallDroneport() {
        name = "Tidewall Droneport";
        grundkosten = getPts("Tidewall Droneport");

        ogE.addElement(new OptionsGruppeEintrag("MV1 Gun Drone", getPts("MV1 Gun Drone")));
        ogE.addElement(new OptionsGruppeEintrag("MV4 Shield Drone", getPts("MV4 Shield Drone")));
        ogE.addElement(new OptionsGruppeEintrag("MV7 Marker Drone", getPts("MV7 Marker Drone")));
        add(ozg1 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 4));

        add(ico = new oc.Picture("oc/wh40k/images/TARemoteSensorTowerTeam.jpg"));

        complete();
    }

    @Override
    public void refreshen() {
        ozg1.setLegal(ozg1.getAnzahl() == 4);
        power = 5;
    }
}

package oc.wh40k.units.fo;

import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsZaehlerGruppe;

public class FOTidewallDroneport extends Eintrag {

    OptionsZaehlerGruppe ozg1;

    public FOTidewallDroneport() {
        name = "Tidewall Droneport";
        grundkosten = 60;


        ogE.addElement(new OptionsGruppeEintrag("Angriffsdrohne", 0));
        ogE.addElement(new OptionsGruppeEintrag("Markiererdrohne", 0));
        ogE.addElement(new OptionsGruppeEintrag("Schilddrohne", 0));
        add(ozg1 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 4));

        add(ico = new oc.Picture("oc/wh40k/images/TARemoteSensorTowerTeam.jpg"));

        complete();
    }

    @Override
    public void refreshen() {
        ozg1.setLegal(ozg1.getAnzahl() == 4);
    }
}

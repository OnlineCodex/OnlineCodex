package oc.wh40k.units.fo;

import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsZaehlerGruppe;

public class FOTidewallDefenceNetwork extends Eintrag {

    OptionsZaehlerGruppe ozg2;
    OptionsZaehlerGruppe ozg1;

    public FOTidewallDefenceNetwork() {
        name = "Tidewall Defence Network";
        grundkosten = 240;


        ogE.addElement(new OptionsGruppeEintrag("Tidewall Gunrig", 85));
        ogE.addElement(new OptionsGruppeEintrag("Tidewall Droneport", 60));
        add(ozg2 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 1));

        ogE.addElement(new OptionsGruppeEintrag("Angriffsdrohne", 0));
        ogE.addElement(new OptionsGruppeEintrag("Markiererdrohne", 0));
        ogE.addElement(new OptionsGruppeEintrag("Schilddrohne", 0));
        add(ozg1 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 4));

        add(ico = new oc.Picture("oc/wh40k/images/TARemoteSensorTowerTeam.jpg"));

        complete();
    }

    @Override
    public void refreshen() {
        ozg2.setLegal(ozg2.getAnzahl() == 1);
        ozg1.setAktiv(ozg2.isSelected("Tidewall Droneport"));
        ozg1.setLegal(ozg1.getAnzahl() == 4);
    }
}

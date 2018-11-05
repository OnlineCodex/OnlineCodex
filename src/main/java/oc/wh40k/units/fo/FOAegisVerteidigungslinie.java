package oc.wh40k.units.fo;

import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.OptionsZaehlerGruppe;

public class FOAegisVerteidigungslinie extends Eintrag {

    OptionsUpgradeGruppe o1;
    OptionsZaehlerGruppe ozg1;

    public FOAegisVerteidigungslinie() {
        name = "Aegis-Verteidigungslinie";
        grundkosten = 50;
        überschriftSetzen = true;

        add(ico = new oc.Picture("oc/wh40k/images/Aegis.jpg"));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Voxrelais", 20));
        ogE.addElement(new OptionsGruppeEintrag("Icarus-Laserkanone", "Waffenstellung mit Icarus-Laserkanone", 35));
        ogE.addElement(new OptionsGruppeEintrag("Vierlings-Flak", "Waffenstellung mit Vierlings-Flak", 50));
        ogE.addElement(new OptionsGruppeEintrag("Munitionslager", 20));
        add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Stacheldraht", 5));
        ogE.addElement(new OptionsGruppeEintrag("Barrikaden", 10));
        ogE.addElement(new OptionsGruppeEintrag("Panzersperren", 15));
        add(ozg1 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 6));
        complete();
    }

    @Override
    public void refreshen() {
    }
}
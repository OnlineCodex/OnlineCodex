package oc.wh40k.units.rh_ia13;

import oc.*;

public class RH_IA13RenegadeRapierLaserDestroyerBattery extends Eintrag {

    OptionsZaehlerGruppe o2;
    AnzahlPanel squad;
    OptionsEinzelUpgrade mt;
    OptionsEinzelUpgrade ca;
    OptionsEinzelUpgrade fnp;

    public RH_IA13RenegadeRapierLaserDestroyerBattery() {
        name = "Rapier Laser Destroyer Battery";
        grundkosten = 0;
        überschriftSetzen = true;

        add(ico = new oc.Picture("oc/wh40k/images/IGChimera.jpg"));

        add(squad = new AnzahlPanel(ID, randAbstand, cnt, "Rapier", "Rapiers", 1, 3, 20));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Additional Crewman", 3));
        add(o2 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 1));

        seperator();

        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Sub-flak armour", 5));
        add(ca = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Carapace armour", 10));
        add(mt = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Militia Training", 10));
        add(fnp = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Feel no Pain SR", 10));
        complete();
    }

    // @OVERRIDE
    public void refreshen() {
        o2.setMaxAnzahl(squad.getModelle());

        if (getCountFromInformationVector("RHBloodyHandedReaver") == 1) {
            mt.setSelected(true);
        }

        ca.setAktiv(getCountFromInformationVector("RHBloodyHandedReaver") == 1);
        fnp.setAktiv(getCountFromInformationVector("RHHeretekMagus") == 1);

    }

}

package oc.wh40k.units.rh_ia13;

import oc.*;

public class RH_IA13RenegadeSupportSquad extends Eintrag {

    AnzahlPanel wummen;
    OptionsZaehlerGruppe FK1;
    OptionsZaehlerGruppe FK2;
    OptionsEinzelUpgrade mt;
    OptionsEinzelUpgrade ca;
    OptionsEinzelUpgrade fnp;
    int aktivesBild = 0;

    public RH_IA13RenegadeSupportSquad() {
        grundkosten = 0;
        name = "Renegade Support Squad";
        überschriftSetzen = true;


        add(wummen = new AnzahlPanel(ID, randAbstand, cnt, "Renegade Weapon Teams", 3, 6, 10));
        wummen.setGrundkosten(-5);

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Heavy stubber", 0));
        add(FK1 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE));
        ogE.addElement(new OptionsGruppeEintrag("Heavy bolter", 5));
        ogE.addElement(new OptionsGruppeEintrag("Autocannon", 10));
        ogE.addElement(new OptionsGruppeEintrag("Missile launcher", 10));
        ogE.addElement(new OptionsGruppeEintrag("Lascannon", 15));
        ogE.addElement(new OptionsGruppeEintrag("Mortar", 5));
        add(FK2 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE));

        seperator();

        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Sub-flak armour", 5));
        add(ca = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Carapace armour", 10));
        add(mt = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Militia Training", 10));
        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Krak grenades", 10));
        add(fnp = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Feel no Pain SR", 10));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Covenant of Khorne", 20));
        ogE.addElement(new OptionsGruppeEintrag("Covenant of Nurgle", 20));
        ogE.addElement(new OptionsGruppeEintrag("Covenant of Slaanesh", 20));
        ogE.addElement(new OptionsGruppeEintrag("Covenant of Tzeentch", 20));
        add(new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE));

        complete();

    }

    //@OVERRIDE
    public void refreshen() {
        FK1.setMaxAnzahl(wummen.getModelle() - FK2.getAnzahl());
        FK1.setAnzahl(0, wummen.getModelle() - FK2.getAnzahl());
        FK2.setMaxAnzahl(wummen.getModelle());

        if (getCountFromInformationVector("RHBloodyHandedReaver") == 1) {
            mt.setSelected(true);
        }

        ca.setAktiv(getCountFromInformationVector("RHBloodyHandedReaver") == 1);
        fnp.setAktiv(getCountFromInformationVector("RHHeretekMagus") == 1);

    }
}

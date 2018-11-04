package oc.wh40k.units.cd;


import oc.*;

public class CDJagdkavalkade extends Eintrag {

    OptionsZaehlerGruppe o3;
    OptionsEinzelUpgrade ErhabeneKurtisane1, ErhabeneKurtisane2, ErhabeneKurtisane3;
    OptionsZaehlerGruppe o1, o2, o4, o5, o6, o7, o8, o9, o10;
    boolean peitsche = false;

    public CDJagdkavalkade() {

        name = "Jagdkavalkade";
        gesamtpunkteImmerAnzeigen = true;
        grundkosten = 0;

        add(ico = new oc.Picture("oc/wh40k/images/CDBlutdaemon.gif"));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Jagdstreitwagen", "Jagdstreitwagen des Slaanesh", 40));
        ogE.addElement(new OptionsGruppeEintrag("Erh. Jagdstreitwagen", "Erhabener Jagdstreitwagen des Slaanesh", 75));
        add(o3 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 3));

        seperator();

        add(ErhabeneKurtisane1 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Erhabene Kurtisane", 0));

        ogE.addElement(new OptionsGruppeEintrag("Geringe Belohnung", 10));
        add(o1 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "option", ogE, 2));
        ogE.addElement(new OptionsGruppeEintrag("Mächtige Belohnung", 20));
        add(o2 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "option", ogE, 1));
        ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Peitschen der Pein"), 15));//Exalted Allures
        add(o8 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "option", ogE, 1));

        seperator();

        add(ErhabeneKurtisane2 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Erhabene Kurtisane", 0));

        ogE.addElement(new OptionsGruppeEintrag("Geringe Belohnung", 10));
        add(o4 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "option", ogE, 2));
        ogE.addElement(new OptionsGruppeEintrag("Mächtige Belohnung", 20));
        add(o5 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "option", ogE, 1));
        ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Peitschen der Pein"), 15));//Exalted Allures
        add(o9 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "option", ogE, 1));

        seperator();

        add(ErhabeneKurtisane3 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Erhabene Kurtisane", 0));

        ogE.addElement(new OptionsGruppeEintrag("Geringe Belohnung", 10));
        add(o6 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "option", ogE, 2));
        ogE.addElement(new OptionsGruppeEintrag("Mächtige Belohnung", 20));
        add(o7 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "option", ogE, 1));
        ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Peitschen der Pein"), 15));//Exalted Allures
        add(o10 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "option", ogE, 1));

        complete();

    }

    @Override
    public void refreshen() {
        o3.setLegal(o3.isSelected());

        if (o3.getAnzahl() > 0) {
            ErhabeneKurtisane1.setAktiv(true);
            ErhabeneKurtisane1.setSelected(true);
        } else {
            ErhabeneKurtisane1.setAktiv(false);
            ErhabeneKurtisane1.setSelected(false);
        }

        o1.setAktiv(ErhabeneKurtisane1.isSelected());
        o2.setAktiv(ErhabeneKurtisane1.isSelected());

        if (o1.getAnzahl() > 0) {
            o2.setMaxAnzahl(0);
        } else {
            o2.setMaxAnzahl(1);
        }

        if (o2.getAnzahl() > 0) {
            o1.setMaxAnzahl(0);
        } else {
            o1.setMaxAnzahl(2);
        }

        if (o3.getAnzahl() > 1) {
            ErhabeneKurtisane2.setAktiv(true);
            ErhabeneKurtisane2.setSelected(true);
        } else {
            ErhabeneKurtisane2.setAktiv(false);
            ErhabeneKurtisane2.setSelected(false);
        }
        o4.setAktiv(ErhabeneKurtisane2.isSelected());
        o5.setAktiv(ErhabeneKurtisane2.isSelected());

        if (o4.getAnzahl() > 0) {
            o5.setMaxAnzahl(0);
        } else {
            o5.setMaxAnzahl(1);
        }

        if (o5.getAnzahl() > 0) {
            o4.setMaxAnzahl(0);
        } else {
            o4.setMaxAnzahl(2);
        }

        if (o3.getAnzahl() > 2) {
            ErhabeneKurtisane3.setAktiv(true);
            ErhabeneKurtisane3.setSelected(true);
        } else {
            ErhabeneKurtisane3.setAktiv(false);
            ErhabeneKurtisane3.setSelected(false);
        }
        o6.setAktiv(ErhabeneKurtisane3.isSelected());
        o7.setAktiv(ErhabeneKurtisane3.isSelected());

        if (o6.getAnzahl() > 0) {
            o7.setMaxAnzahl(0);
        } else {
            o7.setMaxAnzahl(1);
        }

        if (o7.getAnzahl() > 0) {
            o6.setMaxAnzahl(0);
        } else {
            o6.setMaxAnzahl(2);
        }

        o8.setAktiv(ErhabeneKurtisane1.isSelected() && !o9.isSelected() && !o10.isSelected());
        o9.setAktiv(ErhabeneKurtisane1.isSelected() && !o8.isSelected() && !o10.isSelected());
        o10.setAktiv(ErhabeneKurtisane1.isSelected() && !o9.isSelected() && !o8.isSelected());

        if (o8.isSelected() || o9.isSelected() || o10.isSelected()) {
            if (peitsche == false) {
                peitsche = true;
                BuildaHQ.addToInformationVectorGlobal("CDpeitsche", 1);
                RefreshListener.fireRefresh();
            }
        } else {
            if (peitsche == true) {
                peitsche = false;
                BuildaHQ.addToInformationVectorGlobal("CDpeitsche", -1);
                RefreshListener.fireRefresh();
            }
        }

        if (BuildaHQ.getCountFromInformationVectorGlobal("CDpeitsche") > 1 && (o8.isSelected() || o9.isSelected() || o10.isSelected())) {
            setFehlermeldung("Artefakt doppelt");
        } else {
            setFehlermeldung("");
        }

    }

    @Override
    public void deleteYourself() {
        if (peitsche == true) {
            peitsche = false;
            BuildaHQ.addToInformationVectorGlobal("CDpeitsche", -1);
            RefreshListener.fireRefresh();
        }
    }
}

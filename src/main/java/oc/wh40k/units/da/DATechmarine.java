package oc.wh40k.units.da;

import oc.*;

public class DATechmarine extends Eintrag {

    RuestkammerStarter waffenUndReliquien;
    RuestkammerStarter spezialAusruestung;
    RuestkammerStarter servitoren;
    OptionsUpgradeGruppe servoarm = null;
    boolean bikeBool;

    public DATechmarine() {
        name = "Techmarine";
        grundkosten = 65;

        add(ico = new oc.Picture("oc/wh40k/images/DACompanyMaster.gif"));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Servoarm", 0));
        ogE.addElement(new OptionsGruppeEintrag("Servoharnisch", 25));
        add(servoarm = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
        servoarm.setSelected(0, true);

        seperator();

        waffenUndReliquien = new RuestkammerStarter(ID, randAbstand, cnt, "DAWaffenUndReliquien", "");
        // Kompaniemeister, Absolutionspriester, Ordenspriester, Skriptor, Techmarine
        waffenUndReliquien.initKammer(false, false, false, false, true);
        waffenUndReliquien.setButtonText(BuildaHQ.translate("Waffen & Reliquien"));
        add(waffenUndReliquien);
        waffenUndReliquien.setAbwaehlbar(false);

        seperator();

        spezialAusruestung = new RuestkammerStarter(ID, randAbstand, cnt, "DASpezialausruestung", "");
        spezialAusruestung.initKammer(false, false, true);
        spezialAusruestung.setButtonText(BuildaHQ.translate("Spezielle Ausrüstung"));
        add(spezialAusruestung);

        seperator();

        servitoren = new RuestkammerStarter(ID, randAbstand, cnt, "DATechmarineKammer", "");
        servitoren.initKammer();
        servitoren.setButtonText(BuildaHQ.translate("Servitoren"));
        add(servitoren);

        seperator(5);

        complete();
    }

    @Override
    public void deleteYourself() {

    }

    @Override
    public void refreshen() {

        if (((DAWaffenUndReliquien) waffenUndReliquien.getKammer()).uniqueError) {
            setFehlermeldung("Artefakt doppelt!");
        } else if (getCountFromInformationVector("DAHQ") < getCountFromInformationVector("DATechmarine")) {
            setFehlermeldung("0-" + getCountFromInformationVector("DAHQ") + " Techmarines");
        } else {
            setFehlermeldung("");
        }

        spezialAusruestung.getPanel().setLocation(
                (int) spezialAusruestung.getPanel().getLocation().getX(),
                (int) waffenUndReliquien.getPanel().getLocation().getY() + waffenUndReliquien.getPanel().getSize().height + 5
        );

        servitoren.getPanel().setLocation(
                (int) servitoren.getPanel().getLocation().getX(),
                (int) spezialAusruestung.getPanel().getLocation().getY() + spezialAusruestung.getPanel().getSize().height + 5
        );

        if (getCountFromInformationVector("Ravenwing Strike Force") > 0) {
            if (!spezialAusruestung.isSelected()) spezialAusruestung.setSelected(true);
            ((DASpezialausruestung) spezialAusruestung.getKammer()).ravenwing = true;
        }
    }

}

package oc.wh40k.units.da;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.RuestkammerStarter;

public class DACompanyMaster extends Eintrag {

    OptionsEinzelUpgrade termi;
    OptionsEinzelUpgrade meister;
    RuestkammerStarter waffenUndReliquien;
    RuestkammerStarter termiWaffen;
    RuestkammerStarter spezialAusruestung;
    boolean termiBool = false;

    public DACompanyMaster() {
        name = "Company Master";
        grundkosten = 90;

        add(ico = new oc.Picture("oc/wh40k/images/DACompanyMaster.gif"));

        seperator();

        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "Sturmschild", "Sturmschild", 15));
        //add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "Düsteres Relikt der alten Legion", "Düsteres Relikt", 15));
        add(meister = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "Meisterhafte Rüstung", "Meisterhafte Rüstung", 20));

        seperator();

        add(termi = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Terminatorrüstung", 30));

        seperator();

        termiWaffen = new RuestkammerStarter(ID, randAbstand, cnt, "DATerminatorwaffen", "");
        termiWaffen.initKammer(true, false, false);
        termiWaffen.setButtonText(BuildaHQ.translate("Terminatorwaffen & Reliquien"));
        add(termiWaffen);

        seperator();

        waffenUndReliquien = new RuestkammerStarter(ID, randAbstand, cnt, "DAWaffenUndReliquien", "");
        // Kompaniemeister, Absolutionspriester, Ordenspriester, Skriptor, Techmarine
        waffenUndReliquien.initKammer(true, false, false, false, false);
        waffenUndReliquien.setButtonText(BuildaHQ.translate("Waffen & Reliquien"));
        add(waffenUndReliquien);
        waffenUndReliquien.setAbwaehlbar(false);

        seperator();

        spezialAusruestung = new RuestkammerStarter(ID, randAbstand, cnt, "DASpezialausruestung", "");
        spezialAusruestung.initKammer(false, true, false);
        spezialAusruestung.setButtonText(BuildaHQ.translate("Spezielle Ausrüstung"));
        add(spezialAusruestung);

        seperator(5);

        addToInformationVector("DAHQ", 1);

        complete();
    }

    @Override
    public void deleteYourself() {
        addToInformationVector("DAHQ", -1);
        if (termiBool) {
            addToInformationVector("DATermiHQ", -1);
        }

        super.deleteYourself();
    }

    @Override
    public void refreshen() {
        if (termi.isSelected()) {
            waffenUndReliquien.setAktiv(false);
            termiWaffen.setAbwaehlbar(false);
            termiWaffen.setAktiv(true);
        } else {
            waffenUndReliquien.setAktiv(true);
            termiWaffen.setAbwaehlbar(false);
            termiWaffen.setAktiv(false);
        }

        termi.setAktiv(!((DASpezialausruestung) spezialAusruestung.getKammer()).o1.isSelected("Sprungmodul") && !meister.isSelected());
        meister.setAktiv(!termi.isSelected());

        spezialAusruestung.getKammer().switchEntry("Sprungmodul", termi.isSelected());

        if (((DAWaffenUndReliquien) waffenUndReliquien.getKammer()).uniqueError ||
                ((DATerminatorwaffen) termiWaffen.getKammer()).uniqueError) {
            setFehlermeldung("Artefakt doppelt!");
        } else {
            setFehlermeldung("");
        }

        if (termiBool != termi.isSelected()) {
            termiBool = termi.isSelected();
            addToInformationVector("DATermiHQ", (termiBool ? 1 : -1));
        }

        waffenUndReliquien.getPanel().setLocation(
                (int) waffenUndReliquien.getPanel().getLocation().getX(),
                (int) termiWaffen.getPanel().getLocation().getY() + termiWaffen.getPanel().getSize().height + 5
        );

        spezialAusruestung.getPanel().setLocation(
                (int) spezialAusruestung.getPanel().getLocation().getX(),
                (int) waffenUndReliquien.getPanel().getLocation().getY() + waffenUndReliquien.getPanel().getSize().height + 5
        );

        if (getCountFromInformationVector("Deathwing Redemption Force") > 0) {
            if (!termi.isSelected()) termi.setSelected(true);
        }

        if (getCountFromInformationVector("Ravenwing Strike Force") > 0) {
            if (!spezialAusruestung.isSelected()) spezialAusruestung.setSelected(true);
            ((DASpezialausruestung) spezialAusruestung.getKammer()).ravenwing = true;
        }
    }

}

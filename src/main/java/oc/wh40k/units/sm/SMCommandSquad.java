package oc.wh40k.units.sm;

import oc.*;

import java.util.Vector;


public class SMCommandSquad extends Eintrag {

    OptionsEinzelUpgrade apo;
    OptionsEinzelUpgrade boss;
    OptionsUpgradeGruppe oBoss;
    RuestkammerStarter rkTransport;
    RuestkammerStarter rkPrometheus;
    OptionsEinzelUpgrade banner;
    OptionsEinzelUpgrade empBanner;
    OptionsEinzelUpgrade khanBanner;
    OptionsEinzelUpgrade stagandaBanner;
    Vector<RuestkammerStarter> kommandos = new Vector<RuestkammerStarter>();
    boolean empBannerBool;
    boolean khanBannerBool;
    boolean stagandaBannerBool;
    OptionsEinzelUpgrade bikes;

    boolean siegeForce;

    public SMCommandSquad() {
        name = "Command Squad";
        grundkosten = 90;

        addToInformationVector("Command Squad", 1);

        siegeForce = OnlineCodex.getInstance().isCurrentArmy(oc.wh40k.armies.VOLKSiegeVanguardIA10.class);

        add(ico = new oc.Picture("oc/wh40k/images/SMKommandotrupp.jpg"));

        seperator();

        add(bikes = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Space Marine Bikes", 35));

        seperator();

        add(apo = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Apothecarius", 15));
        add(boss = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Kompaniechampion", "Kompaniechampion mit ", 15));
        ogE.addElement(new OptionsGruppeEintrag("Energiewaffe", "Energiewaffe und Parierschild", 0));
        ogE.addElement(new OptionsGruppeEintrag("Energieschwert", "Energieschwert und Parierschild", 0));
        ogE.addElement(new OptionsGruppeEintrag("Energieaxt", "Energieaxt und Parierschild", 0));
        ogE.addElement(new OptionsGruppeEintrag("Energielanze", "Energielanze und Parierschild", 0));
        ogE.addElement(new OptionsGruppeEintrag("Energiestreitkolben", "Energiestreitkolben und Parierschild", 0));
        add(oBoss = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "option", ogE));
        seperator();

        add(banner = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Kompaniestandarte", 15));
        add(empBanner = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Standarte d. H. I.", "Standarte des Himmelfahrenden Imperators", 60));
        add(khanBanner = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "[WZK] The Banner of the Eagle", "The Banner of the Eagle (WZ Kauyon - Sons of the Great Khan)", 30));
        add(stagandaBanner = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "[SoT] The Banner of Staganda", 25));

        seperator();

        for (int i = 0; i < 5; i++) {
            RuestkammerStarter rs = new RuestkammerStarter(ID, randAbstand, cnt, "SMKommandoWaffen", "Veteran\n");
            rs.initKammer(false);
            rs.setButtonText("Veteran");
            rs.setSeperator(0);
            rs.setUeberschriftTrotzNullKostenAusgeben(true);
            add(rs);
            rs.setAbwaehlbar(false);
            kommandos.add(rs);
        }

        seperator();

        rkTransport = new RuestkammerStarter(ID, randAbstand, cnt, "SMTransporterKammer", "Transporter");
        rkTransport.initKammer(false, true);
        rkTransport.setButtonText("Transporter");
        add(rkTransport);

        if (!siegeForce) {

            seperator();

        } else {

            rkPrometheus = new RuestkammerStarter(ID, randAbstand, cnt, "SFLandRaiderPrometheusKammer", "Land Raider Prometheus");
            rkPrometheus.initKammer();
            rkPrometheus.setButtonText("Land Raider Prometheus");
            add(rkPrometheus);
        }

        complete();
    }

    @Override
    public void refreshen() {
        if (((SMTransporterKammer) rkTransport.getKammer()).ultra != (getCountFromInformationVector("SMUltramarines") > 0)) {
            ((SMTransporterKammer) rkTransport.getKammer()).ultra = (getCountFromInformationVector("SMUltramarines") > 0);
            RefreshListener.fireRefresh();
        }

        banner.setAktiv(!empBanner.isSelected() && !khanBanner.isSelected() && !stagandaBanner.isSelected());
        empBanner.setAktiv(!banner.isSelected() && !khanBanner.isSelected() && !stagandaBanner.isSelected());
        khanBanner.setAktiv(!banner.isSelected() && !empBanner.isSelected() && !stagandaBanner.isSelected());
        stagandaBanner.setAktiv(!banner.isSelected() && !empBanner.isSelected() && !khanBanner.isSelected() && getCountFromInformationVector("Sentinels of Terra") > 0);

        if (boss.isSelected() && apo.isSelected()) {
            kommandos.get(4).setAktiv(false);
            kommandos.get(3).setAktiv(false);
        } else if (boss.isSelected() || apo.isSelected()) {
            kommandos.get(4).setAktiv(false);
            kommandos.get(3).setAktiv(true);
        } else {
            kommandos.get(4).setAktiv(true);
            kommandos.get(3).setAktiv(true);
        }

        oBoss.setAktiv(boss.isSelected());
        if (boss.isSelected() && !oBoss.isSelected()) {
            oBoss.setSelected(0, true);
        }

        if (!siegeForce) {


        } else {

            rkTransport.setAktiv(!rkPrometheus.isSelected());
            rkPrometheus.setAktiv(!rkTransport.isSelected());
        }

        //Einzigartige Banner
        if (empBannerBool != empBanner.isSelected()) {
            empBannerBool = empBanner.isSelected();
            addToInformationVector("SMBanner", (empBannerBool ? 1 : -1));
            RefreshListener.fireRefresh();
        }
        empBanner.setLegal(!empBanner.isSelected() || getCountFromInformationVector("SMBanner") <= 1);

        if (khanBannerBool != khanBanner.isSelected()) {
            khanBannerBool = khanBanner.isSelected();
            addToInformationVector("SMKhanBanner", (khanBannerBool ? 1 : -1));
            RefreshListener.fireRefresh();
        }
        khanBanner.setLegal(!khanBanner.isSelected() || getCountFromInformationVector("SMKhanBanner") <= 1);

        if (stagandaBannerBool != stagandaBanner.isSelected()) {
            stagandaBannerBool = stagandaBanner.isSelected();
            addToInformationVector("SMStagandaBanner", (stagandaBannerBool ? 1 : -1));
            RefreshListener.fireRefresh();
        }
        stagandaBanner.setLegal(!stagandaBanner.isSelected() || getCountFromInformationVector("SMStagandaBanner") <= 1);

        //Detachments
        boolean max1Error = false;
        boolean max2Error = false;
        if (getCountFromInformationVector("Battle Company") > 0) {
            ((SMTransporterKammer) rkTransport.getKammer()).mod = 0;
            if (getCountFromInformationVector("Command Squad") > 2) {
                max2Error = true;
            }
        } else if (getCountFromInformationVector("Battle Demi-Company") > 0 || getCountFromInformationVector("Strike Force Command") > 0) {
            if (getCountFromInformationVector("Command Squad") > 1) {
                max1Error = true;
            }
        } else if (getCountFromInformationVector("Reclusiam Command Squad") > 0) {
            rkTransport.setAbwaehlbar(false);
            ((SMTransporterKammer) rkTransport.getKammer()).o1.setAktiv(0, false);
            ((SMTransporterKammer) rkTransport.getKammer()).o1.setSelected(1, true);
            ((SMTransporterKammer) rkTransport.getKammer()).o1.setAktiv(2, false);
            ((SMTransporterKammer) rkTransport.getKammer()).o2.setAktiv(true);
        } else if (getCountFromInformationVector("Hunting Force") > 0) {
            if (!bikes.isSelected()) {
                bikes.setSelected(true);
            }
        }

        //Errors
        if (max2Error) {
            setFehlermeldung("0-2");
        } else if (max1Error) {
            setFehlermeldung("0-1");
        } else if (((SMTransporterKammer) rkTransport.getKammer()).chronosError) {
            setFehlermeldung("Max 1 Chronus");
        } else {
            setFehlermeldung("");
        }
    }

    @Override
    public void deleteYourself() {
        addToInformationVector("Command Squad", -1);
        if (empBannerBool) {
            addToInformationVector("SMBanner", -1);
        }
        if (khanBannerBool) {
            addToInformationVector("SMKhanBanner", -1);
        }
        if (stagandaBannerBool) {
            addToInformationVector("SMStagandaBanner", -1);
        }
        super.deleteYourself();
    }

}

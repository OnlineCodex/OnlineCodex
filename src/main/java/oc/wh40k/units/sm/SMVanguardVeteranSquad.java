package oc.wh40k.units.sm;

import oc.*;

public class SMVanguardVeteranSquad extends Eintrag {//Vanguard

    AnzahlPanel squad;
    OptionsZaehlerGruppe o1;
    OptionsZaehlerGruppe o1x;
    OptionsZaehlerGruppe o2;
    OptionsZaehlerGruppe o2x;
    OptionsEinzelZaehler oMB;
    OptionsEinzelUpgrade oJP;
    OptionsEinzelUpgrade culln;
    RuestkammerStarter rkTransport;
    RuestkammerStarter rkPod;
    RuestkammerStarter rkBoss;

    boolean siegeForce;
    boolean cullnSelected;

    public SMVanguardVeteranSquad() {
        name = "Vanguard Veteran Squad\n";
        grundkosten = 0;
        überschriftSetzen = true;

        addToInformationVector("Vanguard Veteran Squad", 1);

        siegeForce = OnlineCodex.getInstance().isCurrentArmy(oc.wh40k.armies.VOLKSiegeVanguardIA10.class);

        squad = new AnzahlPanel(ID, randAbstand, cnt, "Veteranen", 5, 10, 19);
        add(squad);

        add(ico = new oc.Picture("oc/wh40k/images/SMExpugnatorgarde.jpg"));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Boltpistole", 0));
        add(o1x = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 0));


        ogE.addElement(new OptionsGruppeEintrag("Energieklaue", 5));
        ogE.addElement(new OptionsGruppeEintrag("Energiewaffe", 5));
        ogE.addElement(new OptionsGruppeEintrag("Energieschwert", 5));
        ogE.addElement(new OptionsGruppeEintrag("Energieaxt", 5));
        ogE.addElement(new OptionsGruppeEintrag("Energielanze", 5));
        ogE.addElement(new OptionsGruppeEintrag("Energiestreitkolben", 5));
        ogE.addElement(new OptionsGruppeEintrag("Plasmapistole", 15));
        ogE.addElement(new OptionsGruppeEintrag("Gravpistole", 15));
        ogE.addElement(new OptionsGruppeEintrag("Energiefaust", 15));
        ogE.addElement(new OptionsGruppeEintrag("Energiehammer", 20));
        ogE.addElement(new OptionsGruppeEintrag("Sturmschild", 10));
        add(o1 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 0));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Kettenschwert", 0));
        add(o2x = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 0));


        ogE.addElement(new OptionsGruppeEintrag("Energieklaue", 5));
        ogE.addElement(new OptionsGruppeEintrag("Energiewaffe", 5));
        ogE.addElement(new OptionsGruppeEintrag("Energieschwert", 5));
        ogE.addElement(new OptionsGruppeEintrag("Energieaxt", 5));
        ogE.addElement(new OptionsGruppeEintrag("Energielanze", 5));
        ogE.addElement(new OptionsGruppeEintrag("Energiestreitkolben", 5));
        ogE.addElement(new OptionsGruppeEintrag("Plasmapistole", 15));
        ogE.addElement(new OptionsGruppeEintrag("Gravpistole", 15));
        ogE.addElement(new OptionsGruppeEintrag("Energiefaust", 15));
        ogE.addElement(new OptionsGruppeEintrag("Energiehammer", 20));
        ogE.addElement(new OptionsGruppeEintrag("Sturmschild", 10));
        add(o2 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 0));

        seperator();

        add(oMB = new OptionsEinzelZaehler(ID, randAbstand, cnt, "", "Melterbomben", -88, 5));
        add(oJP = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Sprungmodule", -88));

        seperator();


        add(culln = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Sergeant Culln [FW]", "Sergeant Culln [Forgeworld]", 60));

        seperator(5);

        rkBoss = new RuestkammerStarter(ID, randAbstand, cnt, "SMVanguardSarge", "Upgrade zum Sergeant");
        rkBoss.initKammer();
        rkBoss.setAbwaehlbar(false);
        rkBoss.setUeberschriftTrotzNullKostenAusgeben(true);
        add(rkBoss);

        seperator();

        rkTransport = new RuestkammerStarter(ID, randAbstand, cnt, "SMTransporterKammer", "Transporter");
        rkTransport.initKammer(false, true);
        rkTransport.setButtonText("Transporter");
        add(rkTransport);

        if (!siegeForce) {

            rkPod = new RuestkammerStarter(ID, randAbstand, cnt, "SMDropPodKammer", "Landungskapsel");
            rkPod.initKammer(false);
            rkPod.setButtonText("Landungskapsel");
            rkPod.setSeperator(0);
            add(rkPod);
            rkPod.setSeperator(0);

        }

        complete();
    }

    @Override
    public void refreshen() {

        if (((SMTransporterKammer) rkTransport.getKammer()).ultra != (getCountFromInformationVector("SMUltramarines") > 0)) {
            ((SMTransporterKammer) rkTransport.getKammer()).ultra = (getCountFromInformationVector("SMUltramarines") > 0);
            RefreshListener.fireRefresh();
        }

        if (!rkBoss.isSelected()) rkBoss.setSelected(true);

        o1.setMaxAnzahl(squad.getModelle() - 1);
        o1x.setMaxAnzahl(squad.getModelle() - 1);
        o1x.setAnzahl(0, squad.getModelle() - 1 - o1.getAnzahl());

        o2.setMaxAnzahl(squad.getModelle() - 1);
        o2x.setMaxAnzahl(squad.getModelle() - 1);
        o2x.setAnzahl(0, squad.getModelle() - 1 - o2.getAnzahl());

        oMB.setMaxAnzahl(squad.getModelle() - 1);
        oJP.setPreis(squad.getModelle() * 3);

        rkBoss.setAktiv(!culln.isSelected());
        culln.setAktiv(!rkBoss.isSelected());

        if (!rkBoss.isSelected() && !culln.isSelected()) rkBoss.setSelected(true);

        if (!siegeForce) {

            rkTransport.setAktiv(!rkPod.isSelected() && !oJP.isSelected());
            rkPod.setAktiv(!rkTransport.isSelected() && !oJP.isSelected());

            oJP.setAktiv(!rkPod.isSelected() && !rkTransport.isSelected());

        } else {

            rkTransport.setAktiv(!oJP.isSelected());
            oJP.setAktiv(!rkTransport.isSelected());
        }

        // Unique entry: Sergeant Culln
        if (getCountFromInformationVector("SMLordHighCommanderCarabCulln") == 0) {
            boolean cullnGlobal = (getCountFromInformationVector("SMCulln") > 0 ? true : false);
            if (cullnGlobal && !cullnSelected) culln.setAktiv(false);
            else culln.setAktiv(true);

            if (culln.isSelected()) {
                cullnSelected = true;
                addToInformationVector("SMCulln", 1);
            } else {
                if (cullnSelected) {
                    cullnSelected = false;
                    setInformationVectorValue("SMCulln", 0);
                    BuildaHQ.refreshEntries(2);
                    BuildaHQ.refreshEntries(3);
                }
            }
        } else {
            culln.setAktiv(false);
        }

        //Detachments
        boolean max1Error = false;
        boolean min1Error = false;
        if (getCountFromInformationVector("1st Company Task Force") > 0) {
            int i = getCountFromInformationVector("Sternguard Veteran Squad") + getCountFromInformationVector("Vanguard Veteran Squad") + getCountFromInformationVector("Terminator Squad") + getCountFromInformationVector("Terminator Assault Squad");
            if (i > 5) {
                max1Error = true;
            } else if (i < 3) {
                min1Error = true;
            }
        } else if (getCountFromInformationVector("Shadowstrike Killteam") > 0) {
            oJP.setSelected(true);
        } else if (getCountFromInformationVector("Bladewing Assault Brotherhood") > 0) {
            oJP.setSelected(true);
        }

        //Errors
        if (max1Error || min1Error) {
            setFehlermeldung("3-5");
        } else if (((SMTransporterKammer) rkTransport.getKammer()).chronosError) {
            setFehlermeldung("Max 1 Chronus");
        } else {
            setFehlermeldung("");
        }
    }

    @Override
    public void deleteYourself() {
        addToInformationVector("Vanguard Veteran Squad", -1);
        super.deleteYourself();
    }

}


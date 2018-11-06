package oc.wh40k.units.sm;

import oc.*;

public class SMAssaultSquad extends Eintrag {

    AnzahlPanel squad;
    OptionsZaehlerGruppe o1, o2;
    OptionsEinzelUpgrade jet;
    RuestkammerStarter rkBoss;
    RuestkammerStarter rkRhino;
    RuestkammerStarter rkPod;

    public SMAssaultSquad() {
        name = "Assault Squad\n";
        grundkosten = 0;
        überschriftSetzen = true;

        addToInformationVector("Assault Squad", 1);

        squad = new AnzahlPanel(ID, randAbstand, cnt, "Space Marines", 5, 10, 14);
        add(squad);

        add(ico = new oc.Picture("oc/wh40k/images/SMSturmtrupp.jpg"));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Flammenwerfer", 5));
        ogE.addElement(new OptionsGruppeEintrag("Plasmapistole", 15));
        add(o1 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 2));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Eviscerator", 25));
        add(o2 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 2));

        seperator();

        add(jet = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Sprungmodule", 3));

        seperator();

        seperator();

        rkBoss = new RuestkammerStarter(ID, randAbstand, cnt, "SMSturmtruppSergeant", "Upgrade zum Sergeant");
        rkBoss.initKammer();
        rkBoss.setUeberschriftTrotzNullKostenAusgeben(true);
        add(rkBoss);
        rkBoss.setAbwaehlbar(false);

        seperator();

        rkRhino = new RuestkammerStarter(ID, randAbstand, cnt, "SMTransporterKammer", "");
        rkRhino.initKammer(false, true);
        rkRhino.setButtonText("Transporter");
        rkRhino.setUeberschriftTrotzNullKostenAusgeben(false);
        add(rkRhino);

        seperator();

        rkPod = new RuestkammerStarter(ID, randAbstand, cnt, "SMDropPodKammer", "Landungskapsel");
        rkPod.initKammer(false, false);
        rkPod.setButtonText("Landungskapsel");
        rkPod.setSeperator(0);
        add(rkPod);

        complete();
    }

    @Override
    public void refreshen() {

        jet.setModelle(squad.getModelle());

        o2.setMaxAnzahl(squad.getModelle() == 10 ? 2 : 1);

        if (((SMTransporterKammer) rkRhino.getKammer()).ultra != (getCountFromInformationVector("SMUltramarines") > 0)) {
            ((SMTransporterKammer) rkRhino.getKammer()).ultra = (getCountFromInformationVector("SMUltramarines") > 0);
            RefreshListener.fireRefresh();
        }

        if (!rkBoss.isSelected()) rkBoss.setSelected(true);

        rkRhino.setAktiv(!jet.isSelected() && !rkPod.isSelected());
        rkPod.setAktiv(!jet.isSelected() && !rkRhino.isSelected());

        //Detachments
        boolean max1Error = false;
        boolean max2Error = false;
        if (getCountFromInformationVector("Battle Company") > 0) {
            ((SMTransporterKammer) rkRhino.getKammer()).mod = 0;
            int i = getCountFromInformationVector("Assault Squad") + getCountFromInformationVector("Attack Bike Squad") + getCountFromInformationVector("Bike Squad") + getCountFromInformationVector("Centurion Assault Squad") + getCountFromInformationVector("Land Speeders");
            if (i > 2) {
                max2Error = true;
            }
        } else if (getCountFromInformationVector("Battle Demi-Company") > 0) {
            int i = getCountFromInformationVector("Assault Squad") + getCountFromInformationVector("Attack Bike Squad") + getCountFromInformationVector("Bike Squad") + getCountFromInformationVector("Centurion Assault Squad") + getCountFromInformationVector("Land Speeders");
            if (i > 1) {
                max1Error = true;
            }
        } else if (getCountFromInformationVector("Skyhammer Annihilation Force (Webstore)") > 0) {
            jet.setSelected(true);
            rkRhino.setAktiv(false);
        }

        //Errors
        if (max2Error) {
            setFehlermeldung("Max 2");
        } else if (max1Error) {
            setFehlermeldung("Max 1");
        } else if (((SMTransporterKammer) rkRhino.getKammer()).chronosError) {
            setFehlermeldung("Max 1 Chronus");
        } else {
            setFehlermeldung("");
        }

    }

    @Override
    public void deleteYourself() {
        addToInformationVector("Assault Squad", -1);
        super.deleteYourself();
    }

}

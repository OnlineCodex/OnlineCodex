package oc.wh40k.units.cs;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.RuestkammerStarter;

import java.util.Vector;

public class CSDreadclawTalon extends Eintrag {

    Vector<RuestkammerStarter> dreadclaws = new Vector<RuestkammerStarter>();//1+

    public CSDreadclawTalon() {
        name = "Dreadclaw Talon";
        grundkosten = 50;
        add(ico = new oc.Picture("oc/wh40k/images/DreadclawTalon.gif"));

        for (int i = 0; i < 4; i++) {
            dreadclaws.add(new RuestkammerStarter(ID, randAbstand, cnt, "CMDreadclawKammer", "Dreadclaw", 0));
            dreadclaws.get(i).initKammer();
            add(dreadclaws.get(i));
            dreadclaws.get(i).setButtonText("Dreadclaw");
        }
        dreadclaws.get(3).setAktiv(false);


        complete();

    }

    public void refreshen() {

        adjustOptions(dreadclaws, 3, "CMDreadclawKammer", "Dreadclaw", 0, 0);
        dreadclaws.get(0).setLegal(dreadclaws.get(0).isSelected());
        dreadclaws.get(1).setLegal(dreadclaws.get(1).isSelected());
        dreadclaws.get(2).setLegal(dreadclaws.get(2).isSelected());
        dreadclaws.get(3).setAktiv(dreadclaws.get(0).isSelected() && dreadclaws.get(1).isSelected() && dreadclaws.get(2).isSelected());
        dreadclaws.get(0).setAktiv(true);
        dreadclaws.get(1).setAktiv(true);
        dreadclaws.get(2).setAktiv(true);

        aktualisiereKammerStarterLocation();

        //Forgeworldfreischaltungen
        boolean seuchis = false;
        boolean khornies = false;
        for (int i = 0; i < dreadclaws.size(); i++) {
            if (dreadclaws.get(i).isSelected()) {
                CSDreadclawKammer dc = (CSDreadclawKammer) dreadclaws.get(i).getKammer();
                if (dc.seuchis.isSelected()) {
                    seuchis = true;
                }
                if (dc.khornies.isSelected()) {
                    khornies = true;
                }
            }
        }
        if (seuchis) {
            setInformationVectorValue("CMDreadPlague", 1);
        } else {
            setInformationVectorValue("CMDreadPlague", 0);
        }

        if (khornies) {
            setInformationVectorValue("CMDreadBerserker", 1);
        } else {
            setInformationVectorValue("CMDreadBerserker", 0);
        }

        if (getCountFromInformationVector("CMDreadPlague") > 0 || getCountFromInformationVector("CMPlague") > 0) {
            BuildaHQ.getChooserGruppe(4).addSpezialAuswahl("[Forgeworld] Blight Drones of Nurgle");
            BuildaHQ.getChooserGruppe(2).addSpezialAuswahl("[Forgeworld] Plague Ogryns");
            BuildaHQ.getChooserGruppe(5).addSpezialAuswahl("[Forgeworld] Plague Hulk of Nurgle");
        } else {
            BuildaHQ.getChooserGruppe(4).removeSpezialAuswahl("[Forgeworld] Blight Drones of Nurgle");
            BuildaHQ.getChooserGruppe(2).removeSpezialAuswahl("[Forgeworld] Plague Ogryns");
            BuildaHQ.getChooserGruppe(5).removeSpezialAuswahl("[Forgeworld] Plague Hulk of Nurgle");
        }
        if (getCountFromInformationVector("CMDreadBerserker") > 0 || getCountFromInformationVector("CMBerserker") > 0) {
            BuildaHQ.getChooserGruppe(5).addSpezialAuswahl("[Forgeworld] Blood Slaughterer of Khorne");
        } else {
            BuildaHQ.getChooserGruppe(5).removeSpezialAuswahl("[Forgeworld] Blood Slaughterer of Khorne");
        }
    }

    //Entfernt aus dem Vektor alle überzähligen nicht ausgewählten Einträge.
    //Fügt einen neuen auswählbaren Eintrag hinter dem letzten der gleichen Einheit ein, falls alle ausgewählt wurden.
    public void adjustOptions(Vector<RuestkammerStarter> starter, int minOptions, String unit, String unitName, int offset, int einrueck) {


        for (int i = 0; i < starter.size() - 1 && starter.size() > (minOptions + 1); i++) {
            if (!starter.get(i).isSelected()) {
                remove(starter.get(i));
                starter.remove(i);
                i--;
            }
        }

        if (starter.lastElement().isSelected()) {
            RuestkammerStarter ruest = new RuestkammerStarter(ID, randAbstand, cnt, unit, unitName, einrueck);
            starter.add(ruest);
            ruest.initKammer();
            addAt(ruest, offset + starter.size() - 1);
            ruest.setButtonText(unitName);
        }

    }

    @Override
    public void deleteYourself() {
        setInformationVectorValue("CMDreadPlague", 0);
        setInformationVectorValue("CMDreadBerserker", 0);

        if (getCountFromInformationVector("CMDreadPlague") > 0 || getCountFromInformationVector("CMPlague") > 0) {
            BuildaHQ.getChooserGruppe(4).addSpezialAuswahl("[Forgeworld] Blight Drones of Nurgle");
            BuildaHQ.getChooserGruppe(2).addSpezialAuswahl("[Forgeworld] Plague Ogryns");
            BuildaHQ.getChooserGruppe(5).addSpezialAuswahl("[Forgeworld] Plague Hulk of Nurgle");
        } else {
            BuildaHQ.getChooserGruppe(4).removeSpezialAuswahl("[Forgeworld] Blight Drones of Nurgle");
            BuildaHQ.getChooserGruppe(2).removeSpezialAuswahl("[Forgeworld] Plague Ogryns");
            BuildaHQ.getChooserGruppe(5).removeSpezialAuswahl("[Forgeworld] Plague Hulk of Nurgle");
        }
        if (getCountFromInformationVector("CMDreadBerserker") > 0 || getCountFromInformationVector("CMBerserker") > 0) {
            BuildaHQ.getChooserGruppe(5).addSpezialAuswahl("[Forgeworld] Blood Slaughterer of Khorne");
        } else {
            BuildaHQ.getChooserGruppe(5).removeSpezialAuswahl("[Forgeworld] Blood Slaughterer of Khorne");
        }
        super.deleteYourself();
    }

}

package oc.wh40k.units.dksr;

import oc.*;

public class DKSRDeathRiderCommandSquad extends RuestkammerVater {

    OptionsZaehlerGruppe o2;
    OptionsZaehlerGruppe o3;
    OptionsEinzelUpgrade oe1;
    OptionsEinzelUpgrade oe2;
    OptionsEinzelUpgrade oe3;
    OptionsEinzelUpgrade oe4;
    OptionsEinzelUpgrade oe5;
    OptionsEinzelUpgrade oe6;
    boolean colBool = false;
    boolean stdBool = false;
    boolean uniqueError;
    boolean stdError;

    public DKSRDeathRiderCommandSquad() {
        name = "Death Rider Command Squad";
        grundkosten = 100;
    }

    public void initButtons(boolean... defaults) {
        add(ico = new oc.Picture("oc/wh40k/images/IGCompanyCommandSquad.jpg"));

        seperator();

        add(oe6 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Regimental Standard", 0));

        seperator();

        add(oe1 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Squadron Commander", 0));

        seperator(5);

        ogE.addElement(new OptionsGruppeEintrag("Bolt pistol", 1));
        ogE.addElement(new OptionsGruppeEintrag("Plasma pistol", 15));
        ogE.addElement(new OptionsGruppeEintrag("Power weapon", 10));
        ogE.addElement(new OptionsGruppeEintrag("Power sword", 10));
        ogE.addElement(new OptionsGruppeEintrag("Power axe", 10));
        ogE.addElement(new OptionsGruppeEintrag("Power maul", 10));
        ogE.addElement(new OptionsGruppeEintrag("Power lance", 10));
        add(new OptionsZaehlerGruppe(ID, randAbstand, cnt, "option", ogE, 2));

        seperator(5);

        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Demolition Charge", 20));
        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Melta bombs", 5));

        seperator();

        add(oe3 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Commissar", 35));

        seperator(5);

        ogE.addElement(new OptionsGruppeEintrag("Bolt pistol", 1));
        ogE.addElement(new OptionsGruppeEintrag("Plasma pistol", 15));
        ogE.addElement(new OptionsGruppeEintrag("Power weapon", 10));
        ogE.addElement(new OptionsGruppeEintrag("Power sword", 10));
        ogE.addElement(new OptionsGruppeEintrag("Power axe", 10));
        ogE.addElement(new OptionsGruppeEintrag("Power maul", 10));
        ogE.addElement(new OptionsGruppeEintrag("Power lance", 10));
        add(o2 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "option", ogE, 2));

        seperator();

        add(oe2 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Colonel", 50));

        seperator(5);

        ogE.addElement(new OptionsGruppeEintrag("Bolt pistol", 1));
        ogE.addElement(new OptionsGruppeEintrag("Plasma pistol", 15));
        ogE.addElement(new OptionsGruppeEintrag("Power weapon", 10));
        ogE.addElement(new OptionsGruppeEintrag("Power sword", 10));
        ogE.addElement(new OptionsGruppeEintrag("Power axe", 10));
        ogE.addElement(new OptionsGruppeEintrag("Power maul", 10));
        ogE.addElement(new OptionsGruppeEintrag("Power lance", 10));
        add(o3 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "option", ogE, 2));

        seperator(5);

        add(oe4 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Demolition Charge", 20));
        add(oe5 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Melta bombs", 5));

        sizeSetzen();
    }

    @Override
    public void refreshen() {
        oe1.setSelected(true);

        o2.setAktiv(oe3.isSelected());

        o3.setAktiv(oe2.isSelected());
        oe4.setAktiv(oe2.isSelected());
        oe5.setAktiv(oe2.isSelected());

        if (oe6.isSelected()) {
            if (stdBool == false) {
                stdBool = true;
                BuildaHQ.addToInformationVectorGlobal("DKSRStd", 1);
            }
        } else {
            if (stdBool == true) {
                stdBool = false;
                BuildaHQ.addToInformationVectorGlobal("DKSRStd", -1);
            }
        }

        if (oe2.isSelected()) {
            if (colBool == false) {
                colBool = true;
                BuildaHQ.addToInformationVectorGlobal("DKSRColonel", 1);
            }
        } else {
            if (colBool == true) {
                colBool = false;
                BuildaHQ.addToInformationVectorGlobal("DKSRColonel", -1);
            }
        }

        if (BuildaHQ.getCountFromInformationVectorGlobal("DKSRColonel") > 1) {
            uniqueError = true;
        } else {
            uniqueError = false;
        }

        if (BuildaHQ.getCountFromInformationVectorGlobal("DKSRStd") > 1) {
            stdError = true;
        } else {
            stdError = false;
        }

    }

    public void deleteYourself() {

        if (colBool == true) {
            colBool = false;
            BuildaHQ.addToInformationVectorGlobal("DKSRColonel", -1);
        }

        if (stdBool == true) {
            stdBool = false;
            BuildaHQ.addToInformationVectorGlobal("DKSRStd", -1);
        }

        super.deleteYourself();
    }
}

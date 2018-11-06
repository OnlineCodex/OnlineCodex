package oc.wh40k.units.ec;

import oc.*;

import java.util.Vector;

public class ECCorsairPrince extends Eintrag {

    OptionsUpgradeGruppe o1;
    OptionsUpgradeGruppe o2;
    OptionsUpgradeGruppe o3;
    OptionsUpgradeGruppe o4;
    OptionsUpgradeGruppe o5;
    OptionsUpgradeGruppe o6;
    OptionsEinzelUpgrade jetpack;
    OptionsEinzelUpgrade dancer;

    boolean seelenstein = false;
    boolean phönixjuwel = false;
    boolean jagdgewehr = false;
    boolean schwinge = false;
    boolean feuersäbel = false;
    boolean bruchstück = false;
    boolean bogen = false;
    boolean kussBool = false;
    boolean armorBool = false;
    boolean animusBool = false;
    boolean archangelBool = false;
    boolean helmBool = false;
    boolean djinBool = false;

    public ECCorsairPrince() {
        name = "Corsair Prince";
        grundkosten = 75;

        add(ico = new oc.Picture("oc/wh40k/images/ECCorsairPrince.jpg"));

        seperator();

        add(dancer = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Cloud Dancer", 15));
        ogE.addElement(new OptionsGruppeEintrag("TL Lasblaster", 0));
        ogE.addElement(new OptionsGruppeEintrag("TL Shuriken catapult", 0));
        ogE.addElement(new OptionsGruppeEintrag("TL Splinter rifles", 0));
        add(o4 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "option", ogE));

        seperator();

        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Wild Psyker", 15));

        seperator();

        add(jetpack = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Corsair Jet Pack", 5));

        seperator();

        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Haywire Grenades", 15));
        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Tanglefield Grenades", 10));
        ogE.addElement(new OptionsGruppeEintrag("Power weapon", 15));
        ogE.addElement(new OptionsGruppeEintrag("Power sword", 15));
        ogE.addElement(new OptionsGruppeEintrag("Power axe", 15));
        ogE.addElement(new OptionsGruppeEintrag("Power maul", 15));
        ogE.addElement(new OptionsGruppeEintrag("Power lance", 15));
        add(o3 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Venom blade", 10));
        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Blast pistol", 20));
        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Fusion pistol", 20));
        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Dissonance pistol", 10));
        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Void sabre", 20));
        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Balelight", 15));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Voidplate harness", 15));
        ogE.addElement(new OptionsGruppeEintrag("Ghostplate armour", 10));
        add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Shimmershield", 15));
        ogE.addElement(new OptionsGruppeEintrag("Forceshield", 10));
        ogE.addElement(new OptionsGruppeEintrag("Shadowfield", 25));
        add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Seeker of Forbidden Pleasures", 0));//Jetbikes, infantry, jet pack may select combat drugs for 15
        ogE.addElement(new OptionsGruppeEintrag("Traveller of Forgotten Paths", 0)); // Multiphase Key generator: may be purchases for 25 by other chars of the same dt
        ogE.addElement(new OptionsGruppeEintrag("Collector of Ancient Treasures", 0));//TODO may select one artifact of ELITE, DE, HQ, other chars of the dt may upgrade one weapon to a master-crafted for 10
        ogE.addElement(new OptionsGruppeEintrag("Reaper of the Outer Dark", 0));//Jetbikes, infantry, jet pack may select the rage SR for 0
        ogE.addElement(new OptionsGruppeEintrag("Wielder of Profane Powers", 0));
        ogE.addElement(new OptionsGruppeEintrag("Survivor of Endless Darkness", 0));//other chars of the dt may take the FNP(5+) SR for 10
        add(o5 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

        seperator();
        ogE = new Vector<OptionsGruppeEintrag>();
        ogE.addElement(new OptionsGruppeEintrag("Kuss des Parasiten", 5));
        ogE.addElement(new OptionsGruppeEintrag("Rüstung des Elends", 15));
        ogE.addElement(new OptionsGruppeEintrag("Animus Vitae", 20));
        ogE.addElement(new OptionsGruppeEintrag("Engel der Qualen", 25));
        ogE.addElement(new OptionsGruppeEintrag("Helm der Verachtung", 25));
        ogE.addElement(new OptionsGruppeEintrag("Dschinnklinge", 30));
        ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Seelenstein von Anath'lan"), 15));
        ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Das Phönix-Juwel"), 25));
        ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Kurnous Bogen"), 10));
        ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Jagdgewehr des Uldanoreth"), 25));
        ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Faolchús Schwinge"), 30));
        ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Feuersäbel"), 30));
        ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Bruchstück von Anaris"), 40));
        add(o6 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));

        complete();
    }

    @Override
    public void refreshen() {
        o4.setAktiv(dancer.isSelected());

        if (!o4.isSelected()) {
            o4.setSelected(0, true);
        }

        dancer.setAktiv(!jetpack.isSelected());
        jetpack.setAktiv(!dancer.isSelected());

        o6.setAktiv(o5.isSelected(2));

        setInformationVectorValue("ECPrinceTrait", o5.getSelectedIndex());

        //Einzigartige Gegenstände
        if (o6.isSelected("Kuss des Parasiten")) {
            if (kussBool == false) {
                kussBool = true;
                BuildaHQ.addToInformationVectorGlobal("DEKuss", 1);
            }
        } else if (!o6.isSelected("Kuss des Parasiten")) {
            if (kussBool == true) {
                kussBool = false;
                BuildaHQ.addToInformationVectorGlobal("DEKuss", -1);
            }
        }

        if (o6.isSelected("Rüstung des Elends")) {
            if (armorBool == false) {
                armorBool = true;
                BuildaHQ.addToInformationVectorGlobal("DEArmour", 1);
            }
        } else if (!o6.isSelected("Rüstung des Elends")) {
            if (armorBool == true) {
                armorBool = false;
                BuildaHQ.addToInformationVectorGlobal("DEArmour", -1);
            }
        }

        if (o6.isSelected("Animus Vitae")) {
            if (animusBool == false) {
                animusBool = true;
                BuildaHQ.addToInformationVectorGlobal("DEAnimus", 1);
            }
        } else if (!o6.isSelected("Animus Vitae")) {
            if (animusBool == true) {
                animusBool = false;
                BuildaHQ.addToInformationVectorGlobal("DEAnimus", -1);
            }
        }

        if (o6.isSelected("Engel der Qualen")) {
            if (archangelBool == false) {
                archangelBool = true;
                BuildaHQ.addToInformationVectorGlobal("DEEngel", 1);
            }
        } else if (!o6.isSelected("Engel der Qualen")) {
            if (archangelBool == true) {
                archangelBool = false;
                BuildaHQ.addToInformationVectorGlobal("DEEngel", -1);
            }
        }

        if (o6.isSelected("Helm der Verachtung")) {
            if (helmBool == false) {
                helmBool = true;
                BuildaHQ.addToInformationVectorGlobal("DEHelm", 1);
            }
        } else if (!o6.isSelected("Helm der Verachtung")) {
            if (helmBool == true) {
                helmBool = false;
                BuildaHQ.addToInformationVectorGlobal("DEHelm", -1);
            }
        }

        if (o6.isSelected("Dschinnklinge")) {
            if (djinBool == false) {
                djinBool = true;
                BuildaHQ.addToInformationVectorGlobal("DEDjin", 1);
            }
        } else if (!o6.isSelected("Dschinnklinge")) {
            if (djinBool == true) {
                djinBool = false;
                BuildaHQ.addToInformationVectorGlobal("DEDjin", -1);
            }
        }

        if (o6.isSelected("Seelenstein von Anath'lan")) {
            if (seelenstein == false) {
                seelenstein = true;
                BuildaHQ.addToInformationVectorGlobal("ELSeelenstein", 1);
            }
        } else if (!o6.isSelected("Seelenstein von Anath'lan")) {
            if (seelenstein == true) {
                seelenstein = false;
                BuildaHQ.addToInformationVectorGlobal("ELSeelenstein", -1);
            }
        }

        if (o6.isSelected("Das Phönix-Juwel")) {
            if (phönixjuwel == false) {
                phönixjuwel = true;
                BuildaHQ.addToInformationVectorGlobal("ELJuwel", 1);
            }
        } else if (!o6.isSelected("Das Phönix-Juwel")) {
            if (phönixjuwel == true) {
                phönixjuwel = false;
                BuildaHQ.addToInformationVectorGlobal("ELJuwel", -1);
            }
        }

        if (o6.isSelected("Jagdgewehr des Uldanoreth")) {
            if (jagdgewehr == false) {
                jagdgewehr = true;
                BuildaHQ.addToInformationVectorGlobal("ELJagd", 1);
            }
        } else if (!o6.isSelected("Jagdgewehr des Uldanoreth")) {
            if (jagdgewehr == true) {
                jagdgewehr = false;
                BuildaHQ.addToInformationVectorGlobal("ELJagd", -1);
            }
        }

        if (o6.isSelected("Faolchús Schwinge")) {
            if (schwinge == false) {
                schwinge = true;
                BuildaHQ.addToInformationVectorGlobal("ELSchwinge", 1);
            }
        } else if (!o6.isSelected("Faolchús Schwinge")) {
            if (schwinge == true) {
                schwinge = false;
                BuildaHQ.addToInformationVectorGlobal("ELSchwinge", -1);
            }
        }

        if (o6.isSelected("Feuersäbel")) {
            if (feuersäbel == false) {
                feuersäbel = true;
                BuildaHQ.addToInformationVectorGlobal("ELFeuer", 1);
            }
        } else if (!o6.isSelected("Feuersäbel")) {
            if (feuersäbel == true) {
                feuersäbel = false;
                BuildaHQ.addToInformationVectorGlobal("ELFeuer", -1);
            }
        }

        if (o6.isSelected("Bruchstück von Anaris")) {
            if (bruchstück == false) {
                bruchstück = true;
                BuildaHQ.addToInformationVectorGlobal("ELBruch", 1);
            }
        } else if (!o6.isSelected("Bruchstück von Anaris")) {
            if (bruchstück == true) {
                bruchstück = false;
                BuildaHQ.addToInformationVectorGlobal("ELBruch", -1);
            }
        }

        if (o6.isSelected("Kurnous Bogen")) {
            if (bogen == false) {
                bogen = true;
                BuildaHQ.addToInformationVectorGlobal("ELBogen", 1);
            }
        } else if (!o6.isSelected("Kurnous Bogen")) {
            if (bogen == true) {
                bogen = false;
                BuildaHQ.addToInformationVectorGlobal("ELBogen", -1);
            }
        }

        if (BuildaHQ.getCountFromInformationVectorGlobal("ELSeelenstein") > 1 ||
                BuildaHQ.getCountFromInformationVectorGlobal("ELJuwel") > 1 ||
                BuildaHQ.getCountFromInformationVectorGlobal("ELJagd") > 1 ||
                BuildaHQ.getCountFromInformationVectorGlobal("ELSchwinge") > 1 ||
                BuildaHQ.getCountFromInformationVectorGlobal("ELFeuer") > 1 ||
                BuildaHQ.getCountFromInformationVectorGlobal("ELBruch") > 1 ||
                BuildaHQ.getCountFromInformationVectorGlobal("ELBogen") > 1 ||
                BuildaHQ.getCountFromInformationVectorGlobal("DEKuss") > 1 ||
                BuildaHQ.getCountFromInformationVectorGlobal("DEArmour") > 1 ||
                BuildaHQ.getCountFromInformationVectorGlobal("DEHelm") > 1 ||
                BuildaHQ.getCountFromInformationVectorGlobal("DEAnimus") > 1 ||
                BuildaHQ.getCountFromInformationVectorGlobal("DEEngel") > 1 ||
                BuildaHQ.getCountFromInformationVectorGlobal("DEHelm") > 1 ||
                BuildaHQ.getCountFromInformationVectorGlobal("DEDjin") > 1) {
            if (getFehlermeldung().equals("")) {
                setFehlermeldung("Doppeltes Artefakt");
                RefreshListener.fireRefresh();
            }
        } else {
            if (!getFehlermeldung().equals("")) {
                setFehlermeldung("");
                RefreshListener.fireRefresh();
            }
        }

    }

    @Override
    public void deleteYourself() {
        super.deleteYourself();

        setInformationVectorValue("ECPrinceTrait", -1);

        if (seelenstein == true) {
            seelenstein = false;
            BuildaHQ.addToInformationVectorGlobal("ELSeelenstein", -1);
        }

        if (phönixjuwel == true) {
            phönixjuwel = false;
            BuildaHQ.addToInformationVectorGlobal("ELJuwel", -1);
        }

        if (jagdgewehr == true) {
            jagdgewehr = false;
            BuildaHQ.addToInformationVectorGlobal("ELJagd", -1);
        }

        if (schwinge == true) {
            schwinge = false;
            BuildaHQ.addToInformationVectorGlobal("ELSchwinge", -1);
        }

        if (feuersäbel == true) {
            feuersäbel = false;
            BuildaHQ.addToInformationVectorGlobal("ELFeuer", -1);
        }

        if (bruchstück == true) {
            bruchstück = false;
            BuildaHQ.addToInformationVectorGlobal("ELBruch", -1);
        }

        if (bogen == true) {
            bogen = false;
            BuildaHQ.addToInformationVectorGlobal("ELBogen", -1);
        }

        if (kussBool == true) {
            kussBool = false;
            BuildaHQ.addToInformationVectorGlobal("DEKuss", -1);
        }

        if (armorBool == true) {
            armorBool = false;
            BuildaHQ.addToInformationVectorGlobal("DEArmour", -1);
        }

        if (helmBool == true) {
            helmBool = false;
            BuildaHQ.addToInformationVectorGlobal("DEHelm", -1);
        }

        if (animusBool == true) {
            animusBool = false;
            BuildaHQ.addToInformationVectorGlobal("DEAnimus", -1);
        }

        if (archangelBool == true) {
            archangelBool = false;
            BuildaHQ.addToInformationVectorGlobal("DEEngel", -1);
        }

        if (helmBool == true) {
            helmBool = false;
            BuildaHQ.addToInformationVectorGlobal("DEHelm", -1);
        }

        if (djinBool == true) {
            djinBool = false;
            BuildaHQ.addToInformationVectorGlobal("DEDjin", -1);
        }
    }

}

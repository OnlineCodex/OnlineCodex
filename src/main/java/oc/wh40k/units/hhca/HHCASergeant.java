package oc.wh40k.units.hhca;

import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.OptionsZaehlerGruppe;
import oc.RuestkammerVater;

public class HHCASergeant extends RuestkammerVater {

    OptionsUpgradeGruppe o1a, o1b, o1c, o1d, o2a, o2b, o2c, o3a, o3b, o3c, o4a, o4b, o5a, o5b, o5c, o5d, o5e,
            o6a, o6b, o6c, o7a, o7b, o7c, o8a, o8b, o8c, o8d, o9a, o9b, o10a, o10b, o10c, o10d,
            o11a, o11b, o11c, o11d, o12a, o12b, o12c;
    OptionsZaehlerGruppe o4c;

    boolean isAssault = false;
    boolean isBike = false;
    boolean isBreacher = false;
    boolean isDestroyer = false;
    boolean isHeavy = false;
    boolean isReaver = false;
    boolean isReco = false;
    boolean isSeeker = false;
    boolean isSupport = false;
    boolean isTactical = false;
    boolean isTerminator = false;
    boolean isVeteran = false;

    public HHCASergeant() {
        grundkosten = 0;
    }

    @Override
    public void initButtons(boolean... defaults) {

        if (defaults[0]) isAssault = true;
        if (defaults[1]) isBike = true;
        if (defaults[2]) isBreacher = true;
        if (defaults[3]) isDestroyer = true;
        if (defaults[4]) isHeavy = true;
        if (defaults[5]) isReaver = true;
        if (defaults[6]) isReco = true;
        if (defaults[7]) isSeeker = true;
        if (defaults[8]) isSupport = true;
        if (defaults[9]) isTactical = true;
        if (defaults[10]) isTerminator = true;
        if (defaults[11]) isVeteran = true;

        if (isAssault) {

            seperator();
            ogE.addElement(new OptionsGruppeEintrag("Bolt pistol", 0));
            ogE.addElement(new OptionsGruppeEintrag("Hand flamer", 10));
            ogE.addElement(new OptionsGruppeEintrag("Plasma pistol", 15));
            add(o1a = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

            seperator();
            ogE.addElement(new OptionsGruppeEintrag("Chainsword", 0));
            ogE.addElement(new OptionsGruppeEintrag("Power weapon", 10));
            ogE.addElement(new OptionsGruppeEintrag("Power fist", 15));
            ogE.addElement(new OptionsGruppeEintrag("Single lightning claw", 15));
            ogE.addElement(new OptionsGruppeEintrag("Thunder hammer", 20));
            add(o1b = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

            seperator();
            ogE.addElement(new OptionsGruppeEintrag("Pair of lightning claws", 20));
            add(o1c = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

            seperator();
            ogE.addElement(new OptionsGruppeEintrag("Melta-bombs", 5));
            ogE.addElement(new OptionsGruppeEintrag("Combat shield", 3));
            ogE.addElement(new OptionsGruppeEintrag("Artificer armour", 10));
            add(o1d = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 3));
        } else if (isBike) {

            seperator();
            ogE.addElement(new OptionsGruppeEintrag("Bolt pistol", 0));
            ogE.addElement(new OptionsGruppeEintrag("Hand flamer", 10));
            ogE.addElement(new OptionsGruppeEintrag("Plasma pistol", 15));
            add(o2a = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

            seperator();
            ogE.addElement(new OptionsGruppeEintrag("Chainsword", 0));
            ogE.addElement(new OptionsGruppeEintrag("Power weapon", 10));
            ogE.addElement(new OptionsGruppeEintrag("Power fist", 15));
            ogE.addElement(new OptionsGruppeEintrag("Single lightning claw", 15));
            add(o2b = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

            seperator();
            ogE.addElement(new OptionsGruppeEintrag("Melta-bombs", 5));
            add(o2c = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
        } else if (isBreacher) {

            seperator();
            ogE.addElement(new OptionsGruppeEintrag("Bolter", 0));
            ogE.addElement(new OptionsGruppeEintrag("Combi-flamer", 10));
            ogE.addElement(new OptionsGruppeEintrag("Combi-melta", 10));
            ogE.addElement(new OptionsGruppeEintrag("Combi-plasma", 10));
            ogE.addElement(new OptionsGruppeEintrag("Plasma pistol", 15));
            add(o3a = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

            seperator();
            ogE.addElement(new OptionsGruppeEintrag("Power weapon", 10));
            ogE.addElement(new OptionsGruppeEintrag("Power fist", 15));
            ogE.addElement(new OptionsGruppeEintrag("Single lightning claw", 15));
            ogE.addElement(new OptionsGruppeEintrag("Thunder hammer", 20));
            add(o3b = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

            seperator();
            ogE.addElement(new OptionsGruppeEintrag("Breaching charge", 10));
            ogE.addElement(new OptionsGruppeEintrag("Melta-bombs", 5));
            ogE.addElement(new OptionsGruppeEintrag("Artificer armour", 10));
            add(o3c = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 3));
        } else if (isDestroyer) {

            seperator();
            ogE.addElement(new OptionsGruppeEintrag("Chainsword", 0));
            ogE.addElement(new OptionsGruppeEintrag("Power weapon", 10));
            ogE.addElement(new OptionsGruppeEintrag("Power fist", 15));
            ogE.addElement(new OptionsGruppeEintrag("Single lightning claw", 15));
            ogE.addElement(new OptionsGruppeEintrag("Thunder hammer", 20));
            add(o4a = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

            seperator();
            ogE.addElement(new OptionsGruppeEintrag("Artificer armour", 10));
            add(o4b = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

            ogE.addElement(new OptionsGruppeEintrag("Phosphex bomb", 10));
            add(o4c = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 3));
        } else if (isHeavy) {

            seperator();
            ogE.addElement(new OptionsGruppeEintrag("Heavy bolter", 0));
            ogE.addElement(new OptionsGruppeEintrag("Heavy flamer", 0));
            ogE.addElement(new OptionsGruppeEintrag("Auto-cannon", 5));
            ogE.addElement(new OptionsGruppeEintrag("Missile launcher", 5));
            ogE.addElement(new OptionsGruppeEintrag("Multi-melta", 10));
            ogE.addElement(new OptionsGruppeEintrag("Plasma cannon", 15));
            ogE.addElement(new OptionsGruppeEintrag("Volkite Culverin", 10));
            ogE.addElement(new OptionsGruppeEintrag("Lascannon", 20));
            add(o5a = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

            seperator();
            ogE.addElement(new OptionsGruppeEintrag("Chainsword & nuncio-vox", 0));
            ogE.addElement(new OptionsGruppeEintrag("Power weapon & nuncio-vox", 10));
            ogE.addElement(new OptionsGruppeEintrag("Power fist & nuncio-vox", 15));
            add(o5b = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

            seperator();
            ogE.addElement(new OptionsGruppeEintrag("Bolter", 2));
            ogE.addElement(new OptionsGruppeEintrag("Combi-flamer", 10));
            ogE.addElement(new OptionsGruppeEintrag("Combi-melta", 10));
            ogE.addElement(new OptionsGruppeEintrag("Combi-plasma", 10));
            add(o5c = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

            seperator();
            ogE.addElement(new OptionsGruppeEintrag("Bolt pistol", 0));
            ogE.addElement(new OptionsGruppeEintrag("Plasma pistol", 15));
            add(o5d = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

            seperator();
            ogE.addElement(new OptionsGruppeEintrag("Artificer armour", 10));
            ogE.addElement(new OptionsGruppeEintrag("Augury scanner", 5));
            ogE.addElement(new OptionsGruppeEintrag("Melta-bombs", 5));
            add(o5e = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 3));
        } else if (isReaver) {

            seperator();
            ogE.addElement(new OptionsGruppeEintrag("Boltgun", "Boltgun with Banestrike shells", 5));
            ogE.addElement(new OptionsGruppeEintrag("Volkite charger", 7));
            ogE.addElement(new OptionsGruppeEintrag("Combi-flamer", "Combi-flamer with Banestrike shells", 10));
            ogE.addElement(new OptionsGruppeEintrag("Combi-melta", "Combi-melta with Banestrike shells", 10));
            ogE.addElement(new OptionsGruppeEintrag("Combi-plasma", "Combi-plasma with Banestrike shells", 10));
            add(o12a = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

            seperator();
            ogE.addElement(new OptionsGruppeEintrag("Chainsword", 0));
            ogE.addElement(new OptionsGruppeEintrag("Chain axe", 1));
            ogE.addElement(new OptionsGruppeEintrag("Power weapon", 10));
            ogE.addElement(new OptionsGruppeEintrag("Power fist", 15));
            add(o12b = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

            seperator();
            ogE.addElement(new OptionsGruppeEintrag("Melta bombs", 5));
            ogE.addElement(new OptionsGruppeEintrag("Artificer armour", 10));
            ogE.addElement(new OptionsGruppeEintrag("Hand flamer", 5));
            add(o12c = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 3));
        } else if (isReco) {

            seperator();
            ogE.addElement(new OptionsGruppeEintrag("Chainsword", 0));
            ogE.addElement(new OptionsGruppeEintrag("Power weapon", 10));
            ogE.addElement(new OptionsGruppeEintrag("Power fist", 15));
            add(o6a = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

            seperator();
            ogE.addElement(new OptionsGruppeEintrag("Bolter", 0));
            ogE.addElement(new OptionsGruppeEintrag("Combi-flamer", 10));
            ogE.addElement(new OptionsGruppeEintrag("Combi-melta", 10));
            ogE.addElement(new OptionsGruppeEintrag("Combi-plasma", 10));
            ogE.addElement(new OptionsGruppeEintrag("Plasma pistol", 15));
            add(o6b = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

            seperator();
            ogE.addElement(new OptionsGruppeEintrag("Artificer armour", 10));
            add(o6c = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
        } else if (isSeeker) {

            seperator();
            ogE.addElement(new OptionsGruppeEintrag("Power weapon", 10));
            ogE.addElement(new OptionsGruppeEintrag("Power fist", 15));
            add(o7a = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

            seperator();
            ogE.addElement(new OptionsGruppeEintrag("Bolter", 0));
            ogE.addElement(new OptionsGruppeEintrag("Plasma pistol", 10));
            add(o7b = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

            seperator();
            ogE.addElement(new OptionsGruppeEintrag("Melta-bombs", 5));
            ogE.addElement(new OptionsGruppeEintrag("Artificer armour", 10));
            add(o7c = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 2));
        } else if (isSupport) {

            seperator();
            ogE.addElement(new OptionsGruppeEintrag("Bolt pistol", 0));
            ogE.addElement(new OptionsGruppeEintrag("Plasma pistol", 15));
            add(o8a = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

            seperator();
            ogE.addElement(new OptionsGruppeEintrag("Chainsword", 0));
            ogE.addElement(new OptionsGruppeEintrag("Power weapon", 10));
            ogE.addElement(new OptionsGruppeEintrag("Power fist", 15));
            ogE.addElement(new OptionsGruppeEintrag("Single lightning claw", 15));
            add(o8b = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

            seperator();
            ogE.addElement(new OptionsGruppeEintrag("Bolter", 2));
            ogE.addElement(new OptionsGruppeEintrag("Combi-flamer", 10));
            ogE.addElement(new OptionsGruppeEintrag("Combi-melta", 10));
            ogE.addElement(new OptionsGruppeEintrag("Combi-plasma", 10));
            ogE.addElement(new OptionsGruppeEintrag("Melta-bombs", 5));
            ogE.addElement(new OptionsGruppeEintrag("Augury scanner", 5));
            add(o8c = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

            ogE.addElement(new OptionsGruppeEintrag("Artificer armour", 10));
            add(o8d = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
        } else if (isTactical) {

            seperator();
            ogE.addElement(new OptionsGruppeEintrag("Bolter", 0));
            ogE.addElement(new OptionsGruppeEintrag("Combi-flamer", 10));
            ogE.addElement(new OptionsGruppeEintrag("Combi-melta", 10));
            ogE.addElement(new OptionsGruppeEintrag("Combi-plasma", 10));
            ogE.addElement(new OptionsGruppeEintrag("Plasma pistol", 15));
            ogE.addElement(new OptionsGruppeEintrag("Heavy chainsword", 5));
            ogE.addElement(new OptionsGruppeEintrag("Power weapon", 10));
            ogE.addElement(new OptionsGruppeEintrag("Power fist", 15));
            ogE.addElement(new OptionsGruppeEintrag("Single lightning claw", 15));
            add(o9a = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

            seperator();
            ogE.addElement(new OptionsGruppeEintrag("Melta-bombs", 5));
            ogE.addElement(new OptionsGruppeEintrag("Artificer armour", 10));
            add(o9b = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 2));
        } else if (isTerminator) {

            seperator();
            ogE.addElement(new OptionsGruppeEintrag("Combi-bolter", 0));
            ogE.addElement(new OptionsGruppeEintrag("Combi-flamer", 7));
            ogE.addElement(new OptionsGruppeEintrag("Combi-melta", 7));
            ogE.addElement(new OptionsGruppeEintrag("Combi-plasma", 7));
            ogE.addElement(new OptionsGruppeEintrag("Volkite charger", 7));
            add(o10a = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

            seperator();
            ogE.addElement(new OptionsGruppeEintrag("Power weapon", 0));
            ogE.addElement(new OptionsGruppeEintrag("Power fist", 5));
            ogE.addElement(new OptionsGruppeEintrag("Single lightning claw", 5));
            ogE.addElement(new OptionsGruppeEintrag("Chainfist", 10));
            ogE.addElement(new OptionsGruppeEintrag("Thunder hammer", 10));
            add(o10b = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

            seperator();
            ogE.addElement(new OptionsGruppeEintrag("Pair of lightning claw", 15));
            add(o10c = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

            seperator();
            ogE.addElement(new OptionsGruppeEintrag("Grenade harness", 10));
            add(o10d = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
        } else if (isVeteran) {

            seperator();
            ogE.addElement(new OptionsGruppeEintrag("Bolt pistol", 0));
            ogE.addElement(new OptionsGruppeEintrag("Volkite Serpenta", 5));
            add(o11a = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

            seperator();
            ogE.addElement(new OptionsGruppeEintrag("Chainsword", 0));
            ogE.addElement(new OptionsGruppeEintrag("Power weapon", 10));
            ogE.addElement(new OptionsGruppeEintrag("Power fist", 15));
            ogE.addElement(new OptionsGruppeEintrag("Single lightning claw", 15));
            ogE.addElement(new OptionsGruppeEintrag("Thunder hammer", 20));
            add(o11b = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

            seperator();
            ogE.addElement(new OptionsGruppeEintrag("Bolter", 0));
            ogE.addElement(new OptionsGruppeEintrag("Combi-flamer", 10));
            ogE.addElement(new OptionsGruppeEintrag("Combi-melta", 10));
            ogE.addElement(new OptionsGruppeEintrag("Combi-plasma", 10));
            ogE.addElement(new OptionsGruppeEintrag("Plasma pistol", 15));
            add(o11c = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

            seperator();
            ogE.addElement(new OptionsGruppeEintrag("Artificer armour", 10));
            add(o11d = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
        }


        sizeSetzen();
    }

    @Override
    public void refreshen() {
        if (isAssault) {
            o1a.setAktiv(!o1c.isSelected());
            o1b.setAktiv(!o1c.isSelected());
            if (!o1a.isSelected()) o1a.setSelected(0, true);
            if (!o1b.isSelected()) o1b.setSelected(0, true);
        } else if (isBike) {
            if (!o2a.isSelected()) o2a.setSelected(0, true);
            if (!o2b.isSelected()) o2b.setSelected(0, true);
        } else if (isBreacher) {
            if (!o3a.isSelected()) o3a.setSelected(0, true);
        } else if (isDestroyer) {
            if (!o4a.isSelected()) o4a.setSelected(0, true);
        } else if (isHeavy) {
            o5a.setAktiv(!o5b.isSelected());
            o5c.setAktiv(o5b.isSelected());
            o5d.setAktiv(o5b.isSelected());
            if (!o5a.isSelected() && !o5b.isSelected()) o5a.setSelected(0, true);
            //if(!o5b.isSelected()) o5a.setSelected(0, true);
            if (!o5d.isSelected()) o5d.setSelected(0, true);
        } else if (isReaver) {
            if (!o12b.isSelected()) o12b.setSelected(0, true);
        } else if (isReco) {
            if (!o6a.isSelected()) o6a.setSelected(0, true);
            if (!o6b.isSelected()) o6b.setSelected(0, true);
        } else if (isSeeker) {
            if (!o7b.isSelected()) o7b.setSelected(0, true);
        } else if (isSupport) {
            if (!o8a.isSelected()) o8a.setSelected(0, true);
            if (!o8b.isSelected()) o8b.setSelected(0, true);
        } else if (isTactical) {
            if (!o9a.isSelected()) o9a.setSelected(0, true);
        } else if (isTerminator) {
            o10a.setAktiv(!o10c.isSelected());
            o10b.setAktiv(!o10c.isSelected());
            if (!o10a.isSelected()) o10a.setSelected(0, true);
            if (!o10b.isSelected()) o10b.setSelected(0, true);
        } else if (isVeteran) {
            if (!o11a.isSelected()) o11a.setSelected(0, true);
            if (!o11b.isSelected()) o11b.setSelected(0, true);
            if (!o11c.isSelected()) o11c.setSelected(0, true);
        }
    }


}

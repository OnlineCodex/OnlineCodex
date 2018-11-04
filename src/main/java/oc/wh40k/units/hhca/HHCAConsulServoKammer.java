package oc.wh40k.units.hhca;

import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.OptionsZaehlerGruppe;
import oc.RuestkammerVater;

public class HHCAConsulServoKammer extends RuestkammerVater {

    OptionsUpgradeGruppe o1a, o1c, o1d, o1e, o1f, o1x, o1y,
            o2a, o2c, o2d, o2e, o2f, o2x, o2y,
            o3a, o3c, o3d, o3e, o3f, o3x, o3y,
            o4a, o4c, o4d, o4f, o4x, o4y,
            o5a, o5c, o5d, o5e, o5f, o5x, o5y,
            o6a, o6c, o6d, o6f, o6x, o6y;
    OptionsZaehlerGruppe o1b, o2b, o3b, o4b, o5b, o6b, o6z;

    boolean isCenturion = false;
    boolean isChampion = false;
    boolean isChaplain = false;
    boolean isForge = false;
    boolean isLibrarian = false;
    boolean isMaster = false;
    boolean isMoritat = false;
    boolean isPrimus = false;
    boolean isSiege = false;
    boolean isVigilator = false;

    public HHCAConsulServoKammer() {
        grundkosten = 0;
    }

    @Override
    public void initButtons(boolean... defaults) {

        if (defaults[0]) isCenturion = true;
        if (defaults[1]) isChampion = true;
        if (defaults[2]) isChaplain = true;
        if (defaults[3]) isForge = true;
        if (defaults[4]) isLibrarian = true;
        if (defaults[5]) isMaster = true;
        if (defaults[6]) isMoritat = true;
        if (defaults[7]) isPrimus = true;
        if (defaults[8]) isSiege = true;
        if (defaults[9]) isVigilator = true;

        if (isCenturion || isChampion || isChaplain || isPrimus || isSiege) {

            seperator();
            ogE.addElement(new OptionsGruppeEintrag("Bolter", 2));
            ogE.addElement(new OptionsGruppeEintrag("Combi-flamer", 10));
            ogE.addElement(new OptionsGruppeEintrag("Combi-melta", 10));
            ogE.addElement(new OptionsGruppeEintrag("Combi-plasma", 10));
            ogE.addElement(new OptionsGruppeEintrag("Volkite charger", 10));
            add(o1a = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

            seperator();
            ogE.addElement(new OptionsGruppeEintrag("Chainsword", 0));
            add(o1x = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
            o1x.setSelected(0, true);

            ogE.addElement(new OptionsGruppeEintrag("Bolt pistol", 0));
            add(o1y = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
            o1y.setSelected(0, true);

            seperator();
            ogE.addElement(new OptionsGruppeEintrag("Volkite Serpenta", 5));
            ogE.addElement(new OptionsGruppeEintrag("Plasma pistol", 15));
            ogE.addElement(new OptionsGruppeEintrag("Heavy chainsword", 10));
            ogE.addElement(new OptionsGruppeEintrag("Charnabal sabre", 10));
            ogE.addElement(new OptionsGruppeEintrag("Power weapon", 15));
            ogE.addElement(new OptionsGruppeEintrag("Power fist", 20));
            ogE.addElement(new OptionsGruppeEintrag("Single lightning claw", 20));
            ogE.addElement(new OptionsGruppeEintrag("Thunder hammer", 25));
            add(o1b = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 2));

            seperator();
            ogE.addElement(new OptionsGruppeEintrag("Pair of lightning claws", 25));
            add(o1c = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

            seperator();
            ogE.addElement(new OptionsGruppeEintrag("Melta-bombs", 5));
            ogE.addElement(new OptionsGruppeEintrag("Artificer armour", 10));
            ogE.addElement(new OptionsGruppeEintrag("Banestrike ammunition", 5));
            add(o1d = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 3));

            seperator();
            ogE.addElement(new OptionsGruppeEintrag("Combat shield", 5));
            ogE.addElement(new OptionsGruppeEintrag("Refractor field", 10));
            ogE.addElement(new OptionsGruppeEintrag("Boarding shield", 10));
            add(o1e = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

            seperator();
            ogE.addElement(new OptionsGruppeEintrag("Jump pack", 20));
            ogE.addElement(new OptionsGruppeEintrag("Space Marine bike", 25));
            ogE.addElement(new OptionsGruppeEintrag("Legion jetbike", 45));
            add(o1f = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
        } else if (isForge) {

            seperator();
            ogE.addElement(new OptionsGruppeEintrag("Bolter", 2));
            ogE.addElement(new OptionsGruppeEintrag("Combi-flamer", 10));
            ogE.addElement(new OptionsGruppeEintrag("Combi-melta", 10));
            ogE.addElement(new OptionsGruppeEintrag("Combi-plasma", 10));
            ogE.addElement(new OptionsGruppeEintrag("Volkite charger", 10));
            add(o2a = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

            seperator();
            ogE.addElement(new OptionsGruppeEintrag("Chainsword", 0));
            add(o2x = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
            o2x.setSelected(0, true);

            ogE.addElement(new OptionsGruppeEintrag("Bolt pistol", 0));
            add(o2y = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
            o2y.setSelected(0, true);

            seperator();
            ogE.addElement(new OptionsGruppeEintrag("Volkite Serpenta", 5));
            ogE.addElement(new OptionsGruppeEintrag("Plasma pistol", 15));
            ogE.addElement(new OptionsGruppeEintrag("Heavy chainsword", 10));
            ogE.addElement(new OptionsGruppeEintrag("Charnabal sabre", 10));
            ogE.addElement(new OptionsGruppeEintrag("Power weapon", 15));
            ogE.addElement(new OptionsGruppeEintrag("Power fist", 20));
            ogE.addElement(new OptionsGruppeEintrag("Single lightning claw", 20));
            ogE.addElement(new OptionsGruppeEintrag("Thunder hammer", 25));
            add(o2b = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 2));

            seperator();
            ogE.addElement(new OptionsGruppeEintrag("Pair of lightning claws", 25));
            add(o2c = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

            seperator();
            ogE.addElement(new OptionsGruppeEintrag("Melta-bombs", 5));
            ogE.addElement(new OptionsGruppeEintrag("Banestrike ammunition", 5));
            add(o2d = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 2));

            seperator();
            ogE.addElement(new OptionsGruppeEintrag("Combat shield", 5));
            ogE.addElement(new OptionsGruppeEintrag("Refractor field", 10));
            ogE.addElement(new OptionsGruppeEintrag("Boarding shield", 10));
            add(o2e = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

            seperator();
            ogE.addElement(new OptionsGruppeEintrag("Jump pack", 20));
            ogE.addElement(new OptionsGruppeEintrag("Space Marine bike", 25));
            ogE.addElement(new OptionsGruppeEintrag("Legion jetbike", 45));
            add(o2f = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
        } else if (isLibrarian) {

            seperator();
            ogE.addElement(new OptionsGruppeEintrag("Bolter", 2));
            ogE.addElement(new OptionsGruppeEintrag("Combi-flamer", 10));
            ogE.addElement(new OptionsGruppeEintrag("Combi-melta", 10));
            ogE.addElement(new OptionsGruppeEintrag("Combi-plasma", 10));
            ogE.addElement(new OptionsGruppeEintrag("Volkite charger", 10));
            add(o3a = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

            seperator();
            ogE.addElement(new OptionsGruppeEintrag("Force axe", 0));
            ogE.addElement(new OptionsGruppeEintrag("Force stave", 0));
            ogE.addElement(new OptionsGruppeEintrag("Force sword", 0));
            add(o3x = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
            o3x.setSelected(0, true);

            ogE.addElement(new OptionsGruppeEintrag("Bolt pistol", 0));
            add(o3y = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
            o3y.setSelected(0, true);

            seperator();
            ogE.addElement(new OptionsGruppeEintrag("Volkite Serpenta", 5));
            ogE.addElement(new OptionsGruppeEintrag("Plasma pistol", 15));
            ogE.addElement(new OptionsGruppeEintrag("Heavy chainsword", 10));
            ogE.addElement(new OptionsGruppeEintrag("Charnabal sabre", 10));
            ogE.addElement(new OptionsGruppeEintrag("Power weapon", 15));
            ogE.addElement(new OptionsGruppeEintrag("Power fist", 20));
            ogE.addElement(new OptionsGruppeEintrag("Single lightning claw", 20));
            ogE.addElement(new OptionsGruppeEintrag("Thunder hammer", 25));
            add(o3b = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 2));

            seperator();
            ogE.addElement(new OptionsGruppeEintrag("Melta-bombs", 5));
            ogE.addElement(new OptionsGruppeEintrag("Artificer armour", 10));
            ogE.addElement(new OptionsGruppeEintrag("Banestrike ammunition", 5));
            add(o3c = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 3));

            seperator();
            ogE.addElement(new OptionsGruppeEintrag("Combat shield", 5));
            ogE.addElement(new OptionsGruppeEintrag("Refractor field", 10));
            ogE.addElement(new OptionsGruppeEintrag("Boarding shield", 10));
            add(o3d = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

            seperator();
            ogE.addElement(new OptionsGruppeEintrag("Jump pack", 20));
            ogE.addElement(new OptionsGruppeEintrag("Space Marine bike", 25));
            ogE.addElement(new OptionsGruppeEintrag("Legion jetbike", 45));
            add(o3e = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
        } else if (isMaster) {

            seperator();
            ogE.addElement(new OptionsGruppeEintrag("Volkite charger", 10));
            add(o4a = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

            seperator();
            ogE.addElement(new OptionsGruppeEintrag("Chainsword", 0));
            add(o4x = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
            o4x.setSelected(0, true);

            ogE.addElement(new OptionsGruppeEintrag("Bolt pistol", 0));
            add(o4y = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
            o4y.setSelected(0, true);

            seperator();
            ogE.addElement(new OptionsGruppeEintrag("Volkite Serpenta", 5));
            ogE.addElement(new OptionsGruppeEintrag("Plasma pistol", 15));
            ogE.addElement(new OptionsGruppeEintrag("Heavy chainsword", 10));
            ogE.addElement(new OptionsGruppeEintrag("Charnabal sabre", 10));
            ogE.addElement(new OptionsGruppeEintrag("Power weapon", 15));
            add(o4b = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 2));

            seperator();
            ogE.addElement(new OptionsGruppeEintrag("Melta-bombs", 5));
            ogE.addElement(new OptionsGruppeEintrag("Artificer armour", 10));
            add(o4c = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 2));

            seperator();
            ogE.addElement(new OptionsGruppeEintrag("Combat shield", 5));
            ogE.addElement(new OptionsGruppeEintrag("Refractor field", 10));
            add(o4d = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

            seperator();
            ogE.addElement(new OptionsGruppeEintrag("Jump pack", 20));
            add(o4f = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
        } else if (isVigilator) {

            seperator();
            ogE.addElement(new OptionsGruppeEintrag("Bolter", 2));
            ogE.addElement(new OptionsGruppeEintrag("Volkite charger", 10));
            add(o5a = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

            seperator();
            ogE.addElement(new OptionsGruppeEintrag("Chainsword", 0));
            add(o5x = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
            o5x.setSelected(0, true);

            ogE.addElement(new OptionsGruppeEintrag("Bolt pistol", 0));
            add(o5y = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
            o5y.setSelected(0, true);

            seperator();
            ogE.addElement(new OptionsGruppeEintrag("Volkite Serpenta", 5));
            ogE.addElement(new OptionsGruppeEintrag("Plasma pistol", 15));
            ogE.addElement(new OptionsGruppeEintrag("Heavy chainsword", 10));
            ogE.addElement(new OptionsGruppeEintrag("Charnabal sabre", 10));
            ogE.addElement(new OptionsGruppeEintrag("Power weapon", 15));
            add(o5b = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 2));

            seperator();
            ogE.addElement(new OptionsGruppeEintrag("Melta-bombs", 5));
            ogE.addElement(new OptionsGruppeEintrag("Banestrike ammunition", 5));
            add(o5c = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 2));
            ogE.addElement(new OptionsGruppeEintrag("Artificer armour", 10));
            ogE.addElement(new OptionsGruppeEintrag("Scout armour", 0));
            add(o5d = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

            seperator();
            ogE.addElement(new OptionsGruppeEintrag("Combat shield", 5));
            ogE.addElement(new OptionsGruppeEintrag("Refractor field", 10));
            add(o5e = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

            seperator();
            ogE.addElement(new OptionsGruppeEintrag("Jump pack", 20));
            add(o5f = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
        } else if (isMoritat) {

            seperator();
            ogE.addElement(new OptionsGruppeEintrag("Volkite charger", 10));
            add(o6a = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

            seperator();
            ogE.addElement(new OptionsGruppeEintrag("Chainsword", 0));
            add(o6x = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
            o6x.setSelected(0, true);

            ogE.addElement(new OptionsGruppeEintrag("Bolt pistol", 0));
            add(o6z = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 2));
            o6z.setAnzahl(0, 2);

            seperator();
            ogE.addElement(new OptionsGruppeEintrag("Volkite Serpenta", 5));
            ogE.addElement(new OptionsGruppeEintrag("Plasma pistol", 15));
            ogE.addElement(new OptionsGruppeEintrag("Heavy chainsword", 10));
            ogE.addElement(new OptionsGruppeEintrag("Charnabal sabre", 10));
            ogE.addElement(new OptionsGruppeEintrag("Power weapon", 15));
            add(o6b = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 3));

            seperator();
            ogE.addElement(new OptionsGruppeEintrag("Melta-bombs", 5));
            ogE.addElement(new OptionsGruppeEintrag("Artificer armour", 10));
            add(o6c = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 2));

            seperator();
            ogE.addElement(new OptionsGruppeEintrag("Combat shield", 5));
            ogE.addElement(new OptionsGruppeEintrag("Refractor field", 10));
            add(o6d = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

            seperator();
            ogE.addElement(new OptionsGruppeEintrag("Jump pack", 20));
            add(o6f = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
        }


        sizeSetzen();
    }

    @Override
    public void refreshen() {
        if (isCenturion || isChampion || isChaplain || isPrimus || isSiege) {
            int substractor = 0;
            int klauen = 0;
            int waffen = 0;

            if (o1x.isSelected() && o1y.isSelected()) {
                substractor = 2;
            } else if (o1x.isSelected() || o1y.isSelected()) {
                substractor = 1;
            } else if (!o1x.isSelected() && !o1y.isSelected()) {
                substractor = 0;
            }

            if (o1c.isSelected()) {
                klauen = 2;
            } else if (!o1c.isSelected()) {
                klauen = 0;
            }

            waffen = 2 - substractor - klauen;
            if (waffen < 0) waffen = 0;

            o1b.setMaxAnzahl(waffen);
            o1d.setAktiv(2, o1a.isSelected(0) || o1a.isSelected(1) || o1a.isSelected(2) || o1a.isSelected(3));

            boolean legal = ((o1x.isSelected() ? 1 : 0) + (o1y.isSelected() ? 1 : 0) + o1b.getAnzahl() + klauen) == 2;

            o1x.setLegal(legal);
            o1y.setLegal(legal);
            o1b.setLegal(legal);
            o1c.setLegal(legal);
        } else if (isForge) {
            int substractor = 0;
            int klauen = 0;
            int waffen = 0;

            if (o2x.isSelected() && o2y.isSelected()) {
                substractor = 2;
            } else if (o2x.isSelected() || o2y.isSelected()) {
                substractor = 1;
            } else if (!o2x.isSelected() && !o2y.isSelected()) {
                substractor = 0;
            }

            if (o2c.isSelected()) {
                klauen = 2;
            } else if (!o2c.isSelected()) {
                klauen = 0;
            }

            waffen = 2 - substractor - klauen;
            if (waffen < 0) waffen = 0;

            o2b.setMaxAnzahl(waffen);
            o2d.setAktiv(1, o2a.isSelected(0) || o2a.isSelected(1) || o2a.isSelected(2) || o2a.isSelected(3));

            boolean legal = ((o2x.isSelected() ? 1 : 0) + (o2y.isSelected() ? 1 : 0) + o2b.getAnzahl() + klauen) == 2;

            o2x.setLegal(legal);
            o2y.setLegal(legal);
            o2b.setLegal(legal);
            o2c.setLegal(legal);
        } else if (isLibrarian) {
            int substractor = 0;
            int waffen = 0;

            if (!o3x.isSelected()) {
                o3x.setSelected(0, true);
            }
            if (o3x.isSelected() && o3y.isSelected()) {
                substractor = 2;
            } else if (o3x.isSelected() || o3y.isSelected()) {
                substractor = 1;
            } else if (!o3x.isSelected() && !o3y.isSelected()) {
                substractor = 0;
            }

            waffen = 2 - substractor;
            if (waffen < 0) waffen = 0;

            o3b.setMaxAnzahl(waffen);
            o3c.setAktiv(2, o3a.isSelected(0) || o3a.isSelected(1) || o3a.isSelected(2) || o3a.isSelected(3));

            boolean legal = ((o3x.isSelected() ? 1 : 0) + (o3y.isSelected() ? 1 : 0) + o3b.getAnzahl()) == 2;

            o3y.setLegal(legal);
            o3b.setLegal(legal);
        } else if (isMaster) {
            int substractor = 0;
            int waffen = 0;

            if (o4x.isSelected() && o4y.isSelected()) {
                substractor = 2;
            } else if (o4x.isSelected() || o4y.isSelected()) {
                substractor = 1;
            } else if (!o4x.isSelected() && !o4y.isSelected()) {
                substractor = 0;
            }

            waffen = 2 - substractor;
            if (waffen < 0) waffen = 0;

            o4b.setMaxAnzahl(waffen);

            boolean legal = ((o4x.isSelected() ? 1 : 0) + (o4y.isSelected() ? 1 : 0) + o4b.getAnzahl()) == 2;

            o4x.setLegal(legal);
            o4y.setLegal(legal);
            o4b.setLegal(legal);
        } else if (isVigilator) {
            int substractor = 0;
            int waffen = 0;

            if (o5x.isSelected() && o5y.isSelected()) {
                substractor = 2;
            } else if (o5x.isSelected() || o5y.isSelected()) {
                substractor = 1;
            } else if (!o5x.isSelected() && !o5y.isSelected()) {
                substractor = 0;
            }

            waffen = 2 - substractor;
            if (waffen < 0) waffen = 0;

            o5b.setMaxAnzahl(waffen);
            o5c.setAktiv(1, o5a.isSelected(0));

            boolean legal = ((o5x.isSelected() ? 1 : 0) + (o5y.isSelected() ? 1 : 0) + o5b.getAnzahl()) == 2;

            o5x.setLegal(legal);
            o5y.setLegal(legal);
            o5b.setLegal(legal);
        } else if (isMoritat) {
            int substractor = 0;
            int waffen = 0;

            if (o6x.isSelected()) {
                substractor = 1;
            } else if (!o6x.isSelected()) {
                substractor = 0;
            }

            waffen = 3 - substractor - o6z.getAnzahl();
            if (waffen < 0) waffen = 0;

            o6b.setMaxAnzahl(waffen);

            boolean legal = ((o6x.isSelected() ? 1 : 0) + o6z.getAnzahl() + o6b.getAnzahl()) == 3;

            o6x.setLegal(legal);
            o6z.setLegal(legal);
            o6b.setLegal(legal);
        }


    }


}

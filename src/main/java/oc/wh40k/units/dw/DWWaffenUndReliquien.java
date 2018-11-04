package oc.wh40k.units.dw;

import oc.*;

public class DWWaffenUndReliquien extends RuestkammerVater {

    OptionsUpgradeGruppe o1, o7, o8, o9;
    OptionsZaehlerGruppe o2, o3, o6;
    OptionsEinzelUpgrade o4;
    OptionsEinzelUpgrade meister, sturm, termi, jump, stormbolter;
    OptionsEinzelUpgrade handwaffe = null;
    OptionsEinzelUpgrade boltpistole = null;
    OptionsEinzelUpgrade bolter = null;
    OptionsEinzelUpgrade spezialWaffe = null;
    OptionsUpgradeGruppe psiWaffe = null;

    String type;

    public DWWaffenUndReliquien() {
        grundkosten = 0;
    }

    @Override
    public void initButtons(boolean... defaults) {

        seperator();

        if (type.equals("Chaplain")) {
            add(handwaffe = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Crozius Arcanum", 0));
            handwaffe.setSelected(true);

            ogE.addElement(new OptionsGruppeEintrag("Bolt pistol", getPts("Bolt pistol (DW)")));
            ogE.addElement(new OptionsGruppeEintrag("Storm bolter", getPts("Storm bolter (DW)")));
            ogE.addElement(new OptionsGruppeEintrag("Combi-flamer", getPts("Combi-flamer (DW)")));
            ogE.addElement(new OptionsGruppeEintrag("Combi-grav", getPts("Combi-grav (DW)")));
            ogE.addElement(new OptionsGruppeEintrag("Combi-melta", getPts("Combi-melta (DW)")));
            ogE.addElement(new OptionsGruppeEintrag("Combi-plasma", getPts("Combi-plasma (DW)")));
            ogE.addElement(new OptionsGruppeEintrag("Hand-Flamer", getPts("Hand Flamer (DW)")));
            ogE.addElement(new OptionsGruppeEintrag("Grav-pistol", getPts("Grav-pistol")));
            ogE.addElement(new OptionsGruppeEintrag("Inferno-pistol", getPts("Inferno pistol (DW)")));
            ogE.addElement(new OptionsGruppeEintrag("Plasma-pistol", getPts("Plasma pistol (SM)")));
            add(o2 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 0));
            o2.setAnzahl(0, 1);
        }

        if (type.equals("Watch Captain")) {
            add(sturm = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "Sturmschild", "Sturmschild", getPts("Storm shield (Characters)")));

            seperator();

            add(meister = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "Meisterhafte Rüstung", "Meisterhafte Rüstung", 20));

            seperator();

            add(termi = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Terminatorrüstung", 25));
            add(stormbolter = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "Sturmbolter", "Sturmbolter", getPts("Storm bolter (DW)")));
            ogE.addElement(new OptionsGruppeEintrag("Power sword", getPts("Power sword (SM)")));
            ogE.addElement(new OptionsGruppeEintrag("Relic-blade", getPts("Relic-blade")));
            add(o7 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));
            o7.setSelected(0, true);

            seperator();

            add(jump = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "Sprungmodul", "Sprungmodul", 15));

            seperator();

            ogE.addElement(new OptionsGruppeEintrag("Bolt pistol", getPts("Bolt pistol (DW)")));
            ogE.addElement(new OptionsGruppeEintrag("Storm bolter", getPts("Storm bolter (DW)")));
            ogE.addElement(new OptionsGruppeEintrag("Combi-flamer", getPts("Combi-flamer (DW)")));
            ogE.addElement(new OptionsGruppeEintrag("Combi-grav", getPts("Combi-grav (DW)")));
            ogE.addElement(new OptionsGruppeEintrag("Combi-melta", getPts("Combi-melta (DW)")));
            ogE.addElement(new OptionsGruppeEintrag("Combi-plasma", getPts("Combi-plasma (DW)")));
            ogE.addElement(new OptionsGruppeEintrag("Hand-Flamer", getPts("Hand Flamer (DW)")));
            ogE.addElement(new OptionsGruppeEintrag("Grav-pistol", getPts("Grav-pistol")));
            ogE.addElement(new OptionsGruppeEintrag("Inferno-pistol", getPts("Inferno pistol (DW)")));
            ogE.addElement(new OptionsGruppeEintrag("Plasma-pistol", getPts("Plasma pistol (SM)")));
            add(o2 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 1));
            o2.setAnzahl(0, 1);

            seperator();

            ogE.addElement(new OptionsGruppeEintrag("Chainsword", getPts("Chainsword (SM)")));
            ogE.addElement(new OptionsGruppeEintrag("Power sword", getPts("Power sword (SM)")));
            ogE.addElement(new OptionsGruppeEintrag("Power axe", getPts("Power axe (SM)")));
            ogE.addElement(new OptionsGruppeEintrag("Power maul", getPts("Power maul (SM)")));
            ogE.addElement(new OptionsGruppeEintrag("Lightning claw", getPts("Lightning claw (single)")));
            ogE.addElement(new OptionsGruppeEintrag("Power fist", getPts("Chainsword (SM)")));
            ogE.addElement(new OptionsGruppeEintrag("Heavy thunder hammer", getPts("Heavy thunder hammer")));
            ogE.addElement(new OptionsGruppeEintrag("Xenophase blade", getPts("Xenophase blade")));
            add(o6 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 1));
            o6.setAnzahl(0, 1);

            seperator();

            add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Auspex array", getPts("Auspex array")));
            add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Combat shield", getPts("Combat shield")));
            add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Melta bombs", getPts("Melta bombs")));
            add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Deathwatch teleport homer", getPts("Deathwatch teleport homer")));
        }

        if (type.equals("Librarian")) {

            seperator();

            add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Meisterschaftsgrad 2", 25));

            seperator();

            add(termi = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Terminatorrüstung", 25));
            add(stormbolter = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "Sturm bolter", "Sturm bolter", getPts("Storm bolter (DW)")));
            ogE.addElement(new OptionsGruppeEintrag("Combi-flamer", getPts("Combi-flamer (DW)")));
            ogE.addElement(new OptionsGruppeEintrag("Combi-grav", getPts("Combi-grav (DW)")));
            ogE.addElement(new OptionsGruppeEintrag("Combi-melta", getPts("Combi-melta (DW)")));
            ogE.addElement(new OptionsGruppeEintrag("Combi-plasma", getPts("Combi-plasma (DW)")));
            add(o7 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));

            seperator();

            ogE.addElement(new OptionsGruppeEintrag("Force sword", getPts("Force sword")));
            add(o8 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));
            o8.setSelected(0, true);

            seperator();

            ogE.addElement(new OptionsGruppeEintrag("Bolt pistol", getPts("Bolt pistol (DW)")));
            ogE.addElement(new OptionsGruppeEintrag("Storm bolter", getPts("Storm bolter (DW)")));
            ogE.addElement(new OptionsGruppeEintrag("Combi-flamer", getPts("Combi-flamer (DW)")));
            ogE.addElement(new OptionsGruppeEintrag("Combi-grav", getPts("Combi-grav (DW)")));
            ogE.addElement(new OptionsGruppeEintrag("Combi-melta", getPts("Combi-melta (DW)")));
            ogE.addElement(new OptionsGruppeEintrag("Combi-plasma", getPts("Combi-plasma (DW)")));
            ogE.addElement(new OptionsGruppeEintrag("Hand-Flamer", getPts("Hand Flamer (DW)")));
            ogE.addElement(new OptionsGruppeEintrag("Grav-pistol", getPts("Grav-pistol")));
            ogE.addElement(new OptionsGruppeEintrag("Inferno-pistol", getPts("Inferno pistol (DW)")));
            ogE.addElement(new OptionsGruppeEintrag("Plasma-pistol", getPts("Plasma pistol (SM)")));
            add(o2 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 1));
            o2.setAnzahl(0, 1);

            seperator();


            add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Auspex array", getPts("Auspex array")));
            add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Combat shield", getPts("Combat shield")));
            add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Melta bombs", getPts("Melta bombs")));
            add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Deathwatch teleport homer", getPts("Deathwatch teleport homer")));
        }

        seperator();

        cnt = randAbstand;

        setUeberschrift("Waffen und Artefakte");
        sizeSetzen();

        seperator();

    }

    @Override
    public void refreshen() {

        int nahkampfwaffen = 0;
        int fernkampfwaffen = 0;
        int substractor = 0;

        if (type.equals("Chaplain")) {
            if (handwaffe.isSelected() && o2.isSelected()) {
                substractor = 2;
            } else if (handwaffe.isSelected() || o2.isSelected()) {
                substractor = 1;
            } else if (!handwaffe.isSelected() && !o2.isSelected()) {
                substractor = 0;
            }

            nahkampfwaffen = 2 - substractor;
            fernkampfwaffen = 2 - substractor;

            if (nahkampfwaffen < 0) nahkampfwaffen = 0;
            if (fernkampfwaffen < 0) fernkampfwaffen = 0;

            o2.setMaxAnzahl(2 - (handwaffe.isSelected() ? 1 : 0));

            legal = (o2.getAnzahl() + (handwaffe.isSelected() ? 1 : 0)) == 2;
            o2.setLegal(legal);
            handwaffe.setLegal(legal);
        } else if (type.equals("Watch Captain")) {
            meister.setAktiv(!termi.isSelected());
            jump.setAktiv(!termi.isSelected());
            o2.setAktiv(!termi.isSelected());
            o7.setAktiv(termi.isSelected());
            o6.setAktiv(!termi.isSelected());
            stormbolter.setAktiv(termi.isSelected());

            o2.setMaxAnzahl(2 - o6.getAnzahl());
            o6.setMaxAnzahl(2 - o2.getAnzahl());
        } else if (type.equals("Librarian")) {
            o2.setAktiv(!termi.isSelected());
            o7.setAktiv(termi.isSelected());
        }
    }

    public void SetType(String s) {
        type = s;
    }

    @Override
    public Object getSpecialValue() {
        return 0;
    }

    @Override
    public void switchEntry(String name, boolean aktiv) {
        boolean entrySwitched = false;

        if (entrySwitched) {
            //Aktualisisert alle Einträge, auch die, welche diese Rüstkammer enthält.
            //Sonst werden dort zwar beim abwählen von Malen die Punkte korrekt berechnet,
            //der Text aber nicht aktualisiert.
            RefreshListener.fireRefresh();
        }
    }

    @Override
    public void deleteYourself() {
        super.deleteYourself();
    }

}

package oc.wh40k.units.im;

import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.OptionsZaehlerGruppe;
import oc.RefreshListener;
import oc.RuestkammerVater;

public class DeathWatchKammer extends RuestkammerVater {

    private OptionsUpgradeGruppe o1, o2, o5;
    private OptionsZaehlerGruppe o3, o4;
    private OptionsEinzelUpgrade thunderhammer;
    private String type;

    public DeathWatchKammer() {
        grundkosten = 0;
    }

    @Override
    public void initButtons(boolean... defaults) {

        seperator();

        if (type.equals("Vanguard Veteran")) {
            ogE.addElement(new OptionsGruppeEintrag("Chainsword", getPts("Chainsword (SM)")));
            add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
            o1.setSelected(0, true);

            seperator();

            ogE.addElement(new OptionsGruppeEintrag("Bolt pistol", getPts("Bolt pistol (DW)")));
            add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
            o2.setSelected(0, true);

            seperator();

            ogE.addElement(new OptionsGruppeEintrag("Bolt pistol", getPts("Bolt pistol (DW)")));
            ogE.addElement(new OptionsGruppeEintrag("Chainsword", getPts("Chainsword (SM)")));
            ogE.addElement(new OptionsGruppeEintrag("Grav-pistol", getPts("Grav-pistol")));
            ogE.addElement(new OptionsGruppeEintrag("Inferno-pistol", getPts("Inferno pistol (DW)")));
            ogE.addElement(new OptionsGruppeEintrag("Hand-Flamer", getPts("Hand Flamer (DW)")));
            ogE.addElement(new OptionsGruppeEintrag("Lightning claw", getPts("Lightning claw (single)")));
            ogE.addElement(new OptionsGruppeEintrag("Plasma-pistol", getPts("Plasma pistol (SM)")));
            ogE.addElement(new OptionsGruppeEintrag("Power axe", getPts("Power axe (SM)")));
            ogE.addElement(new OptionsGruppeEintrag("Power fist", getPts("Power fist (SM)")));
            ogE.addElement(new OptionsGruppeEintrag("Power maul", getPts("Power maul (SM)")));
            ogE.addElement(new OptionsGruppeEintrag("Power sword", getPts("Power sword (SM)")));
            ogE.addElement(new OptionsGruppeEintrag("Storm shield", getPts("Storm shield (others)")));
            ogE.addElement(new OptionsGruppeEintrag("Thunder hammer", getPts("Thunder hammer (others)")));
            add(o3 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 1));

            seperator();

            ogE.addElement(new OptionsGruppeEintrag("Boltgun", getPts("Boltgun (DW)")));
            ogE.addElement(new OptionsGruppeEintrag("Combi-flamer", getPts("Combi-flamer (DW)")));
            ogE.addElement(new OptionsGruppeEintrag("Combi-grav", getPts("Combi-grav (DW)")));
            ogE.addElement(new OptionsGruppeEintrag("Combi-melta", getPts("Combi-melta (DW)")));
            ogE.addElement(new OptionsGruppeEintrag("Combi-plasma", getPts("Combi-plasma (DW)")));
            ogE.addElement(new OptionsGruppeEintrag("Deathwatch shotgun", getPts("Deathwatch shotgun")));
            ogE.addElement(new OptionsGruppeEintrag("Flamer", getPts("Flamer (SM)")));
            ogE.addElement(new OptionsGruppeEintrag("Grav-gun", getPts("Grav-gun")));
            ogE.addElement(new OptionsGruppeEintrag("Meltagun", getPts("Meltagun (SM)")));
            ogE.addElement(new OptionsGruppeEintrag("Plasma gun", getPts("Plasma gun (SM)")));
            ogE.addElement(new OptionsGruppeEintrag("Stalker pattern boltgun", getPts("Stalker pattern boltgun")));
            ogE.addElement(new OptionsGruppeEintrag("Storm bolter", getPts("Storm bolter (DW)")));
            add(o4 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE));

            seperator();

            add(thunderhammer = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Heavy thunder hammer", getPts("Heavy thunder hammer")));

            seperator();
        }

        if (type.equals("Biker")) {
            ogE.addElement(new OptionsGruppeEintrag("Bolt pistol", getPts("Bolt pistol (DW)")));
            ogE.addElement(new OptionsGruppeEintrag("Chainsword", getPts("Chainsword (SM)")));
            ogE.addElement(new OptionsGruppeEintrag("Grav-pistol", getPts("Grav-pistol")));
            ogE.addElement(new OptionsGruppeEintrag("Inferno-pistol", getPts("Inferno pistol (DW)")));
            ogE.addElement(new OptionsGruppeEintrag("Hand-Flamer", getPts("Hand Flamer (DW)")));
            ogE.addElement(new OptionsGruppeEintrag("Lightning claw", getPts("Lightning claw (single)")));
            ogE.addElement(new OptionsGruppeEintrag("Plasma-pistol", getPts("Plasma pistol (SM)")));
            ogE.addElement(new OptionsGruppeEintrag("Power axe", getPts("Power axe (SM)")));
            ogE.addElement(new OptionsGruppeEintrag("Power fist", getPts("Power fist (SM)")));
            ogE.addElement(new OptionsGruppeEintrag("Power maul", getPts("Power maul (SM)")));
            ogE.addElement(new OptionsGruppeEintrag("Power sword", getPts("Power sword (SM)")));
            ogE.addElement(new OptionsGruppeEintrag("Storm shield", getPts("Storm shield (others)")));
            ogE.addElement(new OptionsGruppeEintrag("Thunder hammer", getPts("Thunder hammer (others)")));
            add(o3 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 1));

            seperator();

            ogE.addElement(new OptionsGruppeEintrag("Boltgun", getPts("Boltgun (DW)")));
            ogE.addElement(new OptionsGruppeEintrag("Combi-flamer", getPts("Combi-flamer (DW)")));
            ogE.addElement(new OptionsGruppeEintrag("Combi-grav", getPts("Combi-grav (DW)")));
            ogE.addElement(new OptionsGruppeEintrag("Combi-melta", getPts("Combi-melta (DW)")));
            ogE.addElement(new OptionsGruppeEintrag("Combi-plasma", getPts("Combi-plasma (DW)")));
            ogE.addElement(new OptionsGruppeEintrag("Deathwatch shotgun", getPts("Deathwatch shotgun")));
            ogE.addElement(new OptionsGruppeEintrag("Flamer", getPts("Flamer (SM)")));
            ogE.addElement(new OptionsGruppeEintrag("Grav-gun", getPts("Grav-gun")));
            ogE.addElement(new OptionsGruppeEintrag("Meltagun", getPts("Meltagun (SM)")));
            ogE.addElement(new OptionsGruppeEintrag("Plasma gun", getPts("Plasma gun (SM)")));
            ogE.addElement(new OptionsGruppeEintrag("Stalker pattern boltgun", getPts("Stalker pattern boltgun")));
            ogE.addElement(new OptionsGruppeEintrag("Storm bolter", getPts("Storm bolter (DW)")));
            add(o4 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE));

            seperator();
        }

        if (type.equals("Terminator Sergeant")) {
            ogE.addElement(new OptionsGruppeEintrag("Storm bolter", getPts("Storm bolter(DW)")));
            add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));

            seperator();

            ogE.addElement(new OptionsGruppeEintrag("Power fist", getPts("Power fist (SM)")));
            ogE.addElement(new OptionsGruppeEintrag("Chainfist", getPts("Chainfist")));
            ogE.addElement(new OptionsGruppeEintrag("Power axe", getPts("Power axe (SM)")));
            ogE.addElement(new OptionsGruppeEintrag("Power maul", getPts("Power maul (SM)")));
            ogE.addElement(new OptionsGruppeEintrag("Power sword", getPts("Power sword (SM)")));
            ogE.addElement(new OptionsGruppeEintrag("Power fist & melta", getPts("Power fist (SM)") + getPts("Meltagun")));
            add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));

            seperator();

            ogE.addElement(new OptionsGruppeEintrag("Lightning claws", getPts("Lightning claw (pair)")));
            ogE.addElement(new OptionsGruppeEintrag("Thunderhammer & Shield", getPts("Thunder hammer (others)") + getPts("Storm shield (others)")));
            add(o5 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));

            seperator();
        }

        cnt = randAbstand;

        setUeberschrift("");
        sizeSetzen();

        seperator();

    }

    @Override
    public void refreshen() {

        if (type.equals("Vanguard Veteran")) {
            int maxWeapons = 2;

            if (o1.isSelected()) maxWeapons = maxWeapons - 1;
            if (o2.isSelected()) maxWeapons = maxWeapons - 1;
            maxWeapons = maxWeapons - o3.getAnzahl();
            maxWeapons = maxWeapons - o4.getAnzahl();

            if (maxWeapons == 0)
                o3.setMaxAnzahl(o3.getAnzahl());
            else
                o3.setMaxAnzahl(o3.getAnzahl() + maxWeapons);

            if (maxWeapons == 0)
                o4.setMaxAnzahl(o4.getAnzahl());
            else
                o4.setMaxAnzahl(1);

            o1.setAktiv(!thunderhammer.isSelected());
            o2.setAktiv(!thunderhammer.isSelected());
            o3.setAktiv(!thunderhammer.isSelected());
            o4.setAktiv(!thunderhammer.isSelected());
        }

        if (type.equals("Biker")) {
            int maxWeapons = 2;

            maxWeapons = maxWeapons - o3.getAnzahl();
            maxWeapons = maxWeapons - o4.getAnzahl();

            if (maxWeapons == 0)
                o3.setMaxAnzahl(o3.getAnzahl());
            else
                o3.setMaxAnzahl(o3.getAnzahl() + maxWeapons);

            if (maxWeapons == 0)
                o4.setMaxAnzahl(o4.getAnzahl());
            else
                o4.setMaxAnzahl(1);
        }

        if(type.equals("Terminator Sergeant")) {

        	o1.alwaysSelected();
        	o2.alwaysSelected();

        	o1.setAktiv(!o5.isSelected());
        	o2.setAktiv(!o5.isSelected());
        }
    }

    @Override
	public void setType(String s) {
        type = s;
    }

    @Override
    public Object getSpecialValue() {
        return 0;
    }

    @Override
    public void switchEntry(String name, boolean aktiv) {
        final boolean entrySwitched = false;

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

package oc.wh40k.units.im;

import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerVater;

public class IMAdeptusMechanicusRuestkammer extends RuestkammerVater {

	private OptionsUpgradeGruppe o1;
	private OptionsUpgradeGruppe o2;
	private OptionsEinzelUpgrade oe;

	private boolean vanguard = false;
	private boolean ranger = false;
	private boolean hoplite = false;
	private boolean peltast = false;
	private String type = "";

    public IMAdeptusMechanicusRuestkammer() {
        grundkosten = 0;
    }

    @Override
    public void initButtons(boolean... defaults) {
        checkBuildaVater();
        vanguard = defaults[0];
        ranger = defaults[1];
        hoplite = defaults[2];
        peltast = defaults[3];
        
        //special
        if (ranger) {
            ogE = IMAdeptusMechanicusMeleeWeapons.createRK("", "", buildaVater);
            add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

            seperator();

            ogE = IMAdeptusMechanicusPistolWeapons.createRK("Galvanic rifle", "Galvanic rifle", buildaVater);
            add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
        } else if (vanguard) {
            ogE = IMAdeptusMechanicusMeleeWeapons.createRK("", "", buildaVater);
            add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

            seperator();

            ogE = IMAdeptusMechanicusPistolWeapons.createRK("Radium carbine", "Radium carbine", buildaVater);
            add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
        } else if(hoplite) {
            ogE = IMAdeptusMechanicusMeleeWeapons.createRK("Mag-inverter shield", "Mag-inverter shield", buildaVater);
            ogE.addElement(new OptionsGruppeEintrag("Enh. data-tehter", "Enhanced data-tehter", getPts("Enhanced data-tether")));
            ogE.addElement(new OptionsGruppeEintrag("Omnispex", getPts("Omnispex")));
            add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

            seperator();

            ogE = IMAdeptusMechanicusPistolWeapons.createRK("Arc lance", "Arc lance", buildaVater);
            add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
        } else if(peltast) {
            ogE = IMAdeptusMechanicusMeleeWeapons.createRK("", "", buildaVater);
            ogE.addElement(new OptionsGruppeEintrag("Enh. data-tehter", "Enhanced data-tehter", getPts("Enhanced data-tether")));
            ogE.addElement(new OptionsGruppeEintrag("Omnispex", getPts("Omnispex")));
            add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

            seperator();

            ogE = IMAdeptusMechanicusPistolWeapons.createRK("Galvanic caster", "Galvanic caster", buildaVater);
            add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
        }

        if (type.equals("Ruststalker Princeps")) {
            add(oe = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Chordclaw", getPts("chordclaw")));

            ogE.addElement(new OptionsGruppeEintrag("Transonic razor", getPts("Transonic razor")));
            ogE.addElement(new OptionsGruppeEintrag("Transonic blades", getPts("Transonic blades")));
            add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
        }

        sizeSetzen();
    }

    @Override
    public void refreshen() {

        if (type.equals("Ruststalker Princeps")) {
            o1.alwaysSelected();
            oe.setSelected(true);
        } else if(hoplite){
        	o1.alwaysSelected();
        	o2.alwaysSelected();
        } else if(peltast){
        	o1.alwaysSelected();
        	o2.alwaysSelected();
        } else{
            o2.alwaysSelected();
        }
    }

    public void setType(String s) {
        type = s;
    }
}

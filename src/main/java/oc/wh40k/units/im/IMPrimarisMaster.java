package oc.wh40k.units.im;

import oc.*;

public class IMPrimarisMaster extends Eintrag {
    OptionsEinzelUpgrade jump;
    RuestkammerStarter waffenUndReliquien;

    OptionsUpgradeGruppe o1;
    OptionsEinzelUpgrade oe1, oe2;

    public IMPrimarisMaster() {
        name = "Primaris Master";
        grundkosten = getPts("Primaris Master") + getPts("Frag grenade (SM)") + getPts("Krak grenade (SM)");

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("MC boltgun", "Master crafted auto bolt rifle", getPts("Master crafted auto bolt rifle")));
        ogE.addElement(new OptionsGruppeEintrag("MC boltgun", "Master crafted stalker bolt rifle", getPts("Master crafted stalker bolt rifle")));
        add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
        o1.setSelected(0, true);

        add(oe1 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Power sword", getPts("Power sword (SM)")));

        add(oe2 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Power fist und Plasma pisotl", getPts("Power fist (SM)") + getPts("Plasma pistol (SM)")));

        complete();
    }

    @Override
    public void refreshen() {
        power = 6;

        if (oe2.isSelected()) {
            o1.setAktiv(!oe2.isSelected());
            oe1.setAktiv(!oe2.isSelected());
        }
    }
}

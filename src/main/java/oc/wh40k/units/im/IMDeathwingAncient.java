package oc.wh40k.units.im;

import oc.Eintrag;

import oc.OptionsGruppeEintrag;

import oc.OptionsUpgradeGruppe;

public class IMDeathwingAncient extends Eintrag {

    OptionsUpgradeGruppe o1;

    public IMDeathwingAncient() {
        name = "Deathwing Ancient";
        grundkosten = getPts("Deathwing Ancient");
        power = 7;
        
        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Power fist and storm bolter", getPts("Power fist (SM)") + getPts("Storm bolter (SM)")));
        ogE.addElement(new OptionsGruppeEintrag("2 Lightning claws", getPts("Lightning claw (pair)")));
        ogE.addElement(new OptionsGruppeEintrag("Thunder hammer and storm shield", getPts("Thunder hammer (Characters)") + getPts("Storm shield (Characters)")));
        ogE.addElement(new OptionsGruppeEintrag("Chainfist and storm bolter", getPts("Chainfist") + getPts("Storm bolter (SM)")));
        add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
        
        seperator();
        
        addWarlordTraits("", true);

        complete();
    }

    @Override
    public void refreshen() {
    }
}


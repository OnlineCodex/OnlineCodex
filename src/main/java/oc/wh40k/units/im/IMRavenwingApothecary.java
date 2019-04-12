package oc.wh40k.units.im;



import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;



public class IMRavenwingApothecary extends Eintrag {



	public IMRavenwingApothecary() {

        name = "Ravenwing Apothecary";

        grundkosten = getPts("Ravenwing Apothecary") + getPts("Corvus hammer") + getPts("Bolt pistol (SM)") + getPts("Frag grenade (SM)") + getPts("Krak grenade (SM)");

        power = 5;

        seperator();



        ogE.addElement(new OptionsGruppeEintrag("Plasma talon", getPts("Plasma talon")));

        ogE.addElement(new OptionsGruppeEintrag("Ravenwing grenade launcher", getPts("Ravenwing grenade launcher")));

        add(new OptionsUpgradeGruppe(randAbstand, cnt, "", ogE));



        seperator();



        complete();

    }



    @Override

    public void refreshen() {

    }

}


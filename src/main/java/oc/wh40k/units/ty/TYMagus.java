package oc.wh40k.units.ty;



import oc.Eintrag;

import oc.OptionsGruppeEintrag;

import oc.OptionsZaehlerGruppe;
import oc.RuestkammerStarter;
import oc.wh40k.units.PsychicPowers;



public class TYMagus extends Eintrag {


	RuestkammerStarter psychicPowers;
    OptionsZaehlerGruppe o1;



    public TYMagus() {

        name = "Magus";

        grundkosten = getPts("Magus") + getPts("Autopistol") + getPts("Force stave") + getPts("Cultist knife");

        power = 4;



        ogE.addElement(new OptionsGruppeEintrag("Familiars", getPts("Familiars")));

        add(o1 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 2));

        psychicPowers = new RuestkammerStarter(ID, randAbstand, cnt, PsychicPowers.class, "Psychic Powers");
        ((PsychicPowers) psychicPowers.getKammer()).setNumberOfPowers(1);
        ((PsychicPowers) psychicPowers.getKammer()).enableBroodMind();
        psychicPowers.initKammer();
        psychicPowers.setUeberschriftTrotzNullKostenAusgeben(true);
        add(psychicPowers);
        psychicPowers.setAbwaehlbar(true);

        seperator();
        
        addWarlordTraits("", true);
        
        complete();

    }

}


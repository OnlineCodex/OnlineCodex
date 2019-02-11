package oc.wh40k.units.ty;



import static oc.KeyWord.ALLEGIANCE;

import oc.Eintrag;

import oc.OptionsGruppeEintrag;

import oc.OptionsZaehlerGruppe;
import oc.RuestkammerStarter;
import oc.wh40k.units.PsychicPowers;



public class TYPatriarch extends Eintrag {

    RuestkammerStarter psychicPowers;

    OptionsZaehlerGruppe o1;



    public TYPatriarch() {

        name = "Patriarch";

        grundkosten = getPts("Patriarch") + getPts("Monstrous rending claws (GSC)");

        power = 7;
        
        ogE.addElement(new OptionsGruppeEintrag("Familiars", getPts("Familiars")));

        add(o1 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 2));

        seperator();
        
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



    @Override

    public void refreshen() {

    }



}


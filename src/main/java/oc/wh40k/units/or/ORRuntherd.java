package oc.wh40k.units.or;

import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerStarter;

public class ORRuntherd extends Eintrag {
    
    OptionsUpgradeGruppe o1 = null;
    OptionsUpgradeGruppe o2 = null;
    RuestkammerStarter waffen;

    public ORRuntherd() {
        name = "Runtherd";
        grundkosten = getPts("Runtherd");
        power = 2;
        setEintragsCNT(0.0);

        addToInformationVector("Runtherd", 1);
        
        add(ico = new oc.Picture("oc/wh40k/images/Runtherd.gif"));

        ogE.addElement(new OptionsGruppeEintrag("Grabba Stikk", getPts("Grabba Stikk")));
        ogE.addElement(new OptionsGruppeEintrag("Grot-prod", getPts("Grot-prod")));
        add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Grot lash", getPts("Grot lash")));
        ogE.addElement(new OptionsGruppeEintrag("Squig hound", getPts("Squig hound")));
        add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));

        seperator();

        waffen = new RuestkammerStarter(ID, randAbstand, cnt, ORWaffenUndGeschenke.class, "");
        ((ORWaffenUndGeschenke) waffen.getKammer()).setDefaultRanged("no weapon");
        ((ORWaffenUndGeschenke) waffen.getKammer()).setDefaultCloceCombat("no weapon");
        waffen.initKammer(false, false, false, false, false, false, true, false);
        waffen.setButtonText("Waffen und Geschenke");
        add(waffen);
        waffen.setAbwaehlbar(false);
        
        seperator();

		addWarlordTraits("", true);

        complete();
    }

    @Override
    public void refreshen() {
        o1.alwaysSelected();
        if(getCountFromInformationVector("Runtherd") > getCountFromInformationVector("Gretchin Infantry")){
        	setFehlermeldung("Zu wenig Gretchins!");
        } else {
        	setFehlermeldung("");
        }
        
    	warlordTraits.getPanel().setLocation(
                (int) warlordTraits.getPanel().getLocation().getX(),
                (int) waffen.getPanel().getLocation().getY() + waffen.getPanel().getSize().height + 5
        );
    }
    
    @Override
    public void deleteYourself(){
        addToInformationVector("Runtherd", -1);
    }

}

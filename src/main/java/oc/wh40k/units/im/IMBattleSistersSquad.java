package oc.wh40k.units.im;

import oc.*;

import static oc.KeyWord.*;

public class IMBattleSistersSquad extends Eintrag {

    AnzahlPanel squad;
    OptionsZaehlerGruppe bolters;
    OptionsZaehlerGruppe special;
    OptionsZaehlerGruppe heavy;

    public IMBattleSistersSquad() {
    	super(IMPERIUM, ADEPTUS_MINISTORUM, ADEPTA_SORORITAS, ORDER, INFANTRY, BATTLE_SISTERS_SQUAD);
        name = "Battle Sisters Squad\n";
        grundkosten = 0;
        überschriftSetzen = true;

        squad = new AnzahlPanel(ID, randAbstand, cnt, "Battle Sisters", 5, 15, getPts("Battle Sisters Squad"));
        add(squad);

        add(ico = new oc.Picture("oc/wh40k/images/ASSororitastrupp.jpg"));

        seperator();

        checkBuildaVater();
        
        ogE.addElement(new OptionsGruppeEintrag("Boltgun", getPts("Boltgun (AMI)")));
        add(bolters = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE));
        
        seperator();
        
        ogE.addAll(IMAdeptaSororitasRuestkammer.getSpecialWeapons(buildaVater));
        add(special = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE));
        
        seperator();
        
        ogE.addAll(IMAdeptaSororitasRuestkammer.getHeavyWeapons(buildaVater));
        add(heavy = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE));
        
        seperator();

        add(createTroopChampion(IMAdeptaSororitasRuestkammer.class, true, "Upgrade zur Prioris", "Sister Superior"));

        complete();
    }

    @Override
    public void refreshen() {
        if (squad.getModelle() <= 5)
            power = 4;
        else if (squad.getModelle() <= 10)
            power = 6;
        else if (squad.getModelle() <= 15)
            power = 8;
        
        bolters.setMaxAnzahl(squad.getModelle() - 1 - special.getAnzahl() - heavy.getAnzahl());
        bolters.setAnzahl(0, bolters.getMaxAnzahl());
        special.setMaxAnzahl(2 - heavy.getAnzahl());
        heavy.setMaxAnzahl(Math.min(1, 2 - special.getAnzahl()));
    }
    
}

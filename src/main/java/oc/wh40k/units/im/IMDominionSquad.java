package oc.wh40k.units.im;

import oc.*;

public class IMDominionSquad extends Eintrag {

    AnzahlPanel squad;
    OptionsZaehlerGruppe bolters;
    OptionsZaehlerGruppe special;
    OptionsEinzelUpgrade simulacrum;

    public IMDominionSquad() {
        name = "Dominion Squad\n";
        grundkosten = 0;
        überschriftSetzen = true;

        squad = new AnzahlPanel(ID, randAbstand, cnt, "Dominion Squad", 5, 10, getPts("Dominion Squad"));
        add(squad);

        seperator();

        checkBuildaVater();
        
        ogE.addElement(new OptionsGruppeEintrag("Boltgun", getPts("Boltgun (AMI)")));
        add(bolters = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE));
        
        seperator();
        
        ogE.addAll(IMAdeptaSororitasRuestkammer.getSpecialWeapons(buildaVater));
        add(special = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE));
        
        seperator();
        
        add(simulacrum = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Simulacrum Imperialis", getPts("Simulacrum Imperialis (AMI)")));
        
        seperator();

        add(createTroopChampion(IMAdeptaSororitasRuestkammer.class, true, "Upgrade zur Prioris", "Sister Superior"));

        complete();
    }

    @Override
    public void refreshen() {

        if (squad.getModelle() <= 5)
            power = 5;
        else if (squad.getModelle() <= 10)
            power = 7;
        
        bolters.setMaxAnzahl(squad.getModelle() - 1 - special.getAnzahl());
        bolters.setAnzahl(0, bolters.getMaxAnzahl());
        special.setMaxAnzahl(Math.min(4, squad.getModelle() - 1 - (simulacrum.isSelected() ? 1 : 0)));
    }

}

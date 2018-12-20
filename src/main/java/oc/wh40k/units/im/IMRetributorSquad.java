package oc.wh40k.units.im;

import static oc.KeyWord.*;

import oc.*;

public class IMRetributorSquad extends Eintrag {

    AnzahlPanel squad;
    OptionsZaehlerGruppe bolters;
    OptionsZaehlerGruppe heavy;
    OptionsEinzelUpgrade simulacrum;

    public IMRetributorSquad() {
    	super(IMPERIUM, ADEPTUS_MINISTORUM, ADEPTA_SORORITAS, ORDER, INFANTRY, RETRIBUTOR_SQUAD);
        name = "Retributor Squad\n";
        grundkosten = 0;
        überschriftSetzen = true;

        squad = new AnzahlPanel(ID, randAbstand, cnt, "Retributor Squad", 5, 10, getPts("Retributor Squad"));
        add(squad);

        seperator();

        checkBuildaVater();
        
        ogE.addElement(new OptionsGruppeEintrag("Boltgun", getPts("Boltgun (AMI)")));
        add(bolters = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE));
        
        seperator();
        
        ogE.addAll(IMAdeptaSororitasRuestkammer.getHeavyWeapons(buildaVater));
        add(heavy = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE));
        
        seperator();
        
        add(simulacrum = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Simulacrum Imperialis", getPts("Simulacrum Imperialis (AMI)")));
        
        seperator();

        add(createTroopChampion(IMAdeptaSororitasRuestkammer.class, true, "Upgrade zur Prioris", "Retributor Superior"));

        complete();
    }

    @Override
    public void refreshen() {

        if (squad.getModelle() <= 5)
            power = 5;
        else if (squad.getModelle() <= 10)
            power = 7;
        
        bolters.setMaxAnzahl(squad.getModelle() - 1 - heavy.getAnzahl());
        bolters.setAnzahl(0, bolters.getMaxAnzahl());
        heavy.setMaxAnzahl(Math.min(4, squad.getModelle() - 1 - (simulacrum.isSelected() ? 1 : 0)));
    }

}

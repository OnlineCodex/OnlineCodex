package oc.wh40k.units.im;

import static oc.KeyWord.*;

import oc.*;

public class IMSeraphimSquad extends Eintrag {

    AnzahlPanel squad;
    OptionsZaehlerGruppe o1;

    public IMSeraphimSquad() {
    	super(IMPERIUM, ADEPTUS_MINISTORUM, ADEPTA_SORORITAS, ORDER, INFANTRY, JUMP_PACK, FLY, SERAPHIM_SQUAD);
        name = "Seraphim Squad\n";
        grundkosten = 0;
        überschriftSetzen = true;

        squad = new AnzahlPanel(ID, randAbstand, cnt, "Seraphim Squad", 5, 10, getPts("Seraphim Squad"));
        add(squad);

        add(ico = new oc.Picture("oc/wh40k/images/ASSororitastrupp.jpg"));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("2 Hand flamers", getPts("Hand flamer (AMI)") * 2));
        ogE.addElement(new OptionsGruppeEintrag("2 Inferno pistols", getPts("Inferno pistol (AMI)") * 2));
        add(o1 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 2));

        seperator();

        add(createTroopChampion(IMAdeptaSororitasRuestkammer.class, true, "Upgrade zur Prioris", "Seraphim Superior"));

        complete();
    }

    @Override
    public void refreshen() {
        if (squad.getModelle() <= 5)
            power = 4;
        else if (squad.getModelle() <= 10)
            power = 6;
    }

}

package oc.wh40k.units.ty;



import oc.*;
import oc.wh40k.units.im.IMAstraMilitarumHeavyWeapons;



public class TYBroodBrothersInfantrySquad extends Eintrag {



    private final AnzahlPanel squad;

    private final OptionsZaehlerGruppe o1, o2;

    private final OptionsZaehlerGruppe o3;
    
    private final RuestkammerStarter rkBoss;



    public TYBroodBrothersInfantrySquad() {

        name = "Brood Brothers Infantry Squad";

        grundkosten = 0;



        squad = new AnzahlPanel(ID, randAbstand, cnt, "Brood Brothers", 10, 20, getPts("Brood Brothers Infantry Squad"));

        add(squad);



        seperator();



        ogE.addElement(new OptionsGruppeEintrag("Lasgun", getPts("Lasgun")));

        add(o1 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 1));



        seperator();



        ogE.addElement(new OptionsGruppeEintrag("Flamer", getPts("Flamer")));

        ogE.addElement(new OptionsGruppeEintrag("Grenade launcher", getPts("Grenade launcher")));

        add(o2 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 2));

        seperator();

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Autocannon", getPts("Autocannon")));

        ogE.addElement(new OptionsGruppeEintrag("Heavy bolter", getPts("Heavy bolter")));

        ogE.addElement(new OptionsGruppeEintrag("Lascannon", getPts("Lascannon")));

        ogE.addElement(new OptionsGruppeEintrag("Mortar", getPts("Mortar")));

        ogE.addElement(new OptionsGruppeEintrag("Missile launcher", getPts("Missile launcher")));

        add(o3 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 1));

        seperator();

        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Cult vox caster", getPts("Cult vox caster")));

        seperator();



        rkBoss = new RuestkammerStarter(ID, randAbstand, cnt, TYLeader.class, "Brood Brothers Leader");

        ((TYLeader) rkBoss.getKammer()).type = "Brood Brother";

        rkBoss.initKammer();

        add(rkBoss);

        rkBoss.setAbwaehlbar(false);
        rkBoss.setUeberschriftTrotzNullKostenAusgeben(true);


        complete();

    }



    @Override

    public void refreshen() {

        o1.setMaxAnzahl(squad.getModelle() - o2.getAnzahl() - 2 * o3.getAnzahl() - 1);

        if (squad.getModelle() > 10)

            power = 5;

        else

            power = 3;

    }

}
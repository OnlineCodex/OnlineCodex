package oc.wh40k.units.im;

import oc.AnzahlPanel;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsZaehlerGruppe;
import oc.RuestkammerStarter;

public class IMDeathwatchTerminatorSquad extends Eintrag {

	private final AnzahlPanel squad;
    private final OptionsZaehlerGruppe o1, o2, o3;
    private final RuestkammerStarter rkBoss;

    boolean raiderSelected = false;

    public IMDeathwatchTerminatorSquad() {
        name = "Terminator Squad";

        add(squad = new AnzahlPanel(ID, randAbstand, cnt, "Terminators", 5, 10, getPts("Deathwatch Terminators")));
        squad.setGrundkosten(getPts("Power sword (SM)"));
        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Storm bolter", getPts("Storm bolter(DW)")));
        ogE.addAll(IMSpaceMarinesTerminatorHeavyWeapons.createRK("", "", buildaVater));
        add(o1 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 4));
        o1.setAnzahl(0, squad.getModelle()-1);

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Power fist", getPts("Power fist (SM)")));
        ogE.addElement(new OptionsGruppeEintrag("Chainfist", getPts("Chainfist")));
        ogE.addElement(new OptionsGruppeEintrag("Power axe", getPts("Power axe (SM)")));
        ogE.addElement(new OptionsGruppeEintrag("Power maul", getPts("Power maul (SM)")));
        ogE.addElement(new OptionsGruppeEintrag("Power sword", getPts("Power sword (SM)")));
        ogE.addElement(new OptionsGruppeEintrag("Power fist & melta", getPts("Power fist (SM)") + getPts("Meltagun")));
        add(o2 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 0));
        o2.setAnzahl(0, squad.getModelle()-1);

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Lightning claws", getPts("Lightning claw (pair)")));
        ogE.addElement(new OptionsGruppeEintrag("Thunderhammer & Shield", getPts("Thunder hammer (others)") + getPts("Storm shield (others)")));
        add(o3 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 0));

        seperator();

        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Teleport homer", getPts("Teleport homer")));

        seperator();

        rkBoss = new RuestkammerStarter(ID, randAbstand, cnt, DeathWatchKammer.class, "Terminator Sergeant", getKeywords());
        ((DeathWatchKammer) rkBoss.getKammer()).setType("Terminator Sergeant");
        rkBoss.initKammer();
        rkBoss.setGrundkosten(0);
        rkBoss.setUeberschriftTrotzNullKostenAusgeben(true);
        add(rkBoss);
        rkBoss.setAbwaehlbar(false);

        complete();
    }

    @Override
    public void refreshen() {

        o1.setMaxAnzahl(squad.getModelle() - 1 - o3.getAnzahl());
        o2.setMaxAnzahl(squad.getModelle() - 1 - o3.getAnzahl());
        o3.setMaxAnzahl(squad.getModelle() - 1);

        power = 13;
        if (squad.getModelle() > 5) {
            power = 26;
        }
    }
}

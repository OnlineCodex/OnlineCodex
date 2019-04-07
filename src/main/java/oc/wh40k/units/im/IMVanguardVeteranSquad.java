package oc.wh40k.units.im;

import oc.AnzahlPanel;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsZaehlerGruppe;
import oc.RuestkammerStarter;

public class IMVanguardVeteranSquad extends Eintrag {//Sternguard

	private final AnzahlPanel squad;
	private final OptionsZaehlerGruppe o1, o1x, o1y;
	private final OptionsZaehlerGruppe o2;
	private final OptionsZaehlerGruppe o3;
	private final OptionsEinzelUpgrade jump;

	private final RuestkammerStarter rkBoss;

	public IMVanguardVeteranSquad() {
        name = "Vanguard Veteran Squad\n";
        grundkosten = 0;
        überschriftSetzen = true;

        add(squad = new AnzahlPanel(ID, randAbstand, cnt, "Veterans", 5, 10, getPts("Vanguard Veteran Squad")));

        seperator();
        ogE.addElement(new OptionsGruppeEintrag("Bolt pistol + chainsword", getPts("Bolt pistol (SM)") + getPts("Chainsword (SM)")));
        add(o1x = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, -88));
        ogE.addAll(IMSpaceMarinesPistols.createRK("", "", buildaVater));
        ogE.addAll(IMSpaceMarinesMeleeWeapons.createRK("", "", buildaVater));
        add(o1 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, -88));
        ogE.addElement(new OptionsGruppeEintrag("Storm shield", getPts("Storm shield (others)")));
        add(o1y = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, -88));

        seperator();

        ogE.addAll(IMSpaceMarinesPistols.createRK("", "", buildaVater));
        ogE.addAll(IMSpaceMarinesMeleeWeapons.createRK("", "", buildaVater));
        add(o2 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 2));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("2 Lightning claws", getPts("Lightning claw (pair)")));
        add(o3 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 0));

        seperator();

        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Melta bombs", getPts("Melta bombs")));

        seperator();

        add(jump = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Jump packs", getPts("Vanguard Veteran Squad with Jump Packs") - getPts("Vanguard Veteran Squad")));

        seperator();

        rkBoss = new RuestkammerStarter(ID, randAbstand, cnt, IMSergeant.class, "Sergeant");
        ((IMSergeant) rkBoss.getKammer()).type = "Vanguard Veteran Squad";
        rkBoss.initKammer();
        rkBoss.setAbwaehlbar(false);
        rkBoss.setUeberschriftTrotzNullKostenAusgeben(true);
        add(rkBoss);

        seperator();

        complete();
    }

    @Override
    public void refreshen() {

        if (!rkBoss.isSelected()) rkBoss.setSelected(true);

        o1x.setMaxAnzahl(squad.getModelle() - 1 - (o2.getAnzahl() + 1) / 2 - o1.getAnzahl() - o3.getAnzahl());
        o1x.setAnzahl(0, squad.getModelle() - 1 - (o2.getAnzahl() + 1) / 2 - o1.getAnzahl() - o3.getAnzahl());
        o1y.setMaxAnzahl(o1.getAnzahl());
        o1y.setAnzahl(0, o1.getAnzahl());
        o1.setMaxAnzahl(squad.getModelle() - 1 - (o2.getAnzahl() + 1) / 2 - o3.getAnzahl());

        o2.setMaxAnzahl((squad.getModelle() - 1 - o1.getAnzahl()) * 2 - o3.getAnzahl() * 2);

        o2.setLegal(o2.getAnzahl() % 2 == 0);

        o3.setMaxAnzahl(squad.getModelle() - 1 - (o2.getAnzahl() + 1) / 2 - o1.getAnzahl());

        jump.setModelle(squad.getModelle());

        power = 7;
        if (jump.isSelected()) {
            power += 1;
        }
        if (squad.getModelle() > 5) {
            power += 7;
        }
        if (squad.getModelle() == 10 && jump.isSelected()) {
            power += 1;
        }

    }

}

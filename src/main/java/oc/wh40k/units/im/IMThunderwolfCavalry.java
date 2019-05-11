package oc.wh40k.units.im;

import oc.AnzahlPanel;
import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsZaehlerGruppe;

public class IMThunderwolfCavalry extends Eintrag {

	private final AnzahlPanel squad;
	private final OptionsZaehlerGruppe o1;
	private final OptionsZaehlerGruppe o2;
	private final OptionsZaehlerGruppe wolfsklauen;

    public IMThunderwolfCavalry() {
        name = "Thunderwolf Cavalry\n";
        grundkosten = 0;
        überschriftSetzen = true;

        squad = new AnzahlPanel(ID, randAbstand, cnt, "Thunderwolf Cavalry", 3, 6, getPts("Thunderwolf Cavalry"));
        add(squad);

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Bolt pistol", getPts("Bolt pistol (SM)")));
        ogE.addElement(new OptionsGruppeEintrag("Boltgun", getPts("Boltgun (SM)")));
        ogE.addElement(new OptionsGruppeEintrag("Plasma pistol", getPts("Plasma pistol (SM)")));
        ogE.addAll(IMSpaceWolvesMeleeWeapons.createRK("", "", buildaVater));
        add(o1 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 3));
        o1.setAnzahl(0, 3);

        seperator();

        ogE.addAll(IMSpaceWolvesMeleeWeapons.createRK("", "", buildaVater));
        ogE.addElement(new OptionsGruppeEintrag("Storm shield", getPts("Storm shield (Thunderwolf Cavalry)")));
        add(o2 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 3));
        o2.setAnzahl(0, 3);

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("2 Wolf claws", getPts("Wolf claw (pair)")));
        ogE.addElement(new OptionsGruppeEintrag("2 Lightning claws", getPts("Lightning claw (pair)")));
        add(wolfsklauen = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "option", ogE, 0));

        complete();
    }

    @Override
    public void refreshen() {
        o1.setMaxAnzahl(squad.getModelle() - wolfsklauen.getAnzahl());
        o2.setMaxAnzahl(squad.getModelle()- wolfsklauen.getAnzahl());
        wolfsklauen.setMaxAnzahl(squad.getModelle() - Math.max(o1.getAnzahl(), o2.getAnzahl()));
        o1.setLegal(o1.getAnzahl() == o1.getMaxAnzahl());
        o2.setLegal(o2.getAnzahl() == o2.getMaxAnzahl());
        wolfsklauen.setLegal(wolfsklauen.getAnzahl() == wolfsklauen.getMaxAnzahl());

        power = 8;
        if (squad.getModelle() > 3) {
            power += 8;
        }
    }

}

package oc.wh40k.units.im;

import static oc.KeyWord.ADEPTUS_MINISTORUM;
import static oc.KeyWord.IMPERIUM;
import static oc.KeyWord.PENITENT_ENGINES;
import static oc.KeyWord.VEHICLE;

import oc.AnzahlPanel;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsZaehlerGruppe;

public class IMMortifiers extends Eintrag {

	private final AnzahlPanel squad;
	private final OptionsZaehlerGruppe flails, flamer;

    public IMMortifiers() {
    	super(IMPERIUM, ADEPTUS_MINISTORUM, VEHICLE, PENITENT_ENGINES);
        name = "Mortifiers";
        grundkosten = 0;

        squad = new AnzahlPanel(ID, randAbstand, cnt, "Mortifiers", 1, 6, getPts("Mortifiers"));
        add(squad);

        ogE.addElement(new OptionsGruppeEintrag("Penitent flails", getPts("")));
        ogE.addElement(new OptionsGruppeEintrag("Penitent buzz-blades", getPts("")));
        add(flails = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE));
        flails.setAnzahl(0, 2);
        
        ogE.addElement(new OptionsGruppeEintrag("Heavy bolter", getPts("Heavy bolter (AMI other)")));
        ogE.addElement(new OptionsGruppeEintrag("Heavy flamer", getPts("Heavy flamer (AMI other)")));
        add(flamer = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE));
        flamer.setAnzahl(0, 2);
        
        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Anchorite", getPts("Anchorite")-getPts("Mortifiers")));
        
        complete();
    }

    @Override
    public void refreshen() {
        power = squad.getModelle() * 3;
        flails.setMaxAnzahl(2*squad.getModelle());
        flamer.setMaxAnzahl(2*squad.getModelle());
    }

}

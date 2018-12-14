package oc;

import oc.wh40k.units.Warlordtraits;
import oc.wh40k.units.ch.CHWaffenkammer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.swing.*;
import java.awt.*;
import java.util.StringTokenizer;

import static oc.RefreshListener.Priority.EINTRAG;
import static oc.RefreshListener.addRefreshListener;

public abstract class Eintrag extends OptionsCollection implements BuildaSTK {

	private static final Logger LOGGER = LoggerFactory.getLogger(Eintrag.class);

	protected int kategorie;
	protected double eintragsCNT = 1; // Wieviel dieser Eintrag als Eintrag zählt. Fast alle haben 1 hier stehen, wenn der Eintrag nicht als Eintrag zählt steht hier 0, bei Chaosdämonen HQ'S Heralde 0.5
	protected boolean überschriftSetzen = false; // kann innerhalb der "extends Eintrag" Klasse verändert werden
	protected boolean neuzeile = false; // kann innerhalb der "extends Eintrag" Klasse verändert werden
	protected boolean keineÜberschrift = false; // kann innerhalb der "extends Eintrag" Klasse verändert werden
	protected boolean unikat = false; // kann innerhalb der "extends Eintrag" Klasse verändert werden,
	protected String unikatName;
	protected String auswahl = "Auswahl";
	protected int unikatMin = 0;
	protected int unikatMax = 1;
	protected boolean unikatFehler;
	protected boolean gesamtpunkteImmerAnzeigen = false; //Um bei einigen Einheiten bei der Auswahl von alle Punkte zu verhinern, dass keine Gesamtpunkte angezeigt werden.
	protected boolean ally = false;
	protected int power = 0;
	protected OptionsButtonUpgrade chosenRelic = null;
	protected boolean uniqueError = false;
	private JLabel lKosten = new JLabel("");
	private JLabel legalerEintragLabel = new JLabel();
	private boolean countToMinimum = true;
	private boolean countToMaximum = true;
	private double prozentKosten = 0.0;
	protected RuestkammerStarter warlordTraits;
	private boolean warlordError;
	private boolean warlord = false;
	protected RuestkammerStarter waffen;

	public Eintrag() {
		lKosten.setSize(150, 17);
		panel.add(lKosten);
		kostenLabelAktualisieren();

		legalerEintragLabel.setFont(new Font("arial", Font.BOLD, 12));
		legalerEintragLabel.setAlignmentX(JLabel.CENTER_ALIGNMENT);
		legalerEintragLabel.setForeground(Color.RED);
		legalerEintragLabel.setSize(150, 17);

		panel.add(legalerEintragLabel);
		panel.setBorder(blackBorder);
		panel.setLayout(null);

		unikatName = this.getClass().getName();

		oc.BuildaHQ.addToInformationVectorGlobal(unikatName, 1);
		this.ID = addRefreshListener(EINTRAG, this::refreshEintrag).getId();
	}

	private void refreshEintrag() {
		refreshen();
		uniqueError = false;
		warlordError = false;
		chosenRelic = null;
		warlord = false;
		RuestkammerStarter previousRuestKammer = null;
		boolean warlordChange = false;
		for (int i = 0; i < optionen.size(); ++i) {
			if (optionen.elementAt(i) instanceof OptionsUpgradeGruppe) {
				chosenRelic = ((OptionsUpgradeGruppe) optionen.elementAt(i)).getChosenRelic();
				if (chosenRelic != null) {
					uniqueError = uniqueError || chosenRelic.hasUniqueError();
					break;
				}
			} else if (optionen.elementAt(i) instanceof OptionsEinzelUpgrade) {
				chosenRelic = ((OptionsEinzelUpgrade) optionen.elementAt(i)).getChosenRelic();
				if (chosenRelic != null) {
					uniqueError = uniqueError || chosenRelic.hasUniqueError();
					break;
				}
			} else if (optionen.elementAt(i) instanceof RuestkammerStarter) {
				uniqueError = uniqueError || ((RuestkammerStarter) optionen.elementAt(i)).getKammer().uniqueError;
				if(((RuestkammerStarter) optionen.elementAt(i)).getKammer().warlord && optionen.elementAt(i).isSelected()){
					warlord = true;
					warlordError = BuildaHQ.getCountFromInformationVectorGlobal("Warlord") > 1;
					if(((RuestkammerStarter) optionen.elementAt(i)).getKammer().warlordSelected == false){
						((RuestkammerStarter) optionen.elementAt(i)).getKammer().warlordSelected = true;
				    	BuildaHQ.addToInformationVectorGlobal("Warlord", 1);
				    	warlordChange = true;
					}
				} else if(((RuestkammerStarter) optionen.elementAt(i)).getKammer().warlord && !optionen.elementAt(i).isSelected()) {
					if(((RuestkammerStarter) optionen.elementAt(i)).getKammer().warlordSelected == true){
						((RuestkammerStarter) optionen.elementAt(i)).getKammer().warlordSelected = false;
						BuildaHQ.addToInformationVectorGlobal("Warlord", -1);
				    	warlordChange = true;
					}
				}
				// Korrektur der RuestKammer-Positionen
				if(previousRuestKammer != null) {
					correctRuestkammerPosition((RuestkammerStarter) optionen.elementAt(i), previousRuestKammer);
				}
				previousRuestKammer = (RuestkammerStarter) optionen.elementAt(i);	
			}
		}
		if (chosenRelic == null) {
			for (int i = 0; i < optionen.size(); ++i) {
				if (optionen.elementAt(i) instanceof OptionsUpgradeGruppe) {
					((OptionsUpgradeGruppe) optionen.elementAt(i)).enableRelics();
				} else if (optionen.elementAt(i) instanceof OptionsEinzelUpgrade) {
					((OptionsEinzelUpgrade) optionen.elementAt(i)).enableRelics();
				}
			}
		} else {
			for (int i = 0; i < optionen.size(); ++i) {
				if (optionen.elementAt(i) instanceof OptionsUpgradeGruppe) {
					((OptionsUpgradeGruppe) optionen.elementAt(i)).disableOtherRelics(chosenRelic);
				} else if (optionen.elementAt(i) instanceof OptionsEinzelUpgrade) {
					((OptionsEinzelUpgrade) optionen.elementAt(i)).disableOtherRelics(chosenRelic);
				}
			}
		}

		if (warlordError) {
			setFehlermeldung("Max. 1 Warlord");
		} else if (uniqueError) {
			setFehlermeldung("Doppeltes Relikt");
		} else {
			if(getFehlermeldung().equals("Max. 1 Warlord") || getFehlermeldung().equals("Doppeltes Relikt")){
				setFehlermeldung("");
			}
			setFehlermeldung(getFehlermeldung());
		}

		if (unikat && BuildaHQ.getCountFromInformationVectorGlobal(unikatName) > unikatMax) {
			setFehlermeldung((unikatMin == unikatMax ? unikatMin : unikatMin + "-" + unikatMax) + " " + auswahl, true);
		} else {
			setFehlermeldung(getFehlermeldung());
		}

		kostenLabelAktualisieren();
		panel.setSize(getBreite(), getHöhe());
		lKosten.setLocation(278, getHöhe() - 20);
		legalerEintragLabel.setLocation(278, getHöhe() - 40);
		
		if(warlordChange == true) {
			RefreshListener.fireRefresh();
		}
	}

	public void setBuildaVater(BuildaVater buildaVater) {
		LOGGER.info("setBuildaVater " + (buildaVater == null));
		this.buildaVater = buildaVater;
	}

	private void checkUnikatErrorMessageState() {
		String fehlerBuffer = unikatFehler ? "" : getFehlermeldung();

		if (isUnikat()) {
			if (unikat && oc.BuildaHQ.getCountFromInformationVectorGlobal(unikatName) > unikatMax) {
				setFehlermeldung((unikatMin == unikatMax ? unikatMin : unikatMin + "-" + unikatMax) + " " + auswahl, true);
			} else {
				setFehlermeldung(fehlerBuffer);
			}
		}
	}

	public int getPower() {
		return power;
	}

	/**
	 * minimal null, maximal unikatMax solcher Auswahl, sonst Fehlermeldung, wenn unikat = true
	 */
	public void setUnikat(boolean unikat, int unikatMax) {
		checkUnikatErrorMessageState();
		this.unikat = unikat;
		this.unikatMax = unikatMax;
	}

	/**
	 * minimal null, maximal unikatMax solcher Auswahl, sonst Fehlermeldung, wenn unikat = true
	 */
	public void setUnikat(boolean unikat, int unikatMax, String auswahl) {
		checkUnikatErrorMessageState();
		this.unikat = unikat;
		this.unikatMax = unikatMax;
		this.auswahl = auswahl;
	}

	/**
	 * minimal unikatMin, maximal unikatMax solcher Auswahl, sonst Fehlermeldung, wenn unikat = true
	 */
	public void setUnikat(boolean unikat, int unikatMin, int unikatMax) {
		checkUnikatErrorMessageState();
		this.unikat = unikat;
		this.unikatMin = unikatMin;
		this.unikatMax = unikatMax;
	}

	/**
	 * minimal unikatMin, maximal unikatMax solcher Auswahl, sonst Fehlermeldung, wenn unikat = true
	 */
	public void setUnikat(boolean unikat, int unikatMin, int unikatMax, String auswahl) {
		checkUnikatErrorMessageState();
		this.unikat = unikat;
		this.unikatMin = unikatMin;
		this.unikatMax = unikatMax;
		this.auswahl = auswahl;
	}

	public void setUnikatName(String unikatName) {
		BuildaHQ.addToInformationVectorGlobal(unikatName, BuildaHQ.getCountFromInformationVectorGlobal(this.unikatName));
		this.unikatName = unikatName;
	}

	public boolean isUnikat() {
		return this.unikat;
	}

	/**
	 * minimal null, maximal eine solche Auswahl, sonst Fehlermeldung, wenn unikat = true
	 */
	public void setUnikat(boolean unikat) {
		checkUnikatErrorMessageState();
		this.unikat = unikat;
	}

	public boolean isCountToMinimum() {
		return this.countToMinimum;
	}

	public void setCountToMinimum(boolean state) {
		this.countToMinimum = state;
	}

	public boolean isCountToMaximum() {
		return this.countToMaximum;
	}

	public void setCountToMaximum(boolean state) {
		this.countToMaximum = state;
	}

	public int getKategorie() {
		return this.kategorie;
	}

	public void setKategorie(int i) {
		kategorie = i;
	}

	@Override
	public JPanel getPanel() {
		return this.panel;
	}

	public double getEintragsCNT() {
		return eintragsCNT;
	}

	protected void setEintragsCNT(double eintragsCNT) {
		this.eintragsCNT = eintragsCNT;
	}

	public void setKostenLabelVisible(boolean b) {
		lKosten.setVisible(b);
	}

	public void setFehlermeldung(String meldung, boolean unikatFehler) {
		legalerEintragLabel.setText(meldung);
		this.unikatFehler = unikatFehler;
	}

	public String getFehlermeldung() {
		return legalerEintragLabel.getText();
	}

	public void setFehlermeldung(String meldung) {
		setFehlermeldung(meldung, false);
	}

	@Override
	public String getText() {  // der Text, der in der Textarea als Armeeliste angezeigt wird, wird immer in  getText()  Methoden generiert.
		if (this instanceof LeererEintrag) return "";

		String titel = "";
		int cnt = 0;

		if (grundkosten != 0 && !keineÜberschrift) {
			String kosten = "";
			if (BuildaHQ.allePunktkosten) {
				kosten = punkteAbstandHalter + entferneNullNachkomma(grundkosten) + " " + BuildaHQ.translate("Punkte");
			}
			titel = BuildaHQ.formatierFett(name + kosten + (neuzeile ? "\n" : ""));
			++cnt;
		} else if (überschriftSetzen) {
			titel = BuildaHQ.formatierItalic(BuildaHQ.formatierFett(name));
		}

		if(warlord){
			titel += " [WARLORD]";
		}

		StringBuilder text = new StringBuilder(titel);

		for (int i = 0; i < optionen.size(); ++i) {
			if (optionen.elementAt(i).isSelected()) {
				text.append(optionen.elementAt(i).getText());
				++cnt;
			}
		}

		//Bei alle Punktkosten: hier wird bei kostenlosen Einträgen, bei denen nur die erste Option gewählt ist, welche selbst aber noch Kosten und weitere eigene Optionen hat, die Gesamtpunktzahl nicht angezeigt. Deswegen: "gesamtpunkteImmerAnzeigen" hinzugefügt.
		if (this.getKosten() != 0 && (cnt > 1 || !BuildaHQ.allePunktkosten || (optionen.size() > 0 ? optionen.elementAt(0).getKosten() != this.getKosten() : false) || gesamtpunkteImmerAnzeigen)) {
			text.append(" " + BuildaHQ.formatierItalic(" - - - > " + entferneNullNachkomma(getKosten()) + " " + BuildaHQ.translate("Punkte") + " (PL " + getPower()+ ")"));
		}

		// ACHTUNG BEI KOSTENLOSEN EINTRÄGEN, die trotzdem angezeigt werden sollen!
		text.append(ZEILENUMBRUCH);
		text.append(ZEILENUMBRUCH);

		String s = text.toString();

		if (s.indexOf(BuildaHQ.abstand) == 0) {
			s = s.substring(BuildaHQ.abstand.length(), s.length());
		}

		return s;
	}

	public void kostenLabelAktualisieren() {
		lKosten.setText((BuildaHQ.getSprache() == Sprache.English ? "    " : "") + BuildaHQ.translate("Insgesamt") + " " + entferneNullNachkomma(getKosten()) + " " + BuildaHQ.translate("Punkte"));
	}

	public void refreshen() {}

	@Override
	public int getBreite() {
		return auswahlBreite + randAbstand;
	}

	@Override
	public int getHöhe() {
		return super.getHöhe() > 60 ? super.getHöhe() : 60;
	}

	public void complete() {
		panel.setSize(getBreite(), getHöhe());
		lKosten.setLocation(278, getHöhe() - 20);
		refreshen();
		kostenLabelAktualisieren();
	}

	public void deleteYourself() {
		LOGGER.info("Eintrag-deleteyourself");
		BuildaHQ.addToInformationVectorGlobal(unikatName, -1);

		for (int i = 0; i < optionen.size(); ++i) {
			if (optionen.elementAt(i) instanceof RuestkammerStarter) {
				RuestkammerStarter rk = ((RuestkammerStarter) optionen.elementAt(i));

				if (!(rk.getKammer().toString().indexOf("MagicItems") == -1) || !(rk.getKammer().toString().indexOf("Banner") == -1) || !(rk.getKammer().toString().indexOf("Gabe") == -1)
						|| !(rk.getKammer().toString().indexOf("GiftsOf") == -1) || !(rk.getKammer().toString().indexOf("Spites") == -1) || !(rk.getKammer().toString().indexOf("Assassin") == -1)) {

					String text = "";
					if (rk.getKammer().getText().length() > 2) {
						text = rk.getKammer().getText().substring(1, rk.getKammer().getText().length());
					}
					text = text.replaceAll("\n- ", "-");
					StringTokenizer tokenizer = new StringTokenizer(text, ",");
					while (tokenizer.hasMoreElements()) {
						String tok = BuildaHQ.translate(tokenizer.nextToken().trim());

						if (BuildaHQ.Items != null && BuildaHQ.Items.contains(tok)) {
							BuildaHQ.Items.remove(tok);
						}
					}
				}
				
				if(optionen.elementAt(i).isSelected() && ((RuestkammerStarter) optionen.elementAt(i)).getKammer().warlordSelected == true) {
					((RuestkammerStarter) optionen.elementAt(i)).getKammer().warlordSelected = false;
					BuildaHQ.addToInformationVectorGlobal("Warlord", -1);
				}
				
				BuildaHQ.addToInformationVectorGlobal(unikatName, -1);
				LOGGER.info("RuestkammerStarter-rk-deleteyourself");
				rk.deleteYourself();
			} else if (optionen.elementAt(i) instanceof OptionsUpgradeGruppe) {
				((OptionsUpgradeGruppe) optionen.elementAt(i)).deleteYourself();
			} else if (optionen.elementAt(i) instanceof OptionsEinzelUpgrade) {
				((OptionsEinzelUpgrade) optionen.elementAt(i)).deleteYourself();
			}
		}
	}

	public double getProzentKosten() {
		return prozentKosten;
	}

	public void setProzentKosten(double prozentKosten) {
		this.prozentKosten = prozentKosten;
	}

	public boolean hasSpecialValue(String key) {
		return false;
	}

	public void setInformationVectorValue(String s, int value) {
		checkBuildaVater().setInformationVectorValue(s, value);
	}
	
	public void addWarlordTraits(String mandatoryChoice, boolean subfactionsAllowed) {
		warlordTraits = new RuestkammerStarter(ID, randAbstand, cnt, Warlordtraits.class, "Warlordtrait: ");
		warlordTraits.initKammer();
		warlordTraits.setUeberschriftTrotzNullKostenAusgeben(true);
		warlordTraits.setButtonText("Warlord");
		if(!"".equals(mandatoryChoice)) {
			((Warlordtraits)warlordTraits.getKammer()).setMandatoryChoice(mandatoryChoice);
		}
        add(warlordTraits);
	}
	
	public void addWarlordTraits(String mandatoryChoice, boolean subfactionsAllowed, String exclusiveKeyword) {
		warlordTraits = new RuestkammerStarter(ID, randAbstand, cnt, Warlordtraits.class, "Warlordtrait: ");
		warlordTraits.initKammer();
		warlordTraits.setUeberschriftTrotzNullKostenAusgeben(true);
		warlordTraits.setButtonText("Warlord");
		if(!mandatoryChoice.equals("")) {
			((Warlordtraits)warlordTraits.getKammer()).setMandatoryChoice(mandatoryChoice);
		}
		((Warlordtraits)warlordTraits.getKammer()).setExclusiveKeyword(exclusiveKeyword);
        add(warlordTraits);
	}
	
	public void addWaffen(Class<? extends RuestkammerVater> cls, boolean mandatoryChoice) {
		waffen = new RuestkammerStarter(ID, randAbstand, cnt, cls, "");
        waffen.initKammer();
        waffen.setButtonText("Waffen");
        add(waffen);
        waffen.setAbwaehlbar(!mandatoryChoice);
	}
	
	public void addWaffen(Class<? extends RuestkammerVater> cls, boolean mandatoryChoice, String defaultFK, String defaultNK) {
		waffen = new RuestkammerStarter(ID, randAbstand, cnt, cls, "");
        waffen.getKammer().setDefaultFK(defaultFK);
        waffen.getKammer().setDefaultNK(defaultNK);
        waffen.initKammer();
        waffen.setButtonText("Waffen");
        add(waffen);
        waffen.setAbwaehlbar(!mandatoryChoice);
	}
	
	public void correctRuestkammerPosition(RuestkammerStarter ruestkammer, RuestkammerStarter reference){
		ruestkammer.getPanel().setLocation(
                (int) ruestkammer.getPanel().getLocation().getX(),
                (int) reference.getPanel().getLocation().getY() + reference.getPanel().getSize().height + 5
        );
	}
}
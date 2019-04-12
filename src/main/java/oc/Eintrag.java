package oc;

import static oc.RefreshListener.addRefreshListener;
import static oc.RefreshListener.Priority.EINTRAG;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.util.Set;
import java.util.StringTokenizer;

import javax.swing.JLabel;
import javax.swing.JPanel;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Sets;

import oc.wh40k.units.Warlordtraits;

public abstract class Eintrag extends OptionsCollection implements BuildaSTK {

	private static final Logger LOGGER = LoggerFactory.getLogger(Eintrag.class);

	protected int category;
	protected double eintragsCNT = 1; // Wieviel dieser Eintrag als Eintrag zählt. Fast alle haben 1 hier stehen, wenn der Eintrag nicht als Eintrag zählt steht hier 0, bei Chaosdämonen HQ'S Heralde 0.5
	protected boolean applyTitle = false; // kann innerhalb der "extends Eintrag" Klasse verändert werden
	private boolean unique = false; // kann innerhalb der "extends Eintrag" Klasse verändert werden,
	private String uniqueKey;
	private String auswahl = "Auswahl";
	private int unikatMin = 0;
	private int unikatMax = 1;
	private boolean unikatFehler;
	protected int power = 0;
	protected OptionsButtonUpgrade chosenRelic = null;
	private final JLabel lKosten = new JLabel("");
	private final JLabel legalerEintragLabel = new JLabel();
	protected RuestkammerStarter warlordTraits;
    private boolean warlord = false;
	protected RuestkammerStarter weapons;
	private final Set<KeyWord> keywords;

	public Eintrag(KeyWord... keywords) {
		this.keywords = Sets.newEnumSet(ImmutableList.copyOf(keywords), KeyWord.class);
		lKosten.setSize(150, 17);
		panel.add(lKosten);
		kostenLabelAktualisieren();

		legalerEintragLabel.setFont(new Font("arial", Font.BOLD, 12));
		legalerEintragLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
		legalerEintragLabel.setForeground(Color.RED);
		legalerEintragLabel.setSize(150, 17);

		panel.add(legalerEintragLabel);
		panel.setBorder(blackBorder);
		panel.setLayout(null);

		uniqueKey = this.getClass().getName();

		oc.BuildaHQ.addToInformationVectorGlobal(uniqueKey, 1);
		this.ID = addRefreshListener(EINTRAG, this::refreshEintrag).getId();
	}

	private void refreshEintrag() {
		refreshen();
		boolean uniqueError = false;
        boolean warlordError = false;
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
					if(!((RuestkammerStarter) optionen.elementAt(i)).getKammer().warlordSelected){
						((RuestkammerStarter) optionen.elementAt(i)).getKammer().warlordSelected = true;
				    	BuildaHQ.addToInformationVectorGlobal("Warlord", 1);
				    	warlordChange = true;
					}
				} else if(((RuestkammerStarter) optionen.elementAt(i)).getKammer().warlord && !optionen.elementAt(i).isSelected()) {
					if(((RuestkammerStarter) optionen.elementAt(i)).getKammer().warlordSelected){
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

		if (unique && BuildaHQ.getCountFromInformationVectorGlobal(uniqueKey) > unikatMax) {
			setFehlermeldung((unikatMin == unikatMax ? unikatMin : unikatMin + "-" + unikatMax) + " " + auswahl, true);
		} else {
			setFehlermeldung(getFehlermeldung());
		}

		kostenLabelAktualisieren();
		panel.setSize(getBreite(), getHeight());
		lKosten.setLocation(278, getHeight() - 20);
		legalerEintragLabel.setLocation(278, getHeight() - 40);

		if(warlordChange) {
			RefreshListener.fireRefresh();
		}


	}

	public void setBuildaVater(BuildaVater buildaVater) {
		LOGGER.info("setBuildaVater " + (buildaVater == null));
		this.buildaVater = buildaVater;
	}

	private void checkUnikatErrorMessageState() {
		final String fehlerBuffer = unikatFehler ? "" : getFehlermeldung();

		if (isUnique()) {
			if (unique && oc.BuildaHQ.getCountFromInformationVectorGlobal(uniqueKey) > unikatMax) {
				setFehlermeldung((unikatMin == unikatMax ? unikatMin : unikatMin + "-" + unikatMax) + " " + auswahl, true);
			} else {
				setFehlermeldung(fehlerBuffer);
			}
		}
	}

	public int getPower() {
		return power;
	}

	private boolean isUnique() {
		return this.unique;
	}

	/**
	 * minimal null, maximal eine solche Auswahl, sonst Fehlermeldung, wenn unique = true
	 */
	public void setUnique(boolean unique) {
		checkUnikatErrorMessageState();
		this.unique = unique;
	}

    public int getCategory() {
		return this.category;
	}

	public void setCategory(int i) {
		category = i;
	}

	@Override
	public JPanel getPanel() {
		return this.panel;
	}

	double getEintragsCNT() {
		return eintragsCNT;
	}

	protected void setEintragsCNT(double eintragsCNT) {
		this.eintragsCNT = eintragsCNT;
	}

	void setKostenLabelVisible() {
		lKosten.setVisible(false);
	}

	public void setFehlermeldung(String meldung, boolean unikatFehler) {
		legalerEintragLabel.setText(meldung);
		this.unikatFehler = unikatFehler;
	}

	private String getFehlermeldung() {
		return legalerEintragLabel.getText();
	}

	public void setFehlermeldung(String meldung) {
		setFehlermeldung(meldung, false);
	}

	@Override
	public String getSaveText(String trenner) {
		return super.getSaveText(trenner);
	}

	@Override
	public String getText() {  // der Text, der in der Textarea als Armeeliste angezeigt wird, wird immer in  getText()  Methoden generiert.
		if (this instanceof LeererEintrag) return "";

		String titel = "";
		int cnt = 0;

		// kann innerhalb der "extends Eintrag" Klasse verändert werden
		if (grundkosten != 0) {
			String kosten = "";
			if (BuildaHQ.allePunktkosten) {
				kosten = punkteAbstandHalter + ((int) grundkosten) + " " + BuildaHQ.translate("Punkte");
			}
			// kann innerhalb der "extends Eintrag" Klasse verändert werden
			titel = BuildaHQ.formatierFett(name + kosten);
			++cnt;
		} else if (applyTitle) {
			titel = BuildaHQ.formatierItalic(BuildaHQ.formatierFett(name));
		}

		if(warlord){
			titel += " [WARLORD]";
		}

		final StringBuilder text = new StringBuilder(titel);

		for (int i = 0; i < optionen.size(); ++i) {
			if (optionen.elementAt(i).isSelected()) {
				text.append(optionen.elementAt(i).getText());
				++cnt;
			}
		}

		//Bei alle Punktkosten: hier wird bei kostenlosen Einträgen, bei denen nur die erste Option gewählt ist, welche selbst aber noch Kosten und weitere eigene Optionen hat, die Gesamtpunktzahl nicht angezeigt. Deswegen: "gesamtpunkteImmerAnzeigen" hinzugefügt.
		//Um bei einigen Einheiten bei der Auswahl von alle Punkte zu verhinern, dass keine Gesamtpunkte angezeigt werden.
		if (this.getCost() != 0 && (cnt > 1 || !BuildaHQ.allePunktkosten || optionen.size() > 0 && optionen.elementAt(0).getCost() != this.getCost())) {
			text.append(" ").append(BuildaHQ.formatierItalic(" - - - > " + ((int) getCost()) + " " + BuildaHQ.translate("Punkte") + " (PL " + getPower() + ")"));
		}

		// ACHTUNG BEI KOSTENLOSEN EINTRÄGEN, die trotzdem angezeigt werden sollen!
		text.append(ZEILENUMBRUCH);
		text.append(ZEILENUMBRUCH);

		String s = text.toString();

		if (s.indexOf(BuildaHQ.abstand) == 0) {
			s = s.substring(BuildaHQ.abstand.length());
		}

		return s;
	}

	private void kostenLabelAktualisieren() {
		lKosten.setText((BuildaHQ.getSprache() == Sprache.English ? "    " : "") + BuildaHQ.translate("Insgesamt") + " " + ((int) getCost()) + " " + BuildaHQ.translate("Punkte"));
	}

	public void refreshen() {}

	@Override
	public int getBreite() {
		return auswahlBreite + randAbstand;
	}

	@Override
	public int getHeight() {
		return super.getHeight() > 60 ? super.getHeight() : 60;
	}

	public void complete() {
		panel.setSize(getBreite(), getHeight());
		lKosten.setLocation(278, getHeight() - 20);
		refreshen();
		kostenLabelAktualisieren();
	}

	public void deleteYourself() {
		LOGGER.info("Eintrag-deleteyourself");
		BuildaHQ.addToInformationVectorGlobal(uniqueKey, -1);

		for (int i = 0; i < optionen.size(); ++i) {
			if (optionen.elementAt(i) instanceof RuestkammerStarter) {
				final RuestkammerStarter rk = ((RuestkammerStarter) optionen.elementAt(i));

				if (rk.getKammer().toString().contains("MagicItems") || rk.getKammer().toString().contains("Banner") || rk.getKammer().toString().contains("Gabe")
						|| rk.getKammer().toString().contains("GiftsOf") || rk.getKammer().toString().contains("Spites") || rk.getKammer().toString().contains("Assassin")) {

					String text = "";
					if (rk.getKammer().getText().length() > 2) {
						text = rk.getKammer().getText().substring(1);
					}
					text = text.replaceAll("\n- ", "-");
					final StringTokenizer tokenizer = new StringTokenizer(text, ",");
					while (tokenizer.hasMoreElements()) {
						final String tok = BuildaHQ.translate(tokenizer.nextToken().trim());

						if (BuildaHQ.Items != null) {
							BuildaHQ.Items.remove(tok);
						}
					}
				}

				if(optionen.elementAt(i).isSelected() && ((RuestkammerStarter) optionen.elementAt(i)).getKammer().warlordSelected) {
					((RuestkammerStarter) optionen.elementAt(i)).getKammer().warlordSelected = false;
					BuildaHQ.addToInformationVectorGlobal("Warlord", -1);
				}

				BuildaHQ.addToInformationVectorGlobal(uniqueKey, -1);
				LOGGER.info("RuestkammerStarter-rk-deleteyourself");
				rk.deleteYourself();
			} else if (optionen.elementAt(i) instanceof OptionsUpgradeGruppe) {
				((OptionsUpgradeGruppe) optionen.elementAt(i)).deleteYourself();
			} else if (optionen.elementAt(i) instanceof OptionsEinzelUpgrade) {
				((OptionsEinzelUpgrade) optionen.elementAt(i)).deleteYourself();
			}
		}
	}

    public void setInformationVectorValue(String s, int value) {
		checkBuildaVater().setInformationVectorValue(s, value);
	}

	public void addWarlordTraits(String mandatoryChoice) {
		warlordTraits = new RuestkammerStarter(ID, randAbstand, cnt, Warlordtraits.class, "Warlordtrait: ", keywords);
		warlordTraits.initKammer();
		warlordTraits.setUeberschriftTrotzNullKostenAusgeben(true);
		warlordTraits.setButtonText("Warlord");
		if(!"".equals(mandatoryChoice)) {
			((Warlordtraits)warlordTraits.getKammer()).setMandatoryChoice(mandatoryChoice);
		}
        add(warlordTraits);
	}

	public void addWarlordTraits(String mandatoryChoice, KeyWord exclusiveKeyword) {
		warlordTraits = new RuestkammerStarter(ID, randAbstand, cnt, Warlordtraits.class, "Warlordtrait: ", keywords);
		warlordTraits.initKammer();
		warlordTraits.setUeberschriftTrotzNullKostenAusgeben(true);
		warlordTraits.setButtonText("Warlord");
		if(!mandatoryChoice.equals("")) {
			((Warlordtraits)warlordTraits.getKammer()).setMandatoryChoice(mandatoryChoice);
		}
		((Warlordtraits)warlordTraits.getKammer()).setExclusiveKeyword(exclusiveKeyword);
        add(warlordTraits);
	}

	public void addWeapons(Class<? extends RuestkammerVater> cls, boolean mandatoryChoice) {
		weapons = new RuestkammerStarter(ID, randAbstand, cnt, cls, "", keywords);
        weapons.getKammer().setType(name);
        weapons.initKammer();
        weapons.setButtonText("Waffen und Relikte");
        add(weapons);
        weapons.setAbwaehlbar(!mandatoryChoice);
	}

	public void addWeapons(Class<? extends RuestkammerVater> cls, boolean mandatoryChoice, String defaultFK, String defaultNK) {
		weapons = new RuestkammerStarter(ID, randAbstand, cnt, cls, "", keywords);
        weapons.getKammer().setType(name);
        weapons.getKammer().setDefaultRanged(defaultFK);
        weapons.getKammer().setDefaultCloceCombat(defaultNK);
        weapons.initKammer();
        weapons.setButtonText("Waffen");
        add(weapons);
        weapons.setAbwaehlbar(!mandatoryChoice);
	}

	public RuestkammerVater getWeapons() {
		return weapons.getKammer();
	}

	public RuestkammerVater getWarlordtraits() {
		return warlordTraits.getKammer();
	}
	
	private void correctRuestkammerPosition(RuestkammerStarter ruestkammer, RuestkammerStarter reference){
		ruestkammer.getPanel().setLocation(
                (int) ruestkammer.getPanel().getLocation().getX(),
                (int) reference.getPanel().getLocation().getY() + reference.getPanel().getSize().height + 5
        );
	}

	public Set<KeyWord> getKeywords() {
		return keywords;
	}

	protected void addKeyword(KeyWord k) {
		keywords.add(k);
	}

	protected void removeKeyword(KeyWord k) {
		keywords.remove(k);
	}

	public RuestkammerStarter createTroopChampion(Class<? extends RuestkammerVater> cls, boolean mandatoryChoice, String btnText, String type){
		final RuestkammerStarter rk = new RuestkammerStarter(ID, randAbstand, cnt, cls, btnText, keywords);
		rk.getKammer().setType(type);
        rk.initKammer();
        rk.setAbwaehlbar(!mandatoryChoice);

        return rk;
	}
}